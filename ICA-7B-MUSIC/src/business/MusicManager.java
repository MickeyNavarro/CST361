package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import beans.Album;
import beans.Track;
import data.DataAccessInterface;
import data.MusicDataService;
import util.AlbumNotFoundException;
import util.TracksNotFoundException;

@Stateless
@Local(MusicManagerInterface.class)
@LocalBean
public class MusicManager implements MusicManagerInterface {

	@EJB
	DataAccessInterface<Album> dao; 
	
	@Inject
	TrackFinderInterface tf;
	
	@EJB 
	Cache cache; 
	
	public MusicManager() {}

	
	@Override
	public Album addAlbum(Album album) throws TracksNotFoundException {
		album.setTracks(tf.getTracks(album));
		
		if(album.getNumberTracks() == 0)
			throw new TracksNotFoundException();
		
		
		dao.create(album); 
		Album album2 = dao.findBy(album);
		
		if(album2 == null) {
			System.out.println("--------Album does not exist---------");
			dao.create(album);
			album = dao.findBy(album);
			
		}else {
			System.out.println("-------Album exists----------");
		}
		
		return album;
	}
	

	@Override
	public Album getAlbum(Album album) throws AlbumNotFoundException{
		
		//get the album from cache
		Album albumFound = cache.getObject(album); 
		
		//if album is found in cache, return album found
		if(albumFound != null) {
			return albumFound; 
		}
		//if album not found in cache, use the db to get album
		albumFound = dao.findBy(album);
		
		//if album not found in db, throw new exception
		if(albumFound == null) {
			throw new AlbumNotFoundException();
		}
		
		//if album found in db, add to cache & return album found
		else {
			cache.putObject(albumFound);
			return albumFound;
		}

	}
}

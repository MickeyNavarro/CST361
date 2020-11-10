package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptors;

import beans.Album;
import beans.Track;
import util.LoggingInterceptor;

@Stateless
@Local(TrackFinderInterface.class)
@LocalBean
@Alternative
@Interceptors(LoggingInterceptor.class) 
public class TrackFinder1 implements TrackFinderInterface {

	HashMap<String, List<Track>> trackInfo;
	
	public TrackFinder1 () {
	trackInfo = new HashMap<String, List<Track>>();
		List<Track> listOfTracks = new ArrayList<Track>();
		
		listOfTracks.add(new Track("Soaked", 1)); 
		listOfTracks.add(new Track("Glitter", 2)); 
		listOfTracks.add(new Track("Wishful Thinking",3)); 
		
		trackInfo.put("FIRE ON MARZZ by BENEE (2019)", listOfTracks);
		 
	
	}
	
	@Override
	public List<Track> getTracks(Album album) {
		String key = album.getTitle() + " by " + album.getArtist() + " (" + album.getYear() + ")";

		if(trackInfo.containsKey(key))
		{
			return trackInfo.get(key);
		}
		else
		{
			return new ArrayList<Track>();
		}
	}

}

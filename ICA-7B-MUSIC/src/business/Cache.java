package business;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import beans.Album;

@Startup
@Singleton
public class Cache {
	
	//Class scoped variable named cache of type HashMap<String, Album> to the Cache class  
	private HashMap<String, Album> cache;
	
	
	//Public method void to initializes the cache class member variable with an empty HashMap
	@PostConstruct
	public void init() {
		cache = new HashMap<String, Album>();
	}
	
	//Public method to return an Album from the internal cache
	public Album getObject(Album album)
	{
		String key = album.getTitle() + " - " + album.getArtist() + " - " + album.getYear();
		if(cache.containsKey(key))
		{
			System.out.println("Cache contains key:  " + key);
			return cache.get(key);
		}
		else
		{
			System.out.println("Cache does not contain key: " + key);
			return null;
		}
	}
	
	//Public method void to populate the internal cache based on the provided album
	public void putObject(Album album)
	{
		String key = album.getTitle() + " - " + album.getArtist() + " - " + album.getYear();
		cache.put(key, album);
		System.out.println("Cache populated with key: " + key);
	}
}

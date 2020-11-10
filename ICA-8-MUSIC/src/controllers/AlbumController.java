package controllers;

import java.io.Serializable;

import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.interceptor.Interceptors;

import beans.Album;
import business.MusicManager;
import business.MusicManagerInterface;
import util.AlbumNotFoundException;
import util.LoggingInterceptor;
import util.TracksNotFoundException;

//@ManagedBean 
@Named
@ViewScoped
@Interceptors(LoggingInterceptor.class)
public class AlbumController implements Serializable {	
	
	//inject an instance of the MusicManagerInterface
	@EJB
	MusicManagerInterface mgr;
	
	//method to returns the name of the response view 
	public String onSubmit(Album album) {
		
		try { 
			album = mgr.addAlbum(album);
		}
		catch (TracksNotFoundException e){ 
			System.out.println("EXCEPTION: Tracks Not Found");
		}
		
		//Forward to Test Response View along with the User Managed Bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("album", album);
		return "AddAlbumResponse.xhtml";
	}
	
	//method to return 
	public String onFind(Album album) { 
		
		try { 
			mgr.getAlbum(album); 
		}
		catch (AlbumNotFoundException e) { 
			System.out.println("EXCEPTION: Album Not Found");
		}
		
		//Forward to Test Response View along with the User Managed Bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("album", album);
		return "FindAlbumResponse.xhtml";
	}
}

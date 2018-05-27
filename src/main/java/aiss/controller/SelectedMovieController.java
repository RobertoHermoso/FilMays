package aiss.controller;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Movie;
import aiss.model.MovieSearch;
import aiss.model.Spotify.SpotifyTrack;
import aiss.model.Spotify.U.*;
import aiss.model.Spotify.PL.PlayListsUser;
import aiss.model.aliexpress.AliExpress;
import aiss.model.resources.AliExpressResource;
import aiss.model.resources.SpotifyResource;
import aiss.model.resources.TMDBResource;
import aiss.model.resources.Youtuberesource;
import aiss.model.youtube.VideoSearch;



public class SelectedMovieController  extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	private static final Logger log = Logger.getLogger(SelectedMovieController.class.getName());
	
	   public SelectedMovieController() {
	        super();
	    }
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String query = request.getParameter("searchQuery");
		String id = request.getParameter("id");
		RequestDispatcher rd = null;
		
		
		//Search for songs in Spotify
		log.log(Level.FINE, "Searching for Spotify traks that contain " + query);
		String accessToken=(String)request.getSession().getAttribute("Spotify-token");
		SpotifyResource sr=new SpotifyResource(accessToken);
		SpotifyTrack SP=sr.getSearch(query);
		User u = sr.getCurrentlyUser();
		PlayListsUser pl = sr.getPlayListUser();
		
		
		// Search for movie in TMDB
		log.log(Level.FINE, "Searching for TMDB movies that contain " + id);
		TMDBResource tmdb = new TMDBResource();
		Movie tmdbResults = tmdb.getMovie(id);
		
		// Search for videos in Youtube
		log.log(Level.FINE, "Searching for Youtube videos that contain " + query);
		Youtuberesource ytr = new Youtuberesource();
		VideoSearch ytResults = ytr.getVideo(query);
		
		// Search for products in Aliexpress
		log.log(Level.FINE,"Buscado productos de AliExpress que contengan " + query);
		AliExpressResource ali = new AliExpressResource();
		AliExpress aliResults = ali.getProducts(query);
			
		if (tmdbResults!=null && ytResults!=null && aliResults!=null && accessToken!=null && !"".equals(accessToken)
				&& SP!=null && u !=null && pl !=null){
			request.setAttribute("Tracks", SP);
			request.setAttribute("movies", tmdbResults);	
			request.setAttribute("items", ytResults.getItems());	
			request.setAttribute("products", aliResults.getResult().getProducts());
			request.setAttribute("User", u);
			request.setAttribute("pl", pl);

			
			rd = request.getRequestDispatcher("/success.jsp");
			
			
		} else {
			if(accessToken==null || "".equals(accessToken) || SP==null || u==null || pl==null) {
				log.info("Trying to acces to Spotify without an acces token, redirecting to OAuth servlet");
				request.getRequestDispatcher("/AuthController/Spotify");
			}
			if(tmdbResults==null) {
			log.log(Level.SEVERE, "TMDB object: " + tmdbResults);
			rd = request.getRequestDispatcher("/error.jsp");}
			if(ytResults==null) {
			log.log(Level.SEVERE, "YT object: " + ytResults);
			rd = request.getRequestDispatcher("/error.jsp");}
			if(aliResults==null) {
			log.log(Level.SEVERE, " AliExpress object: " + aliResults);
			rd = request.getRequestDispatcher("/error.jsp");}
			}
		
		
	
	   
		rd.forward(request, response);
	   }
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
	 
}

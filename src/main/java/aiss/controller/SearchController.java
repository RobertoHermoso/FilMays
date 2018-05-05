package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.MovieSearch;
import aiss.model.Spotify.SpotifyTrack;
import aiss.model.aliexpress.AliExpress;
import aiss.model.resources.AliExpressResource;
import aiss.model.resources.SpotifyResource;
import aiss.model.resources.TMDBResource;
import aiss.model.resources.Youtuberesource;
import aiss.model.youtube.VideoSearch;



public class SearchController  extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
	
	   public SearchController() {
	        super();
	    }
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		// Search for movies in TMDB
		log.log(Level.FINE, "Searching for TMDB movies that contain " + query);
		TMDBResource tmdb = new TMDBResource();
		MovieSearch tmdbResults = tmdb.getMovies(query);
		
		// Search for videos in Youtube
		log.log(Level.FINE, "Searching for Youtube videos that contain " + query);
		Youtuberesource ytr = new Youtuberesource();
		VideoSearch ytResults = ytr.getVideo(query);
		
		// Search for products in Aliexpress
		log.log(Level.FINE,"Buscado productos de AliExpress que contengan " + query);
		AliExpressResource ali = new AliExpressResource();
		AliExpress aliResults = ali.getProducts(query);
				
		if (tmdbResults!=null || ytResults!=null || aliResults!=null){
			request.setAttribute("movies", tmdbResults.getResults());	
			request.setAttribute("items", ytResults.getItems());	
			request.setAttribute("products", aliResults.getResult().getProducts());
			rd = request.getRequestDispatcher("/success.jsp");
			
		} else {
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

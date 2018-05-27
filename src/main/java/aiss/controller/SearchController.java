package aiss.controller;

import java.io.IOException;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restlet.engine.header.TokenReader;

import aiss.model.Movie;
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
		
		TMDBResource tmdb = new TMDBResource();
		MovieSearch tmdbResults = tmdb.getMovies(query);
		// Search for movies in TMDB
		if (tmdbResults!=null){
			request.setAttribute("movies", tmdbResults.getResults());	
			rd = request.getRequestDispatcher("/Search.jsp");
			
		} else {
			log.log(Level.SEVERE, "TMDB object: " + tmdbResults);
			rd = request.getRequestDispatcher("/error.jsp");
			}
		rd.forward(request, response);
	   }
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
	 
}

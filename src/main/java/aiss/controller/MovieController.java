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
import aiss.model.resources.TMDBResource;

public class MovieController extends HttpServlet  {
	
private static final long serialVersionUID = 1L;
    
	private static final Logger log = Logger.getLogger(MovieController.class.getName());
	
	   public MovieController() {
	        super();
	    }
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		   
			String ListID = request.getParameter("ListID");
			String query = request.getParameter("searchQuery");
			RequestDispatcher rd = null;
			
			// Search for movies in TMDB
			log.log(Level.FINE, "Searching for TMDB movies that contain the id " + query);
			TMDBResource tmdb = new TMDBResource();
			Movie tmdbResult = tmdb.getMovie(query);
			if (tmdbResult!=null){
				request.setAttribute("movieID", tmdbResult);	
				rd = request.getRequestDispatcher("/success.jsp");
				
			} else {
				log.log(Level.SEVERE, "TMDB object: " + tmdbResult);
				rd = request.getRequestDispatcher("/error.jsp");
				}
			rd.forward(request, response);
		   }
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
	 

}

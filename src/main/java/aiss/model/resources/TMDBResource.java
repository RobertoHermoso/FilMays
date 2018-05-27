package aiss.model.resources; 

import java.io.UnsupportedEncodingException;


import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import com.google.protos.cloud.sql.Client;


import aiss.model.Movie;
import aiss.model.MovieSearch;

public class TMDBResource {
	
	private static final String TMDB_API_KEY = "a8a0bca3d6e01faf1370f46ae43ff618";  // TODO: Change this API KEY for your personal Key
	private static final Logger log = Logger.getLogger(TMDBResource.class.getName());
	private static final String uri ="https://api.themoviedb.org/3/";
	
	public MovieSearch getMovies(String query) throws UnsupportedEncodingException {
		String url = uri+"search/movie?api_key="+ TMDB_API_KEY + "&query=" +
				URLEncoder.encode(query , "UTF-8");
		log.log(Level.FINE, "TMDB URI: " + url );
		ClientResource cr = new ClientResource(url);
		MovieSearch res = cr.get(MovieSearch.class);
		
	    return res;
	}
	
	public Movie getMovie(String query) throws UnsupportedEncodingException {
		String url = "https://api.themoviedb.org/3/movie/"+ query + "?api_key=" + TMDB_API_KEY;
		log.log(Level.FINE, "TMDB URI: " + url );
		ClientResource cr = new ClientResource(url);
		Movie res = cr.get(Movie.class);
		
	    return res;
	}
	


}

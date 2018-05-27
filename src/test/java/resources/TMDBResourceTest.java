package resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.Movie;
import aiss.model.MovieSearch;
import aiss.model.Result;
import aiss.model.resources.TMDBResource;

public class TMDBResourceTest {

	TMDBResource tmdbr=new TMDBResource();
	MovieSearch ms;
	Movie m1;
	@Test
	public void testGetMovies() throws UnsupportedEncodingException {
		ms=tmdbr.getMovies("Iron Man");
		assertNotNull("La busqueda es null",ms);
		for(Result R:ms.getResults()) {
			System.out.println("Titulo original:"+R.getOriginalTitle());
			System.out.println("Id:"+R.getId());
		}
	}

	@Test
	public void testGetMovie() throws UnsupportedEncodingException {
		m1=tmdbr.getMovie("169934");
		assertNotNull("la busqueda es null",m1);
		System.out.println("media de votos:"+m1.getVoteAverage());
	}

}

package aiss.api;


import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import aiss.api.resource.CancionesApiResource;
import aiss.api.resource.PeliculasApiResource;
import aiss.api.resource.ProductoApiResource;
import aiss.api.resource.VideosApiResource;

public class FilmaysAplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public FilmaysAplication() {
		
		singletons.add(CancionesApiResource.getInstance());
		singletons.add(PeliculasApiResource.getInstance());
		singletons.add(ProductoApiResource.getInstance());
		singletons.add(VideosApiResource.getInstance());
	}
	
	public Set<Class<?>> getClasses() {
		return classes;
	}

	public Set<Object> getSingletons() {
		return singletons;
	}

}

package resource;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import aiss.api.resource.VideosApiResource;
import aiss.model.Video;

public class VideosApiResourceTest {

	VideosApiResource var=new VideosApiResource();
	@Test
	public void testGetAllVideos() {
		Collection<Video> cc=var.getAllVideos();
		assertNotNull("la collection es null",cc);
		System.out.println("Tamaño de la col:"+cc.size());
	}

	@Test
	public void testGetAllVideosById() {
		Collection<Video> v=var.getAllVideosById("f1");
		assertNotNull("La cancion es null",v);
		System.out.println("Numero de videos:"+v.size());
	}

	@Test
	public void testGetAllVideosByTitle() {
		Collection<Video> v=var.getAllVideosByTitle("Black Panther");
		assertNotNull("La cancion es null",v);
		System.out.println("Numero de videos:"+v.size());
	}

	@Test
	public void testGetVideoById() {
		Video v=var.getVideoById("v01");
		assertNotNull("La cancion es null",v);
		System.out.println("Numero de videos:"+v.getTitle());
	}

}

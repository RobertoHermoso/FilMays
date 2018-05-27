package aiss.model.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import aiss.model.Cancion;
import aiss.model.Pelicula;
import aiss.model.Producto;
import aiss.model.Video;
import aiss.model.repository.FilMaysRepository;
import aiss.model.repository.FilMaysRepositoryImplement;

public class FilMaysRepositoryImplementTest {

	static FilMaysRepository testRepository=FilMaysRepositoryImplement.getInstance();
	@Test
	public void testGetAllPeliculas() {
		Collection<Pelicula> cp=testRepository.getAllPeliculas();
		assertNotNull("ha ocurrido un error,la collection es null",cp);
		for(Pelicula p:cp) {
			System.out.println(p.getTitle());
		}
	}

	@Test
	public void testGetPeliculaById() {
		Pelicula p=testRepository.getPeliculaById("f1");
		assertNotNull("No se ha encontrado la peli, es null",p);
		System.out.println(p.getTitle());
	}

	@Test
	public void testGetPeliculasByTitle() {
		Collection<Pelicula> cp=testRepository.getPeliculasByTitle("Black Panther");
		assertNotNull("La collection es null",cp);
		for(Pelicula P:cp) {
			System.out.println(P.getActores());
		}
	}

	@Test
	public void testAddPelicula() {
		//Crear Video
		
				
				Video v2 = new Video("v02", "Trailer - Iron Man 3", "https://www.youtube.com/watch?v=6Cl8PmVm3YE");
				List<Video> videoIronMan3 = new ArrayList<>();
				
				videoIronMan3.add(v2);
				
				
				//Crear Producto
				Producto p4 = new Producto("p04", "Figura de Iron Man 38cm", "37€", "https://es.aliexpress.com/store/product/Loco-Juguetes-Iron-Man-Mark-XLVI-MK-46-1-6-B-sculas-PVC-figura-juguete-modelo/2313004_32837787629.html?ws_ab_test=searchweb0_0%2Csearchweb201602_5_10152_10151_10065_10344_10068_10547_10342_10343_10340_10548_10341_10696_10084_10083_10618_10307_10301_10303_10059_308_100031_10103_10624_10623_10622_10621_10620_10814_10815%2Csearchweb201603_2%2CppcSwitch_7&algo_expid=0082ced8-c8c3-476f-a432-28d031ced164-4&algo_pvid=0082ced8-c8c3-476f-a432-28d031ced164&transAbTest=ae803_2&priceBeautifyAB=0", "Figura colleccionable de Iron Man de 38 cm");
				Producto p5 = new Producto("p05", "Reactor Iron Man", "38€", "https://es.aliexpress.com/store/product/Toys-Legend-1-1-scale-Iron-Man-MK6-Arc-Reactor-with-LED-Light-Iron-Man-3/2795179_32804369969.html?ws_ab_test=searchweb0_0,searchweb201602_5_10152_10151_10065_10344_10068_10547_10342_10343_10340_10548_10341_10696_10084_10083_10618_10307_10301_10303_10059_308_100031_10103_10624_10623_10622_10621_10620_10814_10815,searchweb201603_2,ppcSwitch_7&algo_expid=0082ced8-c8c3-476f-a432-28d031ced164-5&algo_pvid=0082ced8-c8c3-476f-a432-28d031ced164&transAbTest=ae803_2&priceBeautifyAB=0", "Figura del reactor de Iron Man escala 1:1 con luces LED");
				Producto p6 = new Producto("p06", "Figura de accion de Iron Man", "16€", "https://es.aliexpress.com/store/product/NEW-Hot-1-pcs-Marvel-Movie-Iron-Man-3-Evolution-version-Action-Figure-Superhero-Mark-42/535439_32223118727.html?ws_ab_test=searchweb0_0,searchweb201602_5_10152_10151_10065_10344_10068_10547_10342_10343_10340_10548_10341_10696_10084_10083_10618_10307_10301_10303_10059_308_100031_10103_10624_10623_10622_10621_10620_10814_10815,searchweb201603_2,ppcSwitch_7&algo_expid=0082ced8-c8c3-476f-a432-28d031ced164-8&algo_pvid=0082ced8-c8c3-476f-a432-28d031ced164&transAbTest=ae803_2&priceBeautifyAB=0", "Figura de accion movil de Iron Man de 18 cm");
				
		
				List<Producto> productosIronMan = new ArrayList<>();
				productosIronMan.add(p4);
				productosIronMan.add(p5);
				productosIronMan.add(p6);
			     //Crear Cancion
			
				Cancion c4=new Cancion("https://open.spotify.com/track/6C67ZEgSBc64tof7xKMYA1","Mark I","c04",120,69);
				Cancion c5=new Cancion("https://open.spotify.com/track/19utKBiyGQH8I45pIBNhJL","Mark II","c05",120,69);
				Cancion c6=new Cancion("https://open.spotify.com/track/2iXt0dtlAOA6LS0k6pR6bg","Merchant of Death","c06",180,76);
				  List<Cancion> cancionesIronMan=new ArrayList<>();
				  cancionesIronMan.add(c4);
				  cancionesIronMan.add(c5);
				  cancionesIronMan.add(c6);
		Pelicula f3 = new Pelicula("f3", "Iron Man P", "Shane Black", " Robert Downey Jr., Guy Pearce, Gwyneth Paltrow,...", "En esta ocasión el imponente superhéroe Iron Man intentará mejorar su armadura mediante una nueva tecnología y, entre otros personajes, estará acompañado de su gran amiga Pepper Potts (Gwyneth Paltrow), su aliado de armas James Rhodes y su guardaespaldas Happy Hogan. Esta nueva entrega de la historia se inspira en la colección de comics titulada 'Extremis', escrita por Warren Ellis y dibujada por Adi Granov que fue publicada entre el año 2005 y el año 2006. En esta parte, el argumento se desarrolla en un mundo más realista y menos fantasioso que el de las anteriores, donde los acontecimientos sucedidos en 'Marvel: Los Vengadores' tienen constancia pero no resultan ser el eje central de la película. De esta forma, el tercer capítulo de la saga Iron Man revolucionará el estilo de las anteriores conservando su esencia, pero con originales innovaciones que sorprenderán a todos los fans de la serie.", "Abril 18, 2013", 
				videoIronMan3, productosIronMan, cancionesIronMan);
		
		assertNotNull("La pelicula es null",f3);
		assertEquals("La lista de videos no es la misma",videoIronMan3,f3.getVideos());
		assertEquals("La lista de productos no es la misma",productosIronMan,f3.getProductos());
		assertEquals("La lista de canciones no es la misma",cancionesIronMan,f3.getCanciones());
		testRepository.addPelicula(f3);
		boolean success=false;
		for(Pelicula p :testRepository.getAllPeliculas()) {
			if(p.equals(f3)) {
				success=true;
				break;
			}
		}
		assertTrue("No se ha añadido la peli",success);
	}

	@Test
	public void testUpdatePelicula() {
		Pelicula nw=testRepository.getPeliculaById("f2");
		String director="el kiko";
		String title="White Panther";
		String Synopsis="blabla";
		nw.setDirector(director);
		nw.setTitle(title);
		nw.setSynopsis(Synopsis);
		
		testRepository.updatePelicula(nw);
		assertEquals("No se ha actualizado el director correctamente",director,testRepository.getPeliculaById("f2").getDirector());
		assertEquals("No se ha actualizado el titulo correctamente",title,testRepository.getPeliculaById("f2").getTitle());
		assertEquals("No se ha actualizado la sinopsis correctamente",Synopsis,testRepository.getPeliculaById("f2").getSynopsis());

		
	}

	@Test
	public void testDeletePelicula() {
		testRepository.deletePelicula("f3");
		assertNull("No se ha borrado la pelicula",testRepository.getPeliculaById("f3"));
	}

	@Test
	public void testAddVideoPelicula() {
		Video v3 = new Video("v03", "Trailerazo - Iron Man NP", "https://www.yutuf.com/watch?v=6Cl8PmVm3YE");
		testRepository.addVideoPelicula("f1", v3);
		boolean success=false;
		if(testRepository.getVideoById("v1").equals(v3)) {
				success=true;
		}
		assertNotNull("es null",testRepository.getVideoById("v1"));
				assertTrue("No se ha añadido el video a la pelicula",success);
	}

	@Test
	public void testUpdateVideoPelicula() {
		Video nw=testRepository.getVideoById("v01");
		assertNotNull("es null el video",nw);
		String title="El hombre de hierro";
		String url="URL falsa 111";
		nw.setTitle(title);
		nw.setUrl(url);
		testRepository.updateVideoPelicula("f1",nw);
		assertEquals("No se ha actualizado el titulo correctamente",title,testRepository.getVideoById("v01").getTitle());
		assertEquals("No se ha actualizado la url correctamente",url,testRepository.getVideoById("v01").getUrl());
		
		
	}

	@Test
	public void testDeleteVideoPelicula() {
		testRepository.deleteVideoPelicula("f1","v04");
		boolean success=true;
		for(Video v:testRepository.getPeliculaById("f1").getVideos()) {
			if(v.getId().equals("v04")) {
				success=false;
				break;
			}
		}
		assertTrue("No se ha borrado el video",success);
	}

	@Test
	public void testAddProductoPelicula() {
		Producto p7 = new Producto("p07", "Figura falsa de no accion de Iron Man", "666€", "https://es.aliexpress.com/store/product/NEW-Hot-1-pcs-Marvel-Movie-Iron-Man-3-Evolution-version-Action-Figure-Superhero-Mark-42/535439_32223118727.html?ws_ab_test=searchweb0_0,searchweb201602_5_10152_10151_10065_10344_10068_10547_10342_10343_10340_10548_10341_10696_10084_10083_10618_10307_10301_10303_10059_308_100031_10103_10624_10623_10622_10621_10620_10814_10815,searchweb201603_2,ppcSwitch_7&algo_expid=0082ced8-c8c3-476f-a432-28d031ced164-8&algo_pvid=0082ced8-c8c3-476f-a432-28d031ced164&transAbTest=ae803_2&priceBeautifyAB=0", "Figura de accion movil de Iron Man de 18 cm");
		testRepository.addProductoPelicula("f1", p7);
		boolean success=false;
		for(Producto p:testRepository.getPeliculaById("f1").getProductos()) {
			if(p.getId().equals("p0")) {
				success=true;
				break;
			}
		}
		assertTrue("No se ha añadido el producto a la pelicula",success);
	}

	@Test
	public void testUpdateProductoPelicula() {
		Producto pn=null;
		for(Pelicula p: testRepository.getAllPeliculas()) {
			for(Producto pr:p.getProductos()) {
				if(pr.getId().equals("p0")) {
					pn=pr;
					break;
				}
			}
		}
		String desc="nananaa";
		String nom="KKK";
	   pn.setDescription(desc);
	   pn.setName(nom);
		testRepository.updateProductoPelicula("f1",pn);
		boolean success=false;
		for(Producto p:testRepository.getPeliculaById("f1").getProductos()) {
			if(p.getName().equals(nom) || p.getDescription().equals(desc)) {
				success=true;
				break;
			}
		}
		assertTrue("No se ha actualizado el producto",success);
	}

	@Test
	public void testDeleteProductoPelicula() {
		testRepository.deleteProductoPelicula("f1","p07");
		boolean success=true;
		for(Producto p:testRepository.getPeliculaById("f1").getProductos()) {
			if(p.getId().equals("p07")) {
				success=false;
				break;
			}
		}
		assertTrue("No se ha borrado el producto de la pelicula",success);
	}

	@Test
	public void testAddCancionPelicula() {
		Cancion c7=new Cancion("https://open.spotify.com/track/2iXt0dtlAOA6LS0k6pR6bg","Merchandising of the Dead","c07",190,96);
		testRepository.addCancionPelicula("f1", c7);
		boolean success=false;
		
		for(Cancion c:testRepository.getPeliculaById("f1").getCanciones()) {
			if(c.equals(c7)) {
				success=true;
	
				break;
			}
		}
		assertTrue("No se ha añadido la cancion",success);
	}

	@Test
	public void testUpdateCancionPelicula() {
		Cancion nw=testRepository.getCancionById("c02");
		Integer dur=122;
		String name="Black piss";
		nw.setDuration(dur);
		nw.setName(name);
		testRepository.updateCancionPelicula("f1",nw);
		Cancion cc=testRepository.getCancionById("c02");
		assertEquals("El nombre  es igual",cc.getName(),name);
		assertEquals("la duracion es igual",cc.getDuration(),dur);
		
	}

	@Test
	public void testDeleteCancionPelicula() {
		testRepository.deleteCancionPelicula("f1","c07");
		boolean success=true;
		for(Cancion c :testRepository.getPeliculaById("f1").getCanciones()) {
			if(c.getId().equals("c07")) {
				success=false;
				break;
			}
		}
		assertTrue("No se ha eliminado la cancion",success);
	}

	@Test
	public void testGetAllPeliculaVideos() {
		Collection<Video> video=testRepository.getAllPeliculaVideos();
		assertNotNull("la collection es null",video);
	}

	@Test
	public void testGetPeliculaVideosById() {
		Collection<Video> video=testRepository.getPeliculaVideosById("f1");
		assertNotNull("La collection es null",video);
	}

	@Test
	public void testGetPeliculaVideosByName() {
		Collection<Video> video=testRepository.getPeliculaVideosByName("Black Panther");
		assertNotNull("La collection es null",video);
	}

	@Test
	public void testGetVideoById() {
		Video v=testRepository.getVideoById("v01");
		assertNotNull("El video es null",v);
	}

	@Test
	public void testGetAllPeliculasProductos() {
		Collection<Producto> productos=testRepository.getAllPeliculasProductos();
		assertNotNull("la collection es null",productos);
	}

	@Test
	public void testGetPeliculaProductosById() {
		Collection<Producto> productos=testRepository.getPeliculaProductosById("f1");
		assertNotNull("La collection es null",productos);
	}

	@Test
	public void testGetPeliculaProductosByName() {
		Collection<Producto> productos=testRepository.getPeliculaProductosByName("Black Panther");
		assertNotNull("la collection es null",productos);
	}

	@Test
	public void testGetProductoById() {
		Producto p=testRepository.getProductoById("p01");
		assertNotNull("El producto es null",p);
	}

	@Test
	public void testGetAllPeliculasCanciones() {
		Collection<Cancion> canciones=testRepository.getAllPeliculasCanciones();
		assertNotNull("la collection es null",canciones);
	}

	@Test
	public void testGetPeliculasCancionesById() {
		Collection<Cancion> canciones=testRepository.getPeliculasCancionesById("f1");
		assertNotNull("la collection es null",canciones);
	}

	@Test
	public void testGetPeliculasCancionesByName() {
		Collection<Cancion> canciones=testRepository.getPeliculasCancionesByName("Black Panther");
		assertNotNull("la collection es null",canciones);
	}

	@Test
	public void testGetCancionById() {
		Cancion c=testRepository.getCancionById("c03");
		assertNotNull("la cancion es null",c);
	}

}

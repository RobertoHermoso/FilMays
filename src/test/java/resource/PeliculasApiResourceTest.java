package resource;

import static org.junit.Assert.*;


import java.net.URI;

import java.util.Collection;


import javax.ws.rs.core.UriInfo;

import org.junit.Test;
import org.mockito.Mockito;

import aiss.api.resource.PeliculasApiResource;
import aiss.model.Cancion;
import aiss.model.Pelicula;
import aiss.model.Producto;
import aiss.model.Video;

public class PeliculasApiResourceTest {

	static PeliculasApiResource PEAR=new PeliculasApiResource();
	
	
	
	@Test
	public void testGetAllPeliculas() {
		Collection<Pelicula> cp=PEAR.getAllPeliculas();
		assertNotNull("la collection es null",cp);
		for(Pelicula p:cp) {
			System.out.println("pelis:"+p.getId());
		}
		System.out.println("fin getAllPeliculas================");
	}

	@Test
	public void testGetPeliculaById() {
		Pelicula p=PEAR.getPeliculaById("f1");
		assertNotNull("La pelicula es null",p);
		System.out.println("Titulo de la peli:"+p.getTitle());
		System.out.println("Fin getPeliculaById======================");
	}

	@Test
	public void testGeAllPeliculasByTitle() {
		Collection<Pelicula> cp=PEAR.geAllPeliculasByTitle("Black Panther");
		assertNotNull("La col es null",cp);
		System.out.println("Tamaño de la col:"+cp.size());
		System.out.println("fin getAllPeliculasByTitle=====================0");
	}

	/*@Test
	public void testAddPelicula() {
		//Crear Video
		UriInfo uriInfo = Mockito.mock(UriInfo.class);
		Mockito.when(uriInfo.getAbsolutePath())
		    .thenReturn(URI.create("http://localhost:8090/api/peliculas/")) ;
		
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
		  Pelicula f3 = new Pelicula("pelicula2", "Iron Man P", "Shane Black", " Robert Downey Jr., Guy Pearce, Gwyneth Paltrow,...", "En esta ocasión el imponente superhéroe Iron Man intentará mejorar su armadura mediante una nueva tecnología y, entre otros personajes, estará acompañado de su gran amiga Pepper Potts (Gwyneth Paltrow), su aliado de armas James Rhodes y su guardaespaldas Happy Hogan. Esta nueva entrega de la historia se inspira en la colección de comics titulada 'Extremis', escrita por Warren Ellis y dibujada por Adi Granov que fue publicada entre el año 2005 y el año 2006. En esta parte, el argumento se desarrolla en un mundo más realista y menos fantasioso que el de las anteriores, donde los acontecimientos sucedidos en 'Marvel: Los Vengadores' tienen constancia pero no resultan ser el eje central de la película. De esta forma, el tercer capítulo de la saga Iron Man revolucionará el estilo de las anteriores conservando su esencia, pero con originales innovaciones que sorprenderán a todos los fans de la serie.", "Abril 18, 2013", 
				  videoIronMan3, productosIronMan, cancionesIronMan);

		assertNotNull("La pelicula es null",f3);
		assertEquals("La lista de videos no es la misma",videoIronMan3,f3.getVideos());
		assertEquals("La lista de productos no es la misma",productosIronMan,f3.getProductos());
		assertEquals("La lista de canciones no es la misma",cancionesIronMan,f3.getCanciones());
		PEAR.addPelicula(uriInfo,f3);
		boolean success=false;
		for(Pelicula p :PEAR.getAllPeliculas()) {
			if(p.equals(f3)) {
				success=true;
				break;
			}
		}
		
		assertTrue("No se ha añadido la peli",success);
	}*/

	@Test
	public void testUpdatePelicula() {
		Pelicula nw=PEAR.getPeliculaById("f1");
		System.out.println("pelicula a actualizar:"+nw.getId());
		String director="el kiko";
		String title="White Panther";
		String Synopsis="blabla";
		nw.setDirector(director);
		nw.setTitle(title);
		nw.setSynopsis(Synopsis);
		
		PEAR.updatePelicula(nw);
		assertEquals("No se ha actualizado el director correctamente",director,PEAR.getPeliculaById("f1").getDirector());
		assertEquals("No se ha actualizado el titulo correctamente",title,PEAR.getPeliculaById("f1").getTitle());
		assertEquals("No se ha actualizado la sinopsis correctamente",Synopsis,PEAR.getPeliculaById("f1").getSynopsis());
        System.out.println("fin de updatePelicula=====================");
	}

	@Test
	public void testRemovePelicula() {
		 PEAR.removePelicula("f2");
		 System.out.println("Pelicula a borrar:f2");
		 boolean success=true;
		 for(Pelicula p :PEAR.getAllPeliculas()) {
			 if(p.getId().equals("f2")) {
				 success=false;
			 }
		 }
		 System.out.println("Pelicula borrada:"+success);
		assertTrue("No se ha borrado la pelicula",success);
		System.out.println("fin removePelicula=======================");
	}

	@Test
	public void testAddVideoPelicula() {
		UriInfo uriInfo = Mockito.mock(UriInfo.class);
		Mockito.when(uriInfo.getAbsolutePath())
		    .thenReturn(URI.create("http://localhost:8090/api/peliculas/video/")) ;
	
		Video v3 = new Video("v03", "Trailerazo - Iron Man NP", "https://www.yutuf.com/watch?v=6Cl8PmVm3YE");
		PEAR.addVideoPelicula(uriInfo, "f1", v3);
		System.out.println("video añadido:"+v3.getId());
		System.out.println("Fin addVideoPelicula===========================");
		
		
	}

	@Test
	public void testUpdateVideoPelicula() {
		Video nw=null;
		for(Pelicula p: PEAR.getAllPeliculas()) {
			for(Video v:p.getVideos()) {
				if(v.getId().equals("v01")) {
					nw=v;
					break;
				}
			}
		}
		assertNotNull("es null el video",nw);
		String title="El hombre de hierro";
		String url="URL falsa 111";
		nw.setTitle(title);
		nw.setUrl(url);
		PEAR.updateVideoPelicula("f1",nw);
		Video up=null;
		for(Pelicula p: PEAR.getAllPeliculas()) {
			for(Video v:p.getVideos()) {
				if(v.getId().equals("v01")) {
					up=v;
					break;
				}
			}
		}
		assertEquals("No se ha actualizado el titulo correctamente",title,up.getTitle());
		assertEquals("No se ha actualizado la url correctamente",url,up.getUrl());
		System.out.println("Pelicula actualizada:"+up.getId());
		System.out.println("Fin de updateVideoPelicula====================");
	}

	@Test
	public void testDeleteVideoPelicula() {
		PEAR.deleteVideoPelicula("f1","v04");
		boolean success=true;
		for(Video v:PEAR.getPeliculaById("f1").getVideos()) {
			if(v.getId().equals("v04")) {
				success=false;
				break;
			}
		}
		assertTrue("No se ha borrado el video",success);
		System.out.println("Video borrado:v04");
		System.out.println("Fin deleteVideoPelicula=======================");
	}

	@Test
	public void testAddProductoPelicula() {
		UriInfo uriInfo = Mockito.mock(UriInfo.class);
		Mockito.when(uriInfo.getAbsolutePath())
		    .thenReturn(URI.create("http://localhost:8090/api/peliculas/producto/"));
		Producto p7 = new Producto("p08", "Figura falsa de no accion de Iron Man", "666€", "https://es.aliexpress.com/store/product/NEW-Hot-1-pcs-Marvel-Movie-Iron-Man-3-Evolution-version-Action-Figure-Superhero-Mark-42/535439_32223118727.html?ws_ab_test=searchweb0_0,searchweb201602_5_10152_10151_10065_10344_10068_10547_10342_10343_10340_10548_10341_10696_10084_10083_10618_10307_10301_10303_10059_308_100031_10103_10624_10623_10622_10621_10620_10814_10815,searchweb201603_2,ppcSwitch_7&algo_expid=0082ced8-c8c3-476f-a432-28d031ced164-8&algo_pvid=0082ced8-c8c3-476f-a432-28d031ced164&transAbTest=ae803_2&priceBeautifyAB=0", "Figura de accion movil de Iron Man de 18 cm");
		PEAR.addProductoPelicula(uriInfo, "f1", p7);
		boolean success=false;
		for(Producto p:PEAR.getPeliculaById("f1").getProductos()) {
			if(p.getId().equals("p0")) {
				success=true;
				break;
			}
		}
		assertTrue("No se ha añadido el producto a la pelicula",success);
		System.out.println("Se ha añadido el producto:p0");
		System.out.println("Fin de addProductoPelicula=============================");
	
	}

	@Test
	public void testUpdateProductoPelicula() {
		Producto pn=null;
		for(Pelicula p: PEAR.getAllPeliculas()) {
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
		PEAR.updateProductoPelicula("f1",pn);
		boolean success=false;
		for(Producto p:PEAR.getPeliculaById("f1").getProductos()) {
			if(p.getName().equals(nom) || p.getDescription().equals(desc)) {
				success=true;
				break;
			}
		}
		assertTrue("No se ha actualizado el producto",success);
		System.out.println("Se ha actualizado el producto:"+success);
		System.out.println("Fin updateProductoPelicula========================");
	}

	@Test
	public void testDeleteProductoPelicula() {
		PEAR.deleteProductoPelicula("f1","p07");
		boolean success=true;
		for(Producto p:PEAR.getPeliculaById("f1").getProductos()) {
			if(p.getId().equals("p07")) {
				success=false;
				break;
			}
		}
		assertTrue("No se ha borrado el producto de la pelicula",success);
		System.out.println("Se ha borrado el producto:"+success);
		System.out.println("Fin de deleteProductoPelicula=======================0");
	}

	@Test
	public void testAddCancionPelicula() {
		UriInfo uriInfo = Mockito.mock(UriInfo.class);
		Mockito.when(uriInfo.getAbsolutePath())
		    .thenReturn(URI.create("http://localhost:8090/api/peliculas/cancion/")) ;
		Cancion c7=new Cancion("https://open.spotify.com/track/2iXt0dtlAOA6LS0k6pR6bg","Merchandising of the Dead","c07",190,96);
		PEAR.addCancionPelicula(uriInfo,"f1", c7);
		boolean success=false;
		for(Cancion c:PEAR.getPeliculaById("f1").getCanciones()) {
			if(c.equals(c7)) {
				success=true;
				break;
			}
		}
		assertTrue("No se ha añadido la cancion",success);
		System.out.println("Se ha añadido la cancion:"+success);
		System.out.println("fin de addCancionPelicula=======================0");
	}

	@Test
	public void testUpdateCancionPelicula() {
		Cancion nw=null;
		for(Pelicula p: PEAR.getAllPeliculas()) {
			for(Cancion c:p.getCanciones()) {
				if(c.getId().equals("c02")) {
					nw=c;
					break;
				}
			}
		}
		Integer dur=122;
		String name="Black piss";
		nw.setDuration(dur);
		nw.setName(name);
		PEAR.updateCancionPelicula("f1",nw);
		Cancion cc=null;
		for(Pelicula p: PEAR.getAllPeliculas()) {
			for(Cancion c:p.getCanciones()) {
				if(c.getId().equals("c02")) {
					cc=c;
					break;
				}
			}
		}
		assertEquals("El nombre  es igual",cc.getName(),name);
		assertEquals("la duracion es igual",cc.getDuration(),dur);
		System.out.println("Cancion actualizada:"+cc.getId());
		System.out.println("Fin de updateCancionPelicula=================");
	}

	@Test
	public void testDeleteCancionPelicula() {
		PEAR.deleteCancionPelicula("f1","c07");
		boolean success=true;
		for(Cancion c :PEAR.getPeliculaById("f1").getCanciones()) {
			if(c.getId().equals("c07")) {
				success=false;
				break;
			}
		}
		System.out.println("Se ha borrado la cancion:"+success);
		assertTrue("No se ha eliminado la cancion",success);
		System.out.println("Fin de deleteCancionPelicula===");
	}
	
}

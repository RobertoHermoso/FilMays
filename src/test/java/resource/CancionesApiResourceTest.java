package resource;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import aiss.api.resource.CancionesApiResource;
import aiss.model.Cancion;

public class CancionesApiResourceTest {


	static CancionesApiResource car=new CancionesApiResource();
	@Test
	public void testGetAllCanciones() {
		Collection<Cancion> cc=car.getAllCanciones();
		assertNotNull("la collection es null",cc);
		System.out.println("Tamaño de la col:"+cc.size());
	}

	@Test
	public void testGetCancionById() {
		Cancion c=car.getCancionById("c02");
		assertNotNull("La cancion es null",c);
		System.out.println("Nombre de la cancion:"+c.getName());
	}

	@Test
	public void testGeAllCancionesByTitle() {
		Collection<Cancion> cc=car.geAllCancionesByTitle("All the stars");
		assertNotNull("la collection es null",cc);
		System.out.println("Tamaño de la col:"+cc.size());
	}

}

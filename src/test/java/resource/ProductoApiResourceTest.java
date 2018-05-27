package resource;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import aiss.api.resource.ProductoApiResource;
import aiss.model.Producto;

public class ProductoApiResourceTest {

	static ProductoApiResource par=new ProductoApiResource();
	@Test
	public void testGetAllProductos() {
		Collection<Producto> cc=par.getAllProductos();
		assertNotNull("la collection es null",cc);
		System.out.println("Tamaño de la col:"+cc.size());
	}

	@Test
	public void testGetAllProductosById() {
		Collection<Producto> v=par.getAllProductosById("f1");
		assertNotNull("La cancion es null",v);
		System.out.println("Numero de productos:"+v.size());
	}

	@Test
	public void testGetAllProductosByTitle() {
		Collection<Producto> v=par.getAllProductosByTitle("Black Panther");
		assertNotNull("La cancion es null",v);
		System.out.println("Numero de productos:"+v.size());
	}

	@Test
	public void testGetProductoById() {
		Producto v=par.getProductoById("p01");
		assertNotNull("La cancion es null",v);
		System.out.println("Precio del producto:"+v.getPrize());
	}

}

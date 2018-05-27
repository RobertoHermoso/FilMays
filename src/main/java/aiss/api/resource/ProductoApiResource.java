package aiss.api.resource;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.Producto;
import aiss.model.repository.FilMaysRepository;
import aiss.model.repository.FilMaysRepositoryImplement;




@Path("/productos")
public class ProductoApiResource {
public static ProductoApiResource _instance = null;
	
	FilMaysRepository repository;

	public ProductoApiResource() {
		repository = FilMaysRepositoryImplement.getInstance();
	}

	public static ProductoApiResource getInstance() {
		if (_instance == null) {
			_instance = new ProductoApiResource();
		}
		return _instance;
	}
	
	// Método que devuelve todos los productos
	@GET
	@Produces("application/json")
	public Collection<Producto> getAllProductos() {
		return repository.getAllPeliculasProductos();
	}
	
	// Método que devuelve todos los productos de la id de una Pelicula
	@GET
	@Path("/idPelicula")
	@Produces("application/json")
	public Collection<Producto> getAllProductosById(@QueryParam("id") String idPelicula) {
		Collection<Producto> res = repository.getPeliculaProductosById(idPelicula);
		if (res == null) {
			throw new NotFoundException("No se encuentra ningún producto.");
		}
		return res;
	}
	
	// Método que devuelve todos los productos del nombre de una Pelicula
	@GET
	@Path("/titlePelicula")
	@Produces("application/json")
	public Collection<Producto> getAllProductosByTitle(@QueryParam("title") String title) {
		Collection<Producto> res = repository.getPeliculaProductosByName(title);
		if (res == null) {
			throw new NotFoundException("No se encuentra ningún producto.");
		}
		return res;
	}	
	
	// Método que devuelve un producto con una determinada id
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Producto getProductoById(@PathParam("id") String id) {
		Producto producto = repository.getProductoById(id);
		if (producto == null) {
			throw new BadRequestException("La producto solicitado no existe.");
		}
		return producto;
	}
	
	

}

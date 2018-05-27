package aiss.api.resource;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.Cancion;
import aiss.model.Pelicula;
import aiss.model.Producto;
import aiss.model.Video;
import aiss.model.repository.FilMaysRepository;
import aiss.model.repository.FilMaysRepositoryImplement;

@Path("/peliculas")
public class PeliculasApiResource {
	
	public static PeliculasApiResource _instance  = null;
	FilMaysRepository	repository;
	
	public PeliculasApiResource() {
		
		repository = FilMaysRepositoryImplement.getInstance();
	}
	
	public static PeliculasApiResource getInstance() {
		if (_instance == null)
			_instance = new PeliculasApiResource();
		return _instance;
	}
	
	@GET
	@Produces("application/json")
	public Collection<Pelicula> getAllPeliculas() {
		return repository.getAllPeliculas();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Pelicula getPeliculaById(@PathParam("id") String id) {
		Pelicula res = repository.getPeliculaById(id);
		if (res == null) {
			throw new BadRequestException("La pelicula buscada no existe.");
		}
		return res;
	}
	
	@GET
	@Path("/title}")
	@Produces("application/json")
	public Collection<Pelicula> geAllPeliculasByTitle(@QueryParam("title") String title) {
		Collection<Pelicula> res = repository.getPeliculasByTitle(title);
		if (res == null) {
			throw new NotFoundException("No se encuentra ninguna película.");
		}
		return res;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addPelicula(@Context UriInfo uriInfo, Pelicula pelicula) {
		if (pelicula.getTitle() == null || pelicula.getTitle().equals("")) {
			throw new BadRequestException("La pelicula no es válida");
		}
		repository.addPelicula(pelicula);
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(pelicula);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(pelicula);
		return Response.noContent().build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response updatePelicula(Pelicula pelicula) {
		Pelicula oldP = repository.getPeliculaById(pelicula.getId());
		if (oldP == null) {
			throw new NotFoundException("La pelicula con id="+ pelicula.getId() +" no fue encontrada");			
		}
		else {
			repository.updatePelicula(pelicula);
		}
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes("application/json")
	public Response removePelicula(@PathParam("id") String id) {
		Pelicula pelicula = repository.getPeliculaById(id);
		if (pelicula == null) {
			throw new NotFoundException("El pelicula con id="+ id +" no fue encontrado");			
		}
		else {
			repository.deletePelicula(id);
		}
		return Response.noContent().build();
		
	}
	
	// Método que añade un vídeo a una Pelicula
	@POST
	@Path("/video/{idPelicula}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addVideoPelicula(@Context UriInfo uriInfo, @PathParam("idPelicula") String idPelicula, Video video) {
		if (idPelicula == null || idPelicula == "") {
			throw new BadRequestException("El vídeo no es válido");
		}
		repository.addVideoPelicula(idPelicula, video);
		ResponseBuilder resp = Response.created(uriInfo.getAbsolutePath());
		resp.entity(video);   
		return resp.build();
	}

	// Método que actualiza un vídeo de una Pelicula
	@PUT
	@Path("/video/{idPelicula}")
	@Consumes("application/json")
	public Response updateVideoPelicula(@PathParam("idPelicula") String idPelicula, Video video) {
		Video oldV = repository.getVideoById(video.getId());
		if (oldV == null) {
			throw new NotFoundException("El vídeo no fue encontrado");			
		}
		else {
			repository.updateVideoPelicula(idPelicula, video);
		}
		return Response.noContent().build();
	}

	// Método que elimina un vídeo de una Pelicula
	@DELETE
	@Path("/video/{idPelicula}/{idVideo}")
	@Consumes("application/json")
	public Response deleteVideoPelicula(@PathParam("idPelicula") String idPelicula, @PathParam("idVideo") String idVideo) {
		if (idVideo == null) {
			throw new NotFoundException("El vídeo no fue encontrado");			
		}
		else {
			repository.deleteVideoPelicula(idPelicula, idVideo);
		}
		return Response.noContent().build();
	}
	
	// Método que añade un producto a una Pelicula
	@POST
	@Path("/producto/{idPelicula}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addProductoPelicula(@Context UriInfo uriInfo, @PathParam("idPelicula") String idPelicula, Producto producto) {
		if (idPelicula == null || idPelicula == "") {
			throw new BadRequestException("El producto no es válido");
		}
		repository.addProductoPelicula(idPelicula, producto);
		ResponseBuilder resp = Response.created(uriInfo.getAbsolutePath());
		resp.entity(producto);   
		return resp.build();
	}

	// Método que actualiza un producto de una Pelicula
	@PUT
	@Path("/producto/{idPelicula}")
	@Consumes("application/json")
	public Response updateProductoPelicula(@PathParam("idPelicula") String idPelicula, Producto producto) {
		Producto oldP = repository.getProductoById(producto.getId());
		if (oldP == null) {
			throw new NotFoundException("El producto no fue encontrado");			
		}
		else {
			repository.updateProductoPelicula(idPelicula, producto);
		}
		return Response.noContent().build();
	}

	// Método que elimina un producto de una Pelicula
	@DELETE
	@Path("/producto/{idPelicula}/{idProducto}")
	@Consumes("application/json")
	public Response deleteProductoPelicula(@PathParam("idPelicula") String idPelicula, @PathParam("idProducto") String idProducto) {
		if (idProducto == null) {
			throw new NotFoundException("El producto no fue encontrado");			
		}
		else {
			repository.deleteProductoPelicula(idPelicula, idProducto);
		}
		return Response.noContent().build();
	}
	
	@POST
	@Path("/cancion/{idPelicula}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addCancionPelicula(@Context UriInfo uriInfo, @PathParam("idPelicula") String idPelicula, Cancion cancion) {
		if (idPelicula == null || idPelicula == "") {
			throw new BadRequestException("La cancion no es válida");
		}
		repository.addCancionPelicula(idPelicula,cancion);
		ResponseBuilder resp = Response.created(uriInfo.getAbsolutePath());
		resp.entity(cancion);   
		return resp.build();
	}
	@PUT
	@Path("/cancion/{idPelicula}")
	@Consumes("application/json")
	public Response updateCancionPelicula(@PathParam("idPelicula") String idPelicula, Cancion cancion) {
		Cancion oldC = repository.getCancionById(cancion.getId());
		if (oldC == null) {
			throw new NotFoundException("La cancion no fue encontrada");			
		}
		else {
			repository.updateCancionPelicula(idPelicula, cancion);
		}
		return Response.noContent().build();
	}
	@DELETE
	@Path("/cancion/{idPelicula}/{idCancion}")
	@Consumes("application/json")
	public Response deleteCancionPelicula(@PathParam("idPelicula") String idPelicula, @PathParam("idCancion") String idCancion) {
		if (idCancion == null) {
			throw new NotFoundException("La cancion no fue encontrada");			
		}
		else {
			repository.deleteCancionPelicula(idPelicula, idCancion);
		}
		return Response.noContent().build();
	}
	


}

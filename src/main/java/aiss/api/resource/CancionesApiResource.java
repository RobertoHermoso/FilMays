package aiss.api.resource;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.Cancion;
import aiss.model.repository.FilMaysRepository;
import aiss.model.repository.FilMaysRepositoryImplement;

@Path("/canciones")
public class CancionesApiResource {

  public static CancionesApiResource _instance=null;
     FilMaysRepository  repository;
     
     public CancionesApiResource() {
    	 repository=FilMaysRepositoryImplement.getInstance();
     }
  
     public static CancionesApiResource getInstance() {
    	 if(_instance==null) {
    		 _instance=new CancionesApiResource();
    	 }
    	 return _instance;
     }
     
     @GET
     @Produces("application/json")
     public Collection<Cancion> getAllCanciones(){
    	 return repository.getAllPeliculasCanciones();
     }
     @GET
     @Path("/{id}")
     @Produces("application/json")
     public Cancion getCancionById(@PathParam("id") String id) {
    	 Cancion res=repository.getCancionById(id);
    	 if(res==null) {
    		 throw new BadRequestException("La cancion buscada no existe");
    	 }
    	 return res;
     }
     @GET
 	@Path("/{title}")
 	@Produces("application/json")
 	public Collection<Cancion> geAllCancionesByTitle(@PathParam("title") String title) {
 		Collection<Cancion> res = repository.getPeliculasCancionesByName(title);
 		if (res == null) {
 			throw new NotFoundException("No se encuentra ninguna cancion.");
 		}
 		return res;
 	}
     
}

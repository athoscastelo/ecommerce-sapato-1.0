package resource;

import dto.CorDTO;
import dto.CorResponseDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.CorService;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cores")
public class CorResource {
    
    @Inject
    public CorService corService;

    @GET
    @Path("/{id}")
    public CorResponseDTO findById(@PathParam("id") Long id) {
        return corService.findById(id);
    }

    @GET
    public List<CorResponseDTO> findAll() {
        return corService.findAll();
    }

    @POST
    public CorResponseDTO create(CorDTO dto) {
        return corService.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Long id, CorDTO dto) {
        corService.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        corService.delete(id);
    }
}

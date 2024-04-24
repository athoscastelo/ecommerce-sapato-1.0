package resource;

import java.util.List;

import dto.SapatoDTO;
import dto.SapatoResponseDTO;
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
import service.SapatoService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/sapatos")
public class SapatoResource {
    
    @Inject
    public SapatoService sapatoService;

    

    @GET
    @Path("/{id}")
    public SapatoResponseDTO findById(@PathParam("id") Long codigo) {
        return sapatoService.findById(codigo);
    }

    @GET
    public List<SapatoResponseDTO> findAll() {
        return sapatoService.findAll();
    }

    @POST
    public SapatoResponseDTO create(SapatoDTO dto) {
        return sapatoService.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Long id, SapatoDTO dto) {
        sapatoService.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        sapatoService.delete(id);
    }
}



package resource;

import java.util.List;

import dto.ColecaoDTO;
import dto.ColecaoResponseDTO;
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
import service.ColecaoService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/colecoes")
public class ColecaoResource {
    
    @Inject
    public ColecaoService colecaoService;

    @GET
    @Path("/{id}")
    public ColecaoResponseDTO findById(@PathParam("id") Long id) {
        return colecaoService.findById(id);
    }

    @GET
    public List<ColecaoResponseDTO> findAll() {
        return colecaoService.findAll();
    }

    @POST
    public ColecaoResponseDTO create(ColecaoDTO dto) {
        return colecaoService.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Long id, ColecaoDTO dto) {
        colecaoService.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        colecaoService.delete(id);
    }
}


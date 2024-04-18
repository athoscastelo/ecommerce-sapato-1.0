package resource;

import dto.ModeloDTO;
import dto.ModeloResponseDTO;
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
import service.ModeloService;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/modelos")
public class ModeloResource {

    @Inject
    public ModeloService modeloService;

    @GET
    @Path("/{id}")
    public ModeloResponseDTO findById(@PathParam("id") Long id) {
        return modeloService.findById(id);
    }

    @GET
    public List<ModeloResponseDTO> findAll() {
        return modeloService.findAll();
    }

    @POST
    public ModeloResponseDTO create(ModeloDTO dto) {
        return modeloService.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Long id, ModeloDTO dto) {
        modeloService.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        modeloService.delete(id);
    }
}

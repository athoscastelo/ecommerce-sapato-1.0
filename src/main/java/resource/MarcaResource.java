package resource;

import dto.MarcaDTO;
import dto.MarcaResponseDTO;
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
import service.MarcaService;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/marcas")
public class MarcaResource {

    @Inject
    public MarcaService marcaService;

    @GET
    @Path("/{id}")
    public MarcaResponseDTO findById(@PathParam("id") Long id) {
        return marcaService.findById(id);
    }

    @GET
    public List<MarcaResponseDTO> findAll() {
        return marcaService.findAll();
    }

    @POST
    public MarcaResponseDTO create(MarcaDTO dto) {
        return marcaService.create(dto);
    }

    @PUT
    @Path("/{id}")
    public MarcaResponseDTO update(@PathParam("id") Long id, MarcaDTO dto) {
        return marcaService.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        marcaService.delete(id);
    }
}

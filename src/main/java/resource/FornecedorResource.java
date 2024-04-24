package resource;

import dto.FornecedorDTO;
import dto.FornecedorResponseDTO;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import service.FornecedorService;

import java.util.List;

@Path("/fornecedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FornecedorResource {

    @Inject
    FornecedorService fornecedorService;

    @POST
    public Response create(FornecedorDTO dto) {
        return Response.status(Status.CREATED).entity(fornecedorService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public FornecedorResponseDTO update(@PathParam("id") Long id, @Valid FornecedorDTO fornecedorDTO) {
        return fornecedorService.update(id, fornecedorDTO);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        fornecedorService.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public FornecedorResponseDTO findById(@PathParam("id") Long id) {
        return fornecedorService.findById(id);
    }

    @GET
    public List<FornecedorResponseDTO> findAll() {
        return fornecedorService.findAll();
    }
}

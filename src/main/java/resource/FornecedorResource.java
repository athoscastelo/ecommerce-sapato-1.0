package resource;

import dto.FornecedorDTO;
import dto.FornecedorResponseDTO;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.FornecedorService;

import java.util.List;

@Path("/fornecedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FornecedorResource {

    @Inject
    FornecedorService fornecedorService;

    @POST
    public Response create(@Valid FornecedorDTO fornecedorDTO) {
        FornecedorResponseDTO responseDTO = fornecedorService.create(fornecedorDTO);
        return Response.status(Response.Status.CREATED).entity(responseDTO).build();
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

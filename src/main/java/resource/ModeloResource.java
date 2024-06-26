package resource;

import dto.ModeloDTO;
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
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import service.ModeloService;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/modelos")
public class ModeloResource {

    @Inject
    public ModeloService modeloService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(modeloService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(modeloService.findAll()).build();
    }

    @POST
    public Response create(ModeloDTO dto) {
        return Response.status(Status.CREATED).entity(modeloService.create(dto)).build();
    }


    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ModeloDTO dto) {
        modeloService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        modeloService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}

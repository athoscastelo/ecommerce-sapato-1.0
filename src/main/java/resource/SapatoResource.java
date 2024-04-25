package resource;

import dto.SapatoDTO;
import service.SapatoService;
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

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/sapatos")
public class SapatoResource {
    
    @Inject
    public SapatoService sapatoService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(sapatoService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(sapatoService.findAll()).build();
    }

    @POST
    public Response create(SapatoDTO dto) {
        return Response.status(Status.CREATED).entity(sapatoService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, SapatoDTO dto) {
        sapatoService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        sapatoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}

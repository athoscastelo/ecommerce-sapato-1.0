package resource;

import dto.CorDTO;
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
import service.CorService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cores")
public class CorResource {
    
    @Inject
    public CorService corService;
    
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(corService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(corService.findAll()).build();
    }

    @POST
    public Response create(CorDTO dto) {
        return Response.status(Status.CREATED).entity(corService.create(dto)).build();
    }


    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CorDTO dto) {
        corService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        corService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}



package resource;

import dto.ClienteDTO;
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
import service.ClienteService;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {


    @Inject
    public ClienteService ClienteService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(ClienteService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(ClienteService.findAll()).build();
    }

    @POST
    public Response create(ClienteDTO dto) {
        return Response.status(Status.CREATED).entity(ClienteService.create(dto)).build();
    }


    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ClienteDTO dto) {
        ClienteService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        ClienteService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}



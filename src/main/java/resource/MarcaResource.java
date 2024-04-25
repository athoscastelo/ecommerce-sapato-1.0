package resource;

import dto.MarcaDTO;
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
import service.MarcaService;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/marcas")
public class MarcaResource {

    @Inject
    public MarcaService MarcaService;

    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(MarcaService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(MarcaService.findAll()).build();
    }

    @POST
    public Response create(MarcaDTO dto) {
        return Response.status(Status.CREATED).entity(MarcaService.create(dto)).build();
    }


    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, MarcaDTO dto) {
        MarcaService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        MarcaService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}

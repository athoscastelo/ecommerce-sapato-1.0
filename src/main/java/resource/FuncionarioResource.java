package resource;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import dto.FuncionarioDTO;
import dto.form.ImageForm;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;
import service.FuncionarioFileServiceImpl;
import service.FuncionarioService;

@Path("/funcionarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FuncionarioResource {


    @Inject
    public FuncionarioService FuncionarioService;
    @Inject 
    public FuncionarioFileServiceImpl funcionarioFileServiceImpl;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(FuncionarioService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(FuncionarioService.findAll()).build();
    }

    @POST
    public Response create(FuncionarioDTO dto) {
        return Response.status(Status.CREATED).entity(FuncionarioService.create(dto)).build();
    }


    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, FuncionarioDTO dto) {
        FuncionarioService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        FuncionarioService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("/{id}/image/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@PathParam("id") Long id, @MultipartForm ImageForm form) {
        funcionarioFileServiceImpl.salvar(id, form.getNomeImagem(), form.getImagem());
        return Response.noContent().build();
    }

    @GET
    @Path("/image/download/{nomeImagem}")
    public Response download(@PathParam("nomeImagem") String nomeImagem){
        ResponseBuilder response = Response.ok(funcionarioFileServiceImpl.download(nomeImagem));
        response.header("Content-Disposition", "attachment;filename=" + nomeImagem);
        return response.build(); 

    }
    }




package resource;


import dto.UsuarioResponseDTO;
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
import service.FuncionarioService;
import service.HashService;
import service.JwtService;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {


    @Inject
    public FuncionarioService FuncionarioService;

    @Inject 
    public HashService hashService;

    @Inject
    public JwtService jwtService;



    public Response login (String email, String senha) {

        String hash = hashService.getHashSenha(dto.senha());

        UsuarioResponseDTO usuario = null;

        if (dto.email() == 1){
            FuncionarioService.login(dto.email(), hash);
        } else if (dto.email() == 2) {
            return Response.status(Status.NOT_FOUND).build();

        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
        return  Response.ok(usuario)
        .header("Authorization", jwtService.generateJwt(usuario))
        .build();
    }
}




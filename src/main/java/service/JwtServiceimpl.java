package service;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import dto.UsuarioResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JwtServiceimpl implements JwtService{

    private static final Duration EXPIRATION_TIME = Duration.ofHours(24);
    @Override
    public String generateJwt(UsuarioResponseDTO dto) {

        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME);

        Set<String> roles = new HashSet<String>();
        roles.add("Funcionário");


        return Jwt.issuer("unitins-jwt")
        .subject(dto.email())
        .groups(roles)
        .expiresAt(expiryDate)
        .sign();

    }
     
}

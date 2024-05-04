package repository;

import model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public Usuario findByUsername(String email) {
        return find("UPPER(username) = ?1", email).firstResult();
    }

}
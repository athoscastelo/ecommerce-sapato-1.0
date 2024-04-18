package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Marca;

@ApplicationScoped
public class MarcaRepository implements PanacheRepository<Marca> {

    public Marca findByNome(String nome) {
        return find("nome", nome).firstResult();
    }

    public Marca findById(Long id) {
        return find("id", id).firstResult();
    }
}


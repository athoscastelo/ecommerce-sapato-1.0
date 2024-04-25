package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Modelo;

import java.util.List;

@ApplicationScoped
public class ModeloRepository implements PanacheRepository<Modelo> {

    public List<Modelo> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }
}

package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Modelo;

import java.util.List;

@ApplicationScoped
public class ModeloRepository implements PanacheRepository<Modelo> {

    public List<Modelo> findByNome(String nome) {
        return list("nome", nome);
    }
    
    public Modelo findById(Long id) {
        return find("id", id).firstResult();
    }
}

package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Sapato;

import java.util.List;

@ApplicationScoped
public class SapatoRepository implements PanacheRepository<Sapato> {


    public List<Sapato> findByPreco(float preco) {
        return list("preco", preco);
    }

    public List<Sapato> findByEstoque(int estoque) {
        return list("estoque", estoque);
    }
}


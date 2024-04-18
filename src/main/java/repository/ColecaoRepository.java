package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Colecao;

import java.util.List;

@ApplicationScoped
public class ColecaoRepository implements PanacheRepository<Colecao> {

    public List<Colecao> findByColecaoNome(String nomeColecao) {
        return list("nome", nomeColecao);
    }
}


package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Cor;
import model.Sapato;

import java.util.List;

@ApplicationScoped
public class CorRepository implements PanacheRepository<Cor> {

    public List<Cor> findBySapato(Sapato sapato) {
        return list("sapato", sapato);
    }

    public Cor findByid(Long id) {
        return find("codigo", id).firstResult();
    }

}


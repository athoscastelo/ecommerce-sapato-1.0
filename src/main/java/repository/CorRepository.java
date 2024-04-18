
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

    public List<Cor> findAvailableColors() {
        return list("estoque > 0");
    }

    public List<Cor> findByTipoSapato(String tipoSapato) {
        return list("sapato.tipo = ?1", tipoSapato);
    }

    public void addColorToSapato(Cor cor, Sapato sapato) {
        sapato.setCor(cor);
        persist(cor);
    }

    public void removeColorFromSapato(Cor cor, Sapato sapato) {
        sapato.setCor(null); 
        persist(cor); 
    }
}


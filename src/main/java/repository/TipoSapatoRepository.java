
package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Sapato;
import model.TipoSapato;

import java.util.List;

@ApplicationScoped
public class TipoSapatoRepository implements PanacheRepository<TipoSapato> {

    public List<TipoSapato> findBySapato(Sapato sapato) {
        return list("sapato", sapato);
    }



}

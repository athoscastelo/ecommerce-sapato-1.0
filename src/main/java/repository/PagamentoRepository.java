package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Pagamento;

@ApplicationScoped
public class PagamentoRepository implements PanacheRepository<Pagamento> {
    
        public Pagamento findById(Long id) {
        return find("id", id).firstResult();
    }
}

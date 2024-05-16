package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Pedido;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido> {
    
        public Pedido findById(Long id) {
        return find("id", id).firstResult();
    }
}

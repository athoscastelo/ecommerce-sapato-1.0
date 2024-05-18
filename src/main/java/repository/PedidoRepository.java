package repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Pedido;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido> {
    

    public List<Pedido> findByCliente(Long idCliente) {
        return list("cliente.id", idCliente);
        
    }
    }


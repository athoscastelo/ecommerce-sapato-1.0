package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Fornecedor;


@ApplicationScoped
public class FornecedorRepository implements PanacheRepository<Fornecedor> {


    public Fornecedor findByid(Long id) {
        return find("codigo", id).firstResult();
    }



}

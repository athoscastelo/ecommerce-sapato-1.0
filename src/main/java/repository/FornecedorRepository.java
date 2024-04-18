package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Fornecedor;
import model.Sapato;

import java.util.List;

@ApplicationScoped
public class FornecedorRepository implements PanacheRepository<Fornecedor> {

    public List<Fornecedor> findByNome(String nome) {
        return list("nome", nome);
    }

    public Fornecedor findByCnpj(String cnpj) {
        return find("cnpj", cnpj).firstResult();
    }

    public Fornecedor findByid(Long id) {
        return find("codigo", id).firstResult();
    }

    public List<Fornecedor> findBySapato(Sapato sapato) {
        return find("sapato", sapato).list();
    }

}

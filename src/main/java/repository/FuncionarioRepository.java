package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Funcionario;
import java.util.List;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepository<Funcionario> {


    public List<Funcionario> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%"+ nome.toUpperCase() + "%").list();
    }

    public Funcionario findByEmailAndSenha(String email, String senha) {
        return find("(funcionario.usuario.email) = ?1 AND funcionario.usuario.senha = ?2 ", email, senha).firstResult();
    }

}
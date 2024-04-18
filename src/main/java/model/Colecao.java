package model;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Colecao {

    @Id
    private Long id;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    private String nome;
    private List<Sapato> sapatos;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Sapato> getSapatos() {
        return sapatos;
    }
    public void setSapatos(List<Sapato> sapatos) {
        this.sapatos = sapatos;
    }

}

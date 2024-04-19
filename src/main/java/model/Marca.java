package model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Marca extends DefaultEntity {
    
    @Id
    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

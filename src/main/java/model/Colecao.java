package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "colecao")
public class Colecao extends DefaultEntity {

    @Id
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "colecao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sapato> sapatos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

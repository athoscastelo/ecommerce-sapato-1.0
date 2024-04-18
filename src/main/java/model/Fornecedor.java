package model;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
@Entity
public class Fornecedor extends PanacheEntity {
    
    
    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public static Fornecedor findById(Long id) {
        return find("id", id).firstResult();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }}

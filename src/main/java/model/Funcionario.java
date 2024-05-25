package model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Entity
public class Funcionario extends DefaultEntity {
    
  
    @OneToOne
    @JoinColumn(name = "id_cliente", unique = true)
    private Cliente clientef;
    private String nomeImagem;
    
    public String getNomeImagem() {
        return nomeImagem;
    }
    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }
    public Cliente getClientef() {
        return clientef;
    }
    public void setClientef(Cliente clientef) {
        this.clientef = clientef;
    }
    private String cargo;

    
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }



}

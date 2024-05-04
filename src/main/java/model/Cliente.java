package model;


import jakarta.persistence.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Entity
public class Cliente extends Pessoa {
    

    private String cpf;

    @OneToOne
    @JoinColumn(name = "id_usuario", unique = true)
    private Usuario usuario;


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}

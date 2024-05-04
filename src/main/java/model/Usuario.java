package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Usuario extends DefaultEntity  {

    @Column(unique = true)
    private String email;
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

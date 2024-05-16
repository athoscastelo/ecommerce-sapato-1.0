package model;


import java.util.List;

import jakarta.persistence.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Cliente extends Pessoa {
    

    
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    @ManyToMany
    @JoinTable(
        name = "sapatos_favoritos",
        joinColumns = @JoinColumn(name = "cliente_id"),
        inverseJoinColumns = @JoinColumn(name = "sapato_id")
    )
    private List<Sapato> favoritos;

    @OneToOne
    @JoinColumn(name = "id_usuario", unique = true)
    private Usuario usuario;


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}

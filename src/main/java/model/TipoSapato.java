package model;

import jakarta.persistence.Entity;

@Entity
public class TipoSapato extends DefaultEntity {


    private String descricao;

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}

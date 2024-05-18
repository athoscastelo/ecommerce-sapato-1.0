package model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Item extends DefaultEntity{
    
    private Double preco;
    private Double desconto;
    private Integer qtd;
    @ManyToOne
    @JoinColumn(name = "sapato_id")
    private Sapato sapato;


    public Sapato getSapato() {
        return sapato;
    }
    public void setSapato(Sapato sapato) {
        this.sapato = sapato;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public Double getDesconto() {
        return desconto;
    }
    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
    public Integer getQtd() {
        return qtd;
    }
    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

}

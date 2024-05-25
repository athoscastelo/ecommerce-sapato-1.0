package model;

import jakarta.persistence.Entity;

@Entity
public class Pagamento extends DefaultEntity {

    private Double valorcompra;
    private String formapagamento;

    public Double getValorcompra() {
        return valorcompra;
    }
    public void setValorcompra(Double valorcompra) {
        this.valorcompra = valorcompra;
    }
    public String getFormapagamento() {
        return formapagamento;
    }
    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }


}
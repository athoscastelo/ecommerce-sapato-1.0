package model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Pagamento extends DefaultEntity {


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
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
package model;

import jakarta.persistence.Entity;

@Entity
public class Pagamento extends DefaultEntity {


    private Double valorcompra;
    private String formapagamento;
    private Long clienteid;
    private Long pedidoid;
    
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
    public Long getClienteid() {
        return clienteid;
    }
    public void setClienteid(Long clienteid) {
        this.clienteid = clienteid;
    }
    public Long getPedidoid() {
        return pedidoid;
    }
    public void setPedidoid(Long pedidoid) {
        this.pedidoid = pedidoid;
    }
    
}

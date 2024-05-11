package model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;

@Entity
public class Pedido extends DefaultEntity {
    
    
    private Pagamento pagamento;
    private LocalDateTime data;
    private StatusPedido status;
    private Double valorcompra;

    
    public Pagamento getPagamento() {
        return pagamento;
    }
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    public StatusPedido getStatus() {
        return status;
    }
    public void setStatus(StatusPedido status) {
        this.status = status;
    }
    public Double getValorcompra() {
        return valorcompra;
    }
    public void setValorcompra(Double valorcompra) {
        this.valorcompra = valorcompra;
    }


}

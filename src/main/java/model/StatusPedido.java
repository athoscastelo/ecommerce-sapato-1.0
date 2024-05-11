package model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusPedido {
    PAGO(1, "Pago"),
    PEDIDOS_SEPARACAO(2, "Pedidos em separação"),
    PAGAMENTO_PENDENTE(3, "Pagamento pendente"),
    ENVIADO(4, "Enviado"),
    CONCLUIDO(5, "Concluído"),
    CANCELADO(6, "Cancelado");
  
    private int id;
    private String descricao;

    StatusPedido(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public static StatusPedido valueOf(int id) {
        for (StatusPedido status : values()) {
            if (status.getId() == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("ID de status inválido: " + id);
    }
}

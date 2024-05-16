package dto;

import java.time.LocalDateTime;

import model.Pedido;
import model.StatusPedido;

public record PedidoResponseDTO(
    Long id,
    LocalDateTime data,
    StatusPedido status,
    Double valorcompra,
    String formapagamento
) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {
        return new PedidoResponseDTO(
            pedido.getId(),
            pedido.getData(),
            pedido.getStatus(),
            pedido.getPagamento().getValorcompra(), 
            pedido.getPagamento().getFormapagamento()
        );
    }
}

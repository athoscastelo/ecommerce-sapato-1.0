package dto;

import java.time.LocalDateTime;

import model.Pagamento;
import model.Pedido;
import model.StatusPedido;

public record PedidoResponseDTO(

    Long id,
    Pagamento pagamento,
    LocalDateTime data,
    StatusPedido status,
    Double valorcompra
) {
     public static PedidoResponseDTO valueOf(Pedido pedido) {
        return new PedidoResponseDTO(
            pedido.getId(),
            pedido.getPagamento(),
            pedido.getData(),
            pedido.getStatus(),
            pedido.getValorcompra()
        );
}  }

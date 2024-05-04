package dto;

import java.time.LocalDateTime;

import model.Pagamento;
import model.StatusPedido;

public record PedidoDTO(
    Pagamento pagamento,
    LocalDateTime data,
    StatusPedido status,
    Double valorcompra
) {
    
    
}

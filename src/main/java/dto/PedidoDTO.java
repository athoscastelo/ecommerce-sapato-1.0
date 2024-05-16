package dto;

import java.time.LocalDateTime;


public record PedidoDTO(
    Double valorcompra,
    String formapagamento,
    LocalDateTime data,
    Integer statusId
) {
    
    
}

package dto;

import java.time.LocalDateTime;
import java.util.List;


public record PedidoDTO(
    Double valorcompra,
    String formapagamento,
    LocalDateTime data,
    Integer statusId,
    List<ItemResponseDTO> itens,
    Long idCliente
) {
    
    
}

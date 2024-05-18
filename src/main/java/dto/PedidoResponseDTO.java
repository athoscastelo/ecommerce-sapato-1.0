package dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import model.Pedido;
import model.StatusPedido;

public record PedidoResponseDTO(
    Long id,
    LocalDateTime data,
    StatusPedido status,
    Double valorcompra,
    String formapagamento,
    List<ItemResponseDTO> itens
) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {
        return new PedidoResponseDTO(
            pedido.getId(),
            pedido.getData(),
            pedido.getStatus(),
            pedido.getPagamento().getValorcompra(),
            pedido.getPagamento().getFormapagamento(),
            pedido.getItens().stream()
                  .map(item -> new ItemResponseDTO(
                      item.getId(),
                      item.getPreco(),
                      item.getDesconto(),
                      item.getQtd(),
                      item.getSapato().getId()
                  ))
                  .collect(Collectors.toList())
        );
    }
}

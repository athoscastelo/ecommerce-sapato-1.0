package dto;

import model.Item;

public record ItemResponseDTO(
    Long id,
    Double preco,
    Double desconto,
    Integer quantidade,
    Long sapatoId
) {
    public static ItemResponseDTO valueOf(Item item) {
        return new ItemResponseDTO(
            item.getId(),
            item.getPreco(),
            item.getDesconto(),
            item.getQtd(),
            item.getSapato().getId()
        );
    }
}

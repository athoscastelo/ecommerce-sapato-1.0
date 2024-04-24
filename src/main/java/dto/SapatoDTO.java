package dto;



public record SapatoDTO (
    Double preco,
    Integer estoque,
    Integer valor_numeracao,
    Long fornecedorId,
    Long marcaId,
    Long corId,
    Long modeloId
) {}




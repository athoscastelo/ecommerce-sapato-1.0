package dto;



public record SapatoDTO (
    Double preco,
    Integer estoque,
    Integer valor_numeracao,
    Integer materialsapato_id,
    Integer cadarco_id,
    Long fornecedorId,
    Long marcaId,
    Long corId,
    Long modeloId
) {}




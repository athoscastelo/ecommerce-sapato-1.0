package dto;

import io.smallrye.common.constraint.NotNull;

public record SapatoDTO (
    @NotNull
    Double preco,
    @NotNull
    Integer estoque,
    @NotNull
    Integer valor_numeracao,
    @NotNull
    Integer materialsapato_id,
    @NotNull
    Integer cadarco_id,
    @NotNull
    Long fornecedorId,
    @NotNull
    Long marcaId,
    @NotNull
    Long corId,
    @NotNull
    Long modeloId
) {}




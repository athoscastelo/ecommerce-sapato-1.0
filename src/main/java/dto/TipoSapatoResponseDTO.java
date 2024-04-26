package dto;

import model.TipoSapato;

public record TipoSapatoResponseDTO (
    Long id,
    String descricao
) { 
    public static TipoSapatoResponseDTO valueOf(TipoSapato tiposapato) {
        return new TipoSapatoResponseDTO(
            tiposapato.getId(),
            tiposapato.getDescricao()
        );
    }
}
package dto;

import model.Cor;

public record CorResponseDTO (
    Long id,
    String nome
) { 
    public static CorResponseDTO valueOf(Cor cor) {
        return new CorResponseDTO(
            cor.getId(),
            cor.getNome()
        );
    }
}

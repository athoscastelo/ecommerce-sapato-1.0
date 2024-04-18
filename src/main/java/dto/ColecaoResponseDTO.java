package dto;

import model.Colecao;

public record ColecaoResponseDTO (
    Long id,
    String nome
) {
    public static ColecaoResponseDTO valueOf(Colecao colecao) {
        return new ColecaoResponseDTO(
            colecao.getId(),
            colecao.getNome()
        );
    }
}

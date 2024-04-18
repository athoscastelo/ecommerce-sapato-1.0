package dto;

import model.Modelo;

public record ModeloResponseDTO(
        Long id,
        String nome
) {
    public static ModeloResponseDTO valueOf(Modelo modelo) {
        return new ModeloResponseDTO(
                modelo.getId(),
                modelo.getNome()
        );
    }
}


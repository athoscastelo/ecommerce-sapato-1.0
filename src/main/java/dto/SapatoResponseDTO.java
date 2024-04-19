package dto;

import model.Sapato;

public record SapatoResponseDTO (
    Long id,
    FornecedorResponseDTO fornecedor,
    MarcaResponseDTO marca,
    CorResponseDTO cor,
    ModeloResponseDTO modelo
) { 
    public static SapatoResponseDTO valueOf(Sapato sapato) {
        return new SapatoResponseDTO(
            sapato.getId(),
            FornecedorResponseDTO.valueOf(sapato.getFornecedor()),
            MarcaResponseDTO.valueOf(sapato.getMarca()), 
            CorResponseDTO.valueOf(sapato.getCor()), 
            ModeloResponseDTO.valueOf(sapato.getModelo()) 
        );
    }
}





package dto;

import model.Sapato;
import model.Numeracao;

public record SapatoResponseDTO (
    Long id,
    Double preco,
    Integer estoque,
    Numeracao numeracao,
    FornecedorResponseDTO fornecedor,
    MarcaResponseDTO marca,
    CorResponseDTO cor,
    ModeloResponseDTO modelo
) { 
    public static SapatoResponseDTO valueOf(Sapato sapato) {
        return new SapatoResponseDTO(
            sapato.getId(),
            sapato.getPreco(),        
            sapato.getEstoque(),      
            sapato.getNumeracao(),
            FornecedorResponseDTO.valueOf(sapato.getFornecedor()),
            MarcaResponseDTO.valueOf(sapato.getMarca()), 
            CorResponseDTO.valueOf(sapato.getCor()), 
            ModeloResponseDTO.valueOf(sapato.getModelo()) 
        );
    }
}





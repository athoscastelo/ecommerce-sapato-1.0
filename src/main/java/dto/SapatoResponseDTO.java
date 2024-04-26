package dto;

import model.Sapato;
import model.CorCadarco;
import model.MaterialSapato;
import model.Numeracao;

public record SapatoResponseDTO (
    Long id,
    Double preco,
    Integer estoque,
    Numeracao numeracao,
    MaterialSapato materialsapato,
    CorCadarco cadarco,
    FornecedorResponseDTO fornecedor,
    MarcaResponseDTO marca,
    CorResponseDTO cor,
    ModeloResponseDTO modelo,
    TipoSapatoResponseDTO tiposapato
) { 
    public static SapatoResponseDTO valueOf(Sapato sapato) {
        return new SapatoResponseDTO(
            sapato.getId(),
            sapato.getPreco(),        
            sapato.getEstoque(),      
            sapato.getNumeracao(),
            sapato.getMaterialSapato(),
            sapato.getCadarco(),
            FornecedorResponseDTO.valueOf(sapato.getFornecedor()),
            MarcaResponseDTO.valueOf(sapato.getMarca()), 
            CorResponseDTO.valueOf(sapato.getCor()), 
            ModeloResponseDTO.valueOf(sapato.getModelo()) ,
            TipoSapatoResponseDTO.valueOf(sapato.getTiposapato())
        );
    }
}

package dto;

import model.Cor;
import model.Fornecedor;
import model.Marca;
import model.Modelo;
import model.Sapato;

public record SapatoResponseDTO (
    Long id,
    Fornecedor fornecedor,
    Marca marca,
    Cor cor,
    Modelo modelo
) { 
    public static SapatoResponseDTO valueOf(Sapato sapato) {
        return new SapatoResponseDTO(
            sapato.getId(),
            sapato.getFornecedor(),
            sapato.getMarca(), 
            sapato.getCor(), 
            sapato.getModelo() 
        );
    }
}





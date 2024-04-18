package dto;

import model.Sapato;

public record SapatoResponseDTO (
    Long id,
    float preco,
    int estoque,
    String fornecedor,
    String marca,
    String cor,
    String modelo

) { public static SapatoResponseDTO valueOf(Sapato sapato) {
    return new SapatoResponseDTO(
        sapato.getId(),
        sapato.getPreco(),
        sapato.getEstoque(),
        sapato.getFornecedor().getNome(),
        sapato.getMarca().getNome(), 
        sapato.getCor().getNome(), 
        sapato.getModelo().getNome() 
    );
}}





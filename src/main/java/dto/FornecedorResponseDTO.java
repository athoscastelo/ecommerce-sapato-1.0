package dto;

import model.Fornecedor;

public record FornecedorResponseDTO (
    Long id,
    String nome,
    String cnpj,
    String endereco,
    String telefone
) {
    public static FornecedorResponseDTO valueOf(Fornecedor fornecedor) {
        return new FornecedorResponseDTO(
            fornecedor.getId(),
            fornecedor.getNome(),
            fornecedor.getCnpj(),
            fornecedor.getEndereco(),
            fornecedor.getTelefone()
        );
    }
}

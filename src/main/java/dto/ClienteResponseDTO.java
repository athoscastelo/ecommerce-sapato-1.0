package dto;

import model.Cliente;

public record ClienteResponseDTO (
    Long id,
    String nome,
    String email,
    String senha,
    String cpf,
    String datanascimento
) {
    public static ClienteResponseDTO valueOf(Cliente cliente) {
        return new ClienteResponseDTO(
            cliente.getId(),
            cliente.getNome(),
            cliente.getCpf(),
            cliente.getEmail(),
            cliente.getSenha(),
            cliente.getDataNascimento()
        );
    }
}
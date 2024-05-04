package dto;


import model.Cliente;

public record ClienteResponseDTO (
    Long id,
    String nome,
    String cpf,
    String datanascimento,
    String telefone,
    String endereco

) {
    public static ClienteResponseDTO valueOf(Cliente cliente) {

        return new ClienteResponseDTO(
            cliente.getId(),
            cliente.getNome(),
            cliente.getCpf(),
            cliente.getDataNascimento(),
            cliente.getTelefone(),
            cliente.getEndereco()
            

        );
    }
}
package dto;

import java.util.List;
import java.util.stream.Collectors;

import model.Cliente;

public record ClienteResponseDTO(
    Long id,
    String nome,
    String cpf,
    String dataNascimento,
    String telefone,
    String endereco,
    String username,
    String email,
    List<PedidoResponseDTO> pedidos
) {
    public static ClienteResponseDTO valueOf(Cliente cliente) {
        return new ClienteResponseDTO(
            cliente.getId(),
            cliente.getNome(),
            cliente.getCpf(),
            cliente.getDataNascimento(),
            cliente.getTelefone(),
            cliente.getEndereco(),
            cliente.getUsuario().getUsername(),
            cliente.getUsuario().getEmail(),
            cliente.getPedidos().stream()
                  .map(PedidoResponseDTO::valueOf)
                  .collect(Collectors.toList())
        );
    }
}


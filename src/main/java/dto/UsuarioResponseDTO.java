package dto;

import model.Cliente;

public record UsuarioResponseDTO(
    String email,
    String username,
    String nome
) {
    public static UsuarioResponseDTO valueOf (Cliente cliente){
        return new UsuarioResponseDTO(
            cliente.getUsuario().getEmail(),
            cliente.getUsuario().getUsername(),
            cliente.getNome());
    }
}
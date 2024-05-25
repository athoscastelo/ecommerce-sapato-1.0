package dto;

import model.Funcionario;

public record FuncionarioResponseDTO (
    Long id,
    String nome,
    String cpf,
    String datanascimento,
    String cargo,
    String endereco,
    String telefone,
    String email,
    String senha,
    String nomeImagem
) {
    public static FuncionarioResponseDTO valueOf(Funcionario funcionario) {
        return new FuncionarioResponseDTO(
            funcionario.getId(),
            funcionario.getClientef().getNome(),
            funcionario.getClientef().getCpf(),
            funcionario.getClientef().getDataNascimento(),
            funcionario.getCargo(),
            funcionario.getClientef().getEndereco(),
            funcionario.getClientef().getTelefone(),
            funcionario.getClientef().getUsuario().getEmail(),
            funcionario.getClientef().getUsuario().getSenha(),
            funcionario.getNomeImagem()

        );
    }
}
package dto;

import model.Funcionario;

public record FuncionarioResponseDTO (
    Long id,
    String nome,
    String email,
    String senha,
    String cpf,
    String datanascimento,
    String cargo,
    String endereco,
    String telefone
) {
    public static FuncionarioResponseDTO valueOf(Funcionario funcionario) {
        return new FuncionarioResponseDTO(
            funcionario.getId(),
            funcionario.getNome(),
            funcionario.getCpf(),
            funcionario.getEmail(),
            funcionario.getSenha(),
            funcionario.getDataNascimento(),
            funcionario.getCargo(),
            funcionario.getEndereco(),
            funcionario.getTelefone()

        );
    }
}
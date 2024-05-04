package dto;


import model.Pessoa;

public record PessoaResponseDTO(
    Long id,
    String nome,
    String dataNascimento,
    String telefone,
    String endereco
) {
    public static PessoaResponseDTO valueOf(Pessoa pessoa) {
        return new PessoaResponseDTO(
            pessoa.getId(),
            pessoa.getNome(),
            pessoa.getDataNascimento(),
            pessoa.getTelefone(),
            pessoa.getEndereco()
            
            );
    }
    
}
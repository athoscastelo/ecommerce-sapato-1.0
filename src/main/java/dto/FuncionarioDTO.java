package dto;
import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FuncionarioDTO(
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(min = 2, max = 60, message = "O tamanho do nome deve ser entre 2 e 60 caracteres.")
    String nome,
    @NotNull
    String cpf,
    @NotNull
    String endereco,
    @NotNull
    String datanascimento,
    @NotNull
    String telefone,
    @NotNull
    String cargo,
    String email,
    String senha

) {
 }

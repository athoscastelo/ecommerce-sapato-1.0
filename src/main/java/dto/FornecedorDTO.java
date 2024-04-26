package dto;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;

public record FornecedorDTO (
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    String nome,
    @NotNull
    String cnpj,
    String endereco,
    String telefone
) {}

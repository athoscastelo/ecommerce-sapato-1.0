package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TipoSapatoDTO (
    @NotBlank(message = "A descrição não pode ser nula ou vazia")
    @Size(min = 2, max = 60, message = "O tamanho do nome deve ser entre 2 e 60 caracteres.")
    String descricao
) {}

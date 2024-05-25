package dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import model.Pedido;

public record ClienteDTO(
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(min = 2, max = 60, message = "O tamanho do nome deve ser entre 2 e 60 caracteres.")
    String nome,

    @NotNull(message = "O CPF não pode ser nulo")
    String cpf,

    @NotNull(message = "A data de nascimento não pode ser nula")
    String dataNascimento,

    String telefone,
    String endereco,

    @NotBlank(message = "O nome de usuário não pode ser nulo ou vazio")
    String username,

    @NotBlank(message = "O email não pode ser nulo ou vazio")
    String email,

    @NotBlank(message = "A senha não pode ser nula ou vazia")
    String senha,
    List<Pedido> pedidos
) {}

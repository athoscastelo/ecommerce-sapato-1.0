package dto;

import model.Cor;
import model.Fornecedor;
import model.Marca;
import model.Modelo;
import model.Numeracao;

public record SapatoDTO (
    Long id,
    Numeracao numeracao,
    Fornecedor fornecedorId,
    Marca marcaId,
    Cor corId,
    Modelo modeloId
) {}




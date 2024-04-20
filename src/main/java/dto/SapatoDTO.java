package dto;

import model.Cor;
import model.Fornecedor;
import model.Marca;
import model.Modelo;

public record SapatoDTO (
    Long numeracaoId,
    Fornecedor fornecedorId,
    Marca marcaId,
    Cor corId,
    Modelo modeloId
) {}




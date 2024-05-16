package dto;

import model.Pagamento;

public record PagamentoResponseDTO(
    Long id,
    Double valorcompra,
    String formapagamento
) {
    public static PagamentoResponseDTO valueOf(Pagamento pagamento) {
        return new PagamentoResponseDTO(
            pagamento.getId(),
            pagamento.getValorcompra(),
            pagamento.getFormapagamento()
        );
    }
}

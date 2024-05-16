package service;

import dto.PagamentoDTO;
import dto.PagamentoResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.Pagamento;
import repository.PagamentoRepository;
import java.util.List;


@ApplicationScoped
public class PagamentoServiceimpl implements PagamentoService {


    @Inject
    private PagamentoRepository pagamentoRepository;


    @Override
    @Transactional
    public PagamentoResponseDTO create(@Valid PagamentoDTO dto) {
        Pagamento pagamento = new Pagamento();
        pagamento.setValorcompra(dto.valorcompra());
        pagamento.setFormapagamento(dto.formapagamento());
        pagamentoRepository.persist(pagamento);
        return PagamentoResponseDTO.valueOf(pagamento);
    }
    @Override
    @Transactional
    public void update(Long id, @Valid PagamentoDTO dto) {
        Pagamento pagamento = pagamentoRepository.findById(id);
        pagamento.setValorcompra(dto.valorcompra());
        pagamento.setFormapagamento(dto.formapagamento());
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        pagamentoRepository.deleteById(id);
    }
    
    
    
    @Override
    public PagamentoResponseDTO findById(Long id) {
        return PagamentoResponseDTO.valueOf(pagamentoRepository.findById(id));
    }
    
    
    @Override
    public List<PagamentoResponseDTO> findAll() {
        return pagamentoRepository
        .listAll()
        .stream()
        .map(e -> PagamentoResponseDTO.valueOf(e)).toList();
    }
    
    
}

package service;

import dto.PedidoDTO;
import dto.PedidoResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.Pagamento;
import model.Pedido;
import model.StatusPedido;
import repository.PagamentoRepository;
import repository.PedidoRepository;
import java.util.List;
import java.util.stream.Collectors;


@ApplicationScoped
public class PedidoServiceimpl implements PedidoService {

    @Inject
    private PedidoRepository pedidoRepository;

    @Inject
    private PagamentoRepository pagamentoRepository;

    @Override
    @Transactional
    public PedidoResponseDTO create(@Valid PedidoDTO dto) {
        // Cria um novo pagamento
        Pagamento pagamento = new Pagamento();
        pagamento.setValorcompra(dto.valorcompra());
        pagamento.setFormapagamento(dto.formapagamento());
        pagamentoRepository.persist(pagamento);

        // Cria um novo pedido e associa o pagamento
        Pedido pedido = new Pedido();
        pedido.setData(dto.data());
        pedido.setStatus(StatusPedido.valueOf(dto.statusId()));
        pedido.setPagamento(pagamento);
        pedidoRepository.persist(pedido);

        return PedidoResponseDTO.valueOf(pedido);
    }


    @Override
    @Transactional
    public void update(Long id, @Valid PedidoDTO dto) {
        
                Pagamento pagamento = new Pagamento();
                pagamento.setValorcompra(dto.valorcompra());
                pagamento.setFormapagamento(dto.formapagamento());
        
                Pedido pedido = new Pedido();
                pedido.setData(dto.data());
                pedido.setStatus(StatusPedido.valueOf(dto.statusId()));
                pedido.setPagamento(pagamento);
                
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }
    
    
    
    @Override
    public PedidoResponseDTO findById(Long id) {
        return PedidoResponseDTO.valueOf(pedidoRepository.findById(id));
    }
    
    
    @Override
    public List<PedidoResponseDTO> findAll() {
        return pedidoRepository
        .listAll()
        .stream()
        .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

      @Override
    public List<PedidoResponseDTO> findByCliente(Long id) {
        
        List<Pedido> pedidos = (List<Pedido>) pedidoRepository.findByCliente(id);
        return pedidos.stream()
                .map(PedidoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }
    
    
}

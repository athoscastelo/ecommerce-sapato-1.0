package service;

import java.util.List;

import dto.PedidoDTO;
import dto.PedidoResponseDTO;
import jakarta.validation.Valid;

public interface PedidoService {
    
    PedidoResponseDTO create(@Valid PedidoDTO dto);

    void update(Long id, @Valid PedidoDTO dto);

    void delete(Long id);

    PedidoResponseDTO findById(Long id);

    List<PedidoResponseDTO> findAll();

    List<PedidoResponseDTO> findByCliente (Long id);
}

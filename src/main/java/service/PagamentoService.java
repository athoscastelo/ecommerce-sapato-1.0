package service;

import java.util.List;

import dto.PagamentoDTO;
import dto.PagamentoResponseDTO;
import jakarta.validation.Valid;

public interface PagamentoService {
    
    PagamentoResponseDTO create(@Valid PagamentoDTO dto);

    void update(Long id, @Valid PagamentoDTO dto);

    void delete(Long id);

    PagamentoResponseDTO findById(Long id);

    List<PagamentoResponseDTO> findAll();
}

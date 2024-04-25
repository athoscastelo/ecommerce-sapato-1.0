package service;

import dto.CorDTO;
import dto.CorResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface CorService {

    CorResponseDTO create(@Valid CorDTO dto);

    void update(Long id, @Valid CorDTO dto);

    void delete(Long id);

    CorResponseDTO findById(Long id);

    List<CorResponseDTO> findAll();
}

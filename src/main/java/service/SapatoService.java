package service;

import dto.SapatoDTO;
import dto.SapatoResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface SapatoService {

    SapatoResponseDTO create(@Valid SapatoDTO dto);

    void update(Long id, SapatoDTO dto);

    void delete(Long id);

    SapatoResponseDTO findById(Long id);

    List<SapatoResponseDTO> findAll();
}



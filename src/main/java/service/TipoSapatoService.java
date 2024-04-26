package service;

import dto.TipoSapatoDTO;
import dto.TipoSapatoResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface TipoSapatoService {

    TipoSapatoResponseDTO create(@Valid TipoSapatoDTO dto);

    void update(Long id, @Valid TipoSapatoDTO dto);

    void delete(Long id);

    TipoSapatoResponseDTO findById(Long id);

    List<TipoSapatoResponseDTO> findAll();
}

package service;

import dto.MarcaDTO;
import dto.MarcaResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface MarcaService {

    MarcaResponseDTO create(@Valid MarcaDTO dto);

    void update(Long id, @Valid MarcaDTO dto);

    void delete(Long id);

    MarcaResponseDTO findById(Long id);

    List<MarcaResponseDTO> findAll();
}

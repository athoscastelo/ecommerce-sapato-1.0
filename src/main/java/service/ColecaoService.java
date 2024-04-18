package service;

import dto.ColecaoDTO;
import dto.ColecaoResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface ColecaoService {

    ColecaoResponseDTO create(@Valid ColecaoDTO dto);

    ColecaoResponseDTO update(Long id, @Valid ColecaoDTO dto);

    void delete(Long id);

    ColecaoResponseDTO findById(Long id);

    List<ColecaoResponseDTO> findAll();
}

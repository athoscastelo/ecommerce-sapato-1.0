package service;

import dto.FornecedorDTO;
import dto.FornecedorResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface FornecedorService {

    FornecedorResponseDTO create(@Valid FornecedorDTO dto);

    FornecedorResponseDTO update(Long id, @Valid FornecedorDTO dto);

    void delete(Long id);

    FornecedorResponseDTO findById(Long id);

    List<FornecedorResponseDTO> findAll();
}

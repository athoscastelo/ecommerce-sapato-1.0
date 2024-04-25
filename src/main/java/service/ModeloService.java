package service;

import dto.ModeloDTO;
import dto.ModeloResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface ModeloService {

ModeloResponseDTO create(@Valid ModeloDTO dto);

 void update(Long id, @Valid ModeloDTO dto);

 void delete(Long id);

 ModeloResponseDTO findById(Long id);

 List<ModeloResponseDTO> findAll();
}


package service;

import dto.FuncionarioDTO;
import dto.FuncionarioResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface FuncionarioService  {

    FuncionarioResponseDTO create(@Valid FuncionarioDTO dto);
    

    void update(Long id, @Valid FuncionarioDTO dto);

    void delete(Long id);

    FuncionarioResponseDTO findById(Long id);

    List<FuncionarioResponseDTO> findAll();
}

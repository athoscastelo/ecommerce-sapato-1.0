package service;

import dto.FuncionarioDTO;
import dto.FuncionarioResponseDTO;
import dto.UsuarioResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface FuncionarioService  {

    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto);

    public void update(Long id, @Valid FuncionarioDTO dto);

    public void delete(Long id);

    public FuncionarioResponseDTO findById(Long id);

    public List<FuncionarioResponseDTO> findAll();

    public  UsuarioResponseDTO login(String email, String senha);

}

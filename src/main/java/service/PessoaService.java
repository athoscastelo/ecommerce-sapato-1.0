package service;

import java.util.List;

import dto.PessoaDTO;
import dto.PessoaResponseDTO;
import jakarta.validation.Valid;

public interface PessoaService {

    public PessoaResponseDTO create(@Valid PessoaDTO dto);

    public void update(Long id, PessoaDTO dto);

    public void delete(Long id);

    public PessoaResponseDTO findById(Long id);

    public List<PessoaResponseDTO> findAll();

    public List<PessoaResponseDTO> findByNome(String nome);
}

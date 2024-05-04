package service;

import java.util.List;

import dto.PessoaDTO;
import dto.PessoaResponseDTO;
import model.Pessoa;

import repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class PessoaServiceimpl implements PessoaService {

    @Inject
    public PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public PessoaResponseDTO create(@Valid PessoaDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.nome());
        pessoa.setDataNascimento(dto.dataNascimento());
        pessoa.setTelefone(dto.telefone());
        pessoa.setEndereco(dto.endereco());

        pessoaRepository.persist(pessoa);
        return PessoaResponseDTO.valueOf(pessoa);
    }

    @Override
    @Transactional
    public void update(Long id, PessoaDTO dto) {
        Pessoa pessoa =  pessoaRepository.findById(id);

        pessoa.setNome(dto.nome());
        pessoa.setDataNascimento(dto.dataNascimento());
        pessoa.setTelefone(dto.telefone());
        pessoa.setEndereco(dto.endereco());

    }

    @Override
    @Transactional
    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    public PessoaResponseDTO findById(Long id) {
        return PessoaResponseDTO.valueOf(pessoaRepository.findById(id));
    }

    @Override
    public List<PessoaResponseDTO> findAll() {
        return pessoaRepository
        .listAll()
        .stream()
        .map(e -> PessoaResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PessoaResponseDTO> findByNome(String nome) {
        return pessoaRepository.findByNome(nome).stream()
        .map(e -> PessoaResponseDTO.valueOf(e)).toList();
    }

}

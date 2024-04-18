package service;

import dto.FornecedorDTO;
import dto.FornecedorResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.Fornecedor;
import repository.FornecedorRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class FornecedorServiceimpl implements FornecedorService {

    @Inject
    private FornecedorRepository fornecedorRepository;

    @Override
    @Transactional
    public FornecedorResponseDTO create(@Valid FornecedorDTO dto) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(dto.nome());
        fornecedor.setCnpj(dto.cnpj());
        fornecedor.setEndereco(dto.endereco());
        fornecedor.setTelefone(dto.telefone());

        fornecedorRepository.persist(fornecedor);

        return FornecedorResponseDTO.valueOf(fornecedor);
    }

    @Override
    @Transactional
    public FornecedorResponseDTO update(Long id, @Valid FornecedorDTO dto) {
        Fornecedor fornecedor = fornecedorRepository.findById(id);
        if (fornecedor == null) {
            throw new IllegalArgumentException("Fornecedor não encontrado com o ID: " + id);
        }
        fornecedor.setNome(dto.nome());
        fornecedor.setCnpj(dto.cnpj());
        fornecedor.setEndereco(dto.endereco());
        fornecedor.setTelefone(dto.telefone());

        return FornecedorResponseDTO.valueOf(fornecedor);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id);
        if (fornecedor == null) {
            throw new IllegalArgumentException("Fornecedor não encontrado com o ID: " + id);
        }
        fornecedorRepository.delete(fornecedor);
    }

    @Override
    public FornecedorResponseDTO findById(Long id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id);
        return fornecedor != null ? FornecedorResponseDTO.valueOf(fornecedor) : null;
    }

    @Override
    public List<FornecedorResponseDTO> findAll() {
        List<Fornecedor> fornecedores = fornecedorRepository.listAll();
        return fornecedores.stream().map(FornecedorResponseDTO::valueOf).collect(Collectors.toList());
    }
}

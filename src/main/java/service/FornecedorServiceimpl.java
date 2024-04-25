package service;

import dto.FornecedorDTO;
import dto.FornecedorResponseDTO;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.Fornecedor;
import repository.FornecedorRepository;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class FornecedorServiceimpl implements FornecedorService {

    @Inject
    private FornecedorRepository FornecedorRepository;

    @Override
    @Transactional
    public FornecedorResponseDTO create(@Valid FornecedorDTO dto) {
        Fornecedor Fornecedor = new Fornecedor();
        Fornecedor.setNome(dto.nome());
        Fornecedor.setCnpj(dto.cnpj());
        Fornecedor.setEndereco(dto.endereco());
        Fornecedor.setTelefone(dto.telefone());

        FornecedorRepository.persist(Fornecedor);
        return FornecedorResponseDTO.valueOf(Fornecedor);
    }
    
    @Override
    @Transactional
    public void update(Long id, @Valid FornecedorDTO dto) {
        Fornecedor Fornecedor = FornecedorRepository.findById(id);
        if (Fornecedor == null) {
            throw new IllegalArgumentException("Fornecedor não encontrada com o ID: " + id);
        }
        Fornecedor.setNome(dto.nome());
        Fornecedor.setCnpj(dto.cnpj());
        Fornecedor.setEndereco(dto.endereco());
        Fornecedor.setTelefone(dto.telefone());
        }
    
    @Override
    @Transactional
    public void delete(Long id) {
        Fornecedor Fornecedor = FornecedorRepository.findById(id);
        if (Fornecedor == null) {
            throw new IllegalArgumentException("Fornecedor não encontrada com o ID: " + id);
        }
        FornecedorRepository.delete(Fornecedor); 
    }
    

    @Override
    public FornecedorResponseDTO findById(Long id) {
        Fornecedor Fornecedor = FornecedorRepository.findById(id);
        return Fornecedor != null ? FornecedorResponseDTO.valueOf(Fornecedor) : null;
    }

    @Override
    public List<FornecedorResponseDTO> findAll() {
        PanacheQuery<Fornecedor> Fornecedors = FornecedorRepository.findAll();
        return Fornecedors.stream()
                .map(FornecedorResponseDTO::valueOf)
                .collect(Collectors.toList());
    }
}



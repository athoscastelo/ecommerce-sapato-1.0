package service;

import dto.FuncionarioDTO;
import dto.FuncionarioResponseDTO;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.Funcionario;
import repository.FuncionarioRepository;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class FuncionarioServiceimpl implements FuncionarioService {

    @Inject
    private FuncionarioRepository FuncionarioRepository;

    @Override
    @Transactional
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto) {
        Funcionario Funcionario = new Funcionario();
        Funcionario.setNome(dto.nome());
        Funcionario.setCpf(dto.cpf());
        Funcionario.setEmail(dto.email());
        Funcionario.setSenha(dto.senha());
        Funcionario.setDataNascimento(dto.datanascimento());
        Funcionario.setCargo(dto.cargo());
        Funcionario.setTelefone(dto.telefone());;
        Funcionario.setEndereco(dto.endereco());

        FuncionarioRepository.persist(Funcionario);
        return FuncionarioResponseDTO.valueOf(Funcionario);
    }
    
    @Override
    @Transactional
    public void update(Long id, @Valid FuncionarioDTO dto) {
        Funcionario Funcionario = FuncionarioRepository.findById(id);
        if (Funcionario == null) {
            throw new IllegalArgumentException("Funcionario não encontrado com o ID: " + id);

        }
        Funcionario.setNome(dto.nome());
        Funcionario.setCpf(dto.cpf());
        Funcionario.setEmail(dto.email());
        Funcionario.setSenha(dto.senha());
        Funcionario.setDataNascimento(dto.datanascimento());
        Funcionario.setCargo(dto.cargo());
        Funcionario.setTelefone(dto.telefone());;
        Funcionario.setEndereco(dto.endereco());
            
        }
    
    @Override
    @Transactional
    public void delete(Long id) {
        Funcionario Funcionario = FuncionarioRepository.findById(id);
        if (Funcionario == null) {
            throw new IllegalArgumentException("Funcionario não encontrado com o ID: " + id);
        }
        FuncionarioRepository.delete(Funcionario); 
    }
    

    @Override
    public FuncionarioResponseDTO findById(Long id) {
        Funcionario Funcionario = FuncionarioRepository.findById(id);
        return Funcionario != null ? FuncionarioResponseDTO.valueOf(Funcionario) : null;
    }

    @Override
    public List<FuncionarioResponseDTO> findAll() {
        PanacheQuery<Funcionario> Funcionarios = FuncionarioRepository.findAll();
        return Funcionarios.stream()
                .map(FuncionarioResponseDTO::valueOf)
                .collect(Collectors.toList());
    }
}



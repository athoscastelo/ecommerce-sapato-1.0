package service;

import dto.FuncionarioDTO;
import dto.FuncionarioResponseDTO;
import dto.UsuarioResponseDTO;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.Cliente;
import model.Funcionario;
import model.Usuario;
import repository.ClienteRepository;
import repository.FuncionarioRepository;
import repository.UsuarioRepository;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class FuncionarioServiceimpl implements FuncionarioService {

    @Inject
    private FuncionarioRepository FuncionarioRepository;

    @Inject
    private UsuarioRepository usuarioRepository;

    @Inject
    private ClienteRepository clienteRepository;

    @Inject
    public HashService hashService;

    @Override
    @Transactional
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto) {


        Usuario usuario = new Usuario();
        usuario.setEmail(dto.email());
        // gerando o hash da senha
        usuario.setSenha(hashService.getHashSenha(dto.senha()));

        usuarioRepository.persist(usuario);
      
        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        cliente.setEndereco(dto.endereco());
        cliente.setTelefone(dto.telefone());
        cliente.setDataNascimento(dto.datanascimento());
        cliente.setUsuario(usuario);
        cliente.setCpf(dto.cpf());

        // salvando pessoa fisica
        clienteRepository.persist(cliente);

        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(dto.cargo());
        funcionario.setClientef(cliente);
        // salvando o funcionario
        FuncionarioRepository.persist(funcionario);

        return FuncionarioResponseDTO.valueOf(funcionario);
    }

    @Override
    @Transactional
    public void update(Long id, @Valid FuncionarioDTO dto) {
        Funcionario Funcionario = FuncionarioRepository.findById(id);
        if (Funcionario == null) {
            throw new IllegalArgumentException("Funcionario não encontrado com o ID: " + id);

        }

        Usuario usuario = new Usuario();
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
      
        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        cliente.setEndereco(dto.endereco());
        cliente.setTelefone(dto.telefone());
        cliente.setDataNascimento(dto.datanascimento());
        cliente.setUsuario(usuario);
        cliente.setCpf(dto.cpf());

        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(dto.cargo());
        funcionario.setClientef(cliente);

            
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

    public UsuarioResponseDTO login (String email, String senha) {

        Funcionario funcionario = FuncionarioRepository.findByEmailAndSenha(email, senha);
        return  UsuarioResponseDTO.valueOf(funcionario.getClientef());
    }
}



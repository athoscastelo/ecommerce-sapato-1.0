package service;

import dto.ClienteDTO;
import dto.ClienteResponseDTO;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.Cliente;
import repository.ClienteRepository;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClienteServiceimpl implements ClienteService {

    @Inject
    private ClienteRepository ClienteRepository;

    @Override
    @Transactional
    public ClienteResponseDTO create(@Valid ClienteDTO dto) {
        Cliente Cliente = new Cliente();
        Cliente.setNome(dto.nome());
        Cliente.setCpf(dto.cpf());
        Cliente.setEmail(dto.email());
        Cliente.setSenha(dto.senha());
        Cliente.setDataNascimento(dto.datanascimento());


        ClienteRepository.persist(Cliente);
        return ClienteResponseDTO.valueOf(Cliente);
    }
    
    @Override
    @Transactional
    public void update(Long id, @Valid ClienteDTO dto) {
        Cliente Cliente = ClienteRepository.findById(id);
        if (Cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado com o ID: " + id);
        }
        Cliente.setNome(dto.nome());
        Cliente.setCpf(dto.cpf());
        Cliente.setEmail(dto.email());
        Cliente.setSenha(dto.senha());
        Cliente.setDataNascimento(dto.datanascimento());
        }
    
    @Override
    @Transactional
    public void delete(Long id) {
        Cliente Cliente = ClienteRepository.findById(id);
        if (Cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado com o ID: " + id);
        }
        ClienteRepository.delete(Cliente); 
    }
    

    @Override
    public ClienteResponseDTO findById(Long id) {
        Cliente Cliente = ClienteRepository.findById(id);
        return Cliente != null ? ClienteResponseDTO.valueOf(Cliente) : null;
    }

    @Override
    public List<ClienteResponseDTO> findAll() {
        PanacheQuery<Cliente> Clientes = ClienteRepository.findAll();
        return Clientes.stream()
                .map(ClienteResponseDTO::valueOf)
                .collect(Collectors.toList());
    }
}



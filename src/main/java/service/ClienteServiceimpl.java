package service;

import dto.ClienteDTO;
import dto.ClienteResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.Cliente;
import repository.ClienteRepository;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ClienteServiceimpl implements ClienteService {

    @Inject
    public ClienteRepository clienteRepository;

    @Override
    @Transactional
    public ClienteResponseDTO create(@Valid ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setCpf(dto.cpf());

        clienteRepository.persist(cliente);
        return ClienteResponseDTO.valueOf(cliente);
    }

    @Override
    @Transactional
    public void update(Long id, ClienteDTO dto) {
        Cliente cliente =  clienteRepository.findById(id);

        cliente.setCpf(dto.cpf());

        }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
        return ClienteResponseDTO.valueOf(clienteRepository.findById(id));
    }

    @Override
    public List<ClienteResponseDTO> findAll() {
        return clienteRepository
        .listAll()
        .stream()
        .map(e -> ClienteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ClienteResponseDTO> findByNome(String nome) {
        return clienteRepository.findByNome(nome).stream()
        .map(e -> ClienteResponseDTO.valueOf(e)).toList();
    }
}
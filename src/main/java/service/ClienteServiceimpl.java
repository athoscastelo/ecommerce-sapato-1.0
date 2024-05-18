package service;

import dto.ClienteDTO;
import dto.ClienteResponseDTO;
import dto.PedidoResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.Cliente;
import model.Pedido;
import model.Usuario;
import repository.ClienteRepository;
import repository.PedidoRepository;
import repository.SapatoRepository;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClienteServiceimpl implements ClienteService {
 

    @Inject
    public ClienteRepository clienteRepository;

    @Inject
    public PedidoRepository pedidoRepository;

    @Inject
    public SapatoRepository sapatoRepository;

    @Override
    @Transactional
    public ClienteResponseDTO create(@Valid ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        cliente.setEndereco(dto.endereco());
        cliente.setTelefone(dto.telefone());
        cliente.setDataNascimento(dto.dataNascimento());
        cliente.setCpf(dto.cpf());

        // Criar o usuário do cliente
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.username());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        cliente.setUsuario(usuario);

        // Persistir o cliente
        clienteRepository.persist(cliente);

        return ClienteResponseDTO.valueOf(cliente);
    }

    @Override
    @Transactional
    public void update(Long id, @Valid ClienteDTO dto) {
        Cliente cliente = clienteRepository.findById(id);
        if (cliente != null) {
            cliente.setNome(dto.nome());
            cliente.setEndereco(dto.endereco());
            cliente.setTelefone(dto.telefone());
            cliente.setDataNascimento(dto.dataNascimento());
            cliente.setCpf(dto.cpf());

            // Atualizar o usuário do cliente
            Usuario usuario = cliente.getUsuario();
            if (usuario != null) {
                usuario.setUsername(dto.username());
                usuario.setEmail(dto.email());
                usuario.setSenha(dto.senha());
            }
        }
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
            .map(ClienteResponseDTO::valueOf)
            .collect(Collectors.toList());
    }

    @Override
    public List<PedidoResponseDTO> findPedidosByCliente(Long idCliente) {
        List<Pedido> pedidos = pedidoRepository.findByCliente(idCliente);
        return pedidos.stream()
                      .map(PedidoResponseDTO::valueOf)
                      .collect(Collectors.toList());
    }

    @Override
public List<ClienteResponseDTO> findByNome(String nome) {
    List<Cliente> clientes = clienteRepository.findByNome(nome);
    return clientes.stream()
                  .map(ClienteResponseDTO::valueOf)
                  .collect(Collectors.toList());
}

}

package service;

import dto.ClienteDTO;
import dto.ClienteResponseDTO;
import dto.PedidoResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface ClienteService  {

    ClienteResponseDTO create(@Valid ClienteDTO dto);

    void update(Long id, @Valid ClienteDTO dto);

    void delete(Long id);

    ClienteResponseDTO findById(Long id);

    List<ClienteResponseDTO> findAll();

    List<ClienteResponseDTO> findByNome(String nome);

    List<PedidoResponseDTO> findPedidosByCliente(Long idCliente);


}

package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.Numeracao;
import model.Sapato;
import repository.SapatoRepository;
import dto.SapatoDTO;
import dto.SapatoResponseDTO;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class SapatoServiceimpl implements SapatoService {

    @Inject
    private SapatoRepository sapatoRepository;

    @Override
    @Transactional
    public SapatoResponseDTO create(@Valid SapatoDTO dto) {
        Sapato sapato = new Sapato();
        
        sapato.setNumeracao(Numeracao.valueOf(dto.numeracao()));
        sapato.setFornecedor(dto.fornecedorId());
        sapato.setMarca(dto.marcaId());
        sapato.setCor(dto.corId());
        sapato.setModelo(dto.modeloId());
        sapatoRepository.persist(sapato);
        return SapatoResponseDTO.valueOf(sapato);
    }

   
    @Override
    @Transactional
    public SapatoResponseDTO update(Long id, @Valid SapatoDTO dto) {
    Sapato sapato = sapatoRepository.findById(id);
    if (sapato == null) {
        throw new IllegalArgumentException("Sapato não encontrado com o ID: " + id);
    }

    sapato.setNumeracao(Numeracao.valueOf(dto.numeracao()));
    sapato.setFornecedor(dto.fornecedorId());
    sapato.setMarca(dto.marcaId());
    sapato.setCor(dto.corId());
    sapato.setModelo(dto.modeloId());

    sapatoRepository.persist(sapato);

    return SapatoResponseDTO.valueOf(sapato);
}


    @Override
    @Transactional
    public void delete(Long id) {
        Sapato sapato = sapatoRepository.findById(id);
        if (sapato == null) {
            throw new IllegalArgumentException("Sapato não encontrado com o ID: " + id);
        }
        sapatoRepository.delete(sapato);
    }

    @Override
    public SapatoResponseDTO findById(Long id) {
        Sapato sapato = sapatoRepository.findById(id);
        return sapato != null ? SapatoResponseDTO.valueOf(sapato) : null;
    }

    @Override
    public List<SapatoResponseDTO> findAll() {
        PanacheQuery<Sapato> sapatos = sapatoRepository.findAll();
        return sapatos.stream()
                      .map(SapatoResponseDTO::valueOf)
                      .collect(Collectors.toList());
    }
}






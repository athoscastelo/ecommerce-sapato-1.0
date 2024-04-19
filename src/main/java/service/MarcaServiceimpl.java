package service;

import dto.MarcaDTO;
import dto.MarcaResponseDTO;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.Marca;
import repository.MarcaRepository;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class MarcaServiceimpl implements MarcaService {

    @Inject
    private MarcaRepository marcaRepository;

    @Override
    @Transactional
    public MarcaResponseDTO create(@Valid MarcaDTO dto) {
        Marca marca = new Marca();
        marca.setNome(dto.nome());
        marcaRepository.persist(marca);
        return MarcaResponseDTO.valueOf(marca);
    }
    
    @Override
    @Transactional
    public MarcaResponseDTO update(Long id, @Valid MarcaDTO dto) {
        Marca marca = marcaRepository.findById(id);
        if (marca == null) {
            throw new IllegalArgumentException("Marca não encontrada com o ID: " + id);
        }
        marca.setNome(dto.nome());
        marcaRepository.persist(marca); 
        return MarcaResponseDTO.valueOf(marca);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        Marca marca = marcaRepository.findById(id);
        if (marca == null) {
            throw new IllegalArgumentException("Marca não encontrada com o ID: " + id);
        }
        marcaRepository.delete(marca); 
    }
    

    @Override
    public MarcaResponseDTO findById(Long id) {
        Marca marca = marcaRepository.findById(id);
        return marca != null ? MarcaResponseDTO.valueOf(marca) : null;
    }

    @Override
    public List<MarcaResponseDTO> findAll() {
        PanacheQuery<Marca> marcas = marcaRepository.findAll();
        return marcas.stream()
                .map(MarcaResponseDTO::valueOf)
                .collect(Collectors.toList());
    }
}

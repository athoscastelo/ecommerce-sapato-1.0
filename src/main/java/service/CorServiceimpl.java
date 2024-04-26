package service;

import dto.CorDTO;
import dto.CorResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.Cor;
import repository.CorRepository;
import java.util.List;


@ApplicationScoped
public class CorServiceimpl implements CorService {


    @Inject
    private CorRepository corRepository;



    @Override
    @Transactional
    public CorResponseDTO create(@Valid CorDTO dto) {
        Cor cor = new Cor();
        cor.setNome(dto.nome());

        corRepository.persist(cor);
        return CorResponseDTO.valueOf(cor);
    }
    @Override
    @Transactional
    public void update(Long id, @Valid CorDTO dto) {
        Cor cor = corRepository.findById(id);
        cor.setNome(dto.nome());
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        corRepository.deleteById(id);
    }
    
    
    
    @Override
    public CorResponseDTO findById(Long id) {
        return CorResponseDTO.valueOf(corRepository.findById(id));
    }
    
    
    @Override
    public List<CorResponseDTO> findAll() {
        return corRepository
        .listAll()
        .stream()
        .map(e -> CorResponseDTO.valueOf(e)).toList();
    }
    
    
}



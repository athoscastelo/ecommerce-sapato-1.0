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
import java.util.stream.Collectors;

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
    public CorResponseDTO update(Long id, @Valid CorDTO dto) {
        Cor cor = corRepository.findById(id);
        if (cor == null) {
            throw new IllegalArgumentException("Cor não encontrada com o ID: " + id);
        }

        cor.setNome(dto.nome());

        corRepository.persist(cor);

        return CorResponseDTO.valueOf(cor);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Cor cor = corRepository.findById(id);
        if (cor == null) {
            throw new IllegalArgumentException("Cor não encontrada com o ID: " + id);
        }
        corRepository.delete(cor);
    }

    @Override
    public CorResponseDTO findById(Long id) {
        Cor cor = corRepository.findById(id);
        return cor != null ? CorResponseDTO.valueOf(cor) : null;
    }

    @Override
    public List<CorResponseDTO> findAll() {
        List<Cor> cores = corRepository.listAll();
        return cores.stream()
                .map(CorResponseDTO::valueOf)
                .collect(Collectors.toList());
    }
}


package service;

import dto.TipoSapatoDTO;
import dto.TipoSapatoResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.TipoSapato;
import repository.TipoSapatoRepository;
import java.util.List;

@ApplicationScoped
public class TipoSapatoServiceimpl implements TipoSapatoService {

    @Inject
    private TipoSapatoRepository tiposapatoRepository;

    @Override
    @Transactional
    public TipoSapatoResponseDTO create(@Valid TipoSapatoDTO dto) {
        TipoSapato tiposapato = new TipoSapato();
        tiposapato.setDescricao(dto.descricao());

        tiposapatoRepository.persist(tiposapato);
        return TipoSapatoResponseDTO.valueOf(tiposapato);
    }

    @Override
    @Transactional
    public void update(Long id, @Valid TipoSapatoDTO dto) {
        TipoSapato tiposapato = tiposapatoRepository.findById(id);
        tiposapato.setDescricao(dto.descricao());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tiposapatoRepository.deleteById(id);
    }

    @Override
    public TipoSapatoResponseDTO findById(Long id) {
        return TipoSapatoResponseDTO.valueOf(tiposapatoRepository.findById(id));
    }

    @Override
    public List<TipoSapatoResponseDTO> findAll() {
        return tiposapatoRepository
                .listAll()
                .stream()
                .map(e -> TipoSapatoResponseDTO.valueOf(e))
                .toList();
    }
}

package service;

import dto.MarcaDTO;
import dto.MarcaResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.Marca;
import repository.MarcaRepository;
import java.util.List;


@ApplicationScoped
public class MarcaServiceimpl implements MarcaService {


    @Inject
    private MarcaRepository MarcaRepository;

    @Override
    @Transactional
    public MarcaResponseDTO create(@Valid MarcaDTO dto) {
        Marca Marca = new Marca();
        Marca.setNome(dto.nome());

        MarcaRepository.persist(Marca);
        return MarcaResponseDTO.valueOf(Marca);
    }


@Override
@Transactional
public void update(Long id, @Valid MarcaDTO dto) {
    Marca Marca = MarcaRepository.findById(id);
    Marca.setNome(dto.nome());
}

@Override
@Transactional
public void delete(Long id) {
    MarcaRepository.deleteById(id);
}



@Override
public MarcaResponseDTO findById(Long id) {
    return MarcaResponseDTO.valueOf(MarcaRepository.findById(id));
}


@Override
public List<MarcaResponseDTO> findAll() {
    return MarcaRepository
    .listAll()
    .stream()
    .map(e -> MarcaResponseDTO.valueOf(e)).toList();
}

}
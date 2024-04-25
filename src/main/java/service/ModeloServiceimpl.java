package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.Modelo;
import repository.ModeloRepository;
import dto.ModeloDTO;
import dto.ModeloResponseDTO;
import java.util.List;

@ApplicationScoped
public class ModeloServiceimpl implements ModeloService {

    @Inject
    private ModeloRepository modeloRepository;



    @Override
    @Transactional
    public ModeloResponseDTO create(@Valid ModeloDTO dto) {
        Modelo modelo = new Modelo();
        modelo.setNome(dto.nome());

        modeloRepository.persist(modelo);
        return ModeloResponseDTO.valueOf(modelo);
    }


@Override
@Transactional
public void update(Long id, @Valid ModeloDTO dto) {
    Modelo modelo = modeloRepository.findById(id);
    modelo.setNome(dto.nome());
}

@Override
@Transactional
public void delete(Long id) {
    modeloRepository.deleteById(id);
}



@Override
public ModeloResponseDTO findById(Long id) {
    return ModeloResponseDTO.valueOf(modeloRepository.findById(id));
}


@Override
public List<ModeloResponseDTO> findAll() {
    return modeloRepository
    .listAll()
    .stream()
    .map(e -> ModeloResponseDTO.valueOf(e)).toList();
}


}

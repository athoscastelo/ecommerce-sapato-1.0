package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.Modelo;
import repository.ModeloRepository;
import dto.ModeloDTO;
import dto.ModeloResponseDTO;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import java.util.List;
import java.util.stream.Collectors;

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
    public ModeloResponseDTO update(Long id, @Valid ModeloDTO dto) {
    Modelo modelo = modeloRepository.findById(id);
    if (modelo == null) {
        throw new IllegalArgumentException("Modelo não encontrado com o ID: " + id);
    }

    modelo.setNome(dto.nome());

    modeloRepository.persist(modelo);

    return ModeloResponseDTO.valueOf(modelo);
}


@Override
@Transactional
public void delete(Long id) {
    Modelo modelo = modeloRepository.findById(id);
    if (modelo == null) {
        throw new IllegalArgumentException("Modelo não encontrado com o ID: " + id);
    }
    modeloRepository.delete(modelo);
}


@Override
public ModeloResponseDTO findById(Long id) {
    Modelo modelo = modeloRepository.findById(id);
    return modelo != null ? ModeloResponseDTO.valueOf(modelo) : null;
}


@Override
public List<ModeloResponseDTO> findAll() {
    PanacheQuery<Modelo> modelos = modeloRepository.findAll();
    return modelos.stream()
                  .map(ModeloResponseDTO::valueOf)
                  .collect(Collectors.toList());
}

}

package service;

import dto.ColecaoDTO;
import dto.ColecaoResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.Colecao;
import repository.ColecaoRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ColecaoServiceimpl implements ColecaoService {

    @Inject
    private ColecaoRepository colecaoRepository;

    @Override
    @Transactional
    public ColecaoResponseDTO create(@Valid ColecaoDTO dto) {
        Colecao colecao = new Colecao();
        colecao.setNome(dto.nome());
        colecao.setSapatos(dto.getSapatos());
        colecaoRepository.persist(colecao);
        return ColecaoResponseDTO.valueOf(colecao);
    }

    @Override
    @Transactional
    public ColecaoResponseDTO update(Long id, @Valid ColecaoDTO dto) {
        Colecao colecao = colecaoRepository.findById(id);
        if (colecao == null) {
            throw new IllegalArgumentException("Coleção não encontrada com o ID: " + id);
        }
        colecao.setNome(dto.nome());
        colecao.setSapatos(dto.getSapatos());
        return ColecaoResponseDTO.valueOf(colecao);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Colecao colecao = colecaoRepository.findById(id);
        if (colecao == null) {
            throw new IllegalArgumentException("Coleção não encontrada com o ID: " + id);
        }
        colecaoRepository.delete(colecao);
    }

    @Override
    public ColecaoResponseDTO findById(Long id) {
        Colecao colecao = colecaoRepository.findById(id);
        return colecao != null ? ColecaoResponseDTO.valueOf(colecao) : null;
    }

    @Override
    public List<ColecaoResponseDTO> findAll() {
        List<Colecao> colecoes = colecaoRepository.listAll();
        return colecoes.stream().map(ColecaoResponseDTO::valueOf).collect(Collectors.toList());
    }
}

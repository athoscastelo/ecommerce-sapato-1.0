package service;

import dto.SapatoDTO;
import dto.SapatoResponseDTO;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.CorCadarco;
import model.MaterialSapato;
import model.Numeracao;
import model.Sapato;
import repository.CorRepository;
import repository.FornecedorRepository;
import repository.MarcaRepository;
import repository.ModeloRepository;
import repository.SapatoRepository;
import repository.TipoSapatoRepository;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class SapatoServiceimpl implements SapatoService {

    @Inject
    private SapatoRepository SapatoRepository;

    @Inject
    private FornecedorRepository fornecedorRepository;

    @Inject
    private MarcaRepository marcaRepository;

    @Inject
    private ModeloRepository modeloRepository;

    @Inject
    private CorRepository corRepository;

    @Inject
    private TipoSapatoRepository tipoSapatoRepository;

    @Override
    @Transactional
    public SapatoResponseDTO create(@Valid SapatoDTO dto) {
        Sapato Sapato = new Sapato();
        Sapato.setPreco(dto.preco());
        Sapato.setEstoque(dto.estoque());
        Sapato.setNumeracao(Numeracao.valueOf(dto.valor_numeracao()));
        Sapato.setMaterialSapato(MaterialSapato.valueOf(dto.materialsapato_id()));
        Sapato.setCadarco(CorCadarco.valueOf(dto.cadarco_id()));
        Sapato.setFornecedor(fornecedorRepository.findById(dto.fornecedorId()));
        Sapato.setMarca(marcaRepository.findById(dto.marcaId()));
        Sapato.setCor(corRepository.findById(dto.corId()));
        Sapato.setModelo(modeloRepository.findById(dto.modeloId()));
        Sapato.setTiposapato(tipoSapatoRepository.findById(dto.tiposapato_id()));
        SapatoRepository.persist(Sapato);
        return SapatoResponseDTO.valueOf(Sapato);
    }
    
    @Override
    @Transactional
    public void update(Long id, SapatoDTO dto) {
        Sapato Sapato = SapatoRepository.findById(id);
        if (Sapato == null) {
            throw new IllegalArgumentException("Sapato não encontrada com o ID: " + id);
        }
        Sapato.setPreco(dto.preco());
        Sapato.setEstoque(dto.estoque());
        Sapato.setNumeracao(Numeracao.valueOf(dto.valor_numeracao()));
        Sapato.setMaterialSapato(MaterialSapato.valueOf(dto.materialsapato_id()));
        Sapato.setCadarco(CorCadarco.valueOf(dto.cadarco_id()));
        Sapato.setFornecedor(fornecedorRepository.findById(dto.fornecedorId()));
        Sapato.setMarca(marcaRepository.findById(dto.marcaId()));
        Sapato.setCor(corRepository.findById(dto.corId()));
        Sapato.setModelo(modeloRepository.findById(dto.modeloId()));
        Sapato.setTiposapato(tipoSapatoRepository.findById(dto.tiposapato_id()));
        SapatoRepository.persist(Sapato);
        }
    
    @Override
    @Transactional
    public void delete(Long id) {
        Sapato Sapato = SapatoRepository.findById(id);
        if (Sapato == null) {
            throw new IllegalArgumentException("Sapato não encontrada com o ID: " + id);
        }
        SapatoRepository.delete(Sapato); 
    }
    

    @Override
    public SapatoResponseDTO findById(Long id) {
        Sapato Sapato = SapatoRepository.findById(id);
        return Sapato != null ? SapatoResponseDTO.valueOf(Sapato) : null;
    }

    @Override
    public List<SapatoResponseDTO> findAll() {
        PanacheQuery<Sapato> Sapatos = SapatoRepository.findAll();
        return Sapatos.stream()
                .map(SapatoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }
}







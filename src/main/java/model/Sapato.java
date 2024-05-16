package model;

import java.util.List;

import jakarta.persistence.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Sapato extends DefaultEntity {



    private Double preco;

    private Integer estoque;
    
    private Numeracao numeracao;

    private MaterialSapato materialSapato;

    private CorCadarco cadarco;


    @ManyToMany(mappedBy = "favoritos")
    private List<Cliente> clientesFavoritando;

    @ManyToOne
    @JoinColumn(name = "tiposapato_id")
    private TipoSapato tiposapato;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "cor_id")
    private Cor cor;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;


    public CorCadarco getCadarco() {
        return cadarco;
    }

    public void setCadarco(CorCadarco cadarco) {
        this.cadarco = cadarco;
    }
    
    public MaterialSapato getMaterialSapato() {
        return materialSapato;
    }

    public void setMaterialSapato(MaterialSapato materialSapato) {
        this.materialSapato = materialSapato;
    }

    public TipoSapato getTiposapato() {
        return tiposapato;
    }

    public void setTiposapato(TipoSapato tiposapato) {
        this.tiposapato = tiposapato;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Numeracao getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(Numeracao numeracao) {
        this.numeracao = numeracao;
    }


    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
}

package model;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.JoinColumn;
    import jakarta.persistence.ManyToOne;
    import jakarta.persistence.OneToOne;
    
    @Entity
    public class Sapato {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        private Numeracao numeracao;

        private float preco;
        private int estoque;
        
        @ManyToOne
        @JoinColumn(name = "fornecedor_id")
        private Fornecedor fornecedor;
        
        @OneToOne
        @JoinColumn(name = "marca_id")
        private Marca marca;
        
        @OneToOne
        @JoinColumn(name = "cor_id")
        private Cor cor;
        
        @OneToOne
        @JoinColumn(name = "modelo_id")
        private Modelo modelo;
        
                
        public Numeracao getNumeracao() {
            return numeracao;
        }

        public void setNumeracao(Numeracao numeracao) {
            this.numeracao = numeracao;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public float getPreco() {
            return preco;
        }
    
        public void setPreco(float preco) {
            this.preco = preco;
        }
    
        public int getEstoque() {
            return estoque;
        }
    
        public void setEstoque(int estoque) {
            this.estoque = estoque;
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
    


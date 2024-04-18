
INSERT INTO numeracao (id, nome) VALUES
(1, 'Trinta e quatro'),
(2, 'Trinta e cinco'),
(3, 'Trinta e seis'),
(4, 'Trinta e sete'),
(5, 'Trinta e oito'),
(6, 'Trinta e nove'),
(7, 'Quarenta'),
(8, 'Quarenta e um'),
(9, 'Quarenta e dois'),
(10, 'Quarenta e três'),
(11, 'Quarenta e quatro'),
(12, 'Quarenta e cinco');

INSERT INTO marca (id, nome) VALUES
(1, 'Adidas'),
(2, 'Nike'),
(3, 'Puma');

INSERT INTO modelo (id, nome) VALUES
(1, 'Superstar'),
(2, 'Air Force 1'),
(3, 'Suede');

INSERT INTO cor (id, nome) VALUES
(1, 'Preto'),
(2, 'Branco'),
(3, 'Vermelho');

INSERT INTO fornecedor (id, nome, cnpj, endereco, telefone) VALUES
(1, 'Fornecedor A', '1234567890001', 'Rua A, 123', '(11) 1234-5678'),
(2, 'Fornecedor B', '1234567890002', 'Rua B, 456', '(22) 9876-5432');

INSERT INTO sapato (numeracao_id, preco, estoque, fornecedor_id, marca_id, cor_id, modelo_id) VALUES
(1, 199.99, 50, 1, 1, 1, 1),
(2, 149.99, 30, 1, 2, 2, 2),
(3, 129.99, 20, 2, 3, 3, 3);

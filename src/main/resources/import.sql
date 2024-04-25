-- Inserts para a classe Cor
INSERT INTO Cor (id, nome) VALUES (1, 'Preto');
INSERT INTO Cor (id, nome) VALUES (2, 'Branco');
INSERT INTO Cor (id, nome) VALUES (3, 'Azul');
INSERT INTO Cor (id, nome) VALUES (4, 'Vermelho');
INSERT INTO Cor (id, nome) VALUES (5, 'Verde');

-- Inserts para a classe Fornecedor
INSERT INTO Fornecedor (id, nome, cnpj, endereco, telefone) VALUES (1, 'Fornecedor A', '12345678901234', 'Rua A, 123', '(11) 1234-5678');
INSERT INTO Fornecedor (id, nome, cnpj, endereco, telefone) VALUES (2, 'Fornecedor B', '56789012345678', 'Rua B, 456', '(22) 2345-6789');
INSERT INTO Fornecedor (id, nome, cnpj, endereco, telefone) VALUES (3, 'Fornecedor C', '90123456789012', 'Rua C, 789', '(33) 3456-7890');

-- Inserts para a classe Marca
INSERT INTO Marca (id, nome) VALUES (1, 'Marca X');
INSERT INTO Marca (id, nome) VALUES (2, 'Marca Y');
INSERT INTO Marca (id, nome) VALUES (3, 'Marca Z');

-- Inserts para a classe Modelo
INSERT INTO Modelo ( nome) VALUES ( 'Modelo A');
INSERT INTO Modelo ( nome) VALUES ( 'Modelo B');
INSERT INTO Modelo ( nome) VALUES ('Modelo C');

-- Inserts para a classe Sapato
INSERT INTO Sapato ( preco, estoque, numeracao_id, fornecedor_id, marca_id, cor_id, modelo_id) VALUES ( 99.99, 37, 1, 1, 1, 1, 1);
INSERT INTO Sapato ( preco, estoque, numeracao_id, fornecedor_id, marca_id, cor_id, modelo_id) VALUES ( 79.99, 39, 2, 2, 2, 2, 2);
INSERT INTO Sapato ( preco, estoque, numeracao_id, fornecedor_id, marca_id, cor_id, modelo_id) VALUES ( 129.99, 38, 3, 3, 3, 3, 3);

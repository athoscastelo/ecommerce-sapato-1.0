-- Inserts para a classe Cor
INSERT INTO Cor ( nome) VALUES ('Preto');
INSERT INTO Cor ( nome) VALUES ( 'Branco');
INSERT INTO Cor ( nome) VALUES ( 'Azul');
INSERT INTO Cor ( nome) VALUES ( 'Vermelho');
INSERT INTO Cor ( nome) VALUES ( 'Verde');

-- Inserts para a classe Fornecedor
INSERT INTO Fornecedor ( nome, cnpj, endereco, telefone) VALUES ( 'Fornecedor A', '12345678901234', 'Rua A, 123', '(11) 1234-5678');
INSERT INTO Fornecedor ( nome, cnpj, endereco, telefone) VALUES ( 'Fornecedor B', '56789012345678', 'Rua B, 456', '(22) 2345-6789');
INSERT INTO Fornecedor ( nome, cnpj, endereco, telefone) VALUES ( 'Fornecedor C', '90123456789012', 'Rua C, 789', '(33) 3456-7890');

-- Inserts para a classe Marca
INSERT INTO Marca ( nome) VALUES ( 'Marca X');
INSERT INTO Marca ( nome) VALUES ( 'Marca Y');
INSERT INTO Marca ( nome) VALUES ( 'Marca Z');

-- Inserts para a classe Modelo
INSERT INTO Modelo ( nome) VALUES ( 'Modelo A');
INSERT INTO Modelo ( nome) VALUES ( 'Modelo B');
INSERT INTO Modelo ( nome) VALUES ('Modelo C');

-- Inserts para a classe Sapato
INSERT INTO Sapato ( preco, estoque, numeracao_id, fornecedor_id, marca_id, cor_id, modelo_id) VALUES ( 99.99, 37, 1, 1, 1, 1, 1);
INSERT INTO Sapato ( preco, estoque, numeracao_id, fornecedor_id, marca_id, cor_id, modelo_id) VALUES ( 79.99, 39, 2, 2, 2, 2, 2);
INSERT INTO Sapato ( preco, estoque, numeracao_id, fornecedor_id, marca_id, cor_id, modelo_id) VALUES ( 129.99, 38, 3, 3, 3, 3, 3);

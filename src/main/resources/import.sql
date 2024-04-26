INSERT INTO Cor ( nome) VALUES ('Preto');
INSERT INTO Cor ( nome) VALUES ( 'Branco');
INSERT INTO Cor ( nome) VALUES ( 'Azul');
INSERT INTO Cor ( nome) VALUES ( 'Vermelho');
INSERT INTO Cor ( nome) VALUES ( 'Verde');
INSERT INTO Cor (nome) VALUES ('Amarelo');
INSERT INTO Cor (nome) VALUES ('Rosa');
INSERT INTO Cor (nome) VALUES ('Roxo');
INSERT INTO Cor (nome) VALUES ('Laranja');

INSERT INTO Fornecedor ( nome, cnpj, endereco, telefone) VALUES ( 'Fornecedor A', '12345678901234', 'Rua A, 123', '(11) 1234-5678');
INSERT INTO Fornecedor ( nome, cnpj, endereco, telefone) VALUES ( 'Fornecedor B', '56789012345678', 'Rua B, 456', '(22) 2345-6789');
INSERT INTO Fornecedor ( nome, cnpj, endereco, telefone) VALUES ( 'Fornecedor C', '90123456789012', 'Rua C, 789', '(33) 3456-7890');
INSERT INTO Fornecedor (nome, cnpj, endereco, telefone) VALUES ('Fornecedor D', '78901234567890', 'Rua D, 1010', '(44) 4567-8901');
INSERT INTO Fornecedor (nome, cnpj, endereco, telefone) VALUES ('Fornecedor E', '12345678901234', 'Rua E, 2020', '(55) 5678-9012');
INSERT INTO Fornecedor (nome, cnpj, endereco, telefone) VALUES ('Fornecedor F', '56789012345678', 'Rua F, 3030', '(66) 6789-0123');

INSERT INTO Marca ( nome) VALUES ( 'Marca X');
INSERT INTO Marca ( nome) VALUES ( 'Marca Y');
INSERT INTO Marca ( nome) VALUES ( 'Marca Z');
INSERT INTO Marca (nome) VALUES ('Marca A');
INSERT INTO Marca (nome) VALUES ('Marca B');
INSERT INTO Marca (nome) VALUES ('Marca C');

INSERT INTO Modelo ( nome) VALUES ( 'Modelo A');
INSERT INTO Modelo ( nome) VALUES ( 'Modelo B');
INSERT INTO Modelo ( nome) VALUES ('Modelo C');
INSERT INTO Modelo (nome) VALUES ('Modelo D');
INSERT INTO Modelo (nome) VALUES ('Modelo E');
INSERT INTO Modelo (nome) VALUES ('Modelo F');

INSERT INTO TipoSapato (descricao) VALUES ('Sapato social');
INSERT INTO TipoSapato (descricao) VALUES ('Sapato esportivo masculino');
INSERT INTO TipoSapato (descricao) VALUES ('Sapato de salto alto feminino');
INSERT INTO TipoSapato (descricao) VALUES ('Sapato casual para o dia a dia, confortável e elegante');
INSERT INTO TipoSapato (descricao) VALUES ('Sapato de dança ');

INSERT INTO Cliente (nome, email, senha, cpf) VALUES ('João Silva', 'joao@example.com', 'senha123', '12345678901');
INSERT INTO Cliente (nome, email, senha, cpf) VALUES ('Maria Oliveira', 'maria@example.com', 'senhamaria', '98765432109');

INSERT INTO Funcionario (nome, email, senha, cpf, dataNascimento, cargo, telefone, endereco)
VALUES ('João Silva', 'joao@example.com', 'senha123', '123.456.789-01', '1980-04-15', 'Analista de Vendas', '(11) 1234-5678', 'Rua dos Comerciantes, 123');
INSERT INTO Funcionario (nome, email, senha, cpf, dataNascimento, cargo, telefone, endereco)
VALUES ('Maria Oliveira', 'maria@example.com', 'senhaMaria', '987.654.321-09', '1985-10-20', 'Gerente de Marketing', '(22) 9876-5432', 'Avenida das Flores, 456');
INSERT INTO Funcionario (nome, email, senha, cpf, dataNascimento, cargo, telefone, endereco)
VALUES ('Pedro Santos', 'pedro@example.com', 'senhaPedro', '456.789.123-45', '1990-12-05', 'Analista Financeiro', '(33) 6543-2109', 'Rua das Oliveiras, 789');

INSERT INTO Sapatos (preco, estoque, valor_numeracao, materialsapato_id, cadarco_id, fornecedor_id, tiposapato_id, marca_id, cor_id, modelo_id)
VALUES (67.0, 34, 41, 2, 2, 1, 2, 2, 3, 1);






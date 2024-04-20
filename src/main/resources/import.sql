INSERT INTO marca (id, nome) VALUES
(1, 'Calvin Klein'),
(2, 'Hugo Boss'),
(3, 'Gucci');

INSERT INTO modelo (id, nome) VALUES
(1, 'Oxford'),
(2, 'Monk Strap'),
(3, 'Derby');

INSERT INTO cor (id, nome) VALUES
(1, 'Marrom'),
(2, 'Bege'),
(3, 'Azul Marinho');

INSERT INTO fornecedor (id, nome, cnpj, endereco, telefone) VALUES
(1, 'Fornecedor C', '1234567890003', 'Rua C, 789', '(33) 1234-5678'),
(2, 'Fornecedor D', '1234567890004', 'Rua D, 1011', '(44) 9876-5432');

INSERT INTO sapato (fornecedor_id, marca_id, cor_id, modelo_id) VALUES
(1, 1, 1, 1),
(1, 2, 2, 2),
(1, 3, 3, 3);

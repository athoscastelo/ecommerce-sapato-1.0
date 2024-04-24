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
INSERT INTO fornecedor (id, nome, cnpj, endereco, telefone) VALUES
(3, 'Fornecedor E', '1234567890005', 'Rua E, 1213', '(55) 2468-1357'),
(4, 'Fornecedor F', '1234567890006', 'Rua F, 1415', '(66) 3691-4825'),
(5, 'Fornecedor G', '1234567890007', 'Rua G, 1617', '(77) 7531-9648');


INSERT INTO Sapato (preco, estoque, fornecedor_id, marca_id, cor_id, modelo_id) VALUES (50.0, 100, 1, 1, 1, 1);
INSERT INTO Sapato (preco, estoque, fornecedor_id, marca_id, cor_id, modelo_id) VALUES (40.0, 80, 2, 2, 2, 2);
INSERT INTO Sapato (preco, estoque, fornecedor_id, marca_id, cor_id, modelo_id) VALUES (60.0, 120, 2, 3, 3, 3);

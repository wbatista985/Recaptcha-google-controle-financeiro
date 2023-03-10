INSERT INTO Conta(banco, saldo) VALUES('NuBank', 300);
INSERT INTO Conta(banco, saldo) VALUES('Santander', 400);
INSERT INTO Conta(banco, saldo) VALUES('Itau', 1200);
INSERT INTO Conta(banco, saldo) VALUES('Bradesco', 200);

INSERT INTO Categoria(descricao) VALUES('Compras');
INSERT INTO Categoria(descricao) VALUES('Mercado');
INSERT INTO Categoria(descricao) VALUES('Comida');
INSERT INTO Categoria(descricao) VALUES('Roupas');


INSERT INTO Movimentacao(id_conta, id_categoria, Tipo_Movimentacao, valor, data, comentario) VALUES(1, 1, 'RECEITA', 200, '2023-01-10', 'Guardado');
INSERT INTO Movimentacao(id_conta, id_categoria, Tipo_Movimentacao, valor, data, comentario) VALUES(2, 2, 'RECEITA', 200, '2023-02-10', 'Gasto');
INSERT INTO Movimentacao(id_conta, id_categoria, Tipo_Movimentacao, valor, data, comentario) VALUES(3, 3, 'DESPESA', 100, '2022-11-10', 'Gasto');

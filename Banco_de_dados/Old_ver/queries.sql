--Valor total de vendas para cada cliente:

SELECT c.nome AS NomeCliente, c.sobrenome AS SobrenomeCliente, SUM(pv.valor) AS VendasTotais
FROM cliente c
JOIN pedido_venda pv ON c.clienteID = pv.clienteID
GROUP BY c.nome, c.sobrenome
ORDER BY VendasTotais DESC;

--Total de itens vendidos por produto:

SELECT i.nome AS NomeProduto, SUM(iv.quantidade) AS QuantidadeTotalVendida
FROM item i
JOIN item_venda iv ON i.it_cod = iv.ped_venda
GROUP BY i.nome
ORDER BY QuantidadeTotalVendida DESC;

--Pagamentos pendentes:

SELECT c.nome AS NomeCliente, c.sobrenome AS SobrenomeCliente, p.valor_pago AS ValorPago, p.forma_pagamento AS FormaPagamento, p.status_pagamento AS StatusPagamento
FROM cliente c
JOIN pagamento p ON c.clienteID = p.clienteID
WHERE p.status_pagamento = 'Pendente';

--Níveis de estoque para cada produto:

SELECT i.nome AS NomeProduto, e.quantidade AS QuantidadeEmEstoque
FROM item i
JOIN item_estoque ie ON i.it_cod = ie.it_cod
JOIN estoque e ON ie.estoqueID = e.estoqueID
ORDER BY e.quantidade DESC;

--Pedidos e pagamentos de fornecedores:

SELECT f.Nome AS NomeFornecedor, pf.quantidade AS QuantidadePedido, pf.valor AS ValorPedido, pf.pagamento_fornecedorID AS StatusPagamento
FROM fornecedor f
JOIN pedido_fornecedor pf ON f.fornecedorID = pf.fornecedorID
ORDER BY pf.valor DESC;

--Vendas mais recentes:

SELECT c.nome AS NomeCliente, c.sobrenome AS SobrenomeCliente, pv.dt_venda AS DataVenda, pv.valor AS ValorVenda
FROM cliente c
JOIN pedido_venda pv ON c.clienteID = pv.clienteID
ORDER BY pv.dt_venda DESC
LIMIT 5;

--Melhor vendedor por total de vendas:

SELECT u.nome AS NomeVendedor, SUM(pv.valor) AS TotalVendas
FROM usuario u
JOIN pedido_compra pc ON u.usuarioID = pc.usuarioID
JOIN pedido_venda pv ON pc.ped_compra = pv.ped_venda
WHERE u.tipo = 1  -- Assumindo que tipo 1 indica um vendedor
GROUP BY u.nome
ORDER BY TotalVendas DESC;

--Detalhes da dívida do cliente:

SELECT nome AS NomeCliente, sobrenome AS SobrenomeCliente, divida AS Divida
FROM cliente
WHERE divida > 0
ORDER BY divida DESC;

--Itens abaixo de um certo nível de estoque:

SELECT i.nome AS NomeProduto, e.quantidade AS QuantidadeEmEstoque
FROM item i
JOIN item_estoque ie ON i.it_cod = ie.it_cod
JOIN estoque e ON ie.estoqueID = e.estoqueID
WHERE e.quantidade < 20
ORDER BY e.quantidade ASC;

--Valor total do inventário:

SELECT SUM(e.quantidade * i.valor) AS ValorTotalInventario
FROM item i
JOIN item_estoque ie ON i.it_cod = ie.it_cod
JOIN estoque e ON ie.estoqueID = e.estoqueID;

--Seleção de idades e sexo feminino:
SELECT clienteID, nome, data_nascimento, genero_cliente
FROM cliente
WHERE genero_cliente = 'F'
  AND EXTRACT(YEAR FROM AGE(data_nascimento)) BETWEEN 25 AND 35
ORDER BY nome ASC;


CREATE VIEW vw_empresas_usuarios_ativos AS
SELECT 
    e.companyID,
    e.nome AS empresa_nome,
    e.email AS empresa_email,
    u.usuarioID,
    u.nome AS usuario_nome,
    u.departamento,
    u.salario,
    u.email AS usuario_email
FROM empresa e
JOIN usuario u ON e.companyID = u.companyID
WHERE u.ativo = TRUE;


CREATE VIEW vw_pedidos_compra_fornecedor AS
SELECT 
    pc.ped_compra,
    pc.data_compra,
    pc.data_entrega,
    pc.valor AS valor_total,
    pc.desconto,
    f.nome AS fornecedor_nome,
    f.cedula AS fornecedor_cedula,
    f.telefone AS fornecedor_telefone
FROM pedido_compra pc
JOIN fornecedor f ON pc.fornecedorID = f.fornecedorID;


CREATE VIEW vw_itens_estoque AS
SELECT 
    i.it_cod,
    i.nome AS item_nome,
    i.descricao AS item_descricao,
    i.quantidade,
    i.valor AS valor_unitario,
    e.rua AS estoque_rua,
    e.prateleira AS estoque_prateleira,
    e.peso AS estoque_peso
FROM item i
JOIN estoque e ON i.estoqueID = e.estoqueID;


CREATE VIEW vw_pedidos_venda_itens AS
SELECT 
    pv.ped_venda,
    pv.data_venda,
    pv.data_instalacao,
    pv.valor AS valor_total_pedido,
    iv.quantidade,
    iv.valor_prod AS valor_unitario_item,
    iv.descricao AS item_descricao,
    iv.marca AS item_marca
FROM pedido_venda pv
JOIN item_venda iv ON pv.ped_venda = iv.ped_venda;

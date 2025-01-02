SET lc_time = 'pt_BR';


SELECT 
    c.nome AS cliente_nome,
    pv.dt_venda,
    pv.valor,
    c.cidade
FROM 
    pedido_venda pv
JOIN 
    cliente c ON pv.clienteID = c.clienteID
WHERE 
    c.cidade IN ('Curitiba', 'São Paulo', 'Porto Alegre')
    AND TO_CHAR(pv.dt_venda, 'TMMonth') NOT LIKE '%o' -- 'TMMonth' para evitar problemas de formatação
ORDER BY 
    c.nome DESC;

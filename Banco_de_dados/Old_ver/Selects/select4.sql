SELECT 
    i.nome AS produto,
    SUM(iv.quantidade) AS total_vendas,
    SUM(iv.quantidade * iv.valor_prod) AS valor_total_vendas
FROM 
    item_venda iv
JOIN 
    item i ON iv.itemID = i.it_cod
GROUP BY 
    i.nome
ORDER BY 
    valor_total_vendas DESC;

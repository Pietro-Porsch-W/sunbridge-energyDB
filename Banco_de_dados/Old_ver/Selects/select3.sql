SELECT 
    f.nome AS fornecedor_nome,
    f.cidade,
    i.valor
FROM 
    fornecedor f
JOIN 
    item i ON f.fornecedorid = i.fornecedorid 
WHERE 
    f.cidade IN ('Rio de Janeiro', 'Salvador')
    AND i.valor > 17200
ORDER BY 
    (SELECT COUNT(*)
     FROM fornecedor f2
     WHERE f2.cidade = f.cidade
       AND f2.fornecedorid IN (
           SELECT i2.fornecedorid 
           FROM item i2 
           WHERE i2.valor > 17200
       )
    ) DESC, f.cidade ASC, f.nome ASC;
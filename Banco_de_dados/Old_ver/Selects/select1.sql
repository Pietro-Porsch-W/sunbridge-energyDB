SELECT 
    nome AS cliente_nome,
    data_nascimento,
    genero_cliente 
FROM 
    cliente
WHERE 
    genero_cliente = 'F'
    AND DATE_PART('year', AGE(data_nascimento)) BETWEEN 25 AND 35
ORDER BY 
    nome ASC;

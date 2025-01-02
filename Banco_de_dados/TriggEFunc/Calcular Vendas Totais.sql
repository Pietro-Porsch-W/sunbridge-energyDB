CREATE OR REPLACE FUNCTION vendas_totais(data_inicio DATE, data_fim DATE)
RETURNS NUMERIC AS $$
DECLARE
    total NUMERIC;
BEGIN
    SELECT SUM(valor - COALESCE(desconto, 0))
    INTO total
    FROM pedido_venda
    WHERE data_venda BETWEEN data_inicio AND data_fim;
    RETURN COALESCE(total, 0);
END;
$$ LANGUAGE plpgsql;

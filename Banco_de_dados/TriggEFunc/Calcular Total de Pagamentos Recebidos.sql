CREATE OR REPLACE FUNCTION total_pagamentos_recebidos(data_inicio DATE, data_fim DATE)
RETURNS NUMERIC AS $$
DECLARE
    total NUMERIC;
BEGIN
    SELECT SUM(valor_pago)
    INTO total
    FROM pagamento
    WHERE data_pagamento BETWEEN data_inicio AND data_fim;
    RETURN COALESCE(total, 0);
END;
$$ LANGUAGE plpgsql;

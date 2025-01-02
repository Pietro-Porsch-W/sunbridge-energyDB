CREATE OR REPLACE FUNCTION obter_divida_cliente(p_clienteID INT)
RETURNS NUMERIC AS $$
DECLARE
    total_compras NUMERIC;
    total_pagamentos NUMERIC;
    divida NUMERIC;
BEGIN
    SELECT SUM(valor - COALESCE(desconto, 0))
    INTO total_compras
    FROM pedido_venda
    WHERE clienteID = p_clienteID;

    SELECT SUM(valor_pago)
    INTO total_pagamentos
    FROM pagamento
    WHERE clienteID = p_clienteID;

    divida := COALESCE(total_compras, 0) - COALESCE(total_pagamentos, 0);
    RETURN divida;
END;
$$ LANGUAGE plpgsql;

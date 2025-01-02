-- Função para atualizar a dívida do cliente no pagamento
CREATE OR REPLACE FUNCTION atualizar_divida_cliente_pagamento()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE cliente
    SET divida = COALESCE(divida, 0) - NEW.valor_pago
    WHERE clienteID = NEW.clienteID;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger para chamar a função após inserir em pagamento
CREATE TRIGGER trg_atualizar_divida_cliente_pagamento
AFTER INSERT ON pagamento
FOR EACH ROW
EXECUTE FUNCTION atualizar_divida_cliente_pagamento();

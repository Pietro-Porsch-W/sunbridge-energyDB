-- Função para verificar o valor do pagamento
CREATE OR REPLACE FUNCTION verificar_valor_pagamento()
RETURNS TRIGGER AS $$
DECLARE
    divida_atual NUMERIC;
BEGIN
    SELECT divida INTO divida_atual FROM cliente WHERE clienteID = NEW.clienteID;
    IF NEW.valor_pago > divida_atual THEN
        RAISE EXCEPTION 'Valor do pagamento excede a dívida atual do cliente %', NEW.clienteID;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger para chamar a função antes de inserir em pagamento
CREATE TRIGGER trg_verificar_valor_pagamento
BEFORE INSERT ON pagamento
FOR EACH ROW
EXECUTE FUNCTION verificar_valor_pagamento();

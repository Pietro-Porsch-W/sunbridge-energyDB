-- Função para atualizar a dívida do cliente na venda
CREATE OR REPLACE FUNCTION atualizar_divida_cliente_venda()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE cliente
    SET divida = COALESCE(divida, 0) + (NEW.valor - COALESCE(NEW.desconto, 0))
    WHERE clienteID = NEW.clienteID;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger para chamar a função após inserir em pedido_venda
CREATE TRIGGER trg_atualizar_divida_cliente_venda
AFTER INSERT ON pedido_venda
FOR EACH ROW
EXECUTE FUNCTION atualizar_divida_cliente_venda();

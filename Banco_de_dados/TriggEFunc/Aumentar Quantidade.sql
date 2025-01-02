-- Função para aumentar a quantidade do item
CREATE OR REPLACE FUNCTION aumentar_quantidade_item()
RETURNS TRIGGER AS $$
BEGIN
    -- Aumentar a quantidade do item
    UPDATE item
    SET quantidade = quantidade + NEW.quantidade
    WHERE it_cod = NEW.it_cod;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger para chamar a função após inserir em pedido_fornecedor
CREATE TRIGGER trg_aumentar_quantidade_item
AFTER INSERT ON pedido_fornecedor
FOR EACH ROW
EXECUTE FUNCTION aumentar_quantidade_item();

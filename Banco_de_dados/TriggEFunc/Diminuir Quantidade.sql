-- Função para diminuir a quantidade do item
CREATE OR REPLACE FUNCTION diminuir_quantidade_item()
RETURNS TRIGGER AS $$
BEGIN
    -- Verificar se há quantidade suficiente
    IF (SELECT quantidade FROM item WHERE it_cod = NEW.it_cod) < NEW.quantidade THEN
        RAISE EXCEPTION 'Estoque insuficiente para o item %', NEW.it_cod;
    END IF;
    -- Diminuir a quantidade do item
    UPDATE item
    SET quantidade = quantidade - NEW.quantidade
    WHERE it_cod = NEW.it_cod;

    -- Verificar nova quantidade após a diminuição
    IF (SELECT quantidade FROM item WHERE it_cod = NEW.it_cod) < 10 THEN
        RAISE NOTICE 'Nível de estoque baixo para o item %', NEW.it_cod;
        -- Opcionalmente, inserir em uma tabela de estoque baixo
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger para chamar a função após inserir em item_venda
CREATE TRIGGER trg_diminuir_quantidade_item
AFTER INSERT ON item_venda
FOR EACH ROW
EXECUTE FUNCTION diminuir_quantidade_item();

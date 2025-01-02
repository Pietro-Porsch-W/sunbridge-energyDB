-- Função para verificar o nível de estoque
CREATE OR REPLACE FUNCTION verificar_nivel_estoque()
RETURNS TRIGGER AS $$
DECLARE
    quantidade_atual INT;
BEGIN
    SELECT quantidade INTO quantidade_atual FROM item WHERE it_cod = NEW.it_cod;
    IF quantidade_atual < 10 THEN
        RAISE NOTICE 'Nível de estoque baixo para o item %', NEW.it_cod;
        -- Opcionalmente, inserir em uma tabela de estoque baixo ou enviar uma notificação
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger para chamar a função após atualizar a quantidade do item
CREATE TRIGGER trg_verificar_nivel_estoque
AFTER UPDATE ON item
FOR EACH ROW
WHEN (OLD.quantidade <> NEW.quantidade)
EXECUTE FUNCTION verificar_nivel_estoque();

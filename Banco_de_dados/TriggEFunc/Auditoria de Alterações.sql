-- Criar tabela de log de auditoria
CREATE TABLE audit_log (
    id SERIAL PRIMARY KEY,
    table_name VARCHAR(50),
    operation CHAR(1),
    timestamp TIMESTAMP,
    old_data JSONB,
    new_data JSONB
);

-- Função para registrar alterações
CREATE OR REPLACE FUNCTION auditar_alteracoes()
RETURNS TRIGGER AS $$
BEGIN
    IF TG_OP = 'DELETE' THEN
        INSERT INTO audit_log (table_name, operation, timestamp, old_data)
        VALUES (TG_TABLE_NAME, 'D', NOW(), row_to_json(OLD)::jsonb);
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO audit_log (table_name, operation, timestamp, old_data, new_data)
        VALUES (TG_TABLE_NAME, 'U', NOW(), row_to_json(OLD)::jsonb, row_to_json(NEW)::jsonb);
    ELSIF TG_OP = 'INSERT' THEN
        INSERT INTO audit_log (table_name, operation, timestamp, new_data)
        VALUES (TG_TABLE_NAME, 'I', NOW(), row_to_json(NEW)::jsonb);
    END IF;
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

-- Triggers para auditar alterações em tabelas importantes (por exemplo, cliente, item)
CREATE TRIGGER trg_auditar_cliente
AFTER INSERT OR UPDATE OR DELETE ON cliente
FOR EACH ROW
EXECUTE FUNCTION auditar_alteracoes();

CREATE TRIGGER trg_auditar_item
AFTER INSERT OR UPDATE OR DELETE ON item
FOR EACH ROW
EXECUTE FUNCTION auditar_alteracoes();

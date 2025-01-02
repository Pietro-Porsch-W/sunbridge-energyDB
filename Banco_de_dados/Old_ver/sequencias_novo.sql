-- Criar a sequência para o ID da tabela empresa
CREATE SEQUENCE empresa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Alterar a coluna companyID para usar a sequência como valor padrão
ALTER TABLE empresa ALTER COLUMN companyID SET DEFAULT nextval('empresa_id_seq');

-- Garantir que a sequência seja usada corretamente na tabela
ALTER SEQUENCE empresa_id_seq OWNED BY empresa.companyID;

-- Criar a sequência para o ID da tabela usuario
CREATE SEQUENCE usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Alterar a coluna usuarioID para usar a sequência como valor padrão
ALTER TABLE usuario ALTER COLUMN usuarioID SET DEFAULT nextval('usuario_id_seq');

-- Garantir que a sequência seja usada corretamente na tabela
ALTER SEQUENCE usuario_id_seq OWNED BY usuario.usuarioID;

-- Criar a sequência para o ID da tabela fornecedor
CREATE SEQUENCE fornecedor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Alterar a coluna fornecedorID para usar a sequência como valor padrão
ALTER TABLE fornecedor ALTER COLUMN fornecedorID SET DEFAULT nextval('fornecedor_id_seq');

-- Garantir que a sequência seja usada corretamente na tabela
ALTER SEQUENCE fornecedor_id_seq OWNED BY fornecedor.fornecedorID;

-- Criar a sequência para o ID da tabela pagamento_fornecedor
CREATE SEQUENCE pagamento_fornecedor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Alterar a coluna pagamento_fornecedorID para usar a sequência como valor padrão
ALTER TABLE pagamento_fornecedor ALTER COLUMN pagamento_fornecedorID SET DEFAULT nextval('pagamento_fornecedor_id_seq');

-- Garantir que a sequência seja usada corretamente na tabela
ALTER SEQUENCE pagamento_fornecedor_id_seq OWNED BY pagamento_fornecedor.pagamento_fornecedorID;

-- Criar a sequência para o ID da tabela estoque
CREATE SEQUENCE estoque_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Alterar a coluna estoqueID para usar a sequência como valor padrão
ALTER TABLE estoque ALTER COLUMN estoqueID SET DEFAULT nextval('estoque_id_seq');

-- Garantir que a sequência seja usada corretamente na tabela
ALTER SEQUENCE estoque_id_seq OWNED BY estoque.estoqueID;

-- Criar a sequência para o ID da tabela pedido_compra
CREATE SEQUENCE pedido_compra_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Alterar a coluna ped_compra para usar a sequência como valor padrão
ALTER TABLE pedido_compra ALTER COLUMN ped_compra SET DEFAULT nextval('pedido_compra_id_seq');

-- Garantir que a sequência seja usada corretamente na tabela
ALTER SEQUENCE pedido_compra_id_seq OWNED BY pedido_compra.ped_compra;

-- Criar a sequência para o ID da tabela pedido_fornecedor
CREATE SEQUENCE pedido_fornecedor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Alterar a coluna pedido_forID para usar a sequência como valor padrão
ALTER TABLE pedido_fornecedor ALTER COLUMN pedido_forID SET DEFAULT nextval('pedido_fornecedor_id_seq');

-- Garantir que a sequência seja usada corretamente na tabela
ALTER SEQUENCE pedido_fornecedor_id_seq OWNED BY pedido_fornecedor.pedido_forID;

-- Criar a sequência para o ID da tabela item
CREATE SEQUENCE item_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Alterar a coluna it_cod para usar a sequência como valor padrão
ALTER TABLE item ALTER COLUMN it_cod SET DEFAULT nextval('item_id_seq');

-- Garantir que a sequência seja usada corretamente na tabela
ALTER SEQUENCE item_id_seq OWNED BY item.it_cod;

-- Criar a sequência para o ID da tabela cliente
CREATE SEQUENCE cliente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Alterar a coluna clienteID para usar a sequência como valor padrão
ALTER TABLE cliente ALTER COLUMN clienteID SET DEFAULT nextval('cliente_id_seq');

-- Garantir que a sequência seja usada corretamente na tabela
ALTER SEQUENCE cliente_id_seq OWNED BY cliente.clienteID;

-- Criar a sequência para o ID da tabela pagamento
CREATE SEQUENCE pagamento_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Alterar a coluna pagamentoID para usar a sequência como valor padrão
ALTER TABLE pagamento ALTER COLUMN pagamentoID SET DEFAULT nextval('pagamento_id_seq');

-- Garantir que a sequência seja usada corretamente na tabela
ALTER SEQUENCE pagamento_id_seq OWNED BY pagamento.pagamentoID;

-- Criar a sequência para o ID da tabela pedido_venda
CREATE SEQUENCE pedido_venda_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Alterar a coluna ped_venda para usar a sequência como valor padrão
ALTER TABLE pedido_venda ALTER COLUMN ped_venda SET DEFAULT nextval('pedido_venda_id_seq');

-- Garantir que a sequência seja usada corretamente na tabela
ALTER SEQUENCE pedido_venda_id_seq OWNED BY pedido_venda.ped_venda;

-- Criar a sequência para o ID da tabela item_venda
CREATE SEQUENCE item_venda_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Alterar a coluna itemID para usar a sequência como valor padrão
ALTER TABLE item_venda ALTER COLUMN itemID SET DEFAULT nextval('item_venda_id_seq');

-- Garantir que a sequência seja usada corretamente na tabela
ALTER SEQUENCE item_venda_id_seq OWNED BY item_venda.itemID;

-- Criar a sequência para o ID da tabela cliente_logistica
CREATE SEQUENCE cliente_logistica_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Alterar a coluna logisticalID para usar a sequência como valor padrão
ALTER TABLE cliente_logistica ALTER COLUMN logisticalID SET DEFAULT nextval('cliente_logistica_id_seq');

-- Garantir que a sequência seja usada corretamente na tabela
ALTER SEQUENCE cliente_logistica_id_seq OWNED BY cliente_logistica.logisticalID;


-- Define o usuario do banco como criador
DO $$
DECLARE
    seq RECORD;
BEGIN
    FOR seq IN
        SELECT c.oid::regclass::text AS sequencia
        FROM pg_class c
        JOIN pg_namespace n ON n.oid = c.relnamespace
        WHERE c.relkind = 'S' 
    LOOP
        EXECUTE format('GRANT USAGE, SELECT, UPDATE ON SEQUENCE %I TO sunbridgejava;', seq.sequencia);
    END LOOP;
END $$;
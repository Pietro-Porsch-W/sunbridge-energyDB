 -- Table: empresa
CREATE TABLE empresa (
    companyID INT PRIMARY KEY,
    nome VARCHAR(40) NOT NULL,
    websiteURL VARCHAR(255) NOT NULL,
    email VARCHAR(60) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    provincia VARCHAR(255) NOT NULL,
    data_fundacao DATE,
    cedula_juridica VARCHAR(12),
    setor VARCHAR(100),
    numero_licenca VARCHAR(25),
    rua VARCHAR(60) NOT NULL,
    bairro VARCHAR(60) NOT NULL,
    canton VARCHAR(50) NOT NULL,
    distrito VARCHAR(50) NOT NULL,
    codigo_postal INT NOT NULL,
    complemento VARCHAR(60)
);

-- Table: usuario
CREATE TABLE usuario (
    usuarioID INT PRIMARY KEY,
    usuarioID_FK INT NULL,
    companyID INT NOT NULL,
    nome VARCHAR(40) NOT NULL,
    genero CHAR(1) NOT NULL,
    data_entrada DATE,
    tipo INT,
    cedula VARCHAR(15),
    data_nascimento DATE,
    departamento VARCHAR(100) NOT NULL,
    data_admissao DATE NOT NULL,
    salario DECIMAL(10, 2),
    ativo BOOLEAN,
    telefone VARCHAR(20),
    email VARCHAR(60),
    senha VARCHAR(255) NOT NULL,
    rua VARCHAR(60) NOT NULL,
    bairro VARCHAR(60) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    canton VARCHAR(50) NOT NULL,
    distrito VARCHAR(50) NOT NULL,
    codigo_postal INT NOT NULL,
    complemento VARCHAR(60),
    FOREIGN KEY (companyID) REFERENCES empresa(companyID),
    FOREIGN KEY (usuarioID_FK) REFERENCES usuario(usuarioID)
);

-- Table: fornecedor
CREATE TABLE fornecedor (
    fornecedorID INT PRIMARY KEY,
    nome VARCHAR(40) NOT NULL,
    cedula VARCHAR(12) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    rua VARCHAR(60) NOT NULL,
    bairro VARCHAR(60) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    provincia VARCHAR(50) NOT NULL,
    canton VARCHAR(50) NOT NULL,
    distrito VARCHAR(50) NOT NULL,
    codigo_postal INT NOT NULL,
    complemento VARCHAR(60)
);

-- Table: pagamento_fornecedor
CREATE TABLE pagamento_fornecedor (
    pagamento_fornecedorID INT PRIMARY KEY,
    data_pagamento DATE NOT NULL,
    valor DECIMAL(19, 2) NOT NULL,
    forma_pagamento VARCHAR(20) NOT NULL
);

-- Table: estoque
CREATE TABLE estoque (
    estoqueID INT PRIMARY KEY,
    rua VARCHAR(60) NOT NULL,
    prateleira VARCHAR(30) NOT NULL,
    peso INT NOT NULL,
    data_entrada DATE,
    data_saida DATE,
    valor_compra DECIMAL(19, 2),
    valor_venda DECIMAL(19, 2)
);

-- Table: pedido_compra
CREATE TABLE pedido_compra (
    ped_compra INT PRIMARY KEY,
    data_compra DATE NOT NULL,
    data_entrega DATE,
    valor DECIMAL(19, 2) NOT NULL,
    desconto DECIMAL(19, 2),
    usuarioID INT NOT NULL,
    pagamento_fornecedorID INT NOT NULL,
    fornecedorID INT NOT NULL,
    FOREIGN KEY (usuarioID) REFERENCES usuario(usuarioID),
    FOREIGN KEY (pagamento_fornecedorID) REFERENCES pagamento_fornecedor(pagamento_fornecedorID),
    FOREIGN KEY (fornecedorID) REFERENCES fornecedor(fornecedorID)
);

-- Table: item
CREATE TABLE item (
    it_cod INT PRIMARY KEY,
    nome VARCHAR(40) NOT NULL,
    descricao VARCHAR(255),
    quantidade INT NOT NULL,
    valor DECIMAL(19, 2),
    categoria VARCHAR(100) NOT NULL,
    estoqueID INT NOT NULL,
    FOREIGN KEY (estoqueID) REFERENCES estoque(estoqueID)
);

-- Table: pedido_fornecedor
CREATE TABLE pedido_fornecedor (
    pedido_forID INT PRIMARY KEY,
    quantidade INT NOT NULL,
    valor DECIMAL(19, 2) NOT NULL,
    pedido_compra INT NOT NULL,
    it_cod INT NOT NULL,
    estoqueID INT NOT NULL, 
    FOREIGN KEY (pedido_compra) REFERENCES pedido_compra(ped_compra),
    FOREIGN KEY (it_cod) REFERENCES item(it_cod),
    FOREIGN KEY (estoqueID) REFERENCES estoque(estoqueID) 
);

CREATE TABLE cliente (
    clienteID INT PRIMARY KEY,
    usuarioID INT NOT NULL,
    cedula VARCHAR(12) NOT NULL,
    nome VARCHAR(40) NOT NULL,
    data_nascimento DATE,
    genero CHAR(1),
    email VARCHAR(60),
    telefone VARCHAR(20),
    rua VARCHAR(60) NOT NULL,
    bairro VARCHAR(60) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    provincia VARCHAR(50) NOT NULL,
    canton VARCHAR(50) NOT NULL,
    distrito VARCHAR(50) NOT NULL,
    codigo_postal INT NOT NULL,
    complemento VARCHAR(60),
    divida DECIMAL(10, 2),
    FOREIGN KEY (usuarioID) REFERENCES usuario(usuarioID)
);

-- Table: pagamento
CREATE TABLE pagamento (
    pagamentoID INT PRIMARY KEY,
    clienteID INT NOT NULL,
    data_pagamento DATE NOT NULL,
    valor_pago DECIMAL(10, 2) NOT NULL,
    forma_pagamento VARCHAR(20),
    status_pagamento VARCHAR(20),
    FOREIGN KEY (clienteID) REFERENCES cliente(clienteID)
);

-- Table: pedido_venda
CREATE TABLE pedido_venda (
    ped_venda INT PRIMARY KEY,
    clienteID INT NOT NULL,
    data_venda DATE NOT NULL,
    data_instalacao DATE,
    valor DECIMAL(19, 2),
    desconto DECIMAL(19, 2),
    FOREIGN KEY (clienteID) REFERENCES cliente(clienteID)
);

-- Table: item_venda
CREATE TABLE item_venda (
    itemID INT PRIMARY KEY,
    ped_venda INT NOT NULL,
    quantidade INT NOT NULL,
    valor_prod DECIMAL(19, 2),
    descricao VARCHAR(255),
    marca VARCHAR(255),
    garantia INT,
    composicao VARCHAR(255),
    origem VARCHAR(255),
    it_cod INT NOT NULL,
    FOREIGN KEY (ped_venda) REFERENCES pedido_venda(ped_venda),
    FOREIGN KEY (it_cod) REFERENCES item(it_cod)
);

-- Table: cliente_logistica
CREATE TABLE cliente_logistica (
    logisticalID INT PRIMARY KEY,
    ped_venda INT NOT NULL,
    cedula VARCHAR(12),
    data_entrega DATE NOT NULL,
    nome VARCHAR(40) NOT NULL,
    genero CHAR(1),
    data_nascimento DATE,
    email VARCHAR(60),
    telefone VARCHAR(20),
    rua VARCHAR(60) NOT NULL,
    bairro VARCHAR(60) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    provincia VARCHAR(50) NOT NULL,
    canton VARCHAR(50) NOT NULL,
    distrito VARCHAR(50) NOT NULL,
    codigo_postal INT NOT NULL,
    complemento VARCHAR(60),
    FOREIGN KEY (ped_venda) REFERENCES pedido_venda(ped_venda)
);

-- Comentários para a tabela empresa
COMMENT ON TABLE empresa IS 'Tabela que armazena as informações das empresas relacionadas à comercialização de painéis solares.';
COMMENT ON COLUMN empresa.companyID IS 'Identificador único da empresa (Chave Primária).';
COMMENT ON COLUMN empresa.nome IS 'Nome completo da empresa.';
COMMENT ON COLUMN empresa.websiteURL IS 'URL do site da empresa.';
COMMENT ON COLUMN empresa.email IS 'Endereço de e-mail de contato da empresa.';
COMMENT ON COLUMN empresa.telefone IS 'Número de telefone de contato da empresa.';
COMMENT ON COLUMN empresa.cidade IS 'Cidade onde a empresa está localizada.';
COMMENT ON COLUMN empresa.provincia IS 'Província onde a empresa está localizada.';
COMMENT ON COLUMN empresa.data_fundacao IS 'Data de fundação da empresa.';
COMMENT ON COLUMN empresa.cedula_juridica IS 'Número de identificação fiscal da empresa.';
COMMENT ON COLUMN empresa.setor IS 'Setor de atuação da empresa, como energia ou serviços.';
COMMENT ON COLUMN empresa.numero_licenca IS 'Número de licença de operação da empresa.';
COMMENT ON COLUMN empresa.rua IS 'Rua do endereço da empresa.';
COMMENT ON COLUMN empresa.bairro IS 'Bairro do endereço da empresa.';
COMMENT ON COLUMN empresa.canton IS 'Cantão onde a empresa está localizada.';
COMMENT ON COLUMN empresa.distrito IS 'Distrito onde a empresa está localizada.';
COMMENT ON COLUMN empresa.codigo_postal IS 'Código postal do endereço da empresa.';
COMMENT ON COLUMN empresa.complemento IS 'Complemento do endereço, como número e detalhes adicionais.';

-- Comentários para a tabela usuario
COMMENT ON TABLE usuario IS 'Tabela que registra os dados dos funcionários ou usuários do sistema.';
COMMENT ON COLUMN usuario.usuarioID IS 'Identificador único do usuário (Chave Primária).';
COMMENT ON COLUMN usuario.usuarioID_FK IS 'Referência para outro usuário, geralmente um supervisor ou gerente.';
COMMENT ON COLUMN usuario.companyID IS 'Identificador da empresa à qual o usuário está associado.';
COMMENT ON COLUMN usuario.nome IS 'Nome completo do usuário.';
COMMENT ON COLUMN usuario.genero IS 'Gênero do usuário (M para masculino, F para feminino).';
COMMENT ON COLUMN usuario.data_entrada IS 'Data de entrada do usuário na empresa.';
COMMENT ON COLUMN usuario.tipo IS 'Tipo ou cargo do usuário.';
COMMENT ON COLUMN usuario.cedula IS 'Número de identificação fiscal do usuário.';
COMMENT ON COLUMN usuario.data_nascimento IS 'Data de nascimento do usuário.';
COMMENT ON COLUMN usuario.departamento IS 'Departamento onde o usuário trabalha.';
COMMENT ON COLUMN usuario.data_admissao IS 'Data de admissão do usuário.';
COMMENT ON COLUMN usuario.salario IS 'Salário mensal do usuário.';
COMMENT ON COLUMN usuario.ativo IS 'Indica se o usuário está ativo (TRUE) ou inativo (FALSE).';
COMMENT ON COLUMN usuario.telefone IS 'Número de telefone do usuário.';
COMMENT ON COLUMN usuario.email IS 'Endereço de e-mail do usuário.'; 
COMMENT ON COLUMN usuario.rua IS 'Rua do endereço do usuário.';
COMMENT ON COLUMN usuario.bairro IS 'Bairro do endereço do usuário.';
COMMENT ON COLUMN usuario.cidade IS 'Cidade onde o usuário reside.';
COMMENT ON COLUMN usuario.canton IS 'Cantão do endereço do usuário.';
COMMENT ON COLUMN usuario.distrito IS 'Distrito do endereço do usuário.';
COMMENT ON COLUMN usuario.codigo_postal IS 'Código postal do endereço do usuário.';
COMMENT ON COLUMN usuario.complemento IS 'Complemento do endereço do usuário.';

-- Comentários para a tabela fornecedor
COMMENT ON TABLE fornecedor IS 'Tabela que armazena informações dos fornecedores de materiais ou produtos.';
COMMENT ON COLUMN fornecedor.fornecedorID IS 'Identificador único do fornecedor (Chave Primária).';
COMMENT ON COLUMN fornecedor.nome IS 'Nome do fornecedor.';
COMMENT ON COLUMN fornecedor.cedula IS 'Identificação fiscal do fornecedor.';
COMMENT ON COLUMN fornecedor.telefone IS 'Número de telefone do fornecedor.';
COMMENT ON COLUMN fornecedor.rua IS 'Rua do endereço do fornecedor.';
COMMENT ON COLUMN fornecedor.bairro IS 'Bairro do endereço do fornecedor.';
COMMENT ON COLUMN fornecedor.cidade IS 'Cidade onde o fornecedor está localizado.';
COMMENT ON COLUMN fornecedor.provincia IS 'Província onde o fornecedor está localizado.';
COMMENT ON COLUMN fornecedor.canton IS 'Cantão onde o fornecedor está localizado.';
COMMENT ON COLUMN fornecedor.codigo_postal IS 'Código postal do endereço do fornecedor.';
COMMENT ON COLUMN fornecedor.distrito IS 'Distrito onde o fornecedor está localizado.';
COMMENT ON COLUMN fornecedor.complemento IS 'Complemento do endereço do fornecedor.';

-- Comentários para a tabela pagamento_fornecedor
COMMENT ON TABLE pagamento_fornecedor IS 'Tabela que armazena informações sobre os pagamentos realizados a fornecedores.';
COMMENT ON COLUMN pagamento_fornecedor.pagamento_fornecedorID IS 'Identificador único do pagamento ao fornecedor (Chave Primária).';
COMMENT ON COLUMN pagamento_fornecedor.data_pagamento IS 'Data em que o pagamento foi realizado.';
COMMENT ON COLUMN pagamento_fornecedor.valor IS 'Valor do pagamento ao fornecedor.';
COMMENT ON COLUMN pagamento_fornecedor.forma_pagamento IS 'Forma de pagamento utilizada.';

-- Comentários para a tabela estoque
COMMENT ON TABLE estoque IS 'Tabela para controlar o estoque de itens da empresa.';
COMMENT ON COLUMN estoque.estoqueID IS 'Identificador único do estoque (Chave Primária).';
COMMENT ON COLUMN estoque.rua IS 'Localização do estoque na rua específica.';
COMMENT ON COLUMN estoque.prateleira IS 'Prateleira onde o item está armazenado.';
COMMENT ON COLUMN estoque.peso IS 'Peso dos itens armazenados no estoque.';
COMMENT ON COLUMN estoque.data_entrada IS 'Data de entrada dos itens no estoque.';
COMMENT ON COLUMN estoque.data_saida IS 'Data de saída dos itens do estoque.';
COMMENT ON COLUMN estoque.valor_compra IS 'Valor de compra dos itens armazenados.';
COMMENT ON COLUMN estoque.valor_venda IS 'Valor de venda dos itens armazenados.';

-- Comentários para a tabela pedido_compra
COMMENT ON TABLE pedido_compra IS 'Tabela para armazenar pedidos de compra feitos pela empresa.';
COMMENT ON COLUMN pedido_compra.ped_compra IS 'Identificador único do pedido de compra (Chave Primária).';
COMMENT ON COLUMN pedido_compra.data_compra IS 'Data em que o pedido de compra foi realizado.';
COMMENT ON COLUMN pedido_compra.data_entrega IS 'Data prevista para a entrega do pedido.';
COMMENT ON COLUMN pedido_compra.valor IS 'Valor total do pedido de compra.';
COMMENT ON COLUMN pedido_compra.desconto IS 'Valor do desconto aplicado ao pedido.';
COMMENT ON COLUMN pedido_compra.usuarioID IS 'Identificador do usuário que realizou o pedido.';
COMMENT ON COLUMN pedido_compra.pagamento_fornecedorID IS 'Identificador do pagamento associado ao fornecedor.';
COMMENT ON COLUMN pedido_compra.fornecedorID IS 'Identificador do fornecedor para o pedido.';

-- Comentários para a tabela pedido_fornecedor
COMMENT ON TABLE pedido_fornecedor IS 'Tabela que armazena os detalhes dos pedidos feitos aos fornecedores.';
COMMENT ON COLUMN pedido_fornecedor.pedido_forID IS 'Identificador único do pedido ao fornecedor (Chave Primária).';
COMMENT ON COLUMN pedido_fornecedor.quantidade IS 'Quantidade de itens solicitados no pedido.';
COMMENT ON COLUMN pedido_fornecedor.valor IS 'Valor total do pedido.';
COMMENT ON COLUMN pedido_fornecedor.pedido_compra IS 'Referência ao pedido de compra associado.';
COMMENT ON COLUMN pedido_fornecedor.estoqueID IS 'Identificador do estoque onde os itens serão armazenados.';
COMMENT ON COLUMN pedido_fornecedor.it_cod IS 'ID do item.';

-- Comentários para a tabela item
COMMENT ON TABLE item IS 'Tabela que armazena informações sobre os itens disponíveis no estoque.';
COMMENT ON COLUMN item.it_cod IS 'Identificador único de cada item (Chave Primária).';
COMMENT ON COLUMN item.nome IS 'Nome do item (por exemplo, painel solar, inversor).';
COMMENT ON COLUMN item.descricao IS 'Descrição detalhada do item.';
COMMENT ON COLUMN item.quantidade IS 'Quantidade de itens disponíveis.';
COMMENT ON COLUMN item.valor IS 'Valor unitário do item.';
COMMENT ON COLUMN item.categoria IS 'Categoria a que o item pertence.';
COMMENT ON COLUMN item.estoqueID IS 'Referência ao estoque onde o item está armazenado.';

-- Comentários para a tabela cliente
COMMENT ON TABLE cliente IS 'Tabela que armazena os dados dos clientes.';
COMMENT ON COLUMN cliente.clienteID IS 'Identificador único do cliente (Chave Primária).';
COMMENT ON COLUMN cliente.usuarioID IS 'Referência ao usuário responsável pelo cliente.';
COMMENT ON COLUMN cliente.cedula IS 'Identificação fiscal do cliente.';
COMMENT ON COLUMN cliente.nome IS 'Nome completo do cliente.';
COMMENT ON COLUMN cliente.data_nascimento IS 'Data de nascimento do cliente.';
COMMENT ON COLUMN cliente.genero IS 'Gênero do cliente (M para masculino, F para feminino).';
COMMENT ON COLUMN cliente.email IS 'Endereço de e-mail do cliente (único).';
COMMENT ON COLUMN cliente.telefone IS 'Número de telefone do cliente.';   
COMMENT ON COLUMN cliente.divida IS 'Dívida atual do cliente.';
COMMENT ON COLUMN cliente.rua IS 'Rua do endereço do cliente.';
COMMENT ON COLUMN cliente.bairro IS 'Bairro do endereço do cliente.';
COMMENT ON COLUMN cliente.cidade IS 'Cidade do cliente.';
COMMENT ON COLUMN cliente.provincia IS 'Província do cliente.';
COMMENT ON COLUMN cliente.canton IS 'Cantão do cliente.';
COMMENT ON COLUMN cliente.distrito IS 'Distrito do cliente.';
COMMENT ON COLUMN cliente.codigo_postal IS 'Código postal do cliente.';
COMMENT ON COLUMN cliente.complemento IS 'Complemento do endereço do cliente.';

-- Comentários para a tabela pagamento
COMMENT ON TABLE pagamento IS 'Tabela que armazena registros de pagamentos realizados pelos clientes.';
COMMENT ON COLUMN pagamento.pagamentoID IS 'Identificador único do pagamento (Chave Primária).';
COMMENT ON COLUMN pagamento.clienteID IS 'Referência ao cliente que realizou o pagamento.';
COMMENT ON COLUMN pagamento.data_pagamento IS 'Data do pagamento realizado.';
COMMENT ON COLUMN pagamento.valor_pago IS 'Valor total pago pelo cliente.';
COMMENT ON COLUMN pagamento.forma_pagamento IS 'Método utilizado para o pagamento.';
COMMENT ON COLUMN pagamento.status_pagamento IS 'Status atual do pagamento (Pago ou pendente).';

-- Comentários para a tabela pedido_venda
COMMENT ON TABLE pedido_venda IS 'Tabela que armazena os pedidos de venda realizados por clientes.';
COMMENT ON COLUMN pedido_venda.ped_venda IS 'Identificador único do pedido de venda (Chave Primária).';
COMMENT ON COLUMN pedido_venda.clienteID IS 'Referência ao cliente que realizou o pedido.';
COMMENT ON COLUMN pedido_venda.data_venda IS 'Data em que o pedido foi feito.';
COMMENT ON COLUMN pedido_venda.data_instalacao IS 'Data de instalação dos produtos vendidos.';
COMMENT ON COLUMN pedido_venda.valor IS 'Valor total do pedido de venda.';
COMMENT ON COLUMN pedido_venda.desconto IS 'Desconto aplicado no pedido de venda.';

-- Comentários para a tabela item_venda
COMMENT ON TABLE item_venda IS 'Tabela que armazena informações dos itens vendidos aos clientes.';
COMMENT ON COLUMN item_venda.itemID IS 'Identificador único do item de venda (Chave Primária).';
COMMENT ON COLUMN item_venda.ped_venda IS 'Referência ao pedido de venda associado.';
COMMENT ON COLUMN item_venda.it_cod IS 'Referência ao código do item vendido.';
COMMENT ON COLUMN item_venda.quantidade IS 'Quantidade de itens vendidos.';
COMMENT ON COLUMN item_venda.valor_prod IS 'Valor do produto vendido.';
COMMENT ON COLUMN item_venda.descricao IS 'Descrição do item vendido.';
COMMENT ON COLUMN item_venda.marca IS 'Marca do item vendido.';
COMMENT ON COLUMN item_venda.garantia IS 'Informação sobre garantia do item.';
COMMENT ON COLUMN item_venda.composicao IS 'Composição do item vendido.';
COMMENT ON COLUMN item_venda.origem IS 'Origem do item vendido.'; 

-- Comentários para a tabela cliente_logistica
COMMENT ON TABLE cliente_logistica IS 'Tabela que armazena informações sobre a logística dos pedidos entregues aos clientes.';
COMMENT ON COLUMN cliente_logistica.LogisticalID IS 'Identificador único da logística (Chave Primária).';
COMMENT ON COLUMN cliente_logistica.ped_venda IS 'Referência ao pedido de venda associado.';
COMMENT ON COLUMN cliente_logistica.cedula IS 'Identificação fiscal do cliente.';
COMMENT ON COLUMN cliente_logistica.data_entrega IS 'Data de entrega dos produtos ao cliente.';
COMMENT ON COLUMN cliente_logistica.nome IS 'Nome da pessoa responsável pelo recebimento do pedido.';
COMMENT ON COLUMN cliente_logistica.genero IS 'Gênero da pessoa (M para masculino, F para feminino).';
COMMENT ON COLUMN cliente_logistica.data_nascimento IS 'Data de nascimento da pessoa responsável.';
COMMENT ON COLUMN cliente_logistica.email IS 'Endereço de e-mail para contato.';
COMMENT ON COLUMN cliente_logistica.telefone IS 'Número de telefone para contato.'; 
COMMENT ON COLUMN cliente_logistica.rua IS 'Rua do endereço de entrega.';
COMMENT ON COLUMN cliente_logistica.bairro IS 'Bairro do endereço de entrega.';
COMMENT ON COLUMN cliente_logistica.cidade IS 'Cidade de entrega do pedido.';
COMMENT ON COLUMN cliente_logistica.provincia IS 'Província de entrega do pedido.';
COMMENT ON COLUMN cliente_logistica.canton IS 'Cantão de entrega do pedido.';
COMMENT ON COLUMN cliente_logistica.distrito IS 'Distrito de entrega do pedido.';
COMMENT ON COLUMN cliente_logistica.codigo_postal IS 'Código postal do endereço de entrega.';
COMMENT ON COLUMN cliente_logistica.complemento IS 'Complemento do endereço de entrega.';


-- Índice para a tabela 'cliente' no campo 'clienteID'
CREATE INDEX idx_cliente_clienteID ON cliente (clienteID);

-- Índices para a tabela 'pedido_fornecedor' relacionados a vendas
CREATE INDEX idx_pedido_fornecedor_pedido_compra ON pedido_fornecedor (pedido_compra);
CREATE INDEX idx_pedido_fornecedor_it_cod ON pedido_fornecedor (it_cod);
CREATE INDEX idx_pedido_fornecedor_estoqueID ON pedido_fornecedor (estoqueID);


-- Criar sequencias de geração da ID 

-- Criar a sequência para o ID da tabela empresa
CREATE SEQUENCE empresa_id_seq
    START WITH 2
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
    START WITH 7
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
    START WITH 6
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
    START WITH 6
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
    START WITH 6
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
    START WITH 6
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
    START WITH 6
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
    START WITH 6
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
    START WITH 6
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
    START WITH 6
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
    START WITH 6
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
    START WITH 6
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
    START WITH 6
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Alterar a coluna logisticalID para usar a sequência como valor padrão
ALTER TABLE cliente_logistica ALTER COLUMN logisticalID SET DEFAULT nextval('cliente_logistica_id_seq');

-- Garantir que a sequência seja usada corretamente na tabela
ALTER SEQUENCE cliente_logistica_id_seq OWNED BY cliente_logistica.logisticalID;




-- Criação da auditoria

-- Tabela de Auditoria
CREATE TABLE auditoria (
    auditoriaID SERIAL PRIMARY KEY,        
    tabela VARCHAR(50) NOT NULL,           
    operacao VARCHAR(10) NOT NULL,         
    data_hora TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  
    usuario VARCHAR(60),                 
    chave_primaria TEXT,                 
    dados_anteriores JSONB,              
    dados_novos JSONB                    
);

CREATE OR REPLACE FUNCTION registrar_auditoria()
RETURNS TRIGGER AS $$
BEGIN
    -- Insere um registro na tabela de auditoria
    INSERT INTO auditoria (
        tabela,
        operacao,
        usuario,
        chave_primaria,
        dados_anteriores,
        dados_novos
    )
    VALUES (
        TG_TABLE_NAME,           -- Nome da tabela
        TG_OP,                   -- Operação (INSERT, UPDATE, DELETE)
        SESSION_USER,            -- Usuário responsável
        CASE                     -- Chave primária
            WHEN TG_OP = 'DELETE' THEN row_to_json(OLD)::JSONB
            ELSE row_to_json(NEW)::JSONB
        END,
        CASE                     -- Dados anteriores (para UPDATE e DELETE)
            WHEN TG_OP IN ('UPDATE', 'DELETE') THEN row_to_json(OLD)::JSONB
            ELSE NULL
        END,
        CASE                     -- Dados novos (para INSERT e UPDATE)
            WHEN TG_OP IN ('INSERT', 'UPDATE') THEN row_to_json(NEW)::JSONB
            ELSE NULL
        END
    );
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Criar Triggers para Todas as Tabelas
-- Exemplo para a tabela `empresa`
CREATE TRIGGER auditoria_empresa
AFTER INSERT OR UPDATE OR DELETE ON empresa
FOR EACH ROW EXECUTE FUNCTION registrar_auditoria();

-- Replique a criação de triggers para cada tabela
CREATE TRIGGER auditoria_usuario
AFTER INSERT OR UPDATE OR DELETE ON usuario
FOR EACH ROW EXECUTE FUNCTION registrar_auditoria();

CREATE TRIGGER auditoria_fornecedor
AFTER INSERT OR UPDATE OR DELETE ON fornecedor
FOR EACH ROW EXECUTE FUNCTION registrar_auditoria();

CREATE TRIGGER auditoria_pagamento_fornecedor
AFTER INSERT OR UPDATE OR DELETE ON pagamento_fornecedor
FOR EACH ROW EXECUTE FUNCTION registrar_auditoria();

CREATE TRIGGER auditoria_estoque
AFTER INSERT OR UPDATE OR DELETE ON estoque
FOR EACH ROW EXECUTE FUNCTION registrar_auditoria();

CREATE TRIGGER auditoria_pedido_compra
AFTER INSERT OR UPDATE OR DELETE ON pedido_compra
FOR EACH ROW EXECUTE FUNCTION registrar_auditoria();

CREATE TRIGGER auditoria_item
AFTER INSERT OR UPDATE OR DELETE ON item
FOR EACH ROW EXECUTE FUNCTION registrar_auditoria();

CREATE TRIGGER auditoria_pedido_fornecedor
AFTER INSERT OR UPDATE OR DELETE ON pedido_fornecedor
FOR EACH ROW EXECUTE FUNCTION registrar_auditoria();

CREATE TRIGGER auditoria_cliente
AFTER INSERT OR UPDATE OR DELETE ON cliente
FOR EACH ROW EXECUTE FUNCTION registrar_auditoria();

CREATE TRIGGER auditoria_pagamento
AFTER INSERT OR UPDATE OR DELETE ON pagamento
FOR EACH ROW EXECUTE FUNCTION registrar_auditoria();

CREATE TRIGGER auditoria_pedido_venda
AFTER INSERT OR UPDATE OR DELETE ON pedido_venda
FOR EACH ROW EXECUTE FUNCTION registrar_auditoria();

CREATE TRIGGER auditoria_item_venda
AFTER INSERT OR UPDATE OR DELETE ON item_venda
FOR EACH ROW EXECUTE FUNCTION registrar_auditoria();

CREATE TRIGGER auditoria_cliente_logistica
AFTER INSERT OR UPDATE OR DELETE ON cliente_logistica
FOR EACH ROW EXECUTE FUNCTION registrar_auditoria();


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


-- Inserts das tabelas

-- Insert for empresa
INSERT INTO empresa (companyID, nome, websiteURL, email, telefone, cidade, provincia, data_fundacao, cedula_juridica, setor, numero_licenca, rua, bairro, canton, distrito, codigo_postal, complemento)
VALUES 
(1, 'SunBridge', 'https://sunbridge.cr', 'contact@sunbridge.cr', '+506 2100 1234', 'San José', 'San José', '2005-08-15', '123456789012', 'Energia Solar', 'LIC123456', 'Rua Central', 'Centro', 'San José', 'Catedral', 10101, 'Sala 1');

-- Inserts for usuario
INSERT INTO usuario (usuarioID, usuarioID_FK, companyID, nome, genero, data_entrada, tipo, cedula, data_nascimento, departamento, data_admissao, salario, ativo, telefone, email, senha, rua, bairro, cidade, canton, distrito, codigo_postal, complemento) 
VALUES 
  (1, NULL, 1, 'Leonardo Mateus Bortoluzzi Thums', 'M', '2023-01-01', 1, '12345678901', '1990-01-01', 'TI', '2023-01-01', 4500.00, TRUE, '555-1111', 'leonardo@empresa.com', '123', 'Rua Principal', 'Centro', 'Cidade Exemplo', 'Cantão A', 'Distrito A', 12345, 'Apto 101'),
  (2, 1, 1, 'Pietro Porsch Wilhelms', 'M', '2023-01-03', 3, '12345678903', '1993-03-03', 'Financeiro', '2023-01-03', 5500.00, TRUE, '555-3333', 'pietro@empresa.com', '123', 'Rua Principal', 'Centro', 'Cidade Exemplo', 'Cantão A', 'Distrito A', 12345, 'Apto 103'),
  (3, 1, 1, 'Rafael Luan Schmitz', 'M', '2023-01-04', 4, '12345678904', '1994-04-04', 'Marketing', '2023-01-04', 4800.00, TRUE, '555-4444', 'rafael@empresa.com', '123', 'Rua Principal', 'Centro', 'Cidade Exemplo', 'Cantão A', 'Distrito A', 12345, 'Apto 104'),
  (4, 1, 1, 'Rodrigo Miguel Teles Dos Santos', 'M', '2023-01-05', 5, '12345678905', '1995-05-05', 'Operações', '2023-01-05', 4700.00, TRUE, '555-5555', 'rodrigo@empresa.com', '123', 'Rua Principal', 'Centro', 'Cidade Exemplo', 'Cantão A', 'Distrito A', 12345, 'Apto 105'),
  (5, 1, 1, 'Samuel Fernando Bortoluzzi Thums', 'M', '2023-01-06', 6, '12345678906', '1996-06-06', 'Logística', '2023-01-06', 4600.00, TRUE, '555-6666', 'samuel@empresa.com', '123', 'Rua Principal', 'Centro', 'Cidade Exemplo', 'Cantão A', 'Distrito A', 12345, 'Apto 106'),
  (6, 5, 1, 'Luiz Felipe Christani', 'M', '2023-01-02', 2, '12345678902', '1992-02-02', 'RH', '2023-01-02', 5000.00, TRUE, '555-2222', 'luiz@empresa.com', '123', 'Rua Principal', 'Centro', 'Cidade Exemplo', 'Cantão A', 'Distrito A', 12345, 'Apto 102');


-- Inserts for fornecedor
INSERT INTO fornecedor (fornecedorID, nome, cedula, telefone, rua, bairro, cidade, provincia, canton, distrito, codigo_postal, complemento)
VALUES 
(1, 'SolarTech Supplies', '111111111', '+506 6000 1234', 'Calle 15', 'San José Centro', 'San José', 'San José', 'San José', 'Catedral', 10101, ''),
(2, 'Energy Parts CR', '222222222', '+506 6000 5678', 'Calle 20', 'Sabana Norte', 'San José', 'San José', 'San José', 'Mata Redonda', 10109, ''),
(3, 'Distribuidora Verde', '333333333', '+506 6000 8765', 'Calle 8', 'Barrio Amón', 'San José', 'San José', 'San José', 'Carmen', 10105, ''),
(4, 'EcoSoluciones', '444444444', '+506 6000 4321', 'Calle 3', 'Desamparados', 'Desamparados', 'San José', 'Desamparados', 'San Rafael', 10301, ''),
(5, 'Paneles y Más', '555555555', '+506 6000 0000', 'Avenida 5', 'Escazú', 'Escazú', 'San José', 'Escazú', 'San Rafael', 10201, '');

-- Inserts for pagamento_fornecedor
INSERT INTO pagamento_fornecedor (pagamento_fornecedorID, data_pagamento, valor, forma_pagamento)
VALUES 
(1, '2023-01-10', 10000.00, 'Transferência'),
(2, '2023-02-15', 20000.00, 'Cartão de Crédito'),
(3, '2023-03-20', 15000.00, 'Transferência'),
(4, '2023-04-05', 25000.00, 'Boleto'),
(5, '2023-05-25', 30000.00, 'Pix');

-- Inserts for estoque
INSERT INTO estoque (estoqueID, rua, prateleira, peso, data_entrada, data_saida, valor_compra, valor_venda)
VALUES 
(1, 'Rua Solar', 'A1', 500, '2023-06-01', NULL, 5000.00, 7500.00),
(2, 'Rua Solar', 'A2', 300, '2023-06-02', NULL, 3000.00, 4500.00),
(3, 'Rua Solar', 'A3', 200, '2023-06-03', NULL, 2000.00, 3000.00),
(4, 'Rua Solar', 'A4', 400, '2023-06-04', NULL, 4000.00, 6000.00),
(5, 'Rua Solar', 'A5', 600, '2023-06-05', NULL, 6000.00, 9000.00);

-- Inserts for cliente
INSERT INTO cliente (clienteID, usuarioID, cedula, nome, data_nascimento, genero, email, telefone, rua, bairro, cidade, provincia, canton, distrito, codigo_postal, complemento)
VALUES
(1, 1, '123456789', 'Juan Ramirez', '1985-03-14', 'M', 'juan.ramirez@mail.com', '+506 8001 1234', 'Calle 10', 'San Pedro', 'San José', 'San José', 'Montes de Oca', 'San Pedro', 11501, ''),
(2, 2, '987654321', 'Sofia Morales', '1990-07-25', 'F', 'sofia.morales@mail.com', '+506 8002 5678', 'Calle 12', 'Barrio Escalante', 'San José', 'San José', 'Carmen', 'Escalante', 10105, ''),
(3, 3, '456789123', 'Andres Castro', '1978-02-19', 'M', 'andres.castro@mail.com', '+506 8003 8765', 'Calle 8', 'Zapote', 'San José', 'San José', 'San Francisco', 'Zapote', 10203, ''),
(4, 4, '321654987', 'Laura Jimenez', '1983-05-12', 'F', 'laura.jimenez@mail.com', '+506 8004 4321', 'Calle 15', 'Hatillo', 'San José', 'San José', 'Hatillo', 'Hatillo 1', 10107, ''),
(5, 5, '654987321', 'Mario Vargas', '1992-08-30', 'M', 'mario.vargas@mail.com', '+506 8005 1111', 'Calle 20', 'Sabana', 'San José', 'San José', 'Mata Redonda', 'Sabana Oeste', 10109, '');

-- Inserts for pagamento
INSERT INTO pagamento (pagamentoID, clienteID, data_pagamento, valor_pago, forma_pagamento, status_pagamento)
VALUES
(1, 1, '2023-01-05', 500.00, 'Transferência', 'Pago'),
(2, 2, '2023-01-10', 750.00, 'Cartão de Crédito', 'Pago'),
(3, 3, '2023-02-20', 1200.00, 'Pix', 'Pago'),
(4, 4, '2023-03-15', 300.00, 'Boleto', 'Pendente'),
(5, 5, '2023-04-10', 1500.00, 'Transferência', 'Pago');

-- Inserts for pedido_compra
INSERT INTO pedido_compra (ped_compra, data_compra, data_entrega, valor, desconto, usuarioID, pagamento_fornecedorID, fornecedorID)
VALUES
(1, '2023-05-10', '2023-05-15', 10000.00, 500.00, 1, 1, 1),
(2, '2023-05-20', '2023-05-25', 20000.00, 1000.00, 2, 2, 2),
(3, '2023-06-01', '2023-06-05', 15000.00, 750.00, 3, 3, 3),
(4, '2023-06-15', '2023-06-20', 25000.00, 1250.00, 4, 4, 4),
(5, '2023-07-01', '2023-07-05', 30000.00, 1500.00, 5, 5, 5);

-- Inserts for item
INSERT INTO item (it_cod, nome, descricao, quantidade, valor, categoria, estoqueID)
VALUES
(1, 'Painel Solar 250W', 'Painel solar monocristalino de 250W', 50, 200.00, 'Painel Solar', 1),
(2, 'Inversor 3kW', 'Inversor de corrente contínua para corrente alternada', 30, 150.00, 'Inversor', 2),
(3, 'Bateria 200Ah', 'Bateria para armazenamento de energia', 20, 300.00, 'Bateria', 3),
(4, 'Controlador de Carga', 'Controlador de carga para sistema solar', 40, 100.00, 'Controlador', 4),
(5, 'Estrutura de Montagem', 'Estrutura para instalação de painéis solares', 60, 50.00, 'Estrutura', 5);

-- Inserts for pedido_fornecedor
INSERT INTO pedido_fornecedor (pedido_forID, quantidade, valor, pedido_compra, it_cod, estoqueID)
VALUES
(1, 50, 5000.00, 1, 1, 1),
(2, 30, 3000.00, 2, 2, 2),
(3, 20, 2000.00, 3, 3, 3),
(4, 40, 4000.00, 4, 4, 4),
(5, 60, 6000.00, 5, 5, 5);

-- Inserts for pedido_venda
INSERT INTO pedido_venda (ped_venda, clienteID, data_venda, data_instalacao, valor, desconto)
VALUES
(1, 1, '2023-05-10', '2023-05-20', 1500.00, 50.00),
(2, 2, '2023-05-15', '2023-05-25', 2500.00, 100.00),
(3, 3, '2023-06-01', '2023-06-10', 2000.00, 75.00),
(4, 4, '2023-06-20', '2023-06-30', 3000.00, 125.00),
(5, 5, '2023-07-01', '2023-07-10', 3500.00, 150.00);

-- Inserts for item_venda
INSERT INTO item_venda (it_cod, itemID, ped_venda, quantidade, valor_prod, descricao, marca, garantia, composicao, origem)
VALUES
(1, 1, 1, 2, 400.00, 'Painel Solar 250W', 'SunPower', 10, 'Monocristalino', 'Costa Rica'),
(2, 2, 2, 1, 800.00, 'Inversor 3kW', 'InverTech', 5, 'Eletrônico', 'Alemanha'),
(3, 3, 3, 4, 1200.00, 'Bateria 200Ah', 'BatLife', 7, 'Lítio', 'China'),
(4, 4, 4, 3, 600.00, 'Controlador de Carga', 'ControlTech', 3, 'Eletrônico', 'EUA'),
(5, 5, 5, 5, 250.00, 'Estrutura de Montagem', 'StrucPro', 5, 'Alumínio', 'Brasil');

-- Inserts for cliente_logistica
INSERT INTO cliente_logistica (logisticalID, ped_venda, cedula, data_entrega, nome, genero, data_nascimento, email, telefone, rua, bairro, cidade, provincia, canton, distrito, codigo_postal, complemento)
VALUES
(1, 1, '123456789', '2023-05-20', 'Juan Ramirez', 'M', '1985-03-14', 'juan.ramirez@mail.com', '+506 8001 1234', 'Calle 10', 'San Pedro', 'San José', 'San José', 'Montes de Oca', 'San Pedro', 11501, ''),
(2, 2, '987654321', '2023-05-25', 'Sofia Morales', 'F', '1990-07-25', 'sofia.morales@mail.com', '+506 8002 5678', 'Calle 12', 'Barrio Escalante', 'San José', 'San José', 'Carmen', 'Escalante', 10105, ''),
(3, 3, '456789123', '2023-06-10', 'Andres Castro', 'M', '1978-02-19', 'andres.castro@mail.com', '+506 8003 8765', 'Calle 8', 'Zapote', 'San José', 'San José', 'San Francisco', 'Zapote', 10203, ''),
(4, 4, '321654987', '2023-06-30', 'Laura Jimenez', 'F', '1983-05-12', 'laura.jimenez@mail.com', '+506 8004 4321', 'Calle 15', 'Hatillo', 'San José', 'San José', 'Hatillo', 'Hatillo 1', 10107, ''),
(5, 5, '654987321', '2023-07-10', 'Mario Vargas', 'M', '1992-08-30', 'mario.vargas@mail.com', '+506 8005 1111', 'Calle 20', 'Sabana', 'San José', 'San José', 'Mata Redonda', 'Sabana Oeste', 10109, '');




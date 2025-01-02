CREATE TABLE cliente_logistica (
    logisticaID SERIAL NOT NULL, 
    ped_venda int4 NOT NULL,
    cedula varchar(12) NOT NULL, 
    data_entrega date NOT NULL, 
    nome varchar(40) NOT NULL,
    data_nascimento date NOT NULL,
    genero varchar(1) NOT NULL CHECK (genero IN ('F', 'M')),
    email varchar(60) NOT NULL UNIQUE, 
    telefone varchar(20) NOT NULL,    
    data_cadastro date NOT NULL,
    rua varchar(60) NOT NULL, 
    bairro varchar(60) NOT NULL, 
    cidade varchar(50) NOT NULL, 
    provincia varchar(50) NOT NULL, 
    canton varchar(50) NOT NULL, 
    distrito varchar(50) NOT NULL, 
    codigo_postal varchar(10) NOT NULL,
    complemento varchar(60) NOT NULL, 
    PRIMARY KEY (logisticaID)
);

COMMENT ON TABLE cliente_logistica IS 'Tabela para guardar a informação de quem pegou os produtos do armazem e levou ao cliente';
COMMENT ON COLUMN cliente_logistica.logisticaID IS 'Identificador único para cada pessoa da logistica (Chave Primária)';
COMMENT ON COLUMN cliente_logistica.cedula IS 'Identificador único para cada pessoa fiscal';
COMMENT ON COLUMN cliente_logistica.ped_venda IS 'Identificador único para logistica do pedido';
COMMENT ON COLUMN cliente_logistica.data_entrega IS 'Data de entrega';
COMMENT ON COLUMN cliente_logistica.nome IS 'Nome da pessoa  que buscou o produto';
COMMENT ON COLUMN cliente_logistica.data_nascimento IS 'Data de nascimento do cliente que que buscou o produto';
COMMENT ON COLUMN cliente_logistica.genero IS 'Genero do cliente logistica (M = masculino, F = feminino)';
COMMENT ON COLUMN cliente_logistica.email IS 'E-mail do cliente  que buscou o produto';
COMMENT ON COLUMN cliente_logistica.telefone IS 'Telefone do cliente  que buscou o produto';
COMMENT ON COLUMN cliente_logistica.data_cadastro IS 'Data de cadastro do cliente que buscou o produto';
COMMENT ON COLUMN cliente_logistica.rua IS 'Rua do cliente que pegou/onde foi entregue';
COMMENT ON COLUMN cliente_logistica.bairro IS 'Bairro do cliente que buscou o produto';
COMMENT ON COLUMN cliente_logistica.cidade IS 'Cidade do cliente da logistica  que buscou o produto';
COMMENT ON COLUMN cliente_logistica.provincia IS 'Província da Costa Rica (por exemplo, San José, Alajuela)';
COMMENT ON COLUMN cliente_logistica.canton IS 'Cantão da Costa Rica (por exemplo, Escazú, Grecia)';
COMMENT ON COLUMN cliente_logistica.distrito IS 'Distrito da Costa Rica (por exemplo, San Rafael, San Isidro)';
COMMENT ON COLUMN cliente_logistica.codigo_postal IS 'Código postal da Costa Rica (5 dígitos)';
COMMENT ON COLUMN cliente_logistica.complemento IS 'Complementos, como numero da casa, do cliente que buscou o produto';

CREATE TABLE cliente (
    clienteID SERIAL NOT NULL,
    cedula varchar(12) NOT NULL, 
    usuarioID int4 NOT NULL, 
    nome varchar(40) NOT NULL, 
    data_nascimento date NOT NULL,
    genero_cliente varchar(1) NOT NULL CHECK (genero_cliente IN ('F', 'M')),
    email varchar(60) NOT NULL UNIQUE, 
    telefone varchar(20) NOT NULL, 
    registration_date date DEFAULT NOW() NOT NULL, 
    ativo boolean NOT NULL, 
    descricao varchar(255), 
    divida varchar(10) NOT NULL,
    rua varchar(60) NOT NULL,               
    bairro varchar(60) NOT NULL, 
    cidade varchar(50) NOT NULL, 
    provincia varchar(50) NOT NULL, 
    canton varchar(50) NOT NULL, 
    distrito varchar(50) NOT NULL, 
    codigo_postal varchar(10) NOT NULL,
    complemento varchar(60) NOT NULL, 
    PRIMARY KEY (clienteID)
);

COMMENT ON TABLE cliente IS 'Tabela dos cliente';
COMMENT ON COLUMN cliente.clienteID IS 'Identificador único para cada cliente (Chave Primária)';
COMMENT ON COLUMN cliente.cedula IS 'Identificador único para cada pessoa fiscal';
COMMENT ON COLUMN cliente.usuarioID IS 'Chave estrangeira referenciando a quem vendeu';
COMMENT ON COLUMN cliente.nome IS 'Nome do cliente';
COMMENT ON COLUMN cliente.data_nascimento IS 'Data de nascimento do cliente';
COMMENT ON COLUMN cliente.genero_cliente IS 'Sexo do cliente (M = masculino, F = feminino)';
COMMENT ON COLUMN cliente.email IS 'Endereço de e-mail do cliente (Restrição única para evitar duplicatas)';
COMMENT ON COLUMN cliente.telefone IS 'Número de telefone do cliente (pode incluir código do país e formatação para a Costa Rica)';
COMMENT ON COLUMN cliente.registration_date IS 'Data e hora em que o cliente se cadastrou no sistema';
COMMENT ON COLUMN cliente.ativo IS 'Indica se o cliente está ativo (TRUE) ou inativo (FALSE)';
COMMENT ON COLUMN cliente.descricao IS 'Anotações ou comentários adicionais sobre o cliente';
COMMENT ON COLUMN cliente.divida IS 'Valor de quanto o cliente deve referente a compra, o valor será sempre menor que 0';
COMMENT ON COLUMN cliente.rua IS 'Rua/avenida e afins, do cliente';
COMMENT ON COLUMN cliente.bairro IS 'Bairro do cliente';
COMMENT ON COLUMN cliente.cidade IS 'Cidade do cliente';
COMMENT ON COLUMN cliente.provincia IS 'Província da Costa Rica (por exemplo, San José, Alajuela)';
COMMENT ON COLUMN cliente.canton IS 'Cantão da Costa Rica (por exemplo, Escazú, Grecia)';
COMMENT ON COLUMN cliente.distrito IS 'Distrito da Costa Rica (por exemplo, San Rafael, San Isidro)';
COMMENT ON COLUMN cliente.codigo_postal IS 'Código postal da Costa Rica (5 dígitos)';
COMMENT ON COLUMN cliente.complemento IS 'Complementos, como numero da casa, do cliente que buscou o produto';

CREATE TABLE empresa (
    companyID SERIAL NOT NULL, 
    nome varchar(40) NOT NULL UNIQUE, 
    logo varchar(60),
    website_url varchar(255) NOT NULL, 
    email varchar(60) NOT NULL, 
    telefone varchar(20) NOT NULL, 
    cidade varchar(50) NOT NULL, 
    provincia varchar(50) NOT NULL, 
    data_fundacao date NOT NULL, 
    cedula_juridica varchar(12) NOT NULL, 
    setor varchar(100) NOT NULL, 
    numero_licenca varchar(25) NOT NULL, 
    rua varchar(60) NOT NULL, 
    bairro varchar(60) NOT NULL, 
    canton varchar(50) NOT NULL, 
    distrito varchar(50) NOT NULL, 
    codigo_postal varchar(10) NOT NULL,
    complemento varchar(60) NOT NULL, 
    PRIMARY KEY (companyID)
);

COMMENT ON TABLE empresa IS 'Tabela com os dados da empresa';
COMMENT ON COLUMN empresa.companyID IS 'Identificador único para cada empresa';
COMMENT ON COLUMN empresa.nome IS 'Nome completo da empresa';
COMMENT ON COLUMN empresa.logo IS 'Logo da empresa (opcional)';
COMMENT ON COLUMN empresa.website_url IS 'URL do website da empresa';     
COMMENT ON COLUMN empresa.email IS 'Endereço de e-mail da empresa';
COMMENT ON COLUMN empresa.telefone IS 'Número de telefone da empresa, idealmente no formato internacional';
COMMENT ON COLUMN empresa.cidade IS 'Cidade onde a empresa está localizada';
COMMENT ON COLUMN empresa.provincia IS 'Província onde a empresa está localizada';
COMMENT ON COLUMN empresa.data_fundacao IS 'Data de fundação da empresa';
COMMENT ON COLUMN empresa.cedula_juridica IS 'Número de identificação da empresa (cédula jurídica)';
COMMENT ON COLUMN empresa.setor IS 'Setor de atividade da empresa (ex: Tecnologia, Serviços, etc.)';
COMMENT ON COLUMN empresa.numero_licenca IS 'Número de registro da empresa no Registro Nacional';
COMMENT ON COLUMN empresa.rua IS 'Rua/avenida e afins, da empresa';
COMMENT ON COLUMN empresa.bairro IS 'Bairro da empresa';
COMMENT ON COLUMN empresa.cidade IS 'Cidade da empresa';
COMMENT ON COLUMN empresa.provincia IS 'Província da Costa Rica (por exemplo, San José, Alajuela)';
COMMENT ON COLUMN empresa.canton IS 'Cantão da Costa Rica (por exemplo, Escazú, Grecia)';
COMMENT ON COLUMN empresa.distrito IS 'Distrito da Costa Rica (por exemplo, San Rafael, San Isidro)';
COMMENT ON COLUMN empresa.codigo_postal IS 'Código postal da Costa Rica (5 dígitos)';
COMMENT ON COLUMN empresa.complemento IS 'Complementos, como numero e afins';

CREATE TABLE estoque (
    estoqueID SERIAL NOT NULL, 
    quantidade int4 NOT NULL, 
    rua varchar(30) NOT NULL,
    prateleira varchar(10) NOT NULL,
    peso int4 NOT NULL,
    data_entrada date NOT NULL, 
    data_saida date, 
    valor_compra numeric(19, 2) NOT NULL, 
    valor_venda numeric(19, 2) NOT NULL, 
    PRIMARY KEY (estoqueID)
);

COMMENT ON TABLE estoque IS 'Controle de estoque';
COMMENT ON COLUMN estoque.estoqueID IS 'ID em que esse estoque se mantém';
COMMENT ON COLUMN estoque.quantidade IS 'Quantidade de itens';
COMMENT ON COLUMN estoque.rua IS 'Rua em que o depósito se mantem, exemplo Rua A, Rua B';
COMMENT ON COLUMN estoque.prateleira IS 'prateleira em que o item se encontra, 1A, 1B, 2A, etc';
COMMENT ON COLUMN estoque.peso IS 'Quantidade que aguenta em peso em Quilograma';
COMMENT ON COLUMN estoque.data_entrada IS 'Data de entrada dos itens';
COMMENT ON COLUMN estoque.data_saida IS 'Data de saida dos itens';
COMMENT ON COLUMN estoque.valor_compra IS 'Custo de compra';
COMMENT ON COLUMN estoque.valor_venda IS 'Valor padrão de venda';


CREATE TABLE estoque_item_venda (
    estoqueID int4 NOT NULL, 
    itemID int4 NOT NULL 
);

COMMENT ON TABLE estoque_item_venda IS 'Controle de estoque dos item de venda';
COMMENT ON COLUMN estoque_item_venda.estoqueID IS 'Identificador do Id do estoque';
COMMENT ON COLUMN estoque_item_venda.itemID IS 'identificador do Id do venda';

CREATE TABLE fornecedor (
    fornecedorID SERIAL NOT NULL, 
    it_cod SERIAL NOT NULL,
    cedula varchar(12) NOT NULL, 
    nome varchar(40), 
    telefone varchar(20),  
    rua varchar(60) NOT NULL, 
    bairro varchar(60) NOT NULL, 
    cidade varchar(50) NOT NULL, 
    provincia varchar(50) NOT NULL, 
    canton varchar(50) NOT NULL, 
    distrito varchar(50) NOT NULL, 
    codigo_postal varchar(10) NOT NULL,
    complemento varchar(60) NOT NULL, 
    PRIMARY KEY (fornecedorID)
);

COMMENT ON TABLE fornecedor IS 'Tabela com a informação dos fornecedores';
COMMENT ON COLUMN fornecedor.fornecedorID IS 'Identificador do Id do fornecedor';
COMMENT ON COLUMN fornecedor.cedula IS 'Identificador único para cada pessoa fiscal';
COMMENT ON COLUMN fornecedor.nome IS 'Nome do fornecedor';
COMMENT ON COLUMN fornecedor.telefone IS 'Telefone do fornecedor';
COMMENT ON COLUMN fornecedor.rua IS 'Rua/avenida e afins, do fornecedor';
COMMENT ON COLUMN fornecedor.bairro IS 'Bairro do fornecedor';
COMMENT ON COLUMN fornecedor.cidade IS 'Cidade do fornecedor';
COMMENT ON COLUMN fornecedor.provincia IS 'Província da Costa Rica (por exemplo, San José, Alajuela)';
COMMENT ON COLUMN fornecedor.canton IS 'Cantão da Costa Rica (por exemplo, Escazú, Grecia)';
COMMENT ON COLUMN fornecedor.distrito IS 'Distrito da Costa Rica (por exemplo, San Rafael, San Isidro)';
COMMENT ON COLUMN cliente.complemento IS 'Complementos, como numero da casa, do fornecedor';
COMMENT ON COLUMN fornecedor.codigo_postal IS 'Código postal da Costa Rica (5 dígitos)';
 

CREATE TABLE item (
    it_cod SERIAL NOT NULL, 
    fornecedorID int4 NOT NULL, 
    nome varchar(40) NOT NULL, 
    descricao varchar(255) NOT NULL, 
    quantidade int4 NOT NULL, 
    valor numeric(19, 2) NOT NULL, 
    categoria varchar(100) NOT NULL, 
    PRIMARY KEY (it_cod)
);

COMMENT ON TABLE item IS 'Tabela com a informação do item';
COMMENT ON COLUMN item.it_cod IS 'Identificador único para cada item';
COMMENT ON COLUMN item.fornecedorID IS 'Identificador único para fornecedor do item';
--COMMENT ON COLUMN item.estoqueID IS 'Identificador único para cada estoque';
COMMENT ON COLUMN item.nome IS 'Nome do item (ex: Painel Solar, Inversor, Bateria)';
COMMENT ON COLUMN item.descricao IS 'Descrição detalhada do item (especificações técnicas, modelo, etc.)';
COMMENT ON COLUMN item.quantidade IS 'Quantidade de itens incluídos em um sistema (ex: 8 painéis solares)';
COMMENT ON COLUMN item.valor IS 'Preço unitário do item em dólares americanos';
COMMENT ON COLUMN item.categoria IS 'Categoria do item';

CREATE TABLE item_estoque (
    it_cod int4 NOT NULL, 
    estoqueID int4 NOT NULL
);

COMMENT ON TABLE item_estoque IS 'Controle de estoque dos item de venda';
COMMENT ON COLUMN item_estoque.it_cod IS 'Identificador do Id do item';
COMMENT ON COLUMN item_estoque.estoqueID IS 'Identificador do Id do estoque';

CREATE TABLE item_venda (
    itemID SERIAL NOT NULL, 
    ped_venda int4 NOT NULL, 
    quantidade int4 NOT NULL, 
    valor_prod numeric(19, 2) NOT NULL, 
    descricao varchar(255) NOT NULL, 
    marca varchar(100) NOT NULL, 
    garantia boolean NOT NULL, 
    composicao varchar(255) NOT NULL, 
    origem varchar(255) NOT NULL, 
    PRIMARY KEY (itemID)
);

COMMENT ON TABLE item_venda IS 'Tabela de venda do item';
COMMENT ON COLUMN item_venda.itemID IS 'Identificador do Id do item';
COMMENT ON COLUMN item_venda.ped_venda IS 'Numero do pedido de venda';
COMMENT ON COLUMN item_venda.quantidade IS 'Quantidade de item';
COMMENT ON COLUMN item_venda.valor_prod IS 'Valor do item';
COMMENT ON COLUMN item_venda.descricao IS 'Descricao do item';
COMMENT ON COLUMN item_venda.marca IS 'Marca do item';
COMMENT ON COLUMN item_venda.garantia IS 'Garantia do item';
COMMENT ON COLUMN item_venda.composicao IS 'Composicao do item';
COMMENT ON COLUMN item_venda.origem IS 'Origem do item';

CREATE TABLE pagamento (
    pagamentoID SERIAL NOT NULL, 
    clienteID int4 NOT NULL, 
    data_pagamento date NOT NULL, 
    valor_pago numeric(10, 2) NOT NULL, 
    forma_pagamento varchar(20), 
    status_pagamento boolean NOT NULL, 
    PRIMARY KEY (pagamentoID)
);

COMMENT ON TABLE pagamento IS 'Tabela de pagamentos';
COMMENT ON COLUMN pagamento.pagamentoID IS 'Identificador do pagamento';
COMMENT ON COLUMN pagamento.clienteID IS 'Identificador do cliente';
COMMENT ON COLUMN pagamento.data_pagamento IS 'Data do pagamento';
COMMENT ON COLUMN pagamento.valor_pago IS 'Total do valor do pagamento';
COMMENT ON COLUMN pagamento.forma_pagamento IS 'Forma de pagamento';
COMMENT ON COLUMN pagamento.status_pagamento IS 'Status do pagamento (Pago ou não)';

CREATE TABLE pagamento_fornecedor (
    pagamento_fornecedorID SERIAL NOT NULL, 
    data_fornecedor date NOT NULL, 
    valor int4 NOT NULL, 
    --TODO pq esse valor é int e n decimal?
    forma_pagamento varchar(20), 
    PRIMARY KEY (pagamento_fornecedorID)
);

COMMENT ON TABLE pagamento_fornecedor IS 'Tabela de pagamentos para o fornecedor';
COMMENT ON COLUMN pagamento_fornecedor.pagamento_fornecedorID IS 'Identificador do pagamento para o fornecedor';
COMMENT ON COLUMN pagamento_fornecedor.data_fornecedor IS 'Data do pagamento para o fornecedor';
COMMENT ON COLUMN pagamento_fornecedor.valor IS 'Valor do pagamento para o fornecedor';
COMMENT ON COLUMN pagamento_fornecedor.forma_pagamento IS 'Forma do pagamento para o fornecedor';

CREATE TABLE pedido_compra (
    ped_compra SERIAL NOT NULL,  
    dt_compra date NOT NULL,
    dt_entrega date NOT NULL, 
    valor numeric(19, 2) NOT NULL, 
    desconto numeric(19, 2) NOT NULL, 
    usuarioID int4 NOT NULL, 
    PRIMARY KEY (ped_compra)
);

COMMENT ON TABLE pedido_compra IS 'Tabela do pedido de compra';
COMMENT ON COLUMN pedido_compra.ped_compra IS 'Identificador do pedido de compra';
COMMENT ON COLUMN pedido_compra.dt_compra IS 'Data de compra do pedido';
COMMENT ON COLUMN pedido_compra.dt_entrega IS 'Data de entrega do pedido';
COMMENT ON COLUMN pedido_compra.valor IS 'Valor do pedido';
COMMENT ON COLUMN pedido_compra.desconto IS 'Desconto do pedido';
COMMENT ON COLUMN pedido_compra.usuarioID IS 'Identificador do usuario que realizou a compra';

CREATE TABLE pedido_compra_fornecedor (
    ped_compra int4 NOT NULL, 
    fornecedorID int4 NOT NULL

);

COMMENT ON TABLE pedido_compra_fornecedor IS 'Tabela do pedido de compra do fornecedor';
COMMENT ON COLUMN pedido_compra_fornecedor.ped_compra IS 'Numero do pedido de compra';
COMMENT ON COLUMN pedido_compra_fornecedor.fornecedorID IS 'Identificador do ID do fornecedor';

CREATE TABLE pedido_fornecedor (
    itemID SERIAL NOT NULL, 
    ped_compra int4 NOT NULL, 
    quantidade int4 NOT NULL, 
    valor numeric(19, 2) NOT NULL, 
    fornecedorID int4 NOT NULL, 
    pagamento_fornecedorID int4 NOT NULL,
    PRIMARY KEY (itemID)
);

COMMENT ON TABLE pedido_fornecedor IS 'Tabela do pedido com fornecedor com relacao no estoque';
COMMENT ON COLUMN pedido_fornecedor.itemID IS 'Identificador dos itens do pedido para o fornecedor';
COMMENT ON COLUMN pedido_fornecedor.ped_compra IS 'Pedido de compra para o fornecedor';
COMMENT ON COLUMN pedido_fornecedor.quantidade IS 'Quantidade de itens comprados';
COMMENT ON COLUMN pedido_fornecedor.valor IS 'Valor do pedido para o fornecedor';
COMMENT ON COLUMN pedido_fornecedor.fornecedorID IS 'Identificador unico do fornecedor';
COMMENT ON COLUMN pedido_fornecedor.pagamento_fornecedorID IS 'Identificador do pagamento para o fornecedor';


CREATE TABLE pedido_fornecedor_estoque (
    itemID int4 NOT NULL, 
    estoqueID int4 NOT NULL
);

COMMENT ON TABLE pedido_fornecedor_estoque IS 'Tabela de estoque do fornecedor com relacao no pedido de compra';
COMMENT ON COLUMN pedido_fornecedor_estoque.itemID IS 'Identificador dos itens do pedido para o fornecedor';
COMMENT ON COLUMN pedido_fornecedor_estoque.estoqueID IS 'Identificador do estoque do fornecedor';

CREATE TABLE pedido_venda (
    ped_venda SERIAL NOT NULL, 
    clienteID int4 NOT NULL, 
    dt_venda date NOT NULL, 
    dt_instalacao date NOT NULL, 
    valor numeric(19, 2) NOT NULL, 
    desconto numeric(19, 2) NOT NULL, 
    PRIMARY KEY (ped_venda)
);

COMMENT ON TABLE pedido_venda IS 'Pedido completo do cliente com varios itens';
COMMENT ON COLUMN pedido_venda.ped_venda IS 'Identificador do pedido de venda';
COMMENT ON COLUMN pedido_venda.clienteID IS 'Identificador do cliente no pedido de venda';
COMMENT ON COLUMN pedido_venda.dt_venda IS 'Data de venda no pedido de venda';
COMMENT ON COLUMN pedido_venda.dt_instalacao IS 'Data de instalacao no pedido de venda';
COMMENT ON COLUMN pedido_venda.valor IS 'Valor do pedido de venda';
COMMENT ON COLUMN pedido_venda.desconto IS 'Desconto do pedido de venda';

CREATE TABLE usuario (
    usuarioID SERIAL NOT NULL,
    usuarioID_FK int4 NOT NULL,  
    companyID int4 NOT NULL, 
    nome varchar(40) NOT NULL,
    tipo varchar(40) NOT NULL, 
    dt_entrada date NOT NULL, 
    cedula varchar(15) NOT NULL, 
    data_nascimento date NOT NULL, 
    departamento varchar(100) NOT NULL, 
    data_admissao date NOT NULL, 
    salario numeric(10, 2) NOT NULL, 
    ativo int4 NOT NULL, 
    telefone varchar(20) NOT NULL, 
    estado varchar(20) NOT NULL,
    email varchar(60) NOT NULL, 
    rua varchar(60) NOT NULL, 
    bairro varchar(60) NOT NULL, 
    cidade varchar(50) NOT NULL,  
    canton varchar(50) NOT NULL, 
    distrito varchar(50) NOT NULL, 
    codigo_postal varchar(10) NOT NULL,
    complemento varchar(60) NOT NULL,
    PRIMARY KEY (usuarioID),
    CONSTRAINT FKcliente800498 FOREIGN KEY (usuarioID_FK) REFERENCES usuario (usuarioID)
);

COMMENT ON TABLE usuario IS 'Tabela dos usuarios do sistema (funcionarios)';
COMMENT ON COLUMN usuario.usuarioID_FK IS ' Identificador único para cada funcionário';
COMMENT ON COLUMN usuario.nome IS 'Nome completo do funcionário';
COMMENT ON COLUMN usuario.tipo IS 'Cargo do funcionário';
COMMENT ON COLUMN usuario.dt_entrada IS 'Data de entrada do funcionario';
COMMENT ON COLUMN usuario.cedula IS 'Número de identificação da Costa Rica (cédula)';
COMMENT ON COLUMN usuario.data_nascimento IS 'Data de nascimento do funcionário';
COMMENT ON COLUMN usuario.departamento IS 'Departamento onde o funcionário trabalha';
COMMENT ON COLUMN usuario.data_admissao IS 'Data de admissão do funcionário na empresa';
COMMENT ON COLUMN usuario.salario IS 'Salário mensal do funcionário em dolares americanos';
COMMENT ON COLUMN usuario.ativo IS 'Estado atual do funcionário (ativo, inativo, licença, férias)';
COMMENT ON COLUMN usuario.telefone IS 'Número de telefone do funcionário';  
COMMENT ON COLUMN usuario.estado IS 'Estado do funcionário';  
COMMENT ON COLUMN usuario.email IS 'Endereço de e-mail do funcionário';
COMMENT ON COLUMN usuario.rua IS 'Rua/avenida e afins, do usuario';
COMMENT ON COLUMN usuario.bairro IS 'Bairro do cliente';
COMMENT ON COLUMN usuario.cidade IS 'Cidade do cliente';
--COMMENT ON COLUMN usuario.provincia IS 'Província da Costa Rica (por exemplo, San José, Alajuela)';
--TODO Coluna inexistente na tabela usuario
COMMENT ON COLUMN usuario.canton IS 'Cantão da Costa Rica (por exemplo, Escazú, Grecia)';
COMMENT ON COLUMN usuario.distrito IS 'Distrito da Costa Rica (por exemplo, San Rafael, San Isidro)';
COMMENT ON COLUMN usuario.codigo_postal IS 'Código postal da Costa Rica (5 dígitos)';
COMMENT ON COLUMN usuario.complemento IS 'Complementos, como numero da casa, do usuario';
--COMMENT ON COLUMN usuario.endereco IS 'Endereço residencial do funcionário';
--TODO coluna inexistente na tabela usuario - pq existe esse comentario em uma coluna inexistente?
--
-------------------------------------------------
------------------ Foreign Key ------------------
-------------------------------------------------

-------------------------
--- Pedido_fornecedor ---
-------------------------


ALTER TABLE pedido_fornecedor
ADD CONSTRAINT FKpedido_for884008 FOREIGN KEY (pagamento_fornecedorID) REFERENCES pagamento_fornecedor (pagamento_fornecedorID),
ADD CONSTRAINT FKpedido_for470034 FOREIGN KEY (fornecedorID) REFERENCES fornecedor (fornecedorID),
ADD CONSTRAINT FKpedido_for362420 FOREIGN KEY (ped_compra) REFERENCES pedido_compra (ped_compra);
--ADD CONSTRAINT FK_fornecedor_item FOREIGN KEY (it_cod) REFERENCES item (it_cod)
--TODO FK errada
---------------------------------
--- Pedido_fornecedor_estoque ---
---------------------------------

ALTER TABLE pedido_fornecedor_estoque
ADD CONSTRAINT FKpedido_for819724 FOREIGN KEY (estoqueID) REFERENCES estoque (estoqueID),
ADD CONSTRAINT FKpedido_for361225 FOREIGN KEY (itemID) REFERENCES pedido_fornecedor(itemID);

---------------------
--- Pedido_compra ---
---------------------

ALTER TABLE pedido_compra 
ADD CONSTRAINT FKpedido_com105857 FOREIGN KEY (usuarioID) REFERENCES usuario (usuarioID);

--------------------------------
--- Pedido_compra_fornecedor ---
--------------------------------

ALTER TABLE pedido_compra_fornecedor 
ADD CONSTRAINT FKpedido_com999332 FOREIGN KEY (fornecedorID) REFERENCES fornecedor (fornecedorID),
ADD CONSTRAINT FKpedido_com106947 FOREIGN KEY (ped_compra) REFERENCES pedido_compra (ped_compra);

------------------
--- Item_venda ---
------------------

ALTER TABLE item_venda 
ADD CONSTRAINT FKitem_venda729717 FOREIGN KEY (ped_venda) REFERENCES pedido_venda (ped_venda);

-------------------------
--- Cliente_logistica ---
-------------------------

ALTER TABLE cliente_logistica 
ADD CONSTRAINT FKclientelogistica_pedvenda FOREIGN KEY (ped_venda) REFERENCES pedido_venda (ped_venda);

--------------------
--- Pedido_venda ---
--------------------

ALTER TABLE pedido_venda 
ADD CONSTRAINT FKpedido_ven454913 FOREIGN KEY (clienteID) REFERENCES cliente (clienteID);

-----------------
--- Pagamento ---
-----------------

ALTER TABLE pagamento 
ADD CONSTRAINT FKpagamento911125 FOREIGN KEY (clienteID) REFERENCES cliente (clienteID);

---------------
--- Cliente ---
---------------

ALTER TABLE cliente
ADD CONSTRAINT FKcliente_usuario FOREIGN KEY (usuarioID) REFERENCES usuario (usuarioID);

------------
--- Item ---
------------

ALTER TABLE item 
ADD CONSTRAINT FKitem222604 FOREIGN KEY (fornecedorID) REFERENCES fornecedor (fornecedorID);

--------------------------
--- Estoque_item_venda ---
--------------------------

ALTER TABLE estoque_item_venda
ADD CONSTRAINT FKestoque_it766135 FOREIGN KEY (itemID) REFERENCES item_venda (itemID),
ADD CONSTRAINT FKestoque_it948129 FOREIGN KEY (estoqueID) REFERENCES estoque (estoqueID);

--------------------
--- Item_estoque ---
--------------------

ALTER TABLE item_estoque ADD CONSTRAINT FKitem_estoq517021 FOREIGN KEY (it_cod) REFERENCES item (it_cod);
ALTER TABLE item_estoque ADD CONSTRAINT FKitem_estoq383001 FOREIGN KEY (estoqueID) REFERENCES estoque (estoqueID)



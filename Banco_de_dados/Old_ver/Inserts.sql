-- Inserções na tabela usuario
INSERT INTO usuario (usuarioID, usuarioID_FK, companyID, nome, dt_entrada, tipo, ativo, cedula, data_nascimento, departamento, data_admissao, salario, estado, telefone, email, rua,
					bairro, cidade, canton, distrito, codigo_postal, complemento) 
VALUES
    (1, 1, 1, 'João Silva',    '2022-01-15', 'Gerente de Vendas',      1, '12345678901', '1985-03-12', 'Vendas',     '2022-01-15', 8500.00, 'SC', '49999991234', 'joao.silva@email.com',    'Rua das Flores',          'Centro',            'São Paulo',       'Capital',  'Centro',      '01234-567',   'Apto 101'),
    (2, 1, 1, 'Maria Souza',   '2021-05-20', 'Técnico Instalador',     1, '98765432109', '1990-08-25', 'Instalação', '2021-05-20', 5200.00, 'SC', '49999995678', 'maria.souza@email.com',   'Avenida das Palmeiras',   'Copacabana',        'Rio de Janeiro',  'Zona Sul', 'Ipanema',     '22000-000',   'Bloco B'),
    (3, 3, 1, 'Carlos Santos', '2023-02-10', 'Gerente de Compras',     1, '56789012345', '1982-11-05', 'Compras',    '2023-02-10', 9800.00, 'SC', '49999992345', 'carlos.santos@email.com', 'Rua dos Pinheiros',       'Pinheiros',         'São Paulo',       'Capital',  'Oeste',       '04567-890',   'Casa 2'),
    (4, 3, 1, 'Ana Oliveira',  '2020-09-30', 'Analista Financeiro',    1, '23456789012', '1992-04-18', 'Financeiro', '2020-09-30', 6500.00, 'SC', '49999996789', 'ana.oliveira@email.com',  'Rua das Laranjeiras',     'Laranjeiras',       'Paraná',          'Centro',   'Centro',      '80000-123',   'Apto 3A'),
    (5, 1, 1, 'Pedro Almeida', '2023-06-05', 'Engenheiro Eletricista', 1, '89012345678', '1988-07-03', 'Engenharia', '2023-06-05', 7200.00, 'SC', '49999993456', 'pedro.almeida@email.com',  'Avenida das Orquídeas',   'Botafogo',         'Rio de Janeiro',  'Zona Sul', 'Laranjeiras', '22000-456',   'Apartamento 10'); 

   -- Inserções na tabela estoque
INSERT INTO estoque (estoqueID, quantidade, rua, prateleira, peso, data_entrada, data_saida, valor_compra, valor_venda)
VALUES
--  ID, qnt, rua, pratele peso-data_entrada -data_saida-  valor_compra valor_venda
    (1,  10, 324, 'rua B', 2, '2024-01-01', '2024-06-01', 15000.00, 18000.00),
    (2,  10, 32,  'rua A', 2, '2024-01-05', '2024-06-05', 13000.00, 16000.00),
    (3,  10, 344, 'rua C', 2, '2024-01-10', '2024-06-10', 14000.00, 17000.00),
    (4,  10, 674, 'rua D', 2, '2024-01-15', '2024-06-15', 12000.00, 15000.00),
    (5,  10, 320, 'rua L', 2, '2024-01-20', '2024-06-20', 13500.00, 16500.00),
    (6,  10, 399, 'rua P', 2, '2024-01-25', '2024-06-25', 12500.00, 15500.00),
    (7,  10, 114, 'rua Q', 2, '2024-01-30', '2024-06-30', 14500.00, 17500.00),
    (8,  10, 564, 'rua R', 2, '2024-02-01', '2024-07-01', 15000.00, 18000.00),
    (9,  10, 114, 'rua T', 2, '2024-02-05', '2024-07-05', 15500.00, 18500.00),
    (10, 10, 134, 'rua C', 2, '2024-02-10', '2024-07-10', 16000.00, 19000.00),
    (11, 15, 123, 'rua X', 3, '2024-02-15', '2024-07-15', 17000.00, 20000.00),
    (12, 20, 456, 'rua Y', 4, '2024-02-20', '2024-07-20', 18000.00, 21000.00),
    (13, 12, 789, 'rua Z', 2, '2024-02-25', '2024-07-25', 16000.00, 19000.00),
    (14, 8,  567, 'rua W', 2, '2024-03-01', '2024-08-01', 14000.00, 17000.00),
    (15, 6,  890, 'rua V', 1, '2024-03-05', '2024-08-05', 12000.00, 15000.00),
    (16, 10, 123, 'rua A', 2, '2024-03-10', '2024-08-10', 16000.00, 19000.00),   
    (17, 10, 123, 'rua C', 2, '2024-03-15', '2024-08-15', 16000.00, 19000.00),
    (18, 12, 124, 'rua U', 2, '2024-03-20', '2024-08-20', 16500.00, 19500.00),
    (19, 8,  125, 'rua T', 2, '2024-03-25', '2024-08-25', 15500.00, 18500.00),
    (20, 15, 126, 'rua M', 2, '2024-03-30', '2024-08-30', 17000.00, 20000.00);

   -- Inserções na tabela pedido_fornecedor
INSERT INTO pedido_fornecedor (ped_compra, quantidade, valor, fornecedorID, pagamento_fornecedorID) VALUES
    (1,  500, 12500.00, 2, 1),
    (2,  300, 9250.25,  1, 2),
    (3,  800, 16000.00, 3, 3),
    (4,  450, 10750.00, 2, 4),
    (5,  280, 8900.38,  1, 5),
    (6,  650, 14250.00, 3, 6),
    (7,  900, 18000.00, 2, 7),
    (8,  520, 11600.00, 1, 8),
    (9,  380, 9900.13,  3, 9),
    (10, 700, 15500.00, 2, 10);

-- Inserções na tabela pedido_fornecedor_estoque
INSERT INTO pedido_fornecedor_estoque (itemID, estoqueID) VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 1),
    (7, 2),
    (8, 3),
    (9, 4),
    (10, 5);
   
-- Inserções na tabela cliente
INSERT INTO cliente (usuarioID, cedula, nome, data_nascimento, genero_cliente, email, telefone, registration_date,
                     ativo, descricao, divida, rua, bairro, cidade, provincia, canton, distrito, codigo_postal, complemento)
VALUES
-- user  cedula		---nome---      data_nascimento genero-------email-------           ----telefone----    registration  ativo  --descricao--       divida    -----rua------            -bairro-             ---cidade---      -provincia-          --canton--  -distrito-     codigo_postal -complemento-
    (5,	39468275109, 'Ana Maria',        '1980-03-15', 'F', 'ana.maria@email.com',        '(11) 98765-4321', '2024-05-28', true,  'Cliente VIP',     500.00,  'Rua das Flores',          'Centro',            'São Paulo',      'São Paulo',         'Capital',  'Centro',           '01234-567',   'Apto 101'),
    (3,	82753914608, 'Pedro Oliveira',   '1985-08-20', 'M', 'pedro.oliveira@email.com',   '(21) 99999-8888', '2024-05-29', true,  'Cliente Premium', 1000.00, 'Avenida das Palmeiras',   'Copacabana',        'Rio de Janeiro', 'Rio de Janeiro',    'Zona Sul', 'Ipanema',          '22000-000',   'Bloco B'),
    (2, 21087469536, 'Carla Santos',     '1982-05-10', 'F', 'carla.santos@email.com',     '(31) 55555-1234', '2024-05-30', true,  'Cliente Regular', 200.00,  'Rua dos Pinheiros',       'Pinheiros',         'São Paulo',      'São Paulo',         'Capital',  'Oeste',            '04567-890',   'Casa 2'),
    (4, 65928341701, 'Lucas Souza',      '1998-11-05', 'M', 'lucas.souza@email.com',      '(41) 77777-2468', '2024-05-31', true,  'Cliente Novo',    0.00,    'Rua das Laranjeiras',     'Laranjeiras',       'Curitiba',       'Paraná',            'Centro',   'Centro',           '80000-123',   'Apto 3A'),
    (2,	47389156206, 'Maria Ferreira',   '1993-02-18', 'F', 'maria.ferreira@email.com',   '(51) 33333-7890', '2024-06-01', false, 'Cliente Inativo', 0.00,    'Avenida das Gaivotas',    'Praia de Belas',    'Porto Alegre',   'Rio Grande do Sul', 'Sul',      'Belas',            '90000-456',   'Bloco C'),
    (1,	15820493767, 'Rafael Silva',     '1990-07-25', 'M', 'rafael.silva@email.com',     '(12) 98765-4321', '2024-06-02', true,  'Cliente Regular', 300.00,  'Rua dos Cravos',          'Jardim',            'Campinas',       'São Paulo',         'Interior', 'Centro',           '13000-123',   'Casa 5'),
    (3,	72651038924, 'Juliana Santos',   '1988-04-15', 'F', 'juliana.santos@email.com',   '(21) 98765-4321', '2024-06-03', true,  'Cliente VIP',     800.00,  'Avenida das Orquídeas',   'Botafogo',          'Rio de Janeiro', 'Rio de Janeiro',    'Zona Sul', 'Laranjeiras',      '22000-456',   'Apartamento 10'),
    (4,	94368215705, 'Fernando Lima',    '1995-03-20', 'M', 'fernando.lima@email.com',    '(31) 55555-6789', '2024-06-04', true,  'Cliente Premium', 1200.00, 'Rua das Violetas',        'Floresta',          'Belo Horizonte', 'Minas Gerais',      'Centro',   'Centro',           '30123-456',   'Apto 7B'),
    (2,	31095728476, 'Camila Oliveira',  '1987-01-10', 'F', 'camila.oliveira@email.com',  '(41) 77777-1357', '2024-06-05', true,  'Cliente Novo',    0.00,    'Avenida dos Girassóis',   'Jardim das Flores', 'Curitiba',       'Paraná',            'Norte',    'Flores',           '80000-789',   'Bloco D'),
    (5,	57283649018, 'Gustavo Santos',   '1992-02-28', 'M', 'gustavo.santos@email.com',   '(51) 33333-9876', '2024-06-06', false, 'Cliente Inativo', 0.00,    'Rua das Margaridas',      'Centro',            'Porto Alegre',   'Rio Grande do Sul', 'Sul',      'Centro',           '90000-789',   'Apto 2C'),
    (1, 84629107353, 'Mariana Silva',    '1991-07-15', 'F', 'mariana.silva@email.com',    '(12) 98765-4321', '2024-06-07', true,  'Cliente Regular', 400.00,  'Rua das Azaleias',        'Jardim',            'Campinas',       'São Paulo',         'Interior', 'Centro',           '13000-789',   'Casa 8'),
    (3,	13579046825, 'Rodrigo Santos',   '1989-05-25', 'M', 'rodrigo.santos@email.com',   '(21) 98765-4321', '2024-06-08', true,  'Cliente VIP',     700.00,  'Avenida das Magnólias',   'Botafogo',          'Rio de Janeiro', 'Rio de Janeiro',    'Zona Sul', 'Laranjeiras',      '22000-789',   'Apartamento 15'),
    (4,	68943215707, 'Isabela Lima',     '1993-03-12', 'F', 'isabela.lima@email.com',     '(31) 55555-6789', '2024-06-09', true,  'Cliente Premium', 1500.00, 'Rua das Camélias',        'Floresta',          'Belo Horizonte', 'Minas Gerais',      'Centro',   'Centro',           '30123-789',   'Apto 10A'),
    (2,	25487193608, 'Rafaela Oliveira', '1988-01-20', 'F', 'rafaela.oliveira@email.com', '(41) 77777-1357', '2024-06-10', true,  'Cliente Novo',    0.00,    'Avenida dos Crisântemos', 'Jardim das Flores', 'Curitiba',       'Paraná',            'Norte',    'Flores',           '80000-789',   'Bloco E'),
    (5,	93756281024, 'Thiago Santos',    '1991-02-28', 'M', 'thiago.santos@email.com',    '(51) 33333-9876', '2024-06-11', false, 'Cliente Inativo', 0.00,    'Rua das Tulipas',         'Centro',            'Porto Alegre',   'Rio Grande do Sul', 'Sul',      'Centro',           '90000-987',   'Apto 3D'),
	(5, 93756281024, 'Maria Silva',      '1985-09-15', 'F', 'maria.silva@email.com',      '(51) 98765-4321', '2024-06-11', true,  'Cliente Ativo',   1500.00, 'Avenida das Rosas',       'Jardim Botânico',   'Porto Alegre',   'Rio Grande do Sul', 'Sul',      'Jardim Botânico',  '90000-123',           'Casa 2B');
	
   -- Inserções na tabela pedido_venda
INSERT INTO pedido_venda (clienteID, dt_venda, dt_instalacao, valor, desconto) VALUES
    (12, '2024-06-25', '2024-07-05', 38000.00, 1000.00),
    (8,  '2024-06-18', '2024-06-28', 22500.50, 500.50),
    (5,  '2024-06-02', '2024-06-15', 45000.00, 1500.00),
    (15, '2024-05-15', '2024-05-28', 31200.00, 800.00),
    (1,  '2024-04-28', '2024-05-10', 26800.75, 600.75),
    (9,  '2024-04-10', '2024-04-25', 42500.00, 1200.00),
    (3,  '2024-03-20', '2024-04-05', 51000.00, 1800.00),
    (11, '2024-03-05', '2024-03-20', 35200.00, 1000.00),
    (6,  '2024-02-15', '2024-03-01', 29800.25, 750.25),
    (2,  '2024-01-28', '2024-02-12', 48000.00, 1500.00),
   	(13, '2024-07-10', '2024-07-20', 41000.00, 1100.00),
	(7,  '2024-07-02', '2024-07-12', 23800.75, 525.75),
	(4,  '2024-06-15', '2024-06-28', 46800.50, 1575.50),
	(16, '2024-05-30', '2024-06-10', 32500.00, 840.00),
	(2,  '2024-05-12', '2024-05-25', 27600.25, 620.25),
	(10, '2024-04-22', '2024-05-05', 44200.00, 1260.00);

-- Inserções na tabela cliente_logistica
INSERT INTO cliente_logistica (logisticaID, ped_venda, cedula, data_entrega, nome, data_nascimento, genero, email, telefone, data_cadastro, rua, bairro,
                               cidade, provincia, canton, distrito, codigo_postal, complemento)
VALUES 
--  ID  pv      cedula    DATA_entrega  -----nome-----    data_nascimento genero -----email-----      ----telefone----  data_cadastro  ------rua------          -bairro-             ---Cidade---      -provincia-          --canton--    -distrito-            -codigo_postal- -complemento-
    (1,  1,  12345678901,  '2024-01-06', 'Maria Silva',             '1990-03-15', 'F', 'maria@gmail.com',     '(11) 98765-4321', '2024-05-28', 'Rua das Flores',        'Centro',            'São Paulo',          'São Paulo',         'Capital',     'Centro',             '01234-567',   'Apto 101'),
    (2,  2,  23456789012, '2024-02-06', 'Pedro Santos',             '1985-08-20', 'M', 'pedro@gmail.com',     '(21) 99999-8888', '2024-05-29', 'Avenida das Palmeiras', 'Copacabana',        'Rio de Janeiro',     'Rio de Janeiro',    'Zona Sul',    'Ipanema',            '22000-000',   'Bloco B'),
    (3,  3,  34567890123, '2024-03-06', 'Carlos Oliveira',          '1982-05-10', 'M', 'carlos@gmail.com',    '(31) 55555-1234', '2024-05-30', 'Rua dos Pinheiros',     'Pinheiros',         'São Paulo',          'São Paulo',         'Capital',     'Oeste',              '04567-890',   'Casa 2'),
    (4,  4,  45678901234, '2024-04-06', 'Ana Souza Santos',         '1998-11-05', 'F', 'ana@gmail.com',       '(41) 77777-2468', '2024-05-31', 'Rua das Laranjeiras',   'Laranjeiras',       'Curitiba',           'Paraná',            'Centro',      'Centro',             '80000-123',   'Apto 3A'),
    (5,  5,  56789012345, '2024-05-06', 'Lucas Ferreira',           '1993-02-18', 'M', 'lucas@gmail.com',     '(51) 33333-7890', '2024-06-01', 'Avenida das Gaivotas',  'Praia de Belas',    'Porto Alegre',       'Rio Grande do Sul', 'Sul',         'Belas',              '90000-456',   'Bloco C'),
    (6,  6,  67890123456, '2024-02-06', 'João Oliveira',            '1987-07-25', 'M', 'joao@gmail.com',      '(62) 55555-6789', '2024-06-02', 'Rua das Acácias',       'Jardim das Flores', 'Goiânia',            'Goiás',             'Setor Oeste', 'Centro',             '74000-123',   'Apartamento 5B'),
    (7,  7,  78901234567, '2024-03-06', 'Fernanda Almeida',         '1995-03-10', 'F', 'fernanda@gmail.com',  '(85) 98765-4321', '2024-06-03', 'Rua das Magnólias',     'Aldeota',           'Fortaleza',          'Ceará',             'Centro',      'Praia de Iracema',   '60000-789',   'Casa 3'),
    (8,  8,  89012345678, '2024-04-06', 'Laura Mendes',             '1990-09-05', 'F', 'laura@gmail.com',     '(47) 33333-5555', '2024-06-04', 'Rua das Violetas',      'Jardim Botânico',   'Florianópolis',      'Santa Catarina',    'Centro',      'Lagoa da Conceição', '88000-456',   'Casa 1'),
    (9,  9,  90123456789, '2024-05-06', 'André Santos',             '1982-11-15', 'M', 'andre@gmail.com',     '(81) 98765-4321', '2024-06-05', 'Rua dos Ipês',          'Boa Viagem',        'Recife',             'Pernambuco',        'Centro',      'Pina',               '51000-789',   'Apartamento 4C'),
    (10, 10, 01234567890, '2024-06-06', 'Rafaela Costa',            '1989-04-20', 'F', 'rafaela@gmail.com',   '(62) 55555-1234', '2024-06-06', 'Rua das Orquídeas',     'Jardim das Flores', 'Goiânia',            'Goiás',             'Setor Leste', 'Centro',             '74000-789',   'Apartamento 7A'),
    (11, 11, 09876543210, '2024-07-06', 'Bruno Oliveira',           '1980-06-30', 'M', 'bruno@gmail.com',     '(85) 98765-9876', '2024-06-07', 'Avenida dos Coqueiros', 'Meireles',          'Fortaleza',          'Ceará',             'Centro',      'Praia de Iracema',   '60000-123',   'Casa 5'),
    (12, 12, 98765432109, '2024-08-06', 'Mariana Santos',           '1995-01-12', 'F', 'mariana@gmail.com',   '(47) 33333-4444', '2024-06-08', 'Rua das Azaleias',      'Jardim Botânico',   'Florianópolis',      'Santa Catarina',    'Centro',      'Lagoa da Conceição', '88000-789',   'Casa 2B'),
    (13, 13, 87654321098, '2024-09-06', 'Patrícia Lima',            '1991-03-25', 'F', 'patricia@gmail.com',  '(11) 98765-4321', '2024-06-09', 'Rua das Margaridas',    'Vila Flores',       'São Paulo',          'São Paulo',         'Capital',     'Leste',              '02345-678',   'Apto 4D'),
    (14, 14, 76543210987, '2024-10-06', 'Gustavo Rodrigues',        '1988-07-15', 'M', 'gustavo@gmail.com',   '(21) 99999-1234', '2024-06-10', 'Avenida dos Ipês',      'Ipanema',           'Rio de Janeiro',     'Rio de Janeiro',    'Zona Sul',    'Ipanema',            '22000-789',   'Cobertura 12'),  
    (15, 15, 65432109876, '2024-11-06', 'Camila Ferreira',          '1994-02-20', 'F', 'camila@gmail.com',    '(31) 55555-9876', '2024-06-11', 'Rua das Violetas',      'Savassi',           'Belo Horizonte',     'Minas Gerais',      'Centro',      'Centro',             '30123-456',   'Apartamento 3C'),
	(16, 16, 65532109876, '2024-11-07', 'Camila Ferreira Padilha',  '1994-12-08', 'F', 'camilla@gmail.com',   '(31) 55555-3726', '2024-07-12', 'Rua das Violetas',      'Savassi',           'Belo',               'Minas',             'Centrinho',    'Centrinho',         '30123-4956',  'Apartamento 9C');

   -- Inserções na tabela pagamento_fornecedor
INSERT INTO pagamento_fornecedor (data_fornecedor, valor, forma_pagamento) VALUES
    ('2024-06-15', 8500.00, 'Transferência'),
    ('2024-06-02', 12350.50,'Transferência'),
    ('2024-05-28', 5200.00, 'Transferência'),
    ('2024-05-10', 9875.25, 'Transferência'),
    ('2024-04-22', 3100.75, 'Transferência'),
    ('2024-04-05', 6950.00, 'Transferência'),
    ('2024-03-18', 11200.50, 'Transferência'),
    ('2024-03-01', 7600.00, 'Transferência'),
    ('2024-02-12', 4850.25, 'Transferência'),
    ('2024-01-25', 10500.00,'Transferência');
  
   -- Inserções na tabela fornecedor
INSERT INTO fornecedor (fornecedorID, cedula, nome, telefone, it_cod, rua, bairro, cidade, provincia, canton, distrito, codigo_postal, complemento)
VALUES
--  ID   cedula  -------nome-------       --telefone-- item ------rua------         -bairro-            --cidade--         provincia           - canton-    distrito   codigo_postal  -complemento- 
    (1, 74963582517, 'SolarTech Solutions',    '+123456789', 1, 'Rua das Flores',        'Centro',          'São Paulo',      'São Paulo',         'Capital',   'Centro',  '01234-567',   'Apto 101'),
    (2, 62826435187, 'SunPower Suppliers',     '+987654321', 2, 'Avenida das Palmeiras', 'Copacabana',      'Rio de Janeiro', 'Rio de Janeiro',    'Zona Sul',  'Ipanema', '22000-000',   'Bloco B'),
    (3, 85774396248, 'Green Energy Providers', '+111222333', 3, 'Avenida das Gaivotas',  'Praia de Belas',  'Porto Alegre',   'Rio Grande do Sul', 'Sul',       'Belas',   '90000-456',   'Bloco C'),
    (4, 73684825193, 'EcoPower Solutions',     '+555666777', 4, 'Rua das Árvores',       'Jardins',         'Curitiba',       'Paraná',            'Capital',   'Centro',  '04567-890',   'Apto 201'),
    (5, 26534725371, 'Sunshine Energy Co.',    '+999000111', 5, 'Avenida das Flores',    'Barra da Tijuca', 'Salvador',       'Bahia',             'Sul',       'Barra',   '40000-123',   'Bloco D');

-- Inserções na tabela pedido_fornecedor
INSERT INTO pedido_compra (dt_compra, dt_entrega, valor, desconto, usuarioID) VALUES
    ('2024-06-28', '2024-07-10', 25000.00, 500.00,  3),
    ('2024-06-12', '2024-06-25', 18500.50, 250.50,  1),
    ('2024-05-20', '2024-06-05', 32000.00, 1000.00, 2),
    ('2024-05-05', '2024-05-20', 21500.00, 0.00,    4),
    ('2024-04-15', '2024-05-01', 17800.75, 300.75,  5),
    ('2024-03-28', '2024-04-12', 28500.00, 500.00,  1), 
    ('2024-03-10', '2024-03-25', 36000.00, 800.00,  3),
    ('2024-02-22', '2024-03-10', 23200.00, 200.00,  2),
    ('2024-02-05', '2024-02-20', 19800.25, 150.25,  4),
    ('2024-01-18', '2024-02-03', 31000.00, 1000.00, 5);

   -- Inserções na tabela pedido_compra_fornecedor
INSERT INTO pedido_compra_fornecedor (ped_compra, fornecedorID) VALUES
    (1,  2),
    (2,  1),
    (3,  3),
    (4,  2),
    (5,  1),
    (6,  3),
    (7,  2),
    (8,  1),
    (9,  3),
    (10, 2);




-- Inserções na tabela empresa
INSERT INTO empresa (companyID, nome, logo, website_url, email, telefone, data_fundacao, cedula_juridica, setor, numero_licenca,
                     rua, bairro, cidade, provincia, canton, distrito, codigo_postal, complemento)
VALUES 
--  ID  ------nome------    logo   ---------website_url---------     -----------email----------   --telefone--  ----------data_fundacao-------- cedula_juridica  ----setor----    numero_licenca ------rua------  -----bairro-----  ----cidade----   provincia    canton--  distrito   codigo_postal  ----complemento----
    (1, 'Sunbridge Energy', NULL, 'https://www.sunbrigeenergy.com', 'contact@sunbrigeenergy.com', '+123456789', (to_date('01062005', 'ddMMyyyy')), '12345678', 'Paineis Solares', 'TI13854689',  'Rua Gonçalves', 'Alameda da Luz', 'José da Cruz', 'Carlinhos', 'Ipanema', 'central', '416388-332', 'Em frente a BR-666'  );

-- Inserções na tabela item_venda
INSERT INTO item_venda (itemID, ped_venda, quantidade, valor_prod, descricao, marca, garantia, composicao, origem)
VALUES
    (1,  1,  10, 100.000, 'Painel solar monocristalino de alta eficiência',                        'SolarPanelX1000', TRUE, 'Paineis de aco carbono', 'Estados Unidos da America'),
    (2,  2,  10, 90.000,  'Painel solar de última geração com tecnologia de células de silício',   'stone',           TRUE, 'Paineis de aco carbono', 'Portugal'),
    (3,  3,  10, 100.000, 'Painel solar econômico com bom desempenho em baixa luminosidade',       'stone',           TRUE, 'Paineis de aco carbono', 'Brasil'),
    (4,  4,  10, 100.000, 'Painel solar premium com tecnologia avançada de captação de luz',       'stone',           TRUE, 'Paineis de aco carbono', 'Mexico'),
    (5,  5,  10, 100.000, 'Painel solar ultraleve e eficiente para instalações em telhados',       'stone',           TRUE, 'Paineis de aco carbono', 'Canada'),
    (6,  6,  10, 100.000, 'Painel solar ecológico com alta taxa de conversão de energia',          'stone',           TRUE, 'Paineis de aco carbono', 'Russia'),
    (7,  7,  10, 100.000, 'Painel solar de design elegante e resistente às intempéries',           'stone',           TRUE, 'Paineis de aco carbono', 'China'),
    (8,  8,  10, 95.000,  'Painel solar flexível para aplicações em superfícies curvas',           'FlexSolar',       TRUE, 'Paineis de aco carbono', 'Espanha'),
    (9,  9,  10, 110.000, 'Painel solar bifacial com captação de luz em ambos os lados',           'BiSolar',         TRUE, 'Paineis de aco carbono', 'Japão'),
    (10, 10, 10, 105.000, 'Painel solar compacto e fácil de instalar',                             'CompactSun',      TRUE, 'Paineis de aco carbono', 'Austrália'),
    (11, 11, 10, 120.000, 'Painel solar de alto rendimento para uso industrial',                   'IndustrialSun',   TRUE, 'Paineis de aco carbono', 'Alemanha'),
    (12, 12, 10, 85.000,  'Painel solar compacto e portátil para camping e viagens',               'TravelSolar',     TRUE, 'Paineis de aco carbono', 'Suécia'),
    (13, 13, 10, 115.000, 'Painel solar ultrafino para integração em fachadas de edifícios',       'SlimSolar',       TRUE, 'Paineis de aco carbono', 'França'),
    (14, 14, 10, 95.000,  'Painel solar resistente a condições extremas de temperatura e umidade', 'ExtremeSun',      TRUE, 'Paineis de aco carbono', 'Noruega'),
    (15, 14, 10, 105.000, 'Painel solar de alta eficiência para uso residencial',                  'HomeSun',         TRUE, 'Paineis de aco carbono', 'Holanda'),
    (16, 14, 10, 100.000, 'Painel solar flexível e resistente a impactos',                         'FlexImpact',      TRUE, 'Paineis de aco carbono', 'Coreia do Sul');

INSERT INTO estoque_item_venda (estoqueID, itemID)
VALUES
    (1,  10),
    (2,  9),
    (3,  8),
    (4,  7),
    (5,  6),
    (6,  5),
    (7,  4),
    (8,  3),
    (9,  2),
    (10, 1);

-- Inserções na tabela item
INSERT INTO item (fornecedorID, nome, descricao, quantidade, valor, categoria)
VALUES 
    (1, 'SolarPanelX1000',  'Painel solar monocristalino de alta eficiência',                      100, 15000.00, 'Painel Solar'),
    (2, 'SunPowerUltra',    'Painel solar de última geração com tecnologia de células de silício', 120, 18000.00, 'Painel Solar'),
    (1, 'EcoSunMax',        'Painel solar econômico com bom desempenho em baixa luminosidade',     150, 16000.00, 'Painel Solar'),
    (3, 'SuperSolarTech',   'Painel solar premium com tecnologia avançada de captação de luz',     110, 20000.00, 'Painel Solar'),
    (2, 'PhotonMasterPlus', 'Painel solar ultraleve e eficiente para instalações em telhados',     130, 17500.00, 'Painel Solar'),
    (1, 'GreenEnergyPro',   'Painel solar ecológico com alta taxa de conversão de energia',        140, 16500.00, 'Painel Solar'),
    (3, 'SunnyDaysDeluxe',  'Painel solar de design elegante e resistente às intempéries',         115, 19000.00, 'Painel Solar'),
    (2, 'SolarFlexiPanel',  'Painel solar flexível para aplicações em superfícies curvas',         125, 17000.00, 'Painel Solar'),
    (1, 'EcoSunPowerMax',   'Painel solar de alto desempenho com tecnologia de auto-limpeza',      145, 18500.00, 'Painel Solar'),
    (3, 'UltraSunBlaze',    'Painel solar ultracompacto com garantia de eficiência energética',    135, 19500.00, 'Painel Solar'),
    (4, 'SolarTechPro',     'Painel solar de alta eficiência com tecnologia avançada',             105, 17000.00, 'Painel Solar'),
    (1, 'EcoSunLite',       'Painel solar leve e econômico para aplicações residenciais',          120, 15500.00, 'Painel Solar'),
    (2, 'SunFlexMax',       'Painel solar flexível com ótima adaptação a superfícies curvas',      110, 16800.00, 'Painel Solar'),
    (3, 'GreenPowerUltra',  'Painel solar ecológico de alta potência',                             130, 19200.00, 'Painel Solar'),
    (4, 'SunMasterElite',   'Painel solar premium com garantia estendida',                         115, 20500.00, 'Painel Solar'),
    (4, 'SunMasterElite',   'Painel solar premium com garantia estendida',                         115, 20500.00, 'Painel Solar');


-- Inserções na tabela item_estoque
INSERT INTO item_estoque (it_cod, estoqueID)
VALUES
    (1,  10),
    (2,  9),
    (3,  8),
    (4,  7),
    (5,  6),
    (6,  5),
    (7,  4),
    (8,  3),
    (9,  2),
    (10, 1),
    (11, 10),
    (12, 9),
    (13, 8),
    (14, 7),
    (15, 6),
    (16, 5);


-- Inserções na tabela pagamento
INSERT INTO pagamento (pagamentoID, clienteID, data_pagamento, valor_pago, forma_pagamento, status_pagamento)
VALUES
    (1,  1,  '2024-01-01',  100.000, 'Cartao credito', FALSE),
    (2,  2,  '2024-01-01',  100.000, 'Boleto',         FALSE),
    (3,  3,  '2024-01-01',  100.000, 'Cartao debido',  TRUE),
    (4,  4,  '2024-01-01',  100.000, 'Boleto',         TRUE),
    (5,  5,  '2024-01-01',  100.000, 'Boleto',         FALSE),
    (6,  6,  '2024-01-01',  100.000, 'Cartao debido',  TRUE),
    (7,  7,  '2024-01-01',  100.000, 'Cartao credito', FALSE),
    (8,  8,  '2024-01-02', 150.000,  'Cartao credito', FALSE),
    (9,  9,  '2024-01-02', 200.000,  'Boleto',         FALSE),
    (10, 10, '2024-01-02', 120.000,  'Cartao debido',  TRUE),
    (11, 11, '2024-01-02', 180.000,  'Boleto',         TRUE),
    (12, 12, '2024-01-02', 90.000,   'Boleto',         FALSE),
    (13, 13, '2024-01-02', 210.000,  'Cartao debido',  TRUE),
    (14, 14, '2024-01-02', 170.000,  'Cartao credito', FALSE),
    (15, 15, '2024-01-03', 130.000,  'Cartao credito', FALSE),
    (16, 16, '2024-01-03', 190.000,  'Boleto',         FALSE);

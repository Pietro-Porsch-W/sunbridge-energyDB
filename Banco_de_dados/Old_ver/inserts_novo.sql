-- Insert for empresa
INSERT INTO empresa (companyID, nome, websiteURL, email, telefone, cidade, provincia, data_fundacao, cedula_juridica, setor, numero_licenca, rua, bairro, canton, distrito, codigo_postal, complemento)
VALUES 
(1, 'SunBridge', 'https://sunbridge.cr', 'contact@sunbridge.cr', '+506 2100 1234', 'San José', 'San José', '2005-08-15', '123456789012', 'Energia Solar', 'LIC123456', 'Rua Central', 'Centro', 'San José', 'Catedral', 10101, 'Sala 1');

-- Inserts for usuario
INSERT INTO usuario (usuarioID, usuarioID_FK, companyID, nome, genero, data_entrada, tipo, cedula, data_nascimento, departamento, data_admissao, salario, ativo, telefone, email, senha, rua, bairro, cidade, canton, distrito, codigo_postal, complemento) 
VALUES 
  (1, NULL, 1, 'Leonardo Mateus Bortoluzzi Thums', 'M', '2023-01-01', 1, '12345678901', '1990-01-01', 'TI', '2023-01-01', 4500.00, TRUE, '555-1111', 'leonardo@empresa.com', '123', 'Rua Principal', 'Centro', 'Cidade Exemplo', 'Cantão A', 'Distrito A', 12345, 'Apto 101'),
  (2, NULL, 1, 'Luiz Felipe Christani', 'M', '2023-01-02', 2, '12345678902', '1992-02-02', 'RH', '2023-01-02', 5000.00, TRUE, '555-2222', 'luiz@empresa.com', '123', 'Rua Principal', 'Centro', 'Cidade Exemplo', 'Cantão A', 'Distrito A', 12345, 'Apto 102'),
  (3, NULL, 1, 'Pietro Porsch Wilhelms', 'M', '2023-01-03', 3, '12345678903', '1993-03-03', 'Financeiro', '2023-01-03', 5500.00, TRUE, '555-3333', 'pietro@empresa.com', '123', 'Rua Principal', 'Centro', 'Cidade Exemplo', 'Cantão A', 'Distrito A', 12345, 'Apto 103'),
  (4, NULL, 1, 'Rafael Luan Schmitz', 'M', '2023-01-04', 4, '12345678904', '1994-04-04', 'Marketing', '2023-01-04', 4800.00, TRUE, '555-4444', 'rafael@empresa.com', '123', 'Rua Principal', 'Centro', 'Cidade Exemplo', 'Cantão A', 'Distrito A', 12345, 'Apto 104'),
  (5, NULL, 1, 'Rodrigo Miguel Teles Dos Santos', 'M', '2023-01-05', 5, '12345678905', '1995-05-05', 'Operações', '2023-01-05', 4700.00, TRUE, '555-5555', 'rodrigo@empresa.com', '123', 'Rua Principal', 'Centro', 'Cidade Exemplo', 'Cantão A', 'Distrito A', 12345, 'Apto 105'),
  (6, NULL, 1, 'Samuel Fernando Bortoluzzi Thums', 'M', '2023-01-06', 6, '12345678906', '1996-06-06', 'Logística', '2023-01-06', 4600.00, TRUE, '555-6666', 'samuel@empresa.com', '123', 'Rua Principal', 'Centro', 'Cidade Exemplo', 'Cantão A', 'Distrito A', 12345, 'Apto 106');


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



-- Populating the pedido_compra table
INSERT INTO pedido_compra (dt_compra, dt_entrega, valor, desconto, usuarioID)
VALUES
  ('2024-01-15', '2024-01-25', 5000.00, 500.00, 1),
  ('2024-02-20', '2024-03-05', 8000.00, 800.00, 2),
  ('2024-03-10', '2024-03-20', 12000.00, 1200.00, 3);

-- Populating the fornecedor table
INSERT INTO fornecedor (nome, endereco, telefone, it_cod)
VALUES
  ('Solar Panels Inc.', '123 Solar St., Solar City', '123-456-7890', 1),
  ('Energy Solutions Ltd.', '456 Power Rd., Energy Town', '234-567-8901', 2),
  ('Green Energy Co.', '789 Eco Ave., Green City', '345-678-9012', 3);

-- Populating the cliente table
INSERT INTO cliente (logisticaID, usuarioID, nome, sobrenome, email, telefone, endereco, cidade, provincia, canton, distrito, postal_code, birth_date, eativo, notas, divida)
VALUES
  (1, 1, 'John', 'Doe', 'john.doe@example.com', '111-222-3333', '123 Elm St.', 'San Jose', 'San Jose', 'Central', 'Carmen', '10101', '1980-05-15', 'TRUE', 'Regular customer', '500.00'),
  (2, 2, 'Jane', 'Smith', 'jane.smith@example.com', '222-333-4444', '456 Oak St.', 'Alajuela', 'Alajuela', 'Central', 'Guacima', '20101', '1990-07-20', 'TRUE', 'Prefers email contact', '750.00'),
  (3, 3, 'Carlos', 'Gonzalez', 'carlos.gonzalez@example.com', '333-444-5555', '789 Pine St.', 'Heredia', 'Heredia', 'Central', 'San Francisco', '30101', '1985-03-25', 'FALSE', 'Inactive account', '0.00');

-- Populating the item table
INSERT INTO item (fornecedorID, estoqueID, nome, descricao, quantidade, valor, fornecedor, categoria)
VALUES
  (1, 1, 'Solar Panel Model X', 'High-efficiency solar panel', 50, 200.00, 'Solar Panels Inc.', 'Solar Panels'),
  (2, 2, 'Inverter Model Y', 'Advanced inverter for solar systems', 20, 500.00, 'Energy Solutions Ltd.', 'Inverters'),
  (3, 3, 'Battery Model Z', 'Long-lasting battery for energy storage', 30, 300.00, 'Green Energy Co.', 'Batteries');

-- Populating the pedido_venda table
INSERT INTO pedido_venda (clienteID, dt_venda, dt_instalacao, valor, desconto)
VALUES
  (1, '2024-02-01', '2024-02-10', 5000.00, 500.00),
  (2, '2024-03-15', '2024-03-25', 8000.00, 800.00),
  (3, '2024-04-01', '2024-04-10', 12000.00, 1200.00);

-- Populating the estoque table
INSERT INTO estoque (quantidade, data_entrada, data_saida, valor_compra, valor_venda)
VALUES
  (100, '2024-01-01', '2024-01-10', 15000.00, 20000.00),
  (200, '2024-02-01', '2024-02-10', 30000.00, 40000.00),
  (300, '2024-03-01', '2024-03-10', 45000.00, 60000.00);

-- Populating the cliente_logistica table
INSERT INTO cliente_logistica (data_entrega, nome, email, telefone, data_nascimento, bairro, cidade, tipo_endereco, data_cadastro)
VALUES
  ('2024-01-25', 'Mike Johnson', 'mike.johnson@example.com', '444-555-6666', '1975-08-30', 'Central', 'San Jose', 'Residential', '2024-01-01'),
  ('2024-03-05', 'Ana Martinez', 'ana.martinez@example.com', '555-666-7777', '1980-04-15', 'Guacima', 'Alajuela', 'Commercial', '2024-02-01'),
  ('2024-04-10', 'Luis Rodriguez', 'luis.rodriguez@example.com', '666-777-8888', '1990-11-20', 'San Francisco', 'Heredia', 'Residential', '2024-03-01');

-- Populating the usuario table
INSERT INTO usuario (usuarioID, companyID, nome, dt_entrada, tipo, ativo, cedula, data_nascimento, departamento, data_admissao, salario, estado, telefone, email, endereco)
VALUES
  (1, 1, 'Alice Brown', '2024-01-10', 1, 'TRUE', '123456789', '1980-01-01', 'Sales', '2020-01-01', 5000.00, 1, '111-111-1111', 'alice.brown@example.com', '123 Main St.'),
  (2, 1, 'Bob White', '2024-01-15', 2, 'TRUE', '987654321', '1985-05-05', 'Support', '2021-02-01', 4000.00, 1, '222-222-2222', 'bob.white@example.com', '456 Side St.'),
  (3, 1, 'Charlie Green', '2024-02-01', 3, 'FALSE', '192837465', '1990-10-10', 'Development', '2022-03-01', 6000.00, 2, '333-333-3333', 'charlie.green@example.com', '789 Back St.');

-- Populating the item_venda table
INSERT INTO item_venda (ped_venda, quantidade, valor_prod, descricao, marca, garantia, composicao, origem)
VALUES
  (1, 5, 200.00, 'Solar Panel Model X', 'Brand A', 5, 'Polycrystalline', 'USA'),
  (2, 3, 500.00, 'Inverter Model Y', 'Brand B', 3, 'Advanced Circuitry', 'Germany'),
  (3, 4, 300.00, 'Battery Model Z', 'Brand C', 2, 'Lithium-Ion', 'Japan');

-- Populating the empresa table
INSERT INTO empresa (nome, logo, website_url, email, telefone, endereco, cidade, provincia, codigo_postal, ano_fundacao, cedula_juridica, setor, numero_licenca)
VALUES
  ('SunBridge Energy', NULL, 'https://sunbridge-energy.com', 'info@sunbridge-energy.com', '888-999-0000', '789 Solar Blvd.', 'San Jose', 'San Jose', '10201', 2010, '123456789012', 'Renewable Energy', 'LIC123456');

-- Populating the pagamento table
INSERT INTO pagamento (clienteID, data_pagamento, valor_pago, forma_pagamento, status_pagamento)
VALUES
  (1, '2024-01-20', 4500.00, 'Credit Card', 'Completed'),
  (2, '2024-03-20', 7200.00, 'Bank Transfer', 'Pending'),
  (3, '2024-04-15', 10800.00, 'Cash', 'Completed');

-- Populating the pedido_fornecedor table
INSERT INTO pedido_fornecedor (ped_compra, quantidade, valor, fornecedorID, pagamento_fornecedorID)
VALUES
  (1, 10, 2000.00, 1, 1),
  (2, 15, 3750.00, 2, 2),
  (3, 20, 6000.00, 3, 3);

-- Populating the item_estoque table
INSERT INTO item_estoque (it_cod, estoqueID)
VALUES
  (1, 1),
  (2, 2),
  (3, 3);

-- Populating the estoque_item_venda table
INSERT INTO estoque_item_venda (estoqueID, itemID)
VALUES
  (1, 1),
  (2, 2),
  (3, 3);

-- Populating the pedido_compra_fornecedor table
INSERT INTO pedido_compra_fornecedor (ped_compra, fornecedorID)
VALUES
  (1, 1),
  (2, 2),
  (3, 3);

-- Populating the pedido_fornecedor_estoque table
INSERT INTO pedido_fornecedor_estoque (pedido_fornecedoritemID, estoqueID)
VALUES
  (1, 1),
  (2, 2),
  (3, 3);

-- Populating the Pagamento_fornecedor table
INSERT INTO pagamento_fornecedor (data, valor)
VALUES
  ('2024-01-25', 5000.00),
  ('2024-03-05', 8000.00),
  ('2024-03-20', 12000.00);
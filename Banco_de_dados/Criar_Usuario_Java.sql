--create database sunbridge;

CREATE ROLE sunbridgejava WITH LOGIN PASSWORD '123abc321cba';

-- Criação do grupo de permissões
CREATE ROLE sunbridge_group;

GRANT CONNECT ON DATABASE sunbridge TO sunbridge_group;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO sunbridge_group;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO sunbridge_group;

ALTER DEFAULT PRIVILEGES IN SCHEMA public
GRANT ALL PRIVILEGES ON TABLES TO sunbridge_group;

ALTER DEFAULT PRIVILEGES IN SCHEMA public
GRANT ALL PRIVILEGES ON SEQUENCES TO sunbridge_group;

-- Criação de um usuário com login
CREATE ROLE sunbridgejava WITH LOGIN PASSWORD '123abc321cba';

GRANT sunbridge_group TO sunbridgejava;


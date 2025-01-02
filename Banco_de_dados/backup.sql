--
-- PostgreSQL database cluster dump
--

-- Started on 2024-11-22 19:22:33

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS;
CREATE ROLE rafa;
ALTER ROLE rafa WITH NOSUPERUSER INHERIT NOCREATEROLE CREATEDB LOGIN NOREPLICATION NOBYPASSRLS;
CREATE ROLE sunbridgejava;
ALTER ROLE sunbridgejava WITH NOSUPERUSER INHERIT NOCREATEROLE NOCREATEDB LOGIN NOREPLICATION NOBYPASSRLS;

--
-- User Configurations
--








--
-- Databases
--

--
-- Database "sunbridge" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

-- Started on 2024-11-22 19:22:33

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4950 (class 1262 OID 25616)
-- Name: sunbridge; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE sunbridge WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';


ALTER DATABASE sunbridge OWNER TO postgres;

\connect sunbridge

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 223 (class 1259 OID 25701)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    clienteid integer NOT NULL,
    usuarioid integer,
    cedula character varying(12),
    nome character varying(40),
    data_nascimento date,
    genero character(1),
    email character varying(60),
    telefone character varying(20),
    data_cadastro date,
    ativo boolean,
    descricao character varying(255),
    divida numeric(10,2),
    rua character varying(60),
    bairro character varying(60),
    cidade character varying(50),
    provincia character varying(50),
    canton character varying(50),
    distrito character varying(50),
    codigo_postal integer,
    complemento character varying(60)
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 4952 (class 0 OID 0)
-- Dependencies: 223
-- Name: TABLE cliente; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.cliente IS 'Tabela que armazena os dados dos clientes.';


--
-- TOC entry 4953 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.clienteid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.clienteid IS 'Identificador único do cliente (Chave Primária).';


--
-- TOC entry 4954 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.usuarioid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.usuarioid IS 'Referência ao usuário responsável pelo cliente.';


--
-- TOC entry 4955 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.cedula; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.cedula IS 'Identificação fiscal do cliente.';


--
-- TOC entry 4956 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.nome; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.nome IS 'Nome completo do cliente.';


--
-- TOC entry 4957 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.data_nascimento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.data_nascimento IS 'Data de nascimento do cliente.';


--
-- TOC entry 4958 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.genero; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.genero IS 'Gênero do cliente (M para masculino, F para feminino).';


--
-- TOC entry 4959 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.email; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.email IS 'Endereço de e-mail do cliente (único).';


--
-- TOC entry 4960 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.telefone; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.telefone IS 'Número de telefone do cliente.';


--
-- TOC entry 4961 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.data_cadastro; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.data_cadastro IS 'Data de cadastro do cliente no sistema.';


--
-- TOC entry 4962 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.ativo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.ativo IS 'Status ativo ou inativo do cliente.';


--
-- TOC entry 4963 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.descricao; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.descricao IS 'Informações adicionais sobre o cliente.';


--
-- TOC entry 4964 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.divida; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.divida IS 'Dívida atual do cliente.';


--
-- TOC entry 4965 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.rua; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.rua IS 'Rua do endereço do cliente.';


--
-- TOC entry 4966 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.bairro; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.bairro IS 'Bairro do endereço do cliente.';


--
-- TOC entry 4967 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.cidade; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.cidade IS 'Cidade do cliente.';


--
-- TOC entry 4968 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.provincia; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.provincia IS 'Província do cliente.';


--
-- TOC entry 4969 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.canton; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.canton IS 'Cantão do cliente.';


--
-- TOC entry 4970 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.distrito; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.distrito IS 'Distrito do cliente.';


--
-- TOC entry 4971 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.codigo_postal; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.codigo_postal IS 'Código postal do cliente.';


--
-- TOC entry 4972 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN cliente.complemento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente.complemento IS 'Complemento do endereço do cliente.';


--
-- TOC entry 228 (class 1259 OID 25767)
-- Name: cliente_logistica; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente_logistica (
    logisticalid integer NOT NULL,
    ped_venda integer,
    cedula character varying(12),
    data_entrega date,
    nome character varying(40),
    genero character(1),
    data_nascimento date,
    email character varying(60),
    telefone character varying(20),
    data_cadastro date,
    rua character varying(60),
    bairro character varying(255),
    cidade character varying(255),
    provincia character varying(255),
    canton character varying(50),
    distrito character varying(50),
    codigo_postal integer,
    complemento character varying(60)
);


ALTER TABLE public.cliente_logistica OWNER TO postgres;

--
-- TOC entry 4974 (class 0 OID 0)
-- Dependencies: 228
-- Name: TABLE cliente_logistica; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.cliente_logistica IS 'Tabela que armazena informações sobre a logística dos pedidos entregues aos clientes.';


--
-- TOC entry 4975 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.logisticalid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.logisticalid IS 'Identificador único da logística (Chave Primária).';


--
-- TOC entry 4976 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.ped_venda; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.ped_venda IS 'Referência ao pedido de venda associado.';


--
-- TOC entry 4977 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.cedula; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.cedula IS 'Identificação fiscal do cliente.';


--
-- TOC entry 4978 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.data_entrega; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.data_entrega IS 'Data de entrega dos produtos ao cliente.';


--
-- TOC entry 4979 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.nome; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.nome IS 'Nome da pessoa responsável pelo recebimento do pedido.';


--
-- TOC entry 4980 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.genero; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.genero IS 'Gênero da pessoa (M para masculino, F para feminino).';


--
-- TOC entry 4981 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.data_nascimento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.data_nascimento IS 'Data de nascimento da pessoa responsável.';


--
-- TOC entry 4982 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.email; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.email IS 'Endereço de e-mail para contato.';


--
-- TOC entry 4983 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.telefone; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.telefone IS 'Número de telefone para contato.';


--
-- TOC entry 4984 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.data_cadastro; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.data_cadastro IS 'Data de cadastro do cliente para logística.';


--
-- TOC entry 4985 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.rua; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.rua IS 'Rua do endereço de entrega.';


--
-- TOC entry 4986 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.bairro; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.bairro IS 'Bairro do endereço de entrega.';


--
-- TOC entry 4987 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.cidade; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.cidade IS 'Cidade de entrega do pedido.';


--
-- TOC entry 4988 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.provincia; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.provincia IS 'Província de entrega do pedido.';


--
-- TOC entry 4989 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.canton; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.canton IS 'Cantão de entrega do pedido.';


--
-- TOC entry 4990 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.distrito; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.distrito IS 'Distrito de entrega do pedido.';


--
-- TOC entry 4991 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.codigo_postal; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.codigo_postal IS 'Código postal do endereço de entrega.';


--
-- TOC entry 4992 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN cliente_logistica.complemento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.cliente_logistica.complemento IS 'Complemento do endereço de entrega.';


--
-- TOC entry 215 (class 1259 OID 25617)
-- Name: empresa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.empresa (
    companyid integer NOT NULL,
    nome character varying(40) NOT NULL,
    websiteurl character varying(255),
    email character varying(60),
    telefone character varying(20),
    cidade character varying(255),
    provincia character varying(255),
    data_fundacao date,
    cedula_juridica character varying(12),
    setor character varying(100),
    numero_licenca character varying(25),
    rua character varying(60),
    bairro character varying(60),
    canton character varying(50),
    distrito character varying(50),
    codigo_postal integer,
    complemento character varying(60)
);


ALTER TABLE public.empresa OWNER TO postgres;

--
-- TOC entry 4994 (class 0 OID 0)
-- Dependencies: 215
-- Name: TABLE empresa; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.empresa IS 'Tabela que armazena as informações das empresas relacionadas à comercialização de painéis solares.';


--
-- TOC entry 4995 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.companyid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.companyid IS 'Identificador único da empresa (Chave Primária).';


--
-- TOC entry 4996 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.nome; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.nome IS 'Nome completo da empresa.';


--
-- TOC entry 4997 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.websiteurl; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.websiteurl IS 'URL do site da empresa.';


--
-- TOC entry 4998 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.email; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.email IS 'Endereço de e-mail de contato da empresa.';


--
-- TOC entry 4999 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.telefone; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.telefone IS 'Número de telefone de contato da empresa.';


--
-- TOC entry 5000 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.cidade; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.cidade IS 'Cidade onde a empresa está localizada.';


--
-- TOC entry 5001 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.provincia; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.provincia IS 'Província onde a empresa está localizada.';


--
-- TOC entry 5002 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.data_fundacao; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.data_fundacao IS 'Data de fundação da empresa.';


--
-- TOC entry 5003 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.cedula_juridica; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.cedula_juridica IS 'Número de identificação fiscal da empresa.';


--
-- TOC entry 5004 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.setor; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.setor IS 'Setor de atuação da empresa, como energia ou serviços.';


--
-- TOC entry 5005 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.numero_licenca; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.numero_licenca IS 'Número de licença de operação da empresa.';


--
-- TOC entry 5006 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.rua; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.rua IS 'Rua do endereço da empresa.';


--
-- TOC entry 5007 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.bairro; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.bairro IS 'Bairro do endereço da empresa.';


--
-- TOC entry 5008 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.canton; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.canton IS 'Cantão onde a empresa está localizada.';


--
-- TOC entry 5009 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.distrito; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.distrito IS 'Distrito onde a empresa está localizada.';


--
-- TOC entry 5010 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.codigo_postal; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.codigo_postal IS 'Código postal do endereço da empresa.';


--
-- TOC entry 5011 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN empresa.complemento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.empresa.complemento IS 'Complemento do endereço, como número e detalhes adicionais.';


--
-- TOC entry 219 (class 1259 OID 25651)
-- Name: estoque; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estoque (
    estoqueid integer NOT NULL,
    rua character varying(60),
    prateleira character varying(30),
    peso integer,
    data_entrada date,
    data_saida date,
    valor_compra numeric(19,2),
    valor_venda numeric(19,2)
);


ALTER TABLE public.estoque OWNER TO postgres;

--
-- TOC entry 5013 (class 0 OID 0)
-- Dependencies: 219
-- Name: TABLE estoque; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.estoque IS 'Tabela para controlar o estoque de itens da empresa.';


--
-- TOC entry 5014 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN estoque.estoqueid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.estoque.estoqueid IS 'Identificador único do estoque (Chave Primária).';


--
-- TOC entry 5015 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN estoque.rua; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.estoque.rua IS 'Localização do estoque na rua específica.';


--
-- TOC entry 5016 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN estoque.prateleira; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.estoque.prateleira IS 'Prateleira onde o item está armazenado.';


--
-- TOC entry 5017 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN estoque.peso; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.estoque.peso IS 'Peso dos itens armazenados no estoque.';


--
-- TOC entry 5018 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN estoque.data_entrada; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.estoque.data_entrada IS 'Data de entrada dos itens no estoque.';


--
-- TOC entry 5019 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN estoque.data_saida; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.estoque.data_saida IS 'Data de saída dos itens do estoque.';


--
-- TOC entry 5020 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN estoque.valor_compra; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.estoque.valor_compra IS 'Valor de compra dos itens armazenados.';


--
-- TOC entry 5021 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN estoque.valor_venda; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.estoque.valor_venda IS 'Valor de venda dos itens armazenados.';


--
-- TOC entry 227 (class 1259 OID 25752)
-- Name: estoque_item_venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estoque_item_venda (
    estoqueid integer NOT NULL,
    item_vendaid integer NOT NULL
);


ALTER TABLE public.estoque_item_venda OWNER TO postgres;

--
-- TOC entry 5023 (class 0 OID 0)
-- Dependencies: 227
-- Name: TABLE estoque_item_venda; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.estoque_item_venda IS 'Tabela de relacionamento entre estoque e itens vendidos.';


--
-- TOC entry 5024 (class 0 OID 0)
-- Dependencies: 227
-- Name: COLUMN estoque_item_venda.estoqueid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.estoque_item_venda.estoqueid IS 'Identificador do estoque relacionado.';


--
-- TOC entry 5025 (class 0 OID 0)
-- Dependencies: 227
-- Name: COLUMN estoque_item_venda.item_vendaid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.estoque_item_venda.item_vendaid IS 'Identificador do item de venda relacionado.';


--
-- TOC entry 217 (class 1259 OID 25641)
-- Name: fornecedor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fornecedor (
    fornecedorid integer NOT NULL,
    nome character varying(40) NOT NULL,
    cedula character varying(12),
    telefone character varying(20),
    rua character varying(60),
    bairro character varying(60),
    cidade character varying(50),
    provincia character varying(50),
    canton character varying(50),
    codigo_postal integer,
    distrito character varying(50),
    complemento character varying(60)
);


ALTER TABLE public.fornecedor OWNER TO postgres;

--
-- TOC entry 5027 (class 0 OID 0)
-- Dependencies: 217
-- Name: TABLE fornecedor; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.fornecedor IS 'Tabela que armazena informações dos fornecedores de materiais ou produtos.';


--
-- TOC entry 5028 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN fornecedor.fornecedorid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.fornecedor.fornecedorid IS 'Identificador único do fornecedor (Chave Primária).';


--
-- TOC entry 5029 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN fornecedor.nome; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.fornecedor.nome IS 'Nome do fornecedor.';


--
-- TOC entry 5030 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN fornecedor.cedula; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.fornecedor.cedula IS 'Identificação fiscal do fornecedor.';


--
-- TOC entry 5031 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN fornecedor.telefone; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.fornecedor.telefone IS 'Número de telefone do fornecedor.';


--
-- TOC entry 5032 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN fornecedor.rua; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.fornecedor.rua IS 'Rua do endereço do fornecedor.';


--
-- TOC entry 5033 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN fornecedor.bairro; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.fornecedor.bairro IS 'Bairro do endereço do fornecedor.';


--
-- TOC entry 5034 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN fornecedor.cidade; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.fornecedor.cidade IS 'Cidade onde o fornecedor está localizado.';


--
-- TOC entry 5035 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN fornecedor.provincia; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.fornecedor.provincia IS 'Província onde o fornecedor está localizado.';


--
-- TOC entry 5036 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN fornecedor.canton; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.fornecedor.canton IS 'Cantão onde o fornecedor está localizado.';


--
-- TOC entry 5037 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN fornecedor.codigo_postal; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.fornecedor.codigo_postal IS 'Código postal do endereço do fornecedor.';


--
-- TOC entry 5038 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN fornecedor.distrito; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.fornecedor.distrito IS 'Distrito onde o fornecedor está localizado.';


--
-- TOC entry 5039 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN fornecedor.complemento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.fornecedor.complemento IS 'Complemento do endereço do fornecedor.';


--
-- TOC entry 222 (class 1259 OID 25691)
-- Name: item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item (
    it_cod integer NOT NULL,
    nome character varying(40) NOT NULL,
    descricao character varying(255),
    quantidade integer,
    valor numeric(19,2),
    categoria character varying(100),
    estoqueid integer
);


ALTER TABLE public.item OWNER TO postgres;

--
-- TOC entry 5041 (class 0 OID 0)
-- Dependencies: 222
-- Name: TABLE item; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.item IS 'Tabela que armazena informações sobre os itens disponíveis no estoque.';


--
-- TOC entry 5042 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN item.it_cod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item.it_cod IS 'Identificador único de cada item (Chave Primária).';


--
-- TOC entry 5043 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN item.nome; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item.nome IS 'Nome do item (por exemplo, painel solar, inversor).';


--
-- TOC entry 5044 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN item.descricao; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item.descricao IS 'Descrição detalhada do item.';


--
-- TOC entry 5045 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN item.quantidade; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item.quantidade IS 'Quantidade de itens disponíveis.';


--
-- TOC entry 5046 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN item.valor; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item.valor IS 'Valor unitário do item.';


--
-- TOC entry 5047 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN item.categoria; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item.categoria IS 'Categoria a que o item pertence.';


--
-- TOC entry 5048 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN item.estoqueid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item.estoqueid IS 'Referência ao estoque onde o item está armazenado.';


--
-- TOC entry 226 (class 1259 OID 25735)
-- Name: item_venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item_venda (
    item_vendaid integer NOT NULL,
    ped_venda integer,
    it_cod integer,
    quantidade integer,
    valor_prod numeric(19,2),
    descricao character varying(255),
    marca character varying(255),
    garantia integer,
    composicao character varying(255),
    origem character varying(255)
);


ALTER TABLE public.item_venda OWNER TO postgres;

--
-- TOC entry 5050 (class 0 OID 0)
-- Dependencies: 226
-- Name: TABLE item_venda; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.item_venda IS 'Tabela que armazena informações dos itens vendidos aos clientes.';


--
-- TOC entry 5051 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN item_venda.item_vendaid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item_venda.item_vendaid IS 'Identificador único do item de venda (Chave Primária).';


--
-- TOC entry 5052 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN item_venda.ped_venda; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item_venda.ped_venda IS 'Referência ao pedido de venda associado.';


--
-- TOC entry 5053 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN item_venda.it_cod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item_venda.it_cod IS 'Referência ao código do item vendido.';


--
-- TOC entry 5054 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN item_venda.quantidade; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item_venda.quantidade IS 'Quantidade de itens vendidos.';


--
-- TOC entry 5055 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN item_venda.valor_prod; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item_venda.valor_prod IS 'Valor do produto vendido.';


--
-- TOC entry 5056 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN item_venda.descricao; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item_venda.descricao IS 'Descrição do item vendido.';


--
-- TOC entry 5057 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN item_venda.marca; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item_venda.marca IS 'Marca do item vendido.';


--
-- TOC entry 5058 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN item_venda.garantia; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item_venda.garantia IS 'Informação sobre garantia do item.';


--
-- TOC entry 5059 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN item_venda.composicao; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item_venda.composicao IS 'Composição do item vendido.';


--
-- TOC entry 5060 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN item_venda.origem; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.item_venda.origem IS 'Origem do item vendido.';


--
-- TOC entry 224 (class 1259 OID 25715)
-- Name: pagamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pagamento (
    pagamentoid integer NOT NULL,
    clienteid integer,
    data_pagamento date,
    valor_pago numeric(10,2),
    forma_pagamento character varying(20),
    status_pagamento character varying(20)
);


ALTER TABLE public.pagamento OWNER TO postgres;

--
-- TOC entry 5062 (class 0 OID 0)
-- Dependencies: 224
-- Name: TABLE pagamento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.pagamento IS 'Tabela que armazena registros de pagamentos realizados pelos clientes.';


--
-- TOC entry 5063 (class 0 OID 0)
-- Dependencies: 224
-- Name: COLUMN pagamento.pagamentoid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pagamento.pagamentoid IS 'Identificador único do pagamento (Chave Primária).';


--
-- TOC entry 5064 (class 0 OID 0)
-- Dependencies: 224
-- Name: COLUMN pagamento.clienteid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pagamento.clienteid IS 'Referência ao cliente que realizou o pagamento.';


--
-- TOC entry 5065 (class 0 OID 0)
-- Dependencies: 224
-- Name: COLUMN pagamento.data_pagamento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pagamento.data_pagamento IS 'Data do pagamento realizado.';


--
-- TOC entry 5066 (class 0 OID 0)
-- Dependencies: 224
-- Name: COLUMN pagamento.valor_pago; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pagamento.valor_pago IS 'Valor total pago pelo cliente.';


--
-- TOC entry 5067 (class 0 OID 0)
-- Dependencies: 224
-- Name: COLUMN pagamento.forma_pagamento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pagamento.forma_pagamento IS 'Método utilizado para o pagamento.';


--
-- TOC entry 5068 (class 0 OID 0)
-- Dependencies: 224
-- Name: COLUMN pagamento.status_pagamento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pagamento.status_pagamento IS 'Status atual do pagamento (Pago ou pendente).';


--
-- TOC entry 218 (class 1259 OID 25646)
-- Name: pagamento_fornecedor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pagamento_fornecedor (
    pagamento_fornecedorid integer NOT NULL,
    data_pagamento date,
    valor numeric(19,2),
    forma_pagamento character varying(20)
);


ALTER TABLE public.pagamento_fornecedor OWNER TO postgres;

--
-- TOC entry 5070 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE pagamento_fornecedor; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.pagamento_fornecedor IS 'Tabela que armazena informações sobre os pagamentos realizados a fornecedores.';


--
-- TOC entry 5071 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN pagamento_fornecedor.pagamento_fornecedorid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pagamento_fornecedor.pagamento_fornecedorid IS 'Identificador único do pagamento ao fornecedor (Chave Primária).';


--
-- TOC entry 5072 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN pagamento_fornecedor.data_pagamento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pagamento_fornecedor.data_pagamento IS 'Data em que o pagamento foi realizado.';


--
-- TOC entry 5073 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN pagamento_fornecedor.valor; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pagamento_fornecedor.valor IS 'Valor do pagamento ao fornecedor.';


--
-- TOC entry 5074 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN pagamento_fornecedor.forma_pagamento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pagamento_fornecedor.forma_pagamento IS 'Forma de pagamento utilizada.';


--
-- TOC entry 220 (class 1259 OID 25656)
-- Name: pedido_compra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido_compra (
    ped_compra integer NOT NULL,
    data_compra date,
    data_entrega date,
    valor numeric(19,2),
    desconto numeric(19,2),
    usuarioid integer,
    pagamento_fornecedorid integer,
    fornecedorid integer
);


ALTER TABLE public.pedido_compra OWNER TO postgres;

--
-- TOC entry 5076 (class 0 OID 0)
-- Dependencies: 220
-- Name: TABLE pedido_compra; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.pedido_compra IS 'Tabela para armazenar pedidos de compra feitos pela empresa.';


--
-- TOC entry 5077 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN pedido_compra.ped_compra; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_compra.ped_compra IS 'Identificador único do pedido de compra (Chave Primária).';


--
-- TOC entry 5078 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN pedido_compra.data_compra; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_compra.data_compra IS 'Data em que o pedido de compra foi realizado.';


--
-- TOC entry 5079 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN pedido_compra.data_entrega; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_compra.data_entrega IS 'Data prevista para a entrega do pedido.';


--
-- TOC entry 5080 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN pedido_compra.valor; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_compra.valor IS 'Valor total do pedido de compra.';


--
-- TOC entry 5081 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN pedido_compra.desconto; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_compra.desconto IS 'Valor do desconto aplicado ao pedido.';


--
-- TOC entry 5082 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN pedido_compra.usuarioid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_compra.usuarioid IS 'Identificador do usuário que realizou o pedido.';


--
-- TOC entry 5083 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN pedido_compra.pagamento_fornecedorid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_compra.pagamento_fornecedorid IS 'Identificador do pagamento associado ao fornecedor.';


--
-- TOC entry 5084 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN pedido_compra.fornecedorid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_compra.fornecedorid IS 'Identificador do fornecedor para o pedido.';


--
-- TOC entry 221 (class 1259 OID 25676)
-- Name: pedido_fornecedor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido_fornecedor (
    pedido_forid integer NOT NULL,
    quantidade integer,
    valor numeric(19,2),
    pedido_compra integer,
    estoqueid integer
);


ALTER TABLE public.pedido_fornecedor OWNER TO postgres;

--
-- TOC entry 5086 (class 0 OID 0)
-- Dependencies: 221
-- Name: TABLE pedido_fornecedor; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.pedido_fornecedor IS 'Tabela que armazena os detalhes dos pedidos feitos aos fornecedores.';


--
-- TOC entry 5087 (class 0 OID 0)
-- Dependencies: 221
-- Name: COLUMN pedido_fornecedor.pedido_forid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_fornecedor.pedido_forid IS 'Identificador único do pedido ao fornecedor (Chave Primária).';


--
-- TOC entry 5088 (class 0 OID 0)
-- Dependencies: 221
-- Name: COLUMN pedido_fornecedor.quantidade; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_fornecedor.quantidade IS 'Quantidade de itens solicitados no pedido.';


--
-- TOC entry 5089 (class 0 OID 0)
-- Dependencies: 221
-- Name: COLUMN pedido_fornecedor.valor; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_fornecedor.valor IS 'Valor total do pedido.';


--
-- TOC entry 5090 (class 0 OID 0)
-- Dependencies: 221
-- Name: COLUMN pedido_fornecedor.pedido_compra; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_fornecedor.pedido_compra IS 'Referência ao pedido de compra associado.';


--
-- TOC entry 5091 (class 0 OID 0)
-- Dependencies: 221
-- Name: COLUMN pedido_fornecedor.estoqueid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_fornecedor.estoqueid IS 'Identificador do estoque onde os itens serão armazenados.';


--
-- TOC entry 225 (class 1259 OID 25725)
-- Name: pedido_venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido_venda (
    ped_venda integer NOT NULL,
    clienteid integer,
    data_venda date,
    data_instalacao date,
    valor numeric(19,2),
    desconto numeric(19,2)
);


ALTER TABLE public.pedido_venda OWNER TO postgres;

--
-- TOC entry 5093 (class 0 OID 0)
-- Dependencies: 225
-- Name: TABLE pedido_venda; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.pedido_venda IS 'Tabela que armazena os pedidos de venda realizados por clientes.';


--
-- TOC entry 5094 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN pedido_venda.ped_venda; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_venda.ped_venda IS 'Identificador único do pedido de venda (Chave Primária).';


--
-- TOC entry 5095 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN pedido_venda.clienteid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_venda.clienteid IS 'Referência ao cliente que realizou o pedido.';


--
-- TOC entry 5096 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN pedido_venda.data_venda; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_venda.data_venda IS 'Data em que o pedido foi feito.';


--
-- TOC entry 5097 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN pedido_venda.data_instalacao; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_venda.data_instalacao IS 'Data de instalação dos produtos vendidos.';


--
-- TOC entry 5098 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN pedido_venda.valor; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_venda.valor IS 'Valor total do pedido de venda.';


--
-- TOC entry 5099 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN pedido_venda.desconto; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.pedido_venda.desconto IS 'Desconto aplicado no pedido de venda.';


--
-- TOC entry 216 (class 1259 OID 25624)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    usuarioid integer NOT NULL,
    usuarioid_fk integer,
    companyid integer,
    nome character varying(40) NOT NULL,
    genero character(1),
    data_entrada date,
    tipo integer,
    cedula character varying(15),
    data_nascimento date,
    departamento character varying(100),
    data_admissao date,
    salario numeric(10,2),
    ativo boolean,
    telefone character varying(20),
    email character varying(60),
    endereco character varying(60),
    rua character varying(60),
    bairro character varying(60),
    cidade character varying(50),
    canton character varying(50),
    distrito character varying(50),
    codigo_postal integer,
    complemento character varying(60)
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 5101 (class 0 OID 0)
-- Dependencies: 216
-- Name: TABLE usuario; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.usuario IS 'Tabela que registra os dados dos funcionários ou usuários do sistema.';


--
-- TOC entry 5102 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.usuarioid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.usuarioid IS 'Identificador único do usuário (Chave Primária).';


--
-- TOC entry 5103 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.usuarioid_fk; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.usuarioid_fk IS 'Referência para outro usuário, geralmente um supervisor ou gerente.';


--
-- TOC entry 5104 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.companyid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.companyid IS 'Identificador da empresa à qual o usuário está associado.';


--
-- TOC entry 5105 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.nome; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.nome IS 'Nome completo do usuário.';


--
-- TOC entry 5106 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.genero; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.genero IS 'Gênero do usuário (M para masculino, F para feminino).';


--
-- TOC entry 5107 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.data_entrada; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.data_entrada IS 'Data de entrada do usuário na empresa.';


--
-- TOC entry 5108 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.tipo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.tipo IS 'Tipo ou cargo do usuário.';


--
-- TOC entry 5109 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.cedula; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.cedula IS 'Número de identificação fiscal do usuário.';


--
-- TOC entry 5110 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.data_nascimento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.data_nascimento IS 'Data de nascimento do usuário.';


--
-- TOC entry 5111 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.departamento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.departamento IS 'Departamento onde o usuário trabalha.';


--
-- TOC entry 5112 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.data_admissao; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.data_admissao IS 'Data de admissão do usuário.';


--
-- TOC entry 5113 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.salario; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.salario IS 'Salário mensal do usuário.';


--
-- TOC entry 5114 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.ativo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.ativo IS 'Indica se o usuário está ativo (TRUE) ou inativo (FALSE).';


--
-- TOC entry 5115 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.telefone; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.telefone IS 'Número de telefone do usuário.';


--
-- TOC entry 5116 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.email; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.email IS 'Endereço de e-mail do usuário.';


--
-- TOC entry 5117 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.endereco; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.endereco IS 'Endereço completo do usuário.';


--
-- TOC entry 5118 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.rua; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.rua IS 'Rua do endereço do usuário.';


--
-- TOC entry 5119 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.bairro; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.bairro IS 'Bairro do endereço do usuário.';


--
-- TOC entry 5120 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.cidade; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.cidade IS 'Cidade onde o usuário reside.';


--
-- TOC entry 5121 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.canton; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.canton IS 'Cantão do endereço do usuário.';


--
-- TOC entry 5122 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.distrito; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.distrito IS 'Distrito do endereço do usuário.';


--
-- TOC entry 5123 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.codigo_postal; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.codigo_postal IS 'Código postal do endereço do usuário.';


--
-- TOC entry 5124 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN usuario.complemento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.usuario.complemento IS 'Complemento do endereço do usuário.';


--
-- TOC entry 4939 (class 0 OID 25701)
-- Dependencies: 223
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (clienteid, usuarioid, cedula, nome, data_nascimento, genero, email, telefone, data_cadastro, ativo, descricao, divida, rua, bairro, cidade, provincia, canton, distrito, codigo_postal, complemento) FROM stdin;
\.


--
-- TOC entry 4944 (class 0 OID 25767)
-- Dependencies: 228
-- Data for Name: cliente_logistica; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente_logistica (logisticalid, ped_venda, cedula, data_entrega, nome, genero, data_nascimento, email, telefone, data_cadastro, rua, bairro, cidade, provincia, canton, distrito, codigo_postal, complemento) FROM stdin;
\.


--
-- TOC entry 4931 (class 0 OID 25617)
-- Dependencies: 215
-- Data for Name: empresa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.empresa (companyid, nome, websiteurl, email, telefone, cidade, provincia, data_fundacao, cedula_juridica, setor, numero_licenca, rua, bairro, canton, distrito, codigo_postal, complemento) FROM stdin;
\.


--
-- TOC entry 4935 (class 0 OID 25651)
-- Dependencies: 219
-- Data for Name: estoque; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estoque (estoqueid, rua, prateleira, peso, data_entrada, data_saida, valor_compra, valor_venda) FROM stdin;
\.


--
-- TOC entry 4943 (class 0 OID 25752)
-- Dependencies: 227
-- Data for Name: estoque_item_venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estoque_item_venda (estoqueid, item_vendaid) FROM stdin;
\.


--
-- TOC entry 4933 (class 0 OID 25641)
-- Dependencies: 217
-- Data for Name: fornecedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fornecedor (fornecedorid, nome, cedula, telefone, rua, bairro, cidade, provincia, canton, codigo_postal, distrito, complemento) FROM stdin;
\.


--
-- TOC entry 4938 (class 0 OID 25691)
-- Dependencies: 222
-- Data for Name: item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.item (it_cod, nome, descricao, quantidade, valor, categoria, estoqueid) FROM stdin;
\.


--
-- TOC entry 4942 (class 0 OID 25735)
-- Dependencies: 226
-- Data for Name: item_venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.item_venda (item_vendaid, ped_venda, it_cod, quantidade, valor_prod, descricao, marca, garantia, composicao, origem) FROM stdin;
\.


--
-- TOC entry 4940 (class 0 OID 25715)
-- Dependencies: 224
-- Data for Name: pagamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pagamento (pagamentoid, clienteid, data_pagamento, valor_pago, forma_pagamento, status_pagamento) FROM stdin;
\.


--
-- TOC entry 4934 (class 0 OID 25646)
-- Dependencies: 218
-- Data for Name: pagamento_fornecedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pagamento_fornecedor (pagamento_fornecedorid, data_pagamento, valor, forma_pagamento) FROM stdin;
\.


--
-- TOC entry 4936 (class 0 OID 25656)
-- Dependencies: 220
-- Data for Name: pedido_compra; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido_compra (ped_compra, data_compra, data_entrega, valor, desconto, usuarioid, pagamento_fornecedorid, fornecedorid) FROM stdin;
\.


--
-- TOC entry 4937 (class 0 OID 25676)
-- Dependencies: 221
-- Data for Name: pedido_fornecedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido_fornecedor (pedido_forid, quantidade, valor, pedido_compra, estoqueid) FROM stdin;
\.


--
-- TOC entry 4941 (class 0 OID 25725)
-- Dependencies: 225
-- Data for Name: pedido_venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido_venda (ped_venda, clienteid, data_venda, data_instalacao, valor, desconto) FROM stdin;
\.


--
-- TOC entry 4932 (class 0 OID 25624)
-- Dependencies: 216
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (usuarioid, usuarioid_fk, companyid, nome, genero, data_entrada, tipo, cedula, data_nascimento, departamento, data_admissao, salario, ativo, telefone, email, endereco, rua, bairro, cidade, canton, distrito, codigo_postal, complemento) FROM stdin;
\.


--
-- TOC entry 4757 (class 2606 OID 25709)
-- Name: cliente cliente_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_email_key UNIQUE (email);


--
-- TOC entry 4769 (class 2606 OID 25775)
-- Name: cliente_logistica cliente_logistica_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente_logistica
    ADD CONSTRAINT cliente_logistica_email_key UNIQUE (email);


--
-- TOC entry 4771 (class 2606 OID 25773)
-- Name: cliente_logistica cliente_logistica_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente_logistica
    ADD CONSTRAINT cliente_logistica_pkey PRIMARY KEY (logisticalid);


--
-- TOC entry 4759 (class 2606 OID 25707)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (clienteid);


--
-- TOC entry 4741 (class 2606 OID 25623)
-- Name: empresa empresa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT empresa_pkey PRIMARY KEY (companyid);


--
-- TOC entry 4767 (class 2606 OID 25756)
-- Name: estoque_item_venda estoque_item_venda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estoque_item_venda
    ADD CONSTRAINT estoque_item_venda_pkey PRIMARY KEY (estoqueid, item_vendaid);


--
-- TOC entry 4749 (class 2606 OID 25655)
-- Name: estoque estoque_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT estoque_pkey PRIMARY KEY (estoqueid);


--
-- TOC entry 4745 (class 2606 OID 25645)
-- Name: fornecedor fornecedor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT fornecedor_pkey PRIMARY KEY (fornecedorid);


--
-- TOC entry 4755 (class 2606 OID 25695)
-- Name: item item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (it_cod);


--
-- TOC entry 4765 (class 2606 OID 25741)
-- Name: item_venda item_venda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_venda
    ADD CONSTRAINT item_venda_pkey PRIMARY KEY (item_vendaid);


--
-- TOC entry 4747 (class 2606 OID 25650)
-- Name: pagamento_fornecedor pagamento_fornecedor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamento_fornecedor
    ADD CONSTRAINT pagamento_fornecedor_pkey PRIMARY KEY (pagamento_fornecedorid);


--
-- TOC entry 4761 (class 2606 OID 25719)
-- Name: pagamento pagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamento
    ADD CONSTRAINT pagamento_pkey PRIMARY KEY (pagamentoid);


--
-- TOC entry 4751 (class 2606 OID 25660)
-- Name: pedido_compra pedido_compra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_compra
    ADD CONSTRAINT pedido_compra_pkey PRIMARY KEY (ped_compra);


--
-- TOC entry 4753 (class 2606 OID 25680)
-- Name: pedido_fornecedor pedido_fornecedor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_fornecedor
    ADD CONSTRAINT pedido_fornecedor_pkey PRIMARY KEY (pedido_forid);


--
-- TOC entry 4763 (class 2606 OID 25729)
-- Name: pedido_venda pedido_venda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_venda
    ADD CONSTRAINT pedido_venda_pkey PRIMARY KEY (ped_venda);


--
-- TOC entry 4743 (class 2606 OID 25630)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (usuarioid);


--
-- TOC entry 4787 (class 2606 OID 25776)
-- Name: cliente_logistica cliente_logistica_ped_venda_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente_logistica
    ADD CONSTRAINT cliente_logistica_ped_venda_fkey FOREIGN KEY (ped_venda) REFERENCES public.pedido_venda(ped_venda);


--
-- TOC entry 4780 (class 2606 OID 25710)
-- Name: cliente cliente_usuarioid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_usuarioid_fkey FOREIGN KEY (usuarioid) REFERENCES public.usuario(usuarioid);


--
-- TOC entry 4785 (class 2606 OID 25757)
-- Name: estoque_item_venda estoque_item_venda_estoqueid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estoque_item_venda
    ADD CONSTRAINT estoque_item_venda_estoqueid_fkey FOREIGN KEY (estoqueid) REFERENCES public.estoque(estoqueid);


--
-- TOC entry 4786 (class 2606 OID 25762)
-- Name: estoque_item_venda estoque_item_venda_item_vendaid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estoque_item_venda
    ADD CONSTRAINT estoque_item_venda_item_vendaid_fkey FOREIGN KEY (item_vendaid) REFERENCES public.item_venda(item_vendaid);


--
-- TOC entry 4779 (class 2606 OID 25696)
-- Name: item item_estoqueid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_estoqueid_fkey FOREIGN KEY (estoqueid) REFERENCES public.estoque(estoqueid);


--
-- TOC entry 4783 (class 2606 OID 25747)
-- Name: item_venda item_venda_it_cod_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_venda
    ADD CONSTRAINT item_venda_it_cod_fkey FOREIGN KEY (it_cod) REFERENCES public.item(it_cod);


--
-- TOC entry 4784 (class 2606 OID 25742)
-- Name: item_venda item_venda_ped_venda_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_venda
    ADD CONSTRAINT item_venda_ped_venda_fkey FOREIGN KEY (ped_venda) REFERENCES public.pedido_venda(ped_venda);


--
-- TOC entry 4781 (class 2606 OID 25720)
-- Name: pagamento pagamento_clienteid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamento
    ADD CONSTRAINT pagamento_clienteid_fkey FOREIGN KEY (clienteid) REFERENCES public.cliente(clienteid);


--
-- TOC entry 4774 (class 2606 OID 25671)
-- Name: pedido_compra pedido_compra_fornecedorid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_compra
    ADD CONSTRAINT pedido_compra_fornecedorid_fkey FOREIGN KEY (fornecedorid) REFERENCES public.fornecedor(fornecedorid);


--
-- TOC entry 4775 (class 2606 OID 25666)
-- Name: pedido_compra pedido_compra_pagamento_fornecedorid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_compra
    ADD CONSTRAINT pedido_compra_pagamento_fornecedorid_fkey FOREIGN KEY (pagamento_fornecedorid) REFERENCES public.pagamento_fornecedor(pagamento_fornecedorid);


--
-- TOC entry 4776 (class 2606 OID 25661)
-- Name: pedido_compra pedido_compra_usuarioid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_compra
    ADD CONSTRAINT pedido_compra_usuarioid_fkey FOREIGN KEY (usuarioid) REFERENCES public.usuario(usuarioid);


--
-- TOC entry 4777 (class 2606 OID 25686)
-- Name: pedido_fornecedor pedido_fornecedor_estoqueid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_fornecedor
    ADD CONSTRAINT pedido_fornecedor_estoqueid_fkey FOREIGN KEY (estoqueid) REFERENCES public.estoque(estoqueid);


--
-- TOC entry 4778 (class 2606 OID 25681)
-- Name: pedido_fornecedor pedido_fornecedor_pedido_compra_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_fornecedor
    ADD CONSTRAINT pedido_fornecedor_pedido_compra_fkey FOREIGN KEY (pedido_compra) REFERENCES public.pedido_compra(ped_compra);


--
-- TOC entry 4782 (class 2606 OID 25730)
-- Name: pedido_venda pedido_venda_clienteid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_venda
    ADD CONSTRAINT pedido_venda_clienteid_fkey FOREIGN KEY (clienteid) REFERENCES public.cliente(clienteid);


--
-- TOC entry 4772 (class 2606 OID 25631)
-- Name: usuario usuario_companyid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_companyid_fkey FOREIGN KEY (companyid) REFERENCES public.empresa(companyid);


--
-- TOC entry 4773 (class 2606 OID 25636)
-- Name: usuario usuario_usuarioid_fk_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_usuarioid_fk_fkey FOREIGN KEY (usuarioid_fk) REFERENCES public.usuario(usuarioid);


--
-- TOC entry 4951 (class 0 OID 0)
-- Dependencies: 4950
-- Name: DATABASE sunbridge; Type: ACL; Schema: -; Owner: postgres
--

GRANT CONNECT ON DATABASE sunbridge TO sunbridgejava;


--
-- TOC entry 4973 (class 0 OID 0)
-- Dependencies: 223
-- Name: TABLE cliente; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.cliente TO sunbridgejava;


--
-- TOC entry 4993 (class 0 OID 0)
-- Dependencies: 228
-- Name: TABLE cliente_logistica; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.cliente_logistica TO sunbridgejava;


--
-- TOC entry 5012 (class 0 OID 0)
-- Dependencies: 215
-- Name: TABLE empresa; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.empresa TO sunbridgejava;


--
-- TOC entry 5022 (class 0 OID 0)
-- Dependencies: 219
-- Name: TABLE estoque; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.estoque TO sunbridgejava;


--
-- TOC entry 5026 (class 0 OID 0)
-- Dependencies: 227
-- Name: TABLE estoque_item_venda; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.estoque_item_venda TO sunbridgejava;


--
-- TOC entry 5040 (class 0 OID 0)
-- Dependencies: 217
-- Name: TABLE fornecedor; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.fornecedor TO sunbridgejava;


--
-- TOC entry 5049 (class 0 OID 0)
-- Dependencies: 222
-- Name: TABLE item; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.item TO sunbridgejava;


--
-- TOC entry 5061 (class 0 OID 0)
-- Dependencies: 226
-- Name: TABLE item_venda; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.item_venda TO sunbridgejava;


--
-- TOC entry 5069 (class 0 OID 0)
-- Dependencies: 224
-- Name: TABLE pagamento; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.pagamento TO sunbridgejava;


--
-- TOC entry 5075 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE pagamento_fornecedor; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.pagamento_fornecedor TO sunbridgejava;


--
-- TOC entry 5085 (class 0 OID 0)
-- Dependencies: 220
-- Name: TABLE pedido_compra; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.pedido_compra TO sunbridgejava;


--
-- TOC entry 5092 (class 0 OID 0)
-- Dependencies: 221
-- Name: TABLE pedido_fornecedor; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.pedido_fornecedor TO sunbridgejava;


--
-- TOC entry 5100 (class 0 OID 0)
-- Dependencies: 225
-- Name: TABLE pedido_venda; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.pedido_venda TO sunbridgejava;


--
-- TOC entry 5125 (class 0 OID 0)
-- Dependencies: 216
-- Name: TABLE usuario; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.usuario TO sunbridgejava;


--
-- TOC entry 2089 (class 826 OID 25784)
-- Name: DEFAULT PRIVILEGES FOR TABLES; Type: DEFAULT ACL; Schema: public; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA public GRANT ALL ON TABLES TO sunbridgejava;


-- Completed on 2024-11-22 19:22:33

--
-- PostgreSQL database dump complete
--

-- Completed on 2024-11-22 19:22:33

--
-- PostgreSQL database cluster dump complete
--


--------------------------------------------------------------------------------------------------------------------------------------------
-- Schema: meubar
--------------------------------------------------------------------------------------------------------------------------------------------
DROP SCHEMA meubar CASCADE;

CREATE SCHEMA meubar
  AUTHORIZATION application;

GRANT ALL ON SCHEMA meubar TO application;

ALTER DEFAULT PRIVILEGES IN SCHEMA meubar
    GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLES
    TO application;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.estado
-- DROP TABLE meubar.estado;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.estado
(
  id serial NOT NULL,
  uf character varying(2) NOT NULL,
  nome character varying(20) NOT NULL,
  CONSTRAINT estado_pkey PRIMARY KEY (id),
  CONSTRAINT uq_estado_uf UNIQUE (uf),
  CONSTRAINT uq_estado_nome UNIQUE (nome)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.estado OWNER TO postgres;
GRANT ALL ON TABLE meubar.estado TO postgres;
GRANT ALL ON TABLE meubar.estado TO application;
GRANT USAGE ON SEQUENCE meubar.estado_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.estado_id_seq TO application;

INSERT INTO meubar.estado(uf, nome)  VALUES  ('AC','ACRE');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('AL','ALAGOAS');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('AP','AMAPA');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('AM','AMAZONAS');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('BA','BAHIA');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('CE','CEARA');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('DF','DISTRITO FEDERAL');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('ES','ESPIRITO SANTO');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('GO','GOIAS');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('MA','MARANHAO');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('MT','MATO GROSSO');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('MS','MATO GROSSO DO SUL');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('MG','MINAS GERAIS');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('PA','PARA');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('PB','PARAIBA');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('PR','PARANA');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('PE','PERNAMBUCO');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('PI','PIAUI');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('RJ','RIO DE JANEIRO');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('RN','RIO GRANDE DO NORTE');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('RS','RIO GRANDE DO SUL');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('RO','RONDONIA');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('RR','RORAIMA');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('SC','SANTA CATARINA');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('SP','SAO PAULO');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('SE','SERGIPE');
INSERT INTO meubar.estado(uf, nome)  VALUES  ('TO','TOCANTINS');
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.mesa
-- DROP TABLE meubar.mesa;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.mesa
(
  id serial NOT NULL,
  numero character varying(10) NOT NULL,
  CONSTRAINT mesa_pkey PRIMARY KEY (id),
  CONSTRAINT uq_mesa_numero UNIQUE (numero)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.mesa OWNER TO postgres;
GRANT ALL ON TABLE meubar.mesa TO postgres;
GRANT ALL ON TABLE meubar.mesa TO application;
GRANT USAGE ON SEQUENCE meubar.mesa_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.mesa_id_seq TO application;

INSERT INTO meubar.mesa(numero)  VALUES  ('1');
INSERT INTO meubar.mesa(numero)  VALUES  ('2');
INSERT INTO meubar.mesa(numero)  VALUES  ('3');
INSERT INTO meubar.mesa(numero)  VALUES  ('4');
INSERT INTO meubar.mesa(numero)  VALUES  ('5');
INSERT INTO meubar.mesa(numero)  VALUES  ('6');
INSERT INTO meubar.mesa(numero)  VALUES  ('7');
INSERT INTO meubar.mesa(numero)  VALUES  ('8');
INSERT INTO meubar.mesa(numero)  VALUES  ('9');
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.unidade
-- DROP TABLE meubar.unidade;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.unidade
(
  id serial NOT NULL,
  sigla character varying(4) NOT NULL,
  nome character varying(20) NOT NULL,
  CONSTRAINT unidade_pkey PRIMARY KEY (id),
  CONSTRAINT uq_unidade_sigla UNIQUE (sigla),
  CONSTRAINT uq_unidade_nome UNIQUE (nome)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.unidade OWNER TO postgres;
GRANT ALL ON TABLE meubar.unidade TO postgres;
GRANT ALL ON TABLE meubar.unidade TO application;
GRANT USAGE ON SEQUENCE meubar.unidade_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.unidade_id_seq TO application;

INSERT INTO meubar.unidade(sigla, nome)  VALUES  ('Un','UNIDADE');
INSERT INTO meubar.unidade(sigla, nome)  VALUES  ('L','LITRO');
INSERT INTO meubar.unidade(sigla, nome)  VALUES  ('Kg','KILOS');
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.grupo
-- DROP TABLE meubar.grupo;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.grupo
(
  id serial NOT NULL,
  nome character varying(20) NOT NULL,
  data_criacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  data_modificacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  usuario_id_criacao integer NOT NULL DEFAULT 1, 
  usuario_id_modificacao integer NOT NULL DEFAULT 1,
  CONSTRAINT grupo_pkey PRIMARY KEY (id),
  CONSTRAINT uq_grupo_nome UNIQUE (nome)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.grupo OWNER TO postgres;
GRANT ALL ON TABLE meubar.grupo TO postgres;
GRANT ALL ON TABLE meubar.grupo TO application;
GRANT USAGE ON SEQUENCE meubar.grupo_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.grupo_id_seq TO application;

INSERT INTO meubar.grupo(nome)  VALUES  ( 'Administrador' );
INSERT INTO meubar.grupo(nome)  VALUES  ( 'Gerente' );
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.usuario
-- DROP TABLE meubar.usuario;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.usuario
(
  id serial NOT NULL,
  login character varying(20) NOT NULL,
  senha character varying(255) NOT NULL,
  nome character varying(255) NOT NULL,
  cpf character varying(11) NOT NULL,
  telefone character varying(15),
  status character varying(1) NOT NULL DEFAULT 'A',
  grupo_id integer,
  data_criacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  data_modificacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  usuario_id_criacao integer NOT NULL DEFAULT 1, 
  usuario_id_modificacao integer NOT NULL DEFAULT 1,
  CONSTRAINT usuario_grupo_fk FOREIGN KEY ("grupo_id") REFERENCES meubar.grupo (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT usuario_status_check CHECK (status IN ('A','I')),
  CONSTRAINT usuario_pkey PRIMARY KEY (id),
  CONSTRAINT uq_usuario_login UNIQUE (login),
  CONSTRAINT uq_usuario_cpf UNIQUE (cpf)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.usuario OWNER TO postgres;
GRANT ALL ON TABLE meubar.usuario TO postgres;
GRANT ALL ON TABLE meubar.usuario TO application;
GRANT USAGE ON SEQUENCE meubar.usuario_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.usuario_id_seq TO application;

-- User admin
INSERT INTO meubar.usuario(login, senha, nome, cpf, telefone, grupo_id) VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3','Administrador', '00000000000','+000000000000', 1);
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.fornecedor
-- DROP TABLE meubar.fornecedor;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.fornecedor
(
  id serial NOT NULL,
  nome character varying(50) NOT NULL,
  cnpj character varying(14) NOT NULL,
  estado_id integer,
  cidade character varying(255),
  endereco character varying(255),
  telefone character varying(15),
  data_criacao timestamp without time zone NOT NULL DEFAULT current_timestamp,
  data_modificacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  usuario_id_criacao integer NOT NULL DEFAULT 1, 
  usuario_id_modificacao integer NOT NULL DEFAULT 1,
  CONSTRAINT fornecedor_estado_fk FOREIGN KEY ("estado_id") REFERENCES meubar.estado (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT fornecedor_usuario_id_criacao_fk FOREIGN KEY ("usuario_id_criacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT fornecedor_usuario_id_modificacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT fornecedor_pkey PRIMARY KEY (id),
  CONSTRAINT uq_fornecedor_cnpj UNIQUE (cnpj)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.fornecedor OWNER TO postgres;
GRANT ALL ON TABLE meubar.fornecedor TO postgres;
GRANT ALL ON TABLE meubar.fornecedor TO application;
GRANT USAGE ON SEQUENCE meubar.fornecedor_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.fornecedor_id_seq TO application;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.categoria
-- DROP TABLE meubar.categoria;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.categoria
(
  id serial NOT NULL,
  nome character varying(20) NOT NULL,
  data_criacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  data_modificacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  usuario_id_criacao integer NOT NULL, 
  usuario_id_modificacao integer NOT NULL,
  CONSTRAINT categoria_usuario_id_criacao_fk FOREIGN KEY ("usuario_id_criacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT categoria_usuario_id_modificacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT categoria_pkey PRIMARY KEY (id),
  CONSTRAINT uq_categoria_nome UNIQUE (nome)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.categoria OWNER TO postgres;
GRANT ALL ON TABLE meubar.categoria TO postgres;
GRANT ALL ON TABLE meubar.categoria TO application;
GRANT USAGE ON SEQUENCE meubar.categoria_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.categoria_id_seq TO application;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.produto
-- DROP TABLE meubar.produto;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.produto
(
  id serial NOT NULL,
  nome character varying(50) NOT NULL,
  unidade_id integer,
  categoria_id integer,
  data_criacao timestamp without time zone NOT NULL DEFAULT current_timestamp,
  data_modificacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  usuario_id_criacao integer NOT NULL DEFAULT 1, 
  usuario_id_modificacao integer NOT NULL DEFAULT 1,
  CONSTRAINT produto_unidade_fk FOREIGN KEY ("unidade_id") REFERENCES meubar.unidade (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT produto_categoria_fk FOREIGN KEY ("categoria_id") REFERENCES meubar.categoria (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT produto_usuario_id_criacao_fk FOREIGN KEY ("usuario_id_criacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT produto_usuario_id_modificacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT produto_pkey PRIMARY KEY (id),
  CONSTRAINT uq_produto_nome_categoria UNIQUE (nome, categoria_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.produto OWNER TO postgres;
GRANT ALL ON TABLE meubar.produto TO postgres;
GRANT ALL ON TABLE meubar.produto TO application;
GRANT USAGE ON SEQUENCE meubar.produto_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.produto_id_seq TO application;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.estoque_controle
-- DROP TABLE meubar.estoque_controle;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.estoque_controle
(
  id serial NOT NULL,
  produto_id integer,
  quantidade numeric(8, 2) NOT NULL,
  CONSTRAINT estoque_controle_produto_fk FOREIGN KEY ("produto_id") REFERENCES meubar.produto (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT estoque_controle_pkey PRIMARY KEY (id),
  CONSTRAINT estoque_controle_quantidade_check CHECK (quantidade > 0),
  CONSTRAINT uq_estoque_controle_produto UNIQUE (produto_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.estoque_controle OWNER TO postgres;
GRANT ALL ON TABLE meubar.estoque_controle TO postgres;
GRANT ALL ON TABLE meubar.estoque_controle TO application;
GRANT USAGE ON SEQUENCE meubar.estoque_controle_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.estoque_controle_id_seq TO application;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.estoque_entrada
-- DROP TABLE meubar.estoque_entrada;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.estoque_entrada
(
  id serial NOT NULL,
  fornecedor_id integer,
  produto_id integer,
  nota_fiscal character varying(30),
  quantidade numeric(7, 2) NOT NULL,
  preco numeric(8, 2) NOT NULL,
  data_criacao timestamp without time zone NOT NULL DEFAULT current_timestamp,
  data_modificacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  usuario_id_criacao integer NOT NULL DEFAULT 1, 
  usuario_id_modificacao integer NOT NULL DEFAULT 1,
  CONSTRAINT estoque_entrada_fornecedor_fk FOREIGN KEY ("fornecedor_id") REFERENCES meubar.fornecedor (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT estoque_entrada_produto_fk FOREIGN KEY ("produto_id") REFERENCES meubar.produto (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT estoque_entrada_usuario_id_criacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT estoque_entrada_usuario_id_modificacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT estoque_entrada_pkey PRIMARY KEY (id),
  CONSTRAINT estoque_entrada_quantidade_check CHECK (quantidade > 0),
  CONSTRAINT estoque_entrada_preco_check CHECK (preco > 0),
  CONSTRAINT uq_estoque_entrada_nota_fiscal_produto UNIQUE (nota_fiscal, produto_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.estoque_entrada OWNER TO postgres;
GRANT ALL ON TABLE meubar.estoque_entrada TO postgres;
GRANT ALL ON TABLE meubar.estoque_entrada TO application;
GRANT USAGE ON SEQUENCE meubar.estoque_entrada_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.estoque_entrada_id_seq TO application;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Function: meubar.insertEstoqueEntrada()
-- DROP FUNCTION IF EXISTS meubar.insertEstoqueEntrada() CASCADE;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION meubar.insertEstoqueEntrada() RETURNS TRIGGER AS $estoque_entrada_insert_tg$
    DECLARE
	actual_qtd_item numeric(8,2);
	new_qtd_item numeric(8,2);
    BEGIN
	
	SELECT quantidade into actual_qtd_item
	FROM meubar.estoque_controle
	WHERE produto_id = new.produto_id;
	
	IF actual_qtd_item ISNULL THEN
		INSERT INTO meubar.estoque_controle(produto_id, quantidade) VALUES (new.produto_id, new.quantidade);
	ELSE
		new_qtd_item = actual_qtd_item + new.quantidade;
		UPDATE meubar.estoque_controle SET quantidade = new_qtd_item WHERE produto_id = new.produto_id;
	END IF;
	
	RETURN NEW;
    END;    
$estoque_entrada_insert_tg$ LANGUAGE plpgsql;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Trigger: estoque_entrada_insert_tg
-- DROP TRIGGER IF EXISTS entrada_estoque_insert_tg ON meubar.estoque_entrada CASCADE;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE CONSTRAINT 
TRIGGER estoque_entrada_insert_tg AFTER INSERT ON meubar.estoque_entrada
FOR EACH ROW
EXECUTE PROCEDURE meubar.insertEstoqueEntrada();
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Function: meubar.deleteEstoqueEntrada()
-- DROP FUNCTION IF EXISTS meubar.deleteEstoqueEntrada() CASCADE;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION meubar.deleteEstoqueEntrada() RETURNS TRIGGER AS $estoque_entrada_delete_tg$
    DECLARE
	new_qtd_item numeric(8,2);
	actual_qtd_old_item numeric(8,2);
    BEGIN

	SELECT quantidade into actual_qtd_old_item
	FROM meubar.estoque_controle
	WHERE produto_id = old.produto_id;
	
	IF actual_qtd_old_item ISNULL THEN
		RAISE EXCEPTION '[ERR-UPEST006]Impossivel retirar tal quandidade dos itens atuais<nao existe quantidade>';
	ELSE
		new_qtd_item = actual_qtd_old_item - old.quantidade;
		IF new_qtd_item < 0 THEN
			RAISE EXCEPTION '[ERR-UPEST007]Impossivel retirar tal quandidade dos itens atuais - Estoque: % - Deleted: %', actual_qtd_old_item, old.quantidade;
		ELSEIF new_qtd_item > 0 THEN
			UPDATE meubar.estoque_controle SET quantidade = new_qtd_item WHERE produto_id = old.produto_id;
		ELSE
			DELETE FROM meubar.estoque_controle WHERE produto_id = old.produto_id;
		END IF;
	END IF;
	
	RETURN NEW;
    END;    
$estoque_entrada_delete_tg$ LANGUAGE plpgsql;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Trigger: estoque_entrada_delete_tg
-- DROP TRIGGER IF EXISTS estoque_entrada_delete_tg ON meubar.estoque_entrada CASCADE;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE CONSTRAINT 
TRIGGER estoque_entrada_delete_tg AFTER DELETE ON meubar.estoque_entrada
FOR EACH ROW
EXECUTE PROCEDURE meubar.deleteEstoqueEntrada();
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Function: meubar.updateEstoqueEntrada()
-- DROP FUNCTION IF EXISTS meubar.updateEstoqueEntrada() CASCADE;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION meubar.updateEstoqueEntrada() RETURNS TRIGGER AS $estoque_entrada_update_tg$
	DECLARE
		actual_qtd_item numeric(8,2);
		new_qtd_item numeric(8,2);
		new_qtd_old_item numeric(8,2);
		actual_qtd_old_item numeric(8,2);
    BEGIN
	
		SELECT quantidade into actual_qtd_item
		FROM meubar.estoque_controle
		WHERE produto_id = new.produto_id;

		SELECT quantidade into actual_qtd_old_item
		FROM meubar.estoque_controle
		WHERE produto_id = old.produto_id;
		
		IF old.produto_id = new.produto_id THEN
			IF actual_qtd_item ISNULL THEN
				new_qtd_item = new.quantidade - old.quantidade;
				IF new_qtd_item < 0 THEN
					RAISE EXCEPTION '[ERR-UPEST001]Impossivel retirar tantos itens do item de origem<quantidade atual nao existe>';
				ELSEIF new_qtd_item > 0 THEN
					INSERT INTO meubar.estoque_controle(produto_id, quantidade) VALUES (new.produto_id, new_qtd_item);
				ELSE
					DELETE FROM meubar.estoque_controle WHERE produto_id = old.produto_id;
				END IF;
			ELSE
				new_qtd_item = actual_qtd_item + (new.quantidade - old.quantidade);
				IF new_qtd_item < 0 THEN
					RAISE EXCEPTION '[ERR-UPEST002]Impossivel retirar tantos itens do item de origem';
				ELSEIF new_qtd_item > 0 THEN
					UPDATE meubar.estoque_controle SET quantidade = new_qtd_item WHERE produto_id = new.produto_id;
				ELSE
					DELETE FROM meubar.estoque_controle WHERE produto_id = old.produto_id;
				END IF;
			END IF;
		ELSE

			new_qtd_old_item = actual_qtd_old_item - old.quantidade;
			IF new_qtd_old_item < 0 THEN
				RAISE EXCEPTION '[ERR-UPEST003]Impossivel retirar tantos itens do produto anterior';
			ELSEIF new_qtd_old_item > 0 THEN
				UPDATE meubar.estoque_controle SET quantidade=new_qtd_old_item WHERE produto_id = old.produto_id;
			ELSE
				DELETE FROM meubar.estoque_controle WHERE produto_id = old.produto_id;
			END IF;
			
			IF actual_qtd_item ISNULL THEN
				INSERT INTO meubar.estoque_controle(produto_id, quantidade) VALUES (new.produto_id, new.quantidade);
			ELSE
				new_qtd_item = actual_qtd_item + new.quantidade;
				UPDATE meubar.estoque_controle SET quantidade = new_qtd_item WHERE produto_id = new.produto_id;
			END IF;

		END IF;
		
		RETURN NEW;
    END;    
$estoque_entrada_update_tg$ LANGUAGE plpgsql;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Trigger: estoque_entrada_update_tg
-- DROP TRIGGER IF EXISTS estoque_entrada_update_tg ON meubar.estoque_entrada CASCADE;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE CONSTRAINT 
TRIGGER estoque_entrada_update_tg AFTER UPDATE ON meubar.estoque_entrada
FOR EACH ROW
EXECUTE PROCEDURE meubar.updateEstoqueEntrada();
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.estoque_avulso
-- DROP TABLE meubar.estoque_avulso;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.estoque_avulso
(
  id serial NOT NULL,
  produto_id integer,
  tipo character varying(1) NOT NULL,
  quantidade numeric(8, 2) NOT NULL,
  motivo character varying(500) NOT NULL,
  preco numeric(8, 2) NOT NULL DEFAULT 0,
  data_criacao timestamp without time zone NOT NULL DEFAULT current_timestamp,
  data_modificacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  usuario_id_criacao integer NOT NULL DEFAULT 1, 
  usuario_id_modificacao integer NOT NULL DEFAULT 1,
  CONSTRAINT estoque_avulso_produto_fk FOREIGN KEY ("produto_id") REFERENCES meubar.produto (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT estoque_avulso_usuario_id_criacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT estoque_avulso_usuario_id_modificacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT estoque_avulso_pkey PRIMARY KEY (id),
  CONSTRAINT estoque_avulso_quantidade_check CHECK (quantidade > 0),
  CONSTRAINT estoque_avulso_preco_check CHECK (preco >= 0),
  CONSTRAINT estoque_avulso_tipo_check CHECK (tipo in ('S','E'))
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.estoque_avulso OWNER TO postgres;
GRANT ALL ON TABLE meubar.estoque_avulso TO postgres;
GRANT ALL ON TABLE meubar.estoque_avulso TO application;
GRANT USAGE ON SEQUENCE meubar.estoque_avulso_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.estoque_avulso_id_seq TO application;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Function: meubar.insertEstoqueAvulso()
-- DROP FUNCTION IF EXISTS meubar.insertEstoqueAvulso() CASCADE;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION meubar.insertEstoqueAvulso() RETURNS TRIGGER AS $estoque_avulso_insert_tg$
DECLARE
	actual_qtd_item numeric(8,2);
	new_qtd_item numeric(8,2);
BEGIN
	
	SELECT quantidade into actual_qtd_item
	FROM meubar.estoque_controle
	WHERE produto_id = new.produto_id;
	
	IF new.tipo = 'E' THEN
		IF actual_qtd_item ISNULL THEN
			INSERT INTO meubar.estoque_controle(produto_id, quantidade) VALUES (new.produto_id, new.quantidade);
		ELSE
			new_qtd_item = actual_qtd_item + new.quantidade;
			UPDATE meubar.estoque_controle SET quantidade = new_qtd_item WHERE produto_id = new.produto_id;
		END IF;
	ELSE
		IF actual_qtd_item ISNULL THEN
			RAISE EXCEPTION '[ERR_IN_ES_AV_001]Valor de saída impossivel para as quantidades do item, verifique o estoque % => %', new.produto_id, new_qtd_item;
		ELSE
			new_qtd_item = actual_qtd_item - new.quantidade;
			IF new_qtd_item < 0 THEN
				RAISE EXCEPTION '[ERR_IN_ES_AV_001]Valor de saída impossivel para as quantidades do item, verifique o estoque % => %', new.produto_id, new_qtd_item;
			ELSEIF new_qtd_item > 0 THEN
				UPDATE meubar.estoque_controle SET quantidade = new_qtd_item WHERE produto_id = new.produto_id;
			ELSE
				DELETE FROM meubar.estoque_controle WHERE produto_id = new.produto_id;
			END IF;
			
		END IF;
	END IF;
	
	RETURN NEW;
END;    
$estoque_avulso_insert_tg$ LANGUAGE plpgsql;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Trigger: estoque_avulso_insert_tg
-- DROP TRIGGER IF EXISTS estoque_avulso_insert_tg ON meubar.estoque_avulso CASCADE;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE CONSTRAINT 
TRIGGER estoque_avulso_insert_tg AFTER INSERT ON meubar.estoque_avulso
FOR EACH ROW
EXECUTE PROCEDURE meubar.insertEstoqueAvulso();
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Function: meubar.deleteEstoqueAvulso()
-- DROP FUNCTION IF EXISTS meubar.deleteEstoqueAvulso() CASCADE;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION meubar.deleteEstoqueAvulso() RETURNS TRIGGER AS $estoque_avulso_delete_tg$
DECLARE
	new_qtd_item numeric(8,2);
	actual_qtd_old_item numeric(8,2);
BEGIN

	SELECT quantidade into actual_qtd_old_item
	FROM meubar.estoque_controle
	WHERE produto_id = old.produto_id;
	
	IF old.tipo = 'E' THEN
		IF actual_qtd_old_item ISNULL THEN
			RAISE EXCEPTION '[ERR-UPEST006]Impossivel retirar tal quandidade dos itens atuais <nao existe quantidade>';
		ELSE
			new_qtd_item = actual_qtd_old_item - old.quantidade;
			IF new_qtd_item < 0 THEN
				RAISE EXCEPTION '[ERR-UPEST007]Impossivel retirar tal quandidade dos itens atuais - Estoque: % - Deleted: %', actual_qtd_old_item, old.quantidade;
			ELSEIF new_qtd_item > 0 THEN
				UPDATE meubar.estoque_controle SET quantidade = new_qtd_item WHERE produto_id = old.produto_id;
			ELSE
				DELETE FROM meubar.estoque_controle WHERE produto_id = old.produto_id;
			END IF;
		END IF;
	ELSE
		IF actual_qtd_old_item ISNULL THEN
			INSERT INTO meubar.estoque_controle(produto_id, quantidade) VALUES (old.produto_id, old.quantidade);
		ELSE
			new_qtd_item = actual_qtd_old_item + old.quantidade;
			UPDATE meubar.estoque_controle SET quantidade = new_qtd_item WHERE produto_id = old.produto_id;
		END IF;
	END IF;
	
	RETURN NEW;
END;    
$estoque_avulso_delete_tg$ LANGUAGE plpgsql;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Trigger: estoque_avulso_delete_tg
-- DROP TRIGGER IF EXISTS estoque_avulso_delete_tg ON meubar.estoque_avulso CASCADE;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE CONSTRAINT 
TRIGGER estoque_avulso_delete_tg AFTER DELETE ON meubar.estoque_avulso
FOR EACH ROW
EXECUTE PROCEDURE meubar.deleteEstoqueAvulso();
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Function: meubar.updateEstoqueAvulso()
-- DROP FUNCTION IF EXISTS meubar.updateEstoqueAvulso() CASCADE;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION meubar.updateEstoqueAvulso() RETURNS TRIGGER AS $estoque_avulso_update_tg$
	DECLARE
		actual_qtd_item numeric(8,2);
		new_qtd_item numeric(8,2);
		new_qtd_old_item numeric(8,2);
		actual_qtd_old_item numeric(8,2);
    BEGIN
	
		SELECT quantidade into actual_qtd_item
		FROM meubar.estoque_controle
		WHERE produto_id = new.produto_id;

		IF actual_qtd_item IS NULL THEN
			actual_qtd_item = 0;
		END IF;
		
		SELECT quantidade into actual_qtd_old_item
		FROM meubar.estoque_controle
		WHERE produto_id = old.produto_id;
		
		IF actual_qtd_old_item IS NULL THEN
			actual_qtd_old_item = 0;
		END IF;
		
		IF old.produto_id = new.produto_id THEN
		
			IF old.tipo = new.tipo THEN

				IF old.tipo = 'E' THEN
					new_qtd_item = actual_qtd_item + (new.quantidade - old.quantidade);
				ELSE
					new_qtd_item = actual_qtd_item + (old.quantidade - new.quantidade);
				END IF;
			
			ELSEIF old.tipo = 'E' THEN
				
				new_qtd_item = actual_qtd_item - (old.quantidade + new.quantidade);
				
			ELSE
				
				new_qtd_item = actual_qtd_item + (old.quantidade + new.quantidade);
				
			END IF;
			
			IF new_qtd_item < 0 THEN
				RAISE EXCEPTION '[ERR_UP_ES_AV_001]Valor impossivel para as quantidades do item, verifique o estoque % => %', new.produto_id, new_qtd_item;
			END IF;
			
		ELSE

			IF old.tipo = 'E' THEN
				new_qtd_old_item = actual_qtd_old_item - old.quantidade;
			ELSE
				new_qtd_old_item = actual_qtd_old_item + old.quantidade;
			END IF;
			
			IF new_qtd_old_item < 0 THEN
				RAISE EXCEPTION '[ERR_UP_ES_AV_001]Valor impossivel para as quantidades do item anterior, verifique o estoque % => %', old.produto_id, new_qtd_old_item;
			END IF;
			
			IF new.tipo = 'E' THEN
				new_qtd_item = actual_qtd_item + new.quantidade;
			ELSE
				new_qtd_item = actual_qtd_item - new.quantidade;
			END IF;

			IF new_qtd_item < 0 THEN
				RAISE EXCEPTION '[ERR_UP_ES_AV_001]Valor impossivel para as quantidades do item, verifique o estoque % => %', new.produto_id, new_qtd_item;
			END IF;
			
			IF new_qtd_old_item = 0 THEN
				DELETE FROM meubar.estoque_controle WHERE produto_id = old.produto_id;
			ELSE
				UPDATE meubar.estoque_controle SET quantidade = new_qtd_old_item WHERE produto_id = old.produto_id; 
			END IF;

		END IF;
		
		IF new_qtd_item = 0 AND actual_qtd_item <> 0 THEN
			DELETE FROM meubar.estoque_controle WHERE produto_id = new.produto_id;
		ELSEIF actual_qtd_item = 0 THEN
			INSERT INTO meubar.estoque_controle(produto_id, quantidade) VALUES (new.produto_id, new_qtd_item);
		ELSE
			UPDATE meubar.estoque_controle SET quantidade = new_qtd_item WHERE produto_id = new.produto_id; 
		END IF;
		
		RETURN NEW;
    END;    
$estoque_avulso_update_tg$ LANGUAGE plpgsql;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Trigger: estoque_avulso_update_tg
-- DROP TRIGGER IF EXISTS estoque_avulso_update_tg ON meubar.estoque_avulso CASCADE;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE CONSTRAINT 
TRIGGER estoque_avulso_update_tg AFTER UPDATE ON meubar.estoque_avulso
FOR EACH ROW
EXECUTE PROCEDURE meubar.updateEstoqueAvulso();
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.cardapio_secao
-- DROP TABLE meubar.cardapio_secao;
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.cardapio_secao
(
  id serial NOT NULL,
  nome character varying(30) NOT NULL,
  data_criacao timestamp without time zone NOT NULL DEFAULT current_timestamp,
  data_modificacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  usuario_id_criacao integer NOT NULL DEFAULT 1, 
  usuario_id_modificacao integer NOT NULL DEFAULT 1,
  CONSTRAINT cardapio_secao_usuario_id_criacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT cardapio_secao_usuario_id_modificacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT cardapio_secao_pkey PRIMARY KEY (id),
  CONSTRAINT uq_cardapio_secao_nome UNIQUE (nome)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.cardapio_secao OWNER TO postgres;
GRANT ALL ON TABLE meubar.cardapio_secao TO postgres;
GRANT ALL ON TABLE meubar.cardapio_secao TO application;
GRANT USAGE ON SEQUENCE meubar.cardapio_secao_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.cardapio_secao_id_seq TO application;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.cardapio_item
-- DROP TABLE meubar.cardapio_item
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.cardapio_item
(
  id serial NOT NULL,
  numero integer,
  nome character varying(30) NOT NULL,
  preco numeric(8, 2) NOT NULL,
  cardapio_secao_id integer,
  data_criacao timestamp without time zone NOT NULL DEFAULT current_timestamp,
  data_modificacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  usuario_id_criacao integer NOT NULL DEFAULT 1, 
  usuario_id_modificacao integer NOT NULL DEFAULT 1,
  CONSTRAINT cardapio_item_cardapio_secao_fk FOREIGN KEY ("cardapio_secao_id") REFERENCES meubar.cardapio_secao (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT cardapio_item_usuario_id_criacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT cardapio_item_usuario_id_modificacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT cardapio_item_pkey PRIMARY KEY (id),
  CONSTRAINT cardapio_item_preco_check CHECK (preco > 0),
  CONSTRAINT uq_cardapio_item_numero UNIQUE (numero),
  CONSTRAINT uq_cardapio_item_cardapio_secao_nome UNIQUE (cardapio_secao_id,nome)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.cardapio_item OWNER TO postgres;
GRANT ALL ON TABLE meubar.cardapio_item TO postgres;
GRANT ALL ON TABLE meubar.cardapio_item TO application;
GRANT USAGE ON SEQUENCE meubar.cardapio_item_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.cardapio_item_id_seq TO application;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.cardapio_item_composicao
-- DROP TABLE meubar.cardapio_item_composicao
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.cardapio_item_composicao
(
  id serial NOT NULL,
  cardapio_item_id integer,
  produto_id integer,
  quantidade numeric(8, 2) NOT NULL,
  cardapio_secao_id integer,
  data_criacao timestamp without time zone NOT NULL DEFAULT current_timestamp,
  data_modificacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  usuario_id_criacao integer NOT NULL DEFAULT 1, 
  usuario_id_modificacao integer NOT NULL DEFAULT 1,
  CONSTRAINT cardapio_item_composicao_cardapio_item_fk FOREIGN KEY ("cardapio_item_id") REFERENCES meubar.cardapio_item (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT cardapio_item_composicao_produto_fk FOREIGN KEY ("produto_id") REFERENCES meubar.produto (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT cardapio_item_composicao_cardapio_secao_fk FOREIGN KEY ("cardapio_secao_id") REFERENCES meubar.cardapio_secao (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT cardapio_item_composicao_usuario_id_criacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT cardapio_item_composicao_usuario_id_modificacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT cardapio_item_composicao_pkey PRIMARY KEY (id),
  CONSTRAINT cardapio_item_composicao_quantidade_check CHECK (quantidade > 0)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.cardapio_item_composicao OWNER TO postgres;
GRANT ALL ON TABLE meubar.cardapio_item_composicao TO postgres;
GRANT ALL ON TABLE meubar.cardapio_item_composicao TO application;
GRANT USAGE ON SEQUENCE meubar.cardapio_item_composicao_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.cardapio_item_composicao_id_seq TO application;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.conta
-- DROP TABLE meubar.conta
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.conta
(
  id serial NOT NULL,
  mesa_id integer,
  status character varying(1) NOT NULL DEFAULT 'A',
  saldo numeric(8, 2) NOT NULL,
  data_criacao timestamp without time zone NOT NULL DEFAULT current_timestamp,
  data_modificacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  usuario_id_criacao integer NOT NULL DEFAULT 1, 
  usuario_id_modificacao integer NOT NULL DEFAULT 1,
  CONSTRAINT conta_mesa_fk FOREIGN KEY ("mesa_id") REFERENCES meubar.mesa (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT conta_usuario_id_criacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT conta_usuario_id_modificacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT conta_status_check CHECK (status IN ('A', 'F', 'P')),
  CONSTRAINT conta_status_saldo_check CHECK (saldo >= 0),
  CONSTRAINT conta_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.conta OWNER TO postgres;
GRANT ALL ON TABLE meubar.conta TO postgres;
GRANT ALL ON TABLE meubar.conta TO application;
GRANT USAGE ON SEQUENCE meubar.conta_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.conta_id_seq TO application;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.tipo_pagamento
-- DROP TABLE meubar.tipo_pagamento
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.tipo_pagamento
(
  id serial NOT NULL,
  nome character varying(30) NOT NULL,
  destino character varying(50) NOT NULL,
  outras_informacoes character varying(500),
  data_criacao timestamp without time zone NOT NULL DEFAULT current_timestamp,
  data_modificacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  usuario_id_criacao integer NOT NULL DEFAULT 1, 
  usuario_id_modificacao integer NOT NULL DEFAULT 1,
  CONSTRAINT tipo_pagamento_usuario_id_criacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT tipo_pagamento_usuario_id_modificacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT tipo_pagamento_pkey PRIMARY KEY (id),
  CONSTRAINT uq_tipo_pagamento_nome UNIQUE (nome)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.tipo_pagamento OWNER TO postgres;
GRANT ALL ON TABLE meubar.tipo_pagamento TO postgres;
GRANT ALL ON TABLE meubar.tipo_pagamento TO application;
GRANT USAGE ON SEQUENCE meubar.tipo_pagamento_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.tipo_pagamento_id_seq TO application;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.pagamento
-- DROP TABLE meubar.pagamento
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.pagamento
(
  id serial NOT NULL,
  conta_id integer,
  tipo_pagamento_id integer,
  valor numeric(8, 2) NOT NULL,
  data_criacao timestamp without time zone NOT NULL DEFAULT current_timestamp,
  data_modificacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  usuario_id_criacao integer NOT NULL DEFAULT 1, 
  usuario_id_modificacao integer NOT NULL DEFAULT 1,
  CONSTRAINT pagamento_conta_fk FOREIGN KEY ("conta_id") REFERENCES meubar.conta (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT pagamento_tipo_pagamento_fk FOREIGN KEY ("tipo_pagamento_id") REFERENCES meubar.tipo_pagamento (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT pagamento_usuario_id_criacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT pagamento_usuario_id_modificacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT pagamento_valor_check CHECK (valor > 0),
  CONSTRAINT pagamento_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.pagamento OWNER TO postgres;
GRANT ALL ON TABLE meubar.pagamento TO postgres;
GRANT ALL ON TABLE meubar.pagamento TO application;
GRANT USAGE ON SEQUENCE meubar.pagamento_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.pagamento_id_seq TO application;
--------------------------------------------------------------------------------------------------------------------------------------------
-- *****************************************************************************************************************************************
-- *****************************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------------------------
-- Table: meubar.pedido
-- DROP TABLE meubar.pedido
--------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE meubar.pedido
(
  id serial NOT NULL,
  conta_id integer,
  cardapio_item_id integer,
  preco numeric(8, 2) NOT NULL,
  status character varying(1) NOT NULL DEFAULT 'S',
  data_criacao timestamp without time zone NOT NULL DEFAULT current_timestamp,
  data_modificacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  usuario_id_criacao integer NOT NULL DEFAULT 1, 
  usuario_id_modificacao integer NOT NULL DEFAULT 1,
  CONSTRAINT pedido_conta_fk FOREIGN KEY ("conta_id") REFERENCES meubar.conta (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT pedido_cardapio_item_fk FOREIGN KEY ("cardapio_item_id") REFERENCES meubar.cardapio_item (id) ON UPDATE NO ACTION ON DELETE SET NULL,
  CONSTRAINT pedido_usuario_id_criacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT pedido_usuario_id_modificacao_fk FOREIGN KEY ("usuario_id_modificacao") REFERENCES meubar.usuario (id) ON UPDATE NO ACTION ON DELETE SET DEFAULT,
  CONSTRAINT pedido_status_check CHECK (status IN ('S','P', 'E')),
  CONSTRAINT pedido_preco_check CHECK (preco > 0),
  CONSTRAINT pedido_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.pedido OWNER TO postgres;
GRANT ALL ON TABLE meubar.pedido TO postgres;
GRANT ALL ON TABLE meubar.pedido TO application;
GRANT USAGE ON SEQUENCE meubar.pedido_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.pedido_id_seq TO application;
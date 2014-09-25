-- Schema: meubar

DROP SCHEMA meubar CASCADE;

CREATE SCHEMA meubar
  AUTHORIZATION application;

GRANT ALL ON SCHEMA meubar TO application;

ALTER DEFAULT PRIVILEGES IN SCHEMA meubar
    GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLES
    TO application;
	
-- Table: meubar.grupo

-- DROP TABLE meubar.grupo;

CREATE TABLE meubar.grupo
(
  id serial NOT NULL,
  nome character varying(20) NOT NULL,
  data_criacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  data_modificacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  usuario_id_criacao integer NOT NULL DEFAULT 1, 
  usuario_id_modificacao integer NOT NULL DEFAULT 1,
  CONSTRAINT grupo_pkey PRIMARY KEY (id),
  CONSTRAINT uq_nome UNIQUE (nome)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.grupo
  OWNER TO postgres;
GRANT ALL ON TABLE meubar.grupo TO postgres;
GRANT ALL ON TABLE meubar.grupo TO application;
GRANT USAGE ON SEQUENCE meubar.grupo_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.grupo_id_seq TO application;

-- Table: meubar.usuario

-- DROP TABLE meubar.usuario;

CREATE TABLE meubar.usuario
(
  id serial NOT NULL,
  login character varying(20) NOT NULL,
  senha character varying(255) NOT NULL,
  nome character varying(255) NOT NULL,
  cpf character varying(11) NOT NULL,
  telefone character varying(15),
  grupo_id integer NOT NULL,
  data_criacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  data_modificacao timestamp without time zone NOT NULL DEFAULT current_timestamp, 
  usuario_id_criacao integer NOT NULL DEFAULT 1, 
  usuario_id_modificacao integer NOT NULL DEFAULT 1,
  CONSTRAINT usuario_grupo_fk FOREIGN KEY ("grupo_id") REFERENCES meubar.grupo (id) ON UPDATE NO ACTION ON DELETE CASCADE,
  CONSTRAINT usuario_pkey PRIMARY KEY (id),
  CONSTRAINT uq_login UNIQUE (login),
  CONSTRAINT uq_cpf UNIQUE (cpf)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE meubar.usuario
  OWNER TO postgres;
GRANT ALL ON TABLE meubar.usuario TO postgres;
GRANT ALL ON TABLE meubar.usuario TO application;
GRANT USAGE ON SEQUENCE meubar.usuario_id_seq TO postgres;
GRANT USAGE ON SEQUENCE meubar.usuario_id_seq TO application;

-- Group and User Admin
INSERT INTO meubar.grupo(nome)  VALUES  ( 'Administrador' );
INSERT INTO meubar.usuario(login, senha, nome, cpf, telefone, grupo_id) VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3','Filipe Mendes', '08016230652','+553184682428', 1);
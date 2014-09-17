-- Schema: meubar

-- DROP SCHEMA meubar;

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
  grupo character varying(20),
  CONSTRAINT grupo_pkey PRIMARY KEY (id),
  CONSTRAINT uq_grupo UNIQUE (grupo)
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
  login character varying(20),
  senha character varying(255),
  grupo_id integer NOT NULL,
  CONSTRAINT usuario_grupo_fk FOREIGN KEY ("grupo_id") REFERENCES meubar.grupo (id) ON UPDATE NO ACTION ON DELETE CASCADE,
  CONSTRAINT usuario_pkey PRIMARY KEY (id),
  CONSTRAINT uq_login UNIQUE (login)
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
INSERT INTO meubar.grupo(grupo)  VALUES  ( 'Administrador' );
INSERT INTO meubar.usuario(login, senha, grupo_id) VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', 1);
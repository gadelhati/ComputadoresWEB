-- Database: sinais

-- DROP DATABASE sinais;

CREATE DATABASE sinais
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;
-- Table: area

-- DROP TABLE area;

CREATE TABLE area
(
  id bigint NOT NULL,
  nome character(1) NOT NULL,
  CONSTRAINT area_pkey PRIMARY KEY (id),
  CONSTRAINT uk_m69r6tf1w9c2y32wplvqt9kx2 UNIQUE (nome)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE area
  OWNER TO postgres;
-- Table: aviso

-- DROP TABLE aviso;

CREATE TABLE aviso
(
  id bigint NOT NULL,
  area character varying(16) NOT NULL,
  designacao character varying(16) NOT NULL,
  fim date,
  inicio date,
  numero bigint,
  idfolheto real,
  CONSTRAINT aviso_pkey PRIMARY KEY (id),
  CONSTRAINT fk_jr9bblhphkojhjcq6f0xsg9hw FOREIGN KEY (idfolheto)
      REFERENCES folheto (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE aviso
  OWNER TO postgres;
-- Table: banda

-- DROP TABLE banda;

CREATE TABLE banda
(
  id bigint NOT NULL,
  alcancemaximo real,
  banda character varying(16) NOT NULL,
  comprimentodaonda real,
  idradar bigint,
  CONSTRAINT banda_pkey PRIMARY KEY (id),
  CONSTRAINT fk_3tfjtv12oiyfk0g4mudhjg1b8 FOREIGN KEY (idradar)
      REFERENCES radar (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_elqcvrw14vrt0nil0ig3jnsbi FOREIGN KEY (id)
      REFERENCES radar (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE banda
  OWNER TO postgres;
-- Table: cego

-- DROP TABLE cego;

CREATE TABLE cego
(
  categoria character varying(16) NOT NULL,
  id bigint NOT NULL,
  CONSTRAINT cego_pkey PRIMARY KEY (id),
  CONSTRAINT fk_gnwa78ibpaptfpnkv0x2irhp1 FOREIGN KEY (id)
      REFERENCES instalacao (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_m9kpga4nqxmu5yabd7ktbtxl0 UNIQUE (categoria)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE cego
  OWNER TO postgres;
-- Table: cidade

-- DROP TABLE cidade;

CREATE TABLE cidade
(
  id bigint NOT NULL,
  nome character varying(32) NOT NULL,
  idestado bigint,
  CONSTRAINT cidade_pkey PRIMARY KEY (id),
  CONSTRAINT fk_24t1pyb110miaerifrjfurc7t FOREIGN KEY (idestado)
      REFERENCES estado (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE cidade
  OWNER TO postgres;
-- Table: correcao

-- DROP TABLE correcao;

CREATE TABLE correcao
(
  id bigint NOT NULL,
  acao character varying(16),
  bacalhal boolean NOT NULL,
  legenda character varying(16),
  numero bigint NOT NULL,
  referencia character varying(16),
  status character varying(16) NOT NULL,
  idaviso bigint,
  idestrutura bigint,
  CONSTRAINT correcao_pkey PRIMARY KEY (id),
  CONSTRAINT fk_i2d0snkfauy11jmbhdwicsty0 FOREIGN KEY (idaviso)
      REFERENCES aviso (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_nfpk9b9hoso8crr84h6vmsvqt FOREIGN KEY (idestrutura)
      REFERENCES estrutura (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE correcao
  OWNER TO postgres;
-- Table: embarcacao

-- DROP TABLE embarcacao;

CREATE TABLE embarcacao
(
  boca real,
  comprimento real,
  proa integer,
  velocidadenasuperficie real,
  velocidadenofundo real,
  id bigint NOT NULL,
  CONSTRAINT embarcacao_pkey PRIMARY KEY (id),
  CONSTRAINT fk_ft8rmf7pssyp1p3q2iwuqh5bu FOREIGN KEY (id)
      REFERENCES estrutura (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE embarcacao
  OWNER TO postgres;
-- Table: embarcacao

-- DROP TABLE embarcacao;

CREATE TABLE embarcacao
(
  boca real,
  comprimento real,
  proa integer,
  velocidadenasuperficie real,
  velocidadenofundo real,
  id bigint NOT NULL,
  CONSTRAINT embarcacao_pkey PRIMARY KEY (id),
  CONSTRAINT fk_ft8rmf7pssyp1p3q2iwuqh5bu FOREIGN KEY (id)
      REFERENCES estrutura (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE embarcacao
  OWNER TO postgres;
-- Table: estado

-- DROP TABLE estado;

CREATE TABLE estado
(
  id bigint NOT NULL,
  nome character varying(32) NOT NULL,
  uf character varying(16) NOT NULL,
  idpais bigint,
  CONSTRAINT estado_pkey PRIMARY KEY (id),
  CONSTRAINT fk_5v9jxy6136uo141i3j8lfufur FOREIGN KEY (idpais)
      REFERENCES pais (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE estado
  OWNER TO postgres;
-- Table: estrutura

-- DROP TABLE estrutura;

CREATE TABLE estrutura
(
  tipo character varying(31) NOT NULL,
  id bigint NOT NULL,
  altitude real,
  altura real NOT NULL,
  anterior bytea,
  calado real NOT NULL,
  circulodegiro real,
  cor character varying(7) NOT NULL,
  materialdeconstrucao character varying(16) NOT NULL,
  nome character varying(16) NOT NULL,
  numero character varying(16),
  placadevisibilidade boolean NOT NULL,
  posterior bytea,
  refletorradar boolean NOT NULL,
  visivelmenteconspicuo boolean NOT NULL,
  idformato bigint,
  idradar bigint,
  CONSTRAINT estrutura_pkey PRIMARY KEY (id),
  CONSTRAINT fk_l05k4xcsa287tv7mgxjcngw4l FOREIGN KEY (idradar)
      REFERENCES radar (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_rr0g3bbcohrna9etd30gutbji FOREIGN KEY (idformato)
      REFERENCES formato (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE estrutura
  OWNER TO postgres;
-- Table: farol

-- DROP TABLE farol;

CREATE TABLE farol
(
  descricao character varying(64),
  guarnecido boolean NOT NULL,
  numerointernacional real,
  id bigint NOT NULL,
  CONSTRAINT farol_pkey PRIMARY KEY (id),
  CONSTRAINT fk_dnw94vfdyrughdqs8200rf9lm FOREIGN KEY (id)
      REFERENCES instalacao (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE farol
  OWNER TO postgres;
-- Table: folheto

-- DROP TABLE folheto;

CREATE TABLE folheto
(
  id real NOT NULL,
  fim date,
  inicio date,
  numero real NOT NULL,
  CONSTRAINT folheto_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE folheto
  OWNER TO postgres;
-- Table: formato

-- DROP TABLE formato;

CREATE TABLE formato
(
  id bigint NOT NULL,
  nome character varying(16) NOT NULL,
  CONSTRAINT formato_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE formato
  OWNER TO postgres;
-- Table: instalacao

-- DROP TABLE instalacao;

CREATE TABLE instalacao
(
  numerodeordem real NOT NULL,
  id bigint NOT NULL,
  idmantenedor bigint,
  CONSTRAINT instalacao_pkey PRIMARY KEY (id),
  CONSTRAINT fk_94rr8rtwlt4gr3kd3jetll3lp FOREIGN KEY (id)
      REFERENCES estrutura (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_i0e2wbc12r2kieg5tqcmd4eap FOREIGN KEY (idmantenedor)
      REFERENCES mantenedor (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE instalacao
  OWNER TO postgres;
-- Table: luz

-- DROP TABLE luz;

CREATE TABLE luz
(
  id bigint NOT NULL,
  alcancegeografico real,
  alcancenominal bigint NOT NULL,
  altura real,
  ancanceluminoso bigint NOT NULL,
  intensidade bigint NOT NULL,
  setorfim bigint NOT NULL,
  setorinicio bigint NOT NULL,
  CONSTRAINT luz_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE luz
  OWNER TO postgres;
-- Table: mantenedor

-- DROP TABLE mantenedor;

CREATE TABLE mantenedor
(
  id bigint NOT NULL,
  nome character varying(16) NOT NULL,
  CONSTRAINT mantenedor_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mantenedor
  OWNER TO postgres;
-- Table: marca

-- DROP TABLE marca;

CREATE TABLE marca
(
  id bigint NOT NULL,
  cor character varying(7),
  formato character varying(16) NOT NULL,
  sentido boolean NOT NULL,
  CONSTRAINT marca_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE marca
  OWNER TO postgres;
-- Table: mastro

-- DROP TABLE mastro;

CREATE TABLE mastro
(
  id bigint NOT NULL,
  nome character varying(16),
  idestrutura bigint,
  idluz bigint,
  idtope bigint,
  CONSTRAINT mastro_pkey PRIMARY KEY (id),
  CONSTRAINT fk_34usd6d38jkfngwhuix178yew FOREIGN KEY (idluz)
      REFERENCES luz (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_i6hegkxxgf40ydaneojafu27q FOREIGN KEY (idtope)
      REFERENCES tope (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_iwpiqo821dkh5lvhpilfbin9q FOREIGN KEY (idestrutura)
      REFERENCES estrutura (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_mq9p95cbtv9eb07o5pmeka4te FOREIGN KEY (id)
      REFERENCES estrutura (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mastro
  OWNER TO postgres;
-- Table: pais

-- DROP TABLE pais;

CREATE TABLE pais
(
  id bigint NOT NULL,
  nome character varying(32),
  numerointernacional character varying(16),
  idarea bigint,
  CONSTRAINT pais_pkey PRIMARY KEY (id),
  CONSTRAINT fk_oh15wl0ge8nqxpjd9txph01jc FOREIGN KEY (idarea)
      REFERENCES area (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_5a31x29qme0ctihxk0lsx1819 UNIQUE (nome),
  CONSTRAINT uk_8ydmjp0vhyr2980vqvhul1rai UNIQUE (numerointernacional)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE pais
  OWNER TO postgres;
-- Table: radar

-- DROP TABLE radar;

CREATE TABLE radar
(
  id bigint NOT NULL,
  morse character varying(16) NOT NULL,
  idestrutura bigint,
  CONSTRAINT radar_pkey PRIMARY KEY (id),
  CONSTRAINT fk_i5t71y97ked656i5cfe0b3f0d FOREIGN KEY (idestrutura)
      REFERENCES estrutura (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE radar
  OWNER TO postgres;
-- Table: ritmo

-- DROP TABLE ritmo;

CREATE TABLE ritmo
(
  id bigint NOT NULL,
  cor character varying(7) NOT NULL,
  duracao real,
  idluz bigint,
  CONSTRAINT ritmo_pkey PRIMARY KEY (id),
  CONSTRAINT fk_963xxxr3js386wm3kvsd3ppt5 FOREIGN KEY (id)
      REFERENCES luz (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_l7m9cmjr0c5x0ad5hwb6fg8nx FOREIGN KEY (idluz)
      REFERENCES luz (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ritmo
  OWNER TO postgres;
-- Table: tope

-- DROP TABLE tope;

CREATE TABLE tope
(
  id bigint NOT NULL,
  funcao character varying(32) NOT NULL,
  CONSTRAINT tope_pkey PRIMARY KEY (id),
  CONSTRAINT uk_36dohxhtghoqblkpbtm26cyjw UNIQUE (funcao)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tope
  OWNER TO postgres;
-- Table: tope_marca

-- DROP TABLE tope_marca;

CREATE TABLE tope_marca
(
  idtope bigint NOT NULL,
  idmarca bigint NOT NULL,
  CONSTRAINT fk_2gdnsc51y1imagva1ug872crl FOREIGN KEY (idtope)
      REFERENCES tope (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_cso9jwa2i80kxf3h2mn13y1e5 FOREIGN KEY (idmarca)
      REFERENCES marca (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tope_marca
  OWNER TO postgres;
-- Table: usuario

-- DROP TABLE usuario;

CREATE TABLE usuario
(
  email character varying(32) NOT NULL,
  senha character varying(16) NOT NULL,
  CONSTRAINT usuario_pkey PRIMARY KEY (email)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE usuario
  OWNER TO postgres;

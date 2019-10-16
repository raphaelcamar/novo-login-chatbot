-- DDL das novas tabelas do AM
DROP TABLE DESCRICAO;
DROP TABLE MATERIA;
DROP TABLE CAPITULO;
DROP TABLE DISCIPLINA;

CREATE TABLE DISCIPLINA(
    ID_DISCIPLINA INTEGER PRIMARY KEY,
    NOME VARCHAR2(10),
    CONTADOR_DE_ACESSO INTEGER);

CREATE TABLE CAPITULO(
    ID_CAPITULO INTEGER PRIMARY KEY,
    NUMERO_CAPITULO INTEGER);

CREATE TABLE MATERIA(
    ID_MATERIA INTEGER PRIMARY KEY,
    ID_DISCIPLINA INTEGER REFERENCES DISCIPLINA(ID_DISCIPLINA),
    ID_CAPITULO INTEGER REFERENCES CAPITULO(ID_CAPITULO),
    CONTADOR_DE_ACESSO INTEGER);
    
CREATE TABLE DESCRICAO(
    ID_DESCRICAO INTEGER PRIMARY KEY,
    ID_MATERIA INTEGER REFERENCES MATERIA(ID_MATERIA),
    DESCRICAO VARCHAR2(255));
SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS cursan;
DROP TABLE IF EXISTS hacen;
DROP TABLE IF EXISTS realizan;
DROP TABLE IF EXISTS alumnos;
DROP TABLE IF EXISTS asignaturas;
DROP TABLE IF EXISTS elaboran;
DROP TABLE IF EXISTS examenes;
DROP TABLE IF EXISTS practicas;
DROP TABLE IF EXISTS profesores;




/* Create Tables */

CREATE TABLE alumnos
(
	num_alu int NOT NULL AUTO_INCREMENT,
	nombre varchar(255),
	grupo varchar(255),
	PRIMARY KEY (num_alu)
);


CREATE TABLE asignaturas
(
	num_asi int NOT NULL,
	nombre varchar(255),
	num_prof int NOT NULL,
	PRIMARY KEY (num_asi)
);


CREATE TABLE cursan
(
	num_alu int NOT NULL,
	num_asi int NOT NULL,
	trimestre int
);


CREATE TABLE elaboran
(
	cod_practica int NOT NULL,
	num_prof int NOT NULL,
	fecha date
);


CREATE TABLE examenes
(
	num_exa int NOT NULL AUTO_INCREMENT,
	npreguntas int,
	fecha date,
	PRIMARY KEY (num_exa)
);


CREATE TABLE hacen
(
	num_alu int NOT NULL,
	num_exa int NOT NULL,
	nota int
);


CREATE TABLE practicas
(
	cod_practica int NOT NULL AUTO_INCREMENT,
	titulo varchar(255),
	nivel int,
	PRIMARY KEY (cod_practica)
);


CREATE TABLE profesores
(
	num_prof int NOT NULL AUTO_INCREMENT,
	nombre varchar(255),
	PRIMARY KEY (num_prof)
);


CREATE TABLE realizan
(
	num_alu int NOT NULL,
	cod_practica int NOT NULL,
	nota int,
	fecha date
);



/* Create Foreign Keys */

ALTER TABLE cursan
	ADD FOREIGN KEY (num_alu)
	REFERENCES alumnos (num_alu)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE hacen
	ADD FOREIGN KEY (num_alu)
	REFERENCES alumnos (num_alu)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE realizan
	ADD FOREIGN KEY (num_alu)
	REFERENCES alumnos (num_alu)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cursan
	ADD FOREIGN KEY (num_asi)
	REFERENCES asignaturas (num_asi)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE hacen
	ADD FOREIGN KEY (num_exa)
	REFERENCES examenes (num_exa)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE elaboran
	ADD FOREIGN KEY (cod_practica)
	REFERENCES practicas (cod_practica)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE realizan
	ADD FOREIGN KEY (cod_practica)
	REFERENCES practicas (cod_practica)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE asignaturas
	ADD FOREIGN KEY (num_prof)
	REFERENCES profesores (num_prof)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE elaboran
	ADD FOREIGN KEY (num_prof)
	REFERENCES profesores (num_prof)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;




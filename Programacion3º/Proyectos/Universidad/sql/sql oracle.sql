-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 13-13-2013 a las 13:13:13
-- Versión del servidor: 5.0.51
-- Versión de PHP: 5.2.6

/* SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO"; */

-- 
-- Base de datos: 'db_programacion'
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla 'materia'
-- 

CREATE TABLE materia (
  m_sigla char(7) NOT NULL,
  m_nombre varchar2(60) NOT NULL,
  m_curso number(10) NOT NULL,
  m_tipo char(12) NOT NULL,
  PRIMARY KEY  (m_sigla)
) ;

-- 
-- Volcar la base de datos para la tabla 'materia'
-- 

INSERT INTO materia VALUES ('SIS-420', 'Inteligencia Artificial', 3, 'Obligatorio');
INSERT INTO materia VALUES ('SIS-120', 'Programacion en Ensamblador', 6, 'Opcional');
INSERT INTO materia VALUES ('SIS-360', 'Diseño de Algoritmos', 5, 'Opcional');
INSERT INTO materia VALUES ('IND-234', 'Gestión de Proyectos', 8, 'Opcional');
INSERT INTO materia VALUES ('SIS-100', 'Introducción a la Computación', 9, 'Obligatorio');
INSERT INTO materia VALUES ('MAT-400', 'Cálculo IV', 5, 'Obligatorio');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla 'matricula'
-- 

CREATE TABLE matricula (
  m_ID varchar2(9) NOT NULL,
  m_gestion varchar2(5) default '00/00' NOT NULL,
  m_fecha timestamp(0) NOT NULL,
  PRIMARY KEY  (m_ID)
) ;

-- 
-- Volcar la base de datos para la tabla 'matricula'
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla 'programacion'
-- 

CREATE TABLE programacion (
  p_matricula varchar2(9) NOT NULL,
  p_univ char(7) default NULL,
  p_materia char(36) default NULL,
  p_grupo varchar2(4) default '-' NOT NULL,
  p_sigla char(7) NOT NULL,
  p_tipo char(12) NOT NULL,
  p_curso number(2) NOT NULL
) 

CREATE INDEX p_univ ON programacion (p_univ);
CREATE INDEX p_materia ON programacion (p_materia);

-- 
-- Volcar la base de datos para la tabla 'programacion'
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla 'universitario'
-- 

CREATE TABLE universitario (
  u_cu char(7) NOT NULL,
  u_ci char(7) NOT NULL,
  u_nombre varchar2(100) NOT NULL,
  u_password varchar2(100) NOT NULL,
  PRIMARY KEY  (u_cu)
) 

-- 
-- Volcar la base de datos para la tabla 'universitario'
-- 

INSERT INTO universitario VALUES ('35-3535', '1234567', 'Ana Lisa Meltrozo');
INSERT INTO universitario VALUES ('35-3536', '1234567', 'Dolores Debolas');
INSERT INTO universitario VALUES ('35-1234', '1234567', 'Elvis Cochuelo');
INSERT INTO universitario VALUES ('35-4321', '1234567', 'Kevin Chuca Minovia');
INSERT INTO universitario VALUES ('35-2255', '1234567', 'Susana Horia Legusta');




--CONSULTAS Y EJECUCIONES DE INTERES
insert into matricula values('35-2255','19/05','19/05/16');

INSERT INTO programacion VALUES('35-1111',null,'Cien','2','SX411','opcional',5)
INSERT INTO programacion VALUES('35-1111',null,'Cien','2','SX-411','Opcional',5)
delete from programacion where p_matricula ='35-1111'


select p_matricula,p_materia,p_grupo,p_sigla,p_tipo,p_curso from programacion where p_matricula ='35-7878'
delete from programacion where p_matricula='35-7878'
select * from matricula
INSERT INTO matricula VALUES('35-7878','22/5','22/5/2016')
delete from matricula where m_id='35-7878'
select * from universitario
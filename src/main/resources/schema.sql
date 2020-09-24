DROP ALL OBJECTS;

DROP TABLE IF EXISTS CAT_ROLES;

CREATE TABLE `CAT_ROLES` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL
);

ALTER TABLE CAT_ROLES ADD CONSTRAINT CAT_ROLES_UNIQUE
UNIQUE (nombre);

CREATE TABLE `USUARIOS` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `estatus` tinyint(1) NOT NULL DEFAULT '0',
  `tipo_usuario` varchar(20),
  `fecha_creacion` timestamp,
  `fecha_actualizacion` timestamp
);
ALTER TABLE USUARIOS ADD CONSTRAINT USUARIOS_UNIQUE
UNIQUE (email);

CREATE TABLE `USER_ROLES` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL
);

ALTER TABLE USER_ROLES ADD CONSTRAINT USER_ROLES_UNIQUE
UNIQUE (id_usuario,id_rol);  

CREATE TABLE `PRESTAMO` (
  `id_prestamo` int(11) NOT NULL AUTO_INCREMENT,
  `id_deudor` int(11) NOT NULL,
  `estatus` tinyint(1) NOT NULL DEFAULT '0',
  `monto` decimal(10,2) NOT NULL,
  `fecha_terminacion` timestamp NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

CREATE TABLE `DATOS_USER` (
  `id_datos_user` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `tipo_dato` varchar(50) NOT NULL,
  `dato` varchar(100) NOT NULL DEFAULT '0',
  `relevancia` tinyint(1) NOT NULL DEFAULT '0',
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

ALTER TABLE DATOS_USER ADD CONSTRAINT DATOS_USER_ROLES_UNIQUE
UNIQUE(id_usuario,tipo_dato);  


CREATE TABLE `SOLICITUDES` (
  `id_solicitud` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `tipo_solicitud` varchar(50) NOT NULL DEFAULT '0',
  `estatus` varchar(200) NOT NULL,
  `estatus_detalle` varchar(200),
  `fecha_ejecucion` timestamp NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);


CREATE TABLE `ATRIBUTOS_SOLICITUD` (
  `id_atributo` int(11) NOT NULL AUTO_INCREMENT,
  `id_solicitud` int(11) NOT NULL,
  `tipo_atributo` varchar(50) NOT NULL DEFAULT '0',
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `valor` varchar(100) NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

ALTER TABLE ATRIBUTOS_SOLICITUD ADD CONSTRAINT ATRIBUTOS_SOLICITUD_UNIQUE
UNIQUE(id_solicitud,tipo_atributo,nombre);  


CREATE TABLE `VALIDACIONES` (
  `id_validacion` int(11) NOT NULL AUTO_INCREMENT,
  `id_solicitud` int(11) NOT NULL,
  `numero_validacion` int(3) NOT NULL DEFAULT '0',
  `email` varchar(100) NOT NULL,
  `area` varchar(50) NOT NULL,
  `estatus` tinyint(1) NOT NULL DEFAULT '0',
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

ALTER TABLE VALIDACIONES ADD CONSTRAINT VALIDACIONES_UNIQUE
UNIQUE(id_solicitud,numero_validacion);  

CREATE TABLE `CAT_PROPIEDADES` (
  `id_atributo` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `valor` varchar(100) NOT NULL
);

CREATE TABLE `SALDO_AHORRO` (
  `id_ahorro` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `validado` tinyint(1) NOT NULL DEFAULT '0',
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);


CREATE TABLE `SALDO_PRESTAMO` (
  `id_saldo_prestamo` int(11) NOT NULL AUTO_INCREMENT,
  `id_prestamo` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `validado` tinyint(1) NOT NULL DEFAULT '0',
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

CREATE TABLE `RECURSOS` (
  `id_recurso` int(11) NOT NULL AUTO_INCREMENT,
  `referencia` varchar(45) NOT NULL,
  `tipo_archivo` varchar(32) NOT NULL,
  `tipo_recurso` varchar(32) NOT NULL,
  `dato` blob(45) NOT NULL,
  `fecha_creacion` timestamp NOT NULL
);

ALTER TABLE RECURSOS ADD CONSTRAINT RECURSOS_UNIQUE
UNIQUE(referencia,tipo_archivo,tipo_recurso);  

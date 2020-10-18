DROP TABLE cat_roles;
DROP TABLE usuarios;
DROP TABLE user_roles;
DROP TABLE prestamo;
DROP TABLE datos_user;
DROP TABLE solicitudes;
DROP TABLE atributos_solicitud;
DROP TABLE validaciones;
DROP TABLE cat_propiedades;
DROP TABLE saldo_ahorro;
DROP TABLE saldo_prestamo;
DROP TABLE recursos;


CREATE TABLE IF NOT EXISTS `cat_roles` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  `nombre` varchar(45) NOT NULL UNIQUE
);


CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL UNIQUE,
  `estatus` tinyint(1) NOT NULL DEFAULT '0',
  `no_empleado` varchar(15),
  `tipo_usuario` varchar(20),
  `fecha_creacion` timestamp,
  `fecha_actualizacion` timestamp
);

CREATE TABLE IF NOT EXISTS `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  `id_usuario` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL
);

ALTER TABLE user_roles ADD CONSTRAINT USER_ROLES_UNIQUE
UNIQUE (id_usuario,id_rol);  

CREATE TABLE IF NOT EXISTS `prestamo` (
  `id_prestamo` int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  `id_deudor` int(11) NOT NULL,
  `estatus` tinyint(1) NOT NULL DEFAULT '0',
  `monto` decimal(10,2) NOT NULL,
  `fecha_terminacion` timestamp NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS `datos_user` (
  `id_datos_user` int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  `id_usuario` int(11) NOT NULL,
  `tipo_dato` varchar(50) NOT NULL,
  `dato` varchar(100) NOT NULL DEFAULT '0',
  `relevancia` tinyint(1) NOT NULL DEFAULT '0',
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

ALTER TABLE datos_user ADD CONSTRAINT DATOS_USER_ROLES_UNIQUE
UNIQUE(id_usuario,tipo_dato);  


CREATE TABLE IF NOT EXISTS `solicitudes` (
  `id_solicitud` int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  `id_usuario` int(11) NOT NULL,
  `tipo_solicitud` varchar(50) NOT NULL DEFAULT '0',
  `estatus` varchar(200) NOT NULL,
  `estatus_detalle` varchar(200),
  `fecha_ejecucion` timestamp NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);


CREATE TABLE IF NOT EXISTS `atributos_solicitud` (
  `id_atributo` int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  `id_solicitud` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `valor` varchar(100) NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

ALTER TABLE atributos_solicitud ADD CONSTRAINT ATRIBUTOS_SOLICITUD_UNIQUE
UNIQUE(id_solicitud,nombre);  


CREATE TABLE IF NOT EXISTS `validaciones` (
  `id_validacion` int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  `id_solicitud` int(11) NOT NULL,
  `numero_validacion` int(3) NOT NULL DEFAULT '0',
  `email` varchar(100) NOT NULL,
  `area` varchar(50) NOT NULL,
  `estatus` tinyint(1) NOT NULL DEFAULT '0',
  `estatus_desc` varchar(200),
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

ALTER TABLE validaciones ADD CONSTRAINT VALIDACIONES_UNIQUE
UNIQUE(id_solicitud,numero_validacion);  

CREATE TABLE IF NOT EXISTS `cat_propiedades` (
  `id_atributo` int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  `tipo` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `valor` varchar(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS `saldo_ahorro` (
  `id_ahorro` int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  `id_usuario` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `validado` tinyint(1) NOT NULL DEFAULT '0',
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);


CREATE TABLE IF NOT EXISTS `saldo_prestamo` (
  `id_saldo_prestamo` int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  `id_prestamo` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `validado` tinyint(1) NOT NULL DEFAULT '0',
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS `recursos` (
  `id_recurso` int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  `referencia` varchar(45) NOT NULL,
  `tipo_archivo` varchar(32) NOT NULL,
  `tipo_recurso` varchar(32) NOT NULL,
  `dato` blob(45) NOT NULL,
  `fecha_creacion` timestamp NOT NULL
);

ALTER TABLE recursos ADD CONSTRAINT RECURSOS_UNIQUE
UNIQUE(referencia,tipo_archivo,tipo_recurso);  

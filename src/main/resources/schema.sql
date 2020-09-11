DROP ALL OBJECTS;

DROP TABLE IF EXISTS CAT_ROLES;

CREATE TABLE `CAT_ROLES` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL
);

CREATE TABLE `USER_ROLES` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL
);

CREATE TABLE `USUARIOS` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `estatus` tinyint(1) NOT NULL DEFAULT '0',
  `tipo_usuario` varchar(20),
  `fecha_creacion` timestamp,
  `fecha_actualizacion` timestamp
);

CREATE TABLE `PRESTAMO` (
  `id_prestamo` int(11) NOT NULL AUTO_INCREMENT,
  `id_deudor` int(11) NOT NULL,
  `estatus` tinyint(1) NOT NULL DEFAULT '0',
  `monto` decimal(10,2) NOT NULL,
  `fecha_terminacion` timestamp NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

CREATE TABLE `AHORRADOR` (
  `id_ahorrador` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `monto_ahorro` decimal(10,2) NOT NULL,
  `porcentaje_ahorro` decimal(5,2)  NOT NULL,
  `antiguedad` timestamp NOT NULL,
  `sueldo` decimal(10,2) NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

CREATE TABLE `DEUDOR` (
  `id_deudor` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `antiguedad` timestamp NOT NULL,
  `sueldo` decimal(10,2) NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

CREATE TABLE `DATOS_USER` (
  `id_datos` int(11) NOT NULL,
  `tipo_dato` varchar(50) NOT NULL,
  `dato` varchar(100) NOT NULL DEFAULT '0',
  `relevancia` tinyint(1) NOT NULL DEFAULT '0',
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

CREATE TABLE `SOLICITUDES` (
  `id_solicitud` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `tipo_solicitud` tinyint(1) NOT NULL DEFAULT '0',
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `status_detalle` varchar(50) NOT NULL,
  `porcentaje` decimal(5,2)  NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `fecha_ejecucion` timestamp NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

CREATE TABLE `ATRIBUTOS_SOLICITUD` (
  `id_atributo` int(11) NOT NULL AUTO_INCREMENT,
  `id_solicitud` int(11) NOT NULL,
  `tipo_atributo` tinyint(1) NOT NULL DEFAULT '0',
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `valor` varchar(100) NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

CREATE TABLE `VALIDACIONES` (
  `id_validacion` int(11) NOT NULL AUTO_INCREMENT,
  `id_solicitud` int(11) NOT NULL,
  `numero_validacion` tinyint(1) NOT NULL DEFAULT '0',
  `id_usuario` int(11) NOT NULL,
  `estatus` tinyint(1) NOT NULL DEFAULT '0',
  `tipo_validacion` varchar(50) NOT NULL DEFAULT '0',
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

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

CREATE TABLE `RESOURSCES` (
  `id_recurso` int(11) NOT NULL AUTO_INCREMENT,
  `referencia` varchar(45) NOT NULL,
  `tipo_referencia` tinyint(1) NOT NULL DEFAULT '0',
  `documento` blob(45) NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);



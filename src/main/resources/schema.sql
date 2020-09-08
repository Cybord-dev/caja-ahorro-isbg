CREATE TABLE `CAT_ROLES` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL
);

CREATE TABLE `USER_ROLES` (
  `id_user` int(11) NOT NULL,
  `is_rol` int(11) NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);


CREATE TABLE `CAT_TIPO_CLIENTES` (
  `id_tipo_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombrre` varchar(45) NOT NULL
);

CREATE TABLE `DEPOSITOS` (
  `id_deposito` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `tipo_deposito` varchar(45) NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

CREATE TABLE `DEVOLUCIONES` (
  `id_devolucion` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `tipo_devolucion` varchar(45) NOT NULL,
  `user_val` varchar(45) NOT NULL,
  `monto` decimal(12,4) NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

CREATE TABLE `CLIENTES` (
  `id_cliente` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `Saldo` decimal(20,4) NOT NULL,
  `tipo_cliente` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `user_val_rh` varchar(45) DEFAULT NULL,
  `user_val_cont` varchar(45)  DEFAULT NULL,
  `ahorrador` tinyint(1) NOT NULL DEFAULT '0',
  `fecha_creacion` varchar(45) NOT NULL,
  `fecha_actualizacion` varchar(45) NOT NULL
);

CREATE TABLE `CAT_STATUS` (
  `id_status` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL
);

CREATE TABLE `USERS` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `nickname` varchar(45) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '0',
  `fecha_creacion` timestamp,
  `fecha_actualizacion` timestamp
);

CREATE TABLE `CONDICIONES_CLIENTE` (
  `id_cond` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `porcentaje` decimal(4,2) NOT NULL DEFAULT '0.00',
  `fecha_inicio` timestamp NOT NULL,
  `fecha_final` timestamp NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);

CREATE TABLE `PRESTAMOS` (
  `id_prestamo` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `user_aprobo` varchar(45) NOT NULL,
  `monto` decimal(12,4) NOT NULL,
  `saldo` decimal(12,4) NOT NULL,
  `status` decimal(12,4) NOT NULL,
  `interes` decimal(5,2) NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL
);
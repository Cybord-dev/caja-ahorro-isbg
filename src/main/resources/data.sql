INSERT INTO CAT_PROPIEDADES(id_atributo,tipo,nombre,valor) VALUES (1,'ESTADO','SOLICITUD','0');
INSERT INTO CAT_PROPIEDADES(id_atributo,tipo,nombre,valor) VALUES (2,'ESTADO','VALIDACION RH','1');
INSERT INTO CAT_PROPIEDADES(id_atributo,tipo,nombre,valor) VALUES (3,'ESTADO','VALIDACION CONTABILIDAD','2');

INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(1,'pablito','tqortas23@.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(2,'juanito','towrtas34@.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(3,'culochi','teset@test.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(4,'pablito','tortras23@.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(5,'juanito','tortyas34@.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(6,'culochi','tesit@test.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(7,'pablito','taortas23@.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(8,'juanito','tzortas34@.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(9,'culochi','txest@test.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(10,'pablito','tvortas23@.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(11,'juanito','tnmortas34@.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(12,'culochi','temst@test.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(13,'pablito','tohrtas23@.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(14,'juanito','torttas34@.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(15,'culochi','te5st@test.com',1,'INTERNO');

INSERT INTO SOLICITUDES(id_solicitud,id_usuario, tipo_solicitud, estatus, estatus_detalle, porcentaje, cantidad, fecha_ejecucion, fecha_creacion, fecha_actualizacion) 
VALUES(1, 1, 1,1,'SOLICITUD_AHORRO', 10.10, 1500.00, '2020-09-12 00:00:00','2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO SOLICITUDES(id_solicitud,id_usuario, tipo_solicitud, estatus, estatus_detalle, porcentaje, cantidad, fecha_ejecucion, fecha_creacion, fecha_actualizacion) 
VALUES(2, 2, 1,0,'SOLICITUD_AHORRO', 10.10, 1500.00, '2020-09-20 19:00:00','2020-09-20 00:00:00','2020-09-12 00:00:00');

INSERT INTO SOLICITUDES(id_solicitud,id_usuario, tipo_solicitud, estatus, estatus_detalle, porcentaje, cantidad, fecha_ejecucion, fecha_creacion, fecha_actualizacion) 
VALUES(3, 3, 1,0,'SOLICITUD_AHORRO', 10.10, 1500.00, '2020-09-19 12:00:00','2020-09-19 00:00:00','2020-09-12 00:00:00');

INSERT INTO ATRIBUTOS_SOLICITUD(id_atributo,id_solicitud,tipo_atributo,nombre,valor,fecha_creacion,fecha_actualizacion) VALUES (1,1,1,'PORCENTAJE_AHORRO','10.5','2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO ATRIBUTOS_SOLICITUD(id_atributo,id_solicitud,tipo_atributo,nombre,valor,fecha_creacion,fecha_actualizacion) VALUES (2,1,2,'FECHA_INGRESO','2020-09-12 00:00:00','2020-09-12 01:00:00','2020-09-12 01:00:00');

INSERT INTO VALIDACIONES(id_validacion,id_solicitud,numero_validacion,email,estatus,area,fecha_creacion,fecha_actualizacion) VALUES (1,1,1,'pepe@gmail.com',1,'RH','2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO VALIDACIONES(id_validacion,id_solicitud,numero_validacion,email,estatus,area,fecha_creacion,fecha_actualizacion) VALUES (2,1,2,'papirriin@gmail.com',0,'TESO','2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO DATOS_USER(id_datos_user,id_usuario,tipo_dato,dato,relevancia,fecha_creacion,fecha_actualizacion) VALUES (2,3,'MONTO_AHORRO','221.44',1,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO DATOS_USER(id_datos_user,id_usuario,tipo_dato,dato,relevancia,fecha_creacion,fecha_actualizacion) VALUES (3,3,'ANTIGUEDAD','2020-02-12 00:00:00',1,'2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO CAT_ROLES(id_role,nombre) VALUES (1,'ADMINISTRADOR');
INSERT INTO CAT_ROLES(id_role,nombre) VALUES (2,'SOPORTE');
INSERT INTO CAT_ROLES(id_role,nombre) VALUES (3,'TESORERIA');
INSERT INTO CAT_ROLES(id_role,nombre) VALUES (4,'CONTABILIDAD');
INSERT INTO CAT_ROLES(id_role,nombre) VALUES (5,'RECURSOS-HUMANOS');
INSERT INTO CAT_ROLES(id_role,nombre) VALUES (6,'USUARIO');

INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (1,3,1);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (2,3,2);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (3,3,6);

INSERT INTO SALDO_AHORRO(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (1,1,'tipo',22.54,1,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO SALDO_AHORRO(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (2,1,'tipo',93.23,1,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO SALDO_AHORRO(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (3,1,'tipo',43.13,1,'2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO PRESTAMO(id_prestamo,id_deudor,estatus,monto,fecha_terminacion,fecha_creacion,fecha_actualizacion) VALUES (1,3,1,13.13,'2020-09-12 00:00:00','2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO PRESTAMO(id_prestamo,id_deudor,estatus,monto,fecha_terminacion,fecha_creacion,fecha_actualizacion) VALUES (2,2,1,23.13,'2020-09-12 00:00:00','2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO PRESTAMO(id_prestamo,id_deudor,estatus,monto,fecha_terminacion,fecha_creacion,fecha_actualizacion) VALUES (3,3,0,53.13,'2020-09-12 00:00:00','2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO SALDO_PRESTAMO(id_saldo_prestamo,id_prestamo,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (1,1,'TIPO',13.13,1,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO SALDO_PRESTAMO(id_saldo_prestamo,id_prestamo,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (2,2,'TIPO',23.13,0,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO SALDO_PRESTAMO(id_saldo_prestamo,id_prestamo,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (3,3,'TIPO',53.13,0,'2020-09-12 00:00:00','2020-09-12 00:00:00');


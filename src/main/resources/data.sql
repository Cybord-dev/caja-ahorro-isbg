INSERT INTO CAT_PROPIEDADES(id_atributo,tipo,nombre,valor) VALUES (1,'ESTADO','SOLICITUD','0');
INSERT INTO CAT_PROPIEDADES(id_atributo,tipo,nombre,valor) VALUES (2,'ESTADO','VALIDACION RH','1');
INSERT INTO CAT_PROPIEDADES(id_atributo,tipo,nombre,valor) VALUES (3,'ESTADO','VALIDACION CONTABILIDAD','2');

INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(1,'Jose Miguel Ramirez Valerio','tortas23@.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(2,'Luis Mario Rodriguez Hernandez','tortas34@.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(3,'Mario de la Olla Alvarez','test@test.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(4,'Lluvia de Jade Zubillaga','lluvia@test.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(5,'Ruben Alvarez Morales','rubens.mncrft@gmail.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(6,'Eddy Gomez Rosales','edcgamer@gmail.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(7,'Eddieson Cortes','eddietiend@gmail.com',1,'INTERNO');

INSERT INTO SOLICITUDES(id_solicitud,id_usuario, tipo_solicitud, estatus, estatus_detalle, fecha_ejecucion, fecha_creacion, fecha_actualizacion) 
VALUES(1, 1,'SolicitudAhorro','ValdiacionConta',null, '2020-09-12 00:00:00','2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO SOLICITUDES(id_solicitud,id_usuario, tipo_solicitud, estatus, estatus_detalle, fecha_ejecucion, fecha_creacion, fecha_actualizacion) 
VALUES(2, 2,'SolicitudAhorro','ValdiacionConta',null, '2020-09-12 00:00:00','2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO SOLICITUDES(id_solicitud,id_usuario, tipo_solicitud, estatus, estatus_detalle, fecha_ejecucion, fecha_creacion, fecha_actualizacion) 
VALUES(3, 3,'SolicitudAhorro','ValdiacionConta',null,'2020-09-19 12:00:00','2020-09-19 00:00:00','2020-09-12 00:00:00');

INSERT INTO ATRIBUTOS_SOLICITUD(id_atributo,id_solicitud,tipo_atributo,nombre,valor,fecha_creacion,fecha_actualizacion) VALUES (1,1,1,'PORCENTAJE_AHORRO','10.5','2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO ATRIBUTOS_SOLICITUD(id_atributo,id_solicitud,tipo_atributo,nombre,valor,fecha_creacion,fecha_actualizacion) VALUES (2,1,2,'FECHA_INGRESO','2020-09-12 00:00:00','2020-09-12 01:00:00','2020-09-12 01:00:00');

INSERT INTO VALIDACIONES(id_validacion,id_solicitud,numero_validacion,email,estatus,area,fecha_creacion,fecha_actualizacion) VALUES (1,1,1,'pepe@gmail.com',1,'RecursosHumanos','2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO VALIDACIONES(id_validacion,id_solicitud,numero_validacion,email,estatus,area,fecha_creacion,fecha_actualizacion) VALUES (2,2,1,'papirriin@gmail.com',0,'Tesoreria','2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO DATOS_USER(id_datos_user,id_usuario,tipo_dato,dato,relevancia,fecha_creacion,fecha_actualizacion) VALUES (1,5,'MONTO_AHORRO','221.44',1,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO DATOS_USER(id_datos_user,id_usuario,tipo_dato,dato,relevancia,fecha_creacion,fecha_actualizacion) VALUES (2,5,'ANTIGUEDAD','2020-02-12 00:00:00',1,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO DATOS_USER(id_datos_user,id_usuario,tipo_dato,dato,relevancia,fecha_creacion,fecha_actualizacion) VALUES (3,5,'SUELDO','4221.44',1,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO DATOS_USER(id_datos_user,id_usuario,tipo_dato,dato,relevancia,fecha_creacion,fecha_actualizacion) VALUES (4,5,'NO_EMPLEADO','00345678',1,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO DATOS_USER(id_datos_user,id_usuario,tipo_dato,dato,relevancia,fecha_creacion,fecha_actualizacion) VALUES (5,5,'OFICINA','Oficina 4',1,'2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO CAT_ROLES(id_rol,nombre) VALUES (1,'USUARIO');
INSERT INTO CAT_ROLES(id_rol,nombre) VALUES (2,'RECURSOS_HUMANOS');
INSERT INTO CAT_ROLES(id_rol,nombre) VALUES (3,'TESORERIA');
INSERT INTO CAT_ROLES(id_rol,nombre) VALUES (4,'CONTABILIDAD');
INSERT INTO CAT_ROLES(id_rol,nombre) VALUES (5,'GERENCIA');
INSERT INTO CAT_ROLES(id_rol,nombre) VALUES (6,'ADMINISTRACION');

INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (1,1,1);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (2,1,2);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (3,1,3);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (4,2,1);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (5,2,2);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (6,2,3);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (7,2,4);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (8,3,1);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (9,3,2);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (10,5,1);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (11,5,2);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (12,5,3);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (13,5,4);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (14,5,5);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (15,5,6);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (16,7,1);
INSERT INTO USER_ROLES(id,id_usuario,id_rol) VALUES (17,7,2);

INSERT INTO SALDO_AHORRO(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (1,1,'tipo',22.54,1,'2020-07-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO SALDO_AHORRO(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (2,1,'tipo',93.23,1,'2020-08-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO SALDO_AHORRO(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (3,1,'tipo',43.13,1,'2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO PRESTAMO(id_prestamo,id_deudor,estatus,monto,fecha_terminacion,fecha_creacion,fecha_actualizacion) VALUES (1,3,1,13.13,'2020-09-12 00:00:00','2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO PRESTAMO(id_prestamo,id_deudor,estatus,monto,fecha_terminacion,fecha_creacion,fecha_actualizacion) VALUES (2,2,1,23.13,'2020-09-12 00:00:00','2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO PRESTAMO(id_prestamo,id_deudor,estatus,monto,fecha_terminacion,fecha_creacion,fecha_actualizacion) VALUES (3,3,0,53.13,'2020-09-12 00:00:00','2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO SALDO_PRESTAMO(id_saldo_prestamo,id_prestamo,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (1,1,'TIPO',13.13,1,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO SALDO_PRESTAMO(id_saldo_prestamo,id_prestamo,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (2,2,'TIPO',23.13,0,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO SALDO_PRESTAMO(id_saldo_prestamo,id_prestamo,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (3,3,'TIPO',53.13,0,'2020-09-12 00:00:00','2020-09-12 00:00:00');


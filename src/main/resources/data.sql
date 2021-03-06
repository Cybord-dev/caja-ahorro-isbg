INSERT INTO cat_propiedades(id_atributo,tipo,nombre,valor) VALUES (1,'ESTADO','SOLICITUD','0');
INSERT INTO cat_propiedades(id_atributo,tipo,nombre,valor) VALUES (2,'ESTADO','VALIDACION RH','1');
INSERT INTO cat_propiedades(id_atributo,tipo,nombre,valor) VALUES (3,'ESTADO','VALIDACION CONTABILIDAD','2');

INSERT INTO usuarios(id_usuario,no_empleado,nombre,email,estatus,tipo_usuario) VALUES(1,'1','Edgar Payaso Morales','edanpicon34567@gmail.com',1,'INTERNO');
INSERT INTO usuarios(id_usuario,no_empleado,nombre,email,estatus,tipo_usuario) VALUES(2,'2','Luis Mario Rodriguez Hernandez','tortas34@.com',1,'INTERNO');
INSERT INTO usuarios(id_usuario,no_empleado,nombre,email,estatus,tipo_usuario) VALUES(3,'3','Mario de la Olla Alvarez','test@test.com',1,'INTERNO');
INSERT INTO usuarios(id_usuario,no_empleado,nombre,email,estatus,tipo_usuario) VALUES(4,'4','Lluvia de Jade Zubillaga','lluvia@test.com',1,'INTERNO');
INSERT INTO usuarios(id_usuario,no_empleado,nombre,email,estatus,tipo_usuario) VALUES(5,'5','Ruben Alvarez Morales','rubens.mncrft@gmail.com',1,'INTERNO');
INSERT INTO usuarios(id_usuario,no_empleado,nombre,email,estatus,tipo_usuario) VALUES(6,'6','Eddy Gomez Rosales','edcgamer@gmail.com',1,'INTERNO');
INSERT INTO usuarios(id_usuario,no_empleado,nombre,email,estatus,tipo_usuario) VALUES(7,'7','Eddieson Cortes','eddietiend@gmail.com',1,'INTERNO');

INSERT INTO solicitudes(id_solicitud,id_usuario, tipo_solicitud, estatus, estatus_detalle, fecha_ejecucion, fecha_creacion, fecha_actualizacion) 
VALUES(1, 1,'SolicitudAhorro','ValdiacionConta',null, '2020-09-12 00:00:00','2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO solicitudes(id_solicitud,id_usuario, tipo_solicitud, estatus, estatus_detalle, fecha_ejecucion, fecha_creacion, fecha_actualizacion) 
VALUES(2, 2,'SolicitudAhorro','ValdiacionConta',null, '2020-09-12 00:00:00','2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO solicitudes(id_solicitud,id_usuario, tipo_solicitud, estatus, estatus_detalle, fecha_ejecucion, fecha_creacion, fecha_actualizacion) 
VALUES(3, 3,'SolicitudAhorro','ValdiacionConta',null,'2020-09-19 12:00:00','2020-09-19 00:00:00','2020-09-12 00:00:00');

INSERT INTO atributos_solicitud(id_atributo,id_solicitud,nombre,valor,fecha_creacion,fecha_actualizacion) VALUES (1,1,'MONTO','100.5','2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO atributos_solicitud(id_atributo,id_solicitud,nombre,valor,fecha_creacion,fecha_actualizacion) VALUES (2,1,'FECHA','2020-09-12 00:00:00','2020-09-12 01:00:00','2020-09-12 01:00:00');

INSERT INTO validaciones(id_validacion,id_solicitud,numero_validacion,email,estatus,area,fecha_creacion,fecha_actualizacion) VALUES (1,1,1,'pepe@gmail.com',1,'RecursosHumanos','2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO validaciones(id_validacion,id_solicitud,numero_validacion,email,estatus,area,fecha_creacion,fecha_actualizacion) VALUES (2,2,1,'papirriin@gmail.com',0,'Tesoreria','2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO datos_user(id_datos_user,id_usuario,tipo_dato,dato,relevancia,fecha_creacion,fecha_actualizacion) VALUES (1,5,'MONTO_AHORRO','221.44',1,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO datos_user(id_datos_user,id_usuario,tipo_dato,dato,relevancia,fecha_creacion,fecha_actualizacion) VALUES (2,5,'ANTIGUEDAD','2020-02-12 00:00:00',1,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO datos_user(id_datos_user,id_usuario,tipo_dato,dato,relevancia,fecha_creacion,fecha_actualizacion) VALUES (3,5,'SUELDO','4221.44',1,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO datos_user(id_datos_user,id_usuario,tipo_dato,dato,relevancia,fecha_creacion,fecha_actualizacion) VALUES (4,5,'NO_EMPLEADO','00345678',1,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO datos_user(id_datos_user,id_usuario,tipo_dato,dato,relevancia,fecha_creacion,fecha_actualizacion) VALUES (5,5,'OFICINA','Oficina 4',1,'2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO cat_roles(id_rol,nombre) VALUES (1,'USUARIO');
INSERT INTO cat_roles(id_rol,nombre) VALUES (2,'RECURSOS_HUMANOS');
INSERT INTO cat_roles(id_rol,nombre) VALUES (3,'TESORERIA');
INSERT INTO cat_roles(id_rol,nombre) VALUES (4,'CONTABILIDAD');
INSERT INTO cat_roles(id_rol,nombre) VALUES (5,'GERENCIA');
INSERT INTO cat_roles(id_rol,nombre) VALUES (6,'ADMINISTRACION');

INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (1,1,1);
INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (2,1,2);
INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (3,1,3);
INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (4,2,1);
INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (5,2,2);
INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (6,2,3);
INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (7,2,4);
INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (8,3,1);
INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (9,3,2);
INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (10,5,1);
INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (11,5,2);
INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (12,5,3);
INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (13,5,4);
INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (14,5,5);
INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (15,5,6);
INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (16,7,1);
INSERT INTO user_roles(id,id_usuario,id_rol) VALUES (17,7,2);

INSERT INTO saldo_ahorro(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (1,1,'ahorro',22.54,1,'2020-08-15 00:00:00','2020-09-12 00:00:00');
INSERT INTO saldo_ahorro(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (2,1,'ahorro',93.23,1,'2020-08-31 00:00:00','2020-09-12 00:00:00');
INSERT INTO saldo_ahorro(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (3,1,'ahorro',43.13,1,'2020-09-15 00:00:00','2020-09-12 00:00:00');
INSERT INTO saldo_ahorro(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (4,1,'ahorro',22.54,1,'2020-09-30 00:00:00','2020-09-12 00:00:00');
INSERT INTO saldo_ahorro(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (5,1,'deposito',93.23,1,'2020-10-11 00:00:00','2020-09-12 00:00:00');
INSERT INTO saldo_ahorro(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (6,1,'ahorro',43.13,1,'2020-10-15 00:00:00','2020-09-12 00:00:00');

INSERT INTO saldo_ahorro(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (7,5,'ahorro',220.54,1,'2020-08-15 00:00:00','2020-09-12 00:00:00');
INSERT INTO saldo_ahorro(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (8,5,'ahorro',220.23,1,'2020-08-31 00:00:00','2020-09-12 00:00:00');
INSERT INTO saldo_ahorro(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (9,5,'ahorro',245.13,1,'2020-09-15 00:00:00','2020-09-12 00:00:00');
INSERT INTO saldo_ahorro(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (10,5,'retiro',-560.54,1,'2020-09-30 00:00:00','2020-09-12 00:00:00');
INSERT INTO saldo_ahorro(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (11,5,'deposito',130.23,1,'2020-10-11 00:00:00','2020-09-12 00:00:00');
INSERT INTO saldo_ahorro(id_ahorro,id_usuario,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (12,5,'ahorro',243.13,1,'2020-10-15 00:00:00','2020-09-12 00:00:00');

INSERT INTO prestamo(id_prestamo,id_deudor,estatus,monto,fecha_terminacion,fecha_creacion,fecha_actualizacion) VALUES (1,3,1,13.13,'2020-09-12 00:00:00','2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO prestamo(id_prestamo,id_deudor,estatus,monto,fecha_terminacion,fecha_creacion,fecha_actualizacion) VALUES (2,2,1,23.13,'2020-09-12 00:00:00','2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO prestamo(id_prestamo,id_deudor,estatus,monto,fecha_terminacion,fecha_creacion,fecha_actualizacion) VALUES (3,3,0,53.13,'2020-09-12 00:00:00','2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO saldo_prestamo(id_saldo_prestamo,id_prestamo,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (1,1,'TIPO',13.13,1,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO saldo_prestamo(id_saldo_prestamo,id_prestamo,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (2,2,'TIPO',23.13,0,'2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO saldo_prestamo(id_saldo_prestamo,id_prestamo,tipo,monto,validado,fecha_creacion,fecha_actualizacion) VALUES (3,3,'TIPO',53.13,0,'2020-09-12 00:00:00','2020-09-12 00:00:00');


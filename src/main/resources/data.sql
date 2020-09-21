INSERT INTO CAT_PROPIEDADES(id_atributo,tipo,nombre,valor) VALUES (1,'ESTADO','SOLICITUD','0');
INSERT INTO CAT_PROPIEDADES(id_atributo,tipo,nombre,valor) VALUES (2,'ESTADO','VALIDACION RH','1');
INSERT INTO CAT_PROPIEDADES(id_atributo,tipo,nombre,valor) VALUES (3,'ESTADO','VALIDACION CONTABILIDAD','2');

INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(1,'pablito','tortas23@.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(2,'juanito','tortas34@.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(3,'culochi','test@test.com',1,'INTERNO');

INSERT INTO SOLICITUDES(id_solicitud,id_usuario, tipo_solicitud, estatus, estatus_detalle, porcentaje, cantidad, fecha_ejecucion, fecha_creacion, fecha_actualizacion) 
VALUES(1, 1, 1,1,'SOLICITUD_AHORRO', 10.10, 1500.00, '2020-09-12 00:00:00','2020-09-12 00:00:00','2020-09-12 00:00:00');

INSERT INTO SOLICITUDES(id_solicitud,id_usuario, tipo_solicitud, estatus, estatus_detalle, porcentaje, cantidad, fecha_ejecucion, fecha_creacion, fecha_actualizacion) 
VALUES(2, 2, 1,0,'SOLICITUD_AHORRO', 10.10, 1500.00, '2020-09-20 19:00:00','2020-09-20 00:00:00','2020-09-12 00:00:00');

INSERT INTO SOLICITUDES(id_solicitud,id_usuario, tipo_solicitud, estatus, estatus_detalle, porcentaje, cantidad, fecha_ejecucion, fecha_creacion, fecha_actualizacion) 
VALUES(3, 3, 1,0,'SOLICITUD_AHORRO', 10.10, 1500.00, '2020-09-19 12:00:00','2020-09-19 00:00:00','2020-09-12 00:00:00');

INSERT INTO ATRIBUTOS_SOLICITUD(id_atributo,id_solicitud,tipo_atributo,nombre,valor,fecha_creacion,fecha_actualizacion) VALUES (1,1,1,'PORCENTAJE_AHORRO','10.5','2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO ATRIBUTOS_SOLICITUD(id_atributo,id_solicitud,tipo_atributo,nombre,valor,fecha_creacion,fecha_actualizacion) VALUES (2,1,2,'FECHA_INGRESO','2020-09-12 00:00:00','2020-09-12 01:00:00','2020-09-12 01:00:00');

INSERT INTO VALIDACIONES(id_validacion,id_solicitud,numero_validacion,id_usuario,estatus,tipo_validacion,fecha_creacion,fecha_actualizacion) VALUES (1,1,1,2,1,'RH','2020-09-12 00:00:00','2020-09-12 00:00:00');



INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(1,'Charly1','tortas@.com',1,'INTERNO');
INSERT INTO USUARIOS(id_usuario,nombre,email,estatus,tipo_usuario) VALUES(2,'Charly2','tortas@.com',1,'INTERNO');


INSERT INTO ATRIBUTOS_SOLICITUD(id_atributo,id_solicitud,tipo_atributo,nombre,valor,fecha_creacion,fecha_actualizacion) VALUES (1,1,0,'PORCENTAJE_AHORRO','10.5','2020-09-12 00:00:00','2020-09-12 00:00:00');
INSERT INTO ATRIBUTOS_SOLICITUD(id_atributo,id_solicitud,tipo_atributo,nombre,valor,fecha_creacion,fecha_actualizacion) VALUES (1,1,0,'FECHA_INGRESO','2020-09-12 00:00:00','2020-09-12 01:00:00','2020-09-12 01:00:00');


INSERT INTO VALIDACIONES(id_validacion,id_solicitud,numero_validacion,id_usuario,estatus,tipo_validacion,fecha_creacion,fecha_actualizacion) VALUES (1,1,1,2,1,'RH','2020-09-12 00:00:00','2020-09-12 00:00:00');

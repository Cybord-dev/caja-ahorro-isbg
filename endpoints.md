# [ENDPOINTS DOCUMENTATION]

CATALOGOS

GET /catalogos/{tipo_cat} <-- todo los catalogos de un tipo especifico

GET /catalogos/{tipo_cat}/{nombre} <-- regresa un catalogo especifico

POST /catalogos

DELETE /catalogos/{tipo_cat}/{nombre}

RESOURCES

GET ID  /recursos/1
GET REFERENCIA & REFRENCIADO /recursos/tipos/{AHORRO}/refrerencias/2
DELETE ID /recursos/1
INSERT /recursos

SALDO AHORRO & SALDO PRESTAMO

GET /usuarios/{id_user}/ahorros  <-- TODOS LOS AHORROS DE UN USUARIO
GET /usuarios/{id_user}/ahorros/{id_ahorro} <-- ahorro especifico

POST GET /usuarios/{id_user}/ahorros



GET /usuarios/{id_user}/prestamos  <-- TODOS LOS prestamos DE UN USUARIO
GET /usuarios/{id_user}/prestamos/{id_ahorro} <-- prestamo especifico

POST GET /usuarios/{id_user}/prestamos



USERS (EL objeto debe de contener informacion de USUARIOS-DEUDOR-AHORRADOR-DATOS-USER)

CRUD

GET /usuarios todos los usuarios de la plataforma <-- filtrados dinamicos
 
GET /usuarios/{id_user}

POST /usuarios

PUT /usuarios/{id_user} TODO menos las llaves (ID, EMAIL)

DELETE /usuarios/{id_user}

USER_ROLES

GET /usuarios/{id_user}/roles 

POST /usuarios/{id_user}/roles

DELETE /usuarios/{id_user}/roles/{id_role}


SOLICITUDES (informacion de SOLICITUDES-ATRIBUTOS-VALIDACIONES)

GET /solicitudes todos los solicitudes de la plataforma <-- filtrados dinamicos
 
GET /solicitudes/{id_solicitud}

DELETE /solicitudes/{id_solicitud}

POST /usuarios/{id_user}/solicitudes

PUT /usuarios/{id_user}/solicitudes/{id_solicitud}






MY INFO

GET /myInfo

USUARIOS(solo mi usuario)-(ROLES/USER_ROLES) 








PRESTAMO & AHORRADOR & DEUDOR PENDIENTES

* SOLO INSERT(POST)





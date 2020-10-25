# [ENDPOINTS DOCUMENTATION]

# CATALOGOS

GET /catalogos/{tipo_cat} <-- todo los catalogos de un tipo especifico
GET /catalogos/{tipo_cat}/{nombre} <-- regresa un catalogo especifico
POST /catalogos
DELETE /catalogos/{tipo_cat}/{nombre}

#### OFICINA

GET /catalogos/oficina

# RESOURCES

GET ID  /recursos/1
GET REFERENCIA & REFRENCIADO /recursos/tipos/{AHORRO}/refrerencias/2
DELETE ID /recursos/1
INSERT /recursos

# SALDO AHORRO & SALDO PRESTAMO

GET /usuarios/{id_user}/ahorros  <-- TODOS LOS AHORROS DE UN USUARIO
GET /usuarios/{id_user}/ahorros/{id_ahorro} <-- ahorro especifico

POST GET /usuarios/{id_user}/ahorros

GET /usuarios/{id_user}/prestamos  <-- TODOS LOS prestamos DE UN USUARIO
GET /usuarios/{id_user}/prestamos/{id_ahorro} <-- prestamo especifico

POST GET /usuarios/{id_user}/prestamos
GET /usuarios/{id_user}/prestamos/{id_prestamo}/saldos
GET /usuarios/{id_user}/prestamos/{id_prestamo}/saldos/{id_saldos}
POST /usuarios/{id_user}/prestamos/{id_prestamo}/saldos

# USERS (EL objeto debe de contener informacion de USUARIOS-DEUDOR-AHORRADOR-DATOS-USER)

# USUARIOS

GET /usuarios todos los usuarios de la plataforma <-- filtrados dinamicos
GET /usuarios/{id_user}
POST /usuarios
PUT /usuarios/{id_user} TODO menos las llaves (ID, EMAIL)
DELETE /usuarios/{id_user}

# USER_ROLES

GET     /usuarios/{id_user}/roles 
POST    /usuarios/{id_user}/roles
DELETE  /usuarios/{id_user}/roles/{id_role}

# SOLICITUDES 

-GET    /solicitudes todos los solicitudes de la plataforma <-- filtrados dinamicos
-GET    /usuarios/{id_user}/solicitudes/{id_solicitud}
-GET    /usuarios/{id_user}/solicitudes
-GET    /usuarios/{id_user}/solicitudes/{id_solicitud}
-POST   /usuarios/{id_user}/solicitudes
-PUT    /solicitudes/{id_solicitud}
-DELETE /solicitudes/{id_solicitud}

### paginados 
-GET SOLICITUDES PAGINADAS

    +TODAS
    api/v1/solicitudes
    +POR TIPO SOLICITUD
    api/v1/solicitudes?tipoSolicitud=SolicitudAhorro
    +POR NOMBRE
    api/v1/solicitudes?nombre=Edgar
    +POR NO EMPLEADO
    api/v1/solicitudes?noEmpleado=7
    +POR TIPO USUARIO
    api/v1/solicitudes?tipoUsuario=INTERNO
    +POR ESTATUS
    api/v1/solicitudes?estatus=Rechazada
    +POR FECHA INICIO
    api/v1/solicitudes?since=2020-09-18
    +POR FECHA FINAL
    api/v1/solicitudes?to=Rechazada
    +PAGES
    api/v1/solicitudes?&page=0&size=1

# ATRIBUTOS SOLICITUD 

GET /usuarios/{id_user}/solicitudes/{id_solicitud}/atributos todos los solicitudes de la plataforma <-- filtrados dinamicos
GET /usuarios/{id_user}/solicitudes/{id_solicitud}/atributos/{id_atributo}
DELETE /usuarios/{id_user}/solicitudes/{id_solicitud}/atributos/{id_solicitud}
POST /usuarios/{id_user}/solicitudes/{id_solicitud}/atributos
PUT /usuarios/{id_user}/solicitudes/{id_solicitud}/atributos/{id_atributos}

# VALIDACIONES SOLICITUDES 

GET /usuarios/{id_user}/solicitudes/{id_solicitud}/validaciones todos los solicitudes de la plataforma <-- filtrados dinamicos
GET usuarios/{id_user}/solicitudes/{id_solicitud}/validaciones/{id_validaciones}
DELETE usuarios/{id_user}/solicitudes/{id_solicitud}/validaciones/{id_validaciones}
POST usuarios/{id_user}/solicitudes/{id_solicitud}/validaciones
PUT usuarios/{id_user}/solicitudes/{id_solicitud}/validaciones/{id_validaciones}

### paginados 

-GET SOLICITUDES VALIDACIONES

    +TODAS
    api/v1/validaciones
    +POR TIPO SOLICITUD
    api/v1/validaciones?tipoSolicitud=SolicitudAhorro
    +POR NOMBRE
    api/v1/validaciones?nombre=Edgar
    +POR NO EMPLEADO
    api/v1/validaciones?noEmpleado=7
    +POR TIPO USUARIO
    api/v1/validaciones?tipoUsuario=INTERNO
    +POR ESTATUS
    api/v1/validaciones?estatus=Rechazada
    +POR FECHA INICIO
    api/v1/validaciones?since=2020-09-18
    +POR FECHA FINAL
    api/v1/validaciones?to=Rechazada
    +POR CORREO
    api/v1/validaciones?email=edcgamer@gmail.com
    +POR AREA
    api/v1/validaciones?area=recursos-humanos
    +POR ESTATUS VALIDACION
    api/v1/validaciones?status=0
    +PAGES
    api/v1/validaciones?&page=0&size=1


# MY INFO (USUARIO LOGEADO) 
MY INFO

GET /myInfo

PRESTAMO & AHORRADOR & DEUDOR PENDIENTES

* SOLO INSERT(POST)

# REPORTES

### REPORTE SALDO AHORO
GET api/v1/saldosAhorro

### paginados 
-GET SOLICITUDES PAGINADAS

    +TODAS
    api/v1/saldosAhorro
    +POR TIPO 
    api/v1/solicitudes?tipo=retiro
    +POR NOMBRE
    api/v1/solicitudes?nombre=Edgar
    +POR NO EMPLEADO
    api/v1/solicitudes?noEmpleado=7
    +POR TIPO USUARIO
    api/v1/solicitudes?tipoUsuario=INTERNO
    +POR FECHA INICIO
    api/v1/solicitudes?since=2020-09-18
    +POR FECHA FINAL
    api/v1/solicitudes?to=Rechazada
    +PAGES
    api/v1/solicitudes?&page=0&size=1
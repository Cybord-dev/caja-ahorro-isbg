(window.webpackJsonp=window.webpackJsonp||[]).push([[4],{"aBT+":function(o,i,e){"use strict";e.d(i,"a",(function(){return O}));var t=e("EwKM"),a=e("8Y7J"),n=e("SVse"),s=e("ESM5"),c=e("q+li"),r=e("iInd"),b=e("s7LF"),l=e("jksu");function d(o,i){if(1&o){const o=a.Yb();a.Xb(0,"div",7),a.Xb(1,"label",29),a.Gc(2,"Tipo de Usuario"),a.Wb(),a.Xb(3,"div"),a.Xb(4,"select",30),a.ec("ngModelChange",(function(i){return a.yc(o),a.gc().filterParams.tipoUsuario=i})),a.Xb(5,"option",18),a.Gc(6,"TODOS"),a.Wb(),a.Xb(7,"option",31),a.Gc(8,"INTERNO"),a.Wb(),a.Xb(9,"option",32),a.Gc(10,"EXTERNO"),a.Wb(),a.Wb(),a.Wb(),a.Wb()}if(2&o){const o=a.gc();a.Fb(4),a.nc("ngModel",o.filterParams.tipoUsuario)}}function u(o,i){1&o&&a.Sb(0,"i",33)}function g(o,i){1&o&&(a.Xb(0,"div",34),a.Gc(1," No se encontraron resultados "),a.Wb())}function h(o,i){1&o&&(a.Xb(0,"option",44),a.Gc(1,"20"),a.Wb())}function f(o,i){1&o&&(a.Xb(0,"option",45),a.Gc(1,"50"),a.Wb())}function p(o,i){if(1&o){const o=a.Yb();a.Xb(0,"select",40),a.ec("ngModelChange",(function(i){return a.yc(o),a.gc(2).filterParams.size=i}))("change",(function(i){return a.yc(o),a.gc(2).onChangePageSize(i.target.value)})),a.Xb(1,"option",41),a.Gc(2,"10"),a.Wb(),a.Ec(3,h,2,0,"option",42),a.Ec(4,f,2,0,"option",43),a.Wb()}if(2&o){const o=a.gc(2);a.nc("ngModel",o.filterParams.size),a.Fb(3),a.nc("ngIf",o.page.number<o.page.totalElements/20),a.Fb(1),a.nc("ngIf",o.page.number<o.page.totalElements/50)}}function m(o,i){if(1&o){const o=a.Yb();a.Xb(0,"div",35),a.Xb(1,"button",36),a.ec("click",(function(){return a.yc(o),a.gc().downloadXLSFile()})),a.Sb(2,"i",37),a.Wb(),a.Ec(3,p,5,3,"select",38),a.Xb(4,"strong",39),a.Gc(5," Tama\xf1o Pagina \xa0\xa0\xa0\xa0"),a.Wb(),a.Wb()}if(2&o){const o=a.gc();a.Fb(3),a.nc("ngIf",0==o.page.last||1==o.page.first)}}function v(o,i){1&o&&(a.Xb(0,"td",59),a.Xb(1,"span",61),a.Gc(2,"ACTIVO"),a.Wb(),a.Wb())}function X(o,i){1&o&&(a.Xb(0,"td",59),a.Xb(1,"span",62),a.Gc(2,"INACTIVO"),a.Wb(),a.Wb())}function W(o,i){if(1&o){const o=a.Yb();a.Xb(0,"tr"),a.Xb(1,"td",50),a.Xb(2,"button",51),a.ec("click",(function(){a.yc(o);const e=i.$implicit;return a.gc(2).redirectToUser(e.id)})),a.Sb(3,"i",52),a.Wb(),a.Xb(4,"button",53),a.ec("click",(function(){a.yc(o);const e=i.$implicit;return a.gc(2).redirectToAdjustment(e.id)})),a.Sb(5,"i",54),a.Wb(),a.Xb(6,"button",55),a.ec("click",(function(){a.yc(o);const e=i.$implicit;return a.gc(2).redirectToAhorro(e.id)})),a.Sb(7,"i",56),a.Wb(),a.Xb(8,"button",55),a.ec("click",(function(){a.yc(o);const e=i.$implicit;return a.gc(2).redirectToPrestamo(e.id)})),a.Sb(9,"i",57),a.Wb(),a.Wb(),a.Xb(10,"td",58),a.Gc(11),a.Wb(),a.Xb(12,"td",59),a.Gc(13),a.Wb(),a.Xb(14,"td",59),a.Gc(15),a.Wb(),a.Xb(16,"td",59),a.Gc(17),a.Wb(),a.Ec(18,v,3,0,"td",60),a.Ec(19,X,3,0,"td",60),a.Wb()}if(2&o){const o=i.$implicit;a.Fb(11),a.Hc(o.noEmpleado),a.Fb(2),a.Hc(o.nombre),a.Fb(2),a.Hc(o.email),a.Fb(2),a.Hc(o.tipoUsuario),a.Fb(1),a.nc("ngIf",!0===o.activo),a.Fb(1),a.nc("ngIf",!1===o.activo)}}function E(o,i){if(1&o){const o=a.Yb();a.Xb(0,"li",68),a.Xb(1,"button",69),a.ec("click",(function(){a.yc(o);const i=a.gc(4);return i.updateDataTable(0,i.page.size)})),a.Sb(2,"i",70),a.Wb(),a.Wb()}}function I(o,i){if(1&o){const o=a.Yb();a.Xb(0,"li",68),a.Xb(1,"button",69),a.ec("click",(function(){a.yc(o);const i=a.gc(4);return i.updateDataTable(i.page.number-1,i.page.size)})),a.Gc(2),a.Wb(),a.Wb()}if(2&o){const o=a.gc(4);a.Fb(2),a.Hc(o.page.number)}}function M(o,i){if(1&o){const o=a.Yb();a.Xb(0,"li",68),a.Xb(1,"button",69),a.ec("click",(function(){a.yc(o);const i=a.gc(4);return i.updateDataTable(i.page.number+1,i.page.size)})),a.Gc(2),a.Wb(),a.Wb()}if(2&o){const o=a.gc(4);a.Fb(2),a.Hc(o.page.number+2)}}function C(o,i){if(1&o){const o=a.Yb();a.Xb(0,"li",68),a.Xb(1,"button",69),a.ec("click",(function(){a.yc(o);const i=a.gc(4);return i.updateDataTable(i.page.totalPages-1,i.page.size)})),a.Sb(2,"i",71),a.Wb(),a.Wb()}}function N(o,i){if(1&o&&(a.Xb(0,"ul",64),a.Ec(1,E,3,0,"li",65),a.Ec(2,I,3,1,"li",65),a.Xb(3,"li",66),a.Xb(4,"a",67),a.Xb(5,"strong"),a.Gc(6),a.Wb(),a.Wb(),a.Wb(),a.Ec(7,M,3,1,"li",65),a.Ec(8,C,3,0,"li",65),a.Wb()),2&o){const o=a.gc(3);a.Fb(1),a.nc("ngIf",0==o.page.first),a.Fb(1),a.nc("ngIf",0==o.page.first),a.Fb(4),a.Hc(o.page.number+1),a.Fb(1),a.nc("ngIf",0==o.page.last),a.Fb(1),a.nc("ngIf",0==o.page.last)}}function k(o,i){if(1&o&&(a.Xb(0,"div",35),a.Ec(1,N,9,5,"ul",63),a.Wb()),2&o){const o=a.gc(2);a.Fb(1),a.nc("ngIf",o.page.totalElements>1)}}function y(o,i){if(1&o&&(a.Xb(0,"div",46),a.Xb(1,"table",47),a.Xb(2,"thead",48),a.Xb(3,"tr"),a.Xb(4,"th"),a.Gc(5,"ACCIONES"),a.Wb(),a.Xb(6,"th"),a.Gc(7,"NO. EMPLEADO"),a.Wb(),a.Xb(8,"th"),a.Gc(9,"NOMBRE"),a.Wb(),a.Xb(10,"th"),a.Gc(11,"CORREO"),a.Wb(),a.Xb(12,"th"),a.Gc(13,"TIPO"),a.Wb(),a.Xb(14,"th"),a.Gc(15,"STATUS"),a.Wb(),a.Wb(),a.Wb(),a.Xb(16,"tbody"),a.Ec(17,W,20,6,"tr",49),a.Wb(),a.Wb(),a.Ec(18,k,2,1,"div",26),a.Wb()),2&o){const o=a.gc();a.Fb(17),a.nc("ngForOf",o.page.content),a.Fb(1),a.nc("ngIf",0==o.page.empty)}}function U(o,i){1&o&&a.Sb(0,"cybord-loader")}let O=(()=>{class o{constructor(o,i,e,a){this.datepipe=o,this.userService=i,this.downloadService=e,this.router=a,this.module="recursos-humanos",this.page=new t.a,this.pageSize="10",this.loading=!1,this.filterParams={email:"",estatus:"*",nombre:"",tipoUsuario:"*",page:"0",size:"10"}}ngOnInit(){this.module=this.router.url.split("/")[1],"recursos-humanos"===this.module&&(this.filterParams.tipoUsuario="INTERNO"),"contabilidad"===this.module&&(this.filterParams.tipoUsuario="EXTERNO"),this.updateDataTable(0,10)}updateDataTable(o,i,e){this.loading=!0,this.filterParams.page=o||0,this.filterParams.size=i||10,this.userService.getUsuarios(this.filterParams).subscribe(o=>{this.page=o,this.loading=!1})}onChangePageSize(o){this.updateDataTable(this.page.number,o)}redirectToUser(o){this.router.navigate([`../${this.module}/usuarios/${o}`])}redirectToAdjustment(o){this.router.navigate(["../contabilidad/ajustes/"+o])}redirectToAhorro(o){this.router.navigate([`../${this.module}/saldo-ahorro/${o}`])}redirectToPrestamo(o){this.router.navigate([`../${this.module}/prestamos-activos/${o}`])}downloadXLSFile(){this.loading=!0,this.filterParams.page="0",this.filterParams.size="100000",this.userService.getUsuariosReport(this.filterParams).subscribe(o=>{this.downloadService.downloadFile(o.dato,`ReporteUsuarios-${this.datepipe.transform(Date.now(),"yyyy-MM-dd")}.xls`,"application/vnd.ms-excel"),this.loading=!1})}}return o.\u0275fac=function(i){return new(i||o)(a.Rb(n.f),a.Rb(s.a),a.Rb(c.a),a.Rb(r.c))},o.\u0275cmp=a.Lb({type:o,selectors:[["cybord-usuarios"]],decls:53,vars:12,consts:[[1,"animated","fadeIn"],[1,"row"],[1,"col-sm-12","col-md-12"],[1,"card"],[1,"card-header"],[1,"card-body"],[1,"row","slide_1"],[1,"col-md-2"],["for","inputCorreo",1,"label"],["type","text","nbInput","","fullWidth","","id","inputCorreo","placeholder","email usuario",1,"form-control",3,"ngModel","disabled","ngModelChange"],[1,"col-md-3"],["for","nombreusuario",1,"label"],["type","text","nbInput","","fullWidth","","id","nombreusu","placeholder","nombre usuario",1,"form-control",3,"ngModel","disabled","ngModelChange"],["class","col-md-2",4,"ngIf"],[1,"col-md-5"],["for","inputActivo",1,"label"],[1,"row","form-inline"],["id","inputActivo","fullWidth","",1,"form-control",2,"display","block",3,"ngModel","ngModelChange"],["value","*"],["value","1"],["value","0"],[1,"btn","btn-primary",3,"disabled","click"],["class","fa fa-spinner fa-spin",4,"ngIf"],[1,"btn","btn-primary",3,"click"],[1,"col"],["class","alert alert-primary","role","alert",4,"ngIf"],["class","clearfix",4,"ngIf"],["class","table-responsive",4,"ngIf"],[4,"ngIf"],["for","tipoUsuario",1,"label"],["id","inputTipoUsuario","fullWidth","",1,"form-control",2,"display","block",3,"ngModel","ngModelChange"],["value","INTERNO"],["value","EXTERNO"],[1,"fa","fa-spinner","fa-spin"],["role","alert",1,"alert","alert-primary"],[1,"clearfix"],[1,"btn-sm","btn-success","float-right",3,"click"],[1,"fa","fa-file-excel-o","fa-sm"],["id","inputunidad","style","display:block;width: 95px; margin-right: 15px;","class","float-right form-control form-control-sm",3,"ngModel","ngModelChange","change",4,"ngIf"],[1,"float-right"],["id","inputunidad",1,"float-right","form-control","form-control-sm",2,"display","block","width","95px","margin-right","15px",3,"ngModel","ngModelChange","change"],["value","10"],["value","20",4,"ngIf"],["value","50",4,"ngIf"],["value","20"],["value","50"],[1,"table-responsive"],[1,"table","table-bordered","table-sm"],[1,"thead-dark"],[4,"ngFor","ngForOf"],["scope","row",1,"text-center"],[1,"btn-sm","btn-info",3,"click"],[1,"fa","fa-search","fa-sm"],[1,"btn-sm","btn-warning",3,"click"],[1,"fa","fa-money","fa-sm"],[1,"btn-sm","btn-success",3,"click"],[1,"fa","fa-bank","fa-sm"],[1,"fa","fa-credit-card","fa-sm"],["scope","row",1,"text-right"],["scope","row"],["scope","row",4,"ngIf"],[1,"badge","badge-success"],[1,"badge","badge-danger"],["class","pagination float-right",4,"ngIf"],[1,"pagination","float-right"],["class","page-item",4,"ngIf"],[1,"page-item","active"],[1,"page-link"],[1,"page-item"],[1,"btn","page-link",3,"click"],[1,"icon-control-rewind","icons"],[1,"icon-control-forward","icons"]],template:function(o,i){1&o&&(a.Xb(0,"div",0),a.Xb(1,"div",1),a.Xb(2,"div",2),a.Xb(3,"div",3),a.Xb(4,"div",4),a.Xb(5,"strong"),a.Gc(6,"Altas y bajas de usuarios - Filtros de busqueda"),a.Wb(),a.Wb(),a.Xb(7,"div",5),a.Xb(8,"div",6),a.Xb(9,"div",7),a.Xb(10,"label",8),a.Gc(11,"Correo Usuario"),a.Wb(),a.Xb(12,"input",9),a.ec("ngModelChange",(function(o){return i.filterParams.email=o})),a.Wb(),a.Wb(),a.Xb(13,"div",10),a.Xb(14,"label",11),a.Gc(15,"Nombre Usuario"),a.Wb(),a.Xb(16,"input",12),a.ec("ngModelChange",(function(o){return i.filterParams.nombre=o})),a.Wb(),a.Wb(),a.Ec(17,d,11,1,"div",13),a.Xb(18,"div",14),a.Xb(19,"label",15),a.Gc(20,"Estatus Usuario"),a.Wb(),a.Xb(21,"div",16),a.Xb(22,"select",17),a.ec("ngModelChange",(function(o){return i.filterParams.estatus=o})),a.Xb(23,"option",18),a.Gc(24,"TODOS"),a.Wb(),a.Xb(25,"option",19),a.Gc(26,"ACTIVO"),a.Wb(),a.Xb(27,"option",20),a.Gc(28,"INACTIVO"),a.Wb(),a.Wb(),a.Xb(29,"p"),a.Gc(30,"\xa0\xa0\xa0\xa0"),a.Wb(),a.Xb(31,"button",21),a.ec("click",(function(){return i.updateDataTable(0,10)})),a.Gc(32,"BUSCAR "),a.Ec(33,u,1,0,"i",22),a.Wb(),a.Xb(34,"p"),a.Gc(35,"\xa0\xa0\xa0\xa0"),a.Wb(),a.Xb(36,"button",23),a.ec("click",(function(){return i.redirectToUser("*")})),a.Gc(37,"NUEVO USUARIO"),a.Wb(),a.Wb(),a.Wb(),a.Wb(),a.Wb(),a.Wb(),a.Wb(),a.Wb(),a.Xb(38,"div",1),a.Xb(39,"div",2),a.Xb(40,"div",3),a.Xb(41,"div",4),a.Xb(42,"strong"),a.Gc(43,"Resultados"),a.Wb(),a.Wb(),a.Xb(44,"div",5),a.Xb(45,"div",1),a.Xb(46,"div",24),a.Ec(47,g,2,0,"div",25),a.Ec(48,m,6,1,"div",26),a.Wb(),a.Wb(),a.Xb(49,"div",1),a.Xb(50,"div",24),a.Ec(51,y,19,2,"div",27),a.Wb(),a.Wb(),a.Wb(),a.Ec(52,U,1,0,"cybord-loader",28),a.Wb(),a.Wb(),a.Wb(),a.Wb()),2&o&&(a.Fb(12),a.nc("ngModel",i.filterParams.email)("disabled",i.filterParams.nombre.length>0),a.Fb(4),a.nc("ngModel",i.filterParams.nombre)("disabled",i.filterParams.email.length>0),a.Fb(1),a.nc("ngIf","recursos-humanos"!=i.module),a.Fb(5),a.nc("ngModel",i.filterParams.estatus),a.Fb(9),a.nc("disabled",i.loading),a.Fb(2),a.nc("ngIf",i.loading),a.Fb(14),a.nc("ngIf",!0===i.page.empty),a.Fb(1),a.nc("ngIf",!1===i.page.empty),a.Fb(3),a.nc("ngIf",0==i.page.empty),a.Fb(1),a.nc("ngIf",i.loading))},directives:[b.b,b.h,b.k,n.n,b.o,b.l,b.p,n.m,l.a],styles:[""]}),o})()},qZ4S:function(o,i,e){"use strict";e.d(i,"a",(function(){return a}));var t=e("8Y7J");let a=(()=>{class o{constructor(){}validateSaldoPrestamo(o,i){const e=[];return(void 0===o.monto||o.monto<=10)&&e.push("El monto del pago debe ser mayor a $10.00"),null!=o.idPrestamo&&null!==o.idPrestamo||e.push("La referencia del prestamo no ests ligada"),null!=o.origen&&null!==o.origen||e.push("El origen del pago no ha sido especificado"),null!=o.tipo&&null!==o.tipo||e.push("El tipo del pago no ha sido especificado"),e}validateSolicitud(o,i){const e=[];return"RetiroParcialAhorro"===o.tipo&&+o.atributos.MONTO>i&&e.push("No es posible solicitar un monto superior al total de su ahorro de $"+i),void 0===o.atributos.MONTO&&e.push("El monto de la solicitud no ha sido asignado"),"CancelacionAhorro"===o.tipo&&(void 0===o.atributos.RAZON_CANCELACION||o.atributos.RAZON_CANCELACION.length<10)&&e.push("La descripci\xf3n del motivo de cancelaci\xf3n es muy corto"),e}validarUsuario(o){const i=[],e=new RegExp("^([0-9a-zA-Z\xc0-\xfa.,&-_ ]+)$"),t=new RegExp("^([0-9]{8,20})$");return(!new RegExp("^[a-z0-9A-Z._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$").test(o.email)||void 0===o.email)&&o.email.length<2&&o.email.length>100&&i.push("El email no es valido"),(!e.test(o.nombre)||void 0===o.nombre||o.nombre.length<2||o.nombre.length>100)&&i.push("El nombre no es valido"),void 0===o.noEmpleado&&i.push("El No. de empleado no ha sido asignado"),"*"!==o.datosUsuario.OFICINA&&void 0!==o.datosUsuario.OFICINA||i.push("La oficina no ha sido asignado"),"*"!==o.datosUsuario.BANCO&&void 0!==o.datosUsuario.BANCO||i.push("El banco no ha sido asignado"),"*"!==o.datosUsuario.TIPO_CUENTA&&void 0!==o.datosUsuario.TIPO_CUENTA||i.push("El tipo de cuenta no esta definido"),t.test(o.datosUsuario.CUENTA)||i.push("El no. de cuenta es invalido"),Number(o.datosUsuario.SUELDO)<100&&i.push("El saldo no es valido (MENOR A 100)"),i}}return o.\u0275fac=function(i){return new(i||o)},o.\u0275prov=t.Nb({token:o,factory:o.\u0275fac,providedIn:"root"}),o})()},uwdg:function(o,i,e){"use strict";e.d(i,"a",(function(){return P}));var t=e("mrSG");class a{constructor(o,i,e){this.tipoDato=o,this.dato=i,this.relevancia=e||0}}var n=e("KZhB");class s{constructor(o){this.nombre=o}}var c=e("8Y7J"),r=e("SVse"),b=e("iInd"),l=e("4ujS"),d=e("ESM5"),u=e("qZ4S"),g=e("s7LF"),h=e("ienR"),f=e("LqlI"),p=e("jksu");const m=["modalConfirmacion"];function v(o,i){if(1&o&&(c.Xb(0,"p"),c.Gc(1),c.Wb()),2&o){const o=i.$implicit;c.Fb(1),c.Hc(o)}}function X(o,i){if(1&o&&(c.Xb(0,"div",76),c.Ec(1,v,2,1,"p",77),c.Wb()),2&o){const o=c.gc();c.Fb(1),c.nc("ngForOf",o.errorMessages)}}function W(o,i){if(1&o&&(c.Xb(0,"option",78),c.Gc(1),c.Wb()),2&o){const o=i.$implicit;c.nc("value",o.nombre),c.Fb(1),c.Hc(o.valor)}}function E(o,i){if(1&o&&(c.Xb(0,"option",78),c.Gc(1),c.Wb()),2&o){const o=i.$implicit;c.nc("value",o.nombre),c.Fb(1),c.Hc(o.valor)}}function I(o,i){if(1&o&&(c.Xb(0,"option",78),c.Gc(1),c.Wb()),2&o){const o=i.$implicit;c.nc("value",o.nombre),c.Fb(1),c.Hc(o.valor)}}function M(o,i){1&o&&c.Sb(0,"i",81)}function C(o,i){if(1&o){const o=c.Yb();c.Xb(0,"button",79),c.ec("click",(function(){return c.yc(o),c.gc().openModal("traspaso")})),c.Gc(1," Traspasar prestamos a avales "),c.Ec(2,M,1,0,"i",80),c.Wb()}if(2&o){const o=c.gc();c.nc("disabled",o.loading),c.Fb(2),c.nc("ngIf",o.loading)}}function N(o,i){if(1&o&&(c.Xb(0,"p",82),c.Gc(1),c.Wb()),2&o){const o=c.gc();c.Fb(1),c.Hc(o.params.success)}}function k(o,i){1&o&&c.Sb(0,"cybord-loader")}function y(o,i){1&o&&c.Sb(0,"i",81)}function U(o,i){if(1&o){const o=c.Yb();c.Xb(0,"button",79),c.ec("click",(function(){return c.yc(o),c.gc().openModal("creacion")})),c.Gc(1," Registrar "),c.Ec(2,y,1,0,"i",80),c.Wb()}if(2&o){const o=c.gc();c.nc("disabled",o.loading),c.Fb(2),c.nc("ngIf",o.loading)}}function O(o,i){1&o&&c.Sb(0,"i",81)}function A(o,i){if(1&o){const o=c.Yb();c.Xb(0,"button",79),c.ec("click",(function(){return c.yc(o),c.gc().openModal("actualizacion")})),c.Gc(1," Actualizar "),c.Ec(2,O,1,0,"i",80),c.Wb()}if(2&o){const o=c.gc();c.nc("disabled",o.loading),c.Fb(2),c.nc("ngIf",o.loading)}}function F(o,i){1&o&&(c.Xb(0,"strong"),c.Gc(1," \xbf Estas seguro de actualizar al usuario ?"),c.Wb())}function S(o,i){1&o&&(c.Xb(0,"strong"),c.Gc(1," \xbf Estas seguro de dar de alta al usuario ?"),c.Wb())}function G(o,i){1&o&&(c.Xb(0,"strong",83),c.Gc(1," \xbf Estas seguro de traspasar los prestamos del usuario a los avales ?"),c.Wb())}function R(o,i){1&o&&(c.Xb(0,"p",83),c.Gc(1," Una vez realizada esta accion no puede ser deshecha"),c.Wb())}function T(o,i){if(1&o){const o=c.Yb();c.Xb(0,"button",84),c.ec("click",(function(){return c.yc(o),c.gc().update()})),c.Gc(1,"Si"),c.Wb()}}function x(o,i){if(1&o){const o=c.Yb();c.Xb(0,"button",84),c.ec("click",(function(){return c.yc(o),c.gc().register()})),c.Gc(1,"Si"),c.Wb()}}function D(o,i){if(1&o){const o=c.Yb();c.Xb(0,"button",84),c.ec("click",(function(){return c.yc(o),c.gc().traspasarPrestamos()})),c.Gc(1,"Si"),c.Wb()}}const w=function(){return{dateInputFormat:"DD/MM/YYYY"}};let P=(()=>{class o{constructor(o,i,e,t,a,s){this.datepipe=o,this.route=i,this.catService=e,this.usuarioServicio=t,this.router=a,this.validationService=s,this.submitted=!1,this.loading=!1,this.usuario=new n.a,this.errorMessages=[],this.mensajeModal="",this.params={success:"",message:"",id:"*",module:"usuarios",interno:!1},this.oficinas=[],this.bancos=[],this.cuentas=[],this.roles={USUARIO:!0,RECURSOS_HUMANOS:!1,TESORERIA:!1,CONTABILIDAD:!1,GERENCIA_INTERNA:!1,GERENCIA_EXTERNA:!1,ADMINISTRACION:!1,DIRECCION:!1},this.nombreRoles=Object.keys(this.roles)}ngOnInit(){this.maxDate=new Date,this.loading=!0,this.errorMessages=[],this.params.module=this.router.url.split("/")[1],this.antiguedad=new Date,this.catService.getCatalogosByTipo("oficinas").subscribe(o=>this.oficinas=o),this.catService.getCatalogosByTipo("bancos").subscribe(o=>this.bancos=o),this.catService.getCatalogosByTipo("tipo-cuenta").subscribe(o=>this.cuentas=o),this.route.paramMap.subscribe(o=>{const i=o.get("idUsuario");"*"!==i?(this.updateUserInfo(+i),this.loading=!1):(this.antiguedad=new Date,this.loading=!1)})}updateUserInfo(o){return Object(t.a)(this,void 0,void 0,(function*(){try{this.usuario=yield this.usuarioServicio.getUsuario(o).toPromise(),this.antiguedad=new Date(this.usuario.datosUsuario.ANTIGUEDAD);for(const o of this.usuario.roles)this.roles[o]=!0}catch(i){this.loading=!1,this.errorMessages.push(i)}}))}toggleUserType(){this.usuario.tipoUsuario="INTERNO"===this.usuario.tipoUsuario?"EXTERNO":"INTERNO"}openModal(o){this.operacion=o,this.modalConfirmacion.show()}decline(){this.operacion="",this.params.success=void 0,this.modalConfirmacion.hide()}update(){this.errorMessages=[],this.loading=!0,this.modalConfirmacion.hide(),this.errorMessages=this.validationService.validarUsuario(this.usuario),this.errorMessages.length>0?this.loading=!1:this.usuarioServicio.actualizaUser(this.usuario).toPromise().then(o=>Object(t.a)(this,void 0,void 0,(function*(){void 0!==this.usuario.datosUsuario.ANTIGUEDAD&&(this.usuario.datosUsuario.ANTIGUEDAD=this.datepipe.transform(this.antiguedad,"yyyy-MM-dd"));for(const e in this.usuario.datosUsuario)if(void 0!==e&&void 0!==this.usuario.datosUsuario[e]&&""!==this.usuario.datosUsuario[e]&&null!==this.usuario.datosUsuario[e]&&o.datosUsuario[e]!==this.usuario.datosUsuario[e]){const o=new a(e,this.usuario.datosUsuario[e]);yield this.usuarioServicio.actualizaDatoUsuario(this.usuario.id,e,o).toPromise()}if("administracion"===this.params.module){console.log("Updating user roles");var i=0;for(const o in this.roles)!1===this.roles[o]&&this.usuario.roles.find(i=>i===o)&&(yield this.usuarioServicio.deleteRoles(this.usuario.id,this.nombreRoles[i]).toPromise()),i++;for(const o in this.roles)!0!==this.roles[o]||this.usuario.roles.find(i=>i===o)||(yield this.usuarioServicio.insertarRoles(this.usuario.id,new s(o)).toPromise())}this.submitted=!0,this.params.success="El usuario ha sido actualizado satisfactoriamente."}))).then(()=>this.router.navigate([`../${this.params.module}/usuarios`])).catch(o=>{this.errorMessages.push(o),this.loading=!1})}traspasarPrestamos(){return Object(t.a)(this,void 0,void 0,(function*(){try{this.loading=!0;let o=yield this.usuarioServicio.traspasarPrestamosActivos(this.usuario.id).toPromise();console.log(o),this.params.success="Los prestamos activos se reasignaron correctamente a los avales",this.loading=!1}catch(o){this.loading=!1,this.errorMessages.push(o)}}))}register(){this.errorMessages=[];let o=0;this.loading=!0,this.modalConfirmacion.hide(),this.errorMessages=this.validationService.validarUsuario(this.usuario),this.errorMessages.length>0&&(this.loading=!1),console.log("registering"),this.usuario.datosUsuario.ANTIGUEDAD=this.datepipe.transform(this.antiguedad,"yyyy-MM-dd"),this.usuarioServicio.insertarUsuario(this.usuario).toPromise().then(i=>Object(t.a)(this,void 0,void 0,(function*(){o=i.id;for(const o in this.usuario.datosUsuario)if(void 0!==o&&void 0!==this.usuario.datosUsuario[o]){const e=this.usuario.datosUsuario[o];yield this.usuarioServicio.insertarDatoUsuario(i.id,new a(o,e)).toPromise()}for(const o in this.roles)!0===this.roles[o]&&(yield this.usuarioServicio.insertarRoles(i.id,new s(o)).toPromise());this.submitted=!0}))).then(()=>this.router.navigate([`../${this.params.module}/usuarios`])).catch(o=>{this.errorMessages.push(o),this.loading=!1})}updateRoles(){return Object(t.a)(this,void 0,void 0,(function*(){for(const o in this.roles)!1===this.roles[o]&&this.usuario.roles.find(i=>i===o)&&(yield this.usuarioServicio.deleteRoles(this.usuario.id,this.roles[o]).toPromise());for(const o in this.roles)!0!==this.roles[o]||this.usuario.roles.find(i=>i===o)||(yield this.usuarioServicio.insertarRoles(this.usuario.id,new s(o)).toPromise())}))}clearInput(){this.usuario=new n.a,this.params.success="",this.errorMessages=[],this.submitted=!1}}return o.\u0275fac=function(i){return new(i||o)(c.Rb(r.f),c.Rb(b.a),c.Rb(l.a),c.Rb(d.a),c.Rb(b.c),c.Rb(u.a))},o.\u0275cmp=c.Lb({type:o,selectors:[["cybord-usuario"]],viewQuery:function(o,i){var e;1&o&&c.Lc(m,!0),2&o&&c.uc(e=c.fc())&&(i.modalConfirmacion=e.first)},decls:169,vars:49,consts:[[1,"animated","fadeIn"],[1,"row"],[1,"col-sm-12","col-md-12"],[1,"card"],[1,"card-header"],[1,"card-body"],["class","alert alert-warning","role","alert",4,"ngIf"],[1,"col-xs-12","col-sm-12","col-md-8"],[1,"form-group","row"],[1,"col-md-3","col-form-label"],[1,"col-md-9"],["type","text","placeholder","Sobrenombre o alias",1,"form-control",3,"ngModel","ngModelChange"],["type","text","placeholder","Correo Electronico",1,"form-control",3,"ngModel","ngModelChange"],[1,"col-md-7"],[1,"switch","switch-label","switch-primary"],["type","checkbox",1,"switch-input",3,"checked","ngModel","ngModelChange"],["data-checked","ON","data-unchecked","OFF",1,"switch-slider"],[1,"col-md-7","col-form-label"],[1,"form-check"],["type","radio","name","tipo","id","radio3","value","INTERNO",1,"form-check-input",3,"checked","click"],["for","radio3",1,"form-check-label"],["type","radio","name","tipo","id","radio4","value","EXTERNO",1,"form-check-input",3,"checked","click"],["for","radio4",1,"form-check-label"],["type","text","id","no-emp","name","text-inputa","maxlength","10","placeholder","No empleado",1,"form-control",3,"ngModel","ngModelChange"],["id","office","name","office",1,"form-control",3,"ngModel","ngModelChange"],["value","*"],[3,"value",4,"ngFor","ngForOf"],["id","bank","name","bank",1,"form-control",3,"ngModel","ngModelChange"],["id","account","name","account",1,"form-control",3,"ngModel","ngModelChange"],["type","text","id","no-account","name","account","maxlength","20","minlength","8","placeholder","0000 0000 0000 0000",1,"form-control",3,"ngModel","ngModelChange"],["type","number","id","quantity","name","text-inputafg","min","1","placeholder","1.00",1,"form-control",3,"ngModel","ngModelChange"],["id","start-date","type","text","bsDatepicker","",1,"form-control",3,"maxDate","bsValue","bsConfig","maxDateChange","bsValueChange"],["dp","bsDatepicker"],["id","noAvles","name","noAvles",1,"form-control",3,"ngModel","ngModelChange"],["value","1"],["value","2"],["value","3"],["value","4"],[1,"col-xs-12","col-sm-12","col-md-4"],[1,"col-md-9","col-form-label"],["type","checkbox","value","option1","id","checkbox1",1,"form-check-input",3,"ngModel","disabled","ngModelChange"],["for","checkbox1",1,"form-check-label"],["type","checkbox","value","option1","id","checkbox2",1,"form-check-input",3,"ngModel","disabled","ngModelChange"],["for","checkbox2",1,"form-check-label"],[1,"form-check","checkbox"],["type","checkbox","value","option1","id","checkbox3",1,"form-check-input",3,"ngModel","disabled","ngModelChange"],["for","checkbox3",1,"form-check-label"],["type","checkbox","value","option1","id","checkbox4",1,"form-check-input",3,"ngModel","disabled","ngModelChange"],["for","checkbox4",1,"form-check-label"],["type","checkbox","value","option1","id","checkbox5",1,"form-check-input",3,"ngModel","disabled","ngModelChange"],["for","checkbox5",1,"form-check-label"],["type","checkbox","value","option1","id","checkbox8",1,"form-check-input",3,"ngModel","disabled","ngModelChange"],["for","checkbox8",1,"form-check-label"],["type","checkbox","value","option1","id","checkbox7",1,"form-check-input",3,"ngModel","disabled","ngModelChange"],["for","checkbox7",1,"form-check-label"],["type","checkbox","value","option1","id","checkbox6",1,"form-check-input",3,"ngModel","disabled","ngModelChange"],["for","checkbox6",1,"form-check-label"],[1,"col"],["class","btn btn-primary",3,"disabled","click",4,"ngIf"],["class","alert alert-success","role","alert",4,"ngIf"],[4,"ngIf"],[1,"card-footer"],[1,"float-right","slide_2"],["bsModal","","id","modalConfirmacion","tabindex","-1","role","dialog","aria-labelledby","modalConfirmacion","aria-hidden","true",1,"modal","fade"],["modalConfirmacion","bs-modal"],["role","document",1,"modal-dialog"],[1,"modal-content"],[1,"modal-header"],["id","modalConfirmacionLabel",1,"modal-title"],["type","button","data-dismiss","modal","aria-label","Close",1,"close",3,"click"],["aria-hidden","true"],[1,"modal-body"],["class","text-danger",4,"ngIf"],[1,"modal-footer"],["type","button","class","btn btn-primary",3,"click",4,"ngIf"],["type","button",1,"btn","btn-secondary",3,"click"],["role","alert",1,"alert","alert-warning"],[4,"ngFor","ngForOf"],[3,"value"],[1,"btn","btn-primary",3,"disabled","click"],["class","fa fa-spinner fa-spin",4,"ngIf"],[1,"fa","fa-spinner","fa-spin"],["role","alert",1,"alert","alert-success"],[1,"text-danger"],["type","button",1,"btn","btn-primary",3,"click"]],template:function(o,i){1&o&&(c.Xb(0,"div",0),c.Xb(1,"div",1),c.Xb(2,"div",2),c.Xb(3,"div",3),c.Xb(4,"div",4),c.Xb(5,"strong"),c.Gc(6,"Usuarios"),c.Wb(),c.Wb(),c.Xb(7,"div",5),c.Ec(8,X,2,1,"div",6),c.Xb(9,"div",1),c.Xb(10,"div",7),c.Xb(11,"div",8),c.Xb(12,"strong",9),c.Gc(13,"Nombre"),c.Wb(),c.Xb(14,"div",10),c.Xb(15,"input",11),c.ec("ngModelChange",(function(o){return i.usuario.nombre=o})),c.Wb(),c.Wb(),c.Wb(),c.Xb(16,"div",8),c.Xb(17,"strong",9),c.Gc(18,"Email"),c.Wb(),c.Xb(19,"div",10),c.Xb(20,"input",12),c.ec("ngModelChange",(function(o){return i.usuario.email=o})),c.Wb(),c.Wb(),c.Wb(),c.Xb(21,"div",8),c.Xb(22,"strong",9),c.Gc(23,"Usuario activo"),c.Wb(),c.Xb(24,"div",13),c.Xb(25,"label",14),c.Xb(26,"input",15),c.ec("ngModelChange",(function(o){return i.usuario.activo=o})),c.Wb(),c.Sb(27,"span",16),c.Wb(),c.Wb(),c.Wb(),c.Xb(28,"div",8),c.Xb(29,"strong",9),c.Gc(30,"Tipo Usuario"),c.Wb(),c.Xb(31,"div",17),c.Xb(32,"div",18),c.Xb(33,"input",19),c.ec("click",(function(){return i.toggleUserType()})),c.Wb(),c.Xb(34,"label",20),c.Gc(35," INTERNO "),c.Wb(),c.Wb(),c.Xb(36,"div",18),c.Xb(37,"input",21),c.ec("click",(function(){return i.toggleUserType()})),c.Wb(),c.Xb(38,"label",22),c.Gc(39," EXTERNO "),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Xb(40,"div",8),c.Xb(41,"strong",9),c.Gc(42,"No. Empleado"),c.Wb(),c.Xb(43,"div",10),c.Xb(44,"input",23),c.ec("ngModelChange",(function(o){return i.usuario.noEmpleado=o})),c.Wb(),c.Wb(),c.Wb(),c.Xb(45,"div",8),c.Xb(46,"strong",9),c.Gc(47,"Oficina"),c.Wb(),c.Xb(48,"div",13),c.Xb(49,"select",24),c.ec("ngModelChange",(function(o){return i.usuario.datosUsuario.OFICINA=o})),c.Xb(50,"option",25),c.Gc(51,"Seleccionar"),c.Wb(),c.Ec(52,W,2,2,"option",26),c.Wb(),c.Wb(),c.Wb(),c.Xb(53,"div",8),c.Xb(54,"strong",9),c.Gc(55,"BANCO"),c.Wb(),c.Xb(56,"div",13),c.Xb(57,"select",27),c.ec("ngModelChange",(function(o){return i.usuario.datosUsuario.BANCO=o})),c.Xb(58,"option",25),c.Gc(59,"Seleccionar"),c.Wb(),c.Ec(60,E,2,2,"option",26),c.Wb(),c.Wb(),c.Wb(),c.Xb(61,"div",8),c.Xb(62,"strong",9),c.Gc(63,"TIPO CUENTA"),c.Wb(),c.Xb(64,"div",13),c.Xb(65,"select",28),c.ec("ngModelChange",(function(o){return i.usuario.datosUsuario.TIPO_CUENTA=o})),c.Xb(66,"option",25),c.Gc(67,"Seleccionar"),c.Wb(),c.Ec(68,I,2,2,"option",26),c.Wb(),c.Wb(),c.Wb(),c.Xb(69,"div",8),c.Xb(70,"strong",9),c.Gc(71,"No. Cuenta"),c.Wb(),c.Xb(72,"div",10),c.Xb(73,"input",29),c.ec("ngModelChange",(function(o){return i.usuario.datosUsuario.CUENTA=o})),c.Wb(),c.Wb(),c.Wb(),c.Xb(74,"div",8),c.Xb(75,"strong",9),c.Gc(76,"Sueldo"),c.Wb(),c.Xb(77,"div",13),c.Xb(78,"input",30),c.ec("ngModelChange",(function(o){return i.usuario.datosUsuario.SUELDO=o})),c.Wb(),c.Wb(),c.Wb(),c.Xb(79,"div",8),c.Xb(80,"strong",9),c.Gc(81,"Fecha Antiguedad"),c.Wb(),c.Xb(82,"div",13),c.Xb(83,"input",31,32),c.ec("maxDateChange",(function(o){return i.maxDate=o}))("bsValueChange",(function(o){return i.antiguedad=o})),c.Wb(),c.Wb(),c.Wb(),c.Xb(85,"div",8),c.Xb(86,"strong",9),c.Gc(87,"Maximo No. avales"),c.Wb(),c.Xb(88,"div",13),c.Xb(89,"select",33),c.ec("ngModelChange",(function(o){return i.usuario.datosUsuario.NO_AVALES=o})),c.Xb(90,"option",34),c.Gc(91,"1 avales"),c.Wb(),c.Xb(92,"option",35),c.Gc(93,"2 avales"),c.Wb(),c.Xb(94,"option",36),c.Gc(95,"3 avales"),c.Wb(),c.Xb(96,"option",37),c.Gc(97,"4 avales"),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Xb(98,"div",38),c.Xb(99,"div",8),c.Xb(100,"label",9),c.Xb(101,"strong"),c.Gc(102,"Roles"),c.Wb(),c.Wb(),c.Xb(103,"div",39),c.Xb(104,"div",18),c.Xb(105,"input",40),c.ec("ngModelChange",(function(o){return i.roles.USUARIO=o})),c.Wb(),c.Xb(106,"label",41),c.Gc(107," USUARIO "),c.Wb(),c.Wb(),c.Xb(108,"div",18),c.Xb(109,"input",42),c.ec("ngModelChange",(function(o){return i.roles.RECURSOS_HUMANOS=o})),c.Wb(),c.Xb(110,"label",43),c.Gc(111," RECURSOS HUMANOS "),c.Wb(),c.Wb(),c.Xb(112,"div",44),c.Xb(113,"input",45),c.ec("ngModelChange",(function(o){return i.roles.CONTABILIDAD=o})),c.Wb(),c.Xb(114,"label",46),c.Gc(115," CONTABILIDAD "),c.Wb(),c.Wb(),c.Xb(116,"div",44),c.Xb(117,"input",47),c.ec("ngModelChange",(function(o){return i.roles.TESORERIA=o})),c.Wb(),c.Xb(118,"label",48),c.Gc(119," TESORERIA "),c.Wb(),c.Wb(),c.Xb(120,"div",44),c.Xb(121,"input",49),c.ec("ngModelChange",(function(o){return i.roles.GERENCIA_INTERNA=o})),c.Wb(),c.Xb(122,"label",50),c.Gc(123," GERENCIA INTERNA "),c.Wb(),c.Wb(),c.Xb(124,"div",44),c.Xb(125,"input",51),c.ec("ngModelChange",(function(o){return i.roles.GERENCIA_EXTERNA=o})),c.Wb(),c.Xb(126,"label",52),c.Gc(127," GERENCIA EXTERNA "),c.Wb(),c.Wb(),c.Xb(128,"div",44),c.Xb(129,"input",53),c.ec("ngModelChange",(function(o){return i.roles.DIRECCION=o})),c.Wb(),c.Xb(130,"label",54),c.Gc(131," DIRECCION "),c.Wb(),c.Wb(),c.Xb(132,"div",44),c.Xb(133,"input",55),c.ec("ngModelChange",(function(o){return i.roles.ADMINISTRACION=o})),c.Wb(),c.Xb(134,"label",56),c.Gc(135," ADMINISTRACION "),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Xb(136,"div",1),c.Sb(137,"div",57),c.Xb(138,"div",57),c.Ec(139,C,3,2,"button",58),c.Wb(),c.Sb(140,"div",57),c.Wb(),c.Wb(),c.Wb(),c.Sb(141,"br"),c.Ec(142,N,2,1,"p",59),c.Wb(),c.Ec(143,k,1,0,"cybord-loader",60),c.Xb(144,"div",61),c.Xb(145,"div",62),c.Ec(146,U,3,2,"button",58),c.Ec(147,A,3,2,"button",58),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Xb(148,"div",63,64),c.Xb(150,"div",65),c.Xb(151,"div",66),c.Xb(152,"div",67),c.Xb(153,"h5",68),c.Gc(154,"Confirmacion"),c.Wb(),c.Xb(155,"button",69),c.ec("click",(function(){return i.decline()})),c.Xb(156,"span",70),c.Gc(157,"\xd7"),c.Wb(),c.Wb(),c.Wb(),c.Xb(158,"div",71),c.Ec(159,F,2,0,"strong",60),c.Ec(160,S,2,0,"strong",60),c.Ec(161,G,2,0,"strong",72),c.Ec(162,R,2,0,"p",72),c.Wb(),c.Xb(163,"div",73),c.Ec(164,T,2,0,"button",74),c.Ec(165,x,2,0,"button",74),c.Ec(166,D,2,0,"button",74),c.Xb(167,"button",75),c.ec("click",(function(){return i.decline()})),c.Gc(168,"no"),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Wb()),2&o&&(c.Fb(8),c.nc("ngIf",i.errorMessages.length>0),c.Fb(7),c.nc("ngModel",i.usuario.nombre),c.Fb(5),c.nc("ngModel",i.usuario.email),c.Fb(6),c.nc("checked",i.usuario.activo)("ngModel",i.usuario.activo),c.Fb(7),c.nc("checked","INTERNO"===i.usuario.tipoUsuario),c.Fb(4),c.nc("checked","EXTERNO"===i.usuario.tipoUsuario),c.Fb(7),c.nc("ngModel",i.usuario.noEmpleado),c.Fb(5),c.nc("ngModel",i.usuario.datosUsuario.OFICINA),c.Fb(3),c.nc("ngForOf",i.oficinas),c.Fb(5),c.nc("ngModel",i.usuario.datosUsuario.BANCO),c.Fb(3),c.nc("ngForOf",i.bancos),c.Fb(5),c.nc("ngModel",i.usuario.datosUsuario.TIPO_CUENTA),c.Fb(3),c.nc("ngForOf",i.cuentas),c.Fb(5),c.nc("ngModel",i.usuario.datosUsuario.CUENTA),c.Fb(5),c.nc("ngModel",i.usuario.datosUsuario.SUELDO),c.Fb(5),c.nc("maxDate",i.maxDate)("bsValue",i.antiguedad)("bsConfig",c.pc(48,w)),c.Fb(6),c.nc("ngModel",i.usuario.datosUsuario.NO_AVALES),c.Fb(16),c.nc("ngModel",i.roles.USUARIO)("disabled","administracion"!==i.params.module),c.Fb(4),c.nc("ngModel",i.roles.RECURSOS_HUMANOS)("disabled","administracion"!==i.params.module),c.Fb(4),c.nc("ngModel",i.roles.CONTABILIDAD)("disabled","administracion"!==i.params.module),c.Fb(4),c.nc("ngModel",i.roles.TESORERIA)("disabled","administracion"!==i.params.module),c.Fb(4),c.nc("ngModel",i.roles.GERENCIA_INTERNA)("disabled","administracion"!==i.params.module),c.Fb(4),c.nc("ngModel",i.roles.GERENCIA_EXTERNA)("disabled","administracion"!==i.params.module),c.Fb(4),c.nc("ngModel",i.roles.DIRECCION)("disabled","administracion"!==i.params.module),c.Fb(4),c.nc("ngModel",i.roles.ADMINISTRACION)("disabled","administracion"!==i.params.module),c.Fb(6),c.nc("ngIf",void 0!==i.usuario.id),c.Fb(3),c.nc("ngIf",i.params.success.length>0),c.Fb(1),c.nc("ngIf",i.loading),c.Fb(3),c.nc("ngIf",void 0===i.usuario.id),c.Fb(1),c.nc("ngIf",void 0!==i.usuario.id),c.Fb(12),c.nc("ngIf","actualizacion"===i.operacion),c.Fb(1),c.nc("ngIf","creacion"===i.operacion),c.Fb(1),c.nc("ngIf","traspaso"===i.operacion),c.Fb(1),c.nc("ngIf","traspaso"===i.operacion),c.Fb(2),c.nc("ngIf",void 0!==i.usuario.id&&"actualizacion"===i.operacion),c.Fb(1),c.nc("ngIf",void 0===i.usuario.id&&"creacion"===i.operacion),c.Fb(1),c.nc("ngIf",void 0!==i.usuario.id&&"traspaso"===i.operacion))},directives:[r.n,g.b,g.h,g.k,g.a,g.d,g.o,g.l,g.p,r.m,g.e,g.m,h.b,h.a,f.a,p.a],styles:[""]}),o})()}}]);
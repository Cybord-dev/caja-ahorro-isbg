(window.webpackJsonp=window.webpackJsonp||[]).push([[12],{P3MA:function(o,e,i){"use strict";i.r(e),i.d(e,"ContabilidadModule",(function(){return so}));var n=i("iInd"),t=i("qNWX"),c=i("2IH+"),r=i("mrSG"),a=i("EUZL"),s=i("3JXr"),b=i("8Y7J"),l=i("LDwG"),d=i("SVse");const h=["fileInput"];function u(o,e){if(1&o&&(b.Xb(0,"tr"),b.Xb(1,"td",21),b.Gc(2),b.Wb(),b.Xb(3,"td",21),b.Gc(4),b.Wb(),b.Xb(5,"td",21),b.Gc(6),b.Wb(),b.Wb()),2&o){const o=e.$implicit;b.Fb(2),b.Ic(" ",o.noEmpleado," "),b.Fb(2),b.Ic(" ",o.nombre," "),b.Fb(2),b.Ic(" ",o.saldo," ")}}function g(o,e){1&o&&b.Sb(0,"i",22)}function f(o,e){1&o&&b.Sb(0,"i",22)}function p(o,e){if(1&o){const o=b.Yb();b.Xb(0,"div",12),b.Xb(1,"table",13),b.Xb(2,"thead",14),b.Xb(3,"tr"),b.Xb(4,"th",15),b.Gc(5,"Clave"),b.Wb(),b.Xb(6,"th",15),b.Gc(7,"Nombre"),b.Wb(),b.Xb(8,"th",15),b.Gc(9,"Importe"),b.Wb(),b.Wb(),b.Wb(),b.Xb(10,"tbody"),b.Ec(11,u,7,3,"tr",16),b.Wb(),b.Wb(),b.Xb(12,"div",17),b.Xb(13,"button",18),b.ec("click",(function(){return b.yc(o),b.gc().clean()})),b.Gc(14,"Limpiar "),b.Ec(15,g,1,0,"i",19),b.Wb(),b.Xb(16,"button",20),b.ec("click",(function(){return b.yc(o),b.gc().validar()})),b.Gc(17,"Validar "),b.Ec(18,f,1,0,"i",19),b.Wb(),b.Wb(),b.Wb()}if(2&o){const o=b.gc();b.Fb(11),b.nc("ngForOf",o.datosConciliacion),b.Fb(2),b.nc("disabled",o.loading),b.Fb(2),b.nc("ngIf",o.loading),b.Fb(1),b.nc("disabled",o.loading),b.Fb(2),b.nc("ngIf",o.loading)}}function m(o,e){1&o&&(b.Xb(0,"h3"),b.Gc(1," Ahorradores Validados"),b.Wb())}function v(o,e){if(1&o&&(b.Xb(0,"tr"),b.Xb(1,"td",21),b.Gc(2),b.Wb(),b.Xb(3,"td",21),b.Gc(4),b.hc(5,"uppercase"),b.Wb(),b.Xb(6,"td",21),b.Gc(7),b.Wb(),b.Xb(8,"td",21),b.Gc(9," Validado "),b.Wb(),b.Wb()),2&o){const o=e.$implicit;b.Fb(2),b.Ic(" ",o.noEmpleado," "),b.Fb(2),b.Ic(" ",b.ic(5,3,o.nombre)," "),b.Fb(3),b.Ic(" ",o.saldo," ")}}function X(o,e){if(1&o&&(b.Xb(0,"table",13),b.Xb(1,"thead",14),b.Xb(2,"tr"),b.Xb(3,"th",15),b.Gc(4,"Clave"),b.Wb(),b.Xb(5,"th",15),b.Gc(6,"Nombre"),b.Wb(),b.Xb(7,"th",15),b.Gc(8,"Importe"),b.Wb(),b.Xb(9,"th",15),b.Gc(10,"Observaciones"),b.Wb(),b.Wb(),b.Wb(),b.Xb(11,"tbody"),b.Ec(12,v,10,5,"tr",16),b.Wb(),b.Wb()),2&o){const o=b.gc(2);b.Fb(12),b.nc("ngForOf",o.conciliacionCorrectos)}}function W(o,e){1&o&&(b.Xb(0,"h3"),b.Gc(1," Ahorradores No Validados"),b.Wb())}const F=function(o){return{"alert-danger":o}};function I(o,e){if(1&o&&(b.Xb(0,"tr",26),b.Xb(1,"td",21),b.Gc(2),b.Wb(),b.Xb(3,"td",21),b.Gc(4),b.hc(5,"uppercase"),b.Wb(),b.Xb(6,"td",21),b.Gc(7),b.Wb(),b.Xb(8,"td",21),b.Gc(9),b.hc(10,"uppercase"),b.Wb(),b.Wb()),2&o){const o=e.$implicit;b.nc("ngClass",b.qc(9,F,"Validado"!=o.observaciones)),b.Fb(2),b.Ic(" ",o.noEmpleado," "),b.Fb(2),b.Ic(" ",b.ic(5,5,o.nombre)," "),b.Fb(3),b.Ic(" ",o.saldo," "),b.Fb(2),b.Ic(" ",b.ic(10,7,o.observaciones)," ")}}function G(o,e){if(1&o&&(b.Xb(0,"table",13),b.Xb(1,"thead",14),b.Xb(2,"tr"),b.Xb(3,"th",15),b.Gc(4,"Clave"),b.Wb(),b.Xb(5,"th",15),b.Gc(6,"Nombre"),b.Wb(),b.Xb(7,"th",15),b.Gc(8,"Importe"),b.Wb(),b.Xb(9,"th",15),b.Gc(10,"Observaciones"),b.Wb(),b.Wb(),b.Wb(),b.Xb(11,"tbody"),b.Ec(12,I,11,11,"tr",25),b.Wb(),b.Wb()),2&o){const o=b.gc(2);b.Fb(12),b.nc("ngForOf",o.conciliacionErroneos)}}function y(o,e){1&o&&b.Sb(0,"i",22)}function E(o,e){if(1&o){const o=b.Yb();b.Xb(0,"div",12),b.Ec(1,m,2,0,"h3",23),b.Ec(2,X,13,1,"table",24),b.Ec(3,W,2,0,"h3",23),b.Ec(4,G,13,1,"table",24),b.Xb(5,"div",17),b.Xb(6,"button",18),b.ec("click",(function(){return b.yc(o),b.gc().clean()})),b.Gc(7,"Limpiar "),b.Ec(8,y,1,0,"i",19),b.Wb(),b.Wb(),b.Wb()}if(2&o){const o=b.gc();b.Fb(1),b.nc("ngIf",o.conciliacionCorrectos.length>0),b.Fb(1),b.nc("ngIf",o.conciliacionCorrectos.length>0),b.Fb(1),b.nc("ngIf",o.conciliacionErroneos.length>0),b.Fb(1),b.nc("ngIf",o.conciliacionErroneos.length>0),b.Fb(2),b.nc("disabled",o.loading),b.Fb(2),b.nc("ngIf",o.loading)}}let C=(()=>{class o{constructor(o){this.ahorroService=o,this.datosConciliacion=[],this.conciliacionProcesados=[],this.conciliacionCorrectos=[],this.conciliacionErroneos=[],this.loading=!1}ngOnInit(){}onFileChange(o){this.loading=!0;let e=null,i=null;const n=new FileReader,t=o[0];n.onload=o=>{const t=n.result;let c;for(c in e=a.read(t,{type:"binary"}),i=e.SheetNames.reduce((o,i)=>{const n=e.Sheets[i];return o[i]=a.utils.sheet_to_json(n,{range:16}),a.utils.sheet_to_json(n),o},{}),i);const r=i[c];for(const e of r){const o=JSON.parse(JSON.stringify(e)),i=Object.keys(o);if(3===Object.keys(o).length&&!String(e[i[0]]).includes("Dedu")){let o=String(e[i[2]]);o=o.replace(",","");const n=new s.a(e[i[0]],e[i[1]],parseInt(o,10));this.datosConciliacion.push(n)}}},n.readAsBinaryString(t),this.loading=!1}validar(){return Object(r.a)(this,void 0,void 0,(function*(){this.loading=!0,this.conciliacionProcesados=this.datosConciliacion,this.datosConciliacion=[],console.log("Request "+JSON.stringify(this.conciliacionProcesados)),this.loading=!1}))}clean(){this.fileInput.nativeElement.value=null,this.datosConciliacion=[],this.conciliacionProcesados=[],this.conciliacionCorrectos=[],this.conciliacionErroneos=[],this.loading=!1}}return o.\u0275fac=function(e){return new(e||o)(b.Rb(l.a))},o.\u0275cmp=b.Lb({type:o,selectors:[["cybord-conciliacion-conta"]],viewQuery:function(o,e){var i;1&o&&b.Lc(h,!0),2&o&&b.uc(i=b.fc())&&(e.fileInput=i.first)},decls:16,vars:2,consts:[[1,"animated","fadeIn"],[1,"row"],[1,"col"],[1,"card"],[1,"card-header"],[1,"card-body"],[1,"form-group","row"],["for","file-input",1,"col-md-2","col-form-label"],[1,"col-md-9"],["id","file-input","type","file","accept",".xlsx, .xls, .csv  ","name","file-input",1,"file-input",3,"change"],["fileInput",""],["class","table-responsive slide_1",4,"ngIf"],[1,"table-responsive","slide_1"],[1,"table","table-bordered","table-sm"],[1,"thead-dark"],["scope","col",1,"text-center"],[4,"ngFor","ngForOf"],[1,"col-sm-6"],[1,"btn","btn-warning",3,"disabled","click"],["class","fa fa-spinner fa-spin",4,"ngIf"],[1,"btn","btn-success",3,"disabled","click"],["scope","row",1,"text-left"],[1,"fa","fa-spinner","fa-spin"],[4,"ngIf"],["class","table table-bordered table-sm",4,"ngIf"],[3,"ngClass",4,"ngFor","ngForOf"],[3,"ngClass"]],template:function(o,e){1&o&&(b.Xb(0,"div",0),b.Xb(1,"div",1),b.Xb(2,"div",2),b.Xb(3,"div",3),b.Xb(4,"div",4),b.Xb(5,"strong"),b.Gc(6,"Conciliacion"),b.Wb(),b.Wb(),b.Xb(7,"div",5),b.Xb(8,"div",6),b.Xb(9,"label",7),b.Gc(10,"Subir Archivo"),b.Wb(),b.Xb(11,"div",8),b.Xb(12,"input",9,10),b.ec("change",(function(o){return e.onFileChange(o.target.files)})),b.Wb(),b.Wb(),b.Wb(),b.Ec(14,p,19,5,"div",11),b.Ec(15,E,9,6,"div",11),b.Wb(),b.Wb(),b.Wb(),b.Wb(),b.Wb()),2&o&&(b.Fb(14),b.nc("ngIf",e.datosConciliacion.length>0),b.Fb(1),b.nc("ngIf",e.conciliacionProcesados.length>0))},directives:[d.n,d.m,d.l],pipes:[d.w],styles:[""]}),o})();class S{constructor(o,e,i,n){this.validado=o,this.numeroUsuario=e,this.nombre=i,this.importe=n}}var w=i("eHCh"),O=i("ESM5"),x=i("LqlI"),A=i("xkgV"),k=i("jksu");const N=["modalConfirmacion"],j=["fileInput"];function U(o,e){if(1&o&&(b.Xb(0,"p"),b.Gc(1),b.Wb()),2&o){const o=e.$implicit;b.Fb(1),b.Hc(o)}}function P(o,e){if(1&o&&(b.Xb(0,"div",27),b.Ec(1,U,2,1,"p",28),b.Wb()),2&o){const o=b.gc();b.Fb(1),b.nc("ngForOf",o.errorMessages)}}const V=function(o){return{"alert-danger":o}};function L(o,e){if(1&o&&(b.Xb(0,"tr",38),b.Xb(1,"td",39),b.Gc(2),b.Wb(),b.Xb(3,"td",40),b.Gc(4),b.Wb(),b.Xb(5,"td",40),b.Gc(6),b.hc(7,"uppercase"),b.Wb(),b.Xb(8,"td",41),b.Gc(9),b.hc(10,"currency"),b.Wb(),b.Xb(11,"td",40),b.Gc(12),b.hc(13,"uppercase"),b.Wb(),b.Wb()),2&o){const o=e.$implicit,i=e.index,n=b.gc(2);b.nc("ngClass",b.qc(12,V,"Validado"!=o.observaciones)),b.Fb(2),b.Ic(" ",10*(n.pExternos-1)+i+1,""),b.Fb(2),b.Ic(" ",o.numeroUsuario," "),b.Fb(2),b.Ic(" ",b.ic(7,6,o.nombre)," "),b.Fb(3),b.Ic(" ",b.ic(10,8,o.importe)," "),b.Fb(3),b.Ic(" ",b.ic(13,10,o.observaciones)," ")}}function R(o,e){1&o&&b.Sb(0,"i",42)}function _(o,e){1&o&&b.Sb(0,"i",42)}const M=function(o){return{id:"externos",itemsPerPage:10,currentPage:o}};function q(o,e){if(1&o){const o=b.Yb();b.Xb(0,"div",29),b.Xb(1,"table",30),b.Xb(2,"thead",31),b.Xb(3,"tr"),b.Xb(4,"th",32),b.Gc(5,"No."),b.Wb(),b.Xb(6,"th",32),b.Gc(7,"Clave"),b.Wb(),b.Xb(8,"th",32),b.Gc(9,"Nombre"),b.Wb(),b.Xb(10,"th",32),b.Gc(11,"Importe"),b.Wb(),b.Xb(12,"th",32),b.Gc(13,"Observaciones"),b.Wb(),b.Wb(),b.Wb(),b.Xb(14,"tbody"),b.Ec(15,L,14,14,"tr",33),b.hc(16,"paginate"),b.Wb(),b.Wb(),b.Xb(17,"pagination-controls",34),b.ec("pageChange",(function(e){return b.yc(o),b.gc().pExternos=e})),b.Wb(),b.Xb(18,"div",35),b.Xb(19,"button",36),b.ec("click",(function(){return b.yc(o),b.gc().clean()})),b.Gc(20,"Limpiar "),b.Ec(21,R,1,0,"i",25),b.Wb(),b.Xb(22,"button",37),b.ec("click",(function(){return b.yc(o),b.gc().openModal()})),b.Gc(23,"Cargar "),b.Ec(24,_,1,0,"i",25),b.Wb(),b.Wb(),b.Wb()}if(2&o){const o=b.gc();b.Fb(15),b.nc("ngForOf",b.jc(16,5,o.datosAhorro,b.qc(8,M,o.pExternos))),b.Fb(4),b.nc("disabled",o.loading),b.Fb(2),b.nc("ngIf",o.loading),b.Fb(1),b.nc("disabled",!o.tablaValida),b.Fb(2),b.nc("ngIf",o.loading)}}function B(o,e){if(1&o&&(b.Xb(0,"tr",38),b.Xb(1,"td",39),b.Gc(2),b.Wb(),b.Xb(3,"td",40),b.Gc(4),b.Wb(),b.Xb(5,"td",40),b.Gc(6),b.hc(7,"uppercase"),b.Wb(),b.Xb(8,"td",40),b.Gc(9),b.hc(10,"uppercase"),b.Wb(),b.Wb()),2&o){const o=e.$implicit,i=e.index,n=b.gc(2);b.nc("ngClass",b.qc(9,V,"Validado"!=o.observaciones)),b.Fb(2),b.Ic(" ",10*(n.pErrores-1)+i+1,""),b.Fb(2),b.Ic(" ",o.noEmpleado," "),b.Fb(2),b.Ic(" ",b.ic(7,5,o.nombre)," "),b.Fb(3),b.Ic(" ",b.ic(10,7,o.observaciones)," ")}}function J(o,e){1&o&&b.Sb(0,"i",42)}const $=function(o){return{id:"errores",itemsPerPage:10,currentPage:o}};function H(o,e){if(1&o){const o=b.Yb();b.Xb(0,"div",29),b.Xb(1,"h3"),b.Gc(2," Ahorradores con Errores"),b.Wb(),b.Xb(3,"table",30),b.Xb(4,"thead",31),b.Xb(5,"tr"),b.Xb(6,"th",32),b.Gc(7,"No."),b.Wb(),b.Xb(8,"th",32),b.Gc(9,"Clave"),b.Wb(),b.Xb(10,"th",32),b.Gc(11,"Nombre"),b.Wb(),b.Xb(12,"th",32),b.Gc(13,"Observaciones"),b.Wb(),b.Wb(),b.Wb(),b.Xb(14,"tbody"),b.Ec(15,B,11,11,"tr",33),b.hc(16,"paginate"),b.Wb(),b.Wb(),b.Xb(17,"pagination-controls",43),b.ec("pageChange",(function(e){return b.yc(o),b.gc().pErrores=e})),b.Wb(),b.Xb(18,"div",35),b.Xb(19,"button",36),b.ec("click",(function(){return b.yc(o),b.gc().limpiarErrores()})),b.Gc(20,"Limpiar "),b.Ec(21,J,1,0,"i",25),b.Wb(),b.Wb(),b.Wb()}if(2&o){const o=b.gc();b.Fb(15),b.nc("ngForOf",b.jc(16,3,o.erroresAhorro,b.qc(6,$,o.pErrores))),b.Fb(4),b.nc("disabled",o.loading),b.Fb(2),b.nc("ngIf",o.loading)}}function Y(o,e){1&o&&b.Sb(0,"cybord-loader")}function D(o,e){1&o&&b.Sb(0,"i",42)}function Q(o,e){1&o&&b.Sb(0,"i",42)}let T=(()=>{class o{constructor(o,e,i){this.renderer=o,this.userService=e,this.ahorroService=i,this.errorMessages=[],this.loading=!1,this.tablaValida=!0,this.pExternos=1,this.pErrores=1}ngOnInit(){this.datosAhorro=new Array,this.erroresAhorro=new Array}onFileChange(o){if(0===o.length)return;this.tablaValida=!0,this.loading=!0;let e=null,i=null;const n=new FileReader,t=o[0];n.onload=o=>{const t=n.result;let c;for(c in e=a.read(t,{type:"binary"}),i=e.SheetNames.reduce((o,i)=>{const n=e.Sheets[i];return o[i]=a.utils.sheet_to_json(n,{range:3}),a.utils.sheet_to_json(n),o},{}),i);this.cargarValidar(i[c])},n.readAsBinaryString(t)}cargarValidar(o){return Object(r.a)(this,void 0,void 0,(function*(){const e=Object.keys(o[0]);for(const n of o){const o=!1;let t;if(void 0!==n[e[0]]){const c=new S(!o,n[e[0]],n[e[1]],n[e[2]]);this.datosAhorro.push(c);try{t=yield this.userService.getUsuarioByNumeroUsuario(n[e[0]]).toPromise(),this.validar(t,c)}catch(i){c.observaciones=" No es valida la clave del ahorrador ",this.tablaValida=!1}}}this.loading=!1}))}clean(){this.fileInput.nativeElement.value=null,this.datosAhorro=new Array,this.errorMessages=[]}cargar(){const o=new Array;this.loading=!0,this.datosAhorro.forEach(e=>{const i=new w.a;i.idUsuario=e.idUsuario,i.tipo="ahorro",i.monto=e.importe,i.validado=!0,o.push(i)}),this.ahorroService.postSaldoBulk(o).toPromise().then(o=>{this.erroresAhorro=o.errores,alert("Se registraron depositos de "+o.correctos.length+" ahorradores \nSe tienen "+o.errores.length+" errores"),this.clean(),this.modalConfirmacion.hide()}).then(o=>{this.loading=!1}).catch(o=>{alert("Se registro un error al cargar los ahorros "+o),this.clean(),this.modalConfirmacion.hide(),this.loading=!1})}limpiarErrores(){this.erroresAhorro=[]}validar(o,e){e.idUsuario=o.content[0].id;let i=!0,n=o.content[0].nombre.trim();n=n.toUpperCase();let t=n.split(" ");t=t.sort();let c=e.nombre.trim();c=c.toUpperCase();let r=c.split(" ");r=r.sort(),t.length===r.length&&t.every((function(o,e){return o===r[e]}))||(this.agregarObservacion(e,"No coincide el nombre del ahorrador"),i=!1),o.content[0].activo||(this.agregarObservacion(e,"El ahorrador no esta activo"),i=!1),"EXTERNO"!==o.content[0].tipoUsuario&&(this.agregarObservacion(e,"El usuario no es externo"),i=!1),o.content[0].ahorrador||(this.agregarObservacion(e,"El usuario no es ahorrador"),i=!1),(void 0===e.importe||isNaN(e.importe))&&(this.agregarObservacion(e,"El importe no es correcto"),i=!1),e.importe!=o.content[0].montoAhorro&&(this.agregarObservacion(e,"El importe no es correcto"),i=!1),void 0===e.observaciones&&this.agregarObservacion(e,"Validado"),i||(this.tablaValida=!1)}agregarObservacion(o,e){void 0===o.observaciones?o.observaciones=e:o.observaciones+=", "+e}openModal(){this.modalConfirmacion.show()}decline(){this.modalConfirmacion.hide()}}return o.\u0275fac=function(e){return new(e||o)(b.Rb(b.K),b.Rb(O.a),b.Rb(l.a))},o.\u0275cmp=b.Lb({type:o,selectors:[["cybord-ahorro-externos"]],viewQuery:function(o,e){var i;1&o&&(b.Lc(N,!0),b.Lc(j,!0)),2&o&&(b.uc(i=b.fc())&&(e.modalConfirmacion=i.first),b.uc(i=b.fc())&&(e.fileInput=i.first))},decls:37,vars:8,consts:[[1,"animated","fadeIn"],[1,"row"],[1,"col"],[1,"card"],[1,"card-header"],[1,"card-body"],["class","alert alert-danger","role","alert",4,"ngIf"],[1,"form-group","row"],["for","file-input",1,"col-md-2","col-form-label"],[1,"col-md-9"],["id","file-input","type","file","accept",".xlsx, .xls, .csv  ","name","file-input",1,"file-input",3,"change"],["fileInput",""],["class","table-responsive slide_1",4,"ngIf"],[4,"ngIf"],["bsModal","","id","modalConfirmacion","tabindex","-1","role","dialog","aria-labelledby","modalConfirmacion","aria-hidden","true",1,"modal","fade"],["modalConfirmacion","bs-modal"],["role","document",1,"modal-dialog"],[1,"modal-content"],[1,"modal-header"],["id","modalConfirmacionLabel",1,"modal-title"],["type","button","data-dismiss","modal","aria-label","Close",1,"close",3,"click"],["aria-hidden","true"],[1,"modal-body"],[1,"modal-footer"],["type","button",1,"btn","btn-primary",3,"disabled","click"],["class","fa fa-spinner fa-spin",4,"ngIf"],["type","button",1,"btn","btn-secondary",3,"disabled","click"],["role","alert",1,"alert","alert-danger"],[4,"ngFor","ngForOf"],[1,"table-responsive","slide_1"],[1,"table","table-bordered","table-sm"],[1,"thead-dark"],["scope","col",1,"text-center"],[3,"ngClass",4,"ngFor","ngForOf"],["id","externos","previousLabel","Anterior","nextLabel","Siguiente","autoHide","true",3,"pageChange"],[1,"col-sm-6"],[1,"btn","btn-warning",3,"disabled","click"],[1,"btn","btn-success",3,"disabled","click"],[3,"ngClass"],["scope","row",1,"text-center"],["scope","row",1,"text-left"],["scope","row",1,"text-right"],[1,"fa","fa-spinner","fa-spin"],["id","errores","previousLabel","Anterior","nextLabel","Siguiente",3,"pageChange"]],template:function(o,e){1&o&&(b.Xb(0,"div",0),b.Xb(1,"div",1),b.Xb(2,"div",2),b.Xb(3,"div",3),b.Xb(4,"div",4),b.Xb(5,"strong"),b.Gc(6,"Carga de ahorro externos"),b.Wb(),b.Wb(),b.Xb(7,"div",5),b.Ec(8,P,2,1,"div",6),b.Xb(9,"div",7),b.Xb(10,"label",8),b.Gc(11,"Subir Archivo"),b.Wb(),b.Xb(12,"div",9),b.Xb(13,"input",10,11),b.ec("change",(function(o){return e.onFileChange(o.target.files)})),b.Wb(),b.Wb(),b.Wb(),b.Ec(15,q,25,10,"div",12),b.Ec(16,H,22,8,"div",12),b.Ec(17,Y,1,0,"cybord-loader",13),b.Wb(),b.Wb(),b.Wb(),b.Wb(),b.Wb(),b.Xb(18,"div",14,15),b.Xb(20,"div",16),b.Xb(21,"div",17),b.Xb(22,"div",18),b.Xb(23,"h5",19),b.Gc(24,"Confirmacion"),b.Wb(),b.Xb(25,"button",20),b.ec("click",(function(){return e.decline()})),b.Xb(26,"span",21),b.Gc(27,"\xd7"),b.Wb(),b.Wb(),b.Wb(),b.Xb(28,"div",22),b.Gc(29," \xbfResgistrar ahorros externos? "),b.Wb(),b.Xb(30,"div",23),b.Xb(31,"button",24),b.ec("click",(function(){return e.cargar()})),b.Gc(32,"Si "),b.Ec(33,D,1,0,"i",25),b.Wb(),b.Xb(34,"button",26),b.ec("click",(function(){return e.decline()})),b.Gc(35,"No "),b.Ec(36,Q,1,0,"i",25),b.Wb(),b.Wb(),b.Wb(),b.Wb(),b.Wb()),2&o&&(b.Fb(8),b.nc("ngIf",e.errorMessages.length>0),b.Fb(7),b.nc("ngIf",e.datosAhorro.length>0),b.Fb(1),b.nc("ngIf",e.erroresAhorro.length>0),b.Fb(1),b.nc("ngIf",e.loading),b.Fb(14),b.nc("disabled",e.loading),b.Fb(2),b.nc("ngIf",e.loading),b.Fb(1),b.nc("disabled",e.loading),b.Fb(2),b.nc("ngIf",e.loading))},directives:[d.n,x.a,d.m,A.c,d.l,k.a],pipes:[A.b,d.w,d.d],styles:[""]}),o})();var K=i("aBT+"),Z=i("uwdg"),z=i("+vBq"),oo=i("aJ9a"),eo=i("v/Gv"),io=i("xkWA"),no=i("2jvo"),to=i("8vkG");const co=[{path:"usuarios",component:K.a,data:{title:"Usuarios"}},{path:"usuarios/:idUsuario",component:Z.a,data:{title:"Usario ISBG"}},{path:"saldo-ahorro/:idUsuario",component:io.a,data:{title:"Ahorro usuario"}},{path:"prestamos-activos/:idUsuario",component:to.a,data:{title:"Prestamos usuario"}},{path:"validaciones",component:t.a,data:{title:"Reporte Validaciones"}},{path:"validacion/:idSolicitud",component:z.a,data:{title:"Usario ISBG"}},{path:"historico/:idSolicitud",component:z.a,data:{title:"Usario ISBG"}},{path:"historico",component:c.a,data:{title:"Historico validaciones"}},{path:"conciliacion",component:C,data:{title:"Conciliaciones Contabilidad"}},{path:"carga-ahorro",component:T,data:{title:"Ahorro usuarios externos"}},{path:"reportes-ahorro",component:oo.a,data:{title:"Reporte de ahorro caja"}},{path:"reportes-prestamo",component:no.a,data:{title:"Reporte de prestamos caja"}},{path:"ajustes/:idUsuario",component:eo.a,data:{title:"Ajustes de usuario"}}];let ro=(()=>{class o{}return o.\u0275mod=b.Pb({type:o}),o.\u0275inj=b.Ob({factory:function(e){return new(e||o)},imports:[[n.g.forChild(co)],n.g]}),o})();var ao=i("65jD");let so=(()=>{class o{}return o.\u0275mod=b.Pb({type:o}),o.\u0275inj=b.Ob({factory:function(e){return new(e||o)},imports:[[ao.CommonsPagesModule,ro,A.a]]}),o})()}}]);
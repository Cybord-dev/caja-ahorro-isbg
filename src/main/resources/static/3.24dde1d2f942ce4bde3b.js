(window.webpackJsonp=window.webpackJsonp||[]).push([[3],{"27T3":function(e,t,a){"use strict";a.d(t,"a",(function(){return o}));class o{constructor(){}}},"2jvo":function(e,t,a){"use strict";a.d(t,"a",(function(){return j}));var o=a("mrSG"),n=a("EwKM"),i=a("27T3"),c=a("KZhB"),r=a("8Y7J"),b=a("iInd"),s=a("SVse"),l=a("q+li"),d=a("oxVP"),p=a("bEsI"),g=a("cUpR"),f=a("ESM5"),u=a("s7LF"),h=a("ienR"),m=a("LqlI"),X=a("jksu");const W=["modalConfirmacion"];function v(e,t){1&e&&r.Sb(0,"i",54)}function y(e,t){1&e&&(r.Xb(0,"div",55),r.Gc(1," No se encontraron resultados "),r.Wb())}function G(e,t){1&e&&(r.Xb(0,"option",65),r.Gc(1,"20"),r.Wb())}function E(e,t){1&e&&(r.Xb(0,"option",66),r.Gc(1,"50"),r.Wb())}function I(e,t){if(1&e){const e=r.Yb();r.Xb(0,"select",61),r.ec("ngModelChange",(function(t){return r.yc(e),r.gc(2).filterParams.size=t}))("change",(function(t){return r.yc(e),r.gc(2).onChangePageSize(t.target.value)})),r.Xb(1,"option",62),r.Gc(2,"10"),r.Wb(),r.Ec(3,G,2,0,"option",63),r.Ec(4,E,2,0,"option",64),r.Wb()}if(2&e){const e=r.gc(2);r.nc("ngModel",e.filterParams.size),r.Fb(3),r.nc("ngIf",e.page.number<e.page.totalElements/20),r.Fb(1),r.nc("ngIf",e.page.number<e.page.totalElements/50)}}function P(e,t){if(1&e){const e=r.Yb();r.Xb(0,"div",56),r.Xb(1,"button",57),r.ec("click",(function(){return r.yc(e),r.gc().downloadXLSFile()})),r.Sb(2,"i",58),r.Wb(),r.Ec(3,I,5,3,"select",59),r.Xb(4,"strong",60),r.Gc(5," Tama\xf1o Pagina \xa0\xa0\xa0\xa0"),r.Wb(),r.Wb()}if(2&e){const e=r.gc();r.Fb(3),r.nc("ngIf",0==e.page.last||1==e.page.first)}}function F(e,t){1&e&&(r.Xb(0,"p"),r.Gc(1,"SI"),r.Wb())}function M(e,t){1&e&&(r.Xb(0,"p"),r.Gc(1,"NO"),r.Wb())}const C=function(e,t){return{"btn-success":e,"btn-secondary":t}};function S(e,t){if(1&e){const e=r.Yb();r.Xb(0,"tr"),r.Xb(1,"td",71),r.Xb(2,"button",72),r.ec("click",(function(){r.yc(e);const a=t.$implicit;return r.gc(2).openModal(a)})),r.Sb(3,"i",73),r.Wb(),r.Wb(),r.Xb(4,"td",74),r.Ec(5,F,2,0,"p",30),r.Ec(6,M,2,0,"p",30),r.Wb(),r.Xb(7,"td",75),r.Gc(8),r.hc(9,"currency"),r.Wb(),r.Xb(10,"td",74),r.Gc(11),r.Wb(),r.Xb(12,"td",74),r.Gc(13),r.hc(14,"percent"),r.Wb(),r.Xb(15,"td",74),r.Gc(16),r.Wb(),r.Xb(17,"td",74),r.Gc(18),r.Wb(),r.Xb(19,"td",75),r.Gc(20),r.hc(21,"currency"),r.Wb(),r.Xb(22,"td",75),r.Gc(23),r.hc(24,"currency"),r.Wb(),r.Xb(25,"td",74),r.Gc(26),r.Wb(),r.Xb(27,"td",74),r.Gc(28),r.Wb(),r.Xb(29,"td",74),r.Gc(30),r.Wb(),r.Xb(31,"td",74),r.Gc(32),r.hc(33,"date"),r.Wb(),r.Xb(34,"td",74),r.Gc(35),r.hc(36,"date"),r.Wb(),r.Wb()}if(2&e){const e=t.$implicit,a=r.gc(2);r.Fb(2),r.nc("ngClass",r.rc(30,C,!e.validado,e.validado))("disabled",e.validado||a.loading),r.Fb(3),r.nc("ngIf",e.validado),r.Fb(1),r.nc("ngIf",!e.validado),r.Fb(2),r.Hc(r.ic(9,16,e.monto)),r.Fb(3),r.Hc(e.noQuincenas),r.Fb(2),r.Hc(r.ic(14,18,e.tasaInteres/100)),r.Fb(3),r.Hc(e.noEmpleado),r.Fb(2),r.Hc(e.nombreEmpleado),r.Fb(2),r.Hc(r.ic(21,20,e.montoPrestamo)),r.Fb(3),r.Hc(r.ic(24,22,e.saldoPendiente)),r.Fb(3),r.Hc(e.tipo),r.Fb(2),r.Hc(e.estatus),r.Fb(2),r.Hc(e.origen),r.Fb(2),r.Hc(r.jc(33,24,e.fechaCreacion,"dd/MM/yyyy HH:mm")),r.Fb(3),r.Hc(r.jc(36,27,e.fechaActualizacion,"dd/MM/yyyy HH:mm"))}}function A(e,t){if(1&e&&(r.Xb(0,"div",67),r.Xb(1,"table",42),r.Xb(2,"thead",68),r.Xb(3,"tr"),r.Xb(4,"th",69),r.Gc(5,"APROBACION"),r.Wb(),r.Xb(6,"th",69),r.Gc(7,"PAGO VALIDADO"),r.Wb(),r.Xb(8,"th",69),r.Gc(9,"MONTO PAGO"),r.Wb(),r.Xb(10,"th",69),r.Gc(11,"NO QUINCENAS"),r.Wb(),r.Xb(12,"th",69),r.Gc(13,"TASA"),r.Wb(),r.Xb(14,"th",69),r.Gc(15,"NO EMPLEADO"),r.Wb(),r.Xb(16,"th",69),r.Gc(17,"NOMBRE"),r.Wb(),r.Xb(18,"th",69),r.Gc(19,"MONTO PRESTAMO"),r.Wb(),r.Xb(20,"th",69),r.Gc(21,"SALDO PENDIENTE"),r.Wb(),r.Xb(22,"th",69),r.Gc(23,"TIPO"),r.Wb(),r.Xb(24,"th",69),r.Gc(25,"ESTATUS"),r.Wb(),r.Xb(26,"th",69),r.Gc(27,"MODIFICADO"),r.Wb(),r.Xb(28,"th",69),r.Gc(29,"CREACION"),r.Wb(),r.Xb(30,"th",69),r.Gc(31,"ACTUALIZACION"),r.Wb(),r.Wb(),r.Wb(),r.Xb(32,"tbody"),r.Ec(33,S,37,33,"tr",70),r.Wb(),r.Wb(),r.Wb()),2&e){const e=r.gc();r.Fb(33),r.nc("ngForOf",e.page.content)}}function w(e,t){if(1&e){const e=r.Yb();r.Xb(0,"li",81),r.Xb(1,"button",82),r.ec("click",(function(){r.yc(e);const t=r.gc(3);return t.updateDataTable(0,t.page.size)})),r.Sb(2,"i",83),r.Wb(),r.Wb()}}function O(e,t){if(1&e){const e=r.Yb();r.Xb(0,"li",81),r.Xb(1,"button",82),r.ec("click",(function(){r.yc(e);const t=r.gc(3);return t.updateDataTable(t.page.number-1,t.page.size)})),r.Gc(2),r.Wb(),r.Wb()}if(2&e){const e=r.gc(3);r.Fb(2),r.Hc(e.page.number)}}function T(e,t){if(1&e){const e=r.Yb();r.Xb(0,"li",81),r.Xb(1,"button",82),r.ec("click",(function(){r.yc(e);const t=r.gc(3);return t.updateDataTable(t.page.number+1,t.page.size)})),r.Gc(2),r.Wb(),r.Wb()}if(2&e){const e=r.gc(3);r.Fb(2),r.Hc(e.page.number+2)}}function R(e,t){if(1&e){const e=r.Yb();r.Xb(0,"li",81),r.Xb(1,"button",82),r.ec("click",(function(){r.yc(e);const t=r.gc(3);return t.updateDataTable(t.page.totalPages-1,t.page.size)})),r.Sb(2,"i",84),r.Wb(),r.Wb()}}function k(e,t){if(1&e&&(r.Xb(0,"ul",77),r.Ec(1,w,3,0,"li",78),r.Ec(2,O,3,1,"li",78),r.Xb(3,"li",79),r.Xb(4,"a",80),r.Xb(5,"strong"),r.Gc(6),r.Wb(),r.Wb(),r.Wb(),r.Ec(7,T,3,1,"li",78),r.Ec(8,R,3,0,"li",78),r.Wb()),2&e){const e=r.gc(2);r.Fb(1),r.nc("ngIf",0==e.page.first),r.Fb(1),r.nc("ngIf",0==e.page.first),r.Fb(4),r.Hc(e.page.number+1),r.Fb(1),r.nc("ngIf",0==e.page.last),r.Fb(1),r.nc("ngIf",0==e.page.last)}}function D(e,t){if(1&e&&(r.Xb(0,"div",56),r.Ec(1,k,9,5,"ul",76),r.Wb()),2&e){const e=r.gc();r.Fb(1),r.nc("ngIf",e.page.totalElements>1)}}function H(e,t){1&e&&r.Sb(0,"cybord-loader")}function N(e,t){if(1&e&&r.Sb(0,"img",85),2&e){const e=r.gc();r.nc("src",e.comprobanteUrl,r.Ac)}}function x(e,t){1&e&&(r.Xb(0,"h5",86),r.Gc(1,"SIN COMPROBANTE DE PAGO"),r.Wb())}function z(e,t){if(1&e&&(r.Xb(0,"div",87),r.Xb(1,"p"),r.Gc(2),r.Wb(),r.Wb()),2&e){const e=r.gc();r.Fb(2),r.Hc(e.message)}}function U(e,t){if(1&e){const e=r.Yb();r.Xb(0,"button",88),r.ec("click",(function(){return r.yc(e),r.gc().downloadImage()})),r.Gc(1,"Descargar comprobante"),r.Wb()}}const L=function(){return{standalone:!0}},B=function(e,t){return{"btn-primary":e,"btn-secondary":t}};let j=(()=>{class e{constructor(e,t,a,o,r,b,s){this.router=e,this.datepipe=t,this.downloadService=a,this.resourcesService=o,this.prestamoService=r,this.sanitizer=b,this.userService=s,this.module="usuarios",this.page=new n.a,this.pageSize="10",this.filterParams={no_Quincenas:"",estatus:"*",noEmpleado:"",since:"",to:"",page:"0",size:"10",toUpdate:"",sinceUpdate:""},this.loading=!1,this.usuario=new c.a,this.saldo=new i.a,this.message=""}ngOnInit(){this.userService.myInfo().then(e=>this.usuario=e),this.updateDataTable(0,10)}updateDataTable(e,t){this.loading=!0,null==this.fechaCreacion?(this.filterParams.since="",this.filterParams.to=""):(this.fechaCreacion[1].setDate(this.fechaCreacion[1].getDate()+1),this.filterParams.since=this.datepipe.transform(this.fechaCreacion[0],"yyyy-MM-dd"),this.filterParams.to=this.datepipe.transform(this.fechaCreacion[1],"yyyy-MM-dd")),this.filterParams.page=e||0,this.filterParams.size=t||0,this.prestamoService.getSaldos(this.filterParams).subscribe(e=>{this.page=e,this.loading=!1})}onChangePageSize(e){this.updateDataTable(this.page.number,e)}mostrarComprobante(e){this.comprobanteUrl=void 0,"SISTEMA"!==e.origen&&this.resourcesService.getRecurso(e.id,"PRESTAMO","IMAGEN").subscribe(e=>{this.comprobanteUrl=this.sanitizer.bypassSecurityTrustUrl(e.dato)})}openModal(e){this.saldo=e,this.message="",this.modalConfirmacion.show(),this.mostrarComprobante(e)}salir(){this.message="",this.saldo=new i.a,this.modalConfirmacion.hide()}aprobarPago(){return Object(o.a)(this,void 0,void 0,(function*(){try{let e=Object.assign({},this.saldo);e.validado=!0,e.origen=this.usuario.email,this.saldo=yield this.prestamoService.updateSaldoPrestamo(this.saldo.id,e).toPromise(),this.message="Pago aprobado correctamente"}catch(e){this.message=e}}))}downloadImage(){return Object(o.a)(this,void 0,void 0,(function*(){let e=yield this.resourcesService.getRecurso(this.saldo.id,"PRESTAMO","IMAGEN").toPromise();const t=this.convertBase64ToBlobData(e.dato.replace(/^data:image\/(png|jpeg|jpg);base64,/,""));let a="comprobantePago.jpeg";if(window.navigator&&window.navigator.msSaveOrOpenBlob)window.navigator.msSaveOrOpenBlob(t,a);else{const e=new Blob([t],{type:"image/jpeg"}),o=window.URL.createObjectURL(e),n=document.createElement("a");n.href=o,n.download=a,n.click()}}))}convertBase64ToBlobData(e,t="image/png",a=512){const o=atob(e),n=[];for(let i=0;i<o.length;i+=a){const e=o.slice(i,i+a),t=new Array(e.length);for(let a=0;a<e.length;a++)t[a]=e.charCodeAt(a);const c=new Uint8Array(t);n.push(c)}return new Blob(n,{type:t})}downloadXLSFile(){this.loading=!0,null==this.fechaCreacion?(this.filterParams.since="",this.filterParams.to=""):(this.fechaCreacion[1].setDate(this.fechaCreacion[1].getDate()+1),this.filterParams.since=this.datepipe.transform(this.fechaCreacion[0],"yyyy-MM-dd"),this.filterParams.to=this.datepipe.transform(this.fechaCreacion[1],"yyyy-MM-dd")),this.filterParams.page="0",this.filterParams.size="100000",this.prestamoService.getReporteSaldos(this.filterParams).subscribe(e=>{this.downloadService.downloadFile(e.dato,`ReporteSaldoPrestamos-${this.datepipe.transform(Date.now(),"yyyy-MM-dd")}.xls`,"application/vnd.ms-excel"),this.loading=!1})}}return e.\u0275fac=function(t){return new(t||e)(r.Rb(b.c),r.Rb(s.f),r.Rb(l.a),r.Rb(d.a),r.Rb(p.a),r.Rb(g.b),r.Rb(f.a))},e.\u0275cmp=r.Lb({type:e,selectors:[["cybord-reporte-prestamos"]],viewQuery:function(e,t){var a;1&e&&r.Lc(W,!0),2&e&&r.uc(a=r.fc())&&(t.modalConfirmacion=a.first)},decls:136,vars:34,consts:[[1,"animated","fadeIn"],[1,"row"],[1,"col-sm-12","col-md-12"],[1,"card"],[1,"card-header"],[1,"card-body"],[1,"row","slide_1"],[1,"col-md-2"],["for","noempleado",1,"label"],["type","text","fullWidth","","id","noemp","placeholder","No. Empleado",1,"form-control",3,"ngModel","ngModelChange"],["for","inputActivo",1,"label"],["id","inputActivo",1,"form-control",2,"display","block",3,"ngModel","ngModelChange"],["value","*"],["value","SOLICITADO"],["value","PROCESO_DE_APROBACION"],["value","ACTIVO"],["value","SUSPENDIDO"],["value","TERMINADO"],["value","A_PAGAR_POR_AVAL"],["value","TRASPASADO"],["value","TRASPASADO_TERMINADOO"],["for","fechacre",1,"label"],[1,"form-group"],["type","text","placeholder","Fecha de creaci\xf3n","bsDaterangepicker","",1,"form-control",3,"ngModel","ngModelChange"],[1,"btn","btn-primary",2,"margin-top","2em",3,"disabled","click"],["class","fa fa-spinner fa-spin",4,"ngIf"],[1,"col"],["class","alert alert-primary","role","alert",4,"ngIf"],["class","clearfix",4,"ngIf"],["class","table-responsive",4,"ngIf"],[4,"ngIf"],["bsModal","","id","modalConfirmacion","tabindex","-1","role","dialog","aria-labelledby","modalConfirmacion","aria-hidden","true",1,"modal","fade","modal-info"],["modalConfirmacion","bs-modal"],["role","document",1,"modal-dialog"],[1,"modal-content"],[1,"modal-header"],["id","modalConfirmacionLabel",1,"modal-title"],["type","button","data-dismiss","modal","aria-label","Close",1,"close",3,"click"],["aria-hidden","true"],[1,"modal-body"],["class","card-img-top","style","height: 300px;width: 470px;","alt","Card image cap",3,"src",4,"ngIf"],["class","card-header","class","text-danger",4,"ngIf"],[1,"table","table-bordered","table-sm"],["scope","row",1,"text-left"],[1,"form-group","row"],["for","inputPassword",1,"col-sm-2","col-form-label"],[1,"col-sm-10"],["type","password","id","inputPassword",1,"form-control",3,"ngModel","ngModelOptions","ngModelChange"],["id","noEmpHelp",1,"form-text","text-muted"],["class","alert alert-info","role","alert",4,"ngIf"],[1,"modal-footer"],["type","button","class","btn btn-success",3,"click",4,"ngIf"],["type","button",1,"btn",3,"ngClass","disabled","click"],["type","button",1,"btn","btn-warning",3,"click"],[1,"fa","fa-spinner","fa-spin"],["role","alert",1,"alert","alert-primary"],[1,"clearfix"],[1,"btn-sm","btn-success","float-right",3,"click"],[1,"fa","fa-file-excel-o","fa-sm"],["id","inputunidad","style","display:block;width: 95px; margin-right: 15px;","class","float-right form-control form-control-sm",3,"ngModel","ngModelChange","change",4,"ngIf"],[1,"float-right"],["id","inputunidad",1,"float-right","form-control","form-control-sm",2,"display","block","width","95px","margin-right","15px",3,"ngModel","ngModelChange","change"],["value","10"],["value","20",4,"ngIf"],["value","50",4,"ngIf"],["value","20"],["value","50"],[1,"table-responsive"],[1,"thead-dark"],[1,"text-center"],[4,"ngFor","ngForOf"],["scope","row",1,"text-center"],["type","button",1,"btn","btn-sm",3,"ngClass","disabled","click"],[1,"fa","fa","fa-search"],["scope","row"],["scope","row",1,"text-right"],["class","pagination float-right",4,"ngIf"],[1,"pagination","float-right"],["class","page-item",4,"ngIf"],[1,"page-item","active"],[1,"page-link"],[1,"page-item"],[1,"btn","page-link",3,"click"],[1,"icon-control-rewind","icons"],[1,"icon-control-forward","icons"],["alt","Card image cap",1,"card-img-top",2,"height","300px","width","470px",3,"src"],[1,"text-danger"],["role","alert",1,"alert","alert-info"],["type","button",1,"btn","btn-success",3,"click"]],template:function(e,t){1&e&&(r.Xb(0,"div",0),r.Xb(1,"div",1),r.Xb(2,"div",2),r.Xb(3,"div",3),r.Xb(4,"div",4),r.Xb(5,"strong"),r.Gc(6,"Reportes ahorro sistema de caja"),r.Wb(),r.Wb(),r.Xb(7,"div",5),r.Xb(8,"div",6),r.Xb(9,"div",7),r.Xb(10,"label",8),r.Gc(11,"No. Empleado"),r.Wb(),r.Xb(12,"input",9),r.ec("ngModelChange",(function(e){return t.filterParams.noEmpleado=e})),r.Wb(),r.Wb(),r.Xb(13,"div",7),r.Xb(14,"label",10),r.Gc(15,"Estatus"),r.Wb(),r.Xb(16,"select",11),r.ec("ngModelChange",(function(e){return t.filterParams.estatus=e})),r.Xb(17,"option",12),r.Gc(18,"Todo"),r.Wb(),r.Xb(19,"option",13),r.Gc(20,"Solicitado"),r.Wb(),r.Xb(21,"option",14),r.Gc(22,"Proceso de aprobacion"),r.Wb(),r.Xb(23,"option",15),r.Gc(24,"Activo"),r.Wb(),r.Xb(25,"option",16),r.Gc(26,"Suspendido"),r.Wb(),r.Xb(27,"option",17),r.Gc(28,"Terminado"),r.Wb(),r.Xb(29,"option",18),r.Gc(30,"A pagar por aval"),r.Wb(),r.Xb(31,"option",19),r.Gc(32,"Traspasado"),r.Wb(),r.Xb(33,"option",20),r.Gc(34,"Traspasadoo terminado"),r.Wb(),r.Wb(),r.Wb(),r.Xb(35,"div",7),r.Xb(36,"label",21),r.Gc(37,"Periodo de Creaci\xf3n"),r.Wb(),r.Xb(38,"div",22),r.Xb(39,"input",23),r.ec("ngModelChange",(function(e){return t.fechaCreacion=e})),r.Wb(),r.Wb(),r.Wb(),r.Xb(40,"div",7),r.Xb(41,"button",24),r.ec("click",(function(){return t.updateDataTable(0,10)})),r.Gc(42,"BUSCAR "),r.Ec(43,v,1,0,"i",25),r.Wb(),r.Wb(),r.Wb(),r.Wb(),r.Wb(),r.Wb(),r.Wb(),r.Xb(44,"div",1),r.Xb(45,"div",2),r.Xb(46,"div",3),r.Xb(47,"div",4),r.Xb(48,"strong"),r.Gc(49,"Resultados"),r.Wb(),r.Wb(),r.Xb(50,"div",5),r.Xb(51,"div",1),r.Xb(52,"div",26),r.Ec(53,y,2,0,"div",27),r.Ec(54,P,6,1,"div",28),r.Wb(),r.Wb(),r.Xb(55,"div",1),r.Xb(56,"div",26),r.Ec(57,A,34,1,"div",29),r.Ec(58,D,2,1,"div",28),r.Wb(),r.Wb(),r.Wb(),r.Ec(59,H,1,0,"cybord-loader",30),r.Wb(),r.Wb(),r.Wb(),r.Wb(),r.Xb(60,"div",31,32),r.Xb(62,"div",33),r.Xb(63,"div",34),r.Xb(64,"div",35),r.Xb(65,"h5",36),r.Gc(66,"Confirmacion"),r.Wb(),r.Xb(67,"button",37),r.ec("click",(function(){return t.salir()})),r.Xb(68,"span",38),r.Gc(69,"\xd7"),r.Wb(),r.Wb(),r.Wb(),r.Xb(70,"div",39),r.Ec(71,N,1,1,"img",40),r.Ec(72,x,2,0,"h5",41),r.Xb(73,"table",42),r.Xb(74,"tbody"),r.Xb(75,"tr"),r.Xb(76,"th"),r.Gc(77,"No empleado"),r.Wb(),r.Xb(78,"td",43),r.Gc(79),r.Wb(),r.Wb(),r.Xb(80,"tr"),r.Xb(81,"th"),r.Gc(82,"Nombre"),r.Wb(),r.Xb(83,"td",43),r.Gc(84),r.Wb(),r.Wb(),r.Xb(85,"tr"),r.Xb(86,"th"),r.Gc(87,"Estatus prestamo"),r.Wb(),r.Xb(88,"td",43),r.Gc(89),r.Wb(),r.Wb(),r.Xb(90,"tr"),r.Xb(91,"th"),r.Gc(92,"Monto Pago"),r.Wb(),r.Xb(93,"td",43),r.Gc(94),r.hc(95,"currency"),r.Wb(),r.Wb(),r.Xb(96,"tr"),r.Xb(97,"th"),r.Gc(98,"Tasa de interes"),r.Wb(),r.Xb(99,"td",43),r.Gc(100),r.hc(101,"percent"),r.Wb(),r.Wb(),r.Xb(102,"tr"),r.Xb(103,"th"),r.Gc(104,"Ultima modificacion"),r.Wb(),r.Xb(105,"td",43),r.Gc(106),r.Wb(),r.Wb(),r.Xb(107,"tr"),r.Xb(108,"th"),r.Gc(109,"No. Quincenas"),r.Wb(),r.Xb(110,"td",43),r.Gc(111),r.Wb(),r.Wb(),r.Wb(),r.Wb(),r.Xb(112,"p"),r.Xb(113,"strong"),r.Gc(114),r.Wb(),r.Gc(115," el pago al prestamo."),r.Wb(),r.Xb(116,"p"),r.Gc(117,"Al "),r.Xb(118,"strong"),r.Gc(119,"APROBAR"),r.Wb(),r.Gc(120," el pago, el sistema registra la persona y el momento en que realiza la transacci\xf3n."),r.Wb(),r.Xb(121,"form"),r.Xb(122,"div",44),r.Xb(123,"label",45),r.Gc(124,"No empleado"),r.Wb(),r.Xb(125,"div",46),r.Xb(126,"input",47),r.ec("ngModelChange",(function(e){return t.noEmpleado=e})),r.Wb(),r.Xb(127,"small",48),r.Gc(128,"Ingresa tu numero de empleado para desbloquear."),r.Wb(),r.Wb(),r.Wb(),r.Wb(),r.Ec(129,z,3,1,"div",49),r.Wb(),r.Xb(130,"div",50),r.Ec(131,U,2,0,"button",51),r.Xb(132,"button",52),r.ec("click",(function(){return t.aprobarPago()})),r.Gc(133,"Aprobar Pago"),r.Wb(),r.Xb(134,"button",53),r.ec("click",(function(){return t.salir()})),r.Gc(135,"Salir"),r.Wb(),r.Wb(),r.Wb(),r.Wb(),r.Wb()),2&e&&(r.Fb(12),r.nc("ngModel",t.filterParams.noEmpleado),r.Fb(4),r.nc("ngModel",t.filterParams.estatus),r.Fb(23),r.nc("ngModel",t.fechaCreacion),r.Fb(2),r.nc("disabled",t.loading),r.Fb(2),r.nc("ngIf",t.loading),r.Fb(10),r.nc("ngIf",!0===t.page.empty),r.Fb(1),r.nc("ngIf",!1===t.page.empty),r.Fb(3),r.nc("ngIf",0==t.page.empty),r.Fb(1),r.nc("ngIf",0==t.page.empty),r.Fb(1),r.nc("ngIf",t.loading),r.Fb(12),r.nc("ngIf",void 0!==t.comprobanteUrl),r.Fb(1),r.nc("ngIf",void 0===t.comprobanteUrl),r.Fb(7),r.Hc(t.saldo.noEmpleado),r.Fb(5),r.Hc(t.saldo.nombreEmpleado),r.Fb(5),r.Hc(t.saldo.estatus),r.Fb(5),r.Hc(r.ic(95,26,t.saldo.monto)),r.Fb(6),r.Hc(r.ic(101,28,t.saldo.tasaInteres/100)),r.Fb(6),r.Hc(t.saldo.origen),r.Fb(5),r.Hc(t.saldo.noQuincenas),r.Fb(3),r.Ic("",t.usuario.nombre," aprobar\xe1"),r.Fb(12),r.nc("ngModel",t.noEmpleado)("ngModelOptions",r.pc(30,L)),r.Fb(3),r.nc("ngIf",t.message.length>0),r.Fb(2),r.nc("ngIf",void 0!==t.comprobanteUrl),r.Fb(1),r.nc("ngClass",r.rc(31,B,t.noEmpleado===t.usuario.noEmpleado&&!t.saldo.validado,t.noEmpleado!==t.usuario.noEmpleado||t.saldo.validado))("disabled",t.noEmpleado!==t.usuario.noEmpleado))},directives:[u.b,u.h,u.k,u.o,u.l,u.p,h.e,h.d,s.n,m.a,u.q,u.i,u.j,s.l,s.m,X.a],pipes:[s.d,s.u,s.f],styles:[""]}),e})()},aJ9a:function(e,t,a){"use strict";a.d(t,"a",(function(){return M}));var o=a("EwKM"),n=a("8Y7J"),i=a("iInd"),c=a("SVse"),r=a("q+li"),b=a("LDwG"),s=a("s7LF"),l=a("ienR"),d=a("jksu");function p(e,t){1&e&&n.Sb(0,"i",31)}function g(e,t){1&e&&(n.Xb(0,"div",32),n.Gc(1," No se encontraron resultados "),n.Wb())}function f(e,t){1&e&&(n.Xb(0,"option",42),n.Gc(1,"20"),n.Wb())}function u(e,t){1&e&&(n.Xb(0,"option",43),n.Gc(1,"50"),n.Wb())}function h(e,t){if(1&e){const e=n.Yb();n.Xb(0,"select",38),n.ec("ngModelChange",(function(t){return n.yc(e),n.gc(2).filterParams.size=t}))("change",(function(t){return n.yc(e),n.gc(2).onChangePageSize(t.target.value)})),n.Xb(1,"option",39),n.Gc(2,"10"),n.Wb(),n.Ec(3,f,2,0,"option",40),n.Ec(4,u,2,0,"option",41),n.Wb()}if(2&e){const e=n.gc(2);n.nc("ngModel",e.filterParams.size),n.Fb(3),n.nc("ngIf",e.page.number<e.page.totalElements/20),n.Fb(1),n.nc("ngIf",e.page.number<e.page.totalElements/50)}}function m(e,t){if(1&e){const e=n.Yb();n.Xb(0,"div",33),n.Xb(1,"button",34),n.ec("click",(function(){return n.yc(e),n.gc().downloadXLSFile()})),n.Sb(2,"i",35),n.Wb(),n.Ec(3,h,5,3,"select",36),n.Xb(4,"strong",37),n.Gc(5," Tama\xf1o Pagina \xa0\xa0\xa0\xa0"),n.Wb(),n.Wb()}if(2&e){const e=n.gc();n.Fb(3),n.nc("ngIf",0==e.page.last||1==e.page.first)}}function X(e,t){if(1&e&&(n.Xb(0,"tr"),n.Xb(1,"td",49),n.Gc(2),n.Wb(),n.Xb(3,"td",49),n.Gc(4),n.Wb(),n.Xb(5,"td",49),n.Gc(6),n.Wb(),n.Xb(7,"td",49),n.Gc(8),n.Wb(),n.Xb(9,"td",49),n.Gc(10),n.Wb(),n.Xb(11,"td",50),n.Gc(12),n.hc(13,"currency"),n.Wb(),n.Xb(14,"td",49),n.Gc(15),n.Wb(),n.Wb()),2&e){const e=t.$implicit;n.Fb(2),n.Hc(e.noEmpleado),n.Fb(2),n.Hc(e.tipoEmpleado),n.Fb(2),n.Hc(e.ahorrador),n.Fb(2),n.Hc(e.tipo),n.Fb(2),n.Hc(e.observaciones),n.Fb(2),n.Hc(n.ic(13,7,e.monto)),n.Fb(3),n.Hc(e.fecha)}}function W(e,t){if(1&e){const e=n.Yb();n.Xb(0,"li",56),n.Xb(1,"button",57),n.ec("click",(function(){n.yc(e);const t=n.gc(4);return t.updateDataTable(0,t.page.size)})),n.Sb(2,"i",58),n.Wb(),n.Wb()}}function v(e,t){if(1&e){const e=n.Yb();n.Xb(0,"li",56),n.Xb(1,"button",57),n.ec("click",(function(){n.yc(e);const t=n.gc(4);return t.updateDataTable(t.page.number-1,t.page.size)})),n.Gc(2),n.Wb(),n.Wb()}if(2&e){const e=n.gc(4);n.Fb(2),n.Hc(e.page.number)}}function y(e,t){if(1&e){const e=n.Yb();n.Xb(0,"li",56),n.Xb(1,"button",57),n.ec("click",(function(){n.yc(e);const t=n.gc(4);return t.updateDataTable(t.page.number+1,t.page.size)})),n.Gc(2),n.Wb(),n.Wb()}if(2&e){const e=n.gc(4);n.Fb(2),n.Hc(e.page.number+2)}}function G(e,t){if(1&e){const e=n.Yb();n.Xb(0,"li",56),n.Xb(1,"button",57),n.ec("click",(function(){n.yc(e);const t=n.gc(4);return t.updateDataTable(t.page.totalPages-1,t.page.size)})),n.Sb(2,"i",59),n.Wb(),n.Wb()}}function E(e,t){if(1&e&&(n.Xb(0,"ul",52),n.Ec(1,W,3,0,"li",53),n.Ec(2,v,3,1,"li",53),n.Xb(3,"li",54),n.Xb(4,"a",55),n.Xb(5,"strong"),n.Gc(6),n.Wb(),n.Wb(),n.Wb(),n.Ec(7,y,3,1,"li",53),n.Ec(8,G,3,0,"li",53),n.Wb()),2&e){const e=n.gc(3);n.Fb(1),n.nc("ngIf",0==e.page.first),n.Fb(1),n.nc("ngIf",0==e.page.first),n.Fb(4),n.Hc(e.page.number+1),n.Fb(1),n.nc("ngIf",0==e.page.last),n.Fb(1),n.nc("ngIf",0==e.page.last)}}function I(e,t){if(1&e&&(n.Xb(0,"div",33),n.Ec(1,E,9,5,"ul",51),n.Wb()),2&e){const e=n.gc(2);n.Fb(1),n.nc("ngIf",e.page.totalElements>1)}}function P(e,t){if(1&e&&(n.Xb(0,"div",44),n.Xb(1,"table",45),n.Xb(2,"thead",46),n.Xb(3,"tr"),n.Xb(4,"th",47),n.Gc(5,"NO EMPLEADO"),n.Wb(),n.Xb(6,"th",47),n.Gc(7,"TIPO EMP"),n.Wb(),n.Xb(8,"th",47),n.Gc(9,"AHORRADOR"),n.Wb(),n.Xb(10,"th",47),n.Gc(11,"TIPO TRANSACCION"),n.Wb(),n.Xb(12,"th",47),n.Gc(13,"OBSERVACIONES"),n.Wb(),n.Xb(14,"th",47),n.Gc(15,"MONTO"),n.Wb(),n.Xb(16,"th",47),n.Gc(17,"FECHA"),n.Wb(),n.Wb(),n.Wb(),n.Xb(18,"tbody"),n.Ec(19,X,16,9,"tr",48),n.Wb(),n.Wb(),n.Ec(20,I,2,1,"div",28),n.Wb()),2&e){const e=n.gc();n.Fb(19),n.nc("ngForOf",e.page.content),n.Fb(1),n.nc("ngIf",0==e.page.empty)}}function F(e,t){1&e&&n.Sb(0,"cybord-loader")}let M=(()=>{class e{constructor(e,t,a,n){this.router=e,this.datepipe=t,this.downloadService=a,this.ahorroService=n,this.module="usuarios",this.page=new o.a,this.pageSize="10",this.filterParams={tipo:"*",noEmpleado:"",tipoUsuario:"*",since:"",to:"",page:"0",size:"10"},this.loading=!1}ngOnInit(){this.updateDataTable(0,10)}updateDataTable(e,t){this.loading=!0,null==this.fechaCreacion?(this.filterParams.since="",this.filterParams.to=""):(this.fechaCreacion[1].setDate(this.fechaCreacion[1].getDate()+1),this.filterParams.since=this.datepipe.transform(this.fechaCreacion[0],"yyyy-MM-dd"),this.filterParams.to=this.datepipe.transform(this.fechaCreacion[1],"yyyy-MM-dd")),this.filterParams.page=e||0,this.filterParams.size=t||0,this.ahorroService.getSaldos(this.filterParams).subscribe(e=>{this.page=e,this.loading=!1})}onChangePageSize(e){this.updateDataTable(this.page.number,e)}redirectToValidation(e){this.router.navigate([`./${this.module}/validacion/${e}`])}downloadXLSFile(){this.loading=!0,null==this.fechaCreacion?(this.filterParams.since="",this.filterParams.to=""):(this.fechaCreacion[1].setDate(this.fechaCreacion[1].getDate()+1),this.filterParams.since=this.datepipe.transform(this.fechaCreacion[0],"yyyy-MM-dd"),this.filterParams.to=this.datepipe.transform(this.fechaCreacion[1],"yyyy-MM-dd")),this.filterParams.page="0",this.filterParams.size="100000",this.ahorroService.getReporteSaldos(this.filterParams).subscribe(e=>{this.downloadService.downloadFile(e.dato,`ReporteAhorros-${this.datepipe.transform(Date.now(),"yyyy-MM-dd")}.xls`,"application/vnd.ms-excel"),this.loading=!1})}}return e.\u0275fac=function(t){return new(t||e)(n.Rb(i.c),n.Rb(c.f),n.Rb(r.a),n.Rb(b.a))},e.\u0275cmp=n.Lb({type:e,selectors:[["cybord-reporte-ahorros"]],decls:61,vars:10,consts:[[1,"animated","fadeIn"],[1,"row"],[1,"col-sm-12","col-md-12"],[1,"card"],[1,"card-header"],[1,"card-body"],[1,"row","slide_1"],[1,"col-md-2"],["for","noempleado",1,"label"],["type","text","fullWidth","","id","noemp","placeholder","No. Empleado",1,"form-control",3,"ngModel","ngModelChange"],["for","inputActivo2",1,"label"],["id","inputActivo2",1,"form-control",2,"display","block",3,"ngModel","ngModelChange"],["value","*"],["value","INTERNO"],["value","EXTERNO"],["for","inputActivo",1,"label"],["id","inputActivo",1,"form-control",2,"display","block",3,"ngModel","ngModelChange"],["value","ahorro"],["value","deposito"],["value","ajuste"],["value","retiro"],["for","fechacre",1,"label"],[1,"form-group"],["type","text","placeholder","Fecha de creaci\xf3n","bsDaterangepicker","",1,"form-control",3,"ngModel","ngModelChange"],[1,"btn","btn-primary",2,"margin-top","2em",3,"disabled","click"],["class","fa fa-spinner fa-spin",4,"ngIf"],[1,"col"],["class","alert alert-primary","role","alert",4,"ngIf"],["class","clearfix",4,"ngIf"],["class","table-responsive",4,"ngIf"],[4,"ngIf"],[1,"fa","fa-spinner","fa-spin"],["role","alert",1,"alert","alert-primary"],[1,"clearfix"],[1,"btn-sm","btn-success","float-right",3,"click"],[1,"fa","fa-file-excel-o","fa-sm"],["id","inputunidad","style","display:block;width: 95px; margin-right: 15px;","class","float-right form-control form-control-sm",3,"ngModel","ngModelChange","change",4,"ngIf"],[1,"float-right"],["id","inputunidad",1,"float-right","form-control","form-control-sm",2,"display","block","width","95px","margin-right","15px",3,"ngModel","ngModelChange","change"],["value","10"],["value","20",4,"ngIf"],["value","50",4,"ngIf"],["value","20"],["value","50"],[1,"table-responsive"],[1,"table","table-bordered","table-sm"],[1,"thead-dark"],[1,"text-center"],[4,"ngFor","ngForOf"],["scope","row"],["scope","row",1,"text-right"],["class","pagination float-right",4,"ngIf"],[1,"pagination","float-right"],["class","page-item",4,"ngIf"],[1,"page-item","active"],[1,"page-link"],[1,"page-item"],[1,"btn","page-link",3,"click"],[1,"icon-control-rewind","icons"],[1,"icon-control-forward","icons"]],template:function(e,t){1&e&&(n.Xb(0,"div",0),n.Xb(1,"div",1),n.Xb(2,"div",2),n.Xb(3,"div",3),n.Xb(4,"div",4),n.Xb(5,"strong"),n.Gc(6,"Reportes ahorro sistema de caja"),n.Wb(),n.Wb(),n.Xb(7,"div",5),n.Xb(8,"div",6),n.Xb(9,"div",7),n.Xb(10,"label",8),n.Gc(11,"No. Empleado"),n.Wb(),n.Xb(12,"input",9),n.ec("ngModelChange",(function(e){return t.filterParams.noEmpleado=e})),n.Wb(),n.Wb(),n.Xb(13,"div",7),n.Xb(14,"label",10),n.Gc(15,"Tipo Empleado"),n.Wb(),n.Xb(16,"select",11),n.ec("ngModelChange",(function(e){return t.filterParams.tipoUsuario=e})),n.Xb(17,"option",12),n.Gc(18,"Todo"),n.Wb(),n.Xb(19,"option",13),n.Gc(20,"Interno"),n.Wb(),n.Xb(21,"option",14),n.Gc(22,"Externo"),n.Wb(),n.Wb(),n.Wb(),n.Xb(23,"div",7),n.Xb(24,"label",15),n.Gc(25,"Tipo Ahorro"),n.Wb(),n.Xb(26,"select",16),n.ec("ngModelChange",(function(e){return t.filterParams.tipo=e})),n.Xb(27,"option",12),n.Gc(28,"Todo"),n.Wb(),n.Xb(29,"option",17),n.Gc(30,"Ahorro"),n.Wb(),n.Xb(31,"option",18),n.Gc(32,"Deposito"),n.Wb(),n.Xb(33,"option",19),n.Gc(34,"Ajuste"),n.Wb(),n.Xb(35,"option",20),n.Gc(36,"Retiro"),n.Wb(),n.Wb(),n.Wb(),n.Xb(37,"div",7),n.Xb(38,"label",21),n.Gc(39,"Fecha Creaci\xf3n"),n.Wb(),n.Xb(40,"div",22),n.Xb(41,"input",23),n.ec("ngModelChange",(function(e){return t.fechaCreacion=e})),n.Wb(),n.Wb(),n.Wb(),n.Xb(42,"div",7),n.Xb(43,"button",24),n.ec("click",(function(){return t.updateDataTable(0,10)})),n.Gc(44,"BUSCAR "),n.Ec(45,p,1,0,"i",25),n.Wb(),n.Wb(),n.Wb(),n.Wb(),n.Wb(),n.Wb(),n.Wb(),n.Xb(46,"div",1),n.Xb(47,"div",2),n.Xb(48,"div",3),n.Xb(49,"div",4),n.Xb(50,"strong"),n.Gc(51,"Resultados"),n.Wb(),n.Wb(),n.Xb(52,"div",5),n.Xb(53,"div",1),n.Xb(54,"div",26),n.Ec(55,g,2,0,"div",27),n.Ec(56,m,6,1,"div",28),n.Wb(),n.Wb(),n.Xb(57,"div",1),n.Xb(58,"div",26),n.Ec(59,P,21,2,"div",29),n.Wb(),n.Wb(),n.Wb(),n.Ec(60,F,1,0,"cybord-loader",30),n.Wb(),n.Wb(),n.Wb(),n.Wb()),2&e&&(n.Fb(12),n.nc("ngModel",t.filterParams.noEmpleado),n.Fb(4),n.nc("ngModel",t.filterParams.tipoUsuario),n.Fb(10),n.nc("ngModel",t.filterParams.tipo),n.Fb(15),n.nc("ngModel",t.fechaCreacion),n.Fb(2),n.nc("disabled",t.loading),n.Fb(2),n.nc("ngIf",t.loading),n.Fb(10),n.nc("ngIf",!0===t.page.empty),n.Fb(1),n.nc("ngIf",!1===t.page.empty),n.Fb(3),n.nc("ngIf",0==t.page.empty),n.Fb(1),n.nc("ngIf",t.loading))},directives:[s.b,s.h,s.k,s.o,s.l,s.p,l.e,l.d,c.n,c.m,d.a],pipes:[c.d],styles:[""]}),e})()},bEsI:function(e,t,a){"use strict";a.d(t,"a",(function(){return i}));var o=a("IheW"),n=a("8Y7J");let i=(()=>{class e{constructor(e){this.http=e}getHttpParams(e){let t=new o.d;for(const a in e)if(void 0!==e[a]){const o=e[a].toString();null!==o&&o.length>0&&"*"!==o&&(t=t.append(a,o))}return t}getPrestamosByUsuario(e){return this.http.get(`../api/v1/usuarios/${e}/prestamos`)}getSaldos(e){return this.http.get("../api/v1/saldo-prestamos",{params:this.getHttpParams(e)})}getReporteSaldos(e){return this.http.get("../api/v1/saldo-prestamos/report",{params:this.getHttpParams(e)})}getPrestamosByUsuairoAndPrestamoAndSaldo(e,t,a){return this.http.get(`../api/v1/usuarios/${e}/prestamos/${t}/saldos/${a}`)}insertSaldoPrestamo(e,t){return this.http.post(`../api/v1/prestamos/${e}/saldos`,t)}getPrestamosPendientesByUsuario(e){return this.http.get(`../api/v1/usuarios/${e}/prestamos/pendientes`)}updateSaldoPrestamo(e,t){return this.http.put("../api/v1/saldo-prestamos/"+e,t)}}return e.\u0275fac=function(t){return new(t||e)(n.bc(o.b))},e.\u0275prov=n.Nb({token:e,factory:e.\u0275fac,providedIn:"root"}),e})()}}]);
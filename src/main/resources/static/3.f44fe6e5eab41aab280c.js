(window.webpackJsonp=window.webpackJsonp||[]).push([[3],{"aBT+":function(i,o,e){"use strict";e.d(o,"a",(function(){return k}));var t=e("EwKM"),a=e("8Y7J"),s=e("SVse"),r=e("ESM5"),n=e("q+li"),c=e("iInd"),b=e("s7LF");function l(i,o){if(1&i){const i=a.Yb();a.Xb(0,"div",7),a.Xb(1,"label",28),a.Dc(2,"Tipo de Usuario"),a.Wb(),a.Xb(3,"div"),a.Xb(4,"select",29),a.ec("ngModelChange",(function(o){return a.wc(i),a.gc().filterParams.tipoUsuario=o})),a.Xb(5,"option",18),a.Dc(6,"TODOS"),a.Wb(),a.Xb(7,"option",30),a.Dc(8,"INTERNO"),a.Wb(),a.Xb(9,"option",31),a.Dc(10,"EXTERNO"),a.Wb(),a.Wb(),a.Wb(),a.Wb()}if(2&i){const i=a.gc();a.Fb(4),a.mc("ngModel",i.filterParams.tipoUsuario)}}function d(i,o){1&i&&a.Sb(0,"i",32)}function u(i,o){1&i&&(a.Xb(0,"div",33),a.Dc(1," No se encontraron resultados "),a.Wb())}function m(i,o){1&i&&(a.Xb(0,"option",43),a.Dc(1,"20"),a.Wb())}function g(i,o){1&i&&(a.Xb(0,"option",44),a.Dc(1,"50"),a.Wb())}function h(i,o){if(1&i){const i=a.Yb();a.Xb(0,"select",39),a.ec("ngModelChange",(function(o){return a.wc(i),a.gc(2).filterParams.size=o}))("change",(function(o){return a.wc(i),a.gc(2).onChangePageSize(o.target.value)})),a.Xb(1,"option",40),a.Dc(2,"10"),a.Wb(),a.Cc(3,m,2,0,"option",41),a.Cc(4,g,2,0,"option",42),a.Wb()}if(2&i){const i=a.gc(2);a.mc("ngModel",i.filterParams.size),a.Fb(3),a.mc("ngIf",i.page.number<i.page.totalElements/20),a.Fb(1),a.mc("ngIf",i.page.number<i.page.totalElements/50)}}function f(i,o){if(1&i){const i=a.Yb();a.Xb(0,"div",34),a.Xb(1,"button",35),a.ec("click",(function(){return a.wc(i),a.gc().downloadXLSFile()})),a.Sb(2,"i",36),a.Wb(),a.Cc(3,h,5,3,"select",37),a.Xb(4,"strong",38),a.Dc(5," Tama\xf1o Pagina \xa0\xa0\xa0\xa0"),a.Wb(),a.Wb()}if(2&i){const i=a.gc();a.Fb(3),a.mc("ngIf",0==i.page.last||1==i.page.first)}}function p(i,o){if(1&i){const i=a.Yb();a.Xb(0,"button",56),a.ec("click",(function(){a.wc(i);const o=a.gc().$implicit;return a.gc(2).redirectToAdjustment(o.id)})),a.Sb(1,"i",57),a.Wb()}}function v(i,o){1&i&&(a.Xb(0,"td",54),a.Xb(1,"span",58),a.Dc(2,"ACTIVO"),a.Wb(),a.Wb())}function X(i,o){1&i&&(a.Xb(0,"td",54),a.Xb(1,"span",59),a.Dc(2,"INACTIVO"),a.Wb(),a.Wb())}const W=function(i,o){return{"btn-outline-secondary":i,"btn-outline-success":o}};function C(i,o){if(1&i){const i=a.Yb();a.Xb(0,"tr"),a.Xb(1,"td",49),a.Xb(2,"button",50),a.ec("click",(function(){a.wc(i);const e=o.$implicit;return a.gc(2).redirectToUser(e.id)})),a.Sb(3,"i",51),a.Wb(),a.Cc(4,p,2,0,"button",52),a.Wb(),a.Xb(5,"td",53),a.Dc(6),a.Wb(),a.Xb(7,"td",54),a.Dc(8),a.Wb(),a.Xb(9,"td",54),a.Dc(10),a.Wb(),a.Xb(11,"td",54),a.Dc(12),a.Wb(),a.Cc(13,v,3,0,"td",55),a.Cc(14,X,3,0,"td",55),a.Wb()}if(2&i){const i=o.$implicit,e=a.gc(2);a.Fb(2),a.mc("disabled","contabilidad"===e.module&&"INTERNO"===i.tipoUsuario)("ngClass",a.qc(9,W,"contabilidad"===e.module&&"INTERNO"===i.tipoUsuario,"contabilidad"!==e.module||"INTERNO"!==i.tipoUsuario)),a.Fb(2),a.mc("ngIf","contabilidad"===e.module),a.Fb(2),a.Ec(i.noEmpleado),a.Fb(2),a.Ec(i.nombre),a.Fb(2),a.Ec(i.email),a.Fb(2),a.Ec(i.tipoUsuario),a.Fb(1),a.mc("ngIf",!0===i.activo),a.Fb(1),a.mc("ngIf",!1===i.activo)}}function I(i,o){if(1&i){const i=a.Yb();a.Xb(0,"li",65),a.Xb(1,"button",66),a.ec("click",(function(){a.wc(i);const o=a.gc(4);return o.updateDataTable(0,o.page.size)})),a.Sb(2,"i",67),a.Wb(),a.Wb()}}function D(i,o){if(1&i){const i=a.Yb();a.Xb(0,"li",65),a.Xb(1,"button",66),a.ec("click",(function(){a.wc(i);const o=a.gc(4);return o.updateDataTable(o.page.number-1,o.page.size)})),a.Dc(2),a.Wb(),a.Wb()}if(2&i){const i=a.gc(4);a.Fb(2),a.Ec(i.page.number)}}function M(i,o){if(1&i){const i=a.Yb();a.Xb(0,"li",65),a.Xb(1,"button",66),a.ec("click",(function(){a.wc(i);const o=a.gc(4);return o.updateDataTable(o.page.number+1,o.page.size)})),a.Dc(2),a.Wb(),a.Wb()}if(2&i){const i=a.gc(4);a.Fb(2),a.Ec(i.page.number+2)}}function E(i,o){if(1&i){const i=a.Yb();a.Xb(0,"li",65),a.Xb(1,"button",66),a.ec("click",(function(){a.wc(i);const o=a.gc(4);return o.updateDataTable(o.page.totalPages-1,o.page.size)})),a.Sb(2,"i",68),a.Wb(),a.Wb()}}function N(i,o){if(1&i&&(a.Xb(0,"ul",61),a.Cc(1,I,3,0,"li",62),a.Cc(2,D,3,1,"li",62),a.Xb(3,"li",63),a.Xb(4,"a",64),a.Xb(5,"strong"),a.Dc(6),a.Wb(),a.Wb(),a.Wb(),a.Cc(7,M,3,1,"li",62),a.Cc(8,E,3,0,"li",62),a.Wb()),2&i){const i=a.gc(3);a.Fb(1),a.mc("ngIf",0==i.page.first),a.Fb(1),a.mc("ngIf",0==i.page.first),a.Fb(4),a.Ec(i.page.number+1),a.Fb(1),a.mc("ngIf",0==i.page.last),a.Fb(1),a.mc("ngIf",0==i.page.last)}}function U(i,o){if(1&i&&(a.Xb(0,"div",34),a.Cc(1,N,9,5,"ul",60),a.Wb()),2&i){const i=a.gc(2);a.Fb(1),a.mc("ngIf",i.page.totalElements>1)}}function F(i,o){if(1&i&&(a.Xb(0,"div",45),a.Xb(1,"table",46),a.Xb(2,"thead",47),a.Xb(3,"tr"),a.Xb(4,"th"),a.Dc(5,"ACCIONES"),a.Wb(),a.Xb(6,"th"),a.Dc(7,"NO. EMPLEADO"),a.Wb(),a.Xb(8,"th"),a.Dc(9,"NOMBRE"),a.Wb(),a.Xb(10,"th"),a.Dc(11,"CORREO"),a.Wb(),a.Xb(12,"th"),a.Dc(13,"TIPO"),a.Wb(),a.Xb(14,"th"),a.Dc(15,"STATUS"),a.Wb(),a.Wb(),a.Wb(),a.Xb(16,"tbody"),a.Cc(17,C,15,12,"tr",48),a.Wb(),a.Wb(),a.Cc(18,U,2,1,"div",26),a.Wb()),2&i){const i=a.gc();a.Fb(17),a.mc("ngForOf",i.page.content),a.Fb(1),a.mc("ngIf",0==i.page.empty)}}let k=(()=>{class i{constructor(i,o,e,a){this.datepipe=i,this.userService=o,this.downloadService=e,this.router=a,this.module="recursos-humanos",this.page=new t.a,this.pageSize="10",this.loading=!1,this.filterParams={email:"",estatus:"*",nombre:"",tipoUsuario:"*",page:"0",size:"10"}}ngOnInit(){this.module=this.router.url.split("/")[1],"recursos-humanos"===this.module&&(this.filterParams.tipoUsuario="INTERNO"),"contabilidad"===this.module&&(this.filterParams.tipoUsuario="EXTERNO"),this.updateDataTable(0,10)}updateDataTable(i,o,e){this.loading=!0,this.filterParams.page=i||0,this.filterParams.size=o||10,this.userService.getUsuarios(this.filterParams).subscribe(i=>{this.page=i,this.loading=!1})}onChangePageSize(i){this.updateDataTable(this.page.number,i)}redirectToUser(i){this.router.navigate([`../${this.module}/usuarios/${i}`])}redirectToAdjustment(i){this.router.navigate(["../contabilidad/ajustes/"+i])}downloadXLSFile(){this.loading=!0,this.filterParams.page="0",this.filterParams.size="100000",this.userService.getUsuariosReport(this.filterParams).subscribe(i=>{this.downloadService.downloadFile(i.dato,`ReporteUsuarios-${this.datepipe.transform(Date.now(),"yyyy-MM-dd")}.xls`,"application/vnd.ms-excel"),this.loading=!1})}}return i.\u0275fac=function(o){return new(o||i)(a.Rb(s.f),a.Rb(r.a),a.Rb(n.a),a.Rb(c.c))},i.\u0275cmp=a.Lb({type:i,selectors:[["cybord-usuarios"]],decls:52,vars:11,consts:[[1,"animated","fadeIn"],[1,"row"],[1,"col-sm-12","col-md-12"],[1,"card"],[1,"card-header"],[1,"card-body"],[1,"row","slide_1"],[1,"col-md-2"],["for","inputCorreo",1,"label"],["type","text","nbInput","","fullWidth","","id","inputCorreo","placeholder","email usuario",1,"form-control",3,"ngModel","disabled","ngModelChange"],[1,"col-md-3"],["for","nombreusuario",1,"label"],["type","text","nbInput","","fullWidth","","id","nombreusu","placeholder","nombre usuario",1,"form-control",3,"ngModel","disabled","ngModelChange"],["class","col-md-2",4,"ngIf"],[1,"col-md-5"],["for","inputActivo",1,"label"],[1,"row","form-inline"],["id","inputActivo","fullWidth","",1,"form-control",2,"display","block",3,"ngModel","ngModelChange"],["value","*"],["value","1"],["value","0"],[1,"btn","btn-primary",3,"disabled","click"],["class","fa fa-spinner fa-spin",4,"ngIf"],[1,"btn","btn-primary",3,"click"],[1,"col"],["class","alert alert-primary","role","alert",4,"ngIf"],["class","clearfix",4,"ngIf"],["class","table-responsive",4,"ngIf"],["for","tipoUsuario",1,"label"],["id","inputTipoUsuario","fullWidth","",1,"form-control",2,"display","block",3,"ngModel","ngModelChange"],["value","INTERNO"],["value","EXTERNO"],[1,"fa","fa-spinner","fa-spin"],["role","alert",1,"alert","alert-primary"],[1,"clearfix"],[1,"btn-sm","btn-success","float-right",3,"click"],[1,"fa","fa-file-excel-o","fa-sm"],["id","inputunidad","style","display:block;width: 95px; margin-right: 15px;","class","float-right form-control form-control-sm",3,"ngModel","ngModelChange","change",4,"ngIf"],[1,"float-right"],["id","inputunidad",1,"float-right","form-control","form-control-sm",2,"display","block","width","95px","margin-right","15px",3,"ngModel","ngModelChange","change"],["value","10"],["value","20",4,"ngIf"],["value","50",4,"ngIf"],["value","20"],["value","50"],[1,"table-responsive"],[1,"table","table-bordered","table-sm"],[1,"thead-dark"],[4,"ngFor","ngForOf"],["scope","row",1,"text-center"],[1,"btn-sm",3,"disabled","ngClass","click"],[1,"fa","fa-search","fa-sm"],["class","btn-sm btn-outline-success",3,"click",4,"ngIf"],["scope","row",1,"text-right"],["scope","row"],["scope","row",4,"ngIf"],[1,"btn-sm","btn-outline-success",3,"click"],[1,"fa","fa-money","fa-sm"],[1,"badge","badge-success"],[1,"badge","badge-danger"],["class","pagination float-right",4,"ngIf"],[1,"pagination","float-right"],["class","page-item",4,"ngIf"],[1,"page-item","active"],[1,"page-link"],[1,"page-item"],[1,"btn","page-link",3,"click"],[1,"icon-control-rewind","icons"],[1,"icon-control-forward","icons"]],template:function(i,o){1&i&&(a.Xb(0,"div",0),a.Xb(1,"div",1),a.Xb(2,"div",2),a.Xb(3,"div",3),a.Xb(4,"div",4),a.Xb(5,"strong"),a.Dc(6,"Altas y bajas de usuarios - Filtros de busqueda"),a.Wb(),a.Wb(),a.Xb(7,"div",5),a.Xb(8,"div",6),a.Xb(9,"div",7),a.Xb(10,"label",8),a.Dc(11,"Correo Usuario"),a.Wb(),a.Xb(12,"input",9),a.ec("ngModelChange",(function(i){return o.filterParams.email=i})),a.Wb(),a.Wb(),a.Xb(13,"div",10),a.Xb(14,"label",11),a.Dc(15,"Nombre Usuario"),a.Wb(),a.Xb(16,"input",12),a.ec("ngModelChange",(function(i){return o.filterParams.nombre=i})),a.Wb(),a.Wb(),a.Cc(17,l,11,1,"div",13),a.Xb(18,"div",14),a.Xb(19,"label",15),a.Dc(20,"Estatus Usuario"),a.Wb(),a.Xb(21,"div",16),a.Xb(22,"select",17),a.ec("ngModelChange",(function(i){return o.filterParams.estatus=i})),a.Xb(23,"option",18),a.Dc(24,"TODOS"),a.Wb(),a.Xb(25,"option",19),a.Dc(26,"ACTIVO"),a.Wb(),a.Xb(27,"option",20),a.Dc(28,"INACTIVO"),a.Wb(),a.Wb(),a.Xb(29,"p"),a.Dc(30,"\xa0\xa0\xa0\xa0"),a.Wb(),a.Xb(31,"button",21),a.ec("click",(function(){return o.updateDataTable(0,10)})),a.Dc(32,"BUSCAR "),a.Cc(33,d,1,0,"i",22),a.Wb(),a.Xb(34,"p"),a.Dc(35,"\xa0\xa0\xa0\xa0"),a.Wb(),a.Xb(36,"button",23),a.ec("click",(function(){return o.redirectToUser("*")})),a.Dc(37,"NUEVO USUARIO"),a.Wb(),a.Wb(),a.Wb(),a.Wb(),a.Wb(),a.Wb(),a.Wb(),a.Wb(),a.Xb(38,"div",1),a.Xb(39,"div",2),a.Xb(40,"div",3),a.Xb(41,"div",4),a.Xb(42,"strong"),a.Dc(43,"Resultados"),a.Wb(),a.Wb(),a.Xb(44,"div",5),a.Xb(45,"div",1),a.Xb(46,"div",24),a.Cc(47,u,2,0,"div",25),a.Cc(48,f,6,1,"div",26),a.Wb(),a.Wb(),a.Xb(49,"div",1),a.Xb(50,"div",24),a.Cc(51,F,19,2,"div",27),a.Wb(),a.Wb(),a.Wb(),a.Wb(),a.Wb(),a.Wb(),a.Wb()),2&i&&(a.Fb(12),a.mc("ngModel",o.filterParams.email)("disabled",o.filterParams.nombre.length>0),a.Fb(4),a.mc("ngModel",o.filterParams.nombre)("disabled",o.filterParams.email.length>0),a.Fb(1),a.mc("ngIf","recursos-humanos"!=o.module),a.Fb(5),a.mc("ngModel",o.filterParams.estatus),a.Fb(9),a.mc("disabled",o.loading),a.Fb(2),a.mc("ngIf",o.loading),a.Fb(14),a.mc("ngIf",!0===o.page.empty),a.Fb(1),a.mc("ngIf",!1===o.page.empty),a.Fb(3),a.mc("ngIf",0==o.page.empty))},directives:[b.b,b.i,b.l,s.n,b.q,b.m,b.s,s.m,s.l],styles:[""]}),i})()},uwdg:function(i,o,e){"use strict";e.d(o,"a",(function(){return x}));var t=e("mrSG"),a=e("s7LF");class s{constructor(i,o,e){this.tipoDato=i,this.dato=o,this.relevancia=e||0}}var r=e("KZhB");class n{constructor(i){this.nombre=i}}var c=e("8Y7J"),b=e("SVse"),l=e("iInd"),d=e("4ujS"),u=e("ESM5"),m=e("ienR"),g=e("LqlI");const h=["modalConfirmacion"];function f(i,o){if(1&i&&(c.Xb(0,"p"),c.Dc(1),c.Wb()),2&i){const i=o.$implicit;c.Fb(1),c.Ec(i)}}function p(i,o){if(1&i&&(c.Xb(0,"div",69),c.Cc(1,f,2,1,"p",70),c.Wb()),2&i){const i=c.gc();c.Fb(1),c.mc("ngForOf",i.errorMessages)}}function v(i,o){1&i&&(c.Xb(0,"div"),c.Dc(1,"Nececitas un minimo de 2 caracteres. "),c.Wb())}function X(i,o){1&i&&(c.Xb(0,"div"),c.Dc(1,"No mas de 100 caracteres."),c.Wb())}function W(i,o){1&i&&(c.Xb(0,"div"),c.Dc(1,"Hay caracteres invalidos."),c.Wb())}function C(i,o){if(1&i&&(c.Xb(0,"div",71),c.Cc(1,v,2,0,"div",72),c.Cc(2,X,2,0,"div",72),c.Cc(3,W,2,0,"div",72),c.Wb()),2&i){const i=c.gc();c.Fb(1),c.mc("ngIf",i.f.alias.errors.minlength),c.Fb(1),c.mc("ngIf",i.f.alias.errors.maxlength),c.Fb(1),c.mc("ngIf",i.f.alias.errors.pattern)}}function I(i,o){1&i&&(c.Xb(0,"div"),c.Dc(1,"El correo es requerido."),c.Wb())}function D(i,o){1&i&&(c.Xb(0,"div"),c.Dc(1,"La direccion introducida no es valida. "),c.Wb())}function M(i,o){1&i&&(c.Xb(0,"div"),c.Dc(1,"Hay caracteres invalidos."),c.Wb())}function E(i,o){if(1&i&&(c.Xb(0,"div",71),c.Cc(1,I,2,0,"div",72),c.Cc(2,D,2,0,"div",72),c.Cc(3,M,2,0,"div",72),c.Wb()),2&i){const i=c.gc();c.Fb(1),c.mc("ngIf",i.f.email.errors.required),c.Fb(1),c.mc("ngIf",i.f.email.errors.email),c.Fb(1),c.mc("ngIf",i.f.email.errors.pattern)}}function N(i,o){if(1&i&&(c.Xb(0,"option",73),c.Dc(1),c.Wb()),2&i){const i=o.$implicit;c.mc("value",i.nombre),c.Fb(1),c.Ec(i.valor)}}function U(i,o){if(1&i&&(c.Xb(0,"option",73),c.Dc(1),c.Wb()),2&i){const i=o.$implicit;c.mc("value",i.nombre),c.Fb(1),c.Ec(i.valor)}}function F(i,o){if(1&i&&(c.Xb(0,"p",74),c.Dc(1),c.Wb()),2&i){const i=c.gc();c.Fb(1),c.Ec(i.params.success)}}function k(i,o){1&i&&c.Sb(0,"i",77)}function O(i,o){if(1&i){const i=c.Yb();c.Xb(0,"button",75),c.ec("click",(function(){return c.wc(i),c.gc().openModal()})),c.Dc(1," Registrar "),c.Cc(2,k,1,0,"i",76),c.Wb()}if(2&i){const i=c.gc();c.mc("disabled",i.loading),c.Fb(2),c.mc("ngIf",i.loading)}}function A(i,o){1&i&&c.Sb(0,"i",77)}function R(i,o){if(1&i){const i=c.Yb();c.Xb(0,"button",75),c.ec("click",(function(){return c.wc(i),c.gc().openModal()})),c.Dc(1," Actualizar "),c.Cc(2,A,1,0,"i",76),c.Wb()}if(2&i){const i=c.gc();c.mc("disabled",i.loading),c.Fb(2),c.mc("ngIf",i.loading)}}function y(i,o){if(1&i){const i=c.Yb();c.Xb(0,"button",78),c.ec("click",(function(){return c.wc(i),c.gc().update()})),c.Dc(1,"Si"),c.Wb()}}function S(i,o){if(1&i){const i=c.Yb();c.Xb(0,"button",78),c.ec("click",(function(){return c.wc(i),c.gc().register()})),c.Dc(1,"Si"),c.Wb()}}const T=function(i){return{"is-invalid":i}},w=function(){return{dateInputFormat:"DD/MM/YYYY"}};let x=(()=>{class i{constructor(i,o,e,t,a,s){this.datepipe=i,this.route=o,this.catService=e,this.usuarioServicio=t,this.formBuilder=a,this.router=s,this.submitted=!1,this.loading=!1,this.usuario=new r.a,this.errorMessages=[],this.mensajeModal="",this.params={success:"",message:"",id:"*",module:"usuarios",interno:!1},this.oficinas=[],this.bancos=[],this.roles={USUARIO:!0,RECURSOS_HUMANOS:!1,TESORERIA:!1,CONTABILIDAD:!1,GERENCIA_INTERNA:!1,GERENCIA_EXTERNA:!1,ADMINISTRACION:!1,DIRECCION:!1},this.nombreRoles=Object.keys(this.roles)}ngOnInit(){this.maxDate=new Date,this.loading=!0,this.errorMessages=[],this.params.module=this.router.url.split("/")[1],this.antiguedad=new Date,this.catService.getCatalogosByTipo("oficinas").subscribe(i=>this.oficinas=i),this.catService.getCatalogosByTipo("bancos").subscribe(i=>this.bancos=i),this.route.paramMap.subscribe(i=>{const o=i.get("idUsuario");"*"!==o?(this.updateUserInfo(+o),this.registerForm=this.formBuilder.group({email:[{value:this.usuario.email,disabled:!0}],alias:[this.usuario.nombre,[a.r.maxLength(100),a.r.minLength(2),a.r.pattern("^([0-9a-zA-Z\xc0-\xfa.,&-_!\xa1\"' ]+)$")]],activo:[this.usuario.activo],tipo:[this.usuario.tipoUsuario],oficina:[this.usuario.datosUsuario.OFICINA],banco:[this.usuario.datosUsuario.BANCO],noEmpleado:[this.usuario.noEmpleado],cuenta:[this.usuario.datosUsuario.CUENTA],sueldo:[this.usuario.datosUsuario.SUELDO],antiguedad:[new Date(this.usuario.datosUsuario.ANTIGUEDAD)]})):(this.antiguedad=new Date,this.registerForm=this.formBuilder.group({email:[{value:this.usuario.email,disabled:!1},[a.r.required,a.r.email,a.r.pattern("^[a-z0-9A-Z._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],alias:["",[a.r.required,a.r.maxLength(100),a.r.minLength(2),a.r.pattern("^([0-9a-zA-Z\xc0-\xfa.,&-_!\xa1\"' ]+)$")]],activo:[this.usuario.activo],tipo:[this.usuario.tipoUsuario],oficina:[this.usuario.datosUsuario.OFICINA],banco:[this.usuario.datosUsuario.BANCO],noEmpleado:[this.usuario.noEmpleado],cuenta:[this.usuario.datosUsuario.CUENTA],sueldo:[this.usuario.datosUsuario.SUELDO],antiguedad:[new Date(this.usuario.datosUsuario.ANTIGUEDAD)]}),this.loading=!1)})}updateUserInfo(i){this.errorMessages=[],this.usuarioServicio.getUsuario(i).toPromise().then(i=>{this.usuario=i,this.loading=!1,this.antiguedad=new Date(i.datosUsuario.ANTIGUEDAD);for(const o of i.roles)this.roles[o]=!0}).catch(i=>this.errorMessages.push(i))}toggleUserType(){this.usuario.tipoUsuario="INTERNO"===this.usuario.tipoUsuario?"EXTERNO":"INTERNO"}openModal(){this.mensajeModal=void 0!==this.usuario.id?"\xbfActualizar usuario?":"\xbfRegistrar usuario?",this.modalConfirmacion.show()}decline(){this.modalConfirmacion.hide()}get f(){return this.registerForm.controls}update(){if(this.errorMessages=[],this.loading=!0,this.modalConfirmacion.hide(),this.registerForm.invalid)return this.loading=!1,void(this.registerForm.get("alias").invalid&&this.errorMessages.push("Nombre invalido"));this.errorMessages=[],this.usuarioServicio.actualizaUser(this.usuario).toPromise().then(i=>Object(t.a)(this,void 0,void 0,(function*(){void 0!==this.usuario.datosUsuario.ANTIGUEDAD&&(this.usuario.datosUsuario.ANTIGUEDAD=this.datepipe.transform(this.antiguedad,"yyyy-MM-dd"));for(const e in this.usuario.datosUsuario)if(void 0!==e&&void 0!==this.usuario.datosUsuario[e]&&""!==this.usuario.datosUsuario[e]&&null!==this.usuario.datosUsuario[e]&&i.datosUsuario[e]!==this.usuario.datosUsuario[e]){const i=new s(e,this.usuario.datosUsuario[e]);yield this.usuarioServicio.actualizaDatoUsuario(this.usuario.id,e,i).toPromise()}if("administracion"===this.params.module){console.log("Updating user roles");var o=0;for(const i in this.roles)!1===this.roles[i]&&this.usuario.roles.find(o=>o===i)&&(yield this.usuarioServicio.deleteRoles(this.usuario.id,this.nombreRoles[o]).toPromise()),o++;for(const i in this.roles)!0!==this.roles[i]||this.usuario.roles.find(o=>o===i)||(yield this.usuarioServicio.insertarRoles(this.usuario.id,new n(i)).toPromise())}this.submitted=!0,this.params.success="El usuario ha sido actualizado satisfactoriamente."}))).then(()=>this.router.navigate([`../${this.params.module}/usuarios`])).catch(i=>{this.errorMessages.push(i),this.loading=!1})}register(){this.errorMessages=[];let i=0;return console.log("registering",this.registerForm.invalid),this.loading=!0,this.modalConfirmacion.hide(),this.registerForm.get("email").invalid?(this.errorMessages.push("Email invalido"),void(this.loading=!1)):this.registerForm.get("alias").invalid?(this.errorMessages.push("Nombre invalido"),void(this.loading=!1)):this.registerForm.get("activo").invalid?(this.errorMessages.push("El usuario debe ser activo"),void(this.loading=!1)):void 0===this.usuario.noEmpleado||""===this.usuario.noEmpleado?(this.errorMessages.push("Llena el campo de No. de empleado"),void(this.loading=!1)):void 0===this.usuario.datosUsuario.OFICINA||""===this.usuario.datosUsuario.OFICINA||"*"===this.usuario.datosUsuario.OFICINA?(this.errorMessages.push("Llena el campo de oficina"),void(this.loading=!1)):void 0===this.usuario.datosUsuario.BANCO||""===this.usuario.datosUsuario.BANCO||"*"===this.usuario.datosUsuario.BANCO?(this.errorMessages.push("Llena el campo de banco"),void(this.loading=!1)):void 0===this.usuario.datosUsuario.SUELDO||""===this.usuario.datosUsuario.SUELDO||"*"===this.usuario.datosUsuario.SUELDO?(this.errorMessages.push("Llena el campo de sueldo"),void(this.loading=!1)):(this.errorMessages=[],console.log("registering"),this.usuario.datosUsuario.ANTIGUEDAD=this.datepipe.transform(this.antiguedad,"yyyy-MM-dd"),void this.usuarioServicio.insertarUsuario(this.usuario).toPromise().then(o=>Object(t.a)(this,void 0,void 0,(function*(){i=o.id;for(const i in this.usuario.datosUsuario)if(void 0!==i&&void 0!==this.usuario.datosUsuario[i]){const e=this.usuario.datosUsuario[i];yield this.usuarioServicio.insertarDatoUsuario(o.id,new s(i,e)).toPromise()}for(const i in this.roles)!0===this.roles[i]&&(yield this.usuarioServicio.insertarRoles(o.id,new n(i)).toPromise());this.submitted=!0}))).then(()=>this.router.navigate([`../${this.params.module}/usuarios`])).catch(i=>{this.errorMessages.push(i),this.loading=!1}))}updateRoles(){return Object(t.a)(this,void 0,void 0,(function*(){for(const i in this.roles)!1===this.roles[i]&&this.usuario.roles.find(o=>o===i)&&(yield this.usuarioServicio.deleteRoles(this.usuario.id,this.roles[i]).toPromise());for(const i in this.roles)!0!==this.roles[i]||this.usuario.roles.find(o=>o===i)||(yield this.usuarioServicio.insertarRoles(this.usuario.id,new n(i)).toPromise())}))}clearInput(){this.usuario=new r.a,this.params.success="",this.errorMessages=[],this.submitted=!1}}return i.\u0275fac=function(o){return new(o||i)(c.Rb(b.f),c.Rb(l.a),c.Rb(d.a),c.Rb(u.a),c.Rb(a.c),c.Rb(l.c))},i.\u0275cmp=c.Lb({type:i,selectors:[["cybord-usuario"]],viewQuery:function(i,o){var e;1&i&&c.Ic(h,!0),2&i&&c.tc(e=c.fc())&&(o.modalConfirmacion=e.first)},decls:141,vars:48,consts:[[1,"animated","fadeIn"],[1,"row"],[1,"col-sm-12","col-md-12"],[1,"card"],[1,"card-header"],[1,"card-body"],["class","alert alert-warning","role","alert",4,"ngIf"],[1,"col-xs-12","col-sm-12","col-md-8"],[3,"formGroup"],[1,"form-group","row"],[1,"col-md-3","col-form-label"],[1,"col-md-9"],["type","text","formControlName","alias","placeholder","Sobrenombre o alias",1,"form-control",3,"ngClass","ngModel","ngModelChange"],["class","invalid-feedback",4,"ngIf"],["type","text","formControlName","email","placeholder","Correo Electronico",1,"form-control",3,"ngClass","ngModel","ngModelChange"],[1,"col-md-7"],[1,"switch","switch-label","switch-primary"],["type","checkbox","formControlName","activo",1,"switch-input",3,"checked","ngModel","ngModelChange"],["data-checked","ON","data-unchecked","OFF",1,"switch-slider"],[1,"col-md-7","col-form-label"],[1,"form-check"],["formControlName","tipo","type","radio","name","tipo","id","radio3","value","INTERNO",1,"form-check-input",3,"checked","click"],["for","radio3",1,"form-check-label"],["formControlName","tipo","type","radio","name","tipo","id","radio4","value","EXTERNO",1,"form-check-input",3,"checked","click"],["for","radio4",1,"form-check-label"],["type","text","id","no-emp","name","text-inputa","formControlName","noEmpleado","placeholder","No empleado",1,"form-control",3,"ngModel","ngModelChange"],["id","office","name","office","formControlName","oficina",1,"form-control",3,"ngModel","ngModelChange"],["value","*"],[3,"value",4,"ngFor","ngForOf"],["id","bank","name","bank","formControlName","banco",1,"form-control",3,"ngModel","ngModelChange"],["type","text","id","no-account","name","account","formControlName","cuenta","placeholder","0000 0000 0000 0000",1,"form-control",3,"ngModel","ngModelChange"],["type","number","id","quantity","name","text-inputafg","formControlName","sueldo","min","1","placeholder","1.00",1,"form-control",3,"ngModel","ngModelChange"],["id","start-date","type","text","formControlName","antiguedad","bsDatepicker","",1,"form-control",3,"bsValue","bsConfig","bsValueChange"],["dp","bsDatepicker"],[1,"col-xs-12","col-sm-12","col-md-4"],[1,"col-md-9","col-form-label"],["type","checkbox","value","option1","id","checkbox1",1,"form-check-input",3,"ngModel","disabled","ngModelChange"],["for","checkbox1",1,"form-check-label"],["type","checkbox","value","option1","id","checkbox2",1,"form-check-input",3,"ngModel","disabled","ngModelChange"],["for","checkbox2",1,"form-check-label"],[1,"form-check","checkbox"],["type","checkbox","value","option1","id","checkbox3",1,"form-check-input",3,"ngModel","disabled","ngModelChange"],["for","checkbox3",1,"form-check-label"],["type","checkbox","value","option1","id","checkbox4",1,"form-check-input",3,"ngModel","disabled","ngModelChange"],["for","checkbox4",1,"form-check-label"],["type","checkbox","value","option1","id","checkbox5",1,"form-check-input",3,"ngModel","disabled","ngModelChange"],["for","checkbox5",1,"form-check-label"],["type","checkbox","value","option1","id","checkbox8",1,"form-check-input",3,"ngModel","disabled","ngModelChange"],["for","checkbox8",1,"form-check-label"],["type","checkbox","value","option1","id","checkbox7",1,"form-check-input",3,"ngModel","disabled","ngModelChange"],["for","checkbox7",1,"form-check-label"],["type","checkbox","value","option1","id","checkbox6",1,"form-check-input",3,"ngModel","disabled","ngModelChange"],["for","checkbox6",1,"form-check-label"],["class","alert alert-success","role","alert",4,"ngIf"],[1,"card-footer"],[1,"float-right","slide_2"],["class","btn btn-primary",3,"disabled","click",4,"ngIf"],["bsModal","","id","modalConfirmacion","tabindex","-1","role","dialog","aria-labelledby","modalConfirmacion","aria-hidden","true",1,"modal","fade"],["modalConfirmacion","bs-modal"],["role","document",1,"modal-dialog"],[1,"modal-content"],[1,"modal-header"],["id","modalConfirmacionLabel",1,"modal-title"],["type","button","data-dismiss","modal","aria-label","Close",1,"close",3,"click"],["aria-hidden","true"],[1,"modal-body"],[1,"modal-footer"],["type","button","class","btn btn-primary",3,"click",4,"ngIf"],["type","button",1,"btn","btn-secondary",3,"click"],["role","alert",1,"alert","alert-warning"],[4,"ngFor","ngForOf"],[1,"invalid-feedback"],[4,"ngIf"],[3,"value"],["role","alert",1,"alert","alert-success"],[1,"btn","btn-primary",3,"disabled","click"],["class","fa fa-spinner fa-spin",4,"ngIf"],[1,"fa","fa-spinner","fa-spin"],["type","button",1,"btn","btn-primary",3,"click"]],template:function(i,o){1&i&&(c.Xb(0,"div",0),c.Xb(1,"div",1),c.Xb(2,"div",2),c.Xb(3,"div",3),c.Xb(4,"div",4),c.Xb(5,"strong"),c.Dc(6,"Usuarios"),c.Wb(),c.Wb(),c.Xb(7,"div",5),c.Cc(8,p,2,1,"div",6),c.Xb(9,"div",1),c.Xb(10,"div",7),c.Xb(11,"form",8),c.Xb(12,"div",9),c.Xb(13,"strong",10),c.Dc(14,"Nombre"),c.Wb(),c.Xb(15,"div",11),c.Xb(16,"input",12),c.ec("ngModelChange",(function(i){return o.usuario.nombre=i})),c.Wb(),c.Cc(17,C,4,3,"div",13),c.Wb(),c.Wb(),c.Xb(18,"div",9),c.Xb(19,"strong",10),c.Dc(20,"Email"),c.Wb(),c.Xb(21,"div",11),c.Xb(22,"input",14),c.ec("ngModelChange",(function(i){return o.usuario.email=i})),c.Wb(),c.Cc(23,E,4,3,"div",13),c.Wb(),c.Wb(),c.Xb(24,"div",9),c.Xb(25,"strong",10),c.Dc(26,"Usuario activo"),c.Wb(),c.Xb(27,"div",15),c.Xb(28,"label",16),c.Xb(29,"input",17),c.ec("ngModelChange",(function(i){return o.usuario.activo=i})),c.Wb(),c.Sb(30,"span",18),c.Wb(),c.Wb(),c.Wb(),c.Xb(31,"div",9),c.Xb(32,"strong",10),c.Dc(33,"Tipo Usuario"),c.Wb(),c.Xb(34,"div",19),c.Xb(35,"div",20),c.Xb(36,"input",21),c.ec("click",(function(){return o.toggleUserType()})),c.Wb(),c.Xb(37,"label",22),c.Dc(38," INTERNO "),c.Wb(),c.Wb(),c.Xb(39,"div",20),c.Xb(40,"input",23),c.ec("click",(function(){return o.toggleUserType()})),c.Wb(),c.Xb(41,"label",24),c.Dc(42," EXTERNO "),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Xb(43,"div",9),c.Xb(44,"strong",10),c.Dc(45,"No. Empleado"),c.Wb(),c.Xb(46,"div",11),c.Xb(47,"input",25),c.ec("ngModelChange",(function(i){return o.usuario.noEmpleado=i})),c.Wb(),c.Wb(),c.Wb(),c.Xb(48,"div",9),c.Xb(49,"strong",10),c.Dc(50,"Oficina"),c.Wb(),c.Xb(51,"div",15),c.Xb(52,"select",26),c.ec("ngModelChange",(function(i){return o.usuario.datosUsuario.OFICINA=i})),c.Xb(53,"option",27),c.Dc(54,"Seleccionar"),c.Wb(),c.Cc(55,N,2,2,"option",28),c.Wb(),c.Wb(),c.Wb(),c.Xb(56,"div",9),c.Xb(57,"strong",10),c.Dc(58,"BANCO"),c.Wb(),c.Xb(59,"div",15),c.Xb(60,"select",29),c.ec("ngModelChange",(function(i){return o.usuario.datosUsuario.BANCO=i})),c.Xb(61,"option",27),c.Dc(62,"Seleccionar"),c.Wb(),c.Cc(63,U,2,2,"option",28),c.Wb(),c.Wb(),c.Wb(),c.Xb(64,"div",9),c.Xb(65,"strong",10),c.Dc(66,"No. Cuenta"),c.Wb(),c.Xb(67,"div",11),c.Xb(68,"input",30),c.ec("ngModelChange",(function(i){return o.usuario.datosUsuario.CUENTA=i})),c.Wb(),c.Wb(),c.Wb(),c.Xb(69,"div",9),c.Xb(70,"strong",10),c.Dc(71,"Sueldo"),c.Wb(),c.Xb(72,"div",15),c.Xb(73,"input",31),c.ec("ngModelChange",(function(i){return o.usuario.datosUsuario.SUELDO=i})),c.Wb(),c.Wb(),c.Wb(),c.Xb(74,"div",9),c.Xb(75,"strong",10),c.Dc(76,"Fecha Antiguedad"),c.Wb(),c.Xb(77,"div",15),c.Xb(78,"input",32,33),c.ec("bsValueChange",(function(i){return o.antiguedad=i})),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Xb(80,"div",34),c.Xb(81,"div",9),c.Xb(82,"label",10),c.Xb(83,"strong"),c.Dc(84,"Roles"),c.Wb(),c.Wb(),c.Xb(85,"div",35),c.Xb(86,"div",20),c.Xb(87,"input",36),c.ec("ngModelChange",(function(i){return o.roles.USUARIO=i})),c.Wb(),c.Xb(88,"label",37),c.Dc(89," USUARIO "),c.Wb(),c.Wb(),c.Xb(90,"div",20),c.Xb(91,"input",38),c.ec("ngModelChange",(function(i){return o.roles.RECURSOS_HUMANOS=i})),c.Wb(),c.Xb(92,"label",39),c.Dc(93," RECURSOS HUMANOS "),c.Wb(),c.Wb(),c.Xb(94,"div",40),c.Xb(95,"input",41),c.ec("ngModelChange",(function(i){return o.roles.CONTABILIDAD=i})),c.Wb(),c.Xb(96,"label",42),c.Dc(97," CONTABILIDAD "),c.Wb(),c.Wb(),c.Xb(98,"div",40),c.Xb(99,"input",43),c.ec("ngModelChange",(function(i){return o.roles.TESORERIA=i})),c.Wb(),c.Xb(100,"label",44),c.Dc(101," TESORERIA "),c.Wb(),c.Wb(),c.Xb(102,"div",40),c.Xb(103,"input",45),c.ec("ngModelChange",(function(i){return o.roles.GERENCIA_INTERNA=i})),c.Wb(),c.Xb(104,"label",46),c.Dc(105," GERENCIA INTERNA "),c.Wb(),c.Wb(),c.Xb(106,"div",40),c.Xb(107,"input",47),c.ec("ngModelChange",(function(i){return o.roles.GERENCIA_EXTERNA=i})),c.Wb(),c.Xb(108,"label",48),c.Dc(109," GERENCIA EXTERNA "),c.Wb(),c.Wb(),c.Xb(110,"div",40),c.Xb(111,"input",49),c.ec("ngModelChange",(function(i){return o.roles.DIRECCION=i})),c.Wb(),c.Xb(112,"label",50),c.Dc(113," DIRECCION "),c.Wb(),c.Wb(),c.Xb(114,"div",40),c.Xb(115,"input",51),c.ec("ngModelChange",(function(i){return o.roles.ADMINISTRACION=i})),c.Wb(),c.Xb(116,"label",52),c.Dc(117," ADMINISTRACION "),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Sb(118,"br"),c.Cc(119,F,2,1,"p",53),c.Wb(),c.Xb(120,"div",54),c.Xb(121,"div",55),c.Cc(122,O,3,2,"button",56),c.Cc(123,R,3,2,"button",56),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Xb(124,"div",57,58),c.Xb(126,"div",59),c.Xb(127,"div",60),c.Xb(128,"div",61),c.Xb(129,"h5",62),c.Dc(130,"Confirmacion"),c.Wb(),c.Xb(131,"button",63),c.ec("click",(function(){return o.decline()})),c.Xb(132,"span",64),c.Dc(133,"\xd7"),c.Wb(),c.Wb(),c.Wb(),c.Xb(134,"div",65),c.Dc(135),c.Wb(),c.Xb(136,"div",66),c.Cc(137,y,2,0,"button",67),c.Cc(138,S,2,0,"button",67),c.Xb(139,"button",68),c.ec("click",(function(){return o.decline()})),c.Dc(140,"no"),c.Wb(),c.Wb(),c.Wb(),c.Wb(),c.Wb()),2&i&&(c.Fb(8),c.mc("ngIf",o.errorMessages.length>0),c.Fb(3),c.mc("formGroup",o.registerForm),c.Fb(5),c.mc("ngClass",c.pc(43,T,o.submitted&&o.f.alias.errors))("ngModel",o.usuario.nombre),c.Fb(1),c.mc("ngIf",o.submitted&&o.f.alias.errors),c.Fb(5),c.mc("ngClass",c.pc(45,T,o.submitted&&o.f.email.errors))("ngModel",o.usuario.email),c.Fb(1),c.mc("ngIf",o.submitted&&o.f.email.errors),c.Fb(6),c.mc("checked",o.usuario.activo)("ngModel",o.usuario.activo),c.Fb(7),c.mc("checked","INTERNO"===o.usuario.tipoUsuario),c.Fb(4),c.mc("checked","EXTERNO"===o.usuario.tipoUsuario),c.Fb(7),c.mc("ngModel",o.usuario.noEmpleado),c.Fb(5),c.mc("ngModel",o.usuario.datosUsuario.OFICINA),c.Fb(3),c.mc("ngForOf",o.oficinas),c.Fb(5),c.mc("ngModel",o.usuario.datosUsuario.BANCO),c.Fb(3),c.mc("ngForOf",o.bancos),c.Fb(5),c.mc("ngModel",o.usuario.datosUsuario.CUENTA),c.Fb(5),c.mc("ngModel",o.usuario.datosUsuario.SUELDO),c.Fb(5),c.mc("bsValue",o.antiguedad)("bsConfig",c.oc(47,w)),c.Fb(9),c.mc("ngModel",o.roles.USUARIO)("disabled","administracion"!==o.params.module),c.Fb(4),c.mc("ngModel",o.roles.RECURSOS_HUMANOS)("disabled","administracion"!==o.params.module),c.Fb(4),c.mc("ngModel",o.roles.CONTABILIDAD)("disabled","administracion"!==o.params.module),c.Fb(4),c.mc("ngModel",o.roles.TESORERIA)("disabled","administracion"!==o.params.module),c.Fb(4),c.mc("ngModel",o.roles.GERENCIA_INTERNA)("disabled","administracion"!==o.params.module),c.Fb(4),c.mc("ngModel",o.roles.GERENCIA_EXTERNA)("disabled","administracion"!==o.params.module),c.Fb(4),c.mc("ngModel",o.roles.DIRECCION)("disabled","administracion"!==o.params.module),c.Fb(4),c.mc("ngModel",o.roles.ADMINISTRACION)("disabled","administracion"!==o.params.module),c.Fb(4),c.mc("ngIf",o.params.success.length>0),c.Fb(3),c.mc("ngIf",void 0===o.usuario.id),c.Fb(1),c.mc("ngIf",void 0!==o.usuario.id),c.Fb(12),c.Fc(" ",o.mensajeModal," "),c.Fb(2),c.mc("ngIf",void 0!==o.usuario.id),c.Fb(1),c.mc("ngIf",void 0===o.usuario.id))},directives:[b.n,a.t,a.j,a.e,a.b,a.i,a.d,b.l,a.a,a.o,a.q,a.m,a.s,b.m,a.n,m.b,m.a,a.l,g.a],styles:[""]}),i})()}}]);
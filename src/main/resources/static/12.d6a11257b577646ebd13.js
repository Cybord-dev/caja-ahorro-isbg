(window.webpackJsonp=window.webpackJsonp||[]).push([[12],{"z/b6":function(e,o,i){"use strict";i.r(o),i.d(o,"RecursosHumanosModule",(function(){return v}));var t=i("iInd"),a=i("qNWX"),n=i("aBT+"),c=i("uwdg"),s=i("2IH+"),r=i("8Y7J");let b=(()=>{class e{constructor(){}ngOnInit(){}}return e.\u0275fac=function(o){return new(o||e)},e.\u0275cmp=r.Db({type:e,selectors:[["cybord-conciliacion-rh"]],decls:2,vars:0,template:function(e,o){1&e&&(r.Pb(0,"p"),r.uc(1,"conciliacion-rh works!"),r.Ob())},styles:[""]}),e})();var u=i("3k/E"),l=i("KZhB"),d=i("ESM5"),p=i("xKGb"),m=i("s7LF"),f=i("ienR"),h=i("SVse");const O=[{path:"validaciones",component:a.a,data:{title:"Reporte Validaciones"}},{path:"historico",component:s.a,data:{title:"Historico validaciones"}},{path:"conciliacion",component:b,data:{title:"Conciliacion RH"}},{path:"usuarios",component:n.a,data:{title:"Usuarios"}},{path:"usuarios/:idUsuario",component:c.a,data:{title:"Usario ISBG"}},{path:"validacione/:idUsuario",component:(()=>{class e{constructor(e,o,i){this.userService=e,this.solicitudService=o,this.route=i,this.usuario=new l.a,this.errorMessages=[],this.success="",this.bsValue=new Date,this.bsConfig={containerClass:"theme-dark-blue"},this.enabledDates=[new Date("2020-09-15"),new Date("2020-10-01"),new Date("2020-10-15"),new Date("2020-11-01"),new Date("2020-11-15"),new Date("2020-12-01"),new Date("2020-12-15")]}requestSolicitud(e){this.solicitud.idUsuario=this.usuario.id,this.solicitud.status="Solicitud",this.solicitud.tipo=e,this.solicitud.statusDetalle="Solicitud inicial",this.solicitudService.postSolictudUsuario(this.usuario.id,this.solicitud).subscribe(e=>this.success="Se ha enviado la solicitud correctamente")}ngOnInit(){this.solicitud=new u.a,this.route.paramMap.subscribe(e=>{const o=e.get("idUsuario");console.log("id "+o),this.userService.getUsuario(+o).subscribe(e=>{this.usuario=e,this.noEmpleado=Math.floor(60*Math.random())+1,this.oficina=Math.floor(2*Math.random())+1,this.descuentoQuincenal=Math.floor(60*Math.random())+1})})}}return e.\u0275fac=function(o){return new(o||e)(r.Jb(d.a),r.Jb(p.a),r.Jb(t.a))},e.\u0275cmp=r.Db({type:e,selectors:[["cybord-validacion-solicitud"]],decls:83,vars:16,consts:[[1,"animated","fadeIn"],[1,"row"],[1,"col-sm-12","col-md-12"],[1,"card"],[1,"card-header"],[1,"card-body"],[1,"col-xs-12","col-sm-12","col-md-6","form-group"],["action","","method","post","enctype","multipart/form-data",1,"form-horizontal"],[1,"form-group","row"],[1,"col-md-3","col-form-label"],[1,"col-md-9"],[1,"form-control-static"],["for","no-emp",1,"col-md-3","col-form-label"],["type","number","id","no-emp","name","text-input","placeholder","No empleado",1,"form-control",3,"ngModel","ngModelChange"],[1,"help-block"],["for","office",1,"col-md-3","col-form-label"],["id","office","name","office",1,"form-control",3,"ngModel","ngModelChange"],["value","*"],["value","1"],["value","2"],["value","3"],["value","4"],["for","quantity",1,"col-md-3","col-form-label"],["type","number","id","quantity","name","text-input","min","100","placeholder","100.00",1,"form-control",3,"ngModel","ngModelChange"],["for","start-date",1,"col-md-3","col-form-label"],["id","start-date","type","text","bsDatepicker","",1,"form-control",3,"bsConfig","datesEnabled","bsValue"],["dp","bsDatepicker"],["type","button",1,"btn","btn-sm","btn-success",3,"click"],[1,"fa","fa-dot-circle-o"],["type","button",1,"btn","btn-sm","btn-danger",3,"click"]],template:function(e,o){1&e&&(r.Pb(0,"div",0),r.Pb(1,"div",1),r.Pb(2,"div",2),r.Pb(3,"div",3),r.Pb(4,"div",4),r.Pb(5,"strong"),r.uc(6,"Tr\xe1mites ahorro"),r.Ob(),r.Ob(),r.Pb(7,"div",5),r.Pb(8,"div",1),r.Pb(9,"div",6),r.Pb(10,"form",7),r.Pb(11,"div",8),r.Pb(12,"label",9),r.uc(13,"Nombre"),r.Ob(),r.Pb(14,"div",10),r.Pb(15,"p",11),r.Pb(16,"strong"),r.uc(17),r.Ob(),r.Ob(),r.Ob(),r.Ob(),r.Pb(18,"div",8),r.Pb(19,"label",12),r.uc(20,"No. empleado"),r.Ob(),r.Pb(21,"div",10),r.Pb(22,"input",13),r.Wb("ngModelChange",(function(e){return o.noEmpleado=e})),r.Ob(),r.Pb(23,"span",14),r.uc(24,"Introducir no. empleado"),r.Ob(),r.Ob(),r.Ob(),r.Pb(25,"div",8),r.Pb(26,"label",15),r.uc(27,"Oficina"),r.Ob(),r.Pb(28,"div",10),r.Pb(29,"select",16),r.Wb("ngModelChange",(function(e){return o.oficina=e})),r.Pb(30,"option",17),r.uc(31,"Seleccionar"),r.Ob(),r.Pb(32,"option",18),r.uc(33,"Oficina #1"),r.Ob(),r.Pb(34,"option",19),r.uc(35,"Oficina #2"),r.Ob(),r.Pb(36,"option",20),r.uc(37,"Oficina #3"),r.Ob(),r.Pb(38,"option",21),r.uc(39,"Oficina #4"),r.Ob(),r.Ob(),r.Ob(),r.Ob(),r.Pb(40,"div",8),r.Pb(41,"label",22),r.uc(42,"Descuento quincenal"),r.Ob(),r.Pb(43,"div",10),r.Pb(44,"input",23),r.Wb("ngModelChange",(function(e){return o.descuentoQuincenal=e})),r.Ob(),r.Pb(45,"span",14),r.uc(46,"Descuento quincenal"),r.Ob(),r.Ob(),r.Ob(),r.Pb(47,"div",8),r.Pb(48,"label",24),r.uc(49,"Fecha inicio"),r.Ob(),r.Pb(50,"div",10),r.Kb(51,"input",25,26),r.Pb(53,"span",14),r.uc(54,"fecha inicio descuentos"),r.Ob(),r.Ob(),r.Ob(),r.Ob(),r.Ob(),r.Pb(55,"div",6),r.Pb(56,"span",14),r.uc(57," Yo "),r.Pb(58,"strong"),r.uc(59),r.Ob(),r.uc(60," con n\xfamero de trabajador "),r.Pb(61,"strong"),r.uc(62),r.Ob(),r.uc(63," adscrito a la Oficina "),r.Pb(64,"strong"),r.uc(65),r.Ob(),r.uc(66," autorizo que por este medio se descuente de mi pago de n\xf3mina, la cantidad de "),r.Pb(67,"strong"),r.uc(68),r.Zb(69,"currency"),r.Ob(),r.uc(70,"de manera quincenal a partir de la siguiente fecha "),r.Pb(71,"strong"),r.uc(72),r.Zb(73,"date"),r.Ob(),r.uc(74,", durante el per\xedodo correspondiente, autorizo que la cantidad retenida sea depositada en la cuenta del PROGRAMA DE AHORRO VOLUNTARIO. Estoy de acuerdo que la cantidad ahorrada y los intereses que se hubiesen generado me sean entregados al t\xe9rmino del per\xedodo. "),r.Ob(),r.Kb(75,"br"),r.Kb(76,"br"),r.Pb(77,"button",27),r.Wb("click",(function(){return o.requestSolicitud("SolicitudAhorro")})),r.Kb(78,"i",28),r.uc(79,"\xa0 Validar solicitud"),r.Ob(),r.Pb(80,"button",29),r.Wb("click",(function(){return o.requestSolicitud("SolicitudAhorro")})),r.Kb(81,"i",28),r.uc(82,"\xa0 Rechazar solicitud"),r.Ob(),r.Ob(),r.Ob(),r.Ob(),r.Ob(),r.Ob(),r.Ob(),r.Ob()),2&e&&(r.xb(17),r.vc(o.usuario.nombre),r.xb(5),r.ec("ngModel",o.noEmpleado),r.xb(7),r.ec("ngModel",o.oficina),r.xb(15),r.ec("ngModel",o.descuentoQuincenal),r.xb(7),r.ec("bsConfig",o.bsConfig)("datesEnabled",o.enabledDates)("bsValue",o.bsValue),r.xb(8),r.vc(o.usuario.nombre),r.xb(3),r.vc(o.noEmpleado),r.xb(3),r.vc(o.oficina),r.xb(3),r.wc("",r.ac(69,12,o.descuentoQuincenal)," "),r.xb(4),r.vc(r.ac(73,14,o.bsValue)))},directives:[m.s,m.j,m.k,m.n,m.b,m.i,m.l,m.p,m.m,m.r,f.b,f.a],pipes:[h.d,h.f],styles:[""]}),e})(),data:{title:"Usario ISBG"}}];let P=(()=>{class e{}return e.\u0275mod=r.Hb({type:e}),e.\u0275inj=r.Gb({factory:function(o){return new(o||e)},imports:[[t.g.forChild(O)],t.g]}),e})();var g=i("65jD");let v=(()=>{class e{}return e.\u0275mod=r.Hb({type:e}),e.\u0275inj=r.Gb({factory:function(o){return new(o||e)},imports:[[g.CommonsPagesModule,P]]}),e})()}}]);
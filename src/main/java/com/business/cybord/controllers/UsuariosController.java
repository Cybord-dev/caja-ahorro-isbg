package com.business.cybord.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.business.cybord.models.dtos.UsuariosDto;
import com.business.cybord.services.UsuarioService;

import com.business.cybord.util.EnumAtributos;
import com.business.cybord.util.TipoParametro;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private UsuarioService service;

	@GetMapping("/{id}")
	public ResponseEntity<UsuariosDto> getUserById(@PathVariable Integer id) {
		return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
	}


	@SuppressWarnings("serial")
	@GetMapping
	public ResponseEntity<Page<UsuariosDto>> getUsuariosPorParametrosController(		
			@RequestParam(name = "nombre", defaultValue = "") String nombre,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "page", defaultValue = "0") String page,
			@RequestParam(name = "size", defaultValue = "10") String size) {
		List<TipoParametro> params = new ArrayList<TipoParametro>(){
			{  
				 add(new TipoParametro(EnumAtributos.NOMBRE,nombre));
				 add(new TipoParametro(EnumAtributos.EMAIL,email));
			}};			
		return new ResponseEntity<>(service.getUsuariosPorParametros(params, page, size), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UsuariosDto> insertarNuevoUsuario(@RequestBody @Valid UsuariosDto usuarioDto) {
		return new ResponseEntity<>(service.insertarNuevoUsuario(usuarioDto), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<UsuariosDto> actualizarUsuario(@RequestBody @Valid UsuariosDto userDto) {
		return new ResponseEntity<>(service.actualizarUsuario(userDto), HttpStatus.OK);
	}

}

package com.business.cybord.services;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.mappers.UsuariosMapper;
import com.business.cybord.models.dtos.CapacidadPagoDto;
import com.business.cybord.models.dtos.MenuItem;
import com.business.cybord.models.dtos.RecursoDto;
import com.business.cybord.models.dtos.UserInfoDto;
import com.business.cybord.models.dtos.UsuarioDto;
import com.business.cybord.models.dtos.composed.UserAhorroDto;
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.repositories.dao.UserRepositoryDao;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UsuarioService {

	@Autowired
	private UsuariosRepository repository;

	@Autowired
	private UsuariosMapper mapper;

	@Autowired
	private DownloaderService reportService;

	@Autowired
	private UserRepositoryDao userRepositoryDao;
	
	@Autowired
	private PrestamoService prestamoService;

	private ObjectMapper objMapper = new ObjectMapper();

	private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

	public Page<UserAhorroDto> getAllUsuarios(Map<String, String> parameters) {
		int page = (parameters.get("page") == null) ? 0 : Integer.valueOf(parameters.get("page"));
		int size = (parameters.get("size") == null) ? 10 : Integer.valueOf(parameters.get("size"));
		return userRepositoryDao.findAll(parameters, PageRequest.of(page, size, Sort.by("fechaActualizacion")));
	}

	public RecursoDto descargaReporteUsuarios(Map<String, String> parameters) throws IOException {
		Page<UserAhorroDto> userPage = getAllUsuarios(parameters);

		List<Map<String, String>> data = userPage.getContent().stream().map(u -> {
			Map<String, String> map = new HashMap<>();
			map.put("NO EMPLEADO", u.getNoEmpleado());
			map.put("NOMBRE", u.getNombre());
			map.put("TIPO", u.getTipoUsuario());
			map.put("ACTIVO", u.getActivo() ? "SI" : "NO");
			map.put("EMAIL", u.getEmail());
			return map;
		}).collect(Collectors.toList());

		return reportService.generateBase64Report(String.format("USUARIOS_%tF", new Date()), data);
	}

	public UsuarioDto getUserById(Integer id) {
		log.info("Buscando usuario con id : {}", id);
		Usuario entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("Usuario con el Id %d no existe ", id)));
		return mapper.getDtoFromUserEntity(entity);
	}

	public UsuarioDto getUserByNoEmpleado(String noEmpleado) {
		log.info("Buscando usuario con id : {}", noEmpleado);
		Usuario entity = repository.findByNoEmpleado(noEmpleado)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("Usuario con numero de empleado  %s no existe", noEmpleado)));
		return mapper.getDtoFromUserEntity(entity);
	}

	public UsuarioDto insertarNuevoUsuario(UsuarioDto usuario) {
		Optional<Usuario> entity = repository.findByEmail(usuario.getEmail());
		if (entity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("Ese correo ya ha sido registrado"));
		} else {
			Usuario datos = repository.save(mapper.getEntityFromUserDto(usuario));
			return mapper.getDtoFromUserEntity(datos);
		}
	}

	public UsuarioDto actualizarUsuario(UsuarioDto usuario, int id) {
		Usuario entity = repository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("El usuario no existe.")));
		entity.setEmail(usuario.getEmail());
		entity.setActivo(usuario.getActivo());
		entity.setNombre(usuario.getNombre());
		entity.setTipoUsuario(usuario.getTipoUsuario());
		entity.setNoEmpleado(usuario.getNoEmpleado());
		return mapper.getDtoFromUserEntity(repository.save(entity));
	}
	
	
	public CapacidadPagoDto calculoCapacidadPago(String noEmpleado) {
		CapacidadPagoDto capacidad = new CapacidadPagoDto();
		
		UsuarioDto usuario = getUserByNoEmpleado(noEmpleado);
		BigDecimal sueldo = new BigDecimal(usuario.getDatosUsuario().get("SUELDO"));
		// TODO code a better algorith for payment capacity
		capacidad.setCapacidadPago(sueldo.multiply(BigDecimal.valueOf(Math.random()/3))); 
		capacidad.setPrestamosActivos(prestamoService.getPrestamosdeUnUsuarioPorSuId(usuario.getId()));
		capacidad.setAvalados(new ArrayList<>());
		return capacidad;
	}

	public UserInfoDto getUserInfo(Authentication auth) {
		OidcUser oidcUser = (OidcUser) auth.getPrincipal();
		if (oidcUser != null && oidcUser.getAttributes() != null && oidcUser.getEmail() != null) {
			log.info("Looking roles from : {}", oidcUser.getEmail());
			Usuario usuario = repository.findByEmail(oidcUser.getEmail())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED,
							String.format("%s no se encuentra registrado en la plataforma", oidcUser.getEmail())));

			UserInfoDto userInfo = mapper.getUserInfoFromUsuario(usuario);
			if (!userInfo.getActivo()) {
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
						String.format("%s es un usuario inactivo", "Usuario inactivo"));
			}
			userInfo.setUrlImagenPerfil(oidcUser.getAttributes().get("picture").toString());
			List<MenuItem> menu = new ArrayList<>();
			for (String role : userInfo.getRoles()) {
				menu.addAll(getMenuFromResource(role.toLowerCase()));
			}
			userInfo.setMenu(menu);
			return userInfo;
		}
		log.error("Usuario sin credenciales intenta acceder a la plataforma.");
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
				String.format("%s no es un usuario autorizado", "anonymous"));
	}
	

	private List<MenuItem> getMenuFromResource(String fileName) {
		try {
			List<MenuItem> menu = new ArrayList<>();
			menu.add(new MenuItem(fileName, true));
			InputStream is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(String.format("menus/%s.json", fileName));
			if (is != null) {
				menu.add(objMapper.readValue(is, MenuItem.class));
			}
			return menu;
		} catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	public List<UsuarioDto> findByTipoUsuarioAndAhorrador(String tipoUsuario, Boolean ahorrador) {
		return mapper.getDtosFromEntities(repository.findByTipoUsuarioAndAhorrador(tipoUsuario, ahorrador));
	}

}

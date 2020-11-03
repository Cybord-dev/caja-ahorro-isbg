package com.business.cybord.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.mappers.UsuariosMapper;
import com.business.cybord.models.dtos.MenuItem;
import com.business.cybord.models.dtos.RecursoDto;
import com.business.cybord.models.dtos.UserInfoDto;
import com.business.cybord.models.dtos.UsuarioDto;
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.repositories.DatosUsuarioRepository;
import com.business.cybord.repositories.UsuariosRepository;
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
	private DatosUsuarioRepository datosUsuarioRepository;

	private ObjectMapper objMapper = new ObjectMapper();

	private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

	private Specification<Usuario> buildSearchFilters(Map<String, String> parameters) {
		log.info("Finding facturas by {}", parameters);
		return new Specification<Usuario>() {
			private static final long serialVersionUID = -7435096122716669730L;

			@Override
			public Predicate toPredicate(Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				List<String> filtros = Arrays.asList(new String[] { "nombre", "email", "tipoUsuario" });
				for (String i : filtros) {
					if (parameters.get(i) != null)
						predicates.add(
								criteriaBuilder.and(criteriaBuilder.like(root.get(i), "%" + parameters.get(i) + "%")));
				}

				if (parameters.get("estatus") != null) {
					predicates.add(criteriaBuilder.and(
							criteriaBuilder.equal(root.get("activo"), Integer.parseInt(parameters.get("estatus")))));
				}
				if (parameters.get("noEmpleado") != null) {
					predicates.add(criteriaBuilder
							.and(criteriaBuilder.equal(root.get("noEmpleado"), parameters.get("noEmpleado"))));
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
	}

	public Page<UsuarioDto> getUsuariosPorParametros(Map<String, String> parameters) {
		int page = (parameters.get("page") == null) ? 0 : Integer.valueOf(parameters.get("page"));
		int size = (parameters.get("size") == null) ? 10 : Integer.valueOf(parameters.get("size"));
		Page<Usuario> result = repository.findAll(buildSearchFilters(parameters),
				PageRequest.of(page, size, Sort.by("fechaActualizacion").descending()));	
		return new PageImpl<>(mapper.getDtosFromEntities(result.getContent()), result.getPageable(),
				result.getTotalElements());
	}
	
	public RecursoDto descargaReporteUsuarios(Map<String, String> parameters) throws IOException {
		Page<UsuarioDto> userPage = getUsuariosPorParametros(parameters);
		
		List<Map<String, String>> data = userPage.getContent().stream().map(u -> {
			Map<String, String> map = new HashMap<>();
			map.put("NO EMPLEADO", u.getNoEmpleado());
			map.put("NOMBRE", u.getNombre());
			map.put("TIPO", u.getTipoUsuario());
			map.put("ACTIVO", u.getActivo()?"SI":"NO");
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

	public UsuarioDto getUserByNoEmpleado(String id) {
		log.info("Buscando usuario con id : {}", id);
		Usuario entity = repository.findByNoEmpleado(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("Usuario con numero de empleado  %s no existe", id)));
		return mapper.getDtoFromUserEntity(entity);
	}

	public UsuarioDto insertarNuevoUsuario(UsuarioDto usuario) {
		Optional<Usuario> entity = repository.findByEmail(usuario.getEmail());
		if (entity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("El dato %s ya existe", usuario.getEmail()));
		} else {
			Usuario datos = repository.save(mapper.getEntityFromUserDto(usuario));
			return mapper.getDtoFromUserEntity(datos);
		}
	}

	public UsuarioDto actualizarUsuario(UsuarioDto usuario, int id) {
		Usuario entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("El usuario %s no existe.", usuario.getEmail())));
		entity.setActivo(usuario.getActivo());
		entity.setNombre(usuario.getNombre());
		entity.setTipoUsuario(usuario.getTipoUsuario());
		entity.setNoEmpleado(usuario.getNoEmpleado());
		return mapper.getDtoFromUserEntity(repository.save(entity));
	}

	public void borrarUsuario(Integer id) {
		Usuario entity = repository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("El Usuario no existe %d", id)));
		datosUsuarioRepository.findByIdUsuario(id).stream().forEach(a -> datosUsuarioRepository.delete(a));
		repository.delete(entity);
	}

//	public UserInfoDto getUserInfo(Authentication auth) {
//		OidcUser oidcUser = (OidcUser) auth.getPrincipal();
//		if (oidcUser != null && oidcUser.getAttributes() != null && oidcUser.getEmail() != null) {
//			log.info("Looking roles from : {}", oidcUser.getEmail());
//			Usuario usuario = repository.findByEmail(oidcUser.getEmail())
//					.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED,
//							String.format("%s no se encuentra registrado en la plataforma", oidcUser.getEmail())));
//
//			UserInfoDto userInfo = mapper.getUserInfoFromUsuario(usuario);
//			userInfo.setUrlImagenPerfil(oidcUser.getAttributes().get("picture").toString());
//			List<MenuItem> menu = new ArrayList<>();
//			for (String role : userInfo.getRoles()) {
//				menu.addAll(getMenuFromResource(role.toLowerCase()));
//			}
//			userInfo.setMenu(menu);
//			return userInfo;
//		}
//		log.error("Usuario sin credenciales intenta acceder a la plataforma.");
//		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
//				String.format("%s no es un usuario autorizado", "anonymous"));
//	}
	
	public UserInfoDto getUserInfo(Authentication auth){
		// OidcUser oidcUser =(OidcUser)auth.getPrincipal();
		// if(oidcUser!=null && oidcUser.getAttributes()!=null && oidcUser.getEmail()!=null) {
		// log.info("Looking roles from : {}", oidcUser.getEmail());
		// Usuario usuario = repository.findByEmail(oidcUser.getEmail())
		// .orElseThrow(()-> new ResponseStatusException(HttpStatus.UNAUTHORIZED, String.format("%s no se encuentra registrado en la plataforma",oidcUser.getEmail())));
		Usuario usuario = repository.findByEmail("edcgamer@gmail.com")
		.orElseThrow(()-> new ResponseStatusException(HttpStatus.UNAUTHORIZED, String.format("%s no se encuentra registrado en la plataforma","edcgamer@gmail.com")));
		UserInfoDto userInfo = mapper.getUserInfoFromUsuario(usuario);
		List<MenuItem> menu = new ArrayList<>();
		for (String role : userInfo.getRoles()) {
		menu.addAll(getMenuFromResource(role.toLowerCase()));
		}
		userInfo.setMenu(menu);
		return userInfo;
		// }
		// log.error("Usuario sin credenciales intenta acceder a la plataforma.");
		// throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, String.format("%s no es un usuario autorizado", "anonymous"));
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

}

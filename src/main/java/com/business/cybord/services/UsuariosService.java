package com.business.cybord.services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.entities.AtributoSolicitud;
import com.business.cybord.entities.DatosUsuario;
import com.business.cybord.entities.Solicitud;
import com.business.cybord.entities.Usuario;
import com.business.cybord.entities.Validacion;
import com.business.cybord.mappers.SolicitudMapper;
import com.business.cybord.mappers.UsuariosMapper;
import com.business.cybord.models.dtos.AtributoSolicitudDto;
import com.business.cybord.models.dtos.DatosUsuarioDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.UsuariosDto;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.repositories.AtributoSolicitudRepository;
import com.business.cybord.repositories.DatosUsuarioRepository;
import com.business.cybord.repositories.SolicitudRepository;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.repositories.ValidacionRepository;

@Service
public class UsuariosService {

	@Autowired
	private UsuariosRepository repository;

	@Autowired
	private UsuariosMapper mapper;
	
	@Autowired
	private SolicitudMapper mapperSol;
	
	@Autowired
	private DatosUsuarioRepository datosUsuarioRepository;
	
	@Autowired
	private SolicitudRepository solicitudRepository;
	
	@Autowired
	private ValidacionRepository validacionRepository;
	
	@Autowired
	private AtributoSolicitudRepository atribRepository;
	
	@Autowired
	private SolicitudMapper solicitudMapper;
	
	
	private static final Logger log = LoggerFactory.getLogger(UsuariosService.class);
	

	private Specification<Usuario> buildSearchFilters(Map<String, String> parameters){
		log.info("Finding facturas by {}", parameters);	
		return new Specification<Usuario>() {
			private static final long serialVersionUID = -7435096122716669730L;
			@Override
			public Predicate toPredicate(Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				 List<Predicate> predicates = new ArrayList<>();
				 List<String> filtros = Arrays.asList(new String[]{"nombre", "email","tipoUsuario"});
				for (String i : filtros) {
					 if(parameters.get(i)!=null) 
						 predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get(i),"%"+parameters.get(i)+"%")));
				}	  
				 return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
	}
	
	public Page<UsuariosDto> getUsuariosPorParametros(Map<String, String> parameters) {
		
		int page = (parameters.get("page")==null)?0:Integer.valueOf(parameters.get("page"));
		int size = (parameters.get("size")==null)?10:Integer.valueOf(parameters.get("size"));	
		Page<Usuario> result = repository.findAll(buildSearchFilters(parameters), PageRequest.of(page, size,Sort.by("fechaActualizacion").descending()));
		return new PageImpl<>(mapper.getUsuariosDtoFromEntities(result.getContent()), result.getPageable(),result.getTotalElements());
	}


	public UsuariosDto getUserById(Integer id) {
		log.info("Buscando usuario con id : {}", id);
		Usuario entity = repository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("user no existe %d", id)));
		return mapper.getDtoFromUserEntity(entity);
	}
	
	public UsuariosDto insertarNuevoUsuario(UsuariosDto usuario) {
		log.info("Buscando usuario con eee : {}", usuario.getEmail());
		Optional<Usuario> entity = repository.findByEmail(usuario.getEmail());		
		if (entity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,String.format("El dato %s ya existe", usuario.getEmail()));		
		}
		else {	
			Usuario datos = repository.save(mapper.getEntityFromUserDto(usuario));
			return mapper.getDtoFromUserEntity(datos);		
		}						
	}
	
	
	public UsuariosDto actualizarUsuario(UsuariosDto usuario) {
		Usuario entity = repository.findByEmail(usuario.getEmail()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("El usuario %s no existe.", usuario.getEmail())));
		entity.setActivo(usuario.getActivo());
		entity.setNombre(usuario.getNombre());
		entity.setTipoUsuario(usuario.getTipoUsuario());
		entity.setNombre(usuario.getNombre());
		entity.setDatosUsuario(usuario.getDatosUsuario());
		
		return mapper.getDtoFromUserEntity(repository.save(entity));
	}
	
	public void borrarUsuario(Integer id) {
		Usuario entity = repository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("El Usuario no existe %d", id)));
		
		datosUsuarioRepository.findByIdUsuario(id).stream().forEach(a->datosUsuarioRepository.delete(a));
		repository.delete(entity);
	}
	
	///

	public DatosUsuarioDto insertarNuevoDatoUsuario(DatosUsuarioDto datosUsuario) {
		
		Optional<DatosUsuario> datosusuarioEntity = datosUsuarioRepository.findByTipoDatoAndIdUsuario(datosUsuario.getTipoDato(),datosUsuario.getIdUsuario());
	
		if (datosusuarioEntity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,String.format("El dato %s ya existe", datosUsuario.getTipoDato()));
			
		}
		else {
			
			DatosUsuario datos = datosUsuarioRepository.save(mapper.getDatosEntityFromDatosUsuarioDto(datosUsuario));	
			return mapper.getDtoFromDatosusuarioEntity(datos);		
		}
			
	}
	
	public DatosUsuarioDto actualizarDatoUsuario(DatosUsuarioDto datosUsuario) {
		Optional<DatosUsuario> datosusuarioEntity = datosUsuarioRepository.findByTipoDatoAndIdUsuario(datosUsuario.getTipoDato(),datosUsuario.getIdUsuario());
		if (datosusuarioEntity.isPresent()) {			
			datosusuarioEntity.get().setDato(datosUsuario.getDato());
			datosusuarioEntity.get().setRelevancia(datosUsuario.isRelevancia());			
			return mapper.getDtoFromDatosusuarioEntity(datosUsuarioRepository.save(datosusuarioEntity.get()));
		}
		else
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,String.format("El dato %s no existe", datosUsuario.getTipoDato()));	
	}
	
	public void borraDatoUsuario(Integer id) {
		DatosUsuario entity = datosUsuarioRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("El Dato no existe %s", id)));
		datosUsuarioRepository.delete(entity);
	}
	
	/*
	 * Solicitudes
	 * */
	public SolicitudDto actualizarSolicitudbyId(int id_usuario, int id_solicitud, SolicitudDto nueva) {
		Optional<Solicitud> solicitud = solicitudRepository.findByIdUsuarioAndId(id_usuario, id_solicitud);
		if(solicitud.isPresent()) {
			solicitud.get().update(mapper.getEntityFromSolicitudDto(nueva));
			return solicitudMapper.getDtoFromSolicitudEntity(solicitud.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("la solicitud id=%d no existe con el usuario id=%d", id_solicitud, id_usuario));
		}
	}
	
	public SolicitudDto crearSolicitudUsuario(int id_usuario, SolicitudDto solicitud) {
		Usuario usuario = repository.findById(id_usuario).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("el usuario id= %d no existe", id_usuario)));
		Solicitud nueva = solicitudRepository.save(mapper.getEntityFromSolicitudDto(solicitud));
		return mapper.getDtoFromSolicitudEntity(nueva);
		
	}
	
	public List<SolicitudDto> getAllSolicitudes(int id_usuario){
		List<Solicitud> solicitudes = new ArrayList<>();
		solicitudRepository.findByIdUsuario(id_usuario).forEach(solicitudes::add);
		return mapperSol.SolicitudDtoToSolicitud((solicitudes.stream()));
	}
	
	public SolicitudDto getSolicitudById(int id_usuario, int id_solicitud) {
		Optional<Solicitud> solicitud = solicitudRepository.findByIdUsuarioAndId(id_usuario, id_solicitud);
		if(solicitud.isPresent()) {
			return mapper.getDtoFromSolicitudEntity(solicitud.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("la solicitud id=%d no existe con el usuario id=%d", id_solicitud, id_usuario));
		}
	}
	
	public void deleteSolicitudById(int id_usuario, int id_solicitud) {
		Optional<Solicitud> solicitud = solicitudRepository.findByIdUsuarioAndId(id_usuario, id_solicitud);
		if(solicitud.isPresent()) {
			solicitudRepository.delete(solicitud.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("la solicitud id=%d no existe con el usuario id=%d", id_solicitud, id_usuario));
		}
	}
	
	/*
	 * Validaciones
	 * */
	public ValidacionDto crearValidacion(int id_usuario, int id_solicitud,ValidacionDto validacion) {
		Optional<Solicitud> solicitud = solicitudRepository.findByIdUsuarioAndId(id_usuario, id_solicitud);
		if(!solicitud.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("solicitud id= %d del usuario id=%d no existe", id_solicitud, id_usuario));
		}else {
			Validacion nueva = validacionRepository.save(solicitudMapper.getEntityFromValidacionesDto(validacion));
			return solicitudMapper.getDtoFromValidacionesEntity(nueva);
		}
	}
	
	public ValidacionDto actualizarValidacionById(int idUsuario, int idSolicitud, int idValidacion, ValidacionDto nueva) {
		Optional<Validacion> validacion = validacionRepository.findByIdUsuarioAndIdAndIdSolicitud(idUsuario, idValidacion, idSolicitud);
		if(validacion.isPresent()) {
			validacion.get().update(solicitudMapper.getEntityFromValidacionesDto(nueva));
			return solicitudMapper.getDtoFromValidacionesEntity(validacion.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("la validacion id= %d perteneciente a solicitud id=%d validada por usuario id=%d no existe", idValidacion, idSolicitud, idValidacion));
		}
	}
	
	public ValidacionDto getValidacionById(int id_usuario, int id_solicitud, int id_validacion) {
		Validacion entity = validacionRepository.findByIdUsuarioAndIdAndIdSolicitud(id_usuario, id_validacion, id_solicitud).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("La validacion id=%d no existe", id_validacion)));
		return mapperSol.getDtoFromValidacionesEntity(entity);
	}
	
	public void deleteValidacionById(int id_usuario, int id_solicitud, int id_validacion) {
		Optional<Validacion> entity = validacionRepository.findByIdUsuarioAndIdAndIdSolicitud(id_usuario, id_validacion, id_solicitud);
		if(entity.isPresent()) {
			validacionRepository.delete(entity.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("La validacion id=%d no existe", id_validacion));
		}
		
	}
	
	/*Atributos*/
	
	public AtributoSolicitudDto createAtributoSolicitud(int id_usuario, int id_solicitud, AtributoSolicitudDto atributo) {
		Solicitud entity = solicitudRepository.findByIdUsuarioAndId(id_usuario, id_solicitud).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("la solicitud id= %d del usuario =%d no existe", id_solicitud, id_usuario)));
		AtributoSolicitud nuevo = atribRepository.save(mapperSol.getEntityFromAtributoSolicitudDto(atributo));
		return mapperSol.getDtoFromAtributoSolicitudEntity(nuevo);
	}
	
	public AtributoSolicitudDto actualizarAtributoSolicitud(int id_usuario, int id_solicitud, int id_atributo, AtributoSolicitudDto nuevo) {
		Optional<AtributoSolicitud> atributo = atribRepository.findByIdSolicitudAndId(id_solicitud, id_atributo);
		if(atributo.isPresent()) {
			atributo.get().update(mapperSol.getEntityFromAtributoSolicitudDto(nuevo));
			return mapperSol.getDtoFromAtributoSolicitudEntity(atributo.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("el atributo id= %d de la solicitud id=%d del usuario id=%d no existe", id_atributo, id_solicitud, id_usuario));
		}
	}
	
	public AtributoSolicitudDto getAtributoSolicitudById(int id_usuario, int id_solicitud, int id_atributo) {
		Solicitud sol = solicitudRepository.findByIdUsuarioAndId(id_usuario, id_solicitud).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("La solicitud id=%d no existe del usuario id =%d", id_solicitud, id_usuario)));
		Optional<AtributoSolicitud> entity = atribRepository.findByIdSolicitudAndId(id_solicitud, id_atributo);
		if(entity.isPresent()) {
			return mapperSol.getDtoFromAtributoSolicitudEntity(entity.get());
			
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("La el atributo-solicitud id=%d no existe", id_atributo));
		}
		
	}
	
	public void deleteAtributoSolicitudById(int id_usuario, int id_solicitud, int id_atributo) {
		Optional<AtributoSolicitud> entity = atribRepository.findByIdSolicitudAndId(id_solicitud, id_atributo);
		if(entity.isPresent()) {
			atribRepository.delete(entity.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("La el atributo-solicitud id=%d no existe", id_atributo));
		}
		
	}
	
}

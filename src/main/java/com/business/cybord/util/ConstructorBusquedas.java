package com.business.cybord.util;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

public class ConstructorBusquedas {
	private static final Logger log = LoggerFactory.getLogger(ConstructorBusquedas.class);
	public static <T> Specification<T> buildSearchFiltersGeneric(List<TipoParametro> tipoParametro) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			for (TipoParametro i : tipoParametro) {
				if(!i.getValue().equals("")) 
					switch (i.getAtributo().getTipo()) {
					case "String":
						predicates.add(criteriaBuilder.and(
								criteriaBuilder.like(root.get(i.getAtributo().getNameValue()), "%" + i.getValue() + "%")));
						break;
					case "Int":
						predicates.add(criteriaBuilder
								.and(criteriaBuilder.equal(root.get(i.getAtributo().getNameValue()),i.getValue())));
						break;
					case "Boolean":
						log.info("Buscando usuario con id : {}", i.getValue());
						predicates.add(criteriaBuilder
								.and(criteriaBuilder.equal(root.get(i.getAtributo().getNameValue()), Integer.parseInt(i.getValue()))));
						break;
					case "BigDecimal":
						predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(
								root.get(i.getAtributo().getNameValue()), new BigDecimal(i.getValue()))));
						break;
					case "Date":
						predicates.add(criteriaBuilder.and(criteriaBuilder.between(root.get(i.getAtributo().getNameValue()),
								Date.valueOf(LocalDate.parse(i.getValue())),
								Date.valueOf(LocalDate.parse(i.getSeconValue()).plusDays(1)))));
						break;
					}
				
			}
			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

}

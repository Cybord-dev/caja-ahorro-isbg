package com.business.cybord.models.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RolDto implements Serializable {

	private static final long serialVersionUID = -8142648497651338494L;
	private int id;
	private RolCatDto rolname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RolCatDto getRolname() {
		return rolname;
	}

	public void setRolname(RolCatDto rolname) {
		this.rolname = rolname;
	}

	@Override
	public String toString() {
		return "RolDto [id=" + id + ", rolname=" + rolname + "]";
	}

}

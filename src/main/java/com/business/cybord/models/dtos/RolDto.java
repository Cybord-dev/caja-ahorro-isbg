package com.business.cybord.models.dtos;

import com.business.cybord.models.entities.RolCat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RolDto {

	private int id;
	private RolCat rolname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public RolCat getRolname() {
		return rolname;
	}

	public void setRolname(RolCat rolname) {
		this.rolname = rolname;
	}

	@Override
	public String toString() {
		return "RolDto [id=" + id + ", rolname=" + rolname + "]";
	}

}

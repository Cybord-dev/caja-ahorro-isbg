package com.business.cybord.models.dtos;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author ralfdemoledor
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuItem implements Serializable {

	private static final long serialVersionUID = 1656844506912422028L;
	private String name;
	private String icon;
	private String url;
	private String variant;
	private Boolean title;
	private List<MenuItem> children;
	
	public MenuItem() {}
	
	public MenuItem(String name, Boolean title) {
		this.name = name;
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public Boolean getTitle() {
		return title;
	}
	public void setTitle(Boolean title) {
		this.title = title;
	}
	public List<MenuItem> getChildren() {
		return children;
	}
	public void setChildren(List<MenuItem> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "MenuItem [name=" + name + ", icon=" + icon + ", url=" + url + ", variant=" + variant + ", title="
				+ title + ", children=" + children + "]";
	}
	
}
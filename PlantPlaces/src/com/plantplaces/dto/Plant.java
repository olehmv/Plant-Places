package com.plantplaces.dto;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")
public class Plant {
	private String name;
	private String genus;
	private String species;
	private String common;
	private String cultivar;
	
	public String getGenus() {
		return genus;
	}


	public void setGenus(String genus) {
		this.genus = genus;
	}


	public String getSpecies() {
		return species;
	}


	public void setSpecies(String species) {
		this.species = species;
	}


	public String getCommon() {
		return common;
	}


	public void setCommon(String common) {
		this.common = common;
	}


	public String getCultivar() {
		return cultivar;
	}


	public void setCultivar(String cultivar) {
		this.cultivar = cultivar;
	}


	


	@Override
	public String toString() {
		return "Plant [name=" + name + ", genus=" + genus + ", species=" + species + ", common=" + common
				+ ", cultivar=" + cultivar + "]";
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

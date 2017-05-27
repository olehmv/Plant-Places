package com.plantplaces.ui;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;

@Named
@ManagedBean
@Scope("session")
public class SearchPlants {

	@Inject
	private Plant plant;

	public String execute() {

		if (plant != null && plant.getName().equalsIgnoreCase("Redbutton")) {
			return "results";
		} else {
			return "noresults";
		}
	}

}

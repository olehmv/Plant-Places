package com.plantplaces.ui;


import java.util.ArrayList;
import java.util.List;

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
	public List<Plant>comletePlants(String query){
		List<Plant>list=new ArrayList<>();
		Plant redbud = new Plant();
		Plant pawpaw=new Plant();
		redbud.setName("redbud");
		pawpaw.setName("pawpaw");
		list.add(redbud);
		list.add(pawpaw);
		return list;
	}
}

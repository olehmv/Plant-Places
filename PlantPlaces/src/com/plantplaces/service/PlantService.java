package com.plantplaces.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dto.Plant;

@Named
public class PlantService implements IPlantService {
	@Inject
	private IPlantDAO plantDAO;
	private List<Plant>allPlants;
	@Override
	public List<Plant> filterPlants(String filter) {
	if(allPlants==null){
		allPlants=getPlantDAO().fetchPlants();
	}
	List<Plant>filteredPlant=new ArrayList<>();
	for (Plant plant : allPlants) {
		if(plant.toString().contains(filter)){
			filteredPlant.add(plant);
		}
	}
		return filteredPlant;
	}
	public IPlantDAO getPlantDAO() {
		return plantDAO;
	}
	public void setPlantDAO(IPlantDAO plantDAO) {
		this.plantDAO = plantDAO;
	}

}

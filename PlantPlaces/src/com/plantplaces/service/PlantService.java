package com.plantplaces.service;

import java.io.File;
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
	public List<Plant> filterPlants(String query) {
	if(allPlants==null){
		allPlants=getPlantDAO().fetchPlants();
	}
	List<Plant>filteredPlant=new ArrayList<>();
	for (Plant plant : allPlants) {
		if(plant.toString().contains(query)){
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
	@Override
	public void save(Plant plant) throws Exception {
		if(plant.getGenus()==null||plant.getGenus().isEmpty()){
			throw new Exception("Genus required");
		}
	plantDAO.insert(plant);	
	}
	@SuppressWarnings("unused")
	private static void makeAppDataFolder() {
	     File dir = new File(System.getenv("APPDATA") +  "\\plantplaces");
	     if (!dir.exists()) {dir.mkdir();}
	}

}

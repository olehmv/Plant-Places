package com.plantplaces.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dao.ISpecimenDAO;
import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;

@Named
@ManagedBean
@Scope("session")
public class PlantService implements IPlantService {
	@Inject
	private IPlantDAO plantDAO;
	private List<Plant> allPlants;
	@Inject
	private ISpecimenDAO specimenDAO;

	@Override
	public List<Plant> filterPlants(String query) {
		if (getAllPlants() == null) {
			setAllPlants(getPlantDAO().fetchPlants());
		}
		List<Plant> filteredPlant = new ArrayList<>();
		for (Plant plant : getAllPlants()) {
			if (plant.toString().contains(query)) {
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
		if (plant.getGenus() == null || plant.getGenus().isEmpty()) {
			throw new Exception("Genus required");
		}
		plantDAO.insert(plant);
	}

	@Override
	public void save(Specimen specimen) throws Exception {
		specimenDAO.insert(specimen);
		
	}

	@SuppressWarnings("unused")
	private static void makeAppDataFolder() {
		File dir = new File(System.getenv("APPDATA") + "\\plantplaces");
		if (!dir.exists()) {
			dir.mkdir();
		}
	}

	@Override
	public List<Plant> fetchPlants(Plant plant) {
		return plantDAO.fetchPlants(plant);
	}

	public List<Plant> getAllPlants() {
		return allPlants;
	}

	public void setAllPlants(List<Plant> allPlants) {
		this.allPlants = allPlants;
	}

}

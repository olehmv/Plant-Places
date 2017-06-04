package com.plantplaces.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.apache.log4j.Logger;

import com.plantplaces.dto.Plant;
@Named("plantDAO")
public class PlantDAOStub implements IPlantDAO {
	
	final static Logger logger=Logger.getLogger(PlantDAOStub.class);
	@Override
	public List<Plant> fetchPlants() {
		List<Plant> allPlants = new ArrayList<>();
		Plant redbud = new Plant();
		redbud.setGenus("Cercis");
		redbud.setSpecies("Redbud");
		Plant pawpaw = new Plant();
		pawpaw.setCommon("Paw Paw");
		pawpaw.setGenus("Asi mira");
		pawpaw.setSpecies("triloba");
		Plant redMable = new Plant();
		redMable.setGenus("Genus Aser");
		redMable.setSpecies("rubrum");
		redMable.setCommon("Red Mable");
		allPlants.add(redMable);
		allPlants.add(redbud);
		allPlants.add(pawpaw);
		return allPlants;
	}

	@Override
	public void insert(Plant plant) {
		logger.warn("Inserting to Stub this is not persist the item");

	}

	@Override
	public void update(Plant plant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Plant plant) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Plant> fetchPlants(Plant plant) {
		// TODO Auto-generated method stub
		return null;
	}

}

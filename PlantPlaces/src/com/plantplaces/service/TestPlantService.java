package com.plantplaces.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dto.Plant;

import static org.mockito.Mockito.*;
import junit.framework.TestCase;

public class TestPlantService extends TestCase {

	private PlantService plantService;
	private List<Plant> filterPlants;
	private IPlantDAO mock;

	@Test
	public void testFilterPlants() {
		givenThatPlantServiceIsPopulatedWithPlantDao();
		whenFilterWithRed();
		thenVerifyOneResults();
	}

	private void thenVerifyOneResults() {
		assertEquals(1,filterPlants.size() );
	}

	private void whenFilterWithRed() {
		filterPlants = plantService.filterPlants("Red");
		verify(mock,times(1)).fetchPlants();
	}

	private void givenThatPlantServiceIsPopulatedWithPlantDao() {
		plantService = new PlantService();
		mock = mock(IPlantDAO.class);
		List<Plant> plantList = constructPlantList();
		when(mock.fetchPlants()).thenReturn(plantList);
		plantService.setPlantDAO(mock);
	}

	private List<Plant> constructPlantList() {
		List<Plant> allPlants = new ArrayList<>();
		Plant redMable = new Plant();
		redMable.setGenus("Genus Aser");
		redMable.setSpecies("rubrum");
		redMable.setCommon("Red Mable");
		allPlants.add(redMable);
		return allPlants;
	}

}

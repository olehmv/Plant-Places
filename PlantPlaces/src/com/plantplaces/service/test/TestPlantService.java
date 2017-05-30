package com.plantplaces.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dto.Plant;
import com.plantplaces.service.IPlantService;
import com.plantplaces.service.PlantService;
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
		thenVerifyTwoResults();
	}

	private void thenVerifyTwoResults() {
		assertEquals(2,filterPlants.size() );
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
		Plant redbud = new Plant();
		redbud.setName("Eastern Redbud");
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

}

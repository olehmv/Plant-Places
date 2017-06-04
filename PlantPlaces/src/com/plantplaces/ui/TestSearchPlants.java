package com.plantplaces.ui;

import org.junit.Test;
import org.mockito.Mockito;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dao.PlantHbmDAO;
import com.plantplaces.dto.Plant;
import com.plantplaces.service.IPlantService;
import com.plantplaces.service.PlantService;
import static org.mockito.Mockito.*;

import junit.framework.TestCase;

public class TestSearchPlants extends TestCase {
	
	private SearchPlants searchPlants;
	private String execute;
	private PlantService plantService;
	private PlantHbmDAO plantHbmDAO;

	@Test
	public void testSeachPlantsExecute(){
		givenSearchPlantsCreatedWithRedBud();
		whenInvokeExecute();
		thenVerifyReturnResult();
	}

	private void givenSearchPlantsCreatedWithRedBud() {
			plantHbmDAO = new PlantHbmDAO();
			plantService = new PlantService();
			plantService.setPlantDAO(plantHbmDAO);
			searchPlants = new SearchPlants();
			searchPlants.setPlantService(plantService);
			searchPlants.setPlant(createRedBudPlant());	
	}
	
	private Plant createRedBudPlant() {
		Plant redbud = new Plant();
		redbud.setGenus("Cercis");
		redbud.setSpecies("Redbud");
		redbud.setCommon("Redbud");
		return redbud;
	}

	private void whenInvokeExecute() {
		execute = searchPlants.execute();
	}

	private void thenVerifyReturnResult() {
		assertEquals("results",execute);
		
	}
	@Test
	public void testSearchPlantsExecuteWithReturnNoResults(){
		givenSearchPlantWithPawPaw();
		whenInvokeExecute();
		thenVerifyNoResults();
//		givenSearchPlantExecuteWithNoPlants();
	}


	private void thenVerifyNoResults() {
			assertEquals("noresults",execute);
	}

	private void givenSearchPlantWithPawPaw() {
		Plant pawPaw = new Plant();
		pawPaw.setCommon("PawPaw");
		plantHbmDAO = new PlantHbmDAO();
		plantService = new PlantService();
		plantService.setPlantDAO(plantHbmDAO);
		searchPlants = new SearchPlants();
		searchPlants.setPlantService(plantService);
		searchPlants.setPlant(pawPaw);
	}
//	@Test
//	public void givenSearchPlantExecuteWithNoPlants(){
//		givenSearchPlantWithNotPlant();
//		whenInvokeExecute();
//		thenVerifyNoResults();		
//	}
//
//
//	private void givenSearchPlantWithNotPlant() {
//		searchPlants = new	SearchPlants();	
//	}
	

}

package com.plantplaces.ui.test;

import org.junit.Test;

import com.plantplaces.dto.Plant;
import com.plantplaces.ui.SearchPlants;

import junit.framework.TestCase;

public class TestSearchPlants extends TestCase {
	
	private SearchPlants searchPlants;
	private String execute;

	@Test
	public void testSeachPlantsExecute(){
		givenSearchPlantsCreatedWithRedBud();
		whenInvokeExecute();
		thenVerifyReturnResult();
	}

	private void givenSearchPlantsCreatedWithRedBud() {
			searchPlants = new	SearchPlants();
			searchPlants.setPlant(createRedBudPlant());	
	}
	
	private Plant createRedBudPlant() {
		Plant redbud = new Plant();
		redbud.setName("Redbud");
		redbud.setGenus("Cercis");
		redbud.setSpecies("Redbud");
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
		givenSearchPlantExecuteWithNoPlants();
	}


	private void thenVerifyNoResults() {
			assertEquals("noresults",execute);
	}

	private void givenSearchPlantWithPawPaw() {
		searchPlants = new	SearchPlants();
		Plant pawPaw = new Plant();
		pawPaw.setName("PawPaw");
		searchPlants.setPlant(pawPaw);
	}
	@Test
	public void givenSearchPlantExecuteWithNoPlants(){
		givenSearchPlantWithNotPlant();
		whenInvokeExecute();
		thenVerifyNoResults();		
	}


	private void givenSearchPlantWithNotPlant() {
		searchPlants = new	SearchPlants();	
	}
	

}

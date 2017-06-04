package com.plantplaces.dao;

import java.util.List;

import org.junit.Test;

import com.plantplaces.dto.Plant;

import junit.framework.TestCase;

public class TestPlantHbmDAO extends TestCase {

	private PlantHbmDAO plantDAO;
	private List<Plant> plants;

	@Test
	public void testVerifyByCommonName() {
		givenPlantHbmDAO();
		whenCommonNameIsRedbud();
		thenVerifyResult();
	}

	private void givenPlantHbmDAO() {
		plantDAO = new PlantHbmDAO();

	}

	private void whenCommonNameIsRedbud() {
		Plant plant = new Plant();
		plant.setCommon("Redbud");
		plants = plantDAO.fetchPlants(plant);

	}

	private void thenVerifyResult() {
		assertTrue(plants.size() > 0);
		for (Plant p : plants) {
			assertEquals("Redbud", p.getCommon());
		}

	}

}

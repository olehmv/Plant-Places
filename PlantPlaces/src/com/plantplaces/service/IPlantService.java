package com.plantplaces.service;

import java.util.List;

import com.plantplaces.dto.Plant;
/**
 * Service process data related to Plant
 * @author olehmv
 *
 */
public interface IPlantService {
	/**
	 * method filter return plants by 
	 * String filter
	 * @param String filter
	 * @return List<Plant>
	 */
public List<Plant>filterPlants(String query);

	public void save(Plant plant)throws Exception;

}

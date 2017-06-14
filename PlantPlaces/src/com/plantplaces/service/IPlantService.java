package com.plantplaces.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.plantplaces.dto.Photo;
import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;
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

	List<Plant> fetchPlants(Plant plant);

	void save(Specimen specimen) throws Exception;

	public void loadSpecimens(Plant plant);


	void savePhoto(Photo photo, InputStream inputStream) throws IOException;

	public List<Photo> fetchPhotos(Specimen specimen);

}

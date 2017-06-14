package com.plantplaces.dao;

import java.util.List;

import com.plantplaces.dto.Photo;
import com.plantplaces.dto.Specimen;

public interface IPhotoDAO {

	void save(Photo dto);

	List<Photo> fetchPhotos(Specimen specimen);


}
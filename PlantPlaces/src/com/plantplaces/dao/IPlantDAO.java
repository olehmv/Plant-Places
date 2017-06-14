package com.plantplaces.dao;

import java.util.List;

import com.plantplaces.dto.Plant;

public interface IPlantDAO {
public List<Plant> fetchPlants();
public void save(Plant plant);
public void update(Plant plant);
public void delete(Plant plant);
List<Plant> fetchPlants(Plant plant);
}

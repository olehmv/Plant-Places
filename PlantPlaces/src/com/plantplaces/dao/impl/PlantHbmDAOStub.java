package com.plantplaces.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.plantplaces.dao.HibernateUtils;
import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dto.Plant;
public class PlantHbmDAOStub implements IPlantDAO {
	
	final static Logger logger=Logger.getLogger(PlantHbmDAOStub.class);
	@Override
	public List<Plant> fetchPlants() {
		return null;
	}

	@Override
	public void insert(Plant plant) {
		Session session = HibernateUtils.getSessionfactory().openSession();
		session.beginTransaction();
		session.save(plant);
		session.getTransaction().commit();

	}

	@Override
	public void update(Plant plant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Plant plant) {
		// TODO Auto-generated method stub

	}

}

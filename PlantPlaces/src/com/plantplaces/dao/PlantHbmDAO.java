package com.plantplaces.dao;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.plantplaces.dto.Plant;
public class PlantHbmDAO extends PlantPlacesDAO<Plant>implements IPlantDAO {
	
	final static Logger logger=Logger.getLogger(PlantHbmDAO.class);
	@Override
	public List<Plant> fetchPlants() {
		Session session = HibernateUtils.getSessionfactory().openSession();
		@SuppressWarnings("unchecked")
		Query<Plant> query = session.createQuery("from Plant");
		List<Plant>list=Collections.checkedList(query.list(), Plant.class);
		return list;
	}
	

	@Override
	public List<Plant> fetchPlants(Plant plant) {
		Session session = HibernateUtils.getSessionfactory().openSession();
//		@SuppressWarnings("unchecked")
//		Query<Plant> query = session.createQuery("from Plant where common= :common");
//		query.setParameter("common", "redbud");
//		query.setProperties(plant);
//		@SuppressWarnings("rawtypes")
//		List list = query.list();
		@SuppressWarnings("unchecked")
		Query<Plant> query = session.createQuery("from Plant where common like :common");
		System.out.println(plant.getCommon());
		query.setParameter("common", "%"+plant.getCommon()+"%");
		List<Plant>list=Collections.checkedList(query.list(), Plant.class);
		return list;
	}

	

	@Override
	public void update(Plant plant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Plant plant) {
		// TODO Auto-generated method stub

	}


	@Override
	public void insert(Session session, Plant dto) {
		session.save(dto);
		
	}

}

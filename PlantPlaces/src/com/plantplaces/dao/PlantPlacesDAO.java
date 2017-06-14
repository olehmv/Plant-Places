package com.plantplaces.dao;

import org.hibernate.Session;

public abstract class PlantPlacesDAO<T> {
	
	public void save(T dto) {
		Session session = HibernateUtils.getSessionfactory().openSession();
		session.beginTransaction();
		insert(session,dto);
		session.getTransaction().commit();

	}
	public abstract void insert(Session session,T dto);

}

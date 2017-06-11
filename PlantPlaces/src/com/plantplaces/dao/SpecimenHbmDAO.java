package com.plantplaces.dao;

import java.util.Collections;
import java.util.List;

import javax.inject.Named;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.plantplaces.dto.Specimen;
@Named
public class SpecimenHbmDAO implements  ISpecimenDAO  {
	
	final static Logger logger=Logger.getLogger(SpecimenHbmDAO.class);
	
	
	/* (non-Javadoc)	
	 * @see com.plantplaces.dao.SpecimenDAO#insert(com.plantplaces.dto.Specimen)
	 */
	@Override
	public void insert(Specimen specimen) {
		Session session = HibernateUtils.getSessionfactory().openSession();
		session.beginTransaction();
		session.save(specimen);
		session.getTransaction().commit();

	}

	
	/* (non-Javadoc)
	 * @see com.plantplaces.dao.SpecimenDAO#update(com.plantplaces.dto.Specimen)
	 */
	@Override
	public void update(Specimen specimen) {
		// TODO Auto-generated method stub

	}

	
	/* (non-Javadoc)
	 * @see com.plantplaces.dao.SpecimenDAO#delete(com.plantplaces.dto.Specimen)
	 */
	@Override
	public void delete(Specimen specimen) {
		// TODO Auto-generated method stub

	}


	@Override
	public List<Specimen> fetchSpecimens(int guid) {
		Session session = HibernateUtils.getSessionfactory().openSession();
		@SuppressWarnings("unchecked")
		Query<Specimen> query = session.createQuery("from Specimen where plantId=:plantId");
		query.setParameter("plantId", guid);
		List<Specimen>list=Collections.checkedList(query.list(), Specimen.class);
		return list;		
	}

}

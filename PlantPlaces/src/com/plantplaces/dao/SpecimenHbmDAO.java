package com.plantplaces.dao;

import javax.inject.Named;

import org.apache.log4j.Logger;
import org.hibernate.Session;

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

}

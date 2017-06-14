package com.plantplaces.dao;

import java.util.Collections;
import java.util.List;

import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.plantplaces.dto.Photo;
import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;
@Named
public class PhotoDAO extends PlantPlacesDAO<Photo> implements IPhotoDAO {

	/* (non-Javadoc)
	 * @see com.plantplaces.dao.IPhotoDAO#insert(org.hibernate.Session, com.plantplaces.dto.Photo)
	 */
	@Override
	public void insert(Session session, Photo dto) {
			session.save(dto);
	}

	@Override
	public List<Photo> fetchPhotos(Specimen specimen) {
		Session session = HibernateUtils.getSessionfactory().openSession();
		@SuppressWarnings("unchecked")
		Query<Photo> query = session.createQuery("from Photo where specimenId =:specimenId");
		query.setParameter("specimenId", specimen.getId());
		List<Photo>list=Collections.checkedList(query.list(), Photo.class);
		return list;
	
	}

}

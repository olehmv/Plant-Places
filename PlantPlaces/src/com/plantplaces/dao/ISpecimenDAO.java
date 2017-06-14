package com.plantplaces.dao;

import java.util.List;

import com.plantplaces.dto.Specimen;

public interface ISpecimenDAO {

	/* (non-Javadoc)
	 * @see com.plantplaces.dao.ISpecimenDAO#insert(com.plantplaces.dto.Specimen)
	 */
	void save(Specimen specimen);

	/* (non-Javadoc)
	 * @see com.plantplaces.dao.ISpecimenDAO#update(com.plantplaces.dto.Plant)
	 */
	void update(Specimen specimen);

	/* (non-Javadoc)
	 * @see com.plantplaces.dao.ISpecimenDAO#delete(com.plantplaces.dto.Plant)
	 */
	void delete(Specimen specimen);

	List<Specimen> fetchSpecimens(int guid);

}
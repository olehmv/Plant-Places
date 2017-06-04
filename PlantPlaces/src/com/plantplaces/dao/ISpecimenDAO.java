package com.plantplaces.dao;

import com.plantplaces.dto.Specimen;

public interface ISpecimenDAO {

	/* (non-Javadoc)
	 * @see com.plantplaces.dao.ISpecimenDAO#insert(com.plantplaces.dto.Specimen)
	 */
	void insert(Specimen specimen);

	/* (non-Javadoc)
	 * @see com.plantplaces.dao.ISpecimenDAO#update(com.plantplaces.dto.Plant)
	 */
	void update(Specimen specimen);

	/* (non-Javadoc)
	 * @see com.plantplaces.dao.ISpecimenDAO#delete(com.plantplaces.dto.Plant)
	 */
	void delete(Specimen specimen);

}
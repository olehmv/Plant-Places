package com.plantplaces.ui;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;
import com.plantplaces.service.IPlantService;

@Named
@ManagedBean
@Scope("session")
public class SpecimenVO {
	@Inject
	private Plant plant;
	@Inject
	private Specimen specimen;
	@Inject IPlantService plantServcie;

	
	public Specimen getSpecimen() {
		return specimen;
	}


	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	public String save(){
		specimen.setPlantId(plant.getGuid());
		try {
			plantServcie.save(specimen);
			return "specimentsaved";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";

		}
	}

}

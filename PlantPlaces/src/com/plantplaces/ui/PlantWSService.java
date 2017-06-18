package com.plantplaces.ui;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebService;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.plantplaces.dto.Plant;
import com.plantplaces.service.IPlantService;

@WebService
@Named
public class PlantWSService implements IPlantWSService {

	@Inject
	private IPlantService plantService;
	
	public PlantWSService() {
	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	@Override
	public String fetchPlants(String plant) {
		String result="not found";
		Plant p = new Plant();
		p.setCommon(plant);
		List<Plant> plants = plantService.fetchPlants(p);
		for (Plant plant2 : plants) {
			result=plant2.toString();
		}
		return result;
	}

	public IPlantService getPlantService() {
		return plantService;
	}

	public void setPlantService(IPlantService plantService) {
		this.plantService = plantService;
	}

}

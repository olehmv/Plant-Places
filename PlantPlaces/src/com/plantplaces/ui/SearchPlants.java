package com.plantplaces.ui;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;
import com.plantplaces.service.IPlantService;

@Named
@ManagedBean
@Scope("session")
public class SearchPlants {

	@Inject
	private Plant plant;
	@Inject
	private IPlantService plantService;
	private Plant selectedPlant;
	private List<Plant> fetchPlants;
	@Inject
	SpecimenVO specimenVO;

	public String execute() {
		setFetchPlants(getPlantService().fetchPlants(plant));
		System.out.println("esecute");
		if (fetchPlants.size() > 0) {
			System.out.println(fetchPlants.toString() + " -----------result");
			return "results";
		} else {
			System.out.println("noresult");
			return "noresults";

		}
	}

	public List<Plant> comletePlants(String query) {
		return getPlantService().filterPlants(query);
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public List<Plant> getFetchPlants() {
		return fetchPlants;
	}

	public void setFetchPlants(List<Plant> fetchPlants) {
		this.fetchPlants = fetchPlants;
	}

	public IPlantService getPlantService() {
		return plantService;
	}

	public void setPlantService(IPlantService plantService) {
		this.plantService = plantService;
	}

	public void onRowSelect(SelectEvent event) {
		Plant plant = (Plant) event.getObject();
		specimenVO.setPlant(plant);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("specimen.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Plant getSelectedPlant() {
		return selectedPlant;
	}

	public void setSelectedPlant(Plant selectedPlant) {
		this.selectedPlant = selectedPlant;
	}
	public  void showDetail(){
		
	}

}

package com.plantplaces.ui;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;
import com.plantplaces.service.IPlantService;

@Named
@ManagedBean
@Scope("request")
public class AddPlant {
	final static Logger logger = Logger.getLogger(AddPlant.class);

	@Inject
	private IPlantService plantSrvice;
	@Inject
	private Plant plant;

	public String execute() {
		logger.info("Entering execute method");
		String returnValue = "succses";
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		try {
			plantSrvice.save(plant);
			logger.info("Plant succsesfully saved: " + plant.toString());
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "saved", "Plant saved");
			currentInstance.addMessage(null, fm);
		} catch (Exception e) {
			logger.error("Error saving plant: "+ e.getMessage());
			e.printStackTrace();
			returnValue = "failer";
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "unsaved", "Plant unable to save");
			currentInstance.addMessage(null, fm);
		}
		return returnValue;
	}

}

package com.plantplaces.ui;

import java.io.IOException;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Photo;
import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;
import com.plantplaces.service.IPlantService;

@Named
@ManagedBean
@Scope("session")
public class SpecimenVO {
	@Inject
	private Photo photo;
	@Inject
	private Plant plant;
	@Inject
	private Specimen specimen;
	@Inject
	IPlantService plantService;
	private UploadedFile file;

	public Specimen getSpecimen() {
		return specimen;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
		loadSpecimens();
	}

	private void loadSpecimens() {

		plantService.loadSpecimens(plant);
	}

	public String save() {
		getSpecimen().setPlantId(plant.getGuid());
		try {
			plantService.save(getSpecimen());
			return "specimentsaved";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";

		}
	}

	public void onRowSelect(SelectEvent event) {
		Specimen specimen = (Specimen) event.getObject();
		setSpecimen(specimen);
	}

	public void setSpecimen(Specimen specimen) {
		this.specimen = specimen;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload() {
		if(specimen.getId()==0){
			FacesMessage message = new FacesMessage("Please select specimen");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}else if (file != null) {
		try {
			InputStream inputStream = file.getInputstream();
			photo.setSpecimenId(specimen.getId());
			plantService.savePhoto(photo,inputStream);
				FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			
		} catch (IOException e) {
			e.printStackTrace();
			FacesMessage message = new FacesMessage("file was not  uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		}
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

}

package com.plantplaces.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.context.annotation.Scope;

import com.plantplaces.dao.IFileDAO;
import com.plantplaces.dao.IPhotoDAO;
import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dao.ISpecimenDAO;
import com.plantplaces.dto.Photo;
import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;

@Named
@ManagedBean
@Scope("session")
public class PlantService implements IPlantService {
	@Inject
	private JmsBean jmsBean;
	@Inject
	private IPhotoDAO photoDAO;
	@Inject
	private IPlantDAO plantDAO;
	private List<Plant> allPlants;
	@Inject
	private ISpecimenDAO specimenDAO;
	@Inject
	private IFileDAO fileDAO;

	@Override
	public List<Plant> filterPlants(String query) {
		if (getAllPlants() == null) {
			setAllPlants(getPlantDAO().fetchPlants());
		}
		List<Plant> filteredPlant = new ArrayList<>();
		for (Plant plant : getAllPlants()) {
			if (plant.toString().contains(query)) {
				filteredPlant.add(plant);
			}
		}
		return filteredPlant;
	}

	public IPlantDAO getPlantDAO() {
		return plantDAO;
	}

	public void setPlantDAO(IPlantDAO plantDAO) {
		this.plantDAO = plantDAO;
	}

	@Override
	public void save(Plant plant) throws Exception {
		if (plant.getGenus() == null || plant.getGenus().isEmpty()) {
			throw new Exception("Genus required");
		}
		plantDAO.save(plant);
	}

	@Override
	public void save(Specimen specimen) throws Exception {
		specimenDAO.save(specimen);
		
	}

	@SuppressWarnings("unused")
	private static void makeAppDataFolder() {
		File dir = new File(System.getenv("APPDATA") + "\\plantplaces");
		if (!dir.exists()) {
			dir.mkdir();
		}
	}

	@Override
	public List<Plant> fetchPlants(Plant plant) {
		return plantDAO.fetchPlants(plant);
	}

	public List<Plant> getAllPlants() {
		return allPlants;
	}

	public void setAllPlants(List<Plant> allPlants) {
		this.allPlants = allPlants;
	}

	@Override
	public void loadSpecimens(Plant plant) {
			List<Specimen> specimens = specimenDAO.fetchSpecimens(plant.getGuid());
			plant.setSpecimens(specimens);
	}
	@Override
	public void savePhoto(Photo photo,InputStream inputStream) throws Exception{
		File directory = new File("D:/elipse-neon/workspace/git/PlantPlaces/WebContent/resources/images");
		String generatedName=generatedUniqueImageName();
		File file=new File(directory,generatedName);
		jmsBean.submit(file.toString());
		fileDAO.save(inputStream, file);
		File thumbnailDirectory = new File("D:/elipse-neon/workspace/git/PlantPlaces/WebContent/resources/thumbnails");
		File thumbnailFile=new File(thumbnailDirectory,generatedName);
		Thumbnails.of(file).size(100, 100).toFile(thumbnailFile);
		
		BufferedImage bufferedImage = ImageIO.read(new File(directory,"watermark.png"));
		Thumbnails.of(file).scale(1).watermark(Positions.BOTTOM_LEFT,bufferedImage,0.9f).toFile(file);
		photo.setUri(generatedName);
		photo.setDateTaken(new Date());
		photoDAO.save(photo);
	}

	private String generatedUniqueImageName() {
		String prefix="plantplaces";
		String sufix=".jpg";
		String middle="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMHHmmss");
		middle=sdf.format(new Date());
		return prefix+middle+sufix;
	}

	@Override
	public List<Photo> fetchPhotos(Specimen specimen) {
		return photoDAO.fetchPhotos(specimen);
	}

}

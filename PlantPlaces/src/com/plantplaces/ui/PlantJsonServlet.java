package com.plantplaces.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.plantplaces.dto.Plant;
import com.plantplaces.service.IPlantService;

@Named
@Scope("prototype")
public class PlantJsonServlet extends HttpServlet {
	@Inject
	IPlantService plantService;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2687167746940572679L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Enable Spring dependency injection
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		int i = 1 + 1;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		Plant p = new Plant();
		String filter = req.getParameter("filter");
		if (filter != null && !filter.isEmpty()) {
			p.setCommon(filter);
		} else {
			p.setCommon("e");
		}
		List<Plant> plants = plantService.fetchPlants(p);
		for (Plant plant : plants) {
			JsonObjectBuilder builder = Json.createObjectBuilder();
			JsonObject jsonObject = builder.add("common", plant.getCommon() != null ? plant.getCommon() : "")
					.add("cultivar", plant.getCultivar() != null ? plant.getCultivar() : "")
					.add("genus", plant.getGenus() != null ? plant.getGenus() : "")
					.add("species", plant.getSpecies() != null ? plant.getSpecies() : "").build();
			arrayBuilder.add(jsonObject);
		}
		JsonObject root = rootBuilder.add("plants", arrayBuilder).build();
		writer.print(root);
		writer.flush();
		writer.close();

	}

}

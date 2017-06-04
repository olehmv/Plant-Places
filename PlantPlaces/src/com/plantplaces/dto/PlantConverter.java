//package com.plantplaces.dto;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
//import javax.faces.convert.Converter;
//import javax.faces.convert.ConverterException;
//import javax.faces.convert.FacesConverter;
//
//import com.plantplaces.service.PlantService;
// 
//@FacesConverter("plantConverter")
//public class PlantConverter implements Converter {
// 
//    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
//        if(value != null && value.trim().length() > 0) {
//        	Plant plant=new Plant();
//        	plant.setCommon(value);
//        	return plant;
//        }else{
//        	return null;
//        }
////            try {
////                PlantService service = (PlantService) fc.getExternalContext().getApplicationMap().get("plantService");
////                return service.getAllPlants()fc.;
////            } catch(NumberFormatException e) {
////                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
////            }
////        }
////        else {
////            return null;
////        }
//    }
// 
//    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
//        if(object != null) {
//            return String.valueOf(((Plant) object));
//        }
//        else {
//            return null;
//        }
//    }   
//}     
package al.gov.mb.asylum.ui.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import al.gov.mb.asylum.ui.models.PlaceTypeDTO;
import al.gov.mb.asylum.ui.services.HelperService;
import al.gov.mb.asylum.ui.utils.StringUtil;



@SuppressWarnings("rawtypes")
@FacesConverter("placeTypeConverter")
public class PlaceTypeConverter implements Converter {


	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		
		if(StringUtil.isValid(value))
		{
			return new HelperService().findPlaceType(value);
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null)
		{
			return ((PlaceTypeDTO)value).getId();
		}
		
		return null;
	} 
	
	
	

}

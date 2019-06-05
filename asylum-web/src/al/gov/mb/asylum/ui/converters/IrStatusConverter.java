package al.gov.mb.asylum.ui.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import al.gov.mb.asylum.ui.models.IrStatusDTO;
import al.gov.mb.asylum.ui.services.HelperService;
import al.gov.mb.asylum.ui.utils.StringUtil;

@SuppressWarnings("rawtypes")
@FacesConverter("irStatusConverter")
public class IrStatusConverter implements Converter {


	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		
		if(StringUtil.isValid(value))
		{
			return new HelperService().findIrStatus(value);
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null)
		{
			return ((IrStatusDTO)value).getId();
		}
		
		return null;
	} 
	

}

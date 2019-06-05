package al.gov.mb.asylum.ui.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import al.gov.mb.asylum.ui.models.DecisionReasonDTO;
import al.gov.mb.asylum.ui.services.HelperService;
import al.gov.mb.asylum.ui.utils.StringUtil;

@SuppressWarnings("rawtypes")
@FacesConverter("decisionReasonConverter")
public class DecisionReasonConverter implements Converter {


	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		
		if(StringUtil.isValid(value))
		{
			
			String[] key = value.split(",",-1);
			if(key.length <2) return null;
			String codeOrder = key[0];
			String typeOrder = key[1];
			return new HelperService().findDecisionReason(codeOrder, typeOrder);
			
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null)
		{
			return ((DecisionReasonDTO)value).getKey();
		}
		
		return null;
	} 

}

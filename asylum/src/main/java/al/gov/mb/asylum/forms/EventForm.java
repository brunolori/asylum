package al.gov.mb.asylum.forms;

import java.util.List;

import al.gov.mb.asylum.dto.EventDTO;
import al.gov.mb.asylum.dto.EvidenceDTO;
import al.gov.mb.asylum.dto.OfficerDTO;
import al.gov.mb.asylum.exceptions.ValidationException;
import al.gov.mb.asylum.utils.StringUtil;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EventForm {
	
	
	EventDTO event;
	List<OfficerDTO> officers;
	List<EvidenceDTO> evidences;
	
	
	public void validate()
	{
		if(this.getEvent().getPlaceType() == null)
		{
			throw new ValidationException("Plotesoni Tipin e Vendit");
		}
		
		if(!StringUtil.isValid(this.getEvent().getPlace()))
		{
			throw new ValidationException("Plotesoni Vendin e Konstatimit");
		}
		
		if(this.getEvent().getEventDate() == null)
		{
			throw new ValidationException("Plotesoni Daten e Konstatimit");
		}
		
		if(!StringUtil.isValid(this.getEvent().getDescription()))
		{
			throw new ValidationException("Plotesoni Pershkrimin e Konstatimit");
		}
		
		
	}

}

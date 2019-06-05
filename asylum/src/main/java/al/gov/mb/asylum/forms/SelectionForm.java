package al.gov.mb.asylum.forms;

import java.util.List;

import al.gov.mb.asylum.dto.DocumentDTO;
import al.gov.mb.asylum.dto.OtherDocumentDTO;
import al.gov.mb.asylum.dto.SelectionDTO;
import al.gov.mb.asylum.exceptions.ValidationException;
import al.gov.mb.asylum.utils.StringUtil;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SelectionForm {

	
	SelectionDTO selection;
	List<OtherDocumentDTO> otherDocuments;
	DocumentDTO document;
	
	
	public void validate()
	{
		if(selection.getEvent() == null)
		{
			throw new ValidationException("Zgjidhni konstatimin");
		}
		
		if(isFilledDoc())
		{
			validateDocument();
		}
		
		if(!StringUtil.isValid(selection.getPerson().getName()))
		{
			throw new ValidationException("Plotesoni Emrin");
		}
		if(!StringUtil.isValid(selection.getPerson().getSurname()))
		{
			throw new ValidationException("Plotesoni Mbiemrin");
		}
		if(!StringUtil.isValid(selection.getPerson().getCodeNationality()))
		{
			throw new ValidationException("Plotesoni Nacionalitetin");
		}
		if(selection.getPerson().getDob() == null)
		{
			throw new ValidationException("Plotesoni Datelindjen");
		}
		
		if(selection.getIrStatus() == null)
		{
			throw new ValidationException("Zgjidhni statusin e te parregulltit");
		}
				
		
		if(!StringUtil.isValid(selection.getEntryPlace()))
		{
			throw new ValidationException("Plotesoni Vendin e Hyrjes");
		}
		if(!StringUtil.isValid(selection.getEntryMode()))
		{
			throw new ValidationException("Plotesoni Menyren e Kalimit Kufitar");
		}
		if(!StringUtil.isValid(selection.getItinerary()))
		{
			throw new ValidationException("Plotesoni Itinerarin");
		}
		if(!StringUtil.isValid(selection.getFleeingReason()))
		{
			throw new ValidationException("Plotesoni Arsyen e Largimit");
		}
		
		if(!StringUtil.isValid(selection.getTranslator()))
		{
			throw new ValidationException("Plotesoni Perkthyesin");
		}
		if(!StringUtil.isValid(selection.getTransLang()))
		{
			throw new ValidationException("Plotesoni Gjuhen e Intervistimit");
		}
		if(selection.getSelectionDate() == null)
		{
			throw new ValidationException("Plotesoni Daten e perpilimit");
		}
		
	}
	
	
	public boolean isFilledDoc()
	{
		return (StringUtil.isValid(getDocument().getCodeState()) || StringUtil.isValid(getDocument().getCodeTypeTravelDoc()) || StringUtil.isValid(getDocument().getTravelDocNo())
				|| getDocument().getDateOfIssue() != null || getDocument().getDateOfExpiration() != null || getDocument().getDateOfExtension() != null);
	}
	
	public void validateDocument()
	{
		if(!StringUtil.isValid(getDocument().getCodeState()))		
		  {
			  throw new ValidationException("Plotesoni Shtetin e Dokumentit");
		  }
		  if(!StringUtil.isValid(getDocument().getCodeTypeTravelDoc()))		
		  {
			  throw new ValidationException("Plotesoni Tipin e Dokumentit");
		  }
		  if(!StringUtil.isValid(getDocument().getTravelDocNo()))		
		  {
			  throw new ValidationException("Plotesoni Numrin e Dokumentit");
		  }
		 
	}
	
}

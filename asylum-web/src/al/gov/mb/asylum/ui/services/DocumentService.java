package al.gov.mb.asylum.ui.services;

import java.util.List;

import al.gov.mb.asylum.ui.api.clients.DocumentClient;
import al.gov.mb.asylum.ui.models.DocumentDTO;
import al.gov.mb.asylum.ui.models.OtherDocumentDTO;
import al.gov.mb.asylum.ui.models.TimsDocumentDTO;

public class DocumentService {

	
	
	public List<TimsDocumentDTO> getTimsDocument(String docNo)
	{
		return new DocumentClient().getTimsDocument(docNo);
	}
	
	public List<OtherDocumentDTO> getSelectionOtherDocuments(Integer eventId)
	{
		return new DocumentClient().getSelectionOtherDocuments(eventId);
	}
	
	public DocumentDTO getSelectionDocument(Integer eventId)
	{
		return new DocumentClient().getSelectionDocument(eventId);
	}
	
	
	
	
}

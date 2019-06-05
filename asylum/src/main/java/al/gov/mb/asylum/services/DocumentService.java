package al.gov.mb.asylum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import al.gov.mb.asylum.dao.DocumentDAO;
import al.gov.mb.asylum.entities.tims.Document;
import al.gov.mb.asylum.entities.tims.OtherDocument;
import al.gov.mb.asylum.entities.tims.TravelDocument;
import al.gov.mb.asylum.utils.StringUtil;

@Service
public class DocumentService {
	
	
	@Autowired DocumentDAO documentDAO;
	
	
	public List<TravelDocument> searchTimsDocument(String docNo)
	{
		if(StringUtil.isValid(docNo) && docNo.length() > 2)
		{
			return documentDAO.searchTimsDocument(docNo);
		}
		
		return null;
	}
	
	public List<OtherDocument> getSelectionOtherDocuments(Integer eventId)
	{
		return documentDAO.getSelectionOtherDocuments(eventId);
	}
	
	public Document getSelectionDocument(Integer eventId)
	{
		List<Document> list = documentDAO.getSelectionDocuments(eventId);
		if(list == null || list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

}

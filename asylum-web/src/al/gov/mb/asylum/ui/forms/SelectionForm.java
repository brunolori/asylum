package al.gov.mb.asylum.ui.forms;

import java.io.Serializable;
import java.util.List;

import al.gov.mb.asylum.ui.models.DocumentDTO;
import al.gov.mb.asylum.ui.models.OtherDocumentDTO;
import al.gov.mb.asylum.ui.models.SelectionDTO;



public class SelectionForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	
	SelectionDTO selection;
	List<OtherDocumentDTO> otherDocuments;
	DocumentDTO document;
	
	
	
	
	public SelectionDTO getSelection() {
		return selection;
	}
	public void setSelection(SelectionDTO selection) {
		this.selection = selection;
	}
	public List<OtherDocumentDTO> getOtherDocuments() {
		return otherDocuments;
	}
	public void setOtherDocuments(List<OtherDocumentDTO> otherDocuments) {
		this.otherDocuments = otherDocuments;
	}
	public DocumentDTO getDocument() {
		return document;
	}
	public void setDocument(DocumentDTO document) {
		this.document = document;
	}
	
	

	
}

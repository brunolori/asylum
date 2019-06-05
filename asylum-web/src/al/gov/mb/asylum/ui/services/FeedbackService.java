package al.gov.mb.asylum.ui.services;

import java.util.List;

import al.gov.mb.asylum.ui.api.clients.FeedbackClient;
import al.gov.mb.asylum.ui.forms.FeedbackSx;
import al.gov.mb.asylum.ui.models.FeedbackDTO;

public class FeedbackService {
	
	public FeedbackDTO registerFeedback(FeedbackDTO dto)
	{
		return new FeedbackClient().registerFeedback(dto);
	}
	
	public FeedbackDTO updateFeedback(FeedbackDTO dto)
	{
		return new FeedbackClient().updateFeedback(dto);
	}
	
	public void deleteFeedback(FeedbackDTO dto)
	{
		new FeedbackClient().deleteFeedback(dto);
	}
	
	public List<FeedbackDTO> searchFeedback(FeedbackSx req)
	{
		return new FeedbackClient().searchFeedback(req);
	}

	public List<FeedbackDTO> getSelectionFeedbacks(Integer eventId) {
		FeedbackSx req = new FeedbackSx();
		req.setSelectionId(eventId);
		return searchFeedback(req);
	}
	public FeedbackDTO getSelectionFeedback(Integer eventId) {
		FeedbackSx req = new FeedbackSx();
		req.setSelectionId(eventId);
		List<FeedbackDTO> list = searchFeedback(req);
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		
		return null;
	}
	
	

}

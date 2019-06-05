package al.gov.mb.asylum.ui.services;



import java.util.List;

import al.gov.mb.asylum.ui.api.clients.AppealClient;
import al.gov.mb.asylum.ui.models.AppealDTO;


public class AppealService {

	
	public AppealDTO registerAppeal(AppealDTO payload)
	{
		return new AppealClient().registerAppeal(payload);
	}
	
	public List<AppealDTO> getSelectionAppeals(Integer eventId)
	{
		return new AppealClient().getSelectionAppeals(eventId);
	}
	
}

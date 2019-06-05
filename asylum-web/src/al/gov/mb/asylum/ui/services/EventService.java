package al.gov.mb.asylum.ui.services;

import java.util.List;

import al.gov.mb.asylum.ui.api.clients.EventClient;
import al.gov.mb.asylum.ui.forms.EventForm;
import al.gov.mb.asylum.ui.forms.EventSx;
import al.gov.mb.asylum.ui.models.EventDTO;

public class EventService {

	public EventDTO registerEvent(EventForm form)
	{
		return new EventClient().registerEvent(form);
	}
	
	public EventDTO updateEvent(EventForm form)
	{
		return new EventClient().updateEvent(form);
	}
	
	public EventDTO getEventByUniqueNo(String uniqueNo)
	{
		return new EventClient().getEventByUniqueNo(uniqueNo);
	}
	
	public List<EventDTO> searchEvent(EventSx req)
	{
		return new EventClient().searchEvent(req);
	}
	
	
}

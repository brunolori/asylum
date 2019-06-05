package al.gov.mb.asylum.ui.services;

import java.util.List;

import al.gov.mb.asylum.ui.api.clients.HearingClient;
import al.gov.mb.asylum.ui.forms.HearingSx;
import al.gov.mb.asylum.ui.models.HearingDTO;

public class HearingService {
	
	public HearingDTO selectForHearing(HearingDTO dto)
	{
		return new HearingClient().selectForHearing(dto);
	}
	
	public HearingDTO registerHearing(HearingDTO dto)
	{
		return new HearingClient().registerHearing(dto);
	}
	
	public List<HearingDTO> searchHearing(HearingSx req)
	{
		return new HearingClient().searchHearing(req);
	}
	

}

package al.gov.mb.asylum.ui.services;

import al.gov.mb.asylum.ui.api.clients.BiometricClient;
import al.gov.mb.asylum.ui.models.BiometricDTO;

public class BiometricService {
	
	
	public void registerBiometric(BiometricDTO dto)
	{
		new BiometricClient().registerBiometric(dto);
	}
	
	public BiometricDTO findBiometric(Integer eventId)
	{
		return new BiometricClient().findBiometric(eventId);
	}

}

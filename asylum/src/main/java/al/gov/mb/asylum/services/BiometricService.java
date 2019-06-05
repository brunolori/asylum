package al.gov.mb.asylum.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.gov.mb.asylum.dao.BiometricDAO;
import al.gov.mb.asylum.dao.CrudDAO;
import al.gov.mb.asylum.dto.BiometricDTO;
import al.gov.mb.asylum.entities.tims.Biometric;
import al.gov.mb.asylum.entities.tims.IrregularEvent;
import al.gov.mb.asylum.exceptions.ValidationException;
import al.gov.mb.asylum.utils.CalculatorUtil;
import al.gov.mb.asylum.utils.StringUtil;

@Service
public class BiometricService {

	
	@Autowired CrudDAO crudDAO;
	@Autowired BiometricDAO biometricDAO;
	
	@Transactional
	public void registerPhoto(BiometricDTO dto,String uname)
	{
		if(!StringUtil.isValid(dto.getPhoto()))
		{
			throw new ValidationException("Ngarkoni Foton");
		}
		
		IrregularEvent event = crudDAO.findById(IrregularEvent.class, dto.getEventId());
		
		Biometric b = new Biometric();
		
		//b.setEvent(event);
		b.setEventId(event.getId());
		b.setPhoto(CalculatorUtil.decodeBASE64(dto.getPhoto()));
		b.setRecordDate(Calendar.getInstance().getTime());
		b.setRecordUser(uname);
	//	b.setUniqueNumber(b.getUniqueNumber());
		
		crudDAO.create(b);
	}
	
	public boolean findByUniqueNo(String uniqueNo, String uname)
	{
		return biometricDAO.exists(uniqueNo);
	}

	public Biometric findById(Integer eventId) {
		return crudDAO.findById(Biometric.class, eventId);
	}
	
}

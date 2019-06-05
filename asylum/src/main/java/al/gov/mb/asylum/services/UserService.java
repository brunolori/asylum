package al.gov.mb.asylum.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.gov.mb.asylum.constants.IRole;
import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.dao.CrudDAO;
import al.gov.mb.asylum.dao.UserDAO;
import al.gov.mb.asylum.entities.User;
import al.gov.mb.asylum.exceptions.ValidationException;
import al.gov.mb.asylum.forms.PasswordForm;
import al.gov.mb.asylum.models.Principal;
import al.gov.mb.asylum.security.Ldap;
import al.gov.mb.asylum.utils.StringUtil;

@Service
public class UserService {

	@Autowired CrudDAO crudDAO;
	@Autowired UserDAO userDAO;
	
	@Transactional
	public User login(Principal principal)
	{
		
		if(!StringUtil.isValid(principal.getUsername()))
		{
			throw new ValidationException("Plotesoni username");
		}
		
		if(!StringUtil.isValid(principal.getPassword()))
		{
			throw new ValidationException("Plotesoni fjalekalimin");
		}
		
		User u = crudDAO.findById(User.class, principal.getUsername());
		
		if(u == null)
		{
			throw new ValidationException("Perdoruesi nuk ekziston");
		}
		
		if(u.getStatus() == IStatus.NOT_ACTIVE)
		{
			throw new ValidationException("Perdoruesi nuk eshte aktiv");
		}
		
		if(u.getRole() == IRole.DRKM)
		{
			// update Tims Portal Officer from rims
			if(!new Ldap().ldapLogin(principal.getUsername(), principal.getPassword()))
			{
				throw new ValidationException("Fjalekalimi i pasakte (Domain)");
			}
			return u;
		}
		
		if(!principal.getPassword().equals(u.getSecret()))
		{
			throw new ValidationException("Fjalekalimi i pasakte");
		}
		
		return u;
		
	}
	
	@Transactional
	public void changePassword(PasswordForm form, String uname)
	{
		User u = crudDAO.findById(User.class, uname);
		
		if(!StringUtil.isValid(form.getOldPassword()))
		{
			throw new ValidationException("Plotesoni fjalekalimin e vjeter");
		}
		if(!StringUtil.isValid(form.getNewPassword()))
		{
			throw new ValidationException("Plotesoni fjalekalimin e ri");
		}
		if(form.getNewPassword().length() < 6)
		{
			throw new ValidationException("Fjalekalimi duhet te jete te pakten 6 karaktere");
		}
		if(!u.getSecret().equals(form.getOldPassword()))
		{
			throw new ValidationException("Fjalekalimi i vjeter eshte i pasakte");
		}
		
		u.setSecret(form.getNewPassword());
		u.setUpdateTime(Calendar.getInstance().getTime());
		u.setUpdateUser(uname);
		
		crudDAO.update(u);
		
	}
	
	
	
	
	
	
}

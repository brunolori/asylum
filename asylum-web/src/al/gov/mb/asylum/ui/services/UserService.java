package al.gov.mb.asylum.ui.services;

import al.gov.mb.asylum.ui.api.clients.UserClient;
import al.gov.mb.asylum.ui.forms.PasswordForm;
import al.gov.mb.asylum.ui.models.Principal;
import al.gov.mb.asylum.ui.models.UserToken;

public class UserService {
	
	
	public UserToken login(Principal principal)
	{
		return new UserClient().login(principal);
	}
	
	public void changePassword(PasswordForm form)
	{
		new UserClient().changePassword(form);
	}
	
	

}

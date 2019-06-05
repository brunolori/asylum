package al.gov.mb.asylum.ui.beans.application;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import al.gov.mb.asylum.ui.constants.IRole;
import al.gov.mb.asylum.ui.forms.PasswordForm;
import al.gov.mb.asylum.ui.models.Principal;
import al.gov.mb.asylum.ui.models.UserToken;
import al.gov.mb.asylum.ui.services.UserService;
import al.gov.mb.asylum.ui.utils.Messages;
import al.gov.mb.asylum.ui.utils.StringUtil;
import al.gov.mb.asylum.ui.utils.Util;





@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {


	private static final long serialVersionUID = 1L;
	

	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	String username;
	String password;
	
	UserToken userToken;
	
	String menu;
	
	
	PasswordForm form;
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserToken getUserToken() {
		return userToken;
	}

	public void setUserToken(UserToken userToken) {
		this.userToken = userToken;
	}

	public NavBean getNav() {
		return nav;
	}

	public void setNav(NavBean nav) {
		this.nav = nav;
	}	

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	public PasswordForm getForm() {
		return form;
	}

	public void setForm(PasswordForm form) {
		this.form = form;
	}

	
	@PostConstruct
	public void load()
	{
		this.form = new PasswordForm();
	}
	
	
	
	
	public void login() {
		
		
		if(!StringUtil.isValid(username))
		{
			Messages.throwFacesMessage("Plotëso Përdoruesin", 3);
			return;
		}
		
		if(!StringUtil.isValid(password))
		{
			Messages.throwFacesMessage("Plotëso Fjalëkalimin", 3);
			return;
		}
		
		Principal principal = new Principal();
		principal.setUsername(username);
		principal.setPassword(password);
		principal.setBrowser(Util.getBrowser());
		principal.setIp(Util.getAuthenticatedUserIp());
		
		try {
			
			this.userToken = new UserService().login(principal);
			
			if(userToken.getUser().getRole().equals(IRole.DFCA))
			{
				menu = "dfac-menu.xhtml";
				nav.navigate("home");
				Util.redirect("dfac/main");
			}
			else if(userToken.getUser().getRole().equals(IRole.QKPA))
			{
				menu = "qkpa-menu.xhtml";
				nav.navigate("home");
				Util.redirect("qkpa/main");
			}
			else if(userToken.getUser().getRole().equals(IRole.DRKM))
			{
				menu = "drkm-menu.xhtml";
				nav.navigate("home");
				Util.redirect("drkm/main");
			}
			
			

		}catch(Exception a) {
			Messages.throwFacesMessage(a);
		}
		
		
		
	}
	

	 public String logout() {
		try {
		            HttpSession session = Util.getSession();
		            if (session != null) {
		                session.invalidate();
		            }
		            
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		return "/login.xhtml?faces-redirect=true";
	}

		
	public void changePassword()
	{
		try {
			new UserService().changePassword(form);
			this.form = new PasswordForm();
			Messages.throwFacesMessage("Fjalekalimi u ndryshua me sukses",1);
		}catch(Exception e)
		{
			Messages.throwFacesMessage(e);
		}
	}
	
	
	public void clearPasswordForm()
	{
		this.form = new PasswordForm();
	}
	
	

}

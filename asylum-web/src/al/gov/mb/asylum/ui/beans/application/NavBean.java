package al.gov.mb.asylum.ui.beans.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import al.gov.mb.asylum.ui.models.History;
import al.gov.mb.asylum.ui.models.Param;

@ManagedBean
@SessionScoped
public class NavBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	String actualPage;
	List<Param> actualParams;
	List<History> history;
	
	
	@PostConstruct
	public void load()
	{
		this.actualPage = "home";
		this.history = new ArrayList<>();
	}
	
	public String getActualPage() {
		return actualPage;
	}
	public void setActualPage(String actualPage) {
		this.actualPage = actualPage;
	}
	public List<Param> getActualParams() {
		return actualParams;
	}
	public void setActualParams(List<Param> actualParams) {
		this.actualParams = actualParams;
	}
	public List<History> getHistory() {
		return history;
	}
	public void setHistory(List<History> history) {
		this.history = history;
	}
	
	
	@SuppressWarnings("rawtypes")
	public void navigate(String to)
	{
		Map<String, String> reqParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		List<Param> params = new ArrayList<>();
		Iterator it = reqParams.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pair = (Map.Entry) it.next();
			Param p = new Param((String)pair.getKey(), (String)pair.getValue());
			params.add(p);
		}
		
		
		History h = new History(actualPage,actualParams);
		history.add(0,h);
		actualPage = to;
		actualParams = params;
	}
	
	
	public void navigate(String to,List<Param> params)
	{
		History h = new History(actualPage,actualParams);
		history.add(0,h);
		actualPage = to;
		actualParams = params;
	}
	
	public void back()
	{
		History h = history.get(0);
		actualPage = h.getPage();
		actualParams = h.getParams();
		history.remove(0);
	}
	
	public String getParam(String name)
	{
		for(Param p : actualParams)
		{
			if(name.equals(p.getName()))
			{
				return p.getValue();
			}
		}
		
		return null;
	}
	


}

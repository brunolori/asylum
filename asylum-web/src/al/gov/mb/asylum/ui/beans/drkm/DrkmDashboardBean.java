package al.gov.mb.asylum.ui.beans.drkm;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.constants.IDecisionType;
import al.gov.mb.asylum.ui.models.KeyValue;
import al.gov.mb.asylum.ui.models.OrganizationDTO;
import al.gov.mb.asylum.ui.services.HelperService;
import al.gov.mb.asylum.ui.services.RaportService;

@ManagedBean
@ViewScoped
public class DrkmDashboardBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	
	long total;
	long female;
	long male;
	long noGender;
	long child;
	long azylant;
	long trafficVictim;
	long irregularImigrant;
	long gone;
	long returned;
	
	long expulsionOrder;
	long removalOrder;
	long detentionOrder;
	
	
    LineChartModel dayModel;
	BarChartModel organizationModel;
	
	PieChartModel stateModel;
	PieChartModel statusModel;
	PieChartModel decisionModel;
	PieChartModel placeTypeModel;
	
	List<KeyValue> regByState;
	
		
	Date from;
	Date to;
	
	int period;
	Integer organizationId;
	List<OrganizationDTO> organizations;
	
	
	public NavBean getNav() {
		return nav;
	}
	public void setNav(NavBean nav) {
		this.nav = nav;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getFemale() {
		return female;
	}
	public void setFemale(long female) {
		this.female = female;
	}
	public long getMale() {
		return male;
	}
	public void setMale(long male) {
		this.male = male;
	}
	public long getNoGender() {
		return noGender;
	}
	public void setNoGender(long noGender) {
		this.noGender = noGender;
	}
	public long getChild() {
		return child;
	}
	public void setChild(long child) {
		this.child = child;
	}
	public long getAzylant() {
		return azylant;
	}
	public void setAzylant(long azylant) {
		this.azylant = azylant;
	}
	public long getTrafficVictim() {
		return trafficVictim;
	}
	public void setTrafficVictim(long trafficVictim) {
		this.trafficVictim = trafficVictim;
	}
	public long getIrregularImigrant() {
		return irregularImigrant;
	}
	public void setIrregularImigrant(long irregularImigrant) {
		this.irregularImigrant = irregularImigrant;
	}
	public long getGone() {
		return gone;
	}
	public void setGone(long gone) {
		this.gone = gone;
	}
	public long getReturned() {
		return returned;
	}
	public void setReturned(long returned) {
		this.returned = returned;
	}
	public long getExpulsionOrder() {
		return expulsionOrder;
	}
	public void setExpulsionOrder(long expulsionOrder) {
		this.expulsionOrder = expulsionOrder;
	}
	public long getRemovalOrder() {
		return removalOrder;
	}
	public void setRemovalOrder(long removalOrder) {
		this.removalOrder = removalOrder;
	}
	public long getDetentionOrder() {
		return detentionOrder;
	}
	public void setDetentionOrder(long detentionOrder) {
		this.detentionOrder = detentionOrder;
	}
	public LineChartModel getDayModel() {
		return dayModel;
	}
	public void setDayModel(LineChartModel dayModel) {
		this.dayModel = dayModel;
	}
	public BarChartModel getOrganizationModel() {
		return organizationModel;
	}
	public void setOrganizationModel(BarChartModel organizationModel) {
		this.organizationModel = organizationModel;
	}
	public PieChartModel getStateModel() {
		return stateModel;
	}
	public void setStateModel(PieChartModel stateModel) {
		this.stateModel = stateModel;
	}
	public PieChartModel getStatusModel() {
		return statusModel;
	}
	public void setStatusModel(PieChartModel statusModel) {
		this.statusModel = statusModel;
	}
	public PieChartModel getDecisionModel() {
		return decisionModel;
	}
	public void setDecisionModel(PieChartModel decisionModel) {
		this.decisionModel = decisionModel;
	}
	public PieChartModel getPlaceTypeModel() {
		return placeTypeModel;
	}
	public void setPlaceTypeModel(PieChartModel placeTypeModel) {
		this.placeTypeModel = placeTypeModel;
	}
	public List<KeyValue> getRegByState() {
		return regByState;
	}
	public void setRegByState(List<KeyValue> regByState) {
		this.regByState = regByState;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public Integer getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}		
	
	public List<OrganizationDTO> getOrganizations() {
		return organizations;
	}
	public void setOrganizations(List<OrganizationDTO> organizations) {
		this.organizations = organizations;
	}
	
	
	@PostConstruct
	public void load()
	{ 
		this.organizations = new HelperService().listOrganization();
		this.period = 1;
		defaultDates();
		onFilterChange();
	}
	
	
	public void onPeriodSelect()
	{
				
		switch(period)
		{
		   case 1 : defaultDates(); break;
		   case 2 : thisYear(); break;
		   case 3 : lastMonth(); break;
		   case 4 : lastThreeMonths(); break;
		   case 5 : lastSixMonths(); break;
		   case 6 : lastYear(); break;
		   
		   default : defaultDates();
		}
		
		onFilterChange();
	}
	
	private void defaultDates()
	{
		Calendar cal = Calendar.getInstance();
		this.to = cal.getTime();
		cal.set(Calendar.DATE, 1);
		this.from = cal.getTime();
	}
	
	private void lastMonth()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.DATE, -1);
		this.to = cal.getTime();
		cal.set(Calendar.DATE, 1);
		this.from = cal.getTime();
	}
	
	private void lastThreeMonths()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.DATE, -1);
		this.to = cal.getTime();
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.MONTH, -2);
		this.from = cal.getTime();
	}
	
	private void lastSixMonths()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.DATE, -1);
		this.to = cal.getTime();
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.MONTH, -5);
		this.from = cal.getTime();
	}
	
	private void thisYear()
	{
		Calendar cal = Calendar.getInstance();
		this.to = cal.getTime();
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.MONTH, 0);
		this.from = cal.getTime();
	}
	
	private void lastYear()
	{
		Calendar cal = Calendar.getInstance();
		this.to = cal.getTime();
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.MONTH, 0);
		cal.add(Calendar.DATE, -1);
		this.to = cal.getTime();
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.MONTH, 0);
		this.from = cal.getTime();
	}
	
	
	
	
	
	
	public void onFilterChange()
	{
		
		if(to == null)
		{
			to = Calendar.getInstance().getTime();
		}
		if(from == null)
		{
			defaultDates();
		}
		
		
		
		this.total = new RaportService().countAll(from, to, organizationId);
		List<KeyValue> gender = new RaportService().registeredSelectionsByGender(from, to, organizationId);
		noGender = 0;
		male = 0;
		female = 0;
		if(gender != null && !gender.isEmpty())
		{
			for(KeyValue kv : gender)
			{
				
				if(kv.getKey() == null || kv.getKey().equalsIgnoreCase("null")) this.noGender = (Integer) kv.getValue();
				else if(kv.getKey().equalsIgnoreCase("M")) this.male = (Integer) kv.getValue();
				else if(kv.getKey().equalsIgnoreCase("F")) this.female = (Integer) kv.getValue();
			}
		}
		this.child = new RaportService().childCountByPeriod(from, to, organizationId);
		this.gone = new RaportService().gonePersonsCountByPeriod(from, to, organizationId);
		this.returned = new RaportService().returnedPersonsCountByPeriod(from, to, organizationId);
		
		
				
		generateDayChart();
		generateOrganizationChart();
		
		generateStateChart();
		generateStatusChart(); // gjeneron dhe statiket
		generatePlaceTypeChart();
		generateDecisionTypeChart(); // gjeneron dhe vlerat statike
		
	}
	
	
	public void generateDecisionTypeChart() {
		
		
		this.decisionModel = new PieChartModel();	
		
		List<KeyValue> decisionTypes = new RaportService().registeredDecisionsByType(from, to, organizationId);
				
		this.detentionOrder = 0;
		this.expulsionOrder = 0;
		this.removalOrder = 0;
		
		if(decisionTypes != null && !decisionTypes.isEmpty())
		{
			for(KeyValue k : decisionTypes)
			{
				String name = "";
				if(k.getKey().equals(IDecisionType.F_DETENTION_ORDER))
				{
					this.detentionOrder = (Integer)k.getValue();
					name = "Urdhër për ndalim";
				}
				else if(k.getKey().equals(IDecisionType.F_EXPULSION_ORDER))
				{
					this.expulsionOrder = (Integer)k.getValue();
					name = "Urdhër dëbimi";
				}
				else if(k.getKey().equals(IDecisionType.F_REMOVAL_ORDER))
				{
					this.removalOrder = (Integer)k.getValue();
					name = "Urdhër largimi";
				}
				
				decisionModel.set(name+"-"+k.getValue(), (Integer)k.getValue());
			}
		}
		else
		{
			decisionModel.set("ska", 1);
		}
		
		decisionModel.setTitle("Vendimet e regjistruara");
		decisionModel.setLegendPosition("s");
		decisionModel.setLegendCols(1);
		//decisionModel.setLegendRows(8);
		decisionModel.setFill(true);
		decisionModel.setShowDatatip(true);
		decisionModel.setShowDataLabels(true);
		decisionModel.setExtender("skinPie");
		
	}
	
	public void generatePlaceTypeChart() {
		
		List<KeyValue> placeTypes = new RaportService().registeredSelectionsByPlaceType(from, to, organizationId);
		
		this.placeTypeModel = new PieChartModel();		
		
		if(placeTypes != null && !placeTypes.isEmpty())
		{
			for(KeyValue k : placeTypes)
			{
				placeTypeModel.set(k.getKey()+"-"+k.getValue(), (Integer)k.getValue());
			}
		}
		else
		{
			placeTypeModel.set("ska", 1);
		}
		placeTypeModel.setTitle("Regjistrimet sipas vendit");
		placeTypeModel.setLegendPosition("s");
		placeTypeModel.setLegendCols(1);
		//placeTypeModel.setLegendRows(8);
		placeTypeModel.setFill(true);
		placeTypeModel.setShowDatatip(true);
		placeTypeModel.setShowDataLabels(true);
		placeTypeModel.setExtender("skinPie");
		
	}
	
	public void generateDayChart()
	{
		List<KeyValue> list = new RaportService().registeredSelectionsByPeriod(from, to, organizationId);
		
		this.dayModel = new LineChartModel();
		dayModel.setShowPointLabels(true);
		LineChartSeries days = new LineChartSeries();
		days.setLabel("Regjistrime sipas Ditëve");
		days.setShowLine(true);
		days.setShowMarker(true);
		
		if(list != null && !list.isEmpty())
		{
			for(KeyValue k : list)
			{
				days.set(k.getKey(), (Integer)k.getValue());
			}
		}
		else
		{
			days.set("ska", 0);
		}
		
		dayModel.addSeries(days);
		dayModel.setExtender("skinChart");
		
		CategoryAxis axis = new CategoryAxis("Datat");
        axis.setTickAngle(-50);      
 
        dayModel.getAxes().put(AxisType.X, axis);
        dayModel.getAxis(AxisType.Y).setMin(0);
       
		
		
	}
	
	public void generateOrganizationChart()
	{
		List<KeyValue> list = new RaportService().registeredSelectionsByOrganization(from, to);
		
		this.organizationModel = new BarChartModel();
		organizationModel.setShowPointLabels(true);
		
		ChartSeries orgs = new ChartSeries();
		orgs.setLabel("Regjistrime sipas DRKM");
		
		
		if(list != null && !list.isEmpty())
		{
			for(KeyValue k : list)
			{
				orgs.set(k.getKey().replace("DREJTORIA VENDORE KUFIRIT DHE MIGRACIONIT", "DRKM"), (Integer)k.getValue());
			}
		}
		else
		{
			orgs.set("ska", 0);
		}
		
		organizationModel.addSeries(orgs);
		organizationModel.setExtender("skinBar");
		CategoryAxis axis = new CategoryAxis("Strukturat");
		axis.setTickAngle(-50);   
        organizationModel.getAxes().put(AxisType.X, axis);
        organizationModel.getAxis(AxisType.Y).setMin(0);
		
	}
	
	public void generateStateChart()
	{
		regByState = new RaportService().registeredSelectionsByState(from, to, organizationId);
		
		this.stateModel = new PieChartModel();		
		
		if(regByState != null && !regByState.isEmpty())
		{
			for(KeyValue k : regByState)
			{
				stateModel.set(k.getKey(), (Integer)k.getValue());
			}
		}
		else
		{
			stateModel.set("ska", 1);
		}
		stateModel.setTitle("Regjistrimet sipas shteteve");
		stateModel.setLegendPosition("w");
		stateModel.setLegendCols(1);
		stateModel.setLegendRows(8);
		stateModel.setFill(true);
		stateModel.setShowDatatip(true);
		stateModel.setShowDataLabels(true);
		stateModel.setExtender("skinPie");
		
		
	}
	
	public void generateStatusChart()
	{
        this.statusModel = new PieChartModel();		
        
        this.azylant = new RaportService().countAllAsylants(from, to, organizationId);
		this.trafficVictim = new RaportService().countAllTrafficVictims(from, to, organizationId);
		this.irregularImigrant = new RaportService().countAllIrregularImigrants(from, to, organizationId);

		if((azylant + irregularImigrant + trafficVictim) > 0)
		{
	        statusModel.set("Azilant-"+azylant, azylant);
	        statusModel.set("Viktime Trafiku-"+trafficVictim, trafficVictim);
	        statusModel.set("Imigrant i parregullt-"+irregularImigrant, irregularImigrant);
		}
		else
		{
			statusModel.set("ska-", 1);
		}
		statusModel.setTitle("Regjistrimet sipas statusit");
		statusModel.setLegendPosition("s");
		statusModel.setLegendCols(1);
		//statusModel.setLegendRows(8);
		statusModel.setFill(true);
		statusModel.setShowDatatip(true);
		statusModel.setShowDataLabels(true);
		statusModel.setExtender("skinPie");
	}
	
	
	
	
	
	
	
	
	
}

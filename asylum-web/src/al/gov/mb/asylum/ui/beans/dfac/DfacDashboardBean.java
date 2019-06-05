package al.gov.mb.asylum.ui.beans.dfac;

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
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;


import al.gov.mb.asylum.ui.beans.application.NavBean;
import al.gov.mb.asylum.ui.models.KeyValue;
import al.gov.mb.asylum.ui.services.StatisticService;

@ManagedBean
@ViewScoped
public class DfacDashboardBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{navBean}")
	NavBean nav;
	
	
	long total;
	long female;
	long male;
	long noGender;
	long child;
	long unaccompainedChild;
	long inNeed;
	long withIncomes;
	long gone;
	long refugee;
	long extraProtection;
	long internationalProtection;
	long temporaryProtection;
	
	
    LineChartModel dayModel;
	BarChartModel organizationModel;
	PieChartModel stateModel;
	PieChartModel statusModel;
	
	List<KeyValue> regByState;
	
		
	Date from;
	Date to;
	
	int period;
	
	
	
	
	
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

	public long getUnaccompainedChild() {
		return unaccompainedChild;
	}

	public void setUnaccompainedChild(long unaccompainedChild) {
		this.unaccompainedChild = unaccompainedChild;
	}

	public long getInNeed() {
		return inNeed;
	}

	public void setInNeed(long inNeed) {
		this.inNeed = inNeed;
	}

	public long getWithIncomes() {
		return withIncomes;
	}

	public void setWithIncomes(long withIncomes) {
		this.withIncomes = withIncomes;
	}

	public long getGone() {
		return gone;
	}

	public void setGone(long gone) {
		this.gone = gone;
	}

	public long getRefugee() {
		return refugee;
	}

	public void setRefugee(long refugee) {
		this.refugee = refugee;
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

	public List<KeyValue> getRegByState() {
		return regByState;
	}

	public void setRegByState(List<KeyValue> regByState) {
		this.regByState = regByState;
	}

	public long getExtraProtection() {
		return extraProtection;
	}

	public void setExtraProtection(long extraProtection) {
		this.extraProtection = extraProtection;
	}

	public long getInternationalProtection() {
		return internationalProtection;
	}

	public void setInternationalProtection(long internationalProtection) {
		this.internationalProtection = internationalProtection;
	}

	public long getTemporaryProtection() {
		return temporaryProtection;
	}

	public void setTemporaryProtection(long temporaryProtection) {
		this.temporaryProtection = temporaryProtection;
	}

	@PostConstruct
	public void load()
	{ 
		this.period = 1;
		defaultDates();
		onDateChange();
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
		
		onDateChange();
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
	
	
	
	
	
	
	public void onDateChange()
	{
		
		if(to == null)
		{
			to = Calendar.getInstance().getTime();
		}
		if(from == null)
		{
			defaultDates();
		}
		
		
		
		this.total = new StatisticService().countAll(from, to);
		List<KeyValue> gender = new StatisticService().registeredSelectionsByGender(from, to);
		noGender = 0;
		male = 0;
		female = 0;
		for(KeyValue kv : gender)
		{
			if(kv.getKey() == null || kv.getKey().equalsIgnoreCase("null")) this.noGender = (Integer) kv.getValue();
			else if(kv.getKey().equalsIgnoreCase("M")) this.male = (Integer) kv.getValue();
			else if(kv.getKey().equalsIgnoreCase("F")) this.female = (Integer) kv.getValue();
		}
		this.child = new StatisticService().childCountByPeriod(from, to);
		this.unaccompainedChild = new StatisticService().unaccompainedChildCountByPeriod(from, to);
		this.inNeed = new StatisticService().personsInNeedCountByPeriod(from, to);
		this.withIncomes = 0;
		this.gone = new StatisticService().gonePersonsCountByPeriod(from, to);
		this.refugee = new StatisticService().refugeeCountByPeriod(from, to);
		this.extraProtection = new StatisticService().extraProtectionCountByPeriod(from, to);
		this.internationalProtection = new StatisticService().internationalProtectionCountByPeriod(from, to);
		this.temporaryProtection = new StatisticService().temporaryProtectionCountByPeriod(from, to);
		
		generateDayChart();
		generateOrganizationChart();
		generateStateChart();
		generateStatusChart();
		
	}
	
	
	public void generateDayChart()
	{
		List<KeyValue> list = new StatisticService().registeredSelectionsByPeriod(from, to);
		
		this.dayModel = new LineChartModel();
		dayModel.setShowPointLabels(true);
		LineChartSeries days = new LineChartSeries();
		days.setLabel("Regjistrime sipas Dit�ve");
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
		List<KeyValue> list = new StatisticService().registeredSelectionsByOrganization(from, to);
		
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
		regByState = new StatisticService().registeredSelectionsByState(from, to);
		
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
			stateModel.set("ska", 0);
		}
		stateModel.setTitle("Regjistrimet sipas shteteve");
		stateModel.setLegendPosition("nw");
		stateModel.setLegendCols(1);
		stateModel.setLegendRows(8);
		stateModel.setFill(true);
		stateModel.setShowDatatip(true);
		stateModel.setShowDataLabels(true);
		stateModel.setExtender("skinPie");
		
		
	}
	
	public void generateStatusChart()
	{
		
	}
	
	
	
	
	
	
	
}

package al.gov.mb.asylum.ui.beans.application;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import al.gov.mb.asylum.ui.constants.IDecisionType;
import al.gov.mb.asylum.ui.constants.IHearingStatus;
import al.gov.mb.asylum.ui.constants.IInterviewStatus;
import al.gov.mb.asylum.ui.constants.IIrStatus;
import al.gov.mb.asylum.ui.constants.IStatus;




@ManagedBean(name="constB")
@RequestScoped
public class ConstantBean implements Serializable {

	private static final long serialVersionUID = 1L;
	

	 private int INT_SELECTED = IInterviewStatus.SELECTED;
	 private int INT_COMPLETED = IInterviewStatus.COMPLETED;
	 private int H_SELECTED = IHearingStatus.SELECTED;
	 private int H_COMPLETED = IHearingStatus.COMPLETED;
	 private int YES = 1;
	 private Character F_YES = IStatus.YES;
	 private String AZILANT = IIrStatus.AZILANT;
	 private String TRAFFIC_VICTIM = IIrStatus.TRAFFIC_VICTIM;
	 private String IRREGULAR_IMIGRANT = IIrStatus.IRREGULAR_IMIGRANT;
	 
	 private String EXPULSION_ORDER = IDecisionType.F_EXPULSION_ORDER;
	 private String REMOVAL_ORDER = IDecisionType.F_REMOVAL_ORDER;
	 private String DETENTION_ORDER = IDecisionType.F_DETENTION_ORDER;
	 
	public String getAZILANT() {
		return AZILANT;
	}
	public void setAZILANT(String aZILANT) {
		AZILANT = aZILANT;
	}
	public String getTRAFFIC_VICTIM() {
		return TRAFFIC_VICTIM;
	}
	public void setTRAFFIC_VICTIM(String tRAFFIC_VICTIM) {
		TRAFFIC_VICTIM = tRAFFIC_VICTIM;
	}
	public String getIRREGULAR_IMIGRANT() {
		return IRREGULAR_IMIGRANT;
	}
	public void setIRREGULAR_IMIGRANT(String iRREGULAR_IMIGRANT) {
		IRREGULAR_IMIGRANT = iRREGULAR_IMIGRANT;
	}
	public String getEXPULSION_ORDER() {
		return EXPULSION_ORDER;
	}
	public void setEXPULSION_ORDER(String eXPULSION_ORDER) {
		EXPULSION_ORDER = eXPULSION_ORDER;
	}
	public String getREMOVAL_ORDER() {
		return REMOVAL_ORDER;
	}
	public void setREMOVAL_ORDER(String rEMOVAL_ORDER) {
		REMOVAL_ORDER = rEMOVAL_ORDER;
	}
	public String getDETENTION_ORDER() {
		return DETENTION_ORDER;
	}
	public void setDETENTION_ORDER(String dETENTION_ORDER) {
		DETENTION_ORDER = dETENTION_ORDER;
	}
	public int getYES() {
		return YES;
	}
	public void setYES(int yES) {
		YES = yES;
	}
	public Character getF_YES() {
		return F_YES;
	}	
	public int getINT_SELECTED() {
		return INT_SELECTED;
	}
	public void setINT_SELECTED(int iNT_SELECTED) {
		INT_SELECTED = iNT_SELECTED;
	}
	public int getINT_COMPLETED() {
		return INT_COMPLETED;
	}
	public void setINT_COMPLETED(int iNT_COMPLETED) {
		INT_COMPLETED = iNT_COMPLETED;
	}
	public void setF_YES(Character f_YES) {
		F_YES = f_YES;
	}
	public int getH_SELECTED() {
		return H_SELECTED;
	}
	public void setH_SELECTED(int h_SELECTED) {
		H_SELECTED = h_SELECTED;
	}
	public int getH_COMPLETED() {
		return H_COMPLETED;
	}
	public void setH_COMPLETED(int h_COMPLETED) {
		H_COMPLETED = h_COMPLETED;
	}
	
	
	

}

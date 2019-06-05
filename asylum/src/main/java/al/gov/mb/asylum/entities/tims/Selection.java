/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.gov.mb.asylum.entities.tims;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import al.gov.mb.asylum.entities.AsylantDetails;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "IR_SELECTION", schema="FER")
@Getter @Setter
public class Selection implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")
    @ManyToOne
    private IrregularEvent event;
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID" , insertable=false)
    @ManyToOne
    private AsylantDetails asylantDetails;
    @Lob
    @Column(name = "ITINERARY")
    private String itinerary;
    @Lob
    @Column(name = "FLEEING_REASON")
    private String fleeingReason;
    @Column(name = "SELECTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date selectionDate;
    @Column(name = "RECORD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;
    @Size(max = 100)
    @Column(name = "RECORD_USER")
    private String recordUser;
    @Size(max = 100)
    @Column(name = "MODIF_USER")
    private String modifUser;
    @Size(max = 100)
    @Column(name = "TRANSLATOR")
    private String translator;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "INTERVIEWER")
    private String interviewer;
    @Size(max = 100)
    @Column(name = "TRANS_LANG")
    private String transLang;
    @Lob
    @Column(name = "NOTES")
    private String notes;
    @Size(max = 200)
    @Column(name = "ALB_ADDRESS")
    private String albAddress;
    @Size(max = 200)
    @Column(name = "ENTRY_PLACE")
    private String entryPlace;
    @Size(max = 200)
    @Column(name = "ENTRY_MODE")
    private String entryMode;
    @Size(max = 100)
    @Column(name = "REASON")
    private String reason;
    @JoinColumn(name = "HANDED", referencedColumnName = "ID")
    @ManyToOne
    private HandedOver handed;
    @JoinColumn(name = "IR_PERSON_ID", referencedColumnName = "IR_PERSON_ID")
    @ManyToOne
    private Person person;
    @JoinColumn(name = "IR_STATUS", referencedColumnName = "ID")
    @ManyToOne
    private IrStatus irStatus;


    public Selection() {
    }
    
   


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Selection other = (Selection) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		return true;
	}

  
    
}

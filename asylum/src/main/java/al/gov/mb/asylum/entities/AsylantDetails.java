/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.gov.mb.asylum.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import al.gov.mb.asylum.entities.tims.Organization;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "ASYLANT_DETAILS", schema="ASYLUM")
@Cacheable(false)
@Getter
@Setter
public class AsylantDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "EVENT_ID")
    private Integer eventId;
  //  @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")
  //  @OneToOne
  //  private Selection selection;
    @Column(name = "IN_NEED")
    private Character inNeed;
    @Size(max = 500)
    @Column(name = "NEEDS")
    private String needs;
    @Column(name = "WITH_INCOMES")
    private Character withIncomes;
    @Column(name = "INCOMES")
    private String incomes;
    @Column(name = "ACCELERATED_PROCESS")
    private Character acceleratedProcess;
    @Column(name = "RETURNED")
    private Character returned;
    @Column(name = "UNACCOMPAINED_CHILD")
    private Character unaccompainedChild;
    @Column(name = "FEEDBACK_VALUE")
    private Character feedbackValue;
    @JoinColumn(name = "CURRENT_LOCATION_ID", referencedColumnName = "ID")
    @ManyToOne
    private Organization currentLocation;
    @Column(name = "INTERVIEW_CNT")
    private Integer interviewCnt;
    @Column(name = "HEARING_CNT")
    private Integer hearingCnt;
    @Size(max = 100)
    @Column(name = "ISSUED_ALB_DOCS")
    private String issuedAlbDocs;
    @Column(name = "FAMILY_ID")
    private Integer familyId;
    @JoinColumn(name = "ASYLANT_STAGE_ID", referencedColumnName = "ID")
    @ManyToOne
    private AsylantStage asylantStage;
    @JoinColumn(name = "ASYLANT_STATUS_ID", referencedColumnName = "ID")
    @ManyToOne
    private AsylantStatus asylantStatus;
    @JoinColumn(name = "FAMILY_UNION_STATUS_ID", referencedColumnName = "ID")
    @ManyToOne
    private FamilyUnionStatus familyUnionStatus;
    @JoinColumn(name = "LAST_HEARING_STATUS_ID", referencedColumnName = "ID")
    @ManyToOne
    private HearingStatus lastHearingStatus;
    @JoinColumn(name = "LAST_INTERVIEW_STATUS_ID", referencedColumnName = "ID")
    @ManyToOne
    private InterviewStatus lastInterviewStatus;
    @JoinColumn(name = "TRANSFER_STATUS_ID", referencedColumnName = "ID")
    @ManyToOne
    private TransferStatus transferStatus;

    public AsylantDetails() {
    }

   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.gov.mb.asylum.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import al.gov.mb.asylum.entities.tims.Selection;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "ASYLUM_DECISION", schema="ASYLUM")
@Getter @Setter
public class AsylumDecision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asylum_decision_seq")
    @SequenceGenerator(sequenceName = "ASYLUM.ASYLUM_DECISION_SEQ", allocationSize = 1, name = "asylum_decision_seq")
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")
    @ManyToOne
    private Selection selection;
    @Column(name = "DECISION_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date decisionTime;
    @Size(max = 100)
    @Column(name = "DECISION_USER")
    private String decisionUser;
    @Size(max = 500)
    @Column(name = "NOTES")
    private String notes;
    @Size(max = 20)
    @Column(name = "ORDER_NO")
    private String orderNo;
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Size(max = 20)
    @Column(name = "ARTICLE")
    private String article;
    @Column(name = "STATUS")
    private Integer status;
    @JoinColumn(name = "OLD_STAGE_ID", referencedColumnName = "ID")
    @ManyToOne
    private AsylantStage oldStage;
    @JoinColumn(name = "NEW_STAGE_ID", referencedColumnName = "ID")
    @ManyToOne
    private AsylantStage newStage;
    @JoinColumn(name = "OLD_STATUS_ID", referencedColumnName = "ID")
    @ManyToOne
    private AsylantStatus oldStatus;
    @JoinColumn(name = "NEW_STATUS_ID", referencedColumnName = "ID")
    @ManyToOne
    private AsylantStatus newStatus;
    @JoinColumn(name = "DECISION_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private AsylumDecisionType decisionType;

    public AsylumDecision() {
    }

    
    
}

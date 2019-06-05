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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "IR_DECISION", schema="FER")
@Getter @Setter
public class Decision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IR_DECISION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "decision_seq")
    @SequenceGenerator(sequenceName = "FER.SEQ_IR_DECISION", allocationSize = 1, name = "decision_seq")
    private Integer id;
    @Size(max = 10)
    @Column(name = "ARTICLE")
    private String article;
    @Size(max = 10)
    @Column(name = "ORDER_NUMBER")
    private String orderNumber;
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Size(max = 2)
    @Column(name = "REASON")
    private String reason;
    @Column(name = "DAY_REMOVAL")
    private Integer dayRemoval;
    @Size(max = 200)
    @Column(name = "BORDER_CROSSING_POINT")
    private String borderCrossingPoint;
    @Column(name = "DATE_PERMIT_ENTRANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePermitEntrance;
    @Size(max = 100)
    @Column(name = "RECORD_USER")
    private String recordUser;
    @Column(name = "RECORD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;
    @Size(max = 100)
    @Column(name = "MODIF_USER")
    private String modifUser;
    @JoinColumns({
        @JoinColumn(name = "CODE_ORDER", referencedColumnName = "CODE_ORDER"),
        @JoinColumn(name = "IR_TYPE_ORDER", referencedColumnName = "IR_TYPE_ORDER")})
    @ManyToOne
    private DecisionReason decisionReason;
    @JoinColumn(name = "IR_ORDER_STATUS", referencedColumnName = "IR_ORDER_STATUS")
    @ManyToOne
    private DecisionStatus orderStatus;
    @JoinColumn(name = "DECISION_TYPE", referencedColumnName = "DECISION_TYPE_ID")
    @ManyToOne
    private DecisionType decisionType;
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")
    @ManyToOne
    private Selection selection;
    

    public Decision() {
    }

   
    
}

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
import javax.persistence.Lob;
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
@Table(name = "IR_DECISION_HISTORY", schema="FER")
@Getter @Setter
public class DecisionHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "decision_history_seq")
    @SequenceGenerator(sequenceName = "FER.SEQ_IR_DECISION_HIST", allocationSize = 1, name = "decision_history_seq")
    @Column(name = "ID_DECISION_HISTORY")
    private Integer id;
    @Size(max = 10)
    @Column(name = "PROCESS")
    private String process;
    @Lob
    @Column(name = "FIELD")
    private String field;
    @Size(max = 200)
    @Column(name = "NOTES")
    private String notes;
    @Size(max = 100)
    @Column(name = "RECORD_USER")
    private String recordUser;
    @Column(name = "RECORD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;
    @JoinColumn(name = "IR_DECISION_ID", referencedColumnName = "IR_DECISION_ID")
    @ManyToOne
    private Decision decision;

    public DecisionHistory() {
    }

   
    
}

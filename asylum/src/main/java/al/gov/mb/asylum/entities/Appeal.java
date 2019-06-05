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
@Table(name = "APPEAL", schema="ASYLUM")
@Getter @Setter
public class Appeal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appeal_seq")
    @SequenceGenerator(sequenceName = "ASYLUM.APPEAL_SEQ", allocationSize = 1, name = "appeal_seq")
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")
    @ManyToOne
    private Selection selection;
    @Column(name = "APPEAL_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appealTime;
    @Size(max = 100)
    @Column(name = "APPEAL_USER")
    private String appealUser;
    @Size(max = 20)
    @Column(name = "DECISION_NO")
    private String decisionNo;
    @Column(name = "DECISION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date decisionDate;
    @Size(max = 500)
    @Column(name = "NOTES")
    private String notes;
    @Column(name = "STATUS")
    private Integer status;

    public Appeal() {
    }

  
    
    
}

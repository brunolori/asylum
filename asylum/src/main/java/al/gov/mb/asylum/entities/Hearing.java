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
@Table(name = "HEARING", schema="ASYLUM")
@Getter @Setter
public class Hearing implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hearing_seq")
    @SequenceGenerator(sequenceName = "ASYLUM.HEARING_SEQ", allocationSize = 1, name = "hearing_seq")
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")
    @ManyToOne
    private Selection selection;
    @Column(name = "HEARING_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hearingTime;
    @Size(max = 100)
    @Column(name = "HEARING_USER")
    private String hearingUser;
    @Column(name = "SELECTION_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date selectionTime;
    @Size(max = 100)
    @Column(name = "SELECTION_USER")
    private String selectionUser;
    @Column(name = "SELECTION_NOTES")
    private String selectionNotes;
    @Size(max = 100)
    @Column(name = "LISTENER")
    private String listener;
    @Size(max = 50)
    @Column(name = "LANGUAGE")
    private String language;
    @Size(max = 100)
    @Column(name = "TRANSLATOR")
    private String translator;
    @Size(max = 500)
    @Column(name = "NOTES")
    private String notes;
    @Column(name = "STATUS")
    private Integer status;
    @JoinColumn(name = "HEARING_STATUS_ID", referencedColumnName = "ID")
    @ManyToOne
    private HearingStatus hearingStatus;
    @Column(name = "PREDICTED_HEARING_DATE")
    @Temporal(TemporalType.DATE)
    private Date predictedHearingDate;

    public Hearing() {
    }

   
    
}

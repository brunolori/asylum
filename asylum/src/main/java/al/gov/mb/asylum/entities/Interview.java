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
@Table(name = "INTERVIEW", schema="ASYLUM")
@Getter @Setter
public class Interview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interview_seq")
    @SequenceGenerator(sequenceName = "ASYLUM.INTERVIEW_SEQ", allocationSize = 1, name = "interview_seq")
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")
    @ManyToOne
    private Selection selection;
    @Column(name = "SELECTION_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date selectionTime;
    @Column(name = "SELECTION_NOTES")
    private String selectionNotes;
    @Size(max = 100)
    @Column(name = "SELECTION_USER")
    private String selectionUser;
    @Column(name = "INTERVIEW_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date interviewTime;
    @Size(max = 100)
    @Column(name = "INTERVIEW_USER")
    private String interviewUser;
    @Size(max = 500)
    @Column(name = "NOTES")
    private String notes;
    @Size(max = 100)
    @Column(name = "INTERVIEWER")
    private String interviewer;
    @Size(max = 50)
    @Column(name = "LANGUAGE")
    private String language;
    @Size(max = 100)
    @Column(name = "TRANSLATOR")
    private String translator;
    @Column(name = "STATUS")
    private Integer status;
    @JoinColumn(name = "INTERVIEW_STATUS_ID", referencedColumnName = "ID")
    @ManyToOne
    private InterviewStatus interviewStatus;
    @Column(name = "PREDICTED_INTERVIEW_DATE")
    @Temporal(TemporalType.DATE)
    private Date predictedInteviewDate;
    

    public Interview() {
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.gov.mb.asylum.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "INTERVIEW_QUESTION", schema="ASYLUM")
@Getter @Setter
public class InterviewQuestion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interview_answer_seq")
    @SequenceGenerator(sequenceName = "ASYLUM.INTERVIEW_ANSWER_SEQ", allocationSize = 1, name = "interview_answer_seq")
    @Column(name = "ID")
    private Integer id;
    @Size(max = 200)
    @Column(name = "QUESTION")
    private String question;
    @Size(max = 200)
    @Column(name = "ANSWER")
    private String answer;
    @Column(name = "STATUS")
    private Integer status;
    @JoinColumn(name = "INTERVIEW_ID", referencedColumnName = "ID")
    @ManyToOne
    private Interview interview;

    public InterviewQuestion() {
    }

    
    
}

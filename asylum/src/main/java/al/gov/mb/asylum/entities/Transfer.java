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

import al.gov.mb.asylum.entities.tims.Organization;
import al.gov.mb.asylum.entities.tims.Selection;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "TRANSFER", schema="ASYLUM")
@Getter @Setter
public class Transfer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transfer_seq")
    @SequenceGenerator(sequenceName = "ASYLUM.TRANSFER_SEQ", allocationSize = 1, name = "transfer_seq")
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")
    @ManyToOne
    private Selection selection;
    @JoinColumn(name = "FROM_ORG_ID", referencedColumnName = "ID")
    @ManyToOne
    private Organization fromOrganization;
    @JoinColumn(name = "TO_ORG_ID", referencedColumnName = "ID")
    @ManyToOne
    private Organization toOrganization;
    @Column(name = "CHECK_OUT_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutTime;
    @Size(max = 100)
    @Column(name = "CHECK_OUT_USER")
    private String checkOutUser;
    @Size(max = 500)
    @Column(name = "CHECK_OUT_NOTES")
    private String checkOutNotes;
    @Column(name = "CHECK_IN_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInTime;
    @Size(max = 100)
    @Column(name = "CHECK_IN_USER")
    private String checkInUser;
    @Size(max = 500)
    @Column(name = "CHECK_IN_NOTES")
    private String checkInNotes;
    @Column(name = "STATUS")
    private Integer status;
    @JoinColumn(name = "TRANSFER_STATUS_ID", referencedColumnName = "ID")
    @ManyToOne
    private TransferStatus transferStatus;

    public Transfer() {
    }

   
    
}

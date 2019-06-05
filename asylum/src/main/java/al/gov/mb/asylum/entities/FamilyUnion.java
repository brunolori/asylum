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
@Table(name = "FAMILY_UNION", schema="ASYLUM")
@Getter @Setter
public class FamilyUnion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "family_union_seq")
    @SequenceGenerator(sequenceName = "ASYLUM.FAMILY_UNION_SEQ", allocationSize = 1, name = "family_union_seq")
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")
    @ManyToOne
    private Selection selection;
    @Column(name = "PROCESS_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date processTime;
    @Size(max = 100)
    @Column(name = "PROCESS_USER")
    private String processUser;
    @Size(max = 500)
    @Column(name = "NOTES")
    private String notes;
    @Column(name = "FAMILY_ID")
    private Integer familyId;
    @Column(name = "STATUS")
    private Integer status;
    @JoinColumn(name = "FAMILY_STATUS_ID", referencedColumnName = "ID")
    @ManyToOne
    private FamilyUnionStatus familyStatus;

    public FamilyUnion() {
    }

   
}

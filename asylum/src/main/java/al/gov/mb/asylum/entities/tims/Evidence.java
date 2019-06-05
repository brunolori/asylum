/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.gov.mb.asylum.entities.tims;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "IR_EVIDENCE", schema="FER")
@Getter @Setter
public class Evidence implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvidencePK idPK;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "RECORD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;
    @Size(max = 100)
    @Column(name = "MODIF_USER")
    private String modifUser;
    @Size(max = 100)
    @Column(name = "RECORD_USER")
    private String recordUser;
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private IrregularEvent event;

    public Evidence() {
    }

    
}

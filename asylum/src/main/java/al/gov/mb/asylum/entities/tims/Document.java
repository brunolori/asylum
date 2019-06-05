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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "IR_DOCUMENT", schema="FER")
@Getter @Setter
public class Document implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private DocumentPK idPK;           
    @Column(name = "DATE_OF_ISSUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfIssue;
    @Column(name = "DATE_OF_EXPIRATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfExpiration;
    @Column(name = "DATE_OF_EXTENSION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfExtension;
    @Column(name = "RECORD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;
    @Size(max = 100)
    @Column(name = "MODIF_USER")
    private String modifUser;
    @Size(max = 100)
    @Column(name = "RECORD_USER")
    private String recordUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IR_PERSON_ID")
    private Integer personId;

    public Document() {
    }

   
    
}

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
import javax.persistence.JoinColumns;
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
@Table(name = "TRAVEL_DOCUMENT", schema="REGMIN")
@Getter @Setter
public class TravelDocument implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TravelDocumentPK idPK;
    
    @Size(max = 15)
    @Column(name = "PERSONAL_NO")
    private String personalNo;
    @Column(name = "DATE_OF_ISSUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfIssue;
    @Column(name = "DATE_OF_EXPIRATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfExpiration;
    @Column(name = "DATE_OF_EXTENSION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfExtension;
    @JoinColumn(name = "CODE_TYPE_TRAVEL_DOC", referencedColumnName = "CODE_DOC_TYPE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DocType docType;
    @JoinColumns({
        @JoinColumn(name = "CODE_O_S", referencedColumnName = "CODE_O_S"),
        @JoinColumn(name = "PERSON_ID", referencedColumnName = "PERSON_ID")})
    @ManyToOne
    private PersonsInstitutions personsInstitutions;
    
    

    public TravelDocument() {
    }

   
   

}

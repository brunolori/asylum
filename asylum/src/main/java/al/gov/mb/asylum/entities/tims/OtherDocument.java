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
@Table(name = "IR_OTHER_DOCUMENT", schema="FER")
@Getter @Setter
public class OtherDocument implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OtherDocumentPK idPK;
    @Size(max = 20)
    @Column(name = "DOCUMENT_NO")
    private String documentNo;
    @Size(max = 255)
    @Column(name = "STATE")
    private String state;
    @Size(max = 100)
    @Column(name = "DOC_TYPE")
    private String docType;
    @Size(max = 100)
    @Column(name = "RECORD_USER")
    private String recordUser;
    @Size(max = 100)
    @Column(name = "MODIF_USER")
    private String modifUser;
    @Column(name = "RECORD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;

    public OtherDocument() {
    }

    
}

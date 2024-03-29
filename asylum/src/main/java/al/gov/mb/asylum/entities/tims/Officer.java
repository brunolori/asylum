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
@Table(name = "IR_OFFICER", schema="FER")
@Getter @Setter
public class Officer implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OfficerPK idPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SURNAME")
    private String surname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "GRADE")
    private String grade;
    @Size(max = 150)
    @Column(name = "ORGANIZATION")
    private String organization;
    @Column(name = "RECORD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;
    @Size(max = 100)
    @Column(name = "MODIF_USER")
    private String modifUser;
    @Size(max = 100)
    @Column(name = "RECORD_USER")
    private String recordUser;


    public Officer() {
    }

    
    
}

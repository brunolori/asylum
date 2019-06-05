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
@Table(name = "PERSONS_INSTITUTIONS", schema= "REGMIN")
@Getter @Setter
public class PersonsInstitutions implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonsInstitutionsPK idPK;
    @Size(max = 15)
    @Column(name = "ID_NO")
    private String nid;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 50)
    @Column(name = "SURNAME")
    private String surname;
    @Size(max = 30)
    @Column(name = "MAIDEN_NAME")
    private String maidenName;
    @Size(max = 30)
    @Column(name = "FATHER_NAME")
    private String fatherName;
    @Size(max = 30)
    @Column(name = "FATHER_FAMILY_NAME")
    private String pob;
    @Size(max = 30)
    @Column(name = "MOTHER_NAME")
    private String motherName;
    @Column(name = "DATE_OF_BIRTH")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "GENDER")
    private Character gender;
    @Size(max = 2)
    @Column(name = "CODE_STATE_BIRTH")
    private String codeStateBirth;
    @Size(max = 4)
    @Column(name = "CODE_CITY_BIRTH")
    private String codeCityBirth;
    @JoinColumn(name = "CODE_NATIONALITY", referencedColumnName = "CODE_STATE")
    @ManyToOne
    private State nationality;

    public PersonsInstitutions() {
    }

    public PersonsInstitutions(PersonsInstitutionsPK personsInstitutionsPK) {
        this.idPK = personsInstitutionsPK;
    }

    
    
}

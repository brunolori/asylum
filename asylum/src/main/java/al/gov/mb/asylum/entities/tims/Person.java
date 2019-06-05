/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.gov.mb.asylum.entities.tims;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@Table(name = "IR_PERSON", schema="FER")
@Getter @Setter
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IR_PERSON_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(sequenceName = "FER.SEQ_IR_PERSON", allocationSize = 1, name = "person_seq")
    private Integer id;
    @Size(max = 15)
    @Column(name = "CODE_O_S")
    private String codeOS;
    @Column(name = "PERSON_ID")
    private BigInteger personTimsId;
    @Size(max = 30)
    @Column(name = "ID_NO")
    private String nid;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 50)
    @Column(name = "MIDLE_NAME")
    private String midleName;
    @Size(max = 50)
    @Column(name = "SURNAME")
    private String surname;
    @Size(max = 50)
    @Column(name = "NAME_1")
    private String name1;
    @Size(max = 50)
    @Column(name = "SURNAME_1")
    private String surname1;
    @Size(max = 50)
    @Column(name = "FATHER_NAME")
    private String fatherName;
    @Size(max = 50)
    @Column(name = "MOTHER_NAME")
    private String motherName;
    @Column(name = "DATE_OF_BIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Size(max = 30)
    @Column(name = "DATE_OF_BIRTH_TEXT")
    private String dobText;
    @Column(name = "GENDER")
    private Character gender;
    @Column(name = "CODE_CIVIL_STATUS")
    private Character codeCivilStatus;
    @Size(max = 2)
    @Column(name = "CODE_NATIONALITY")
    private String codeNationality;
    @Size(max = 2)
    @Column(name = "CODE_STATE_BIRTH")
    private String codeStateBirth;
    @Size(max = 4)
    @Column(name = "CODE_CITY_BIRTH")
    private String codeCityBirth;
    @Column(name = "RECORD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;
    @Size(max = 100)
    @Column(name = "MODIF_USER")
    private String modifUser;
    @Size(max = 100)
    @Column(name = "RECORD_USER")
    private String recordUser;
    @Size(max = 100)
    @Column(name = "PROFESION")
    private String profesion;
    @Size(max = 100)
    @Column(name = "RELIGION")
    private String religion;


    public Person() {
    }

}

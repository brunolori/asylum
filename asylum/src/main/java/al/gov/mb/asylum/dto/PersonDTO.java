package al.gov.mb.asylum.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class PersonDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String codeOS;
    private BigInteger personTimsId;
    private String nid;
    private String name;
    private String midleName;
    private String surname;
    private String name1;
    private String surname1;
    private String fatherName;
    private String motherName;
    private Date dob;
    private String dobText;
    private Character gender;
    private Character codeCivilStatus;
    private String codeNationality;
    private String codeStateBirth;
    private String codeCityBirth;
    private Date recordDate;
    private String modifUser;
    private String recordUser;
    private String profesion;
    private String religion;
	
	

}

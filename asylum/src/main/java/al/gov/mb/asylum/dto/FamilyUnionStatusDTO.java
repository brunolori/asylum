package al.gov.mb.asylum.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class FamilyUnionStatusDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String tag;
    private String tagEn;
    private boolean status;
    
    
}
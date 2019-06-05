/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.gov.mb.asylum.entities.tims;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "IR_DECISION_TYPE", schema="FER")
@Getter @Setter
public class DecisionType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "DECISION_TYPE_ID")
    private String id;
    @Size(max = 100)
    @Column(name = "TAG")
    private String tag;
    @Size(max = 100)
    @Column(name = "TAG_ENG")
    private String tagEng;
    @Column(name = "STATUS")
    private Character status;
    
    public DecisionType() {
    }

   
}

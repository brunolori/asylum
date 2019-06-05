/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.gov.mb.asylum.entities.tims;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "IR_DECISION_REASONS", schema="FER")
@Getter @Setter
public class DecisionReason implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DecisionReasonPK idPK;
    @Size(max = 200)
    @Column(name = "TAG")
    private String tag;
    @Size(max = 200)
    @Column(name = "TAG_ENG")
    private String tagEng;    
    @Column(name = "STATUS")
    private Character status;
    @JoinColumn(name = "IR_TYPE_ORDER", referencedColumnName = "DECISION_TYPE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DecisionType decisionType;
    

    public DecisionReason() {
    }

   
    
}

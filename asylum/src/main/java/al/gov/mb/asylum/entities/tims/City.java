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
@Table(name = "CITIES", schema="REGMIN")
@Getter @Setter
public class City implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CityPK idPK;
    @Size(max = 50)
    @Column(name = "TAG")
    private String tag;
    @JoinColumn(name = "CODE_STATE", referencedColumnName = "CODE_STATE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private State state;
    

    public City() {
    }

    
}

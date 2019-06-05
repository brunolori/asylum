/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.gov.mb.asylum.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import al.gov.mb.asylum.entities.tims.Organization;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "USERS", schema="ASYLUM")
@Getter @Setter
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 20)
    @Column(name = "SECRET")
    private String secret;
    @Size(max = 50)
    @Column(name = "SURNAME")
    private String surname;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 5)
    @Column(name = "ROLE")
    private String role;
    @JoinColumn(name = "ORGANIZATION_ID", referencedColumnName = "ID")
    @ManyToOne
    private Organization organization;
    @Size(max = 100)
    @Column(name = "CREATE_USER")
    private String createUser;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Size(max = 100)
    @Column(name = "UPDATE_USER")
    private String updateUser;
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Column(name = "STATUS")
    private Integer status;

    public User() {
    }

   
    
}

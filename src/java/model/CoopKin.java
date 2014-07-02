/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_kin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopKin.findAll", query = "SELECT c FROM CoopKin c"),
    @NamedQuery(name = "CoopKin.findByRelativeNum", query = "SELECT c FROM CoopKin c WHERE c.relativeNum = :relativeNum"),
    @NamedQuery(name = "CoopKin.findByLastName", query = "SELECT c FROM CoopKin c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "CoopKin.findByFirstName", query = "SELECT c FROM CoopKin c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "CoopKin.findByMiddleName", query = "SELECT c FROM CoopKin c WHERE c.middleName = :middleName"),
    @NamedQuery(name = "CoopKin.findByBirthdate", query = "SELECT c FROM CoopKin c WHERE c.birthdate = :birthdate")})
public class CoopKin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "relative_num")
    private Integer relativeNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 20)
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @OneToMany(mappedBy = "relativeNum")
    private Collection<CoopKinship> coopKinshipCollection;
    @JoinColumn(name = "mem_no", referencedColumnName = "mem_no")
    @ManyToOne
    private CoopMember memNo;

    public CoopKin() {
    }

    public CoopKin(Integer relativeNum) {
        this.relativeNum = relativeNum;
    }

    public CoopKin(Integer relativeNum, String lastName, String firstName) {
        this.relativeNum = relativeNum;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Integer getRelativeNum() {
        return relativeNum;
    }

    public void setRelativeNum(Integer relativeNum) {
        this.relativeNum = relativeNum;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @XmlTransient
    public Collection<CoopKinship> getCoopKinshipCollection() {
        return coopKinshipCollection;
    }

    public void setCoopKinshipCollection(Collection<CoopKinship> coopKinshipCollection) {
        this.coopKinshipCollection = coopKinshipCollection;
    }

    public CoopMember getMemNo() {
        return memNo;
    }

    public void setMemNo(CoopMember memNo) {
        this.memNo = memNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relativeNum != null ? relativeNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopKin)) {
            return false;
        }
        CoopKin other = (CoopKin) object;
        if ((this.relativeNum == null && other.relativeNum != null) || (this.relativeNum != null && !this.relativeNum.equals(other.relativeNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopKin[ relativeNum=" + relativeNum + " ]";
    }
    
}

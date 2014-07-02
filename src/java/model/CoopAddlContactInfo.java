/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_addl_contact_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopAddlContactInfo.findAll", query = "SELECT c FROM CoopAddlContactInfo c"),
    @NamedQuery(name = "CoopAddlContactInfo.findByContactInfoNum", query = "SELECT c FROM CoopAddlContactInfo c WHERE c.contactInfoNum = :contactInfoNum"),
    @NamedQuery(name = "CoopAddlContactInfo.findByContactType", query = "SELECT c FROM CoopAddlContactInfo c WHERE c.contactType = :contactType"),
    @NamedQuery(name = "CoopAddlContactInfo.findByContactDetail", query = "SELECT c FROM CoopAddlContactInfo c WHERE c.contactDetail = :contactDetail")})
public class CoopAddlContactInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contact_info_num")
    private Integer contactInfoNum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contact_type")
    private char contactType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "contact_detail")
    private String contactDetail;
    @JoinColumn(name = "mem_no", referencedColumnName = "mem_no")
    @ManyToOne
    private CoopMember memNo;

    public CoopAddlContactInfo() {
    }

    public CoopAddlContactInfo(Integer contactInfoNum) {
        this.contactInfoNum = contactInfoNum;
    }

    public CoopAddlContactInfo(Integer contactInfoNum, char contactType, String contactDetail) {
        this.contactInfoNum = contactInfoNum;
        this.contactType = contactType;
        this.contactDetail = contactDetail;
    }

    public Integer getContactInfoNum() {
        return contactInfoNum;
    }

    public void setContactInfoNum(Integer contactInfoNum) {
        this.contactInfoNum = contactInfoNum;
    }

    public char getContactType() {
        return contactType;
    }

    public void setContactType(char contactType) {
        this.contactType = contactType;
    }

    public String getContactDetail() {
        return contactDetail;
    }

    public void setContactDetail(String contactDetail) {
        this.contactDetail = contactDetail;
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
        hash += (contactInfoNum != null ? contactInfoNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopAddlContactInfo)) {
            return false;
        }
        CoopAddlContactInfo other = (CoopAddlContactInfo) object;
        if ((this.contactInfoNum == null && other.contactInfoNum != null) || (this.contactInfoNum != null && !this.contactInfoNum.equals(other.contactInfoNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopAddlContactInfo[ contactInfoNum=" + contactInfoNum + " ]";
    }
    
}

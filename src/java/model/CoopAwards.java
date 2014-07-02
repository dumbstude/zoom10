/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_awards")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopAwards.findAll", query = "SELECT c FROM CoopAwards c"),
    @NamedQuery(name = "CoopAwards.findByAccAwdNum", query = "SELECT c FROM CoopAwards c WHERE c.accAwdNum = :accAwdNum"),
    @NamedQuery(name = "CoopAwards.findByAwardTitle", query = "SELECT c FROM CoopAwards c WHERE c.awardTitle = :awardTitle"),
    @NamedQuery(name = "CoopAwards.findByAwardDetails", query = "SELECT c FROM CoopAwards c WHERE c.awardDetails = :awardDetails"),
    @NamedQuery(name = "CoopAwards.findByAccAwdDate", query = "SELECT c FROM CoopAwards c WHERE c.accAwdDate = :accAwdDate")})
public class CoopAwards implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "acc_awd_num")
    private Integer accAwdNum;
    @Size(max = 35)
    @Column(name = "award_title")
    private String awardTitle;
    @Size(max = 2147483647)
    @Column(name = "award_details")
    private String awardDetails;
    @Column(name = "acc_awd_date")
    @Temporal(TemporalType.DATE)
    private Date accAwdDate;
    @JoinColumn(name = "mem_no", referencedColumnName = "mem_no")
    @ManyToOne
    private CoopMember memNo;

    public CoopAwards() {
    }

    public CoopAwards(Integer accAwdNum) {
        this.accAwdNum = accAwdNum;
    }

    public Integer getAccAwdNum() {
        return accAwdNum;
    }

    public void setAccAwdNum(Integer accAwdNum) {
        this.accAwdNum = accAwdNum;
    }

    public String getAwardTitle() {
        return awardTitle;
    }

    public void setAwardTitle(String awardTitle) {
        this.awardTitle = awardTitle;
    }

    public String getAwardDetails() {
        return awardDetails;
    }

    public void setAwardDetails(String awardDetails) {
        this.awardDetails = awardDetails;
    }

    public Date getAccAwdDate() {
        return accAwdDate;
    }

    public void setAccAwdDate(Date accAwdDate) {
        this.accAwdDate = accAwdDate;
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
        hash += (accAwdNum != null ? accAwdNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopAwards)) {
            return false;
        }
        CoopAwards other = (CoopAwards) object;
        if ((this.accAwdNum == null && other.accAwdNum != null) || (this.accAwdNum != null && !this.accAwdNum.equals(other.accAwdNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopAwards[ accAwdNum=" + accAwdNum + " ]";
    }
    
}

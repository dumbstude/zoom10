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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_biz_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopBizInfo.findAll", query = "SELECT c FROM CoopBizInfo c"),
    @NamedQuery(name = "CoopBizInfo.findByBizInfoNum", query = "SELECT c FROM CoopBizInfo c WHERE c.bizInfoNum = :bizInfoNum"),
    @NamedQuery(name = "CoopBizInfo.findByBizType", query = "SELECT c FROM CoopBizInfo c WHERE c.bizType = :bizType"),
    @NamedQuery(name = "CoopBizInfo.findByBizIncRange", query = "SELECT c FROM CoopBizInfo c WHERE c.bizIncRange = :bizIncRange"),
    @NamedQuery(name = "CoopBizInfo.findByBizNature", query = "SELECT c FROM CoopBizInfo c WHERE c.bizNature = :bizNature"),
    @NamedQuery(name = "CoopBizInfo.findByBizName", query = "SELECT c FROM CoopBizInfo c WHERE c.bizName = :bizName"),
    @NamedQuery(name = "CoopBizInfo.findByDateEstablished", query = "SELECT c FROM CoopBizInfo c WHERE c.dateEstablished = :dateEstablished")})
public class CoopBizInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "biz_info_num")
    private Integer bizInfoNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "biz_type")
    private String bizType;
    @Size(max = 25)
    @Column(name = "biz_inc_range")
    private String bizIncRange;
    @Size(max = 20)
    @Column(name = "biz_nature")
    private String bizNature;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "biz_name")
    private String bizName;
    @Column(name = "date_established")
    @Temporal(TemporalType.DATE)
    private Date dateEstablished;
    @JoinColumn(name = "mem_no", referencedColumnName = "mem_no")
    @ManyToOne
    private CoopMember memNo;

    public CoopBizInfo() {
    }

    public CoopBizInfo(Integer bizInfoNum) {
        this.bizInfoNum = bizInfoNum;
    }

    public CoopBizInfo(Integer bizInfoNum, String bizType, String bizName) {
        this.bizInfoNum = bizInfoNum;
        this.bizType = bizType;
        this.bizName = bizName;
    }

    public Integer getBizInfoNum() {
        return bizInfoNum;
    }

    public void setBizInfoNum(Integer bizInfoNum) {
        this.bizInfoNum = bizInfoNum;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizIncRange() {
        return bizIncRange;
    }

    public void setBizIncRange(String bizIncRange) {
        this.bizIncRange = bizIncRange;
    }

    public String getBizNature() {
        return bizNature;
    }

    public void setBizNature(String bizNature) {
        this.bizNature = bizNature;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public Date getDateEstablished() {
        return dateEstablished;
    }

    public void setDateEstablished(Date dateEstablished) {
        this.dateEstablished = dateEstablished;
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
        hash += (bizInfoNum != null ? bizInfoNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopBizInfo)) {
            return false;
        }
        CoopBizInfo other = (CoopBizInfo) object;
        if ((this.bizInfoNum == null && other.bizInfoNum != null) || (this.bizInfoNum != null && !this.bizInfoNum.equals(other.bizInfoNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopBizInfo[ bizInfoNum=" + bizInfoNum + " ]";
    }
    
}

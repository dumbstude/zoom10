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
@Table(name = "coop_kinship")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopKinship.findAll", query = "SELECT c FROM CoopKinship c"),
    @NamedQuery(name = "CoopKinship.findByKinshipNum", query = "SELECT c FROM CoopKinship c WHERE c.kinshipNum = :kinshipNum"),
    @NamedQuery(name = "CoopKinship.findByRelatedAs", query = "SELECT c FROM CoopKinship c WHERE c.relatedAs = :relatedAs")})
public class CoopKinship implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kinship_num")
    private Integer kinshipNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "related_as")
    private String relatedAs;
    @JoinColumn(name = "mem_no", referencedColumnName = "mem_no")
    @ManyToOne
    private CoopMember memNo;
    @JoinColumn(name = "relative_num", referencedColumnName = "relative_num")
    @ManyToOne
    private CoopKin relativeNum;

    public CoopKinship() {
    }

    public CoopKinship(Integer kinshipNum) {
        this.kinshipNum = kinshipNum;
    }

    public CoopKinship(Integer kinshipNum, String relatedAs) {
        this.kinshipNum = kinshipNum;
        this.relatedAs = relatedAs;
    }

    public Integer getKinshipNum() {
        return kinshipNum;
    }

    public void setKinshipNum(Integer kinshipNum) {
        this.kinshipNum = kinshipNum;
    }

    public String getRelatedAs() {
        return relatedAs;
    }

    public void setRelatedAs(String relatedAs) {
        this.relatedAs = relatedAs;
    }

    public CoopMember getMemNo() {
        return memNo;
    }

    public void setMemNo(CoopMember memNo) {
        this.memNo = memNo;
    }

    public CoopKin getRelativeNum() {
        return relativeNum;
    }

    public void setRelativeNum(CoopKin relativeNum) {
        this.relativeNum = relativeNum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kinshipNum != null ? kinshipNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopKinship)) {
            return false;
        }
        CoopKinship other = (CoopKinship) object;
        if ((this.kinshipNum == null && other.kinshipNum != null) || (this.kinshipNum != null && !this.kinshipNum.equals(other.kinshipNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopKinship[ kinshipNum=" + kinshipNum + " ]";
    }
    
}

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
@Table(name = "coop_educ_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopEducInfo.findAll", query = "SELECT c FROM CoopEducInfo c"),
    @NamedQuery(name = "CoopEducInfo.findByEducInfoNum", query = "SELECT c FROM CoopEducInfo c WHERE c.educInfoNum = :educInfoNum"),
    @NamedQuery(name = "CoopEducInfo.findBySchoolName", query = "SELECT c FROM CoopEducInfo c WHERE c.schoolName = :schoolName"),
    @NamedQuery(name = "CoopEducInfo.findBySchoolLevel", query = "SELECT c FROM CoopEducInfo c WHERE c.schoolLevel = :schoolLevel"),
    @NamedQuery(name = "CoopEducInfo.findByCourse", query = "SELECT c FROM CoopEducInfo c WHERE c.course = :course"),
    @NamedQuery(name = "CoopEducInfo.findByGraduated", query = "SELECT c FROM CoopEducInfo c WHERE c.graduated = :graduated"),
    @NamedQuery(name = "CoopEducInfo.findByYearLastAttended", query = "SELECT c FROM CoopEducInfo c WHERE c.yearLastAttended = :yearLastAttended")})
public class CoopEducInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "educ_info_num")
    private Integer educInfoNum;
    @Size(max = 35)
    @Column(name = "school_name")
    private String schoolName;
    @Size(max = 15)
    @Column(name = "school_level")
    private String schoolLevel;
    @Size(max = 15)
    @Column(name = "course")
    private String course;
    @Column(name = "graduated")
    private Boolean graduated;
    @Column(name = "year_last_attended")
    @Temporal(TemporalType.DATE)
    private Date yearLastAttended;
    @JoinColumn(name = "mem_no", referencedColumnName = "mem_no")
    @ManyToOne
    private CoopMember memNo;

    public CoopEducInfo() {
    }

    public CoopEducInfo(Integer educInfoNum) {
        this.educInfoNum = educInfoNum;
    }

    public Integer getEducInfoNum() {
        return educInfoNum;
    }

    public void setEducInfoNum(Integer educInfoNum) {
        this.educInfoNum = educInfoNum;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolLevel() {
        return schoolLevel;
    }

    public void setSchoolLevel(String schoolLevel) {
        this.schoolLevel = schoolLevel;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Boolean getGraduated() {
        return graduated;
    }

    public void setGraduated(Boolean graduated) {
        this.graduated = graduated;
    }

    public Date getYearLastAttended() {
        return yearLastAttended;
    }

    public void setYearLastAttended(Date yearLastAttended) {
        this.yearLastAttended = yearLastAttended;
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
        hash += (educInfoNum != null ? educInfoNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopEducInfo)) {
            return false;
        }
        CoopEducInfo other = (CoopEducInfo) object;
        if ((this.educInfoNum == null && other.educInfoNum != null) || (this.educInfoNum != null && !this.educInfoNum.equals(other.educInfoNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopEducInfo[ educInfoNum=" + educInfoNum + " ]";
    }
    
}

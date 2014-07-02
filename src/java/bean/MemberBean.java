/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.CoopMember;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import service.CoopMemberFacadeREST;

/**
 *
 * @author roland
 */
@ManagedBean
@SessionScoped
public class MemberBean implements Serializable {

    @EJB
    private CoopMemberFacadeREST coopMemberFacadeREST;
    private CoopMember member;
    private List<CoopMember> memberList;
    private List<CoopMember> filteredMembers;
    private CoopMember selectedMember;
    private DataModel<CoopMember> memberModel;

    public void init() {
        member = new CoopMember();
        memberList = coopMemberFacadeREST.findAll();
        memberModel = new ListDataModel<>(memberList);
    }

    public void beanclear() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("memberBean", null);
    }
    @ManagedProperty(value = "#{applicantBean}")
    private ApplicantBean applicantBean;

    public ApplicantBean getApplicantBean() {
        return this.applicantBean;
    }

    public void setApplicantBean(ApplicantBean applicantBean) {
        this.applicantBean = applicantBean;
    }

    /**
     * Creates a new instance of ProspectBean
     */
    public MemberBean() {
        member = new CoopMember();
    }

    public DataModel<CoopMember> getMemberModel() {
        if (memberModel == null) {
            memberModel = new ListDataModel<>(memberList);
        }
        return memberModel;
    }

    public CoopMember getMember() {
        return member;
    }

    public void setMember(CoopMember member) {
        this.member = selectedMember;
    }

    public String save() {
        coopMemberFacadeREST.create(member);
        member = new CoopMember();
        return "addMember";
    }
    private boolean skip;

    public void addSave() {
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + member.getFirstName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public List<CoopMember> getMemberList() {
        memberList = coopMemberFacadeREST.findAll();
        return memberList;
    }

    public void setMemberList(List<CoopMember> memberList) {
        this.memberList = memberList;
    }

    public List<CoopMember> getFilteredMembers() {
        return filteredMembers;
    }

    public void setFilteredMembers(List<CoopMember> filteredMembers) {
        this.filteredMembers = filteredMembers;
    }

    public void setSelectedMember(CoopMember selectedMember) {
        this.selectedMember = selectedMember;
    }

    public CoopMember getSelectedMember() {
        if (selectedMember == null) {
            selectedMember = new CoopMember();
        }
        return selectedMember;
    }

    public void onRowSelect(SelectEvent event) {
    }

    public String saveEdit() {
        coopMemberFacadeREST.edit(member);
        member = new CoopMember();
        beanclear();
        return "viewMember";
    }
}
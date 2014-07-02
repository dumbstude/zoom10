/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.CoopApplicant;
import org.primefaces.event.SelectEvent;
import service.CoopApplicantFacadeREST;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author roland
 */
@ManagedBean (name="applicantBean")
@SessionScoped
public class ApplicantBean implements Serializable {

    @EJB
    private CoopApplicantFacadeREST coopApplicantFacadeREST;
    private CoopApplicant applicant;
    private List<CoopApplicant> applicantList;
    private List<CoopApplicant> filteredApplicants;
    private CoopApplicant selectedApplicant;
    private DataModel<CoopApplicant> applicantModel;

    public void init() {
        applicant = new CoopApplicant();
        applicantList = coopApplicantFacadeREST.findAll();
        applicantModel = new ListDataModel<>(applicantList);
    }


    public void beanclear() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("applicantBean", null);
    }

    /**
     * Creates a new instance of ApplicantBean
     */
    public ApplicantBean() {
        applicant = new CoopApplicant();
    }

    public DataModel<CoopApplicant> getApplicantModel() {
        if (applicantModel == null) {
            applicantModel = new ListDataModel<>(applicantList);
        }
        return applicantModel;
    }

    public CoopApplicant getApplicant() {
        return applicant;
    }

    public void setApplicant(CoopApplicant applicant) {
        this.applicant = selectedApplicant;
    }

    public String save() {
        coopApplicantFacadeREST.create(applicant);
        applicant = new CoopApplicant();
        return "addApplicant";
    }

    public List<CoopApplicant> getApplicantList() {
        applicantList = coopApplicantFacadeREST.findAll();
        return applicantList;
    }

    public void setApplicantList(List<CoopApplicant> applicantList) {
        this.applicantList = applicantList;
    }

          public List<CoopApplicant> getFilteredApplicants() {  
        return filteredApplicants;  
    }  
  
    public void setFilteredApplicants(List<CoopApplicant> filteredApplicants) {  
        this.filteredApplicants = filteredApplicants;  
    }  

    public void setSelectedApplicant(CoopApplicant selectedApplicant) {
        this.selectedApplicant = selectedApplicant;
    }

    
    public CoopApplicant getSelectedApplicant() {
        if (selectedApplicant == null) {
            selectedApplicant = new CoopApplicant();
        }
        return selectedApplicant;
    }

    public void onRowSelect(SelectEvent event) {
    }

    public String saveEdit() {
        coopApplicantFacadeREST.edit(applicant);
        applicant = new CoopApplicant();
        beanclear();
        return "viewApplicant";
    }

    public String deleteApplicant() {
        coopApplicantFacadeREST.remove(applicant);
        applicant = new CoopApplicant();
        beanclear();
        return "viewApplicant";
    }
}

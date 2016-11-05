/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vetement;

import Couleurs.CouleursDAO;
import Types.TypesDAO;
import java.io.Serializable;
import java.util.List;
import javafx.scene.control.TableColumn.CellEditEvent;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author sabat
 */
@Named(value = "vetementController")
@ViewScoped
public class VetementController implements Serializable {
    @EJB
    private CouleursDAO couleursDAO;
    
    @EJB
    private TypesDAO typesDAO;
    
    @EJB
    private VetementDAO vetementDAO;

    private int id;

    private Vetement saisie;

    public VetementController() {
        saisie = new Vetement();
    }

    public List<Vetement> getVetements() {
        return vetementDAO.getAllVetements();
    }
    
    public List<String> getTypes() {
        return typesDAO.getAllTypes();
    }
    
    public List<String> getCouleurs() {
        return couleursDAO.getAllCouleurs();
    }

    public Vetement getSaisie() {
        return saisie;
    }

    public void setSaisie(Vetement saisie) {
        this.saisie = saisie;
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Vetement modifié : ", ((Vetement) event.getObject()).getRefVet().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Modification annulée", ((Vetement) event.getObject()).getRefVet().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}

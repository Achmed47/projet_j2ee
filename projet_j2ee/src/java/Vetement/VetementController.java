/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vetement;

import Couleurs.Couleurs;
import Couleurs.CouleursDAO;
import Types.Types;
import Types.TypesDAO;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author sabat
 */
@Named(value = "vetementController")
@SessionScoped
public class VetementController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private CouleursDAO couleursDAO;
    
    @EJB
    private TypesDAO typesDAO;
    
    @EJB
    private VetementDAO vetementDAO;
    
    private List<Vetement> allVetements;
    private List<Types> typesList;
    private List<Couleurs> couleursList;
    
    private Vetement newVetement;

    public VetementController() {
    }
    
    @PostConstruct
    public void init() {
        newVetement  = new Vetement();
        allVetements = vetementDAO.getAllVetements();
        typesList    = typesDAO.getAllTypes();
        couleursList = couleursDAO.getAllCouleurs();
    }

    public List<Vetement> getVetements() {
        return allVetements;
    }
    
    public List<Types> getTypes() {
        return typesList;
    }
    
    public List<Couleurs> getCouleurs() {
        return couleursList;
    }

    public Vetement getNewVetement() {
        return newVetement;
    }

    public void setNewVetement(Vetement saisie) {
        this.newVetement = saisie;
    }

    public void onRowEdit(RowEditEvent event) {
        Vetement v = (Vetement) event.getObject();
        vetementDAO.saveVetement(v);
    }

    public void onRowCancel(RowEditEvent event) {
        
    }
    
    public void deleteVetement(Vetement vetement) {
        System.out.println(vetement);
        if(vetement != null && vetement.getRefVet() != null) {
            for (Iterator<Vetement> it = allVetements.iterator(); it.hasNext();) {
                Vetement v = it.next();
                if(Objects.equals(v.getRefVet(), vetement.getRefVet())) {
                    vetementDAO.deleteVetement(vetement);
                    it.remove();
                   
                }
            }
        }
    }
    
    public void addVetement(ActionEvent e) {
        System.out.println("Vetement a ajouter : " + newVetement);
        if(newVetement != null && newVetement.getRefVet() != null 
                && newVetement.getCouleur() != null && newVetement.getType() != null
                && newVetement.getPrixV() >= 0 && newVetement.getUrlV().length() > 0) {
            System.out.println("Prêt à être ajouté");
            vetementDAO.saveVetement(newVetement);
            allVetements.add(newVetement);
            RequestContext.getCurrentInstance().execute("PF('addVetementDialog').hide()");
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("tableVetements");
            RequestContext.getCurrentInstance().update("form:addVetementDialog");
            newVetement = new Vetement();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Couleurs;

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
@Named(value = "couleursController")
@SessionScoped
public class CouleursController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private CouleursDAO couleursDAO;
    
    private List<Couleurs> allCouleurs;
    private Couleurs newCouleur;

    public CouleursController() {
    }
    
    @PostConstruct
    public void init() {
        newCouleur = new Couleurs();
        allCouleurs = couleursDAO.getAllCouleurs();
    }
    
    public List<Couleurs> getCouleurs() {
        return allCouleurs;
    }
    
    public Couleurs getNewCouleur() {
        return this.newCouleur;
    }

    public void setNewCouleur(Couleurs couleur) {
        this.newCouleur = couleur;
    }
    
    public void onRowEdit(RowEditEvent event) {
        Couleurs c = (Couleurs) event.getObject();
        if(!contains(c.getCouleur())) {
            couleursDAO.saveCouleur(c);
        }
    }

    public void onRowCancel(RowEditEvent event) {
        
    }
    
    public void deleteCouleur(Couleurs couleur) {
        if(couleur != null && couleur.getCouleur()!= null) {
            for (Iterator<Couleurs> it = allCouleurs.iterator(); it.hasNext();) {
                Couleurs c = it.next();
                if(Objects.equals(c.getCouleur(), couleur.getCouleur())) {
                    couleursDAO.deleteCouleur(couleur);
                    it.remove();
                }
            }
        }
    }
    
    public void addCouleur(ActionEvent e) {
        if(newCouleur != null && newCouleur.getCouleur()!= null && !contains(newCouleur.getCouleur())) {
            couleursDAO.saveCouleur(newCouleur);
            allCouleurs.add(newCouleur);
            RequestContext.getCurrentInstance().execute("PF('addCouleurDialog').hide()");
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("tableCouleurs");
            RequestContext.getCurrentInstance().update("formCouleurs:addCouleurDialog");
            newCouleur = new Couleurs();
        }
    }
        
    private boolean contains(String couleur) {
        return (allCouleurs.stream().anyMatch((c) -> (c.getCouleur().equals(couleur))));
    }
}

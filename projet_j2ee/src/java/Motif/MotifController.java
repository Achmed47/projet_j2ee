/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motif;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
@Named(value = "motifController")
@SessionScoped
public class MotifController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private MotifDAO motifDAO;
    
    private List<Motif> allMotifs;
    private Motif newMotif;
    private Motif selectedMotif;
    
    /**
     * Creates a new instance of MotifController
     */
    public MotifController() {
    }
    
    @PostConstruct
    public void init() {
        allMotifs = motifDAO.getAllMotifs();
        newMotif = new Motif();
        selectedMotif = new Motif();
    }

    public List<Motif> getMotifs() {
        return allMotifs;
    }

    public void setMotifs(List<Motif> allMotifs) {
        this.allMotifs = allMotifs;
    }

    public Motif getNewMotif() {
        return newMotif;
    }

    public void setNewMotif(Motif newMotif) {
        this.newMotif = newMotif;
    }
    
    public void onRowEdit(RowEditEvent event) {
        Motif m = (Motif) event.getObject();
        if(!contains(m.getUrlMotif())) { 
           motifDAO.saveMotif(m); 
       }
    }

    public void onRowCancel(RowEditEvent event) {
        
    }
    
    public void deleteMotif(Motif motif) {
        if(motif != null && motif.getIdMotif()!= null) {
            for (Iterator<Motif> it = allMotifs.iterator(); it.hasNext();) {
                Motif t = it.next();
                if(Objects.equals(t.getIdMotif(), motif.getIdMotif())) {
                    motifDAO.deleteMotif(motif);
                    it.remove();
                }
            }
        }
    }
    
    public void addMotif(ActionEvent e) {
        
        if(newMotif != null && !contains(newMotif.getUrlMotif())) {
            motifDAO.saveMotif(newMotif);
            allMotifs.add(newMotif);
            RequestContext.getCurrentInstance().execute("PF('addMotifDialog').hide()");
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("tableMotif");
            RequestContext.getCurrentInstance().update("formMotif:addMotifDialog");
            newMotif = new Motif();
        }
    }
        
    private boolean contains(String motifUrl) {
        return (allMotifs.stream().anyMatch((m) -> (m.getUrlMotif().equals(motifUrl))));
    }
    
    public int getNeededColumns() {
        return allMotifs.size() > 8 ? 3 : 2;
    }
    
    public Motif getSelectedMotif() {
        return this.selectedMotif;
    }
    
    public void resetSelectedMotif() {
        this.selectedMotif = new Motif();
    }
    
    public void setSelectedMotif(Motif m) {
        this.selectedMotif = m;
    }
}

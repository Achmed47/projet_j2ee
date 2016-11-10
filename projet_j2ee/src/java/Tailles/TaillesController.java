/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tailles;

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
@Named(value = "taillesController")
@SessionScoped
public class TaillesController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private TaillesDAO taillesDAO;

    private List<Tailles> allTailles;
    private Tailles newTaille;
    
    /**
     * Creates a new instance of TaillesController
     */
    public TaillesController() {
    }
    
    @PostConstruct
    public void init() {
        newTaille = new Tailles();
        allTailles = taillesDAO.getAllTailles();
    }

    public List<Tailles> getTailles() {
        return allTailles;
    }

    public void setTailles(List<Tailles> allTailles) {
        this.allTailles = allTailles;
    }

    public Tailles getNewTaille() {
        return newTaille;
    }

    public void setNewTaille(Tailles newTaille) {
        this.newTaille = newTaille;
    }
    
    public void onRowEdit(RowEditEvent event) {
        Tailles t = (Tailles) event.getObject();
        if(!contains(t.getTaille())) {
            taillesDAO.saveTaille(t);    
        }
    }

    public void onRowCancel(RowEditEvent event) {
        
    }
    
    public void deleteTaille(Tailles taille) {
        if(taille != null && taille.getTaille()!= null) {
            for (Iterator<Tailles> it = allTailles.iterator(); it.hasNext();) {
                Tailles t = it.next();
                if(Objects.equals(t.getTaille(), taille.getTaille())) {
                    taillesDAO.deleteTaille(taille);
                    it.remove();
                }
            }
        }
    }
    
    public void addTaille(ActionEvent e) {
        if(newTaille != null && newTaille.getTaille()!= null && !contains(newTaille.getTaille())) {
            taillesDAO.saveTaille(newTaille);
            allTailles.add(newTaille);
            RequestContext.getCurrentInstance().execute("PF('addTailleDialog').hide()");
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("tableTailles");
            RequestContext.getCurrentInstance().update("formTaille:addTailleDialog");
            newTaille = new Tailles();
        }
    }
        
    private boolean contains(String taille) {
        return (allTailles.stream().anyMatch((t) -> (t.getTaille().equals(taille))));
    }
}

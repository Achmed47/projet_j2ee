/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;

import Couleurs.CouleursDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sabat
 */
@Named(value = "venteController")
@SessionScoped
public class VenteController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private VenteDAO venteDAO;
    
    @EJB
    private CouleursDAO couleursDAO;

    private List<Vente> allVentes;
    private Vente currentVente;
    
    /**
     * Creates a new instance of VenteController
     */
    public VenteController() {
    }
    
    @PostConstruct
    public void init() {
        allVentes = venteDAO.getAllVentes();
        currentVente = new Vente(couleursDAO.getAllCouleurs().get(0));
    }
    
    public List<Vente> getVentes() {
        return allVentes;
    }

    public Vente getCurrentVente() {
        return currentVente;
    }

    public void setCurrentVente(Vente currentVente) {
        this.currentVente = currentVente;
    }
    
    public void updatePrixCurrentVente() {
        this.currentVente.setPrixV(currentVente.getQuantite()*(currentVente.getVet().getPrixV()+currentVente.getMotif().getPrixM()));
    }
    
    public boolean isMotifSet() {
        System.out.println("Printing vente's add button : " + (this.currentVente.getMotif() != null && this.currentVente.getMotif().getUrlMotif() != null));
        return !(this.currentVente.getMotif() != null && this.currentVente.getMotif().getUrlMotif() != null);
    }
    
    public void updatePrixVente(Vente v) {
        v.setPrixV(v.getQuantite()*(v.getVet().getPrixV()+v.getMotif().getPrixM()));
    }
}

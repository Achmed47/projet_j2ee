/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    private List<Vente> allVentes;
    private List<Vente> ventesFiltered;
    
    /**
     * Creates a new instance of VenteController
     */
    public VenteController() {
    }
    
    @PostConstruct
    public void init() {
        allVentes = venteDAO.getAllVentes();
        ventesFiltered = new ArrayList<>();
    }
    
    public List<Vente> getVentes() {
        return allVentes;
    }
    
    public List<Vente> getVentesByCommandeId(Integer commandeId) {
        ventesFiltered.clear();
        allVentes.stream().filter((v) -> (Objects.equals(v.getCommande().getIdCommande(), commandeId))).forEachOrdered((v) -> {
            ventesFiltered.add(v);
        });
        return ventesFiltered;
    }
    
    public float getPrixTotalByCommandeId(Integer commandeId) {
        if(ventesFiltered.isEmpty()) {
            return 0;
        } else {
            float prixTotal = 0;
            return ventesFiltered.stream().map((v) -> v.getPrix()).reduce(prixTotal, (accumulator, _item) -> accumulator + _item);
        }
    }
}

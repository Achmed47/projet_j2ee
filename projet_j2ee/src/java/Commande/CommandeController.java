/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande;

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
@Named(value = "commandeController")
@SessionScoped
public class CommandeController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private CommandeDAO commandeDAO;
    
    private List<Commande> allCommandes;
    
    /**
     * Creates a new instance of CommandeController
     */
    public CommandeController() {
    }
    
    @PostConstruct
    public void init() {
        allCommandes = commandeDAO.getAllCommandes();
    }
    
    public List<Commande> getCommandes() {
        return allCommandes;
    }
    
    public void updateCommandeStatut(Commande c) {
        if(c != null && c.getIdCommande() != null && c.getStatut() == 0) {
            c.setStatut((short) 1);
            commandeDAO.save(c);
        }
    }
}

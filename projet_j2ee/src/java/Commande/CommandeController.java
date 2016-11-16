/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande;

import Vente.Vente;
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
    private Commande currentCommande;

    /**
     * Creates a new instance of CommandeController
     */
    public CommandeController() {
    }

    @PostConstruct
    public void init() {
        currentCommande = new Commande();
        allCommandes = commandeDAO.getAllCommandes();
    }

    public List<Commande> getCommandes() {
        return allCommandes;
    }

    public void updateCommandeStatut(Commande c) {
        if (c != null && c.getIdCommande() != null && c.getStatut() == 0) {
            c.setStatut((short) 1);
            commandeDAO.save(c);
        }
    }

    public void addVente(Vente v) {
        currentCommande.getVenteList().add(v);
    }

    public Commande getCurrentCommande() {
        return currentCommande;
    }

    public void setCurrentCommande(Commande c) {
        this.currentCommande = c;
    }

    public void validatePanier() {
        System.out.println("Panier en validation.");
    }

    public float getPrixCurrentCommande() {
        float prixTotal = 0;

        if (currentCommande != null && currentCommande.getVenteList() != null && currentCommande.getVenteList().size() > 0) {
            for (Vente v : currentCommande.getVenteList()) {
                prixTotal += v.getPrixV();
            }
        }
        return prixTotal;
    }
}

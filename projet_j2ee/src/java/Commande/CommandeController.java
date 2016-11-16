/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande;

import Motif.Motif;
import Tailles.TaillesDAO;
import Vente.Vente;
import Vetement.Vetement;
import java.io.Serializable;
import java.util.ArrayList;
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
    
    @EJB
    private TaillesDAO tailleDAO;

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

    public void addVente(Vente v, Motif m, Vetement vet, String positionMotif) {
        Vente newVente = new Vente();
        
        newVente.setCouleur(v.getCouleur());
        newVente.setFaceVetement("avant".equals(positionMotif));
        newVente.setMotif(m);
        newVente.setVet(vet);
        newVente.setQuantite(1);
        newVente.setPositionMotif("avant".equals(positionMotif) ? (short) 0 : (short) 1);
        newVente.setPrixV((m != null) ? m.getPrixM() + vet.getPrixV() : vet.getPrixV());
        newVente.setTaille(tailleDAO.getTailleByValue("M"));
        newVente.setCommande(currentCommande);
        
        if(currentCommande.getVenteList() == null) {
            currentCommande.setVenteList(new ArrayList<>());
        }
        
        List<Vente> listeVente = currentCommande.getVenteList();
        listeVente.add(newVente);
    }

    public Commande getCurrentCommande() {
        return currentCommande;
    }

    public void setCurrentCommande(Commande c) {
        this.currentCommande = c;
    }

    public String validatePanier() {
        return "confirmation";
    }
    
    public void removeVente(Vente v) {
        if(currentCommande.getVenteList() != null && currentCommande.getVenteList().contains(v)) {
            currentCommande.getVenteList().remove(v);
        }
    }

    public float getPrixCurrentCommande() {
        float prixTotal = 0;
        if (currentCommande != null && currentCommande.getVenteList() != null && currentCommande.getVenteList().size() > 0) {
            prixTotal = currentCommande.getVenteList().stream().map((v) -> v.getPrixV()).reduce(prixTotal, (accumulator, _item) -> accumulator + _item);
        }
        return prixTotal;
    }
    
    public boolean isVentesEmpty() {
        return (currentCommande.getVenteList() == null || currentCommande.getVenteList().isEmpty());
    }
}

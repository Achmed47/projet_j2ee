/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande;

import Client.Client;
import Client.ClientDAO;
import Dates.Dates;
import Dates.DatesDAO;
import Motif.Motif;
import Tailles.TaillesDAO;
import Vente.Vente;
import Vente.VenteDAO;
import Vetement.Vetement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;
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
    
    @EJB
    private ClientDAO clientDAO;
    
    @EJB
    private VenteDAO venteDAO;
    
    @EJB
    private DatesDAO dateDAO;

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
    
    public List<Vente> getVentesByCommandeId(int idCommande) {
        for(Commande c : allCommandes) {
            if(idCommande == c.getIdCommande()) {
                return c.getVenteList();
            }
        }
        return new ArrayList<>();
    }

    public String validatePanier() {
        System.out.println("validatePanier");
        if(currentCommande != null && currentCommande.getVenteList() != null) {
            Client client = clientDAO.getFirstClient();
            currentCommande.setClient(client);
            currentCommande.setStatut((short) 0);
            currentCommande.setPrixC(getPrixCurrentCommande());
            
            // link to current day
            Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
            Dates d = new Dates();
            d.setAnnee(localCalendar.get(Calendar.YEAR));
            d.setMois(localCalendar.get(Calendar.MONTH)+1);
            d.setJour(localCalendar.get(Calendar.DATE));
            d.setHeure(localCalendar.get(Calendar.HOUR_OF_DAY));
            d.setMinute(localCalendar.get(Calendar.MINUTE));
            
            dateDAO.add(d);
            d.setIdDate(dateDAO.getLastDateId());
            
            currentCommande.setDate(d);
            
            
            for(Vente v : currentCommande.getVenteList()) {
                v.setCommande(currentCommande);
            }
            
            commandeDAO.save(currentCommande);
            allCommandes.add(0, currentCommande.clone());
            System.out.println("added");
        }
        return "paiement";
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

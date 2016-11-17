package Panier;

import Commande.Commande;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author Val
 */
public class Panier implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Commande commande;
    
    public Panier() {
        
    }
    
    @PostConstruct
    public void init() {
        commande = new Commande();
    }
    
    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}

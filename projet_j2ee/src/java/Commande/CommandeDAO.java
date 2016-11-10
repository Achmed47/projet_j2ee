/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author sabat
 */
@Stateless
public class CommandeDAO {
 
    @PersistenceContext(unitName = "projet_j2eePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Commande> getAllCommandes() {
        Query query = em.createNamedQuery("Commande.findAll");
        return query.getResultList();
    }
    
    public Commande getCommandeById(Integer idCommande) {
        TypedQuery query = em.createNamedQuery("Commande.findByIdCommande", Commande.class);
        query.setParameter("idCommande", idCommande);
        return (Commande) query.getSingleResult();
    }
    
    public void save(Commande c){
        try {
            if (c.getIdCommande() != null) {
                em.merge(c);
            } else {
                em.persist(c);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}

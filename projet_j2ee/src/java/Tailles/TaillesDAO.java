/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tailles;

import Couleurs.Couleurs;
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
public class TaillesDAO {

    @PersistenceContext(unitName = "projet_j2eePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Tailles> getAllTailles() {
        Query query = em.createNamedQuery("Tailles.findAll");
        return query.getResultList();
    }
    
    public Object getTailleByValue(String value) {
        TypedQuery query = em.createNamedQuery("Tailles.findByTaille", Couleurs.class);
        query.setParameter("taille", value);
        return (Tailles) query.getSingleResult();
    }
    
    public void saveTaille(Tailles taille){
        try {
            if (taille.getTaille()!= null) {
                em.merge(taille);
            } else {
                em.persist(taille);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void deleteTaille(Tailles taille) {
        try {
            if (taille.getTaille() != null) {
                Tailles t = em.find(Tailles.class, taille.getIdTaille());
                em.remove(t);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}

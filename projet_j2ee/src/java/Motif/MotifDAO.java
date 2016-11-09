/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motif;

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
public class MotifDAO {

    @PersistenceContext(unitName = "projet_j2eePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Motif> getAllMotifs() {
        Query query = em.createNamedQuery("Motif.findAll");
        return query.getResultList();
    }
    
    public Motif getMotifByValue(String value) {
        TypedQuery query = em.createNamedQuery("Motif.findByMotif", Couleurs.class);
        query.setParameter("motif", value);
        return (Motif) query.getSingleResult();
    }
    
    public void saveMotif(Motif motif){
        try {
            if (motif.getIdMotif()!= null) {
                em.merge(motif);
            } else {
                em.persist(motif);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void deleteMotif(Motif motif) {
        try {
            if (motif.getIdMotif() != null) {
                Motif t = em.find(Motif.class, motif.getIdMotif());
                em.remove(t);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}

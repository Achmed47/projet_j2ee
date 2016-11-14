/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vetement;

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
public class VetementDAO {

    private static final long serialVersionUID = 1L;
    
    @PersistenceContext(unitName = "projet_j2eePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Vetement> getAllVetements() {
        Query query = em.createNamedQuery("Vetement.findAll");
        return query.getResultList();
    }
    
    public Vetement getVetementFromRef(int refVetement) {
        TypedQuery<Vetement> query = em.createNamedQuery("Vetement.findByRefVet", Vetement.class);
        query.setParameter("refVet", refVetement);
        return (Vetement) query.getSingleResult();
    }
    
    public void saveVetement(Vetement vetement){
        try {
            if (vetement.getRefVet() != null) {
                em.merge(vetement);
            } else {
                em.persist(vetement);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void deleteVetement(Vetement vetement) {
        try {
            if (vetement.getRefVet() != null) {
                Vetement v = em.find(Vetement.class, vetement.getRefVet());
                em.remove(v);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}

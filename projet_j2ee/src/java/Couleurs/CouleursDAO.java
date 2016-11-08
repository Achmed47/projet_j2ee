/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Couleurs;

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
public class CouleursDAO {

    @PersistenceContext(unitName = "projet_j2eePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Couleurs> getAllCouleurs() {
        Query query = em.createNamedQuery("Couleurs.findAll");
        return query.getResultList();
    }

    public Object getCouleurByName(String value) {
        TypedQuery query = em.createNamedQuery("Couleurs.findByCouleur", Couleurs.class);
        query.setParameter("couleur", value);
        return (Couleurs) query.getSingleResult();
    }
}

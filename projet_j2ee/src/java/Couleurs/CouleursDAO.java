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

    public Couleurs getCouleurByName(String value) {
        TypedQuery query = em.createNamedQuery("Couleurs.findByCouleur", Couleurs.class);
        query.setParameter("couleur", value);
        return (Couleurs) query.getSingleResult();
    }
    
    public void saveCouleur(Couleurs couleur){
        try {
            if (couleur.getIdCouleur() != null) {
                em.merge(couleur);
            } else {
                em.persist(couleur);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void deleteCouleur(Couleurs couleur) {
        try {
            if (couleur.getCouleur() != null) {
                Couleurs v = em.find(Couleurs.class, couleur.getIdCouleur());
                em.remove(v);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}

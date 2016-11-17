/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sabat
 */
@Stateless
public class VenteDAO {

    @PersistenceContext(unitName = "projet_j2eePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Vente> getAllVentes() {
        Query query = em.createNamedQuery("Vente.findAll");
        return query.getResultList();
    }
    
    public void save(Vente v){
        try {
            if (v.getIdVente() != null && v.getMotif() != null) {
                em.merge(v);
            } else {
                em.persist(v);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void save(List<Vente> listVente){
        try {
            listVente.stream().forEach((v) -> {
                save(v);
            });
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}

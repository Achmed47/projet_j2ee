/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dates;

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
public class DatesDAO {

    @PersistenceContext(unitName = "projet_j2eePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public int getLastDateId() {
        Query query = em.createNamedQuery("Dates.findAll");
        List<Dates> allDates = query.getResultList();
        return (allDates != null && allDates.size() > 0) ? allDates.get(allDates.size()-1).getIdDate() : 0;
    }
    
    public void add(Dates d) {
        try {
            em.persist(d);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Types;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sabat
 */
@Stateless
public class TypesDAO {

    @PersistenceContext(unitName = "projet_j2eePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
}

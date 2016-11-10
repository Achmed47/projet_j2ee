/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Types;

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
public class TypesDAO {

    @PersistenceContext(unitName = "projet_j2eePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Types> getAllTypes() {
        Query query = em.createNamedQuery("Types.findAll");
        return query.getResultList();
    }

    public Types getTypeByName(String value) {
        TypedQuery query = em.createNamedQuery("Types.findByType", Types.class);
        query.setParameter("type", value);
        return (Types) query.getSingleResult();
    }
    
    public void saveType(Types type){
        try {
            if (type.getIdType() != null) {
                em.merge(type);
            } else {
                em.persist(type);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void deleteType(Types type) {
        try {
            if (type.getType() != null) {
                Types t = em.find(Types.class, type.getIdType());
                em.remove(t);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}

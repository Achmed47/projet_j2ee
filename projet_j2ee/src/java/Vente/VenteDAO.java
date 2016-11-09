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
//    private ArrayList<DataChart> dataChartArray;

    public void persist(Object object) {
        em.persist(object);
//        this.dataChartArray = new ArrayList();
    }
    
    public List<Vente> getAllVentes() {
        Query query = em.createNamedQuery("Vente.findAll");
        return query.getResultList();
    }
    
    public List<Vente> recupData(){
        Query query = em.createQuery("SELECT count(v) nbVentes, t.type, d.mois FROM Vente v, Vetement vt, Dates d, Commande c, Types t WHERE (v.refVet = :vt.refVet) AND (v.idCommande = :c.idCommande) AND (c.idDate = :d.idDate) AND (vt.idType = :t.idType) ORDER BY t.type, d.mois", Vente.class);
                
        List<Vente> rs = query.getResultList();
            for (int i = 0; i < rs.size(); i++){
                System.out.println(rs.get(i));
            }
        return rs;
    }
}

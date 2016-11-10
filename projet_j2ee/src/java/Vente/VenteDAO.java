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
        Query query = em.createQuery("SELECT sum(v.prix) revenu, d.mois FROM Vente v JOIN Dates d JOIN Commande c WHERE (c.idCommande = :idCommande) AND (d.idDate = :idDate) ORDER BY d.mois", Vente.class);
        List<Vente> rs = query.getResultList();
        for (int i = 0; i < rs.size(); i++){
            System.out.println(rs.get(i));
        }
        return rs;
    }
        
}

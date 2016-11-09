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
    
    public void recupData(){
        Query query = em.createQuery("SELECT count(*) nbVentes, type, mois \n" +
                " FROM vente v, vetement vt, dates d, commande c\n" +
                " WHERE v.refVet = vt.refVet\n" +
                " AND v.idCommande = c.idCommande\n" +
                " AND c.idDate = d.idDate\n" +
                " ORDER BY type, mois");
                
        List<Vente[]> results = query.getResultList();
            System.out.println(results.toString());
            for (int i = 0; i < results.size(); i++){
                
            }
    }


}

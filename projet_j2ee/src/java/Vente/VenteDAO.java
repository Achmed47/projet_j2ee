/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;

import charts.DataChart;
import java.util.ArrayList;
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

//    public ArrayList<DataChart> getDataChartArray() {
//        return dataChartArray;
//    }

//    public void setDataChartArray(ArrayList<DataChart> dataChartArray) {
//        this.dataChartArray = dataChartArray;
//    }
    
//    public void recupData(){
//        try (Connection conn = DriverManager.getConnection("projetj2ee", "root", "")) {
//            Statement state = conn.createStatement();
            
//            ResultSet rs = state.executeQuery("SELECT count(*) nbVentes, type, mois \n" +
//                " FROM vente v, vetement vt, dates d, commande c\n" +
//                " WHERE v.refVet = vt.refVet\n" +
//                " AND v.idCommande = c.idCommande\n" +
//                " AND c.idDate = d.idDate\n" +
//                " ORDER BY type, mois");
//            while (rs.next()) {
//                DataChart dc = new DataChart(rs.getInt("nbVentes"), rs.getString("type"), rs.getInt("mois"));
//                System.out.println(dc);
//                dataChartArray.add(dc);
//            }
//            System.out.println("Résultat de la requête : " + dataChartArray.toString());
//        }catch(SQLException e) {
//           System.out.println(e.getMessage()); 
//        }
//    }
}

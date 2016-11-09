/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charts;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author léa
 */
@ManagedBean
public class horizontalChart implements Serializable {
    
//    @PersistenceContext(unitName = "projet_j2eePU")
        
    private HorizontalBarChartModel horizontalBarModel;
//    private ArrayList<DataChart> dataChartArray;
 
    @PostConstruct
    public void init() {
//        this.dataChartArray = new ArrayList();
        createHorizontalBarModel();
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
    
//    public ArrayList<DataChart> getDataChartArray() {
//        return dataChartArray;
//    }

//    public void setDataChartArray(ArrayList<DataChart> dataChartArray) {
//        this.dataChartArray = dataChartArray;
//    }
     
    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
 
//        recupData();
//        
//        ChartSeries tshirt = new ChartSeries();
//        tshirt.setLabel("Tshirt");
//        tshirt.set("abscisse", ordonnée);
// 
//        ChartSeries pull = new ChartSeries();
//        pull.setLabel("Pull");
//        pull.set("abscisse", ordonnée);
 
//        horizontalBarModel.addSeries(tshirt);
//        horizontalBarModel.addSeries(pull);
         
//        horizontalBarModel.setTitle("Horizontal and Stacked");
//        horizontalBarModel.setLegendPosition("e");
//        horizontalBarModel.setStacked(true);
//         
//        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
//        xAxis.setLabel("Mois");
//        xAxis.setMin(0);
//        xAxis.setMax(200);
//         
//        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
//        yAxis.setLabel("NbVentes");        
    }
    
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
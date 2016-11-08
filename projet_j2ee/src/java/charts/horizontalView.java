/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charts;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;
 
@ManagedBean

public class horizontalView implements Serializable {
 
    private HorizontalBarChartModel horizontalBarModel;
    
    @PostConstruct
    public void init() {
        createHorizontalBarModel();
    }
      
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
     
    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
 
        ChartSeries tshirt = new ChartSeries();
        tshirt.setLabel("Tshirt");

        // Récupérer le nombre de t-shirt vendu dans le mois
        // tshirt.set(abscisse, ordonnée);
 
        ChartSeries pull = new ChartSeries();
        pull.setLabel("Pull");

        // Récupérer le nombre de pull vendu dans le mois
        // tshirt.set(abscisse, ordonnée);
 
        horizontalBarModel.addSeries(tshirt);
        horizontalBarModel.addSeries(pull);
         
        horizontalBarModel.setTitle("Horizontal and Stacked");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Nb Ventes");
        xAxis.setMin(0);
        xAxis.setMax(200);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Mois");        
    }

    public void recupData(){
        try {
            Connection conn = DriverManager.getConnection("projetj2ee", "root", "");
            Statement state = conn.createStatement();
            
            ResultSet rs = state.executeQuery("SELECT count(*) nbVentes, type, mois \n" +
                " FROM vente v, vetement vt, dates d, commande c\n" +
                " WHERE v.refVet = vt.refVet\n" +
                " AND v.idCommande = c.idCommande\n" +
                " AND c.idDate = d.idDate\n" +
                " ORDER BY type, mois");
            while (rs.next()) {
                int nbVentes = rs.getInt("nbVentes");
                String typeVet = rs.getString("type");
                int mois = rs.getInt("mois");
                System.out.println(nbVentes + "\t" + typeVet + "\t" + mois);
            }
            conn.close();
        }catch(SQLException e) {
           System.out.println(e.getMessage()); 
        }
    }
 
}
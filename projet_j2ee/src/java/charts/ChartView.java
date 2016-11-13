/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charts;

import Commande.Commande;
import Commande.CommandeDAO;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
//import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author léa
 */

@Named(value = "chartView")
@RequestScoped

public class ChartView implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private CommandeDAO commandeDAO;

    private List<Commande> commandesMois;
    
    private BarChartModel barModel;
//    private HorizontalBarChartModel horizontalBarModel;
 
    @PostConstruct
    public void init() {
        createBarModel();
    }
     
    public BarChartModel getBarModel() {
        return barModel;
    }
    
    private BarChartModel initChartBar(){
        BarChartModel chart = new BarChartModel();
        commandesMois = commandeDAO.recupData();
        
        try {
            for (int i = 0; i < commandesMois.size(); i++){
                System.out.print("ligne : " + i + " revenu = " + commandesMois.get(i));
//                commandesMois.add(new Commande(i));
//                System.out.print("ligne : " + i + " valeur = " + commandesMois.toString());
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        
        System.out.println("j'ai fini récup data");
//        ChartSeries revenu = new ChartSeries();
//        
//        revenu.setLabel("Revenu");
//        revenu.set("12", 150);
//        
//        chart.addSeries(revenu);
        
        return chart;
    }
     
    private void createBarModel() {
        barModel = initChartBar();
        barModel.setTitle("Revenu Mensuel");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Mois");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Revenu");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
}
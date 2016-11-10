/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

/**
 *
 * @author sabat
 */
@Named(value = "venteController")
@SessionScoped
public class VenteController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private VenteDAO venteDAO;
    private HorizontalBarChartModel venteMoisChart;

    /**
     * Creates a new instance of VenteController
     */
    public VenteController() {
    }
    
    public List<Vente> getVentes() {
        System.out.println(venteDAO.getAllVentes().toString());
        return venteDAO.getAllVentes();
    }
    
    
    
    public HorizontalBarChartModel chartHorizontal() {
        List<Vente> venteMois = venteDAO.recupData();
        venteMoisChart = new HorizontalBarChartModel();
        
        ChartSeries tshirt = new ChartSeries();
//        tshirt.setLabel("Tshirt");
//        tshirt.set("abscisse", ordonnée);
// 
        ChartSeries pull = new ChartSeries();
//        pull.setLabel("Pull");
//        pull.set("abscisse", ordonnée);
 
        venteMoisChart.addSeries(tshirt);
        venteMoisChart.addSeries(pull);
         
        venteMoisChart.setTitle("Horizontal and Stacked");
        venteMoisChart.setLegendPosition("e");
        venteMoisChart.setStacked(true);
         
        Axis xAxis = venteMoisChart.getAxis(AxisType.X);
        xAxis.setLabel("Mois");
        xAxis.setMin(0);
        xAxis.setMax(200);
         
        Axis yAxis = venteMoisChart.getAxis(AxisType.Y);
        yAxis.setLabel("NbVentes");    

        return venteMoisChart;
    }
}

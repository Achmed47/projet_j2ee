/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.chart.HorizontalBarChartModel;

/**
 *
 * @author sabat
 */
@Named(value = "venteController")
@ViewScoped
public class VenteController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private VenteDAO venteDAO;

    /**
     * Creates a new instance of VenteController
     */
    public VenteController() {
    }
    
    public List<Vente> getVentes() {
        System.out.println(venteDAO.getAllVentes().toString());
        return venteDAO.getAllVentes();
    }
    
    public HorizontalBarChartModel ChartHorizontal() {
        List<Vente> venteMois = venteDAO.recupData();
        HorizontalBarChartModel venteMoisChart = new HorizontalBarChartModel();
        
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

        return venteMoisChart;
    }

}

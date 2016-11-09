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
}
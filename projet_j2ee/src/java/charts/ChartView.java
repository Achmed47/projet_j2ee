/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charts;

import Vente.Vente;
import Vente.VenteDAO;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
//import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author léa
 */
@ManagedBean
public class ChartView implements Serializable {
    @EJB
    private VenteDAO venteDAO;
    
    private BarChartModel barModel;
//    private HorizontalBarChartModel horizontalBarModel;
 
    @PostConstruct
    public void init() {
        createBarModel();
    }
     
    public BarChartModel getBarModel() {
        return barModel;
    }
    
    public List<Vente> selectData() {
        List<Vente> revenuMois = venteDAO.recupData();
        return revenuMois;
    }
    
    private BarChartModel initChartBar(){
        BarChartModel chart = new BarChartModel();
        return chart;
    }
     
    private void createBarModel() {
        barModel = initChartBar();
        barModel.setTitle("Revenu Mensuel");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Gender");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
}
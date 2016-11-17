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
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author léa
 */

@Named(value = "chartBarYear")
@RequestScoped

public class ChartBarYear implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private CommandeDAO commandeDAO;

    private List<Commande> commandesMois;
    
    private BarChartModel barModel;
 
    @PostConstruct
    public void init() {
        createBarModel();
    }
     
    public BarChartModel getBarModel() {
        return barModel;
    }
    
    private BarChartModel initChartBar(){
        BarChartModel chart = new BarChartModel();
        commandesMois = commandeDAO.recupDataAnnee();
        Iterator it = commandesMois.iterator();
        ChartSeries revenuAnnee = new ChartSeries();        
        revenuAnnee.setLabel("Revenu");
        while(it.hasNext()){
            Object[] ligne = (Object[])it.next();
            String sRevenu = ligne[0].toString();
            float revenu = new Float(sRevenu);
            String sAnnee = ligne[1].toString();
            revenuAnnee.set(sAnnee, revenu);
        }
        chart.addSeries(revenuAnnee);
        
        return chart;
    }
     
    private void createBarModel() {
        barModel = initChartBar();
        barModel.setTitle("Revenu Mensuel");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Annees");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Revenu");
        yAxis.setMin(0);
        yAxis.setMax(500);
    }
}
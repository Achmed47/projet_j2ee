/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
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

    private List<Vente> allVentes;
    private List<Vente> ventesFiltered;
    
    /**
     * Creates a new instance of VenteController
     */
    public VenteController() {
    }
    
    @PostConstruct
    public void init() {
        allVentes = venteDAO.getAllVentes();
        ventesFiltered = new ArrayList<>();
    }
    
    public List<Vente> getVentes() {
        return allVentes;
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
    
    public List<Vente> getVentesByCommandeId(Integer commandeId) {
        ventesFiltered.clear();
        allVentes.stream().filter((v) -> (Objects.equals(v.getCommande().getIdCommande(), commandeId))).forEachOrdered((v) -> {
            ventesFiltered.add(v);
        });
        return ventesFiltered;
    }
    
    public float getPrixTotalByCommandeId(Integer commandeId) {
        if(ventesFiltered.isEmpty()) {
            return 0;
        } else {
            float prixTotal = 0;
            return ventesFiltered.stream().map((v) -> v.getPrix()).reduce(prixTotal, (accumulator, _item) -> accumulator + _item);
        }
    }
}

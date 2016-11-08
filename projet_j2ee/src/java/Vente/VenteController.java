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
import javax.faces.view.ViewScoped;
import javax.inject.Named;

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
    
}

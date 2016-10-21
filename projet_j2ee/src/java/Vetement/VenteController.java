/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vetement;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author sabat
 */
@Named(value = "venteController")
@ViewScoped
public class VenteController {

    @EJB
    private VetementDAO vetementDAO;

    /**
     * Creates a new instance of VenteController
     */
    public VenteController() {
    }
}

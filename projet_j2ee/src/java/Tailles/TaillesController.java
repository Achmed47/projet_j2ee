/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tailles;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author sabat
 */
@Named(value = "taillesController")
@ViewScoped
public class TaillesController {

    @EJB
    private TaillesDAO taillesDAO;

    /**
     * Creates a new instance of TaillesController
     */
    public TaillesController() {
    }
    
    
}

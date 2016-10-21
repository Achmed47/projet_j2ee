/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motif;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author sabat
 */
@Named(value = "motifController")
@ViewScoped
public class MotifController {

    @EJB
    private MotifDAO motifDAO;

    /**
     * Creates a new instance of MotifController
     */
    public MotifController() {
    }
}

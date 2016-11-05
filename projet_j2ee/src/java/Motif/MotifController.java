/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motif;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author sabat
 */
@Named(value = "motifController")
@ViewScoped
public class MotifController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private MotifDAO motifDAO;

    /**
     * Creates a new instance of MotifController
     */
    public MotifController() {
    }
}

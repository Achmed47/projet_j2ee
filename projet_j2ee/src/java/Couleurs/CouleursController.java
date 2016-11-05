/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Couleurs;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author sabat
 */
@Named(value = "couleursController")
@ViewScoped
public class CouleursController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private CouleursDAO couleursDAO;

    /**
     * Creates a new instance of CouleursController
     */
    public CouleursController() {
    }
}

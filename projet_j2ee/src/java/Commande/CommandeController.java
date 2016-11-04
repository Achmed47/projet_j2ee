/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author sabat
 */
@Named(value = "commandeController")
@ViewScoped
public class CommandeController implements Serializable {

    @EJB
    private CommandeDAO commandeDAO;

    /**
     * Creates a new instance of CommandeController
     */
    public CommandeController() {
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande;

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
@Named(value = "commandeController")
@ViewScoped
public class CommandeController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private CommandeDAO commandeDAO;

    /**
     * Creates a new instance of CommandeController
     */
    public CommandeController() {
    }
    
    public List<Commande> getCommandes() {
        System.out.println(commandeDAO.getAllCommandes().toString());
        return commandeDAO.getAllCommandes();
    }
   
}

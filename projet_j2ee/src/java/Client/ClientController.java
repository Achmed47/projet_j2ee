/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author sabat
 */
@Named(value = "clientController")
@ViewScoped
public class ClientController implements Serializable {

    @EJB
    private ClientDAO clientDAO;

    /**
     * Creates a new instance of ClientController
     */
    public ClientController() {
    }
    
    
    
}

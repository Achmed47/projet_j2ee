/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sabat
 */
@Named(value = "clientController")
@SessionScoped
public class ClientController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ClientDAO clientDAO;
    
    private Client client;
    /**
     * Creates a new instance of ClientController
     */
    public ClientController() {
    }
    
    @PostConstruct
    public void init() {
        client = clientDAO.getFirstClient();
    }
    
    public Client getClient() {
        return this.client;
    }
    
    public void setClient(Client c) {
        this.client = c;
    }
}

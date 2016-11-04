/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author sabat
 */
@Named(value = "stockController")
@ViewScoped
public class StockController implements Serializable {

    @EJB
    private StockDAO stockDAO1;

    @EJB
    private StockDAO stockDAO;

    /**
     * Creates a new instance of StockController
     */
    public StockController() {
    }
}

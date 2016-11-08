/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dates;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author sabat
 */
@Named(value = "datesController")
@ViewScoped
public class DatesController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private DatesDAO datesDAO;

    /**
     * Creates a new instance of DatesController
     */
    public DatesController() {
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Types;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author sabat
 */
@Named(value = "typesController")
@ViewScoped
public class TypesController implements Serializable {

   private static final long serialVersionUID = 1L;
    
    @EJB
    private TypesDAO typesDAO;
    
    public TypesController() {
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Types;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author sabat
 */
@Named(value = "typesController")
@SessionScoped
public class TypesController implements Serializable {

   private static final long serialVersionUID = 1L;
    
    @EJB
    private TypesDAO typesDAO;
    
    private List<Types> allTypes;
    private Types newType;
    
    public TypesController() {
    }
    
    @PostConstruct
    public void init() {
        newType = new Types();
        allTypes = typesDAO.getAllTypes();
    }

    public List<Types> getTypes() {
        return allTypes;
    }

    public void setTypes(List<Types> allTypes) {
        this.allTypes = allTypes;
    }

    public Types getNewType() {
        return newType;
    }

    public void setNewType(Types newType) {
        this.newType = newType;
    }
    
    public void onRowEdit(RowEditEvent event) {
        Types t = (Types) event.getObject();
        if(!contains(t.getType())) {
            typesDAO.saveType(t);
        }
    }

    public void onRowCancel(RowEditEvent event) {
        
    }
    
    public void deleteType(Types type) {
        if(type != null && type.getType()!= null) {
            for (Iterator<Types> it = allTypes.iterator(); it.hasNext();) {
                Types t = it.next();
                if(Objects.equals(t.getType(), type.getType())) {
                    typesDAO.deleteType(type);
                    it.remove();
                }
            }
        }
    }
    
    public void addType(ActionEvent e) {
        if(newType != null && newType.getType()!= null && !contains(newType.getType())) {
            typesDAO.saveType(newType);
            allTypes.add(newType);
            RequestContext.getCurrentInstance().execute("PF('addTypeDialog').hide()");
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("tableTypes");
            RequestContext.getCurrentInstance().update("formType:addTypeDialog");
            newType = new Types();
        }
    }
        
    private boolean contains(String type) {
        return (allTypes.stream().anyMatch((c) -> (c.getType().equals(type))));
    }
}

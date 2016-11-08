/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converters;

import Types.Types;
import Types.TypesDAO;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Val Gros Pénis
 */
@FacesConverter(forClass = Types.class)
@Model
public class TypeConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {  
        if (value != null && !value.isEmpty()) {
            return (Types) component.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Types) {
            Types entity = (Types) value;
            if (entity != null && entity instanceof Types && entity.getType()!= null) {
                component.getAttributes().put( entity.getType().toString(), entity);
                return entity.getType().toString();
            }
        }
        return "";
    }
}

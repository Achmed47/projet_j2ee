/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converters;

import Couleurs.Couleurs;
import Motif.Motif;
import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Val Gros Pénis
 */
@FacesConverter(forClass = Motif.class)
@Model
public class MotifConverter implements Converter {
   
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {  
        if (value != null && !value.isEmpty()) {
            System.err.println("Converting " + value + " to motif");
            return (Motif) component.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Motif) {
            Motif entity = (Motif) value;
            if (entity instanceof Motif && entity.getIdMotif()!= null) {
                component.getAttributes().put( entity.getUrlMotif(), entity);
                return entity.getUrlMotif();
            }
        }
        return "";
    }
    
}

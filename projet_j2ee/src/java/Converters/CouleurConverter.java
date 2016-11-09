/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converters;

import Couleurs.Couleurs;
import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Val Gros Pénis
 */
@FacesConverter(forClass = Couleurs.class)
@Model
public class CouleurConverter implements Converter {
   
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {  
        if (value != null && !value.isEmpty()) {
            System.err.println("Converting " + value + " to color");
            return (Couleurs) component.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Couleurs) {
            Couleurs entity = (Couleurs) value;
            if (entity instanceof Couleurs && entity.getCouleur() != null) {
                component.getAttributes().put( entity.getCouleur(), entity);
                return entity.getCouleur();
            }
        }
        return "";
    }
    
}

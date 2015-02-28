/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.bdaplication.controllers.converter;

import com.mycompany.backend.bdapplication.business.dto.EstadoDTO;
import com.mycompany.bdaplication.controllers.view.EstadoViewBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Roberth
 */
@FacesConverter(value = "estadoConverter", forClass = EstadoDTO.class)
public class EstadoConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {

        EstadoViewBean estadoViewBean = (EstadoViewBean) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "estadoViewBean");

        if (value.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(value);
                for (EstadoDTO estado : estadoViewBean.getListaEstadosTodos()) {
                    if (estado.getId() == number) {
                        return estado;
                    }
                }
            } catch (NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Estado Invalido"));
            }
        }
        return null;
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((EstadoDTO) value).getId());
        }
    }
    
}

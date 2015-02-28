/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.bdaplication.controllers.converter;

import com.mycompany.backend.bdapplication.business.dto.CiudadDTO;
import com.mycompany.bdaplication.controllers.view.CiudadViewBean;
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
@FacesConverter(value = "ciudadConverter", forClass = CiudadDTO.class)
public class CiudadConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {

        CiudadViewBean ciudadViewBean = (CiudadViewBean) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "ciudadViewBean");

        if (value.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(value);
                for (CiudadDTO ciudad : ciudadViewBean.getListaCiudadesTodas()) {
                    if (ciudad.getId() == number) {
                        return ciudad;
                    }
                }
            } catch (NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Ciudad Invalida"));   
            }
        }
        return null;
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((CiudadDTO) value).getId());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.bdaplication.controllers.converter;


import com.mycompany.backend.bdapplication.business.dto.ClienteDTO;
import com.mycompany.bdaplication.controllers.view.ClienteViewBean;
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
@FacesConverter(value = "clienteConverter", forClass = ClienteDTO.class)
public class ClienteConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {

        ClienteViewBean clienteViewBean = (ClienteViewBean) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "clienteViewBean");

        if (value.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(value);
                for (ClienteDTO cliente : clienteViewBean.getListaTrabajadoresTodos()) {
                    if (cliente.getId() == number) {
                        return cliente;
                    }
                }
            } catch (NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Rol Invalida"));
            }
        }
        return null;
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((ClienteDTO) value).getId());
        }
    }
}

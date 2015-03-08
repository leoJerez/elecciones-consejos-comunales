package org.eleccion_comunal.beans.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.eleccion_comunal.beans.view.PostuladosViewBean;
import org.eleccion_comunal.model.dto.Cargo;

@FacesConverter(value = "cargoConverter", forClass = Cargo.class)
public class CargoConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	PostuladosViewBean postuladosViewBean = (PostuladosViewBean) context.getApplication().getELResolver().getValue(context.getELContext(), null, "postuladosViewBean");
	if (value.trim().equals("")) {
            return null;
        } else {
            try {
                int numero = Integer.parseInt(value);
                for (Cargo p : postuladosViewBean.getListaCargos()) {
		    if (p.getIdCargo() == numero) {
			return p;
		    }
		}
            } catch (NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Eje Invalido"));
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
	if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Cargo) value).getIdCargo());
        }
    }
}

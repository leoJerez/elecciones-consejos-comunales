package org.eleccion_comunal.utilidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ManejadorFechas implements Serializable {

    private static final long serialVersionUID = -6242437333318018564L;

    private static ManejadorFechas instancia;

    private ManejadorFechas() {
	super();
    }

    public static ManejadorFechas getInstancia() {
	if (instancia == null) {
	    instancia = new ManejadorFechas();
	}
	return instancia;
    }

    /**
     * Este metodo se encarga de calcular la edad de algo a partir de la fecha de nacimiento
     * @param fechaNacimiento
     * @return edad calculada o 0 si la fecha de nacimiento es NULL
     * @author Jos� Leonardo Jerez
     */
    public int calcularEdad(Date fechaNacimiento) {
	Calendar nacimientoGregorian = new GregorianCalendar();
	Calendar hoyGregorian = new GregorianCalendar();
	int edadResultante = 0;
	if (fechaNacimiento != null) {
	    int factor = 0;
	    nacimientoGregorian.setTime(fechaNacimiento);
	    hoyGregorian.setTime(new Date());
	    if (hoyGregorian.get(Calendar.MONTH) <= nacimientoGregorian.get(Calendar.MONTH)) {
		if (hoyGregorian.get(Calendar.MONTH) == nacimientoGregorian.get(Calendar.MONTH)) {
		    if (hoyGregorian.get(Calendar.DATE) > nacimientoGregorian.get(Calendar.DATE)) {
			factor = -1; // Aun no celebra su cumpleaños
		    }
		} else {
		    factor = -1; // Aun no celebra su cumpleaños
		}
	    }
	    edadResultante = (hoyGregorian.get(Calendar.YEAR) - nacimientoGregorian.get(Calendar.YEAR)) + factor;
	    return edadResultante;
	} else {
	    return edadResultante;
	}

    }
}

package org.eleccion_comunal.utilidades;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

/**
 * Este objeto contiene mÈtodos que permiten darle formato a diferentes tipos de datos
 * 
 * @author JosÈ Leonardo Jerez
 */
public class Formateador implements Serializable {

    private static final long serialVersionUID = -6242437333528018564L;

    private static Formateador instancia;

    private Formateador() {
	super();
    }

    public static Formateador getInstancia() {
	if (instancia == null) {
	    instancia = new Formateador();
	}
	return instancia;
    }

    /**
     * 
     * @param fechaObjetivo
     *            es la fecha que queremos transformar a un formato facil de
     *            leer
     * @return String que contiene la fecha ya formateada en formato (FULL)
     *         ejemplo: "lunes 6 de agosto de 2012"
     */
    public String formatearFechaEstiloCompleto(Date fechaObjetivo) {
	if (fechaObjetivo != null) {
	    DateFormat formatoFechaFull = DateFormat.getDateInstance(DateFormat.FULL, new Locale("es", "VE"));
	    return formatoFechaFull.format(fechaObjetivo);
	} else {
	    return "";
	}
    }

    /**
     * 
     * @param fechaObjetivo
     *            es la fecha que queremos transformar a un formato facil de
     *            leer
     * @return String que contiene la fecha ya formateada en formato (SHORT)
     *         ejemplo: "06/08/12"
     */
    public String formatearFechaEstiloCorto(Date fechaObjetivo) {
	if (fechaObjetivo != null) {
	    DateFormat formatoFechaShort = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("es", "VE"));
	    return formatoFechaShort.format(fechaObjetivo);
	} else {
	    return "";
	}
    }

    /**
     * 
     * @param fechaObjetivo
     *            es la fecha que queremos transformar a un formato facil de
     *            leer
     * @return String que contiene la fecha ya formateada en formato (MEDIUM)
     *         ejemplo: "06/08/2012"
     */
    public String formatearFechaEstiloMedio(Date fechaObjetivo) {
	if (fechaObjetivo != null) {
	    DateFormat formatoFechaMedium = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("es", "VE"));
	    return formatoFechaMedium.format(fechaObjetivo);
	} else {
	    return "";
	}
    }

    /**
     * 
     * @param fechaObjetivo
     *            es la fecha que queremos transformar a un formato facil de
     *            leer
     * @return String que contiene la fecha ya formateada en formato (LONG)
     *         ejemplo: "6 de agosto de 2012"
     */
    public String formatearFechaEstiloLargo(Date fechaObjetivo) {
	if (fechaObjetivo != null) {
	    DateFormat formatoFechaLong = DateFormat.getDateInstance(DateFormat.LONG, new Locale("es", "VE"));
	    return formatoFechaLong.format(fechaObjetivo);
	} else {
	    return "";
	}
    }

    /**
     * Este metodo permite eliminar caracteres con tilde de una cadena de
     * caracteres, sin importar si la cadena esta en mayusculas o minusculas
     * 
     * @param input
     *            - cadena que se quiere modificar
     * @return cadena sin tildes
     */
    public String removeCharacter(String input) {
	String original = "·‡‰ÈËÎÌÏÔÛÚˆ˙˘uÒ¡¿ƒ…»ÀÕÃœ”“÷⁄Ÿ‹—Á«";
	String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	String output = input;
	try {
	    for (int i = 0; i < original.length(); i++) {
		output = output.replace(original.charAt(i), ascii.charAt(i));
	    }
	} catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
	}
	return output;
    }

    /**
     * Este m√©todo se encarga de darle formato a un valor tipo Double, de tal
     * forma que el valor entrante sufra la siguiente transformaci√≥n:
     * valorEntrante = 9000,99923141 valoRetorno = 9.000,99
     * 
     * @param valorParaFormatear
     *            , valor que se desea formatear
     * @param localidadParaFormato
     *            , ejemplo: new Locale("es", "VE") para Venezuela
     * @return valorRetorno, valor ya formateado
     */
    public String formatearDecimalDouble(Double valorParaFormatear, Locale localidadParaFormato) {
	return String.format(localidadParaFormato, "%,.2f", valorParaFormatear);
    }

    /**
     * Este m√©todo se encarga de darle formato a un valor tipo Double para que
     * haga uso de los separadores de miles seg√∫n a notaci√≥n venezolana, de
     * tal forma que el valor entrante sufra la siguiente transformaci√≥n:
     * valorEntrante = 9000,99923141 valoRetorno = 9.000
     * 
     * @param valorParaFormatear
     *            , valor que se desea formatear
     * @param localidadParaFormato
     *            , ejemplo: new Locale("es", "VE") para Venezuela
     * @return valorRetorno, valor ya formateado
     */
    public String formatearEnteroMiles(Double valorParaFormatear, Locale localidadParaFormato) {
	return NumberFormat.getNumberInstance(localidadParaFormato).format(valorParaFormatear.intValue());
    }

}

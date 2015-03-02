package org.eleccion_comunal.enums;


/**
 * Estos son los sexos de cualquier persona
 * @author José Leonardo Jerez
 *
 */
public enum Sexo {

    MASCULINO("Masculino", "H"),
    FEMENINO("Femenino", "M");

    private final String descripcion;

    private final String valor;

    private Sexo(String descripcion, String valor) {
	this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

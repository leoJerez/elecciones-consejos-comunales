package org.eleccion_comunal.enums;


/**
 * Estos son los posibles valores del campo status de las entidades, los cuales son utilizados para la eliminaci�n l�gica
 * @author Jos� Leonardo Jerez
 *
 */
public enum Status {
    
    STATUS_ACTIVO("Para la eliminaci�n l�gica", "A"),
    STATUS_INACTIVO("Para la eliminaci�n l�gica", "I");

    private final String descripcion;

    private final String valor;

    private Status(String descripcion, String valor) {
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

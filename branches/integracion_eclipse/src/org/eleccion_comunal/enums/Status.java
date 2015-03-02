package org.eleccion_comunal.enums;


/**
 * Estos son los posibles valores del campo status de las entidades, los cuales son utilizados para la eliminación lógica
 * @author José Leonardo Jerez
 *
 */
public enum Status {
    
    STATUS_ACTIVO("Para la eliminación lógica", "A"),
    STATUS_INACTIVO("Para la eliminación lógica", "I");

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

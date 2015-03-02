package org.eleccion_comunal.enums;


/**
 * Estos son los posibles estados civil de cualquier persona
 * @author José Leonardo Jerez
 *
 */
public enum EstadoCivil {

    SOLTERO("Soltero", "S"),
    CASADO("Casado", "C"),
    VIUDO("Viudo", "V"),
    DIVORCIADO("Divorciado", "D");

    private final String descripcion;

    private final String valor;

    private EstadoCivil(String descripcion, String valor) {
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

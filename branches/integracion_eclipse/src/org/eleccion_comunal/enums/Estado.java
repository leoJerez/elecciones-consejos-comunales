package org.eleccion_comunal.enums;


/**
 * Estos son los posibles valores del campo estado de algunas entidades
 * @author José Leonardo Jerez
 *
 */
public enum Estado {

    MIEMBRO_ESTADO_HABILITADO("Para el campo estado de la entidad MiembrosConsejo, cargo habilitado", "H"),
    MIEMBRO_ESTADO_INHABILITADO("Para el campo estado de la entidad MiembrosConsejo, cargo inhabilitado", "N"),
    CANDIDATO_ESTADO_APROBADO("Para el campo estado de la entidad Candidato, el candidato cumple con los requisitos", "P"),
    CANDIDATO_ESTADO_RECHAZADO("Para el campo estado de la entidad Candidato, el candidato NO cumple con los requisitos", "R"),
    CANDIDATO_ESTADO_EN_PROCESO("Para el campo estado de la entidad Candidato, al candidato aun no se le han revisado sus requisitos", "E");

    private final String descripcion;

    private final String valor;

    private Estado(String descripcion, String valor) {
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

package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.Estado;


public class EstadoDAO extends DAOGenerico {

    private static EstadoDAO instancia;

    public static EstadoDAO getInstancia() {
	if (instancia == null) {
	    instancia = new EstadoDAO();
	}
	return instancia;
    }

    private EstadoDAO() {
	super(Estado.class);
    }
}

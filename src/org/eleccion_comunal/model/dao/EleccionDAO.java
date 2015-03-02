package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.Eleccion;



public class EleccionDAO extends DAOGenerico {

    private static EleccionDAO instancia;

    public static EleccionDAO getInstancia() {
	if (instancia == null) {
	    instancia = new EleccionDAO();
	}
	return instancia;
    }

    private EleccionDAO() {
	super(Eleccion.class);
    }
}

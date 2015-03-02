package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.Parroquia;

public class ParroquiaDAO extends DAOGenerico {

    private static ParroquiaDAO instancia;

    public static ParroquiaDAO getInstancia() {
	if (instancia == null) {
	    instancia = new ParroquiaDAO();
	}
	return instancia;
    }

    private ParroquiaDAO() {
	super(Parroquia.class);
    }
}

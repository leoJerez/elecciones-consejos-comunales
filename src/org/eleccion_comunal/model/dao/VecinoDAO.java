package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.Vecino;


public class VecinoDAO extends DAOGenerico {

    private static VecinoDAO instancia;

    public static VecinoDAO getInstancia() {
	if (instancia == null) {
	    instancia = new VecinoDAO();
	}
	return instancia;
    }

    private VecinoDAO() {
	super(Vecino.class);
    }
}

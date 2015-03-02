package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.VecinoVivienda;

public class VecinoViviendaDAO extends DAOGenerico {

    private static VecinoViviendaDAO instancia;

    public static VecinoViviendaDAO getInstancia() {
	if (instancia == null) {
	    instancia = new VecinoViviendaDAO();
	}
	return instancia;
    }

    private VecinoViviendaDAO() {
	super(VecinoVivienda.class);
    }
}

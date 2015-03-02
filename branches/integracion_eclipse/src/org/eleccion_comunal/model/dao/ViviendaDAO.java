package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.Vivienda;


public class ViviendaDAO extends DAOGenerico {

    private static ViviendaDAO instancia;

    public static ViviendaDAO getInstancia() {
	if (instancia == null) {
	    instancia = new ViviendaDAO();
	}
	return instancia;
    }

    private ViviendaDAO() {
	super(Vivienda.class);
    }
}

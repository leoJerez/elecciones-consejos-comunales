package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.VehiculoVivienda;


public class VehiculoViviendaDAO extends DAOGenerico {

    private static VehiculoViviendaDAO instancia;

    public static VehiculoViviendaDAO getInstancia() {
	if (instancia == null) {
	    instancia = new VehiculoViviendaDAO();
	}
	return instancia;
    }

    private VehiculoViviendaDAO() {
	super(VehiculoVivienda.class);
    }
}

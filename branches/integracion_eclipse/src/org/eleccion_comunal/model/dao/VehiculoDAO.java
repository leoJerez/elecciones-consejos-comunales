package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.Vehiculo;


public class VehiculoDAO extends DAOGenerico {

    private static VehiculoDAO instancia;

    public static VehiculoDAO getInstancia() {
	if (instancia == null) {
	    instancia = new VehiculoDAO();
	}
	return instancia;
    }

    private VehiculoDAO() {
	super(Vehiculo.class);
    }
}

package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.Cargo;


public class CargoDAO extends DAOGenerico {

    private static CargoDAO instancia;

    public static CargoDAO getInstancia() {
	if (instancia == null) {
	    instancia = new CargoDAO();
	}
	return instancia;
    }

    private CargoDAO() {
	super(Cargo.class);
    }
}

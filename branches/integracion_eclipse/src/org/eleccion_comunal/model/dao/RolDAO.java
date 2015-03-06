package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.Rol;

public class RolDAO extends DAOGenerico {

    private static RolDAO instancia;

    public static RolDAO getInstancia() {
	if (instancia == null) {
	    instancia = new RolDAO();
	}
	return instancia;
    }

    private RolDAO() {
	super(Rol.class);
    }
}

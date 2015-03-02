package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.MiembrosConsejo;

public class MiembrosConsejoDAO extends DAOGenerico {

    private static MiembrosConsejoDAO instancia;

    public static MiembrosConsejoDAO getInstancia() {
	if (instancia == null) {
	    instancia = new MiembrosConsejoDAO();
	}
	return instancia;
    }

    private MiembrosConsejoDAO() {
	super(MiembrosConsejo.class);
    }
}

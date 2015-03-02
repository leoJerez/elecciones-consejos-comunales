package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.ConsejoComunal;

public class ConsejoComunalDAO extends DAOGenerico {

    private static ConsejoComunalDAO instancia;

    public static ConsejoComunalDAO getInstancia() {
	if (instancia == null) {
	    instancia = new ConsejoComunalDAO();
	}
	return instancia;
    }

    private ConsejoComunalDAO() {
	super(ConsejoComunal.class);
    }
}

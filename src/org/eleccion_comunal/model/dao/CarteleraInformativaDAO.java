package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.CarteleraInformativa;

public class CarteleraInformativaDAO extends DAOGenerico {

    private static CarteleraInformativaDAO instancia;

    public static CarteleraInformativaDAO getInstancia() {
	if (instancia == null) {
	    instancia = new CarteleraInformativaDAO();
	}
	return instancia;
    }

    private CarteleraInformativaDAO() {
	super(CarteleraInformativa.class);
    }
}

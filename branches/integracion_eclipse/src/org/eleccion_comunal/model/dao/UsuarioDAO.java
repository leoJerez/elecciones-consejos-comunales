package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.Usuario;

public class UsuarioDAO extends DAOGenerico {

    private static UsuarioDAO instancia;

    public static UsuarioDAO getInstancia() {
	if (instancia == null) {
	    instancia = new UsuarioDAO();
	}
	return instancia;
    }

    private UsuarioDAO() {
	super(Usuario.class);
    }
}

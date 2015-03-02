package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.Municipio;


public class MunicipioDAO extends DAOGenerico {

    private static MunicipioDAO instancia;

    public static MunicipioDAO getInstancia() {
	if (instancia == null) {
	    instancia = new MunicipioDAO();
	}
	return instancia;
    }

    private MunicipioDAO() {
	super(Municipio.class);
    }
}

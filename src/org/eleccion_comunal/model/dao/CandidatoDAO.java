package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.Candidato;


public class CandidatoDAO extends DAOGenerico {

    private static CandidatoDAO instancia;

    public static CandidatoDAO getInstancia() {
	if (instancia == null) {
	    instancia = new CandidatoDAO();
	}
	return instancia;
    }

    private CandidatoDAO() {
	super(Candidato.class);
    }
}

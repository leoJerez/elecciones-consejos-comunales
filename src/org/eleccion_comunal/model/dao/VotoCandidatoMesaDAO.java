package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.VotoCandidatoMesa;


public class VotoCandidatoMesaDAO extends DAOGenerico {

    private static VotoCandidatoMesaDAO instancia;

    public static VotoCandidatoMesaDAO getInstancia() {
	if (instancia == null) {
	    instancia = new VotoCandidatoMesaDAO();
	}
	return instancia;
    }

    private VotoCandidatoMesaDAO() {
	super(VotoCandidatoMesa.class);
    }
}

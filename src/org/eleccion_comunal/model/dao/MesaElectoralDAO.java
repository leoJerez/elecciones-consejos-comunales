package org.eleccion_comunal.model.dao;

import org.eleccion_comunal.model.dto.MesaElectoral;



public class MesaElectoralDAO extends DAOGenerico {

    private static MesaElectoralDAO instancia;

    public static MesaElectoralDAO getInstancia() {
	if (instancia == null) {
	    instancia = new MesaElectoralDAO();
	}
	return instancia;
    }

    private MesaElectoralDAO() {
	super(MesaElectoral.class);
    }
}

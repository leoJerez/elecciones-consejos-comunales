package org.eleccion_comunal.servicios;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




import org.eleccion_comunal.exceptions.ExceptionHttpPersonalizada;
import org.eleccion_comunal.utilidades.CustomLogger;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.JsonParseException;

public class ClienteRESTImplementacion {

    private static final Logger log = CustomLogger.getGeneralLogger(ClienteRESTImplementacion.class.getName());
    private ProveedorGenericoObjetosREST proveedorGenericoObjetosREST;

    public <T> List<T> cargarListaCompleta(ServiciosDisponibles servicio, String recursoSolicitado) {
	try {
	    return (List<T>) this.getProveedorGenericoObjetosREST().getObjeto(ClienteHttp.getInstancia().getCliente(), servicio, recursoSolicitado);
	} catch (JsonMappingException jsonMappingException) {
	    log.log(Level.SEVERE, null, jsonMappingException);
	} catch (JsonParseException jsonParseException) {
	    log.log(Level.SEVERE, null, jsonParseException);
	} catch (IOException iOException) {
	    log.log(Level.SEVERE, null, iOException);
	} catch (ExceptionHttpPersonalizada exceptionHttpPersonalizada) {
	    log.log(Level.SEVERE, null, exceptionHttpPersonalizada);
	}
	return new ArrayList<T>();
    }

    public <T> Object buscarPorId(ServiciosDisponibles servicio, String recursoSolicitado, int idBuscado) {
	StringBuilder cadenaRecursoCompleto = new StringBuilder();
	cadenaRecursoCompleto.append(recursoSolicitado);
	cadenaRecursoCompleto.append("/");
	cadenaRecursoCompleto.append(idBuscado);
	try {
	    return this.getProveedorGenericoObjetosREST().getObjeto(ClienteHttp.getInstancia().getCliente(), servicio, cadenaRecursoCompleto.toString());
	} catch (JsonMappingException jsonMappingException) {
	    log.log(Level.SEVERE, null, jsonMappingException);
	} catch (JsonParseException jsonParseException) {
	    log.log(Level.SEVERE, null, jsonParseException);
	} catch (IOException iOException) {
	    log.log(Level.SEVERE, null, iOException);
	} catch (ExceptionHttpPersonalizada exceptionHttpPersonalizada) {
	    log.log(Level.SEVERE, null, exceptionHttpPersonalizada);
	}
	return new Object();
    }

    public boolean crearNuevo(Object objetoACrear, ServiciosDisponibles servicio, String recursoSolicitado) {
	try {
	    this.getProveedorGenericoObjetosREST().postObjeto(ClienteHttp.getInstancia().getCliente(), servicio, recursoSolicitado, objetoACrear);
	    return true;
	} catch (NoSuchAlgorithmException noSuchAlgorithmException) {
	    log.log(Level.SEVERE, null, noSuchAlgorithmException);
	} catch (JsonMappingException jsonMappingException) {
	    log.log(Level.SEVERE, null, jsonMappingException);
	} catch (JsonParseException jsonParseException) {
	    log.log(Level.SEVERE, null, jsonParseException);
	} catch (IOException iOException) {
	    log.log(Level.SEVERE, null, iOException);
	} catch (ExceptionHttpPersonalizada exceptionHttpPersonalizada) {
	    log.log(Level.SEVERE, null, exceptionHttpPersonalizada);
	}
	return false;
    }

    public boolean eliminarElemento(Object objetoAEliminar, ServiciosDisponibles servicio, String recursoSolicitado) {
	try {
	    this.getProveedorGenericoObjetosREST().deleteObjeto(ClienteHttp.getInstancia().getCliente(), servicio, recursoSolicitado);
	    return true;
	} catch (JsonParseException jsonParseException) {
	    log.log(Level.SEVERE, null, jsonParseException);
	} catch (ExceptionHttpPersonalizada exceptionHttpPersonalizada) {
	    log.log(Level.SEVERE, null, exceptionHttpPersonalizada);
	}
	return false;
    }
    
    public boolean modificarVoluntario(ServiciosDisponibles servicio, String recursoSolicitado, Object objetoModificado) {
	try {
	    this.getProveedorGenericoObjetosREST().putObjeto(ClienteHttp.getInstancia().getCliente(), servicio, recursoSolicitado, objetoModificado);
	    return true;
	} catch (NoSuchAlgorithmException noSuchAlgorithmException) {
	    log.log(Level.SEVERE, null, noSuchAlgorithmException);
	} catch (JsonMappingException jsonMappingException) {
	    log.log(Level.SEVERE, null, jsonMappingException);
	} catch (JsonParseException jsonParseException) {
	    log.log(Level.SEVERE, null, jsonParseException);
	} catch (IOException iOException) {
	    log.log(Level.SEVERE, null, iOException);
	} catch (ExceptionHttpPersonalizada exceptionHttpPersonalizada) {
	    log.log(Level.SEVERE, null, exceptionHttpPersonalizada);
	}
	return false;
    }

    // ****************************** GETTERS y SETTERS *****************************//

    public ProveedorGenericoObjetosREST getProveedorGenericoObjetosREST() {
	if (this.proveedorGenericoObjetosREST == null) {
	    this.proveedorGenericoObjetosREST = new ProveedorGenericoObjetosREST();
	}
	return proveedorGenericoObjetosREST;
    }

    public void setProveedorGenericoObjetosREST(ProveedorGenericoObjetosREST proveedorGenericoObjetosREST) {
	this.proveedorGenericoObjetosREST = proveedorGenericoObjetosREST;
    }

}

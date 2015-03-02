package org.eleccion_comunal.servicios;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




import org.eleccion_comunal.exceptions.ExceptionHttpPersonalizada;
import org.eleccion_comunal.utilidades.CustomLogger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.sun.jersey.api.client.Client;

public class ProveedorGenericoObjetosREST {

    private static final Logger log = CustomLogger.getGeneralLogger(ProveedorGenericoObjetosREST.class.getName());
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public <T> Object getObjeto(Client client, ServiciosDisponibles servicio, String sufijo) throws JsonParseException, JsonMappingException, IOException, ExceptionHttpPersonalizada {

	String jsonString = ServicioClienteREST.getJSON(client, servicio, sufijo);
	if (jsonString != null) {
	    byte[] jsonData = jsonString.getBytes("UTF-8");

	    ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.setDateFormat(dateFormat);;

	    if (jsonString.substring(0, 1).equals("[")) {
		List<Object> obj = objectMapper.readValue(jsonData, TypeFactory.defaultInstance().constructCollectionType(List.class, servicio.getClase()));
		log.log(Level.INFO, "Object\n{0}", obj);
		return obj;
	    } else {
		Object obj = objectMapper.readValue(jsonData, servicio.getClase());
		log.log(Level.INFO, "Object\n{0}", obj);
		return obj;
	    }
	}
	return null;
    }

    public <T> Object postObjeto(Client client, ServiciosDisponibles servicio, String sufijo, String[] parametros) throws NoSuchAlgorithmException, JsonIOException, JsonParseException,
	    JsonMappingException, IOException, ExceptionHttpPersonalizada {
	String jsonString = ServicioClienteREST.postJSON(client, servicio, sufijo, parametros);
	// read json file data to String
	byte[] jsonData = jsonString.getBytes("UTF-8");
	// byte[] jsonData =
	// Files.readAllBytes(Paths.get("C:\\calendario.txt"));

	// create ObjectMapper instance
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.setDateFormat(dateFormat);

	// convert json string to object
	if (jsonString.substring(0, 1).equals("[")) {
	    List<Object> obj = objectMapper.readValue(jsonData, TypeFactory.defaultInstance().constructCollectionType(List.class, servicio.getClase()));
	    log.log(Level.INFO, "Object\n{0}", obj);
	    return obj;
	} else {
	    Object obj = objectMapper.readValue(jsonData, servicio.getClase());
	    log.log(Level.INFO, "Object\n{0}", obj);
	    return obj;
	}
    }

    public <T> Object postObjeto(Client client, ServiciosDisponibles servicio, String sufijo, Object JSON) throws NoSuchAlgorithmException, JsonIOException, JsonParseException, JsonMappingException,
	    IOException, ExceptionHttpPersonalizada {

	String jsonString = ServicioClienteREST.postJSON(client, servicio, sufijo, JSON);
	byte[] jsonData = jsonString.getBytes("UTF-8");
	ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	objectMapper.setDateFormat(dateFormat);
	
	if (jsonString.substring(0, 1).equals("[")) {
	    List<Object> obj = objectMapper.readValue(jsonData, TypeFactory.defaultInstance().constructCollectionType(List.class, servicio.getClase()));
	    log.log(Level.INFO, "Object\n{0}", obj);
	    return obj;
	} else {
	    Object obj = objectMapper.readValue(jsonData, servicio.getClase());
	    log.log(Level.INFO, "Object\n{0}", obj);
	    return obj;
	}
    }

    public boolean deleteObjeto(Client client, ServiciosDisponibles servicio, String sufijo) throws ExceptionHttpPersonalizada {
	return ServicioClienteREST.deleteJSON(client, servicio, sufijo);
    }

    public <T> Object putObjeto(Client client, ServiciosDisponibles servicio, String sufijo, Object JSON) throws NoSuchAlgorithmException, JsonIOException, JsonParseException, JsonMappingException,
	    IOException, ExceptionHttpPersonalizada {
	String jsonString = ServicioClienteREST.putJSON(client, servicio, sufijo, JSON);
	byte[] jsonData = jsonString.getBytes("UTF-8");
	ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	objectMapper.setDateFormat(dateFormat);
	
	if (jsonString.substring(0, 1).equals("[")) {
	    List<Object> obj = objectMapper.readValue(jsonData, TypeFactory.defaultInstance().constructCollectionType(List.class, servicio.getClase()));
	    log.log(Level.INFO, "Object\n{0}", obj);
	    return obj;
	} else {
	    Object obj = objectMapper.readValue(jsonData, servicio.getClase());
	    log.log(Level.INFO, "Object\n{0}", obj);
	    return obj;
	}
    }

}
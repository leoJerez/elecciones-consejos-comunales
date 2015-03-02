package org.eleccion_comunal.servicios;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.eleccion_comunal.exceptions.ExceptionHttpPersonalizada;
import org.eleccion_comunal.utilidades.CustomLogger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ServicioClienteREST {

    private static final Logger log = CustomLogger.getGeneralLogger(ServicioClienteREST.class.getName());

    public static String getJSON(Client client, ServiciosDisponibles servicio, String sufijo) throws ExceptionHttpPersonalizada {
	WebResource webResource = client.resource(servicio.getEndPoint() + sufijo);
	ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

	if (response.getStatus() != 200) {
	    throw new ExceptionHttpPersonalizada("Failed : HTTP error code : " + response.getStatus(), response.getStatus());
	}

	String output = response.getEntity(String.class);

	log.log(Level.INFO, "Output from Server .... \n");
	log.log(Level.INFO, output);
	return output;

    }

    public static String postJSON(Client client, ServiciosDisponibles servicio, String sufijo, String[] parametros) throws JsonIOException, UnsupportedEncodingException, NoSuchAlgorithmException,
	    ExceptionHttpPersonalizada {
	WebResource webResource = client.resource(servicio.getEndPoint() + sufijo);
	JSONObject object = new JSONObject();

	for (int i = 0; i < parametros.length; i++) {
	    try {
		object.put(parametros[i], parametros[++i]);
	    } catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, object.toString());

	if (response.getStatus() != 200 && response.getStatus() != 204) {
	    throw new ExceptionHttpPersonalizada("Failed : HTTP error code : " + response.getStatus(), response.getStatus());
	}

	String output = response.getEntity(String.class);

	log.log(Level.INFO, "Output from Server .... \n");
	log.log(Level.INFO, output);
	return output;
    }

    public static String postJSON(Client client, ServiciosDisponibles servicio, String sufijo, Object JSON) throws JsonIOException, UnsupportedEncodingException, NoSuchAlgorithmException,
	    ExceptionHttpPersonalizada {
	WebResource webResource = client.resource(servicio.getEndPoint() + sufijo);
	GsonBuilder gsonBuilder = new GsonBuilder();
	Gson gson = gsonBuilder.create();
	ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, gson.toJson(JSON));
	if (response.getStatus() != 200 && response.getStatus() != 204) {
	    throw new ExceptionHttpPersonalizada("Failed : HTTP error code : " + response.getStatus(), response.getStatus());
	}
	String output = response.getEntity(String.class);

	log.log(Level.INFO, "Output from Server .... \n");
	log.log(Level.INFO, output);
	return output;
    }

    public static boolean deleteJSON(Client client, ServiciosDisponibles servicio, String sufijo) throws ExceptionHttpPersonalizada {
	WebResource webResource = client.resource(servicio.getEndPoint() + sufijo);
	webResource.header("Accept-Encoding", "gzip");
	ClientResponse response = webResource.delete(ClientResponse.class);
	if (response.getStatus() != 200 && response.getStatus() != 204) {
	    throw new ExceptionHttpPersonalizada("Failed : HTTP error code : " + response.getStatus(), response.getStatus());
	} else {
	    return true;
	}
    }

    public static String putJSON(Client client, ServiciosDisponibles servicio, String sufijo, Object JSON) throws JsonIOException, UnsupportedEncodingException, NoSuchAlgorithmException,
	    ExceptionHttpPersonalizada {
	WebResource webResource = client.resource(servicio.getEndPoint() + sufijo);
	GsonBuilder gsonBuilder = new GsonBuilder();
	Gson gson = gsonBuilder.create();
	ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE).put(ClientResponse.class, gson.toJson(JSON));

	if (response.getStatus() != 200 && response.getStatus() != 204) {
	    throw new ExceptionHttpPersonalizada("Failed : HTTP error code : " + response.getStatus(), response.getStatus());
	}
	String output = response.getEntity(String.class);
	log.log(Level.INFO, "Output from Server .... \n");
	log.log(Level.INFO, output);
	return output;
    }
}

package org.eleccion_comunal.servicios;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ClienteHttp {

    private static ClienteHttp instancia;
    private Client cliente;

    private ClienteHttp() {
	ClientConfig config = new DefaultClientConfig();
	this.cliente = Client.create(config);
    }

    public static ClienteHttp getInstancia() {
	if (instancia == null) {
	    instancia = new ClienteHttp();
	}
	return instancia;
    }

    public Client getCliente() {
	return cliente;
    }

    public void setCliente(Client cliente) {
	this.cliente = cliente;
    }
}

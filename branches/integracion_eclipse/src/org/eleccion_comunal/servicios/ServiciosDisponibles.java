package org.eleccion_comunal.servicios;

import java.io.IOException;

import org.eleccion_comunal.utilidades.PropertiesLocator;


public enum ServiciosDisponibles {

    EVENTOS("End Point of Web Service", "/pathService", Object.class);

    private final String nombre;

    private final String endPoint;

    private final Class<?> clase;

    private StringBuilder ruta;

    private ServiciosDisponibles(String nombre, String endPoint, Class<?> clase) {
        this.nombre = nombre;
        ruta = new StringBuilder();
        ruta.append("http://").append(PropertiesLocator.getProperty("serverAddress")).append(":").append(PropertiesLocator.getProperty("serverPort")).append("/").append(PropertiesLocator.getProperty("backendContextRoot"));
        this.endPoint = ruta.toString()+endPoint;
        this.clase = clase;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public Class<?> getClase() {
        return clase;
    }

    public StringBuilder getRuta() throws IOException {
        ruta = new StringBuilder();
        ruta.append("http://").append(PropertiesLocator.getProperty("serverAddress")).append(":").append(PropertiesLocator.getProperty("serverPort")).append("/").append(PropertiesLocator.getProperty("backendContextRoot")).append("/rest");
        return ruta;
    }

    public void setRuta(StringBuilder ruta) {
        this.ruta = ruta;
    }
}

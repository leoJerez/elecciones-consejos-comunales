package org.eleccion_comunal.utilidades;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Esta clase esta hecha con la intension de contar con un unico objeto que se encargue de crear los mensajes para la interaccion con el usuario
 * @author Jose Leonardo Jerez
 */
public class GeneradorMensajes implements Serializable {

    private static final long serialVersionUID = -652323321332432L;
    private FacesContext context;
    private StringBuilder stringBuilder;
    private String tituloMensaje;

    private static GeneradorMensajes instancia;

    /**
     * Este metodo nos permite crear una unica instancia de esta clase desde cualquier otro objeto
     * @return GeneradorMensajes
     */
    public static GeneradorMensajes getInstancia() {
        if (instancia == null) {
            instancia = new GeneradorMensajes();
        }
        return instancia;
    }

    private GeneradorMensajes() {
        super();
    }

    /**
     * Este es metodo se encarga de construir y desplegar el mensaje que se mostrará, para ello necesita construir la cadena de caracteres a partir del
     * parametro listaCadenaConcatenar, la cual contiene en la posicion 0 el TITULO del mensaje y en los elementos siguientes está el detalle del mensaje
     * 
     * @param tipo. Se encarga de indicar el tipo de mensaje que se va a generar (I: informativo, E: error, A: advertencia, F: fatal)
     * @param listaCadenasConcatenar. Posee el contenido del mensaje (Posicon 0: titulo del mensaje, el resto de las posiciones contienen el detalle)
     */
    public void generarMensaje(char tipo, List<String> listaCadenasConcatenar) {
        int titulo = 0;
        for (String cadena : listaCadenasConcatenar) {
            if (titulo == 0) { //Obtenemos el titulo del mensaje (siempre debe estar en la posicion 0)
                this.setTituloMensaje(cadena);
            } else { //construimos el contenido del mensaje
                this.getStringBuilder().append(cadena);
            }
            titulo++;
        }

        switch (tipo) {
            case 'I': //Informativo
                this.getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, this.getTituloMensaje(), this.getStringBuilder().toString()));
                this.getStringBuilder().setLength(0);
                break;
            case 'E': //Error
                this.getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, this.getTituloMensaje(), this.getStringBuilder().toString()));
                this.getStringBuilder().setLength(0);
                break;
            case 'A': //Advertencia
                this.getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, this.getTituloMensaje(), this.getStringBuilder().toString()));
                this.getStringBuilder().setLength(0);
                break;
            case 'F': //Fatal
                this.getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, this.getTituloMensaje(), this.getStringBuilder().toString()));
                this.getStringBuilder().setLength(0);
                break;
        }
    }

    public StringBuilder getStringBuilder() {
        if (this.stringBuilder == null) {
            this.stringBuilder = new StringBuilder();
        }
        return stringBuilder;
    }

    public void setStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public FacesContext getContext() {
        this.context = FacesContext.getCurrentInstance();
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }

    public String getTituloMensaje() {
        return tituloMensaje;
    }

    public void setTituloMensaje(String tituloMensaje) {
        this.tituloMensaje = tituloMensaje;
    }

}

package org.eleccion_comunal.beans.controller;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PreDestroy;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

public class BaseBean implements Serializable {

    private static final long serialVersionUID = -5623951510676999987L;
    private final RequestContext context = RequestContext.getCurrentInstance();

    @PreDestroy
    public void destruir() {
    }

    public void redireccionar(String url) throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        if (url.contains("http")) {
            externalContext.redirect(url);
        } else {
            externalContext.redirect(externalContext.getRequestContextPath() + url);
        }
    }

    public void desplegarDialogo(String form, String dialogo) {
        context.update(new StringBuilder().append(form).append(":").append(dialogo).toString());
        context.execute(new StringBuilder().append(dialogo).append(".show()").toString());
    }

    public void cerrarDialogo(String form, String dialogo) {
        context.update(new StringBuilder().append(form).append(":").append(dialogo).toString());
        context.execute(new StringBuilder().append(dialogo).append(".hide()").toString());
    }

}

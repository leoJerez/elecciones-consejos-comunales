package org.eleccion_comunal.beans.request;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.eleccion_comunal.beans.controller.BaseBean;
import org.eleccion_comunal.beans.session.UsuarioSessionBean;
import org.eleccion_comunal.beans.view.PrincipalViewBean;
import org.eleccion_comunal.model.dao.UsuarioDAO;
import org.eleccion_comunal.model.dao.VecinoDAO;
import org.eleccion_comunal.model.dto.Usuario;
import org.eleccion_comunal.model.dto.Vecino;
import org.eleccion_comunal.utilidades.GeneradorMensajes;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "principalRequestBean")
@RequestScoped
public class PrincipalRequestBean extends BaseBean implements Serializable {

    private static final long serialVersionUID = 6310152595584201197L;

    @ManagedProperty(value = "#{usuarioSessionBean}")
    private UsuarioSessionBean usuarioSessionBean;

    @ManagedProperty(value = "#{principalViewBean}")
    private PrincipalViewBean principalViewBean;
    
    public void login() {
	HashMap<String, Object> propiedades = new HashMap<String, Object>();
	propiedades.put("login", this.getPrincipalViewBean().getLogin());
	propiedades.put("password", this.getPrincipalViewBean().getPassword());
	Usuario usuarioLogueado = (Usuario) UsuarioDAO.getInstancia().buscarEntidadPorPropiedades(propiedades);
	if (usuarioLogueado != null && usuarioLogueado.getIdUsuario() != null && usuarioLogueado.getIdUsuario() > 0) {
		System.out.println("LOGUEADO: "+usuarioLogueado.getLogin());
	    this.getUsuarioSessionBean().setUsuario(usuarioLogueado);
	    if (usuarioLogueado.getRol().getIdRol() >= 2) {
		this.getUsuarioSessionBean().setVecinoLogueado((Vecino) VecinoDAO.getInstancia().buscarEntidadPorPropiedad("usuario", usuarioLogueado));
	    }
	    RequestContext.getCurrentInstance().execute("login.hide()");
	    try {
		this.redireccionar("/faces/app/dashboard.xhtml");
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	} else {
	    List<String> cadenaMensaje = new ArrayList<String>();
	    cadenaMensaje.add("Usuario no encontrado");
	    cadenaMensaje.add("Verifique sus datos de acceso");
	    GeneradorMensajes.getInstancia().generarMensaje('E', cadenaMensaje);
	}
    }

    public UsuarioSessionBean getUsuarioSessionBean() {
        return usuarioSessionBean;
    }

    public void setUsuarioSessionBean(UsuarioSessionBean usuarioSessionBean) {
        this.usuarioSessionBean = usuarioSessionBean;
    }

    public PrincipalViewBean getPrincipalViewBean() {
        return principalViewBean;
    }

    public void setPrincipalViewBean(PrincipalViewBean principalViewBean) {
        this.principalViewBean = principalViewBean;
    }
}

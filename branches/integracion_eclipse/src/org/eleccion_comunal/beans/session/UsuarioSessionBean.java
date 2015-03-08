package org.eleccion_comunal.beans.session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.eleccion_comunal.model.dto.Usuario;
import org.eleccion_comunal.model.dto.Vecino;

@ManagedBean (name = "usuarioSessionBean")
@SessionScoped
public class UsuarioSessionBean {
    
    private Usuario usuario;
    private Vecino vecinoLogueado;
    
    
    @PostConstruct
    public void init() {
    }


    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public Vecino getVecinoLogueado() {
        return vecinoLogueado;
    }


    public void setVecinoLogueado(Vecino vecinoLogueado) {
        this.vecinoLogueado = vecinoLogueado;
    }
    
}

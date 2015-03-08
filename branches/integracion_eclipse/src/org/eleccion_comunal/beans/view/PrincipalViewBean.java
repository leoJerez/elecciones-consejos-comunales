package org.eleccion_comunal.beans.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.eleccion_comunal.model.dao.ConsejoComunalDAO;
import org.eleccion_comunal.model.dto.ConsejoComunal;

@ManagedBean (name = "principalViewBean")
@ViewScoped
public class PrincipalViewBean {

    private String login;
    private String password;
    
    private ConsejoComunal consejoComunal;
    
    @PostConstruct
    public void inti() {
	login = "";
	password = "";
	this.setConsejoComunal( (ConsejoComunal) ConsejoComunalDAO.getInstancia().buscarEntidadPorClave(1));
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ConsejoComunal getConsejoComunal() {
	if (consejoComunal == null) {
	    consejoComunal = new ConsejoComunal();
	}
        return consejoComunal;
    }

    public void setConsejoComunal(ConsejoComunal consejoComunal) {
        this.consejoComunal = consejoComunal;
    }
}

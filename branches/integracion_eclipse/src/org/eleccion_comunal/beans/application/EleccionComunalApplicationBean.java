package org.eleccion_comunal.beans.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.eleccion_comunal.model.dao.ConsejoComunalDAO;
import org.eleccion_comunal.model.dto.ConsejoComunal;

@ManagedBean(name = "eleccionComunalApplicationBean")
@ApplicationScoped
public class EleccionComunalApplicationBean implements Serializable {

    private List<ConsejoComunal> listaConsejosComunales;
    private ConsejoComunal consejoComunal;

    public EleccionComunalApplicationBean() {
	super();
    }

    @PostConstruct
    public void init() {
	this.getListaConsejosComunales().addAll(ConsejoComunalDAO.getInstancia().buscarTodasEntidades());
	this.setConsejoComunal(this.getListaConsejosComunales().get(0));
    }

    public List<ConsejoComunal> getListaConsejosComunales() {
	if (listaConsejosComunales == null) {
	    listaConsejosComunales = new ArrayList<ConsejoComunal>();
	}
	return listaConsejosComunales;
    }

    public void setListaConsejosComunales(List<ConsejoComunal> listaConsejosComunales) {
	this.listaConsejosComunales = listaConsejosComunales;
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

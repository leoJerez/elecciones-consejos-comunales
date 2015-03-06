/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.eleccion_comunal.beans.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.eleccion_comunal.model.dao.ConsejoComunalDAO;
import org.eleccion_comunal.model.dao.ViviendaDAO;
import org.eleccion_comunal.model.dto.ConsejoComunal;
import org.eleccion_comunal.model.dto.Vivienda;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Roberth
 */
@ManagedBean(name = "viviendaViewBean")
@ViewScoped
public class ViviendaViewBean implements Serializable {

	private Vivienda newVivienda;
	private Vivienda viviendaSelected;
	private List<Vivienda> listaDeViviendas;
	private List<ConsejoComunal> listaConsejosComunales;

	@PostConstruct
	public void init() {
		this.getListaDeViviendas().addAll(
				ViviendaDAO.getInstancia().buscarTodasEntidades());
		this.getListaConsejosComunales().addAll(
				ConsejoComunalDAO.getInstancia().buscarTodasEntidades());
	}

	public ViviendaViewBean() {
	}

	public Vivienda getNewVivienda() {
		if (newVivienda == null) {
			newVivienda = new Vivienda();
		}
		return newVivienda;
	}

	public void setNewVivienda(Vivienda newVivienda) {
		this.newVivienda = newVivienda;
	}

	public Vivienda getViviendaSelected() {
		if(viviendaSelected == null){
			viviendaSelected = new Vivienda();
		}
		return viviendaSelected;
	}

	public void setViviendaSelected(Vivienda viviendaSelected) {
		this.viviendaSelected = viviendaSelected;
	}

	public List<Vivienda> getListaDeViviendas() {
		if (listaDeViviendas == null) {
			listaDeViviendas = new ArrayList<Vivienda>();
		}
		return listaDeViviendas;
	}

	public void setListaDeViviendas(List<Vivienda> listaDeViviendas) {
		this.listaDeViviendas = listaDeViviendas;
	}

	public List<ConsejoComunal> getListaConsejosComunales() {
		if (listaConsejosComunales == null) {
			listaConsejosComunales = new ArrayList<ConsejoComunal>();
		}
		return listaConsejosComunales;
	}

	public void setListaConsejosComunales(
			List<ConsejoComunal> listaConsejosComunales) {
		this.listaConsejosComunales = listaConsejosComunales;
	}

	public void guardarVivienda() {
		if (newVivienda != null) {
			boolean existe = false;
			for (Vivienda vivienda : this.listaDeViviendas) {
				if (vivienda.getNumeroCasa().equals(
						this.getNewVivienda().getNumeroCasa())) {
					existe = true;
					break;
				}
			}
			if (!existe) {
				this.getNewVivienda().setConsejoComunal(this.listaConsejosComunales.get(0));
				this.getListaDeViviendas().add(this.getNewVivienda());
				ViviendaDAO.getInstancia().actualizar(this.getNewVivienda());
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion Exitosa", "Se ha registrado una vivienda"));
                RequestContext.getCurrentInstance().update("formVivienda:growl");
                RequestContext.getCurrentInstance().update("formVivienda");
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operacion Fallida", "La vivienda ya existe, por favor verifique el numero de casa"));
                RequestContext.getCurrentInstance().update("formVivienda:growl");
                RequestContext.getCurrentInstance().update("formVivienda");
			}
		}
	}
	
	public void editarVivienda(){
		if(viviendaSelected != null){
			ViviendaDAO.getInstancia().actualizar(this.getViviendaSelected());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion Exitosa", "Vivienda Actualizada"));
            RequestContext.getCurrentInstance().update("formVivienda:growl");
            RequestContext.getCurrentInstance().update("formVivienda");
		}
	}
	
	public void eliminarVivienda(){
		if(viviendaSelected != null){
			ViviendaDAO.getInstancia().eliminarLogicamente(this.getViviendaSelected());
			this.getListaDeViviendas().remove(this.getViviendaSelected());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion Exitosa", "Se elimino una vivienda"));
            RequestContext.getCurrentInstance().update("formVivienda:growl");
            RequestContext.getCurrentInstance().update("formVivienda");
		}
	}
}

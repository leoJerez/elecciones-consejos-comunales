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
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.eleccion_comunal.beans.application.EleccionComunalApplicationBean;
import org.eleccion_comunal.model.dao.VehiculoDAO;
import org.eleccion_comunal.model.dao.VehiculoViviendaDAO;
import org.eleccion_comunal.model.dao.ViviendaDAO;
import org.eleccion_comunal.model.dto.Vehiculo;
import org.eleccion_comunal.model.dto.VehiculoVivienda;
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
	private Vehiculo nuevoVehiculo;
	private VehiculoVivienda vehiculoSelected;
	private boolean agregarVehiculo;

	@ManagedProperty(value = "#{eleccionComunalApplicationBean}")
	private EleccionComunalApplicationBean eleccionComunalApplicationBean;

	@PostConstruct
	public void init() {
		this.getListaDeViviendas().addAll(
				ViviendaDAO.getInstancia().buscarTodasEntidades());
		this.setAgregarVehiculo(false);
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
		if (viviendaSelected == null) {
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

	public Vehiculo getNuevoVehiculo() {
		if (nuevoVehiculo == null) {
			nuevoVehiculo = new Vehiculo();
		}
		return nuevoVehiculo;
	}

	public VehiculoVivienda getVehiculoSelected() {
		if (vehiculoSelected == null) {
			vehiculoSelected = new VehiculoVivienda();
		}
		return vehiculoSelected;
	}

	public void setVehiculoSelected(VehiculoVivienda vehiculoSelected) {
		this.vehiculoSelected = vehiculoSelected;
	}

	public void setNuevoVehiculo(Vehiculo nuevoVehiculo) {
		this.nuevoVehiculo = nuevoVehiculo;
	}

	public boolean isAgregarVehiculo() {
		return agregarVehiculo;
	}

	public void setAgregarVehiculo(boolean agregarVehiculo) {
		this.agregarVehiculo = agregarVehiculo;
	}

	public EleccionComunalApplicationBean getEleccionComunalApplicationBean() {
		if (eleccionComunalApplicationBean == null) {
			eleccionComunalApplicationBean = new EleccionComunalApplicationBean();
		}
		return eleccionComunalApplicationBean;
	}

	public void setEleccionComunalApplicationBean(
			EleccionComunalApplicationBean eleccionComunalApplicationBean) {
		this.eleccionComunalApplicationBean = eleccionComunalApplicationBean;
	}

	public void guardarVivienda() {
		if (newVivienda != null) {
			boolean existe = false;
			for (Vivienda vivienda : this.getListaDeViviendas()) {
				if (vivienda.getNumeroCasa().equals(
						this.getNewVivienda().getNumeroCasa())) {
					existe = true;
					break;
				}
			}
			if (!existe) {
				this.getNewVivienda().setConsejoComunal(
						this.getEleccionComunalApplicationBean()
								.getConsejoComunal());
				this.getListaDeViviendas().add(this.getNewVivienda());
				ViviendaDAO.getInstancia().actualizar(this.getNewVivienda());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Operacion Exitosa",
								"Se ha registrado una vivienda"));
				RequestContext.getCurrentInstance()
						.update("formVivienda:growl");
				RequestContext.getCurrentInstance().update("formVivienda");
			} else {
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR,
										"Operacion Fallida",
										"La vivienda ya existe, por favor verifique el numero de casa"));
				RequestContext.getCurrentInstance()
						.update("formVivienda:growl");
				RequestContext.getCurrentInstance().update("formVivienda");
			}
		}
	}

	public void editarVivienda() {
		if (viviendaSelected != null) {
			ViviendaDAO.getInstancia().actualizar(this.getViviendaSelected());
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Operacion Exitosa", "Vivienda Actualizada"));
			RequestContext.getCurrentInstance().update("formVivienda:growl");
			RequestContext.getCurrentInstance().update("formVivienda");
		}
	}

	public void eliminarVivienda() {
		if (viviendaSelected != null) {
			ViviendaDAO.getInstancia().eliminarLogicamente(
					this.getViviendaSelected());
			this.getListaDeViviendas().remove(this.getViviendaSelected());
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Operacion Exitosa", "Se elimino una vivienda"));
			RequestContext.getCurrentInstance().update("formVivienda:growl");
			RequestContext.getCurrentInstance().update("formVivienda");
		}
	}

	public void cargarPanelVehiculo() {
		this.setAgregarVehiculo(true);
	}

	public void agregarVehiculo() {
		if (this.getNuevoVehiculo() != null) {
			System.out.print("Iniciando Carga...");
			VehiculoVivienda propiedades = new VehiculoVivienda();
			propiedades.setVivienda(this.getViviendaSelected());
			System.out.print("agrego vivienda");
			propiedades.setVehiculo(this.getNuevoVehiculo());
			System.out.print("agrego vehiculo");
			VehiculoViviendaDAO.getInstancia().actualizar(propiedades);
			this.getViviendaSelected().getVehiculoViviendas().add(propiedades);
			System.out.print("agrego propiedad a la vivienda seleccionada");
		}
	}

	public void eliminarVehiculo() {
		System.out.print("Esta nul");
		if (vehiculoSelected != null) {
			System.out.print("Paso por aqui");
			VehiculoViviendaDAO.getInstancia().eliminarFisicamente(
					this.getVehiculoSelected());
			System.out.print("Elimino la Relacion");
			VehiculoDAO.getInstancia().eliminarFisicamente(
					getVehiculoSelected().getVehiculo());
			this.getViviendaSelected().getVehiculoViviendas()
					.remove(this.getVehiculoSelected());
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Operacion Exitosa", "Se elimino el vehiculo"));
			RequestContext.getCurrentInstance().update("formVivienda:growl");
			RequestContext.getCurrentInstance().update(
					"formVivienda:contenidoEditar");

		}
	}
}

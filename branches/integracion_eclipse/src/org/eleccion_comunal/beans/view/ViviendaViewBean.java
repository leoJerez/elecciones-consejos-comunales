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
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.eleccion_comunal.model.dao.ConsejoComunalDAO;
import org.eleccion_comunal.model.dao.VehiculoDAO;
import org.eleccion_comunal.model.dao.VehiculoViviendaDAO;
import org.eleccion_comunal.model.dao.ViviendaDAO;
import org.eleccion_comunal.model.dto.ConsejoComunal;
import org.eleccion_comunal.model.dto.EntidadGenerica;
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
	
	private static final long serialVersionUID = 187L;
	private Vivienda newVivienda;
	private Vivienda viviendaSelected;
	private List<Vivienda> listaDeViviendas;
	private List<Vehiculo> listaDeVehiculos;
	private List<Vehiculo> listaDeVehiculosEditar;
	private List<VehiculoVivienda> listaDePropiedades;
	private Vehiculo nuevoVehiculo;
	private VehiculoVivienda vehiculoSelected;
	private boolean agregarVehiculo;

	@PostConstruct
	public void init() {
		this.viviendaSelected = new Vivienda();
		this.getListaDeViviendas().addAll(
				ViviendaDAO.getInstancia().buscarTodasEntidades());
		this.getListaDeVehiculos().addAll(
				VehiculoDAO.getInstancia().buscarTodasEntidades());
//		this.getListaDePropiedades().addAll(
//				);
		this.setAgregarVehiculo(false);
		obtenerVehiculosDeLaVivienda();
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

	public List<Vehiculo> getListaDeVehiculos() {
		if (listaDeVehiculos == null) {
			listaDeVehiculos = new ArrayList<Vehiculo>();
		}
		return listaDeVehiculos;
	}

	public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
		this.listaDeVehiculos = listaDeVehiculos;
	}

	public List<Vehiculo> getListaDeVehiculosEditar() {
		if (listaDeVehiculosEditar == null) {
			listaDeVehiculosEditar = new ArrayList<Vehiculo>();
		}
		return listaDeVehiculosEditar;
	}

	public void setListaDeVehiculosEditar(List<Vehiculo> listaDeVehiculosEditar) {
		this.listaDeVehiculosEditar = listaDeVehiculosEditar;
	}

	public List<VehiculoVivienda> getListaDePropiedades() {
		if (listaDePropiedades == null) {
			listaDePropiedades = new ArrayList<VehiculoVivienda>();
		}
		return listaDePropiedades;
	}

	public void setListaDePropiedades(List<VehiculoVivienda> listaDePropiedades) {
		this.listaDePropiedades = listaDePropiedades;
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
						(ConsejoComunal) ConsejoComunalDAO.getInstancia()
								.buscarEntidadPorClave(1));
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

	public void editarVivienda(Vivienda vivienda) {
		if (viviendaSelected != null && vivienda.getIdVivienda() != null) {
			ViviendaDAO.getInstancia().actualizar(vivienda);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Operacion Exitosa", "Vivienda Actualizada"));
			RequestContext.getCurrentInstance().update("formVivienda:growl");
			RequestContext.getCurrentInstance().update("formVivienda");
		}
	}

	public boolean existeVehiculo(Vehiculo vehiculo) {
		boolean exist = false;
		for (Vehiculo vehiculoBD : this.getListaDeVehiculos()) {
			if (vehiculoBD.getPlaca().equals(vehiculo.getPlaca())) {
				exist = true;
				break;
			}
		}
		return exist;
	}

	public void eliminarVivienda(Vivienda vivienda) {
		if (viviendaSelected != null) {
			ViviendaDAO.getInstancia().eliminarLogicamente(vivienda);
			this.getListaDeViviendas().remove(vivienda);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Operacion Exitosa", "Se elimino una vivienda"));
			RequestContext.getCurrentInstance().update("formVivienda:growl");
			RequestContext.getCurrentInstance().update("formVivienda");
		}
	}

	public void desplegarDialogoEditar(Vivienda vivienda) {
		this.setViviendaSelected(vivienda);
		obtenerVehiculosDeLaVivienda();
		RequestContext.getCurrentInstance().execute(
				"PF('editarVivienda').show()");
	}

	public void cargarPanelVehiculo() {
		System.out.print("Datos>> " + getViviendaSelected().getIdVivienda()
				+ " " + getViviendaSelected().getCalle() + " "
				+ getViviendaSelected().getNombreCasa());
		this.setAgregarVehiculo(true);
	}

	public void agregarVehiculo() {
		if (this.getNuevoVehiculo() != null) {
			if (!existeVehiculo(this.getNuevoVehiculo())) {
				VehiculoVivienda propiedades = new VehiculoVivienda();
				propiedades.setVivienda(this.getViviendaSelected());
				Vehiculo vehiculo = (Vehiculo) VehiculoDAO.getInstancia().actualizar(this.getNuevoVehiculo());
				propiedades.setVehiculo(vehiculo);
				propiedades = (VehiculoVivienda) VehiculoViviendaDAO.getInstancia().actualizar(propiedades);
				this.getViviendaSelected().getVehiculoViviendas()
						.add(propiedades);
				this.setNuevoVehiculo(new Vehiculo());
				obtenerVehiculosDeLaVivienda();
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Operacion Exitosa",
								"Se agrego un nuevo vehiculo"));
				RequestContext.getCurrentInstance()
						.update("formVivienda:growl");
				RequestContext.getCurrentInstance().update(
						"formVivienda:pnlEditarVivienda");
			} else {
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR,
										"Operacion Fallida",
										"Ya existe un vehiculo con este numero de placa, por favor verifique"));
				RequestContext.getCurrentInstance()
						.update("formVivienda:growl");
			}
		}
	}

	public void eliminarVehiculo(Vehiculo vehiculo) {
		System.out.println("ID CARRO ELIMINAR -> "+vehiculo.getIdVehiculo());
		if (vehiculo != null) {
//			VehiculoVivienda propiedad = (VehiculoVivienda) VehiculoViviendaDAO.getInstancia().buscarEntidadPorPropiedad("vehiculo", vehiculo);
//			System.out.println("ID CARRO ELIMINAR -> "+propiedad.getIdVehiculoVivienda());
//			VehiculoViviendaDAO.getInstancia().eliminarFisicamente(propiedad);
			VehiculoDAO.getInstancia().eliminarLogicamente(
					vehiculo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Operacion Exitosa", "Se elimino el vehiculo"));
			RequestContext.getCurrentInstance().update("formVivienda:growl");
			RequestContext.getCurrentInstance().update(
					"formVivienda:contenidoEditar");
		}
	}

	public void obtenerVehiculosDeLaVivienda() {
		List<VehiculoVivienda> lista = (List<VehiculoVivienda>) VehiculoViviendaDAO.getInstancia().buscarTodasEntidades();
		for (VehiculoVivienda propiedad : lista) {
			if (propiedad.getVivienda().getIdVivienda()
					.equals(this.getViviendaSelected().getIdVivienda())) {
				if(!this.getListaDeVehiculosEditar().contains(propiedad.getVehiculo())){
					if(propiedad.getVehiculo().getStatus().equals(EntidadGenerica.DATA_ACTIVA)){
						this.getListaDeVehiculosEditar().add(propiedad.getVehiculo());
					}
				}
			}
		}
	}
}

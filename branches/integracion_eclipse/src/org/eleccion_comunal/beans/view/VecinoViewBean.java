/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eleccion_comunal.beans.view;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.eleccion_comunal.enums.Sexo;
import org.eleccion_comunal.enums.Status;
import org.eleccion_comunal.model.dao.VecinoDAO;
import org.eleccion_comunal.model.dao.ViviendaDAO;
import org.eleccion_comunal.model.dto.Vecino;
import org.eleccion_comunal.model.dto.Vivienda;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Roberth Borges
 */
@ManagedBean(name = "vecinoViewBean")
@ViewScoped
public class VecinoViewBean implements Serializable {

    private Vecino newVecino;
    private Vecino VecinoSelected;
    private List<Vecino> listaDeVecinos;
    private List<Vecino> listaDeVecinosActivos;
    private List<Vivienda> listaDeViviendas;
    private String nacionalidadSelected;

    @PostConstruct
    public void init() {
	this.getListaDeVecinosActivos().addAll(VecinoDAO.getInstancia().buscarTodasEntidades());
        this.getListaDeViviendas().addAll(ViviendaDAO.getInstancia().buscarTodasEntidades());
    }

    public VecinoViewBean() {
    }

    public Vecino getNewVecino() {
        if (newVecino == null) {
            newVecino = new Vecino();
        }
        return newVecino;
    }

    public void setNewVecino(Vecino newVecino) {
        this.newVecino = newVecino;
    }

    public Vecino getVecinoSelected() {
        if (VecinoSelected == null) {
            VecinoSelected = new Vecino();
        }
        return VecinoSelected;
    }

    public void setVecinoSelected(Vecino VecinoSelected) {
        this.VecinoSelected = VecinoSelected;
    }

    public List<Vecino> getListaDeVecinos() {
        if (listaDeVecinos == null) {
            listaDeVecinos = new ArrayList<Vecino>();
        }
        return listaDeVecinos;
    }

    public void setListaDeVecinos(List<Vecino> listaDeVecinos) {
        this.listaDeVecinos = listaDeVecinos;
    }

    public List<Vecino> getListaDeVecinosActivos() {
        if (listaDeVecinosActivos == null) {
            listaDeVecinosActivos = new ArrayList<Vecino>();
        }
        return listaDeVecinosActivos;
    }

    public void setListaDeVecinosActivos(List<Vecino> listaDeVecinosActivos) {
        this.listaDeVecinosActivos = listaDeVecinosActivos;
    }

    public List<Vivienda> getListaDeViviendas() {
        if(listaDeViviendas == null){
            listaDeViviendas = new ArrayList<Vivienda>();
        }
        return listaDeViviendas;
    }

    public void setListaDeViviendas(List<Vivienda> listaDeViviendas) {
        this.listaDeViviendas = listaDeViviendas;
    }

    public String getNacionalidadSelected() {
        return nacionalidadSelected;
    }

    public void setNacionalidadSelected(String nacionalidadSelected) {
        this.nacionalidadSelected = nacionalidadSelected;
    }

    public void guardarVecino() {
        if (this.newVecino != null) {
            if (this.getNewVecino().getCedula() != null && this.getNewVecino().getNombre() != null && this.getNewVecino().getApellido() != null
        	    && this.getNewVecino().getCorreo() != null && this.getNewVecino().getFechaNacimiento() != null) {
                if (!cedulaExiste(this.getNewVecino())) {
                    if (!correoExiste(this.getNewVecino())) {
                        StringBuilder cedulaNacionalidad = new StringBuilder();
                        cedulaNacionalidad.append(this.getNacionalidadSelected());
                        cedulaNacionalidad.append("-");
                        cedulaNacionalidad.append(this.getNewVecino().getCedula());
                        this.getNewVecino().setCedula(cedulaNacionalidad.toString());
                        this.getNewVecino().setStatus(Status.STATUS_ACTIVO.getValor());
                        VecinoDAO.getInstancia().actualizar(this.getNewVecino());
                        this.getListaDeVecinosActivos().add(this.getNewVecino());
                    } else {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operacion Fallida", "La cedula del Vecino ya existe"));
                        RequestContext.getCurrentInstance().update("formVecino:growl");
                        RequestContext.getCurrentInstance().update("formVecino");
                    }
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operacion Fallida", "El correo del Vecino ya existe"));
                    RequestContext.getCurrentInstance().update("formVecino:growl");
                    RequestContext.getCurrentInstance().update("formVecino");
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operacion Fallida", "Debe llenar todos los campos marcados con (*)"));
                RequestContext.getCurrentInstance().update("formVecino:growl");
                RequestContext.getCurrentInstance().update("formVecino");
            }
        }
    }

    public void editarVecino() {
        if (this.VecinoSelected != null) {
            if (!correoExiste(this.getVecinoSelected())) {
        	VecinoDAO.getInstancia().actualizar(this.getVecinoSelected());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion Exitosa", " Se ha editado el Vecino"));
                RequestContext.getCurrentInstance().update("formVecino");
                RequestContext.getCurrentInstance().update("formVecino:growl");
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operacion Fallida", "El correo del Vecino ya existe"));
                RequestContext.getCurrentInstance().update("formVecino:growl");
            }
        }
    }

    public void eliminarVecino() {
        if (this.VecinoSelected != null) {
            VecinoDAO.getInstancia().eliminarLogicamente(this.getVecinoSelected());
            this.getListaDeVecinosActivos().remove(this.getVecinoSelected());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion Exitosa", " Se eliminado el Vecino"));
            RequestContext.getCurrentInstance().update("formVecino");
        }
    }

    public String formatShortDate(Vecino Vecino) {
        DateFormat formatoFechaShort = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("es", "VE"));
        return formatoFechaShort.format(Vecino.getFechaNacimiento());
    }

    public boolean cedulaExiste(Vecino nuevoVecino) {
        boolean existe = false;
        for (Vecino Vecino : this.getListaDeVecinosActivos()) {
            if (Vecino.getCedula().equalsIgnoreCase(this.getNewVecino().getCedula())) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public boolean correoExiste(Vecino nuevoVecino) {
        boolean existe = false;
        for (Vecino Vecino : this.getListaDeVecinosActivos()) {
            if (Vecino.getCorreo().equalsIgnoreCase(this.getNewVecino().getCorreo())) {
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    public Sexo[] getSexoVecino(){
        return Sexo.values();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bdaplication.controllers.view;

import com.mycompany.backend.bdapplication.business.delegate.HabitanteDelegate;
import com.mycompany.backend.bdapplication.business.dto.HabitanteDTO;
import com.mycompany.backend.bdapplication.business.enums.Sexo;
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
import org.primefaces.context.RequestContext;

/**
 *
 * @author Roberth
 */
@ManagedBean(name = "habitanteViewBean")
@ViewScoped
public class HabitanteViewBean implements Serializable {

    private HabitanteDTO newHabitante;
    private HabitanteDTO habitanteSelected;
    private List<HabitanteDTO> listaDeHabitantes;
    private List<HabitanteDTO> listaDeHabitantesActivos;
    private String nacionalidadSelected;

    @PostConstruct
    public void init() {
        this.setListaDeHabitantes(new HabitanteDelegate().findAllHabitante());
        for (HabitanteDTO habitanteDTO : this.getListaDeHabitantes()) {
            if (habitanteDTO.getEstatus().equals("A")) {
                this.getListaDeHabitantesActivos().add(habitanteDTO);
            }
        }
    }

    public HabitanteViewBean() {
    }

    public HabitanteDTO getNewHabitante() {
        if (newHabitante == null) {
            newHabitante = new HabitanteDTO();
        }
        return newHabitante;
    }

    public void setNewHabitante(HabitanteDTO newHabitante) {
        this.newHabitante = newHabitante;
    }

    public HabitanteDTO getHabitanteSelected() {
        if (habitanteSelected == null) {
            habitanteSelected = new HabitanteDTO();
        }
        return habitanteSelected;
    }

    public void setHabitanteSelected(HabitanteDTO habitanteSelected) {
        this.habitanteSelected = habitanteSelected;
    }

    public List<HabitanteDTO> getListaDeHabitantes() {
        if (listaDeHabitantes == null) {
            listaDeHabitantes = new ArrayList<>();
        }
        return listaDeHabitantes;
    }

    public void setListaDeHabitantes(List<HabitanteDTO> listaDeHabitantes) {
        this.listaDeHabitantes = listaDeHabitantes;
    }

    public List<HabitanteDTO> getListaDeHabitantesActivos() {
        if (listaDeHabitantesActivos == null) {
            listaDeHabitantesActivos = new ArrayList<>();
        }
        return listaDeHabitantesActivos;
    }

    public void setListaDeHabitantesActivos(List<HabitanteDTO> listaDeHabitantesActivos) {
        this.listaDeHabitantesActivos = listaDeHabitantesActivos;
    }

    public String getNacionalidadSelected() {
        return nacionalidadSelected;
    }

    public void setNacionalidadSelected(String nacionalidadSelected) {
        this.nacionalidadSelected = nacionalidadSelected;
    }

    public void guardarHabitante() {
        if (this.newHabitante != null) {
            if (this.getNewHabitante().getCedula() != null && this.getNewHabitante().getNombre() != null && this.getNewHabitante().getApellido() != null
                    && this.getNewHabitante().getNumeroCasa() != null && this.getNewHabitante().getCorreo() != null && this.getNewHabitante().getFechaNacimiento() != null) {
                if (!cedulaExiste(this.getNewHabitante())) {
                    if (!correoExiste(this.getNewHabitante())) {
                        StringBuilder cedulaNacionalidad = new StringBuilder();
                        cedulaNacionalidad.append(this.getNacionalidadSelected());
                        cedulaNacionalidad.append("-");
                        cedulaNacionalidad.append(this.getNewHabitante().getCedula());
                        this.getNewHabitante().setCedula(cedulaNacionalidad.toString());
                        this.getNewHabitante().setEstatus("A");
                        new HabitanteDelegate().create(this.getNewHabitante());
                        this.getListaDeHabitantes().add(this.getNewHabitante());
                    } else {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operacion Fallida", "La cedula del habitante ya existe"));
                        RequestContext.getCurrentInstance().update("formHabitante:growl");
                        RequestContext.getCurrentInstance().update("formHabitante");
                    }
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operacion Fallida", "El correo del habitante ya existe"));
                    RequestContext.getCurrentInstance().update("formHabitante:growl");
                    RequestContext.getCurrentInstance().update("formHabitante");
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operacion Fallida", "Debe llenar todos los campos marcados con (*)"));
                RequestContext.getCurrentInstance().update("formHabitante:growl");
                RequestContext.getCurrentInstance().update("formHabitante");
            }
        }
    }

    public void editarHabitante() {
        if (this.habitanteSelected != null) {
            if (!correoExiste(this.getHabitanteSelected())) {
                new HabitanteDelegate().edit(this.getHabitanteSelected());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion Exitosa", " Se ha editado el habitante"));
                RequestContext.getCurrentInstance().update("formHabitante");
                RequestContext.getCurrentInstance().update("formHabitante:growl");
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operacion Fallida", "El correo del habitante ya existe"));
                RequestContext.getCurrentInstance().update("formHabitante:growl");
            }
        }
    }

    public void eliminarHabitante() {
        if (this.habitanteSelected != null) {
            this.getHabitanteSelected().setEstatus("I");
            new HabitanteDelegate().edit(this.getHabitanteSelected());
            this.getListaDeHabitantesActivos().remove(this.getHabitanteSelected());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion Exitosa", " Se eliminado el habitante"));
            RequestContext.getCurrentInstance().update("formHabitante");
        }
    }

    public String formatShortDate(HabitanteDTO habitante) {
        DateFormat formatoFechaShort = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("es", "VE"));
        return formatoFechaShort.format(habitante.getFechaNacimiento());
    }

    public boolean cedulaExiste(HabitanteDTO nuevoHabitante) {
        boolean existe = false;
        for (HabitanteDTO habitante : this.getListaDeHabitantesActivos()) {
            if (habitante.getCedula().equalsIgnoreCase(this.getNewHabitante().getCedula())) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public boolean correoExiste(HabitanteDTO nuevoHabitante) {
        boolean existe = false;
        for (HabitanteDTO habitante : this.getListaDeHabitantesActivos()) {
            if (habitante.getCorreo().equalsIgnoreCase(this.getNewHabitante().getCorreo())) {
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    public Sexo[] getSexoHabitante(){
        return Sexo.values();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bdaplication.controllers.view;

import com.mycompany.backend.bdapplication.business.delegate.EstadoDelegate;
import com.mycompany.backend.bdapplication.business.dto.EstadoDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Roberth
 */
@ManagedBean(name = "estadoViewBean")
@ViewScoped
public class EstadoViewBean implements Serializable {

    private EstadoDTO estadoSelected;
    private List<EstadoDTO> listaEstadosTodos;
    private List<EstadoDTO> listaEstados;
    private EstadoDTO e1, e2, e3;
    boolean guardar, editar, eliminar;

    public EstadoViewBean() {

    }

    @PostConstruct
    public void init() {
        this.setListaEstadosTodos(new ArrayList<EstadoDTO>());
        this.setListaEstadosTodos(new EstadoDelegate().findAllEstado());
//        e1 = new EstadoDTO();
//        e2 = new EstadoDTO();
//        e3 = new EstadoDTO();
        this.setGuardar(true);
        this.setEditar(true);
        this.setEliminar(true);
//        cargarEstados();
    }

    public EstadoDTO getEstadoSelected() {
        if (estadoSelected == null) {
            estadoSelected = new EstadoDTO();
        }
        return estadoSelected;
    }

    public void setEstadoSelected(EstadoDTO estado) {
        this.estadoSelected = estado;
    }

    public List<EstadoDTO> getListaEstadosTodos() {
        if (listaEstadosTodos == null) {
            listaEstadosTodos = new ArrayList<>();
        }
        return listaEstadosTodos;
    }

    public void setListaEstadosTodos(List<EstadoDTO> listaEstadosTodos) {
        this.listaEstadosTodos = listaEstadosTodos;
    }

    public List<EstadoDTO> getListaEstados() {
        if (listaEstados == null) {
            listaEstados = new ArrayList<>();
        }
        return listaEstados;
    }

    public void setListaEstados(List<EstadoDTO> listaEstados) {
        this.listaEstados = listaEstados;
    }

//    public EstadoDTO getE1() {
//        return e1;
//    }
//
//    public void setE1(EstadoDTO e1) {
//        this.e1 = e1;
//    }
//
//    public EstadoDTO getE2() {
//        return e2;
//    }
//
//    public void setE2(EstadoDTO e2) {
//        this.e2 = e2;
//    }
//
//    public EstadoDTO getE3() {
//        return e3;
//    }
//
//    public void setE3(EstadoDTO e3) {
//        this.e3 = e3;
//    }
    public boolean isGuardar() {
        return guardar;
    }

    public void setGuardar(boolean guardar) {
        this.guardar = guardar;
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    public boolean isEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    public void cargarEstados() {

//        e1.setId(1);
//        e1.setCodigo("001");
//        e1.setNombre("LARA");
//        e2.setId(2);
//        e2.setCodigo("002");
//        e2.setNombre("CARABOBO");
//        e3.setId(3);
//        e3.setCodigo("003");
//        e3.setNombre("ZULIA");
//        this.getListaEstados().add(e1);
//        this.getListaEstados().add(e2);
//        this.getListaEstados().add(e3);
    }

    public void botonGuardar() {
        System.out.println("ESTA ACTIVO");
        if (this.getEstadoSelected().getCodigo() != null && this.getEstadoSelected().getNombre() != null) {
            if (!this.getListaEstados().isEmpty()) {
                boolean state = false;
                for (EstadoDTO estado : this.getListaEstados()) {
                    if (estado.getCodigo().equals(this.getEstadoSelected().getCodigo())) {
                        state = true;
                        break;
                    }
                }
                if (!state) {
                    new EstadoDelegate().create(this.getEstadoSelected());
                    this.getListaEstados().add(this.getEstadoSelected());
                    this.setEstadoSelected(new EstadoDTO());
                    FacesContext.getCurrentInstance().addMessage("Se ha registrado un nuevo pais.", null);
                }
            } else {
                new EstadoDelegate().create(this.getEstadoSelected());
                this.getListaEstados().add(this.getEstadoSelected());
                this.setEstadoSelected(new EstadoDTO());
                FacesContext.getCurrentInstance().addMessage("Se ha registrado un nuevo pais.", null);
            }
        } else {
            FacesContext.getCurrentInstance().addMessage("Debe llenar los campos solicitados.", null);
        }
    }

    public void botonEditar() {
        if (this.getEstadoSelected().getId() != null) {
            new EstadoDelegate().edit(this.getEstadoSelected());
            FacesContext.getCurrentInstance().addMessage("Se ha editado la informacion del estado.", null);
        }
    }

    public void botonEliminar() {
        if (this.getEstadoSelected().getId() != null) {
//            new EstadoDelegate().remove(this.getEstadoSelected());
            this.getListaEstados().remove(this.getEstadoSelected());
            FacesContext.getCurrentInstance().addMessage("Se ha eliminado el estado.", null);
        }
    }

    public void activeButtons() {
        if (this.getEstadoSelected().getId() != null) {
            this.setEditar(false);
            this.setEliminar(false);
            this.setGuardar(true);
        } else if (this.getEstadoSelected().getId() == null) {
            this.setEditar(true);
            this.setEliminar(true);
            this.setGuardar(false);
        }
    }
}

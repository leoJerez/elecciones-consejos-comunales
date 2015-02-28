/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bdaplication.controllers.view;

import com.mycompany.backend.bdapplication.business.delegate.CiudadDelegate;
import com.mycompany.backend.bdapplication.business.delegate.EstadoDelegate;
import com.mycompany.backend.bdapplication.business.dto.CiudadDTO;
import com.mycompany.backend.bdapplication.business.dto.EstadoDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Roberth
 */
@ManagedBean(name = "ciudadViewBean")
@ViewScoped
public class CiudadViewBean implements Serializable {

    private CiudadDTO ciudadSelected;
    private EstadoDTO estadoSelected;
    private List<CiudadDTO> listaCiudadesTodas;
    private List<CiudadDTO> listaCiudades;
    private List<EstadoDTO> listaEstados;
    private EstadoDTO e1, e2, e3;
    private CiudadDTO c1, c2, c3;
    boolean guardar, editar, eliminar;

    public CiudadViewBean() {
    }

    @PostConstruct
    public void init() {
//        e1 = new EstadoDTO();
//        e2 = new EstadoDTO();
//        e3 = new EstadoDTO();
//        c1 = new CiudadDTO();
//        c2 = new CiudadDTO();
//        c3 = new CiudadDTO();
//        this.setGuardar(true);
//        this.setEditar(true);
//        this.setEliminar(true);
//        cargarEstados();
        this.getListaEstados().addAll(new EstadoDelegate().findAllEstado());
        this.getListaCiudadesTodas().addAll(new CiudadDelegate().findAllCiudad());
    }

    public CiudadDTO getCiudadSelected() {
        if (ciudadSelected == null) {
            ciudadSelected = new CiudadDTO();
        }
        return ciudadSelected;
    }

    public void setCiudadSelected(CiudadDTO ciudadSelected) {
        this.ciudadSelected = ciudadSelected;
    }

    public EstadoDTO getEstadoSelected() {
        if (estadoSelected == null) {
            estadoSelected = new EstadoDTO();
        }
        return estadoSelected;
    }

    public void setEstadoSelected(EstadoDTO estadoSelected) {
        this.estadoSelected = estadoSelected;
    }

    public List<CiudadDTO> getListaCiudadesTodas() {
        if (listaCiudadesTodas == null) {
            listaCiudadesTodas = new ArrayList<>();
        }
        return listaCiudadesTodas;
    }

    public void setListaCiudadesTodas(List<CiudadDTO> listaCiudadesTodas) {
        this.listaCiudadesTodas = listaCiudadesTodas;
    }

    public List<CiudadDTO> getListaCiudades() {
        if (listaCiudades == null) {
            listaCiudades = new ArrayList<>();
        }
        return listaCiudades;
    }

    public void setListaCiudades(List<CiudadDTO> listaCiudades) {
        this.listaCiudades = listaCiudades;
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

    public EstadoDTO getE1() {
        if (e1 == null) {
            e1 = new EstadoDTO();
        }
        return e1;
    }

    public void setE1(EstadoDTO e1) {
        this.e1 = e1;
    }

    public EstadoDTO getE2() {
        if (e2 == null) {
            e2 = new EstadoDTO();
        }
        return e2;
    }

    public void setE2(EstadoDTO e2) {
        this.e2 = e2;
    }

    public EstadoDTO getE3() {
        if (e3 == null) {
            e3 = new EstadoDTO();
        }
        return e3;
    }

    public void setE3(EstadoDTO e3) {
        this.e3 = e3;
    }

    public boolean isGuardar() {
        return guardar;
    }

    public CiudadDTO getC1() {
        if (c1 == null) {
            c1 = new CiudadDTO();
        }
        return c1;
    }

    public void setC1(CiudadDTO c1) {
        this.c1 = c1;
    }

    public CiudadDTO getC2() {
        if (c2 == null) {
            c2 = new CiudadDTO();
        }
        return c2;
    }

    public void setC2(CiudadDTO c2) {
        this.c2 = c2;
    }

    public CiudadDTO getC3() {
        if (c3 == null) {
            c3 = new CiudadDTO();
        }
        return c3;
    }

    public void setC3(CiudadDTO c3) {
        this.c3 = c3;
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

    public void activeButtons() {
        if (this.getCiudadSelected().getId() != null) {
            this.setEditar(false);
            this.setEliminar(false);
            this.setGuardar(true);
        } else if (this.getCiudadSelected().getId() == null) {
            this.setEditar(true);
            this.setEliminar(true);
            this.setGuardar(false);
        }
    }

    public void cargarEstados() {

        e1.setId(1);
        e1.setCodigo("001");
        e1.setNombre("LARA");
        e2.setId(2);
        e2.setCodigo("002");
        e2.setNombre("CARABOBO");
        e3.setId(3);
        e3.setCodigo("003");
        e3.setNombre("ZULIA");
        this.getListaEstados().add(e1);
        this.getListaEstados().add(e2);
        this.getListaEstados().add(e3);
        c1.setId(1);
        c1.setCodigo("001");
        c1.setNombre("BARQUISIMETO");
        c1.setCodigoEstado("001");
        c2.setId(2);
        c2.setCodigo("002");
        c2.setNombre("VALENCIA");
        c2.setCodigoEstado("002");
        c3.setId(1);
        c3.setCodigo("003");
        c3.setNombre("MARACAIBO");
        c3.setCodigoEstado("003");
        this.getListaCiudadesTodas().add(c1);
        this.getListaCiudadesTodas().add(c2);
        this.getListaCiudadesTodas().add(c3);
    }

    public void cargarCiudades() {
        this.getListaCiudades().clear();
        for (CiudadDTO ciudad : this.getListaCiudadesTodas()) {
            if (ciudad.getCodigoEstado().equals(this.getEstadoSelected().getCodigo())) {
                this.getListaCiudades().add(ciudad);
            }
        }
    }
}


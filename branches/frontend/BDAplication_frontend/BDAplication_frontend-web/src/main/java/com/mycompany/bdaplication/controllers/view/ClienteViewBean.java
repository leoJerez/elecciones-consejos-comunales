/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.bdaplication.controllers.view;

import com.mycompany.backend.bdapplication.business.delegate.CiudadDelegate;
import com.mycompany.backend.bdapplication.business.delegate.HabitanteDelegate;
import com.mycompany.backend.bdapplication.business.delegate.EstadoDelegate;
import com.mycompany.backend.bdapplication.business.dto.CiudadDTO;
import com.mycompany.backend.bdapplication.business.dto.ClienteDTO;
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
@ManagedBean(name = "clienteViewBean")
@ViewScoped
public class ClienteViewBean implements Serializable {
    
    private ClienteDTO trabajadorSelected;
    private List<ClienteDTO> listaTrabajadoresTodos;
    private List<EstadoDTO> listaPaisesTodos;
    private List<CiudadDTO> listaEstadosTodos;
    private EstadoDTO paisSelected;
    private CiudadDTO estadoSelected;

    public ClienteViewBean() {
    }
    
    @PostConstruct
    public void init(){
        this.estadoSelected = new CiudadDTO();
        this.paisSelected = new EstadoDTO();
        this.trabajadorSelected = new ClienteDTO();
        this.listaEstadosTodos = new ArrayList<>();
        this.listaTrabajadoresTodos = new ArrayList<>();
        this.listaPaisesTodos = new ArrayList<>();
        
//        this.getListaTrabajadoresTodos().addAll(new HabitanteDelegate().findAllCliente());
        this.getListaPaisesTodos().addAll(new EstadoDelegate().findAllEstado());
        this.getListaEstadosTodos().addAll(new CiudadDelegate().findAllCiudad());
    }

    public ClienteDTO getTrabajadorSelected() {
        if(trabajadorSelected == null){
            trabajadorSelected = new ClienteDTO();
        }
        return trabajadorSelected;
    }

    public void setTrabajadorSelected(ClienteDTO trabajadorSelected) {
        this.trabajadorSelected = trabajadorSelected;
    }

    public List<ClienteDTO> getListaTrabajadoresTodos() {
        return listaTrabajadoresTodos;
    }

    public void setListaTrabajadoresTodos(List<ClienteDTO> listaTrabajadoresTodos) {
        this.listaTrabajadoresTodos = listaTrabajadoresTodos;
    }

    public List<EstadoDTO> getListaPaisesTodos() {
        return listaPaisesTodos;
    }

    public void setListaPaisesTodos(List<EstadoDTO> listaPaisesTodos) {
        this.listaPaisesTodos = listaPaisesTodos;
    }

    public List<CiudadDTO> getListaEstadosTodos() {
        return listaEstadosTodos;
    }

    public void setListaEstadosTodos(List<CiudadDTO> listaEstadosTodos) {
        this.listaEstadosTodos = listaEstadosTodos;
    }

    public EstadoDTO getPaisSelected() {
        return paisSelected;
    }

    public void setPaisSelected(EstadoDTO paisSelected) {
        this.paisSelected = paisSelected;
    }

    public CiudadDTO getEstadoSelected() {
        return estadoSelected;
    }

    public void setEstadoSelected(CiudadDTO estadoSelected) {
        this.estadoSelected = estadoSelected;
    }
    
    public void guardarTrabajador(){
        if( this.getTrabajadorSelected().getNombre() != null){
            if(this.getTrabajadorSelected().getCodigopais() != null && this.getTrabajadorSelected().getCodigoestado() != null){
//                new HabitanteDelegate().create(this.getTrabajadorSelected());
            }
        }else {
            FacesContext.getCurrentInstance().getMessages("Error los datos del trabajador no pueden ser nulos");
        }
    }
    
    public void eliminarTrabajador(){
        if(getTrabajadorSelected().getCodigo() != null){
//            new HabitanteDelegate().remove(getTrabajadorSelected());
        }
    }
}

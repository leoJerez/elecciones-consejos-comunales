/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.bdaplication.controllers.view;

import com.mycompany.backend.bdapplication.business.dto.ViviendaDTO;
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
@ManagedBean(name = "viviendaViewBean")
@ViewScoped
public class ViviendaViewBean implements Serializable {

    private ViviendaDTO newVivienda;
    private List<ViviendaDTO> listaDeViviendas;
    
    @PostConstruct
    public void init(){
        
    }
    
    public ViviendaViewBean() {
    }

    public ViviendaDTO getNewVivienda() {
        if(newVivienda == null){
            newVivienda = new ViviendaDTO();
        }
        return newVivienda;
    }

    public void setNewVivienda(ViviendaDTO newVivienda) {
        this.newVivienda = newVivienda;
    }

    public List<ViviendaDTO> getListaDeViviendas() {
        if(listaDeViviendas == null){
            listaDeViviendas = new ArrayList<>();
        }
        return listaDeViviendas;
    }

    public void setListaDeViviendas(List<ViviendaDTO> listaDeViviendas) {
        this.listaDeViviendas = listaDeViviendas;
    }
    
    public void guardarVivienda(){
        this.getListaDeViviendas().add(this.getNewVivienda());
    }
}

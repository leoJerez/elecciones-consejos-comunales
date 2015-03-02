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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.eleccion_comunal.model.dao.ViviendaDAO;
import org.eleccion_comunal.model.dto.Vivienda;

/**
 *
 * @author Roberth
 */
@ManagedBean(name = "viviendaViewBean")
@ViewScoped
public class ViviendaViewBean implements Serializable {

    private Vivienda newVivienda;
    private List<Vivienda> listaDeViviendas;
    
    @PostConstruct
    public void init(){
        this.getListaDeViviendas().addAll(ViviendaDAO.getInstancia().buscarTodasEntidades());
    }
    
    public ViviendaViewBean() {
    }

    public Vivienda getNewVivienda() {
        if(newVivienda == null){
            newVivienda = new Vivienda();
        }
        return newVivienda;
    }

    public void setNewVivienda(Vivienda newVivienda) {
        this.newVivienda = newVivienda;
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
    
    public void guardarVivienda(){
        this.getListaDeViviendas().add(this.getNewVivienda());
        ViviendaDAO.getInstancia().actualizar(this.getNewVivienda());
    }
}

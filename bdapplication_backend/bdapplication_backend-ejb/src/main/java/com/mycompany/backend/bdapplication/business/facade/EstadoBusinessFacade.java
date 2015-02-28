/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.backend.bdapplication.business.facade;

import com.mycompany.backend.bdapplication.business.dto.EstadoDTO;
import com.mycompany.backend.bdapplication.model.Ciudad;
import com.mycompany.backend.bdapplication.model.Estado;
import com.mycompany.backend.bdapplication.model.facade.CiudadFacadeLocal;
import com.mycompany.backend.bdapplication.model.facade.EstadoFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Roberth
 */
@Stateless(name = "EstadoBusinessFacade", mappedName = EstadoBusinessFacadeRemote.JNDI_REMOTE_NAME)
@Remote(EstadoBusinessFacadeRemote.class)
public class EstadoBusinessFacade implements EstadoBusinessFacadeRemote, EstadoBusinessFacadeLocal {

    @EJB
    private EstadoFacadeLocal estadoFacadeLocal;
    
    @EJB
    private CiudadFacadeLocal ciudadFacadeLocal;

    @Override
    public EstadoDTO prepareEstado(Estado estado) {
        EstadoDTO estadoConverter = new EstadoDTO();
        if (estado != null) {
            estadoConverter.setId(estado.getId());
            estadoConverter.setCodigo(estado.getCodigo());
            estadoConverter.setNombre(estado.getNombre());
//            estadoConverter.setFechaRegistro(estado.getFechaRegistro());
//            estadoConverter.setFechaModificacion(estado.getFechaModificacion());
//
//            estadoConverter.getListaCiudadesDTO().addAll(estado.getListaCiudadesDTO());
        }
        return estadoConverter;
    }

    public List<EstadoDTO> obtenerListaEstadosDTO(List<Estado> listaEstadosJPA) {
        if (listaEstadosJPA == null) {
            return new ArrayList<>();
        }
        List<EstadoDTO> listaEstadosDTO = new ArrayList<>();
        for (Estado estado : listaEstadosJPA) {
//            for(Ciudad ciudad : ciudadFacadeLocal.findAll()){
//                if(estado.getCodigo().equals(ciudad.getCodigoEstado())){
//                    estado.getListaCiudades().add(ciudad);
//                }
//            }
            listaEstadosDTO.add(this.prepareEstado(estado));
        }
        return listaEstadosDTO;
    }

//    public EstadoDTO create(EstadoDTO estadoDTO) {
//
//        return prepareEstado(estado);
//    }
//    public EstadoDTO edit(EstadoDTO estadoDTO) {
//
//        return prepareEstado(estado);
//    }
    @Override
    public void remove(EstadoDTO estadoDTO) {
        estadoFacadeLocal.remove(estadoFacadeLocal.find(estadoDTO.getId()));
    }

    public List<EstadoDTO> findAll() {
        return obtenerListaEstadosDTO(estadoFacadeLocal.findAll());
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public List<EstadoDTO> findAllEstado() {
        return obtenerListaEstadosDTO(estadoFacadeLocal.findAll());
//        return findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(EstadoDTO estadoDTO) {
        Estado estado = new Estado(estadoDTO);
        estadoFacadeLocal.create(estado);
    }

    @Override
    public void edit(EstadoDTO estadoDTO) {
        Estado estado = new Estado(estadoDTO);
        estadoFacadeLocal.edit(estado);
    }

    @Override
    public String init() {
        return "inicializado";
    }

 
}

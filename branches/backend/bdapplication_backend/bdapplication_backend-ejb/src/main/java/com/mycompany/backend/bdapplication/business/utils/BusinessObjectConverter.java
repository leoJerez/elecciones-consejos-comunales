/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.backend.bdapplication.business.utils;

import com.mycompany.backend.bdapplication.business.dto.CiudadDTO;
import com.mycompany.backend.bdapplication.business.dto.ClienteDTO;
import com.mycompany.backend.bdapplication.business.dto.EstadoDTO;
import com.mycompany.backend.bdapplication.model.Ciudad;
import com.mycompany.backend.bdapplication.model.Habitante;
import com.mycompany.backend.bdapplication.model.Estado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberth
 */
public class BusinessObjectConverter {

    public ClienteDTO convetirClienteJPA(Habitante cliente) {
        ClienteDTO clienteConverter = new ClienteDTO();
        if (cliente != null) {
//            clienteConverter.setCodigo(cliente.getCodigo());
            clienteConverter.setNombre(cliente.getNombre());
            clienteConverter.setFechaRegistro(cliente.getFechaRegistro());
            clienteConverter.setFechaModificacion(cliente.getFechaModificacion());
        }
        return clienteConverter;
    }
    
    public List<ClienteDTO> obtenerListaClientesDTO(List<Habitante> listaClientesJPA){
        if (listaClientesJPA == null) {
            return new ArrayList<>();
        }
        List<ClienteDTO> listaClientesDTO = new ArrayList<>();
        for(Habitante cliente : listaClientesJPA){
            listaClientesDTO.add(this.convetirClienteJPA(cliente));
        }
        return listaClientesDTO;
    }

    public EstadoDTO convertirEstadoJPA(Estado estado) {
        EstadoDTO estadoConverter = new EstadoDTO();
        if (estado != null) {
            estadoConverter.setCodigo(estado.getCodigo());
            estadoConverter.setNombre(estado.getNombre());
            estadoConverter.setFechaRegistro(estado.getFechaRegistro());
            estadoConverter.setFechaModificacion(estado.getFechaModificacion());
        }
        return estadoConverter;
    }
    
    public List<EstadoDTO> obtenerListaEstadosDTO(List<Estado> listaEstadosJPA){
        if (listaEstadosJPA == null) {
            return new ArrayList<>();
        }
        List<EstadoDTO> listaEstadosDTO = new ArrayList<>();
        for(Estado estado : listaEstadosJPA){
            listaEstadosDTO.add(this.convertirEstadoJPA(estado));
        }
        return listaEstadosDTO;
    }

    public CiudadDTO convertirCiudadJPA(Ciudad ciudad) {
        CiudadDTO ciudadConverter = new CiudadDTO();
        if (ciudad != null) {
            ciudadConverter.setCodigo(ciudad.getCodigo());
            ciudadConverter.setNombre(ciudad.getNombre());
            ciudadConverter.setFechaRegistro(ciudad.getFechaRegistro());
            ciudadConverter.setFechaModificacion(ciudad.getFechaModificacion());
        }
        return ciudadConverter;
    }
    
    public List<CiudadDTO> obtenerListaCiudadDTO(List<Ciudad> listaCiudadesJPA){
        if (listaCiudadesJPA == null) {
            return new ArrayList<>();
        }
        List<CiudadDTO> listaCiudadesDTO = new ArrayList<>();
        for(Ciudad ciudad : listaCiudadesJPA){
            listaCiudadesDTO.add(this.convertirCiudadJPA(ciudad));
        }
        return listaCiudadesDTO;
    }
}

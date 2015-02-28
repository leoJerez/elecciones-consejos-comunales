/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.business.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Roberth
 */
@XmlRootElement(name = "estado")
public class EstadoDTO extends AuthenticateBaseSQLDTO implements Comparable<EstadoDTO> {
    private String codigo;
    private String nombre;
    private List<CiudadDTO> listaCiudadesDTO;

    public EstadoDTO() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<CiudadDTO> getListaCiudadesDTO() {
        if(listaCiudadesDTO == null){
            listaCiudadesDTO = new ArrayList<>();
        }
        return listaCiudadesDTO;
    }

    public void setListaCiudadesDTO(List<CiudadDTO> listaCiudadesDTO) {
        this.listaCiudadesDTO = listaCiudadesDTO;
    }

    @Override
    public int compareTo(EstadoDTO estado) {
        if(estado.getId() != null && this.getId() != null){
            return this.getId().compareTo(estado.getId());
        }else{
            return -1;
        }
    }

}

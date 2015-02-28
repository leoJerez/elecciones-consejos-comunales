/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.business.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Roberth
 */
@XmlRootElement(name = "vivienda")
public class ViviendaDTO extends AuthenticateBaseSQLDTO implements Comparable<ViviendaDTO> {

    private String codigo;
    private String propietario;

    public ViviendaDTO() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    
    @Override
    public int compareTo(ViviendaDTO o) {
        if(o.getId() != null){
            return this.getId().compareTo(o.getId());
        }else{
            return -1;
        }
    }
    
}

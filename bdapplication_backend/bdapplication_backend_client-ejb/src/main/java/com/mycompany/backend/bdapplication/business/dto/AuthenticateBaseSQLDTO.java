/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.business.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Roberth
 */
public class AuthenticateBaseSQLDTO implements Serializable {
    private static final long serialVersionUID = 6537829554428475033L;
    
    public Integer id;
    public Integer version;
    public Date fechaRegistro;
    public Date fechaModificacion;

    public AuthenticateBaseSQLDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
}

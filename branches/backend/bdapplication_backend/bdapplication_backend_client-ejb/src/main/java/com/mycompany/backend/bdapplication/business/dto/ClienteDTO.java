/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.business.dto;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Roberth
 */
@XmlRootElement(name = "cliente")
public class ClienteDTO extends AuthenticateBaseSQLDTO implements Comparable<ClienteDTO> {

    private String codigo;
    private String nombre;
    private String codigopais;
    private String codigoestado;
    private Date fechanacimiento;
    private String sueldo;
    
    public ClienteDTO() {
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

    public String getCodigopais() {
        return codigopais;
    }

    public void setCodigopais(String codigopais) {
        this.codigopais = codigopais;
    }

    public String getCodigoestado() {
        return codigoestado;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public void setCodigoestado(String codigoestado) {
        this.codigoestado = codigoestado;
    }

    @Override
    public int compareTo(ClienteDTO cliente) {
        if(cliente.getId() != null){
            return this.getId().compareTo(cliente.getId());
        }else{
            return -1;
        }
    }
}

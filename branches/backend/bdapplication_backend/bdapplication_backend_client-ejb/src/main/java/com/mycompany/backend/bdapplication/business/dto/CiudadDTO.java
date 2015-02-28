/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.business.dto;



/**
 *
 * @author Roberth
 */

public class CiudadDTO extends AuthenticateBaseSQLDTO implements Comparable<CiudadDTO> {
    private String codigo;
    private String nombre;
    private String codigoEstado;
    private String codigoPais;
    
    public CiudadDTO() {
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

    public String getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(String codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }



    @Override
    public int compareTo(CiudadDTO ciudad) {
        if(ciudad.getId() != null){
            return this.getId().compareTo(ciudad.getId());
        }else{
            return -1;
        }
    }
}

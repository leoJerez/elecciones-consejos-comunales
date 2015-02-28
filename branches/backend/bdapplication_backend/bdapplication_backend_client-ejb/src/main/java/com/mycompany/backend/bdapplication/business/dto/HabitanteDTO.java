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
@XmlRootElement(name = "habitante")
public class HabitanteDTO extends AuthenticateBaseSQLDTO implements Comparable<HabitanteDTO> {

    private String nombre;
    private String cedula;
    private String apellido;
    private Date fechaNacimiento;
    private String numeroCasa;
    private String sexo;
    private String correo;
    private String telefonoMovil;
    private String telefonoFijo;
    private String estatus;

    public HabitanteDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String nroCasa) {
        this.numeroCasa = nroCasa;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String nroTelefonoFijo) {
        this.telefonoFijo = nroTelefonoFijo;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    @Override
    public int compareTo(HabitanteDTO habitante) {
        if(habitante.getId() != null){
            return this.getId().compareTo(habitante.getId());
        }else{
            return -1;
        }
    }
}

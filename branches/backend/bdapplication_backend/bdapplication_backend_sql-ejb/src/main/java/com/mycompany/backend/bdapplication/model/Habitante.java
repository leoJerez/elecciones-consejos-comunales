/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.model;

import com.mycompany.backend.bdapplication.business.dto.HabitanteDTO;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Roberth
 */
@Entity
@Table(name = "habitante")
@NamedQueries({
    @NamedQuery(name = "Habitante.findAll", query = "SELECT i FROM Habitante i"),
    @NamedQuery(name = "Habitante.findById", query = "SELECT i FROM Habitante i WHERE i.id = :id")})
public class Habitante extends HabitanteDTO { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(HabitanteDTO habitante) {
        return super.compareTo(habitante); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        return super.getNombre(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public void setTelefonoFijo(String nroTelefonoFijo) {
        super.setTelefonoFijo(nroTelefonoFijo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTelefonoFijo() {
        return super.getTelefonoFijo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTelefonoMovil(String nroCelular) {
        super.setTelefonoMovil(nroCelular); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTelefonoMovil() {
        return super.getTelefonoMovil(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCorreo(String correo) {
        super.setCorreo(correo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCorreo() {
        return super.getCorreo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSexo(String sexo) {
        super.setSexo(sexo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSexo() {
        return super.getSexo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNumeroCasa(String nroCasa) {
        super.setNumeroCasa(nroCasa); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNumeroCasa() {
        return super.getNumeroCasa(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFechaNacimiento(Date fechaNacimiento) {
        super.setFechaNacimiento(fechaNacimiento); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getFechaNacimiento() {
        return super.getFechaNacimiento(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setApellido(String apellido) {
        super.setApellido(apellido); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getApellido() {
        return super.getApellido(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCedula(String cedula) {
        super.setCedula(cedula); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCedula() {
        return super.getCedula(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEstatus(String estatus) {
        super.setEstatus(estatus); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEstatus() {
        return super.getEstatus(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setVersion(Integer version) {
        super.setVersion(version); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getVersion() {
        return super.getVersion(); //To change body of generated methods, choose Tools | Templates.
    }


    //METODOS GENERICOS DE CADA CLASE
    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitante)) {
            return false;
        }
        Habitante other = (Habitante) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    public Habitante() {
    }

    public Habitante(HabitanteDTO habitanteDTO){
        this.setId(habitanteDTO.getId());
        this.setCedula(habitanteDTO.getCedula());
        this.setNombre(habitanteDTO.getNombre());
        this.setApellido(habitanteDTO.getApellido());
        this.setNumeroCasa(habitanteDTO.getNumeroCasa());
        this.setFechaNacimiento(habitanteDTO.getFechaNacimiento());
        this.setTelefonoFijo(habitanteDTO.getTelefonoFijo());
        this.setTelefonoMovil(habitanteDTO.getTelefonoMovil());
        this.setSexo(habitanteDTO.getSexo());
        this.setCorreo(habitanteDTO.getCorreo());
        this.setVersion(habitanteDTO.getVersion());
        this.setEstatus(habitanteDTO.getEstatus());
        
    }
}
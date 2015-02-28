/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.backend.bdapplication.model;

import com.mycompany.backend.bdapplication.business.dto.CiudadDTO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Roberth
 */
@Entity
@Table(name = "estado")
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT i FROM Ciudad i"),
    @NamedQuery(name = "Ciudad.findById", query = "SELECT i FROM Ciudad i WHERE i.id = :id")})
public class Ciudad extends CiudadDTO implements Serializable{
    private static final long serialVersionUID = 1L;
   
//    private Estado estado;
//    
//    
//    @JoinColumn(name="codigoestado", referencedColumnName = "id")
//    @ManyToOne(optional = false)
//    public Estado getEstado() {
//        return estado;
//    }
//
//    public void setEstado(Estado estado) {
//        this.estado = estado;
//    }

    
    @Override
    public int compareTo(CiudadDTO ciudad) {
        return super.compareTo(ciudad); //To change body of generated methods, choose Tools | Templates.
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
    public void setCodigoEstado(String codigoEstado) {
        super.setCodigoEstado(codigoEstado); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCodigoEstado() {
        return super.getCodigoEstado(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCodigoPais(String codigoPais) {
        super.setCodigoPais(codigoPais); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCodigoPais() {
        return super.getCodigoPais(); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public void setId(Integer id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @Override
    public Integer getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    public Ciudad() {
    }
    
    public Ciudad(CiudadDTO ciudadDTO) {
        this.setId(ciudadDTO.getId());
        this.setNombre(ciudadDTO.getNombre());
        this.setCodigoEstado(ciudadDTO.getCodigoEstado());
        this.setCodigoPais(ciudadDTO.getCodigoPais());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.backend.bdapplication.model;

import com.mycompany.backend.bdapplication.business.dto.CiudadDTO;
import com.mycompany.backend.bdapplication.business.dto.EstadoDTO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Roberth
 */
@Entity
@Table(name = "paises")
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT i FROM Estado i"),
    @NamedQuery(name = "Estado.findById", query = "SELECT i FROM Estado i WHERE i.id = :id")})
public class Estado extends EstadoDTO {

    
//    private List<Ciudad> listaCiudades;

    @Override
    public int compareTo(EstadoDTO estado) {
        return super.compareTo(estado); //To change body of generated methods, choose Tools | Templates.
    }

//    @OneToMany(mappedBy = "estado")
//    public List<Ciudad> getListaCiudades() {
//        return this.listaCiudades;
//    }
//
//    public void setListaCiudades(List<Ciudad> listaCiudades) {
//        this.listaCiudades = listaCiudades;
//    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        return super.getNombre(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCodigo(String codigo) {
        super.setCodigo(codigo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCodigo() {
        return super.getCodigo(); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public void setFechaModificacion(Date fechaModificacion) {
//        super.setFechaModificacion(fechaModificacion); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    @Temporal(javax.persistence.TemporalType.DATE)
//    public Date getFechaModificacion() {
//        return super.getFechaModificacion(); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public void setFechaRegistro(Date fechaRegistro) {
//        super.setFechaRegistro(fechaRegistro); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    @Temporal(javax.persistence.TemporalType.DATE)
//    public Date getFechaRegistro() {
//        return super.getFechaRegistro(); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setVersion(Integer version) {
//        super.setVersion(version); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Integer getVersion() {
//        return super.getVersion(); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void setId(Integer id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    public Integer getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    public Estado() {
    }

    public Estado(EstadoDTO estadoDTO) {
        this.setCodigo(estadoDTO.getCodigo());
        this.setNombre(estadoDTO.getNombre());
    }
}

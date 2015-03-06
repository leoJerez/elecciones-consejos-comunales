package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the estado database table.
 * 
 */
@Entity
@NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
public class Estado extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idEstado;
    private String nombre;
    private List<Municipio> municipios;

    public Estado() {
    }

    @Id
    @SequenceGenerator(name = "EstadoSequence", sequenceName = "estado_id_estado_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EstadoSequence")
    @Column(name = "id_estado")
    public Integer getIdEstado() {
	return this.idEstado;
    }

    public void setIdEstado(Integer idEstado) {
	this.idEstado = idEstado;
    }

    public String getNombre() {
	return this.nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    // bi-directional many-to-one association to Municipio
    @OneToMany(mappedBy = "estado")
    public List<Municipio> getMunicipios() {
	return this.municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
	this.municipios = municipios;
    }

    public Municipio addMunicipio(Municipio municipio) {
	getMunicipios().add(municipio);
	municipio.setEstado(this);

	return municipio;
    }

    public Municipio removeMunicipio(Municipio municipio) {
	getMunicipios().remove(municipio);
	municipio.setEstado(null);

	return municipio;
    }

    @Override
    public Object getPrimaryKey() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return null;
    }

}
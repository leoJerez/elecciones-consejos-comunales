package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the municipio database table.
 * 
 */
@Entity
@NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m")
public class Municipio extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idMunicipio;
    private String nombre;
    private Estado estado;
    private List<Parroquia> parroquias;

    public Municipio() {
    }

    @Id
    @SequenceGenerator(name = "MunicipioSequence", sequenceName = "municipio_id_municipio_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MunicipioSequence")
    @Column(name = "id_municipio")
    public Integer getIdMunicipio() {
	return this.idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
	this.idMunicipio = idMunicipio;
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

    // bi-directional many-to-one association to Estado
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    public Estado getEstado() {
	return this.estado;
    }

    public void setEstado(Estado estado) {
	this.estado = estado;
    }

    // bi-directional many-to-one association to Parroquia
    @OneToMany(mappedBy = "municipio")
    public List<Parroquia> getParroquias() {
	return this.parroquias;
    }

    public void setParroquias(List<Parroquia> parroquias) {
	this.parroquias = parroquias;
    }

    public Parroquia addParroquia(Parroquia parroquia) {
	getParroquias().add(parroquia);
	parroquia.setMunicipio(this);

	return parroquia;
    }

    public Parroquia removeParroquia(Parroquia parroquia) {
	getParroquias().remove(parroquia);
	parroquia.setMunicipio(null);

	return parroquia;
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
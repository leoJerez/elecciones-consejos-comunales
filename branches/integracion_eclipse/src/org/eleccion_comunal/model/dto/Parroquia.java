package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the parroquia database table.
 * 
 */
@Entity
@NamedQuery(name="Parroquia.findAll", query="SELECT p FROM Parroquia p")
public class Parroquia extends EntidadGenerica implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idParroquia;
	private String nombre;
	private List<ConsejoComunal> consejoComunals;
	private Municipio municipio;

	public Parroquia() {
	}


	@Id
	@SequenceGenerator(name="PARROQUIA_IDPARROQUIA_GENERATOR", sequenceName = "parroquia_id_parroquia_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARROQUIA_IDPARROQUIA_GENERATOR")
	@Column(name="id_parroquia")
	public Integer getIdParroquia() {
		return this.idParroquia;
	}

	public void setIdParroquia(Integer idParroquia) {
		this.idParroquia = idParroquia;
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


	//bi-directional many-to-one association to ConsejoComunal
	@OneToMany(mappedBy="parroquia")
	public List<ConsejoComunal> getConsejoComunals() {
		return this.consejoComunals;
	}

	public void setConsejoComunals(List<ConsejoComunal> consejoComunals) {
		this.consejoComunals = consejoComunals;
	}

	public ConsejoComunal addConsejoComunal(ConsejoComunal consejoComunal) {
		getConsejoComunals().add(consejoComunal);
		consejoComunal.setParroquia(this);

		return consejoComunal;
	}

	public ConsejoComunal removeConsejoComunal(ConsejoComunal consejoComunal) {
		getConsejoComunals().remove(consejoComunal);
		consejoComunal.setParroquia(null);

		return consejoComunal;
	}


	//bi-directional many-to-one association to Municipio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_municipio")
	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
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
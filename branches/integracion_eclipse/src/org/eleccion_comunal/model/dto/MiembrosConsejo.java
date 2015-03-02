package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the miembros_consejo database table.
 * 
 */
@Entity
@Table(name="miembros_consejo")
@NamedQuery(name="MiembrosConsejo.findAll", query="SELECT m FROM MiembrosConsejo m")
public class MiembrosConsejo extends EntidadGenerica implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idMiembro;
	private String estado;
	private String observaciones;
	private Cargo cargo;
	private Eleccion eleccion;
	private Vecino vecino;

	public MiembrosConsejo() {
	}


	@Id
	@SequenceGenerator(name="MIEMBROS_CONSEJO_IDMIEMBRO_GENERATOR", sequenceName = "miembros_consejo_id_miembro_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MIEMBROS_CONSEJO_IDMIEMBRO_GENERATOR")
	@Column(name="id_miembro")
	public Integer getIdMiembro() {
		return this.idMiembro;
	}

	public void setIdMiembro(Integer idMiembro) {
		this.idMiembro = idMiembro;
	}


	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	//bi-directional many-to-one association to Cargo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cargo")
	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}


	//bi-directional many-to-one association to Eleccion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id__eleccion")
	public Eleccion getEleccion() {
		return this.eleccion;
	}

	public void setEleccion(Eleccion eleccion) {
		this.eleccion = eleccion;
	}


	//bi-directional many-to-one association to Vecino
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_vecino")
	public Vecino getVecino() {
		return this.vecino;
	}

	public void setVecino(Vecino vecino) {
		this.vecino = vecino;
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
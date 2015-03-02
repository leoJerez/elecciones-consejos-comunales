package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the mesa_electoral database table.
 * 
 */
@Entity
@Table(name="mesa_electoral")
@NamedQuery(name="MesaElectoral.findAll", query="SELECT m FROM MesaElectoral m")
public class MesaElectoral extends EntidadGenerica implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idMesa;
	private String macPc;
	private String numeroMesa;
	private String observaciones;
	private Eleccion eleccion;

	public MesaElectoral() {
	}


	@Id
	@SequenceGenerator(name="MESA_ELECTORAL_IDMESA_GENERATOR", sequenceName = "mesa_electoral_id_mesa_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MESA_ELECTORAL_IDMESA_GENERATOR")
	@Column(name="id_mesa")
	public Integer getIdMesa() {
		return this.idMesa;
	}

	public void setIdMesa(Integer idMesa) {
		this.idMesa = idMesa;
	}


	@Column(name="mac_pc")
	public String getMacPc() {
		return this.macPc;
	}

	public void setMacPc(String macPc) {
		this.macPc = macPc;
	}


	@Column(name="numero_mesa")
	public String getNumeroMesa() {
		return this.numeroMesa;
	}

	public void setNumeroMesa(String numeroMesa) {
		this.numeroMesa = numeroMesa;
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


	//bi-directional many-to-one association to Eleccion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id__eleccion")
	public Eleccion getEleccion() {
		return this.eleccion;
	}

	public void setEleccion(Eleccion eleccion) {
		this.eleccion = eleccion;
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
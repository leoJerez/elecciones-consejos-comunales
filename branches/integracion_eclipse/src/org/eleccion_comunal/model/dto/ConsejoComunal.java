package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the consejo_comunal database table.
 * 
 */
@Entity
@Table(name="consejo_comunal")
@NamedQuery(name="ConsejoComunal.findAll", query="SELECT c FROM ConsejoComunal c")
public class ConsejoComunal extends EntidadGenerica implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idConsejoComunal;
	private Date fechaCreacion;
	private String linderoEste;
	private String linderoNorte;
	private String linderoOeste;
	private String linderoSur;
	private String nombre;
	private Cargo cargo;
	private Parroquia parroquia;
	private List<Vivienda> viviendas;

	public ConsejoComunal() {
	}


	@Id
	@SequenceGenerator(name="CONSEJO_COMUNAL_IDCONSEJOCOMUNAL_GENERATOR", sequenceName = "consejo_comunal_id_consejo_comunal_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONSEJO_COMUNAL_IDCONSEJOCOMUNAL_GENERATOR")
	@Column(name="id_consejo_comunal")
	public Integer getIdConsejoComunal() {
		return this.idConsejoComunal;
	}

	public void setIdConsejoComunal(Integer idConsejoComunal) {
		this.idConsejoComunal = idConsejoComunal;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	@Column(name="lindero_este")
	public String getLinderoEste() {
		return this.linderoEste;
	}

	public void setLinderoEste(String linderoEste) {
		this.linderoEste = linderoEste;
	}


	@Column(name="lindero_norte")
	public String getLinderoNorte() {
		return this.linderoNorte;
	}

	public void setLinderoNorte(String linderoNorte) {
		this.linderoNorte = linderoNorte;
	}


	@Column(name="lindero_oeste")
	public String getLinderoOeste() {
		return this.linderoOeste;
	}

	public void setLinderoOeste(String linderoOeste) {
		this.linderoOeste = linderoOeste;
	}


	@Column(name="lindero_sur")
	public String getLinderoSur() {
		return this.linderoSur;
	}

	public void setLinderoSur(String linderoSur) {
		this.linderoSur = linderoSur;
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


	//bi-directional many-to-one association to Cargo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cargo")
	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}


	//bi-directional many-to-one association to Parroquia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_parroquia")
	public Parroquia getParroquia() {
		return this.parroquia;
	}

	public void setParroquia(Parroquia parroquia) {
		this.parroquia = parroquia;
	}


	//bi-directional many-to-one association to Vivienda
	@OneToMany(mappedBy="consejoComunal")
	public List<Vivienda> getViviendas() {
		return this.viviendas;
	}

	public void setViviendas(List<Vivienda> viviendas) {
		this.viviendas = viviendas;
	}

	public Vivienda addVivienda(Vivienda vivienda) {
		getViviendas().add(vivienda);
		vivienda.setConsejoComunal(this);

		return vivienda;
	}

	public Vivienda removeVivienda(Vivienda vivienda) {
		getViviendas().remove(vivienda);
		vivienda.setConsejoComunal(null);

		return vivienda;
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
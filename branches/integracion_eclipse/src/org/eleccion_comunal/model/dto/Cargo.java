package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the cargo database table.
 * 
 */
@Entity
@NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c")
public class Cargo extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idCargo;
    private String descripcion;
    private double duracionPeriodo;
    private Integer minimoEdadPostulante;
    private String nombre;
    private List<Candidato> candidatos;
    private ConsejoComunal consejoComunal;
    private List<MiembrosConsejo> miembrosConsejos;

    public Cargo() {
    }

    @Id
    @SequenceGenerator(name = "CargoSequence", sequenceName = "cargo_id_cargo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CargoSequence")
    @Column(name = "id_cargo")
    public Integer getIdCargo() {
	return this.idCargo;
    }

    public void setIdCargo(Integer idCargo) {
	this.idCargo = idCargo;
    }

    public String getDescripcion() {
	return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    @Column(name = "duracion_periodo")
    public double getDuracionPeriodo() {
	return this.duracionPeriodo;
    }

    public void setDuracionPeriodo(double duracionPeriodo) {
	this.duracionPeriodo = duracionPeriodo;
    }

    @Column(name = "minimo_edad_postulante")
    public Integer getMinimoEdadPostulante() {
	return this.minimoEdadPostulante;
    }

    public void setMinimoEdadPostulante(Integer minimoEdadPostulante) {
	this.minimoEdadPostulante = minimoEdadPostulante;
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

    // bi-directional many-to-one association to Candidato
    @OneToMany(mappedBy = "cargo")
    public List<Candidato> getCandidatos() {
	return this.candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
	this.candidatos = candidatos;
    }

    public Candidato addCandidato(Candidato candidato) {
	getCandidatos().add(candidato);
	candidato.setCargo(this);

	return candidato;
    }

    public Candidato removeCandidato(Candidato candidato) {
	getCandidatos().remove(candidato);
	candidato.setCargo(null);

	return candidato;
    }

    // bi-directional many-to-one association to ConsejoComunal
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consejo_comunal")
    public ConsejoComunal getConsejoComunal() {
	return this.consejoComunal;
    }

    public void setConsejoComunal(ConsejoComunal consejoComunal) {
	this.consejoComunal = consejoComunal;
    }

    // bi-directional many-to-one association to MiembrosConsejo
    @OneToMany(mappedBy = "cargo")
    public List<MiembrosConsejo> getMiembrosConsejos() {
	return this.miembrosConsejos;
    }

    public void setMiembrosConsejos(List<MiembrosConsejo> miembrosConsejos) {
	this.miembrosConsejos = miembrosConsejos;
    }

    public MiembrosConsejo addMiembrosConsejo(MiembrosConsejo miembrosConsejo) {
	getMiembrosConsejos().add(miembrosConsejo);
	miembrosConsejo.setCargo(this);

	return miembrosConsejo;
    }

    public MiembrosConsejo removeMiembrosConsejo(MiembrosConsejo miembrosConsejo) {
	getMiembrosConsejos().remove(miembrosConsejo);
	miembrosConsejo.setCargo(null);

	return miembrosConsejo;
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
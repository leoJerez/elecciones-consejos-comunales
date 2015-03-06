package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the eleccion database table.
 * 
 */
@Entity
@NamedQuery(name = "Eleccion.findAll", query = "SELECT e FROM Eleccion e")
public class Eleccion extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idEleccion;
    private Date fechaEvento;
    private Time horaCierre;
    private Time horaInicio;
    private List<Candidato> candidatos;
    private List<MesaElectoral> mesaElectorals;
    private List<MiembrosConsejo> miembrosConsejos;

    public Eleccion() {
    }

    @Id
    @SequenceGenerator(name = "EleccionSequence", sequenceName = "eleccion_id__eleccion_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EleccionSequence")
    @Column(name = "id__eleccion")
    public Integer getIdEleccion() {
	return this.idEleccion;
    }

    public void setIdEleccion(Integer idEleccion) {
	this.idEleccion = idEleccion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_evento")
    public Date getFechaEvento() {
	return this.fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
	this.fechaEvento = fechaEvento;
    }

    @Column(name = "hora_cierre")
    public Time getHoraCierre() {
	return this.horaCierre;
    }

    public void setHoraCierre(Time horaCierre) {
	this.horaCierre = horaCierre;
    }

    @Column(name = "hora_inicio")
    public Time getHoraInicio() {
	return this.horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
	this.horaInicio = horaInicio;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    // bi-directional many-to-one association to Candidato
    @OneToMany(mappedBy = "eleccion")
    public List<Candidato> getCandidatos() {
	return this.candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
	this.candidatos = candidatos;
    }

    public Candidato addCandidato(Candidato candidato) {
	getCandidatos().add(candidato);
	candidato.setEleccion(this);

	return candidato;
    }

    public Candidato removeCandidato(Candidato candidato) {
	getCandidatos().remove(candidato);
	candidato.setEleccion(null);

	return candidato;
    }

    // bi-directional many-to-one association to MesaElectoral
    @OneToMany(mappedBy = "eleccion")
    public List<MesaElectoral> getMesaElectorals() {
	return this.mesaElectorals;
    }

    public void setMesaElectorals(List<MesaElectoral> mesaElectorals) {
	this.mesaElectorals = mesaElectorals;
    }

    public MesaElectoral addMesaElectoral(MesaElectoral mesaElectoral) {
	getMesaElectorals().add(mesaElectoral);
	mesaElectoral.setEleccion(this);

	return mesaElectoral;
    }

    public MesaElectoral removeMesaElectoral(MesaElectoral mesaElectoral) {
	getMesaElectorals().remove(mesaElectoral);
	mesaElectoral.setEleccion(null);

	return mesaElectoral;
    }

    // bi-directional many-to-one association to MiembrosConsejo
    @OneToMany(mappedBy = "eleccion")
    public List<MiembrosConsejo> getMiembrosConsejos() {
	return this.miembrosConsejos;
    }

    public void setMiembrosConsejos(List<MiembrosConsejo> miembrosConsejos) {
	this.miembrosConsejos = miembrosConsejos;
    }

    public MiembrosConsejo addMiembrosConsejo(MiembrosConsejo miembrosConsejo) {
	getMiembrosConsejos().add(miembrosConsejo);
	miembrosConsejo.setEleccion(this);

	return miembrosConsejo;
    }

    public MiembrosConsejo removeMiembrosConsejo(MiembrosConsejo miembrosConsejo) {
	getMiembrosConsejos().remove(miembrosConsejo);
	miembrosConsejo.setEleccion(null);

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
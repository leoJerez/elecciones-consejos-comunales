package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;


import java.util.List;

/**
 * The persistent class for the candidato database table.
 * 
 */
@Entity
@NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c")
public class Candidato extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idCandidato;
    private Integer cantidadVotos;
    private String estado;
    private Cargo cargo;
    private Eleccion eleccion;
    private Vecino vecino;
    private List<VotoCandidatoMesa> votoCandidatoMesas;

    public Candidato() {
    }

    @Id
    @SequenceGenerator(name = "CandidatoSequence", sequenceName = "candidato_id_candidato_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CandidatoSequence")
    @Column(name = "id_candidato")
    public Integer getIdCandidato() {
	return this.idCandidato;
    }

    public void setIdCandidato(Integer idCandidato) {
	this.idCandidato = idCandidato;
    }

    @Column(name = "cantidad_votos")
    public Integer getCantidadVotos() {
	return this.cantidadVotos;
    }

    public void setCantidadVotos(Integer cantidadVotos) {
	this.cantidadVotos = cantidadVotos;
    }

    public String getEstado() {
	return this.estado;
    }

    public void setEstado(String estado) {
	this.estado = estado;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    // bi-directional many-to-one association to Cargo
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cargo")
    public Cargo getCargo() {
	return this.cargo;
    }

    public void setCargo(Cargo cargo) {
	this.cargo = cargo;
    }

    // bi-directional many-to-one association to Eleccion
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id__eleccion")
    public Eleccion getEleccion() {
	return this.eleccion;
    }

    public void setEleccion(Eleccion eleccion) {
	this.eleccion = eleccion;
    }

    // bi-directional many-to-one association to Vecino
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vecino")
    public Vecino getVecino() {
	return this.vecino;
    }

    public void setVecino(Vecino vecino) {
	this.vecino = vecino;
    }

    // bi-directional many-to-one association to VotoCandidatoMesa
    @OneToMany(mappedBy = "candidato")
    public List<VotoCandidatoMesa> getVotoCandidatoMesas() {
	return this.votoCandidatoMesas;
    }

    public void setVotoCandidatoMesas(List<VotoCandidatoMesa> votoCandidatoMesas) {
	this.votoCandidatoMesas = votoCandidatoMesas;
    }

    public VotoCandidatoMesa addVotoCandidatoMesa(VotoCandidatoMesa votoCandidatoMesa) {
	getVotoCandidatoMesas().add(votoCandidatoMesa);
	votoCandidatoMesa.setCandidato(this);

	return votoCandidatoMesa;
    }

    public VotoCandidatoMesa removeVotoCandidatoMesa(VotoCandidatoMesa votoCandidatoMesa) {
	getVotoCandidatoMesas().remove(votoCandidatoMesa);
	votoCandidatoMesa.setCandidato(null);

	return votoCandidatoMesa;
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
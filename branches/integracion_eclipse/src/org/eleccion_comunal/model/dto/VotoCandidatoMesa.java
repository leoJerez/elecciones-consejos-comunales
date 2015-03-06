package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the voto_candidato_mesa database table.
 * 
 */
@Entity
@Table(name = "voto_candidato_mesa")
@NamedQuery(name = "VotoCandidatoMesa.findAll", query = "SELECT v FROM VotoCandidatoMesa v")
public class VotoCandidatoMesa extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idVotoCandidatoMesa;
    private Integer cantidadVotos;
    private Candidato candidato;
    private MesaElectoral mesaElectoral;

    public VotoCandidatoMesa() {
    }

    @Id
    @SequenceGenerator(name = "VotoCandidatoMesaSequence", sequenceName = "voto_candidato_mesa_id_voto_candidato_mesa_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VotoCandidatoMesaSequence")
    @Column(name = "id_voto_candidato_mesa")
    public Integer getIdVotoCandidatoMesa() {
	return this.idVotoCandidatoMesa;
    }

    public void setIdVotoCandidatoMesa(Integer idVotoCandidatoMesa) {
	this.idVotoCandidatoMesa = idVotoCandidatoMesa;
    }

    @Column(name = "cantidad_votos")
    public Integer getCantidadVotos() {
	return this.cantidadVotos;
    }

    public void setCantidadVotos(Integer cantidadVotos) {
	this.cantidadVotos = cantidadVotos;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    // bi-directional many-to-one association to Candidato
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_candidato")
    public Candidato getCandidato() {
	return this.candidato;
    }

    public void setCandidato(Candidato candidato) {
	this.candidato = candidato;
    }

    // bi-directional many-to-one association to MesaElectoral
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mesa")
    public MesaElectoral getMesaElectoral() {
	return this.mesaElectoral;
    }

    public void setMesaElectoral(MesaElectoral mesaElectoral) {
	this.mesaElectoral = mesaElectoral;
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
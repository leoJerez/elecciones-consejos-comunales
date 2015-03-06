package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the mesa_electoral database table.
 * 
 */
@Entity
@Table(name = "mesa_electoral")
@NamedQuery(name = "MesaElectoral.findAll", query = "SELECT m FROM MesaElectoral m")
public class MesaElectoral extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idMesa;
    private String macPc;
    private String numeroMesa;
    private String observaciones;
    private Integer votosNulos;
    private Eleccion eleccion;
    private List<MiembrosMesa> miembrosMesas;
    private List<VotoCandidatoMesa> votoCandidatoMesas;

    public MesaElectoral() {
    }

    @Id
    @SequenceGenerator(name = "MesaElectoralSequence", sequenceName = "mesa_electoral_id_mesa_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MesaElectoralSequence")
    @Column(name = "id_mesa")
    public Integer getIdMesa() {
	return this.idMesa;
    }

    public void setIdMesa(Integer idMesa) {
	this.idMesa = idMesa;
    }

    @Column(name = "mac_pc")
    public String getMacPc() {
	return this.macPc;
    }

    public void setMacPc(String macPc) {
	this.macPc = macPc;
    }

    @Column(name = "numero_mesa")
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

    @Column(name = "votos_nulos")
    public Integer getVotosNulos() {
	return this.votosNulos;
    }

    public void setVotosNulos(Integer votosNulos) {
	this.votosNulos = votosNulos;
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

    // bi-directional many-to-one association to MiembrosMesa
    @OneToMany(mappedBy = "mesaElectoral")
    public List<MiembrosMesa> getMiembrosMesas() {
	return this.miembrosMesas;
    }

    public void setMiembrosMesas(List<MiembrosMesa> miembrosMesas) {
	this.miembrosMesas = miembrosMesas;
    }

    public MiembrosMesa addMiembrosMesa(MiembrosMesa miembrosMesa) {
	getMiembrosMesas().add(miembrosMesa);
	miembrosMesa.setMesaElectoral(this);

	return miembrosMesa;
    }

    public MiembrosMesa removeMiembrosMesa(MiembrosMesa miembrosMesa) {
	getMiembrosMesas().remove(miembrosMesa);
	miembrosMesa.setMesaElectoral(null);

	return miembrosMesa;
    }

    // bi-directional many-to-one association to VotoCandidatoMesa
    @OneToMany(mappedBy = "mesaElectoral")
    public List<VotoCandidatoMesa> getVotoCandidatoMesas() {
	return this.votoCandidatoMesas;
    }

    public void setVotoCandidatoMesas(List<VotoCandidatoMesa> votoCandidatoMesas) {
	this.votoCandidatoMesas = votoCandidatoMesas;
    }

    public VotoCandidatoMesa addVotoCandidatoMesa(VotoCandidatoMesa votoCandidatoMesa) {
	getVotoCandidatoMesas().add(votoCandidatoMesa);
	votoCandidatoMesa.setMesaElectoral(this);

	return votoCandidatoMesa;
    }

    public VotoCandidatoMesa removeVotoCandidatoMesa(VotoCandidatoMesa votoCandidatoMesa) {
	getVotoCandidatoMesas().remove(votoCandidatoMesa);
	votoCandidatoMesa.setMesaElectoral(null);

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
package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the miembros_mesa database table.
 * 
 */
@Entity
@Table(name = "miembros_mesa")
@NamedQuery(name = "MiembrosMesa.findAll", query = "SELECT m FROM MiembrosMesa m")
public class MiembrosMesa extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idMiembro;
    private CargoEventoElectoral cargoEventoElectoral;
    private MesaElectoral mesaElectoral;
    private Vecino vecino;

    public MiembrosMesa() {
    }

    @Id
    @SequenceGenerator(name = "MiembrosMesaSequence", sequenceName = "miembros_mesa_id_miembro_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MiembrosMesaSequence")
    @Column(name = "id_miembro")
    public Integer getIdMiembro() {
	return this.idMiembro;
    }

    public void setIdMiembro(Integer idMiembro) {
	this.idMiembro = idMiembro;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    // bi-directional many-to-one association to CargoEventoElectoral
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cargo_evento")
    public CargoEventoElectoral getCargoEventoElectoral() {
	return this.cargoEventoElectoral;
    }

    public void setCargoEventoElectoral(CargoEventoElectoral cargoEventoElectoral) {
	this.cargoEventoElectoral = cargoEventoElectoral;
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

    // bi-directional many-to-one association to Vecino
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vecino")
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
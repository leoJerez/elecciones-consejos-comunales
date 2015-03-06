package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the cargo_evento_electoral database table.
 * 
 */
@Entity
@Table(name = "cargo_evento_electoral")
@NamedQuery(name = "CargoEventoElectoral.findAll", query = "SELECT c FROM CargoEventoElectoral c")
public class CargoEventoElectoral extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idCargoEvento;
    private String descripcion;
    private String nombre;
    private List<MiembrosMesa> miembrosMesas;

    public CargoEventoElectoral() {
    }

    @Id
    @SequenceGenerator(name = "CargoEventoSequence", sequenceName = "cargo_evento_electoral_id_cargo_evento_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CargoEventoSequence")
    @Column(name = "id_cargo_evento")
    public Integer getIdCargoEvento() {
	return this.idCargoEvento;
    }

    public void setIdCargoEvento(Integer idCargoEvento) {
	this.idCargoEvento = idCargoEvento;
    }

    public String getDescripcion() {
	return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
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

    // bi-directional many-to-one association to MiembrosMesa
    @OneToMany(mappedBy = "cargoEventoElectoral")
    public List<MiembrosMesa> getMiembrosMesas() {
	return this.miembrosMesas;
    }

    public void setMiembrosMesas(List<MiembrosMesa> miembrosMesas) {
	this.miembrosMesas = miembrosMesas;
    }

    public MiembrosMesa addMiembrosMesa(MiembrosMesa miembrosMesa) {
	getMiembrosMesas().add(miembrosMesa);
	miembrosMesa.setCargoEventoElectoral(this);

	return miembrosMesa;
    }

    public MiembrosMesa removeMiembrosMesa(MiembrosMesa miembrosMesa) {
	getMiembrosMesas().remove(miembrosMesa);
	miembrosMesa.setCargoEventoElectoral(null);

	return miembrosMesa;
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
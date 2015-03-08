package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the vehiculo_vivienda database table.
 * 
 */
@Entity
@Table(name = "vehiculo_vivienda")
@NamedQuery(name = "VehiculoVivienda.findAll", query = "SELECT v FROM VehiculoVivienda v")
public class VehiculoVivienda extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idVehiculoVivienda;
    private Vehiculo vehiculo;
    private Vivienda vivienda;

    public VehiculoVivienda() {
    }

    @Id
    @SequenceGenerator(name = "VehiculoViviendaSequence", sequenceName = "vehiculo_vivienda_id_vehiculo_vivienda_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VehiculoViviendaSequence")
    @Column(name = "id_vehiculo_vivienda")
    public Integer getIdVehiculoVivienda() {
	return this.idVehiculoVivienda;
    }

    public void setIdVehiculoVivienda(Integer idVehiculoVivienda) {
	this.idVehiculoVivienda = idVehiculoVivienda;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    // bi-directional many-to-one association to Vehiculo
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vehiculo")
    public Vehiculo getVehiculo() {
	return this.vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
	this.vehiculo = vehiculo;
    }

    // bi-directional many-to-one association to Vivienda
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vivienda")
    public Vivienda getVivienda() {
	return this.vivienda;
    }

    public void setVivienda(Vivienda vivienda) {
	this.vivienda = vivienda;
    }

    @Override
    public Object getPrimaryKey() {
	// TODO Auto-generated method stub
	return this.getIdVehiculoVivienda();
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return null;
    }

}
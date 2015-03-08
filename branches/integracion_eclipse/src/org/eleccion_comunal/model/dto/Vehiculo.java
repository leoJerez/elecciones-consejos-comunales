package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the vehiculo database table.
 * 
 */
@Entity
@NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
public class Vehiculo extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idVehiculo;
    private String anno;
    private String marca;
    private String modelo;
    private String placa;
    private List<VehiculoVivienda> vehiculoViviendas;

    public Vehiculo() {
    }

    @Id
    @SequenceGenerator(name = "VehiculoSequence", sequenceName = "vehiculo_id_vehiculo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VehiculoSequence")
    @Column(name = "id_vehiculo")
    public Integer getIdVehiculo() {
	return this.idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
	this.idVehiculo = idVehiculo;
    }

    public String getAnno() {
	return this.anno;
    }

    public void setAnno(String anno) {
	this.anno = anno;
    }

    public String getMarca() {
	return this.marca;
    }

    public void setMarca(String marca) {
	this.marca = marca;
    }

    public String getModelo() {
	return this.modelo;
    }

    public void setModelo(String modelo) {
	this.modelo = modelo;
    }

    public String getPlaca() {
	return this.placa;
    }

    public void setPlaca(String placa) {
	this.placa = placa;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    // bi-directional many-to-one association to VehiculoVivienda
    @OneToMany(mappedBy = "vehiculo")
    public List<VehiculoVivienda> getVehiculoViviendas() {
	return this.vehiculoViviendas;
    }

    public void setVehiculoViviendas(List<VehiculoVivienda> vehiculoViviendas) {
	this.vehiculoViviendas = vehiculoViviendas;
    }

    public VehiculoVivienda addVehiculoVivienda(VehiculoVivienda vehiculoVivienda) {
	getVehiculoViviendas().add(vehiculoVivienda);
	vehiculoVivienda.setVehiculo(this);

	return vehiculoVivienda;
    }

    public VehiculoVivienda removeVehiculoVivienda(VehiculoVivienda vehiculoVivienda) {
	getVehiculoViviendas().remove(vehiculoVivienda);
	vehiculoVivienda.setVehiculo(null);

	return vehiculoVivienda;
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
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        return (this.getIdVehiculo() != null || other.getIdVehiculo() == null) && (this.getIdVehiculo() == null || this.getIdVehiculo().equals(other.getIdVehiculo()));
    }

}
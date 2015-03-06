package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the vivienda database table.
 * 
 */
@Entity
@NamedQuery(name = "Vivienda.findAll", query = "SELECT v FROM Vivienda v")
public class Vivienda extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idVivienda;
    private String calle;
    private String cantidadBannos;
    private String cantidadHabitaciones;
    private String carrera;
    private String codigoPosteCercano;
    private String manzana;
    private String nombreCasa;
    private String numeroCasa;
    private List<VecinoVivienda> vecinoViviendas;
    private List<VehiculoVivienda> vehiculoViviendas;
    private ConsejoComunal consejoComunal;

    public Vivienda() {
    }

    @Id
    @SequenceGenerator(name = "ViviendaSequence", sequenceName = "vivienda_id_vivienda_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ViviendaSequence")
    @Column(name = "id_vivienda")
    public Integer getIdVivienda() {
	return this.idVivienda;
    }

    public void setIdVivienda(Integer idVivienda) {
	this.idVivienda = idVivienda;
    }

    public String getCalle() {
	return this.calle;
    }

    public void setCalle(String calle) {
	this.calle = calle;
    }

    @Column(name = "cantidad_bannos")
    public String getCantidadBannos() {
	return this.cantidadBannos;
    }

    public void setCantidadBannos(String cantidadBannos) {
	this.cantidadBannos = cantidadBannos;
    }

    @Column(name = "cantidad_habitaciones")
    public String getCantidadHabitaciones() {
	return this.cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(String cantidadHabitaciones) {
	this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public String getCarrera() {
	return this.carrera;
    }

    public void setCarrera(String carrera) {
	this.carrera = carrera;
    }

    @Column(name = "codigo_poste_cercano")
    public String getCodigoPosteCercano() {
	return this.codigoPosteCercano;
    }

    public void setCodigoPosteCercano(String codigoPosteCercano) {
	this.codigoPosteCercano = codigoPosteCercano;
    }

    public String getManzana() {
	return this.manzana;
    }

    public void setManzana(String manzana) {
	this.manzana = manzana;
    }

    @Column(name = "nombre_casa")
    public String getNombreCasa() {
	return this.nombreCasa;
    }

    public void setNombreCasa(String nombreCasa) {
	this.nombreCasa = nombreCasa;
    }

    @Column(name = "numero_casa")
    public String getNumeroCasa() {
	return this.numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
	this.numeroCasa = numeroCasa;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    // bi-directional many-to-one association to VecinoVivienda
    @OneToMany(mappedBy = "vivienda")
    public List<VecinoVivienda> getVecinoViviendas() {
	return this.vecinoViviendas;
    }

    public void setVecinoViviendas(List<VecinoVivienda> vecinoViviendas) {
	this.vecinoViviendas = vecinoViviendas;
    }

    public VecinoVivienda addVecinoVivienda(VecinoVivienda vecinoVivienda) {
	getVecinoViviendas().add(vecinoVivienda);
	vecinoVivienda.setVivienda(this);

	return vecinoVivienda;
    }

    public VecinoVivienda removeVecinoVivienda(VecinoVivienda vecinoVivienda) {
	getVecinoViviendas().remove(vecinoVivienda);
	vecinoVivienda.setVivienda(null);

	return vecinoVivienda;
    }

    // bi-directional many-to-one association to VehiculoVivienda
    @OneToMany(mappedBy = "vivienda")
    public List<VehiculoVivienda> getVehiculoViviendas() {
	return this.vehiculoViviendas;
    }

    public void setVehiculoViviendas(List<VehiculoVivienda> vehiculoViviendas) {
	this.vehiculoViviendas = vehiculoViviendas;
    }

    public VehiculoVivienda addVehiculoVivienda(VehiculoVivienda vehiculoVivienda) {
	getVehiculoViviendas().add(vehiculoVivienda);
	vehiculoVivienda.setVivienda(this);

	return vehiculoVivienda;
    }

    public VehiculoVivienda removeVehiculoVivienda(VehiculoVivienda vehiculoVivienda) {
	getVehiculoViviendas().remove(vehiculoVivienda);
	vehiculoVivienda.setVivienda(null);

	return vehiculoVivienda;
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
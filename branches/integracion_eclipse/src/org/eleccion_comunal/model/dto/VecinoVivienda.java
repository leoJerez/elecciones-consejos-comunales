package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the vecino_vivienda database table.
 * 
 */
@Entity
@Table(name = "vecino_vivienda")
@NamedQuery(name = "VecinoVivienda.findAll", query = "SELECT v FROM VecinoVivienda v")
public class VecinoVivienda extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idVecinoVivienda;
    private Vecino vecino;
    private Vivienda vivienda;

    public VecinoVivienda() {
    }

    @Id
    @SequenceGenerator(name = "VecinoViviendaSequence", sequenceName = "vecino_vivienda_id_vecino_vivienda_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VecinoViviendaSequence")
    @Column(name = "id_vecino_vivienda")
    public Integer getIdVecinoVivienda() {
	return this.idVecinoVivienda;
    }

    public void setIdVecinoVivienda(Integer idVecinoVivienda) {
	this.idVecinoVivienda = idVecinoVivienda;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
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

    // bi-directional many-to-one association to Vivienda
    @ManyToOne(fetch = FetchType.LAZY)
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
	return null;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return null;
    }

}
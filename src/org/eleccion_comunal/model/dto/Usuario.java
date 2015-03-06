package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idUsuario;
    private String login;
    private String password;
    private List<ConsejoComunal> consejoComunals;
    private Rol rol;
    private List<Vecino> vecinos;

    public Usuario() {
    }

    @Id
    @SequenceGenerator(name = "UsuarioSequence", sequenceName = "usuario_id_usuario_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsuarioSequence")
    @Column(name = "id_usuario")
    public Integer getIdUsuario() {
	return this.idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
	this.idUsuario = idUsuario;
    }

    public String getLogin() {
	return this.login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    // bi-directional many-to-one association to ConsejoComunal
    @OneToMany(mappedBy = "usuario")
    public List<ConsejoComunal> getConsejoComunals() {
	return this.consejoComunals;
    }

    public void setConsejoComunals(List<ConsejoComunal> consejoComunals) {
	this.consejoComunals = consejoComunals;
    }

    public ConsejoComunal addConsejoComunal(ConsejoComunal consejoComunal) {
	getConsejoComunals().add(consejoComunal);
	consejoComunal.setUsuario(this);

	return consejoComunal;
    }

    public ConsejoComunal removeConsejoComunal(ConsejoComunal consejoComunal) {
	getConsejoComunals().remove(consejoComunal);
	consejoComunal.setUsuario(null);

	return consejoComunal;
    }

    // bi-directional many-to-one association to Rol
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    public Rol getRol() {
	return this.rol;
    }

    public void setRol(Rol rol) {
	this.rol = rol;
    }

    // bi-directional many-to-one association to Vecino
    @OneToMany(mappedBy = "usuario")
    public List<Vecino> getVecinos() {
	return this.vecinos;
    }

    public void setVecinos(List<Vecino> vecinos) {
	this.vecinos = vecinos;
    }

    public Vecino addVecino(Vecino vecino) {
	getVecinos().add(vecino);
	vecino.setUsuario(this);

	return vecino;
    }

    public Vecino removeVecino(Vecino vecino) {
	getVecinos().remove(vecino);
	vecino.setUsuario(null);

	return vecino;
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
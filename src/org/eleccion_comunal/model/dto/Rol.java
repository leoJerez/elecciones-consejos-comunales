package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol extends EntidadGenerica implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idRol;
	private String descripcion;
	private String nombre;
	private List<Usuario> usuarios;

	public Rol() {
	}


	@Id
	@SequenceGenerator(name="ROL_IDROL_GENERATOR", sequenceName = "rol_id_rol_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_IDROL_GENERATOR")
	@Column(name="id_rol")
	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
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


	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="rol")
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRol(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRol(null);

		return usuario;
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
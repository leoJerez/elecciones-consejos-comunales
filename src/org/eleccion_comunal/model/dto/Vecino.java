package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the vecino database table.
 * 
 */
@Entity
@NamedQuery(name = "Vecino.findAll", query = "SELECT v FROM Vecino v")
public class Vecino extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idVecino;
    private String apellido;
    private String cedula;
    private String celular;
    private String correo;
    private String estadoCivil;
    private Date fechaIngresoComunidad;
    private Date fechaNacimiento;
    private byte[] imagen;
    private String nombre;
    private String profesionOcupacion;
    private String sexo;
    private String telefono;
    private String urlFoto;
    private List<Candidato> candidatos;
    private List<MiembrosConsejo> miembrosConsejos;
    private List<MiembrosMesa> miembrosMesas;
    private Usuario usuario;
    private List<VecinoVivienda> vecinoViviendas;

    public Vecino() {
    }

    @Id
    @SequenceGenerator(name = "VecinoSequence", sequenceName = "vecino_id_vecino_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VecinoSequence")
    @Column(name = "id_vecino")
    public Integer getIdVecino() {
	return this.idVecino;
    }

    public void setIdVecino(Integer idVecino) {
	this.idVecino = idVecino;
    }

    public String getApellido() {
	return this.apellido;
    }

    public void setApellido(String apellido) {
	this.apellido = apellido;
    }

    public String getCedula() {
	return this.cedula;
    }

    public void setCedula(String cedula) {
	this.cedula = cedula;
    }

    public String getCelular() {
	return this.celular;
    }

    public void setCelular(String celular) {
	this.celular = celular;
    }

    public String getCorreo() {
	return this.correo;
    }

    public void setCorreo(String correo) {
	this.correo = correo;
    }

    @Column(name = "estado_civil")
    public String getEstadoCivil() {
	return this.estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
	this.estadoCivil = estadoCivil;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_ingreso_comunidad")
    public Date getFechaIngresoComunidad() {
	return this.fechaIngresoComunidad;
    }

    public void setFechaIngresoComunidad(Date fechaIngresoComunidad) {
	this.fechaIngresoComunidad = fechaIngresoComunidad;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    public Date getFechaNacimiento() {
	return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
    }

    public byte[] getImagen() {
	return this.imagen;
    }

    public void setImagen(byte[] imagen) {
	this.imagen = imagen;
    }

    public String getNombre() {
	return this.nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    @Column(name = "profesion_ocupacion")
    public String getProfesionOcupacion() {
	return this.profesionOcupacion;
    }

    public void setProfesionOcupacion(String profesionOcupacion) {
	this.profesionOcupacion = profesionOcupacion;
    }

    public String getSexo() {
	return this.sexo;
    }

    public void setSexo(String sexo) {
	this.sexo = sexo;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getTelefono() {
	return this.telefono;
    }

    public void setTelefono(String telefono) {
	this.telefono = telefono;
    }

    @Column(name = "url_foto")
    public String getUrlFoto() {
	return this.urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
	this.urlFoto = urlFoto;
    }

    // bi-directional many-to-one association to Candidato
    @OneToMany(mappedBy = "vecino")
    public List<Candidato> getCandidatos() {
	return this.candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
	this.candidatos = candidatos;
    }

    public Candidato addCandidato(Candidato candidato) {
	getCandidatos().add(candidato);
	candidato.setVecino(this);

	return candidato;
    }

    public Candidato removeCandidato(Candidato candidato) {
	getCandidatos().remove(candidato);
	candidato.setVecino(null);

	return candidato;
    }

    // bi-directional many-to-one association to MiembrosConsejo
    @OneToMany(mappedBy = "vecino")
    public List<MiembrosConsejo> getMiembrosConsejos() {
	return this.miembrosConsejos;
    }

    public void setMiembrosConsejos(List<MiembrosConsejo> miembrosConsejos) {
	this.miembrosConsejos = miembrosConsejos;
    }

    public MiembrosConsejo addMiembrosConsejo(MiembrosConsejo miembrosConsejo) {
	getMiembrosConsejos().add(miembrosConsejo);
	miembrosConsejo.setVecino(this);

	return miembrosConsejo;
    }

    public MiembrosConsejo removeMiembrosConsejo(MiembrosConsejo miembrosConsejo) {
	getMiembrosConsejos().remove(miembrosConsejo);
	miembrosConsejo.setVecino(null);

	return miembrosConsejo;
    }

    // bi-directional many-to-one association to MiembrosMesa
    @OneToMany(mappedBy = "vecino")
    public List<MiembrosMesa> getMiembrosMesas() {
	return this.miembrosMesas;
    }

    public void setMiembrosMesas(List<MiembrosMesa> miembrosMesas) {
	this.miembrosMesas = miembrosMesas;
    }

    public MiembrosMesa addMiembrosMesa(MiembrosMesa miembrosMesa) {
	getMiembrosMesas().add(miembrosMesa);
	miembrosMesa.setVecino(this);

	return miembrosMesa;
    }

    public MiembrosMesa removeMiembrosMesa(MiembrosMesa miembrosMesa) {
	getMiembrosMesas().remove(miembrosMesa);
	miembrosMesa.setVecino(null);

	return miembrosMesa;
    }

    // bi-directional many-to-one association to Usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    public Usuario getUsuario() {
	return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    // bi-directional many-to-one association to VecinoVivienda
    @OneToMany(mappedBy = "vecino")
    public List<VecinoVivienda> getVecinoViviendas() {
	return this.vecinoViviendas;
    }

    public void setVecinoViviendas(List<VecinoVivienda> vecinoViviendas) {
	this.vecinoViviendas = vecinoViviendas;
    }

    public VecinoVivienda addVecinoVivienda(VecinoVivienda vecinoVivienda) {
	getVecinoViviendas().add(vecinoVivienda);
	vecinoVivienda.setVecino(this);

	return vecinoVivienda;
    }

    public VecinoVivienda removeVecinoVivienda(VecinoVivienda vecinoVivienda) {
	getVecinoViviendas().remove(vecinoVivienda);
	vecinoVivienda.setVecino(null);

	return vecinoVivienda;
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
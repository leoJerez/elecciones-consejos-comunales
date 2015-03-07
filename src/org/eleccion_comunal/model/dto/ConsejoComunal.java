package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the consejo_comunal database table.
 * 
 */
@Entity
@Table(name = "consejo_comunal")
@NamedQuery(name = "ConsejoComunal.findAll", query = "SELECT c FROM ConsejoComunal c")
public class ConsejoComunal extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idConsejoComunal;
    private String celular;
    private String codigoRegistroFundacomunal;
    private String correo;
    private String dataWidgetId;
    private Date fechaCreacion;
    private String hrefTwitter;
    private String linderoEste;
    private String linderoNorte;
    private String linderoOeste;
    private String linderoSur;
    private String mision;
    private String nombre;
    private String rif;
    private String sector;
    private String telefono;
    private String vision;
    private List<Cargo> cargos;
    private List<CarteleraInformativa> carteleraInformativas;
    private Parroquia parroquia;
    private Usuario usuario;
    private List<Vivienda> viviendas;

    public ConsejoComunal() {
    }

    @Id
    @SequenceGenerator(name = "ConsejoComunalSequence", sequenceName = "consejo_comunal_id_consejo_comunal_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ConsejoComunalSequence")
    @Column(name = "id_consejo_comunal")
    public Integer getIdConsejoComunal() {
	return this.idConsejoComunal;
    }

    public void setIdConsejoComunal(Integer idConsejoComunal) {
	this.idConsejoComunal = idConsejoComunal;
    }

    public String getCelular() {
	return this.celular;
    }

    public void setCelular(String celular) {
	this.celular = celular;
    }

    @Column(name = "codigo_registro_fundacomunal")
    public String getCodigoRegistroFundacomunal() {
	return this.codigoRegistroFundacomunal;
    }

    public void setCodigoRegistroFundacomunal(String codigoRegistroFundacomunal) {
	this.codigoRegistroFundacomunal = codigoRegistroFundacomunal;
    }

    public String getCorreo() {
	return this.correo;
    }

    public void setCorreo(String correo) {
	this.correo = correo;
    }

    @Column(name = "data_widget_id")
    public String getDataWidgetId() {
	return this.dataWidgetId;
    }

    public void setDataWidgetId(String dataWidgetId) {
	this.dataWidgetId = dataWidgetId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_creacion")
    public Date getFechaCreacion() {
	return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
	this.fechaCreacion = fechaCreacion;
    }

    @Column(name = "href_twitter")
    public String getHrefTwitter() {
	return this.hrefTwitter;
    }

    public void setHrefTwitter(String hrefTwitter) {
	this.hrefTwitter = hrefTwitter;
    }

    @Column(name = "lindero_este")
    public String getLinderoEste() {
	return this.linderoEste;
    }

    public void setLinderoEste(String linderoEste) {
	this.linderoEste = linderoEste;
    }

    @Column(name = "lindero_norte")
    public String getLinderoNorte() {
	return this.linderoNorte;
    }

    public void setLinderoNorte(String linderoNorte) {
	this.linderoNorte = linderoNorte;
    }

    @Column(name = "lindero_oeste")
    public String getLinderoOeste() {
	return this.linderoOeste;
    }

    public void setLinderoOeste(String linderoOeste) {
	this.linderoOeste = linderoOeste;
    }

    @Column(name = "lindero_sur")
    public String getLinderoSur() {
	return this.linderoSur;
    }

    public void setLinderoSur(String linderoSur) {
	this.linderoSur = linderoSur;
    }

    public String getMision() {
	return this.mision;
    }

    public void setMision(String mision) {
	this.mision = mision;
    }

    public String getNombre() {
	return this.nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getRif() {
	return this.rif;
    }

    public void setRif(String rif) {
	this.rif = rif;
    }

    public String getSector() {
	return this.sector;
    }

    public void setSector(String sector) {
	this.sector = sector;
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

    public String getVision() {
	return this.vision;
    }

    public void setVision(String vision) {
	this.vision = vision;
    }

    // bi-directional many-to-one association to Cargo
    @OneToMany(mappedBy = "consejoComunal")
    public List<Cargo> getCargos() {
	return this.cargos;
    }

    public void setCargos(List<Cargo> cargos) {
	this.cargos = cargos;
    }

    public Cargo addCargo(Cargo cargo) {
	getCargos().add(cargo);
	cargo.setConsejoComunal(this);

	return cargo;
    }

    public Cargo removeCargo(Cargo cargo) {
	getCargos().remove(cargo);
	cargo.setConsejoComunal(null);

	return cargo;
    }

    // bi-directional many-to-one association to CarteleraInformativa
    @OneToMany(mappedBy = "consejoComunal")
    public List<CarteleraInformativa> getCarteleraInformativas() {
	return this.carteleraInformativas;
    }

    public void setCarteleraInformativas(List<CarteleraInformativa> carteleraInformativas) {
	this.carteleraInformativas = carteleraInformativas;
    }

    public CarteleraInformativa addCarteleraInformativa(CarteleraInformativa carteleraInformativa) {
	getCarteleraInformativas().add(carteleraInformativa);
	carteleraInformativa.setConsejoComunal(this);

	return carteleraInformativa;
    }

    public CarteleraInformativa removeCarteleraInformativa(CarteleraInformativa carteleraInformativa) {
	getCarteleraInformativas().remove(carteleraInformativa);
	carteleraInformativa.setConsejoComunal(null);

	return carteleraInformativa;
    }

    // bi-directional many-to-one association to Parroquia
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_parroquia")
    public Parroquia getParroquia() {
	return this.parroquia;
    }

    public void setParroquia(Parroquia parroquia) {
	this.parroquia = parroquia;
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

    // bi-directional many-to-one association to Vivienda
    @OneToMany(mappedBy = "consejoComunal")
    public List<Vivienda> getViviendas() {
	return this.viviendas;
    }

    public void setViviendas(List<Vivienda> viviendas) {
	this.viviendas = viviendas;
    }

    public Vivienda addVivienda(Vivienda vivienda) {
	getViviendas().add(vivienda);
	vivienda.setConsejoComunal(this);

	return vivienda;
    }

    public Vivienda removeVivienda(Vivienda vivienda) {
	getViviendas().remove(vivienda);
	vivienda.setConsejoComunal(null);

	return vivienda;
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
	// TODO: Warning - this method won't work in the case the elementId
	// fields are not set
	if (!(object instanceof ConsejoComunal)) {
	    return false;
	}
	ConsejoComunal other = (ConsejoComunal) object;
	if ((this.idConsejoComunal == null && other.idConsejoComunal != null) || (this.idConsejoComunal != null && !this.idConsejoComunal.equals(other.idConsejoComunal))) {
	    return false;
	}
	return true;
    }

}
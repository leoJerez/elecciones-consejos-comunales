package org.eleccion_comunal.model.dto;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the cartelera_informativa database table.
 * 
 */
@Entity
@Table(name = "cartelera_informativa")
@NamedQuery(name = "CarteleraInformativa.findAll", query = "SELECT c FROM CarteleraInformativa c")
public class CarteleraInformativa extends EntidadGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idNoticia;
    private String autor;
    private String contenido;
    private Date fechaPublicacion;
    private byte[] imagen;
    private String titulo;
    private String urlImagen;
    private ConsejoComunal consejoComunal;

    public CarteleraInformativa() {
    }

    @Id
    @SequenceGenerator(name = "CarteleraSequence", sequenceName = "cartelera_informativa_id_noticia_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CarteleraSequence")
    @Column(name = "id_noticia")
    public Integer getIdNoticia() {
	return this.idNoticia;
    }

    public void setIdNoticia(Integer idNoticia) {
	this.idNoticia = idNoticia;
    }

    public String getAutor() {
	return this.autor;
    }

    public void setAutor(String autor) {
	this.autor = autor;
    }

    public String getContenido() {
	return this.contenido;
    }

    public void setContenido(String contenido) {
	this.contenido = contenido;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_publicacion")
    public Date getFechaPublicacion() {
	return this.fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
	this.fechaPublicacion = fechaPublicacion;
    }

    public byte[] getImagen() {
	return this.imagen;
    }

    public void setImagen(byte[] imagen) {
	this.imagen = imagen;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getTitulo() {
	return this.titulo;
    }

    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }

    @Column(name = "url_imagen")
    public String getUrlImagen() {
	return this.urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
	this.urlImagen = urlImagen;
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
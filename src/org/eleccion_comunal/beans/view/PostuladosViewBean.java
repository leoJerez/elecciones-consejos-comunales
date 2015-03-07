package org.eleccion_comunal.beans.view;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.view.ViewScoped;

import org.eleccion_comunal.beans.application.EleccionComunalApplicationBean;
import org.eleccion_comunal.enums.Estado;
import org.eleccion_comunal.model.dao.CandidatoDAO;
import org.eleccion_comunal.model.dao.ConsejoComunalDAO;
import org.eleccion_comunal.model.dao.EleccionDAO;
import org.eleccion_comunal.model.dto.Candidato;
import org.eleccion_comunal.model.dto.Eleccion;
import org.eleccion_comunal.utilidades.Formateador;
import org.eleccion_comunal.utilidades.ManejadorFechas;
import org.eleccion_comunal.utilidades.PropertiesLocator;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "postuladosViewBean")
@ViewScoped
public class PostuladosViewBean implements Serializable {

    private static final long serialVersionUID = 187L;
    private List<String> imagenesPostulados;
    private List<Candidato> listaCandidatos;
    private List<Eleccion> listaElecciones;
    private Eleccion eleccion;
    private int annoEleccion;
    
//    @ManagedProperty(value = "#{eleccionComunalApplicationBean}")
//    private EleccionComunalApplicationBean eleccionComunalApplicationBean;

    public PostuladosViewBean() {
	// TODO Auto-generated constructor stub
    }

    @PostConstruct
    public void init() {
	this.cargarImagenesPostulados();
	this.setEleccion(this.buscarProximaElecion());
	this.setListaCandidatos(this.obtenerCandidatos(eleccion));
	this.setAnnoEleccion(this.obtenerAnnoEleccion(this.getEleccion()));
    }

    public List<String> getImagenesPostulados() {
	if (imagenesPostulados == null) {
	    imagenesPostulados = new ArrayList<String>();
	}
	return imagenesPostulados;
    }

    public void setImagenesPostulados(List<String> imagenesPostulados) {
	this.imagenesPostulados = imagenesPostulados;
    }

    public List<Candidato> getListaCandidatos() {
	if (listaCandidatos == null) {
	    listaCandidatos = new ArrayList<Candidato>();
	}
	return listaCandidatos;
    }

    public void setListaCandidatos(List<Candidato> listaCandidatos) {
	this.listaCandidatos = listaCandidatos;
    }
    
    public List<Eleccion> getListaElecciones() {
	if (listaElecciones == null) {
	    listaElecciones = new ArrayList<Eleccion>();
	}
        return listaElecciones;
    }

    public void setListaElecciones(List<Eleccion> listaElecciones) {
        this.listaElecciones = listaElecciones;
    }

    public Eleccion getEleccion() {
	if (eleccion == null) {
	    eleccion = new Eleccion();
	}
        return eleccion;
    }

    public void setEleccion(Eleccion eleccion) {
        this.eleccion = eleccion;
    }

    public int getAnnoEleccion() {
        return annoEleccion;
    }

    public void setAnnoEleccion(int annoEleccion) {
        this.annoEleccion = annoEleccion;
    }

    public void cargarImagenesPostulados() {
	// this.getImagenesPostulados().add(
	// PropertiesLocator.getProperty("urlFotoVecino") + "add.png");
	this.getImagenesPostulados().add("H2");
	this.getImagenesPostulados().add("M1");
	this.getImagenesPostulados().add("M2");
	this.getImagenesPostulados().add("M3");
	this.getImagenesPostulados().add("H2");
	this.getImagenesPostulados().add("H3");
    }

    public StreamedContent obtenerImagen(String ruta) {

	FacesContext context = FacesContext.getCurrentInstance();

	try {
	    System.out.println("ENTRAMOS");
	    // String ruta =
	    // context.getExternalContext().getRequestParameterMap().get("fotoPostulado");
	    System.out.println("***--- " + ruta);
	    // Path path = Paths.get(ruta);
	    // byte[] data = Files.readAllBytes(path);
	    // System.out.println("==== " + data);
	    // return new DefaultStreamedContent(
	    // new ByteArrayInputStream(data));

	    File archivo = new File(ruta);
	    System.out.println("EXISTE: " + archivo.isFile());
	    return new DefaultStreamedContent(new FileInputStream(archivo));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return new DefaultStreamedContent();

    }
    
    public Eleccion buscarProximaElecion() {
	this.getListaElecciones().addAll((List<Eleccion>) EleccionDAO.getInstancia().buscarTodasEntidades());
	Collections.sort(this.getListaElecciones());
	for (Eleccion eleccion : this.getListaElecciones()) {
	    if (eleccion.getCandidatos() != null && !eleccion.getCandidatos().isEmpty()) {
//		if (eleccion.getCandidatos().get(0).getCargo().getConsejoComunal().equals(this.eleccionComunalApplicationBean.getConsejoComunal())) {
		if (eleccion.getCandidatos().get(0).getCargo().getConsejoComunal().equals(ConsejoComunalDAO.getInstancia().buscarEntidadPorClave(1))) {
		    return eleccion;
		}
	    }
	}
	return new Eleccion();
    }
    
    public int obtenerAnnoEleccion(Eleccion eleccion) {
	if (eleccion.getFechaEvento() != null) {
	    Calendar fechaEleccion = new GregorianCalendar();
	    fechaEleccion.setTime(eleccion.getFechaEvento());
	    return fechaEleccion.get(Calendar.YEAR);
	} 
	return 0;
    }
    
    public List<Candidato> obtenerCandidatos(Eleccion eleccion) {
	List<Candidato> candidatosAprobados = new ArrayList<Candidato>();
	if (eleccion != null && eleccion.getCandidatos() != null && !eleccion.getCandidatos().isEmpty()) {
	    for (Candidato candidato : eleccion.getCandidatos()) {
		if (candidato.getEstado().equalsIgnoreCase(Estado.CANDIDATO_ESTADO_APROBADO.getValor())) {
		    candidatosAprobados.add(candidato);
		}
	    }
	}
	return candidatosAprobados;
    }
    
    public int obtenerEdadCandidato(Date fechaNacimiento) {
	return ManejadorFechas.getInstancia().calcularEdad(fechaNacimiento);
    }
    
    public String obtenerFechaIngresoComunidadCandidato(Date fechaIngreso) {
	return Formateador.getInstancia().formatearFechaEstiloLargo(fechaIngreso);
    }
}

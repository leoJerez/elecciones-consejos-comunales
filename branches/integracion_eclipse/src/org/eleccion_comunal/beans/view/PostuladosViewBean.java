package org.eleccion_comunal.beans.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.eleccion_comunal.beans.controller.AccionarSobreElecciones;
import org.eleccion_comunal.enums.Estado;
import org.eleccion_comunal.model.dao.CandidatoDAO;
import org.eleccion_comunal.model.dao.CargoDAO;
import org.eleccion_comunal.model.dao.ConsejoComunalDAO;
import org.eleccion_comunal.model.dao.EleccionDAO;
import org.eleccion_comunal.model.dao.VecinoDAO;
import org.eleccion_comunal.model.dto.Candidato;
import org.eleccion_comunal.model.dto.Cargo;
import org.eleccion_comunal.model.dto.ConsejoComunal;
import org.eleccion_comunal.model.dto.Eleccion;
import org.eleccion_comunal.model.dto.Vecino;
import org.eleccion_comunal.model.dto.VotoCandidatoMesa;
import org.eleccion_comunal.utilidades.Formateador;
import org.eleccion_comunal.utilidades.GeneradorMensajes;
import org.eleccion_comunal.utilidades.ManejadorFechas;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "postuladosViewBean")
@ViewScoped
public class PostuladosViewBean implements Serializable {

    private static final long serialVersionUID = 187L;
    private List<Candidato> listaCandidatos;
    private List<Eleccion> listaElecciones;
    private List<Cargo>	listaCargos;
    private Eleccion eleccion;
    private Candidato postulado;
    private Vecino vecino;
    private int annoEleccion;
    private boolean existeVecino;
    private String mensajeBusqueda;

    // @ManagedProperty(value = "#{eleccionComunalApplicationBean}")
    // private EleccionComunalApplicationBean eleccionComunalApplicationBean;

    public PostuladosViewBean() {
	// TODO Auto-generated constructor stub
    }

    @PostConstruct
    public void init() {
	this.setExisteVecino(false);
	this.setEleccion(AccionarSobreElecciones.getInstancia().buscarProximaElecion());
	this.setListaCandidatos(AccionarSobreElecciones.getInstancia().obtenerCandidatos(eleccion));
	this.setAnnoEleccion(AccionarSobreElecciones.getInstancia().obtenerAnnoEleccion(this.getEleccion()));
	this.getListaCargos().addAll(AccionarSobreElecciones.getInstancia().buscarCargos((ConsejoComunal)ConsejoComunalDAO.getInstancia().buscarEntidadPorClave(1)));
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

    public List<Cargo> getListaCargos() {
	if (listaCargos == null) {
	    listaCargos = new ArrayList<Cargo>();
	}
        return listaCargos;
    }

    public void setListaCargos(List<Cargo> listaCargos) {
        this.listaCargos = listaCargos;
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

    public Candidato getPostulado() {
	if (postulado == null) {
	    postulado = new Candidato();
	}
	return postulado;
    }

    public void setPostulado(Candidato postulado) {
	this.postulado = postulado;
    }

    public Vecino getVecino() {
	if (vecino == null) {
	    vecino = new Vecino();
	}
	return vecino;
    }

    public void setVecino(Vecino vecino) {
	this.vecino = vecino;
    }

    public int getAnnoEleccion() {
	return annoEleccion;
    }

    public void setAnnoEleccion(int annoEleccion) {
	this.annoEleccion = annoEleccion;
    }

    public boolean isExisteVecino() {
	return existeVecino;
    }

    public void setExisteVecino(boolean existeVecino) {
	this.existeVecino = existeVecino;
    }

    public String getMensajeBusqueda() {
	return mensajeBusqueda;
    }

    public void setMensajeBusqueda(String mensajeBusqueda) {
	this.mensajeBusqueda = mensajeBusqueda;
    }

    public int obtenerEdadCandidato(Date fechaNacimiento) {
	return ManejadorFechas.getInstancia().calcularEdad(fechaNacimiento);
    }

    public String obtenerFechaIngresoComunidadCandidato(Date fechaIngreso) {
	return Formateador.getInstancia().formatearFechaEstiloLargo(fechaIngreso);
    }
    
    public void buscarVecino() {
	List<String> cadenaMensajes = new ArrayList<String>();
	Vecino vecino = AccionarSobreElecciones.getInstancia().buscarEnRegistroElectoral(this.getVecino().getCedula());
	if (vecino != null) {
	    this.setVecino(vecino);
		this.getPostulado().setVecino(this.getVecino());
	    this.setExisteVecino(true);
	    this.setMensajeBusqueda("");
	} else {
	    this.setExisteVecino(false);
	    cadenaMensajes.add("Cédula no encontrada");
	    cadenaMensajes.add("Cédula no registrada o el portador aun no es mayor de 15 años");
	    this.setMensajeBusqueda("Cédula no registrada o el portador aun no es mayor de 15 años");
	    GeneradorMensajes.getInstancia().generarMensaje('F', cadenaMensajes);
	}
    }
    
    public void guardarPostulacion() {
	List<VotoCandidatoMesa> votoCandidatoMesas = new ArrayList<VotoCandidatoMesa>();
	this.getPostulado().setVecino(this.getVecino());
	this.getPostulado().setCantidadVotos(0);
	this.getPostulado().setEleccion(this.getEleccion());
	this.getPostulado().setVotoCandidatoMesas(votoCandidatoMesas);
	this.getPostulado().setEstado(Estado.CANDIDATO_ESTADO_EN_PROCESO.getValor());
	CandidatoDAO.getInstancia().insertarOActualizar(this.getPostulado());
    }

    
}

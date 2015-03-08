package org.eleccion_comunal.beans.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import org.eleccion_comunal.enums.Estado;
import org.eleccion_comunal.model.dao.CargoDAO;
import org.eleccion_comunal.model.dao.ConsejoComunalDAO;
import org.eleccion_comunal.model.dao.EleccionDAO;
import org.eleccion_comunal.model.dao.VecinoDAO;
import org.eleccion_comunal.model.dto.Candidato;
import org.eleccion_comunal.model.dto.Cargo;
import org.eleccion_comunal.model.dto.ConsejoComunal;
import org.eleccion_comunal.model.dto.Eleccion;
import org.eleccion_comunal.model.dto.Vecino;
import org.eleccion_comunal.utilidades.Formateador;
import org.eleccion_comunal.utilidades.ManejadorFechas;

public class AccionarSobreElecciones implements Serializable {

    private static final long serialVersionUID = -6240988018564L;

    private static AccionarSobreElecciones instancia;

    private AccionarSobreElecciones() {
	super();
    }

    public static AccionarSobreElecciones getInstancia() {
	if (instancia == null) {
	    instancia = new AccionarSobreElecciones();
	}
	return instancia;
    }
    /**
     * Este método se encarga de buscar todos los vecinos que tengan mas que 15
     * años
     * 
     * @return Lista de vecinos con más de 15 años
     */
    public List<Vecino> obtenerRegistroElectoral() {
	List<Vecino> listaTodosVecinos = (List<Vecino>) VecinoDAO.getInstancia().buscarTodasEntidades();
	List<Vecino> registroElectoral = new ArrayList<Vecino>();
	for (Vecino vecino : listaTodosVecinos) {
	    if (ManejadorFechas.getInstancia().calcularEdad(vecino.getFechaNacimiento()) >= 15) {
		registroElectoral.add(vecino);
	    }
	}
	return registroElectoral;
    }


    /**
     * Este metodo busca una cédula en el registro elecctoral, es decir,
     * verifica si es mayor de 15 años
     * 
     * @param cedula
     *            a buscar
     * @return Vecino que está registrado
     */
    public Vecino buscarEnRegistroElectoral(String cedula) {
	for (Vecino vecinoRegistrado : this.obtenerRegistroElectoral()) {
	    if (vecinoRegistrado.getCedula().equalsIgnoreCase(cedula)) {
		return vecinoRegistrado;
	    }
	}
	return null;
    }
    
    /**
     * Este método retorna el año del próximo evento electoral
     * @param eleccion
     * @return
     */
    public int obtenerAnnoEleccion(Eleccion eleccion) {
	if (eleccion.getFechaEvento() != null) {
	    Calendar fechaEleccion = new GregorianCalendar();
	    fechaEleccion.setTime(eleccion.getFechaEvento());
	    return fechaEleccion.get(Calendar.YEAR);
	}
	return 0;
    }

    /**
     * Este método retorna la lista de los candidatos aprobados para las elecciones que pasan por parámetro
     * @param Eleccion
     * @return lista de candidatos
     */
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

    /**
     * Este método retorna la lista de los candidatos que aun no se han evaluado para las elecciones que pasan por parámetro
     * @param Eleccion
     * @return lista de candidatos
     */
    public List<Candidato> obtenerCandidatosSinEvaluar(Eleccion eleccion) {
	List<Candidato> candidatosEnProceso = new ArrayList<Candidato>();
	if (eleccion != null && eleccion.getCandidatos() != null && !eleccion.getCandidatos().isEmpty()) {
	    for (Candidato candidato : eleccion.getCandidatos()) {
		if (candidato.getEstado().equalsIgnoreCase(Estado.CANDIDATO_ESTADO_EN_PROCESO.getValor())) {
		    candidatosEnProceso.add(candidato);
		}
	    }
	}
	return candidatosEnProceso;
    }
    
    /**
     * Obtiene la lista de cargos para el consejo comunal que entra por parámetro
     * @param consejoComunal
     * @return
     */
    public List<Cargo> buscarCargos(ConsejoComunal consejoComunal) {
	List<Cargo> cargosDisponibles = new ArrayList<Cargo>();
	cargosDisponibles = (List<Cargo>) CargoDAO.getInstancia().buscarEntidadesPorPropiedad("consejoComunal", consejoComunal);
	return cargosDisponibles;
    }

    /**
     * Este método busca el evento electoral más próximo
     * @return
     */
    public Eleccion buscarProximaElecion() {
	List<Eleccion> listaCompletaEleciones = new ArrayList<Eleccion>();
	listaCompletaEleciones.addAll((List<Eleccion>) EleccionDAO.getInstancia().buscarTodasEntidades());
//	this.getListaElecciones().addAll((List<Eleccion>) EleccionDAO.getInstancia().buscarTodasEntidades());
	Collections.sort(listaCompletaEleciones);
	for (Eleccion eleccion : listaCompletaEleciones) {
	    if (eleccion.getCandidatos() != null && !eleccion.getCandidatos().isEmpty()) {
		if (eleccion.getCandidatos().get(0).getCargo().getConsejoComunal().equals(ConsejoComunalDAO.getInstancia().buscarEntidadPorClave(1))) {
		    return eleccion;
		}
	    }
	}
	return new Eleccion();
    }
}

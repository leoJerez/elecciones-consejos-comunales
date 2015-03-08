package org.eleccion_comunal.beans.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.eleccion_comunal.beans.controller.AccionarSobreElecciones;
import org.eleccion_comunal.model.dto.Vecino;
import org.eleccion_comunal.utilidades.Formateador;
import org.eleccion_comunal.utilidades.GeneradorMensajes;
import org.eleccion_comunal.utilidades.ManejadorFechas;

@ManagedBean(name = "registroElectoralViewBean")
@ViewScoped
public class RegistroElectoralViewBean implements Serializable {
	private static final long serialVersionUID = 187L;
	private List<Vecino> listadoDeVotantes;
	private Vecino vecino;
	private boolean existeVecino;
	private boolean renderPanel;

	public RegistroElectoralViewBean() {

	}

	@PostConstruct
	public void init() {
		this.getListadoDeVotantes().addAll(
				AccionarSobreElecciones.getInstancia()
						.obtenerRegistroElectoral());
		this.setExisteVecino(false);
		this.setRenderPanel(false);
	}

	public List<Vecino> getListadoDeVotantes() {
		if (listadoDeVotantes == null) {
			listadoDeVotantes = new ArrayList<Vecino>();
		}
		return listadoDeVotantes;
	}

	public void setListadoDeVotantes(List<Vecino> listadoDeVotantes) {
		this.listadoDeVotantes = listadoDeVotantes;
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

	public boolean isExisteVecino() {
		return existeVecino;
	}

	public void setExisteVecino(boolean existeVecino) {
		this.existeVecino = existeVecino;
	}

	public boolean isRenderPanel() {
		return renderPanel;
	}

	public void setRenderPanel(boolean renderPanel) {
		this.renderPanel = renderPanel;
	}

	public int obtenerEdadCandidato(Date fechaNacimiento) {
		return ManejadorFechas.getInstancia().calcularEdad(fechaNacimiento);
	}

	public void buscarVecino() {
		List<String> cadenaMensajes = new ArrayList<String>();
		Vecino vecino = AccionarSobreElecciones.getInstancia()
				.buscarEnRegistroElectoral(this.getVecino().getCedula());
		if (vecino != null) {
			this.setVecino(vecino);
			this.setExisteVecino(true);
			this.setRenderPanel(true);
			if (this.fechaProximasElecciones() != null) {
				cadenaMensajes.add("Informarción:");
				cadenaMensajes.add("Las proximas elecciones son el "
						+ this.fechaProximasElecciones() + ".");
				GeneradorMensajes.getInstancia().generarMensaje('I',
						cadenaMensajes);
			}
		} else {
			this.setExisteVecino(false);
			cadenaMensajes.add("Cédula no encontrada");
			cadenaMensajes
					.add("Cédula no registrada o el portador aun no es mayor de 15 años");
			GeneradorMensajes.getInstancia()
					.generarMensaje('F', cadenaMensajes);
		}
	}

	public void limpiarCampoDeBusqueda() {
		this.setVecino(new Vecino());
	}

	public String fechaProximasElecciones() {
		return Formateador.getInstancia().formatearFechaEstiloCompleto(
				AccionarSobreElecciones.getInstancia().buscarProximaElecion()
						.getFechaEvento());
	}
}

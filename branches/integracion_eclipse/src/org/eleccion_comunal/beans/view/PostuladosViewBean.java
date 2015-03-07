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
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.view.ViewScoped;

import org.eleccion_comunal.model.dto.Candidato;
import org.eleccion_comunal.utilidades.PropertiesLocator;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "postuladosViewBean")
@ViewScoped
public class PostuladosViewBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<String> imagenesPostulados;
	private List<Candidato> listaCandidatos;

	public PostuladosViewBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		this.cargarImagenesPostulados();
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
		if(listaCandidatos == null){
			listaCandidatos = new ArrayList<Candidato>();
		}
		return listaCandidatos;
	}

	public void setListaCandidatos(List<Candidato> listaCandidatos) {
		this.listaCandidatos = listaCandidatos;
	}

	public void cargarImagenesPostulados() {
//		this.getImagenesPostulados().add(
//				PropertiesLocator.getProperty("urlFotoVecino") + "add.png");
		this.getImagenesPostulados()
				.add("H2");
		this.getImagenesPostulados()
				.add("M1");
		this.getImagenesPostulados()
		.add("M2");
		this.getImagenesPostulados()
		.add("M3");
		this.getImagenesPostulados()
		.add("H2");
		this.getImagenesPostulados()
		.add("H3");
	}

	public StreamedContent obtenerImagen(String ruta) {

		FacesContext context = FacesContext.getCurrentInstance();
		
			try {
				System.out.println("ENTRAMOS");
//				String ruta = context.getExternalContext().getRequestParameterMap().get("fotoPostulado");
				System.out.println("***--- " + ruta);
//				Path path = Paths.get(ruta);
//				byte[] data = Files.readAllBytes(path);
//				System.out.println("==== " + data);
//				return new DefaultStreamedContent(
//						new ByteArrayInputStream(data));

				 File archivo = new File(ruta);
				 System.out.println("EXISTE: "+archivo.isFile());
				 return new DefaultStreamedContent(new
				 FileInputStream(archivo));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new DefaultStreamedContent();
		
	
	}
}

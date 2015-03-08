package org.eleccion_comunal.beans.view;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DonutChartModel;

@ManagedBean(name = "dashboardViewBean")
@ViewScoped
public class DashboardViewBean implements Serializable {

	private static final long serialVersionUID = 187L;
	private DonutChartModel donutModel1;
	private BarChartModel barModel;

	public DashboardViewBean() {

	}

	@PostConstruct
	public void init() {
		createDonutModels();
		createBarModels();
	}

	public DonutChartModel getDonutModel1() {
		return donutModel1;
	}
	
	public BarChartModel getBarModel() {
        return barModel;
    }

	/*********METODOS PARA CARGAR GRAFICA DE DONA PARTE IZQUIERDA**********/
	private void createDonutModels() {
		donutModel1 = initDonutModel();
		donutModel1.setTitle("Porcentaje de vecinos inscritos");
		donutModel1.setLegendPosition("w");
	}

	private DonutChartModel initDonutModel() {
		DonutChartModel model = new DonutChartModel();
		Map<String, Number> circle1 = new LinkedHashMap<String, Number>();
		circle1.put("Total de Habitantes", 100);
		circle1.put("Vecinos inscritos en Registro Electoral", 1000);
		model.addCircle(circle1);
		

		return model;
	}
	/*********************************FIN*******************************/
	
	/*********METODOS PARA CARGAR GRAFICA DE BARRAS PARTE DERECHA**********/
	
	private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Vecinos");
        boys.set("2008", 50);
        boys.set("2010", 25);
        boys.set("2012", 30);
        boys.set("2014", 15);
 
        model.addSeries(boys);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Abstención por año");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Años");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
    /*********************************FIN*******************************/
    
}

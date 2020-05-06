package modelo;


import javafx.scene.chart.Axis;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

 

/**
 *
 * @author asrg2
 */

@Named(value = "bean")
@Dependent
public class Estadisticas {


    private BarChartModel model;
    
    public Estadisticas() {
        model = new BarChartModel();
        
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Promedio");
        girls.set("2004", 52);
       
        model.addSeries(girls);
        
        model.setTitle("Bar Chart");
        model.setLegendPosition("ne");
        
        //POR HACER
        //leer datos de la tabla estrella, sacar promedio y mostrar en grafica
        
        org.primefaces.model.chart.Axis xAxis = model.getAxis(AxisType.X);
        xAxis.setLabel("Usuarios");
        org.primefaces.model.chart.Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Numero de estrellas");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }

 

    public BarChartModel getModel() {
        return model;
    }
}
package modelo;

import controlador.EstrellasController;
import controlador.UserController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javafx.scene.chart.Axis;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import upb.edu.co.dao.EstrellasDAO;

/**
 *
 * @author asrg2
 */
@Named(value = "bean")
@SessionScoped
public class Estadisticas implements Serializable {

    @EJB
    EstrellasDAO ejbFacade;
    private ListDataModel<Estrellas> items;

    @Inject
    private EstrellasController estrellaContr;

    private BarChartModel model;

    public Estadisticas() {
        model = new BarChartModel();
 
        
        
/*
        items = (ListDataModel<Estrellas>) estrellaContr.getItems();
        Iterator<Estrellas> it = items.iterator();

        while (it.hasNext()) {
            double promedio;
            if (it.next().getContador() == 0) {
                promedio = 0;
            } else {
                promedio = it.next().getSumaCalificaciones() / it.next().getContador();
            }

            ChartSeries usuario = new ChartSeries();
            usuario.setLabel("prueba");
            usuario.set(it.next().getCorreoUsuario(), promedio);
            model.addSeries(usua    rio);
        }

        if (items2 != null) {
            for (Estrellas item : items2) {
                double promedio;
                if (item.getContador() == 0) {
                    promedio = 0;
                } else {
                    promedio = item.getSumaCalificaciones() / item.getContador();
                }

                ChartSeries usuario = new ChartSeries();
                usuario.setLabel("prueba");
                usuario.set(item.getCorreoUsuario(), promedio);
                model.addSeries(usuario);

            }

        }*/

        model.setTitle("Bar Chart");
        model.setLegendPosition("ne");

        //POR HACER
        //leer datos de la tabla estrella, sacar promedio y mostrar en grafica
        org.primefaces.model.chart.Axis xAxis = model.getAxis(AxisType.X);
        xAxis.setLabel("Usuarios");
        org.primefaces.model.chart.Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Numero de estrellas");
        yAxis.setMin(0);
        yAxis.setMax(5);
    }

    public BarChartModel getModel() {
        return model;
    }

    public ListDataModel<Estrellas> getItems() {
        return items;
    }

    public void setItems(ListDataModel<Estrellas> items) {
        this.items = items;
    }

    public EstrellasController getEstrellaContr() {
        return estrellaContr;
    }

    public void setEstrellaContr(EstrellasController estrellaContr) {
        this.estrellaContr = estrellaContr;
    }


}

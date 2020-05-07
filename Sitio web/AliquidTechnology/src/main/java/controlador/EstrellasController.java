/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import modelo.Estrellas;
import modelo.Usuario;
import upb.edu.co.dao.EstrellasDAO;

/**
 *
 * @author Duvan
 */
@Named(value = "estrellasController")
@SessionScoped
public class EstrellasController implements Serializable {

  
    private int cont;
    private int suma;
    private int calificacionActual;
    private Estrellas current;
    private DataModel<Estrellas> items = null;
    private List<Double> prom;

    @EJB
    EstrellasDAO ejbFacade;

    @Inject
    private UserController auth;

    public EstrellasController() {
        current = new Estrellas();
       
    }

    public DataModel<Estrellas> getItems() {
        items = new ListDataModel<Estrellas>(ejbFacade.findAll());

        return items;
    }
 

    public String prepareList() {
        items = new ListDataModel<Estrellas>(ejbFacade.findAll());
        return "estadisticas?faces-redirect=true";
    }

    public void ActualizarCal() {

        Estrellas actual = (Estrellas) ejbFacade.find(auth.getUsuarioAutenticado().getCorreo());
        cont = actual.getContador();
        suma = actual.getSumaCalificaciones();

        current.setContador(cont + 1);
        current.setSumaCalificaciones(calificacionActual + suma);
        current.setCorreoUsuario(auth.getUsuarioAutenticado().getCorreo());

        ejbFacade.edit(current);
        current = new Estrellas();

    }

    public int getCalificacionActual() {
        return calificacionActual;
    }

    public void setCalificacionActual(int calificacionActual) {
        this.calificacionActual = calificacionActual;
    }

    public Estrellas getCurrent() {
        return current;
    }

    public void setCurrent(Estrellas current) {
        this.current = current;
    }

    public UserController getAuth() {
        return auth;
    }

    public void setAuth(UserController auth) {
        this.auth = auth;
    }

  
    public List<Double> getProm() {
        double promedio;
         prom=new ArrayList<Double>();
        for (Estrellas item : items) {

            if (item.getContador() == 0) {
                promedio = 0;

            } else {
                promedio = (double) item.getSumaCalificaciones() / (double) item.getContador();
            }
            prom.add(promedio);
        }
        return prom;
    }

    public void setProm(List<Double> prom) {
        this.prom = prom;
    }

}

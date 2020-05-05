/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Inject;
import modelo.Estrellas;
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
    
    @EJB
    EstrellasDAO ejbFacade;
    
    @Inject
    private UserController auth;
 
    public EstrellasController() {
         current  = new Estrellas();
    }
    
    public void ActualizarCal() {
        
        Estrellas actual = (Estrellas) ejbFacade.find(auth.getUsuarioAutenticado().getCorreo());
        cont = actual.getContador();
        suma = actual.getSumaCalificaciones();
        
        current.setContador( cont+1);   
        current.setSumaCalificaciones(calificacionActual +suma);
        current.setCorreoUsuario(auth.getUsuarioAutenticado().getCorreo());
        
        ejbFacade.edit(current);
        current  = new Estrellas();
    
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
    
}

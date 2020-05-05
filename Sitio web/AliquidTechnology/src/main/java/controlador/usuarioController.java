/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import modelo.Estrellas;
import modelo.Usuario;
import upb.edu.co.dao.EstrellasDAO;
import upb.edu.co.dao.UsuarioDAO;
import util.AuthUtil;

/**
 *
 * @author VAL
 */
@Named(value = "usuarioController")
@SessionScoped
public class usuarioController implements Serializable{

    private DataModel <Usuario> items;
    private Usuario current;
     private Estrellas currentEstrellas;
    
    @EJB
    UsuarioDAO ejbFacade;

     @EJB
    EstrellasDAO ejbFacadeEstrellas;
    
    
    public usuarioController() {
        
    }
    
    public DataModel<Usuario> getItems(){
        items=new ListDataModel<Usuario>(ejbFacade.findAll());
        return items;
    }
    
    public String prepareList(){
        items=new ListDataModel<Usuario>(ejbFacade.findAll());
        return "listado?faces-redirect=true";
    }
    
    public String doUserCreate(){
        
        String claveSegura = AuthUtil.crearClaveSegura(current.getContraseña());
        current.setContraseña(claveSegura);
        
        currentEstrellas.setContador(0);
        currentEstrellas.setSumaCalificaciones(0);
        currentEstrellas.setCorreoUsuario(current.getCorreo());
        ejbFacadeEstrellas.create(currentEstrellas);

        ejbFacade.create(current);
        current = new Usuario();
        currentEstrellas = new Estrellas();

        return"index?faces-redirect=true";

    }   
    
    public String prepareCreate(){
        current = new Usuario();
        currentEstrellas = new Estrellas();
        return "registro?faces-redirect=true";
    }
    
    
    
 

    public void setItems(DataModel<Usuario> items) {
        this.items = items;
    }

    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }
    
    
    
}

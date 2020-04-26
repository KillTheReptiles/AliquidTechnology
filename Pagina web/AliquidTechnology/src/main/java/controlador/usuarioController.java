/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import modelo.Usuario;
import upb.edu.co.dao.UsuarioDAO;

/**
 *
 * @author VAL
 */
@Named(value = "usuarioController")
@Dependent
public class usuarioController {

    private DataModel <Usuario> items;
    private Usuario current;
    @EJB
    UsuarioDAO ejbFacade;

    
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
       
        ejbFacade.create(current);
         current = new Usuario();

        return"index?faces-redirect=true";

    }   
    
    public String prepareCreate(){
        current = new Usuario();

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

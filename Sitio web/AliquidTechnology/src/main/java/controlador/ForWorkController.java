/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import modelo.ForWork;
import modelo.Usuario;
import upb.edu.co.dao.ForWorkDAO;

/**
 *
 * @author Duvan
 */
@Named(value = "forWorkController")
@SessionScoped
public class ForWorkController implements Serializable {

    private DataModel<ForWork> items;
    private ForWork current;
      private List<ForWork> listado;
    
    @EJB
    ForWorkDAO ejbFacade;
    
    

    public ForWorkController() {
        current = new  ForWork();
    }
    
    public List<ForWork> getlistado(){
        return ejbFacade.findAll();
    }

    
    
     public DataModel<ForWork> getItems(){
        items=new ListDataModel<ForWork>(ejbFacade.findAll());
        return items;
    }
    
    public String prepareList(){
        items=new ListDataModel<ForWork>(ejbFacade.findAll());
        return "ForWork?faces-redirect=true";
    }
    
    
    
    
    public void setItems(DataModel<ForWork> items) {
        this.items = items;
    }

    public ForWork getCurrent() {
        return current;
    }

    public void setCurrent(ForWork current) {
        this.current = current;
    }
    
    
    
}

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
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import modelo.ForWork;
 
import modelo.Gaming;
 
import upb.edu.co.dao.GamingDAO;

/**
 *
 * @author Duvan
 */
@Named(value = "gamingController")
@SessionScoped
public class GamingController implements Serializable {

    private DataModel<Gaming> items;
    private Gaming current;
    
    @EJB
    GamingDAO ejbFacade;

    public GamingController() {
    }
    
    
     public DataModel<Gaming> getItems(){
        items=new ListDataModel<Gaming>(ejbFacade.findAll());
        return items;
    }
    
    public String prepareList(){
        items=new ListDataModel<Gaming>(ejbFacade.findAll());
        return "Gaming?faces-redirect=true";
    }
    
    
    
    
    public void setItems(DataModel<Gaming> items) {
        this.items = items;
    }

    public Gaming getCurrent() {
        return current;
    }

    public void setCurrent(Gaming current) {
        this.current = current;
    }
    
    
    
}

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
import modelo.TwoInOneConvertible;
import modelo.Ultrabook;
import upb.edu.co.dao.TwoinOneConvertibleDAO;
import upb.edu.co.dao.UltrabookDAO;

/**
 *
 * @author Duvan
 */
@Named(value = "ultrabookController")
@SessionScoped
public class UltrabookController implements Serializable {

    private DataModel<Ultrabook> items;
    private Ultrabook current;

    @EJB
    UltrabookDAO ejbFacade;

    public UltrabookController() {
    }
    
      
     public DataModel<Ultrabook> getItems(){
        items=new ListDataModel<Ultrabook>(ejbFacade.findAll());
        return items;
    }
    
    public String prepareList(){
        items=new ListDataModel<Ultrabook>(ejbFacade.findAll());
        return "Ultrabook?faces-redirect=true";
    }
    
    
    
    
    public void setItems(DataModel<Ultrabook> items) {
        this.items = items;
    }

    public Ultrabook getCurrent() {
        return current;
    }

    public void setCurrent(Ultrabook current) {
        this.current = current;
    }
    
}

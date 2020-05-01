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
import modelo.Netbook;
import modelo.TwoInOneConvertible;
import upb.edu.co.dao.NetbookDAO;
import upb.edu.co.dao.TwoinOneConvertibleDAO;

/**
 *
 * @author Duvan
 */
@Named(value = "twoinOneConvertibleController")
@SessionScoped
public class TwoinOneConvertibleController implements Serializable {

   
    private DataModel<TwoInOneConvertible> items;
    private TwoInOneConvertible current;

    @EJB
    TwoinOneConvertibleDAO ejbFacade;
    
    public TwoinOneConvertibleController() {
    }
    
    
     public DataModel<TwoInOneConvertible> getItems(){
        items=new ListDataModel<TwoInOneConvertible>(ejbFacade.findAll());
        return items;
    }
    
    public String prepareList(){
        items=new ListDataModel<TwoInOneConvertible>(ejbFacade.findAll());
        return "TwoInOneConvertible?faces-redirect=true";
    }
    
    
    
    
    public void setItems(DataModel<TwoInOneConvertible> items) {
        this.items = items;
    }

    public TwoInOneConvertible getCurrent() {
        return current;
    }

    public void setCurrent(TwoInOneConvertible current) {
        this.current = current;
    }
    
}

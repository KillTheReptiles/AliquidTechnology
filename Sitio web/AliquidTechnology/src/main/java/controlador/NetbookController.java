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
import modelo.Gaming;
import modelo.Netbook;
import upb.edu.co.dao.GamingDAO;
import upb.edu.co.dao.NetbookDAO;

/**
 *
 * @author Duvan
 */
@Named(value = "netbookController")
@SessionScoped
public class NetbookController implements Serializable {
    
    private DataModel<Netbook> items;
    private Netbook current;

    @EJB
    NetbookDAO ejbFacade;

    public NetbookController() {
    }
    
     public DataModel<Netbook> getItems(){
        items=new ListDataModel<Netbook>(ejbFacade.findAll());
        return items;
    }
    
    public String prepareList(){
        items=new ListDataModel<Netbook>(ejbFacade.findAll());
        return "Netbook?faces-redirect=true";
    }
    
    
    
    
    public void setItems(DataModel<Netbook> items) {
        this.items = items;
    }

    public Netbook getCurrent() {
        return current;
    }

    public void setCurrent(Netbook current) {
        this.current = current;
    }
}

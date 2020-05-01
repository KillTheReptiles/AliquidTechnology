/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modelo.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.json.JsonObject;

/**
 *
 * @author VAL
 */
@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {
   Usuario usuario;
   private String userName;
    private String correo;
    private String clave;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<Usuario> getListausuario() {
        return listausuario;
    }

    public void setListausuario(List<Usuario> listausuario) {
        this.listausuario = listausuario;
    }
    
    private List<Usuario> listausuario;
    /**
     * Creates a new instance of userController
     */
    public UserController() {
        usuario= new Usuario();
        listausuario= new ArrayList<Usuario>();
    }
   
    public void registrar(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ex = context.getExternalContext();
        
    }
}

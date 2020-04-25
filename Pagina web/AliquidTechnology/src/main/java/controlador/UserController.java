package controlador;

import modelo.Usuario;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import java.io.IOException;
import java.util.logging.Logger;
import javax.ejb.EJB;
import upb.edu.co.dao.MongoDAO;
import upb.edu.co.dao.UsuarioDAO;

@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

    private Usuario usuario;
    private Usuario usuarioAutenticado = null;
    private List<Usuario> listado;

    @EJB
    UsuarioDAO ejbFacade;
    

    public UserController() {
        
        usuarioAutenticado = null;
        
        usuario = new Usuario();
    }

    public String login() throws IOException {
        
        

        usuarioAutenticado = ejbFacade.authUser(usuario.getUsuario(), usuario.getContraseña());

        if (usuarioAutenticado != null) {

            return "dashboard?faces-redirect=true";

        } else {

            return "index?faces-redirect=true";

        }

      

    }
   
 

    public void setListado(List<Usuario> listado) {
        this.listado = listado;
    }



    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }
    


}

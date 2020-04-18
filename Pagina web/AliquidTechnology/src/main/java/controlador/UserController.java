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
    private UsuarioDAO ejbDao;


    @EJB
    private MongoDAO dao;

    public UserController() {
        usuario = new Usuario();
    }

    

    public String login() throws IOException {
    FacesContext ctx = FacesContext.getCurrentInstance();
        
         usuarioAutenticado = (Usuario) ejbDao.encontrarUsuarioPorLogin(usuario.getCorreo(), usuario.getContraseña());

        if (usuarioAutenticado != null) {
           
            ctx.getExternalContext().redirect("dashboard.xhtml");
        } else {
            
            ctx.getExternalContext().redirect("index.xhtml");
        }
        
        return "index?redirect=true";

    }

    
  
    
    public String registrar() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ex = context.getExternalContext();
//F PORQUE NO SABEMOS
       
        usuario = new Usuario();
        return "index?redirect=true";

    }

    public List<Usuario> getListado(){
        listado = ejbDao.listar();
        return listado;
    }

    public void setListado(List<Usuario> listado) {
        this.listado = listado;
    }

    public MongoDAO getDao() {
        return dao;
    }

    public void setDao(MongoDAO dao) {
        this.dao = dao;
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

    public UsuarioDAO getEjbDao() {
        return ejbDao;
    }

    public void setEjbDao(UsuarioDAO ejbDao) {
        this.ejbDao = ejbDao;
    }





}

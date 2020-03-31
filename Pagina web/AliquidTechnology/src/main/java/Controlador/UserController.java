package Controlador;

import Modelo.Usuario;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.json.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.json.simple.parser.JSONParser;
import util.UsuarioUtil;

@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

    Usuario usuario;
    private List<Usuario> listado;
    private final static Logger LOGGER = Logger.getLogger("UsuarioController");

    public UserController() {
        usuario = new Usuario();
    }

    @PostConstruct
    public void leerListado() {
        listado = UsuarioUtil.leer(getRutaJson()); //cargar una lista que tiene los usuarios del json
    }

    public String login() {

        leerListado();

        for (Usuario u : listado) {
                if ((usuario.getUserName().equals(u.getUserName())) && (usuario.getContraseña().equals(u.getContraseña()))) {
                return "dashboard?redirect=true";
            }
        }

        return "index?redirect=true";

    }

    public String registrar() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ex = context.getExternalContext();

        Usuario u = new Usuario(usuario.getCorreo(),usuario.getUserName(), usuario.getContraseña());
        listado.add(u);

        UsuarioUtil.guardarJSON(listado, getRutaJson());
        usuario = new Usuario();
        return "index?redirect=true";

    }

    private String getRutaJson() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ex = context.getExternalContext();
        String ruta = ex.getRealPath("/");
        ruta = ruta.substring(0, ruta.lastIndexOf("Pagina web"));
        ruta = ruta + "Pagina Web\\usuarios.json";
        return ruta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListausuario() {
        return listado;
    }

    public void setListausuario(List<Usuario> listado) {
        this.listado = listado;
    }

}

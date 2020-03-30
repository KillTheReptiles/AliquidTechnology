package Controlador;

import Modelo.Usuario;
import com.google.gson.Gson;
import java.io.File;
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
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;

@Named(value = "userController")
@SessionScoped
public class userController implements Serializable {

    public static FileWriter getFile() {
        return file;
    }

    public static void setFile(FileWriter aFile) {
        file = aFile;
    }
    Usuario usuario;
    private String userName;
    private String correo;
    private String clave;

    private List<Usuario> listausuario = new ArrayList<Usuario>();

    ;
    
    public userController() {
        usuario = new Usuario();
    }

    public String login() {
        for (Usuario u : listausuario) {
            if ((usuario.getUserName().equals(u.getUserName())) && (usuario.getContraseña().equals(u.getContraseña()))) {
                return "dashboard?redirect=true";
            }
        }
        return "index?redirect=true";

    }

    public String registrar() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ex = context.getExternalContext();

        Usuario u = new Usuario(usuario.getUserName(),usuario.getCorreo(),usuario.getContraseña());
        listausuario.add(u);
        /*
        try{
            Writer filer= new FileWriter("rueba.json");
            new Gson().toJson(u, filer); 
            filer.close();
        }catch(IOException e)
                {
                    e.printStackTrace();
                }*/
         
        
        
        JSONObject obj = new JSONObject();
        obj.put("Correo", u.getCorreo());
        obj.put("Username", u.getUserName());
        obj.put("Contrasena", u.getContraseña());
        
        JSONObject objReal = new JSONObject();
        objReal.put("Usuario", obj);
        JSONArray usuariosList = new JSONArray();
        usuariosList.add(objReal);
        
        //Escribir el archivo
        try (FileWriter file = new FileWriter("C:\\Users\\Duvan\\Documents\\CARRERA\\Tercer semestre\\Matematicas Discretas 2\\Aliquid Technology\\Pagina web\\usuarios.json",true))
        {
            file.write(usuariosList.toJSONString());
            file.flush();
        }
        catch (IOException e)
                {
                    e.printStackTrace();
                }
         
        //guardarJSON();

        return "index?redirect=true";

    }

    private static FileWriter file;

    public void guardarJSON() {
        JSONObject obj = new JSONObject();

        for (Usuario u : listausuario) {
            obj.put("Correo", u.getCorreo());
            obj.put("Username", u.getUserName());
            obj.put("Contrasena", u.getContraseña());
        }

        try {

            file = new FileWriter("usurios.txt");
            file.write(obj.toJSONString());

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                file.flush();

                file.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }

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

}

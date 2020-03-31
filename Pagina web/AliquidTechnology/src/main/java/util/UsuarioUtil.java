/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Modelo.Usuario;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Duvan
 */
public class UsuarioUtil {

    private static FileWriter file;
    private final static Logger LOGGER = Logger.getLogger("UsuarioUtil");

    public static List<Usuario> leer(String ruta) {

        List<Usuario> listausuario = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(ruta)) {
            JSONArray userList = (JSONArray) jsonParser.parse(reader);

            //userList.forEach(us -> parseUsuarioObject((JSONObject) us));
            for (Object us : userList) {
                Usuario u = parseObjectToUsuario((JSONObject) us);
                listausuario.add(u);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        LOGGER.log(Level.INFO, listausuario.toString());

        return listausuario;

    }

    public static void guardarJSON(List<Usuario> listaU, String ruta) {

        JSONArray usuariosList = new JSONArray();
        
        for (Usuario u : listaU) {
            usuariosList.add(parseUsuarioToObject(u));
        }
        
        try (FileWriter file = new FileWriter(ruta)) {
            file.write(usuariosList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Usuario parseObjectToUsuario(JSONObject jsonObject) {

        JSONObject usuarioObject = (JSONObject) jsonObject.get("Usuario");
        String correo = (String) usuarioObject.get("Correo");
        String username = (String) usuarioObject.get("Username");
        String contrasena = (String) usuarioObject.get("Contrasena");

        return new Usuario(correo, username, contrasena);

    }

    public static JSONObject parseUsuarioToObject(Usuario u) {

        JSONObject objReal = new JSONObject();
        JSONObject obj = new JSONObject();
        obj.put("Correo", u.getCorreo());
        obj.put("Username", u.getUserName());
        obj.put("Contrasena", u.getContraseña());
        objReal.put("Usuario", obj);
        return objReal;

    }

    public static FileWriter getFile() {
        return file;
    }

    public static void setFile(FileWriter aFile) {
        file = aFile;
    }

}

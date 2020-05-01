/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


@Named(value = "chatbotController")
@SessionScoped
public class chatbotController implements Serializable {

    String mensaje;
    String respuesta;

    public chatbotController() {
    }

    public void sendmessage() {
        respuesta = respuesta + "\n" + "Tu: " + mensaje;
        String respuestaChat = "";
        Client cliente = ClientBuilder.newClient();

        WebTarget pagina = cliente.target("http://127.0.0.1:5000/chatbot/" + mensaje);

        respuestaChat = pagina.request(MediaType.TEXT_PLAIN + ";charset=utf-8").get(String.class);
        
        byte[] bytes = respuestaChat.getBytes(StandardCharsets.UTF_8);
        respuestaChat = new String(bytes, StandardCharsets.UTF_8);

        respuesta = respuesta + "\n" + respuestaChat;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}

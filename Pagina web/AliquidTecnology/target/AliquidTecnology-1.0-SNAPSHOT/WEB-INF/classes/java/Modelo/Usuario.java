/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author VAL
 */
public class Usuario {
    String userName;
    String correo;
    String contraseña;

    public Usuario(String userName, String correo, String contraseña) {
        this.userName = userName;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public Usuario() {
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}

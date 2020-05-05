/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Duvan
 */
@Entity
@Table(name = "estrellas")
@NamedQueries({
    @NamedQuery(name = "Estrellas.findAll", query = "SELECT e FROM Estrellas e"),
    @NamedQuery(name = "Estrellas.findByCorreoUsuario", query = "SELECT e FROM Estrellas e WHERE e.correoUsuario = :correoUsuario"),
    @NamedQuery(name = "Estrellas.findBySumaCalificaciones", query = "SELECT e FROM Estrellas e WHERE e.sumaCalificaciones = :sumaCalificaciones"),
    @NamedQuery(name = "Estrellas.findByContador", query = "SELECT e FROM Estrellas e WHERE e.contador = :contador")})
public class Estrellas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo_usuario")
    private String correoUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suma_calificaciones")
    private int sumaCalificaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contador")
    private int contador;

    public Estrellas() {
    }

    public Estrellas(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public Estrellas(String correoUsuario, int sumaCalificaciones, int contador) {
        this.correoUsuario = correoUsuario;
        this.sumaCalificaciones = sumaCalificaciones;
        this.contador = contador;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public int getSumaCalificaciones() {
        return sumaCalificaciones;
    }

    public void setSumaCalificaciones(int sumaCalificaciones) {
        this.sumaCalificaciones = sumaCalificaciones;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correoUsuario != null ? correoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estrellas)) {
            return false;
        }
        Estrellas other = (Estrellas) object;
        if ((this.correoUsuario == null && other.correoUsuario != null) || (this.correoUsuario != null && !this.correoUsuario.equals(other.correoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Estrellas[ correoUsuario=" + correoUsuario + " ]";
    }
    
}

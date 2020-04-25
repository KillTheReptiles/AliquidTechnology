/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upb.edu.co.dao;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelo.Usuario;

/**
 *
 * @author CharliePC
 */
@Stateless
public class UsuarioDAO extends AbstractFacade<Usuario> {
//Web_DBAccessPU

    @PersistenceContext(unitName = "Web_DBAccessPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public Usuario authUser(String user, String pass) {
        Usuario found = null;
        Query q = getEntityManager().createQuery("Select u from Usuario u where u.usuario=:user and u.contraseña =:pass");
        q.setParameter("user", user);

        q.setParameter("pass", pass);

        try {
            found = (Usuario) q.getSingleResult();
        } catch  (NoResultException e){
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "No se encontraron registros");
        }catch  (Exception e){
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "Error");
        }

        return found;
    }

        
    
}

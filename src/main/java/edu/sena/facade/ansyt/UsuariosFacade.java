/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ansyt;

import edu.sena.entity.ansyt.Usuarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "AnsyTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    @Override
    public Usuarios validarUsuario(String correoIn, String claveIn) {
        try {
            Query q = em.createQuery("SELECT p FROM Usuarios p WHERE p.usCorreo = :p1 AND p.usClave = :p2");
            q.setParameter("p1", correoIn);
            q.setParameter("p2", claveIn);
            return (Usuarios) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public Usuarios validarUsuarioReg(String correoIn) {
        try {
            Query q = em.createQuery("SELECT p FROM Usuarios p WHERE p.usCorreo = :p1");
            q.setParameter("p1", correoIn);
            return (Usuarios) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    
}

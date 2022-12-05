/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.sena.facade.ansyt;

import edu.sena.entity.ansyt.ServiciosAdquiridos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author anderson
 */
@Stateless
public class ServiciosAdquiridosFacade extends AbstractFacade<ServiciosAdquiridos> implements ServiciosAdquiridosFacadeLocal {

    @PersistenceContext(unitName = "AnsyTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiciosAdquiridosFacade() {
        super(ServiciosAdquiridos.class);
    }
    
    @Override
    public List<ServiciosAdquiridos> planesActivosClientes(int idCliente, int estado) {
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createQuery("SELECT p FROM ServiciosAdquiridos p WHERE p.iDUsuario.idUsuario = :p1 and p.iDEstado.iDest = :p2");
            q.setParameter("p1", idCliente);
            q.setParameter("p2", estado);
            return q.getResultList();            
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<ServiciosAdquiridos> buscarIDUsuario(int idCliente) {
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createQuery("SELECT p FROM ServiciosAdquiridos p WHERE p.iDUsuario.idUsuario = :p1");
            q.setParameter("p1", idCliente);
            return q.getResultList();            
        } catch (Exception e) {
            return null;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ansyt;

import edu.sena.entity.ansyt.Planes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
@Stateless
public class PlanesFacade extends AbstractFacade<Planes> implements PlanesFacadeLocal {

    @PersistenceContext(unitName = "AnsyTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanesFacade() {
        super(Planes.class);
    }

    @Override
    public List<Planes> planesSelecionados(String tipo) {
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createQuery("SELECT p FROM Planes p WHERE p.planTipoPlan = :p1 ");
            q.setParameter("p1", tipo);
            return q.getResultList();            
        } catch (Exception e) {
            return null;
        }
    }
    
    
    
    
}

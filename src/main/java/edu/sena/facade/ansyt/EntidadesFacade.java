/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ansyt;

import edu.sena.entity.ansyt.Entidades;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aprendiz
 */
@Stateless
public class EntidadesFacade extends AbstractFacade<Entidades> implements EntidadesFacadeLocal {

    @PersistenceContext(unitName = "AnsyTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntidadesFacade() {
        super(Entidades.class);
    }
    
}

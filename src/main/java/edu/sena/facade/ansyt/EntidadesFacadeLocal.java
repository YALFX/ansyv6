/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ansyt;

import edu.sena.entity.ansyt.Entidades;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aprendiz
 */
@Local
public interface EntidadesFacadeLocal {

    void create(Entidades entidades);

    void edit(Entidades entidades);

    void remove(Entidades entidades);

    Entidades find(Object id);

    List<Entidades> findAll();

    List<Entidades> findRange(int[] range);

    int count();
    
}

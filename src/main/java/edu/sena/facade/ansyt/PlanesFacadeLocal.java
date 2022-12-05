/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ansyt;

import edu.sena.entity.ansyt.Planes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aprendiz
 */
@Local
public interface PlanesFacadeLocal {

    void create(Planes planes);

    void edit(Planes planes);

    void remove(Planes planes);

    Planes find(Object id);

    List<Planes> findAll();

    List<Planes> findRange(int[] range);

    int count();

    public List<Planes> planesSelecionados(String tipo);
    
}

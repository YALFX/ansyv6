/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ansyt;

import edu.sena.entity.ansyt.EstadosCiviles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aprendiz
 */
@Local
public interface EstadosCivilesFacadeLocal {

    void create(EstadosCiviles estadosCiviles);

    void edit(EstadosCiviles estadosCiviles);

    void remove(EstadosCiviles estadosCiviles);

    EstadosCiviles find(Object id);

    List<EstadosCiviles> findAll();

    List<EstadosCiviles> findRange(int[] range);

    int count();
    
}

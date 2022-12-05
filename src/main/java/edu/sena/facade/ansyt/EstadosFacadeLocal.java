/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.sena.facade.ansyt;

import edu.sena.entity.ansyt.Estados;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anderson
 */
@Local
public interface EstadosFacadeLocal {

    void create(Estados estados);

    void edit(Estados estados);

    void remove(Estados estados);

    Estados find(Object id);

    List<Estados> findAll();

    List<Estados> findRange(int[] range);

    int count();
    
}

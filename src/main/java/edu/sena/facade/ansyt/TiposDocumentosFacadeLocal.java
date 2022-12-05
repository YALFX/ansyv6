/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ansyt;

import edu.sena.entity.ansyt.TiposDocumentos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aprendiz
 */
@Local
public interface TiposDocumentosFacadeLocal {

    void create(TiposDocumentos tiposDocumentos);

    void edit(TiposDocumentos tiposDocumentos);

    void remove(TiposDocumentos tiposDocumentos);

    TiposDocumentos find(Object id);

    List<TiposDocumentos> findAll();

    List<TiposDocumentos> findRange(int[] range);

    int count();
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.sena.facade.ansyt;

import edu.sena.entity.ansyt.ServiciosAdquiridos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anderson
 */
@Local
public interface ServiciosAdquiridosFacadeLocal {

    void create(ServiciosAdquiridos serviciosAdquiridos);

    void edit(ServiciosAdquiridos serviciosAdquiridos);

    void remove(ServiciosAdquiridos serviciosAdquiridos);

    ServiciosAdquiridos find(Object id);

    List<ServiciosAdquiridos> findAll();

    List<ServiciosAdquiridos> findRange(int[] range);

    int count();
    
    //
    
    public List<ServiciosAdquiridos> planesActivosClientes(int idCliente, int estado);
    public List<ServiciosAdquiridos> buscarIDUsuario(int idCliente);
    
}

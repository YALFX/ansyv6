/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package edu.sena.controller.ansyt;

import edu.sena.facade.ansyt.ClientesFacadeLocal;
import edu.sena.facade.ansyt.EntidadesFacadeLocal;
import edu.sena.facade.ansyt.PlanesFacadeLocal;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author anderson
 */
@Named(value = "dashAdminView")
@ViewScoped
public class dashAdminView implements Serializable {

    @EJB
    ClientesFacadeLocal cfl;
    @EJB
    EntidadesFacadeLocal efl;
    @EJB
    PlanesFacadeLocal sfl;
    
    public dashAdminView() {
    }
    
    public int contarClientes(){
       int numero= cfl.count();
        return numero;
    }
    
    public int contarEntidades(){
       int numero;
        return numero = efl.count();
    }
    
    public int contarServicios(){
       int numero;
        return numero = sfl.count();
    }
}

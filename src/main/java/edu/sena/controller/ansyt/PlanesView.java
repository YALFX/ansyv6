/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package edu.sena.controller.ansyt;

import edu.sena.entity.ansyt.Planes;
import edu.sena.entity.ansyt.ServiciosAdquiridos;
import edu.sena.facade.ansyt.PlanesFacadeLocal;
import edu.sena.facade.ansyt.ServiciosAdquiridosFacadeLocal;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author anderson
 */
@Named(value = "planesView")
@ViewScoped
public class PlanesView implements Serializable {

    //EJB
    
    @EJB
    PlanesFacadeLocal pfl;
    
    Planes plan = new Planes();

    //Metodos
    
    public PlanesView() {
    }
    
    
    
    public List<Planes> listarPlanes(){
       return pfl.findAll();
    }
    
   
    
    public String PuntoPrecio(int precioM){
        
        try {
             String precioS = String.valueOf(precioM);
        char[] cadenaString = precioS.toCharArray();
        precioS="";
        
        int contador;
        if(cadenaString.length % 2 == 0){
            contador=0;
        }else{
            contador=1;
        }

        for (int i = 0; i < cadenaString.length; i++) {
            if(contador == 3 ){
                precioS = precioS + ".";
                contador = 0;}
            precioS+= cadenaString[i];
            contador++;
        }
        
        return precioS;
        } catch (Exception e) {
            return null;
        }
    }
    
    
}

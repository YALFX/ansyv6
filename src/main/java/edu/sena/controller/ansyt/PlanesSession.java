/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 
*/
package edu.sena.controller.ansyt;

import edu.sena.entity.ansyt.Planes;
import edu.sena.facade.ansyt.PlanesFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author anderson
 */
@Named(value = "planesSession")
@SessionScoped
public class PlanesSession implements Serializable {

    //EJB
    @EJB
    PlanesFacadeLocal pfl;
    Planes plan = new Planes();
    private String tipoPlan;
    
    //Contrutores
    public PlanesSession() {
    }
    
    //Metodos
    
    public List<Planes> listarPlanes(){
        return pfl.planesSelecionados(tipoPlan);
    }
    
    
    
    
    //Getter and Setter

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }
    

    public void obTipoPlanP() throws IOException {
        this.tipoPlan = "Prepagada";
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("DetallesPlanes.xhtml");
    }
    
    public void obTipoPlanC() throws IOException {
        this.tipoPlan = "Complementario";
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("DetallesPlanes.xhtml");
    }
    
    public void obTipoPlanE() throws IOException {
        this.tipoPlan = "Exequial";
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("DetallesPlanes.xhtml");
    }
    
    
    
}

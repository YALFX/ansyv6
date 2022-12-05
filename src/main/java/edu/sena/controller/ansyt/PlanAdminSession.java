/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package edu.sena.controller.ansyt;

//librerias enviar archivos
import java.io.IOException;
import java.io.Serializable;
import org.apache.poi.util.IOUtils;
import org.primefaces.model.file.UploadedFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import edu.sena.entity.ansyt.Entidades;
import edu.sena.entity.ansyt.Estados;
import edu.sena.entity.ansyt.Planes;
import edu.sena.facade.ansyt.EntidadesFacadeLocal;
import edu.sena.facade.ansyt.EstadosFacadeLocal;
import edu.sena.facade.ansyt.PlanesFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author anderson
 */
@Named(value = "planAdminSession")
@SessionScoped
public class PlanAdminSession implements Serializable {

    //EJB
    @EJB
    PlanesFacadeLocal pfl;
    @EJB
    EntidadesFacadeLocal efl;
    @EJB
    EstadosFacadeLocal estfl;
    private Planes plan = new Planes();
    private int entidad;
    private int estado;
    private UploadedFile file;

    //Contrutores
    public PlanAdminSession() {
    }

    //Metodos
    public List<Planes> listarPlanes() {
        return pfl.findAll();
    }

    public List<Entidades> listarEntidades() {
        return efl.findAll();
    }

    public List<Estados> listarEstados() {
        return estfl.findAll();
    }

    public void eliminarServicio(int id) {
        Planes planDelete = pfl.find(id);
        pfl.remove(planDelete);
    }

    public void registrarServico() throws IOException {
        try {
            Entidades entidadReg = efl.find(this.entidad);
            Estados estadosReg = estfl.find(this.estado);
            plan.setPlanEntidad(entidadReg);
            plan.setPlanest(estadosReg);
            if (this.file != null) {
                String carpeta = "/home/anderson/NetBeansProjects/AnsyV5/src/main/webapp/resources/imagenes/planes";
                plan.setPlanimg(file.getContent());
                plan.setNameimg(file.getFileName());
                escriByte(IOUtils.toByteArray(file.getInputStream()), carpeta, file.getFileName());
            } else {
                plan.setNameimg("Plan-Oro.jpg");
            }
            pfl.create(plan);
            plan = new Planes();
        } catch (Exception e) {
        }
    }
    
    public void close() throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("planes.xhtml");
        plan = new Planes();
    }

    public void escriByte(byte[] bytes, String carpeta, String imgName) throws IOException {
        try {
            Path path = Paths.get(carpeta, imgName);
            Files.write(path, bytes);
        } catch (Exception e) {
        }

    }

    public void cargarDatos(int id) throws IOException {
        plan = pfl.find(id);
        entidad = plan.getPlanEntidad().getIdEntidades();
        estado = plan.getPlanest().getIDest();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("updateS.xhtml");
    }

    public void actualizarDatos() throws IOException {
        Entidades entidadReg = efl.find(this.entidad);
        Estados estadosReg = estfl.find(this.estado);
        plan.setPlanEntidad(entidadReg);
        plan.setPlanest(estadosReg);
        if (this.file != null) {
                String carpeta = "/home/anderson/NetBeansProjects/AnsyV5/src/main/webapp/resources/imagenes/planes";
                plan.setPlanimg(file.getContent());
                plan.setNameimg(file.getFileName());
                escriByte(IOUtils.toByteArray(file.getInputStream()), carpeta, file.getFileName());
            }
        pfl.edit(plan);
    }

    //Getter and Setter
    public Planes getPlan() {
        return plan;
    }

    public void setPlan(Planes plan) {
        this.plan = plan;
    }

    public int getEntidad() {
        return entidad;
    }

    public void setEntidad(int entidad) {
        this.entidad = entidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

}

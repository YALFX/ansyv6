/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package edu.sena.controller.ansyt;

import edu.sena.entity.ansyt.Entidades;
import edu.sena.facade.ansyt.EntidadesFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.poi.util.IOUtils;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author anderson
 */
@Named(value = "entidadesSession")
@SessionScoped
public class EntidadesSession implements Serializable {

    @EJB
    EntidadesFacadeLocal efl;
    private Entidades entidad = new Entidades();
    private UploadedFile file;

    public EntidadesSession() {
    }

    public void CargarDatos(int id) throws IOException {
        try {
            entidad = efl.find(id);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().redirect("updateE.xhtml");
        } catch (IOException e) {
            error("Error al cargar los datos", "Intente nuevamente");
        }

    }

    public void actualizarDatos() throws IOException {
        try {
            if (this.file != null) {
            String carpeta = "/home/anderson/NetBeansProjects/AnsyV5/src/main/webapp/resources/imagenes/entidades";
            entidad.setEntimg(file.getContent());
            entidad.setNameimg(file.getFileName());
            escriByte(IOUtils.toByteArray(file.getInputStream()), carpeta, file.getFileName());
        }
        efl.edit(entidad);
            info("Se actualizo correctamente", "");
        } catch (IOException e) {
            error("Error al actualizar los datos", "Intente nuevamente");
        }
    }

    public void escriByte(byte[] bytes, String carpeta, String imgName) throws IOException {
        try {
            Path path = Paths.get(carpeta, imgName);
            Files.write(path, bytes);
        } catch (IOException e) {
        }

    }

    public void error(String mensaje, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, detalle));
    }

    public void info(String mensaje, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, detalle));
    }

    public void warn(String mensaje, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensaje, detalle));
    }

    public Entidades getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidades entidad) {
        this.entidad = entidad;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

}

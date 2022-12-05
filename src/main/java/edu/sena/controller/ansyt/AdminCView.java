/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.ansyt;

import edu.sena.entity.ansyt.Clientes;

import edu.sena.entity.ansyt.Roles;
import edu.sena.entity.ansyt.TiposDocumentos;
import edu.sena.entity.ansyt.Usuarios;
import edu.sena.facade.ansyt.ClientesFacadeLocal;
import edu.sena.facade.ansyt.EstadosCivilesFacadeLocal;
import edu.sena.facade.ansyt.RolesFacadeLocal;
import edu.sena.facade.ansyt.TiposDocumentosFacadeLocal;
import edu.sena.facade.ansyt.UsuariosFacadeLocal;
import edu.sena.sendmail.ansyt.SendMail;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author yinlo
 */
@Named(value = "adminCView")
@ViewScoped
public class AdminCView implements Serializable {

    @EJB
    ClientesFacadeLocal cd;
    @EJB
    UsuariosFacadeLocal ufl;
    @EJB
    TiposDocumentosFacadeLocal ctd;
    @EJB
    EstadosCivilesFacadeLocal esfl;
    @EJB
    RolesFacadeLocal rfl;

    private int id = 1;
    private String correo = "";
    private String mensaje;
    private String nombre = "";
    private String clave = "";
    private String asunto;
    private int count = 0;
    private Clientes persona = new Clientes();
    private Usuarios usuario = new Usuarios();
    private UploadedFile file;


    /**
     * Creates a new instance of AdminView
     */
    public AdminCView() {
    }
    

    public void eliminarU(int id) {

        try {
            Usuarios u = ufl.find(id);
            if (u == null) {
            } else {
                ufl.remove(u);
            }

            info("Eliminado exitosamente","");
        } catch (Exception e) {

            error("Error al eliminar","");
        }

    }

    public List<Usuarios> listarUsuarios() {
        try {
            return ufl.findAll();
        } catch (Exception e) {
            return null;
        }
    }

//    public List<Mensajes> listarMensajes() {
//        try {
//            return mfl.findAll();
//        } catch (Exception e) {
//            return null;
//        }
//    }

    public void enviarEmail() {

        try {
            SendMail mail = new SendMail();
            mail.setVmessage(mensaje);
            mail.setSubject(asunto);
            mail.SendMail(correo);

            info("E-mail enviado exitosamente", "");

        } catch (Exception e) {
            error("Error al enviar e-mail", "");
        }

        mensaje = "";
        correo = "";
        asunto = "";
    }

    public int count() {
        this.count = this.count + 1;
        return count;
    }
    

    public void cargarArchivo() throws IOException {
        if (this.file != null) {
            try {

                InputStream inputStream = file.getInputStream();
                XSSFWorkbook libro = new XSSFWorkbook(inputStream);
                Sheet sheet = libro.getSheetAt(0);
                Iterator<Row> iterator = sheet.iterator();
                int i = 0;
                while (iterator.hasNext()) {
                    Row currentRow = iterator.next();
                    int td;
                    if (i > 0) {
                        if (currentRow.getCell(0) != null && 
                                currentRow.getCell(1) != null && 
                                currentRow.getCell(2) != null && 
                                currentRow.getCell(3) != null && 
                                currentRow.getCell(4) != null && 
                                currentRow.getCell(5) != null && 
                                currentRow.getCell(6) != null && 
                                currentRow.getCell(7) != null ){
                            persona.setCliNombre(currentRow.getCell(0).getStringCellValue());
                            persona.setCliApellido(currentRow.getCell(1).getStringCellValue());
                            td = (int) currentRow.getCell(2).getNumericCellValue();
                            persona.setCliTipoDocumento(ctd.find(td));
                            persona.setCliNumeroDocumento((int)currentRow.getCell(3).getNumericCellValue());
                            int n = (int) currentRow.getCell(4).getNumericCellValue();
                            BigInteger bigInteger = BigInteger.valueOf(n);
                            persona.setCliTelefono(bigInteger);
                            Date fc = currentRow.getCell(5).getDateCellValue();
                            persona.setCliFechaNacimiento(fc);
                            persona.setCliSexo(currentRow.getCell(6).getStringCellValue());
                            usuario.setUsCorreo(currentRow.getCell(7).getStringCellValue());
                            usuario.setUsClave(currentRow.getCell(8).getStringCellValue());
                            usuario.setRolTipo(rfl.find((int)currentRow.getCell(9).getNumericCellValue()));
                            persona.setNameImg("user-profile-icon.jpg");
                            cd.create(persona);
                            ufl.create(usuario);
                        } else {
                            break;
                        }
                    }
                    i++;
                }
                libro.close();
                info("Carga exitosa", "se agregaron los datos correctamente");
            } catch (Exception e) {
                error("NO SE PUEDE SUBIR", "");
            }
        } else {
            error("NO hay archivos", "");
        }

    }
    
    public static Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }

    public String fechaString(Date fecha) {
        Date date = fecha;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);

        return strDate;
    }

    //Mensajes
    public void error(String mensaje, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, detalle));
    }

    public void info(String mensaje, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, detalle));
    }

    public void warn(String mensaje, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensaje, detalle));
    }

//Getter y Setter  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Clientes getPersona() {
        return persona;
    }

    public void setPersona(Clientes persona) {
        this.persona = persona;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    

}

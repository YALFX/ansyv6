/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

//default
import javax.enterprise.context.SessionScoped;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.context.FacesContext;

//paquetes
import edu.sena.entity.ansyt.Clientes;
import edu.sena.entity.ansyt.Estados;
import edu.sena.entity.ansyt.EstadosCiviles;

import edu.sena.entity.ansyt.Roles;
import edu.sena.entity.ansyt.ServiciosAdquiridos;
import edu.sena.entity.ansyt.TiposDocumentos;
import edu.sena.entity.ansyt.Usuarios;
import edu.sena.facade.ansyt.ClientesFacadeLocal;
import edu.sena.facade.ansyt.EstadosCivilesFacadeLocal;

import edu.sena.facade.ansyt.RolesFacadeLocal;
import edu.sena.facade.ansyt.ServiciosAdquiridosFacadeLocal;
import edu.sena.facade.ansyt.TiposDocumentosFacadeLocal;
import edu.sena.facade.ansyt.UsuariosFacadeLocal;
import edu.sena.sendmail.ansyt.SendMail;

//adicional
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


/**
 *
 * @author yinlo
 */
@Named(value = "cSession")
@SessionScoped
public class CSession implements Serializable {
    
    @EJB
    UsuariosFacadeLocal ufl;
    @EJB
    ClientesFacadeLocal cd;
    @EJB
    TiposDocumentosFacadeLocal ctd;
    @EJB
    EstadosCivilesFacadeLocal esfl;
    @EJB
    RolesFacadeLocal rfl;
    @EJB
    ServiciosAdquiridosFacadeLocal sfl;

    private Clientes persona = new Clientes();
    private Usuarios usuario = new Usuarios();
    private String fechaS = "";
    private String genero = "";
    private int es = 6;
    private int tipoDocumento = 1;
    private int rol = 2;
    private String correo = "";
    private String clave = "";
    private Integer id = 14;
    private String classMS;
    private String mensaje;
    private String doc;
    private UploadedFile file;
        


    public void validarUsuario() throws IOException {
        try {
            usuario = ufl.validarUsuario(correo, clave);
            if (usuario == null) {
                correo = "";
                clave = "";
                fechaS = "";
                error("El usuario o la contraseña son incorrectos", "");
            } else {
                if (usuario.getRolTipo().getIdrol() == 1) {
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    facesContext.getExternalContext().redirect("administrador/index.xhtml?faces-redirect=true");
                    rol = 1;
                } else if (usuario.getRolTipo().getIdrol() == 2) {
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    facesContext.getExternalContext().redirect("cliente/perfil.xhtml?faces-redirect=true");
                    id = usuario.getIDCliente().getIdCliente();
                    persona = cd.find(id);
                    fechaS = fechaString(persona.getCliFechaNacimiento());
                    rol = 2;
                }
            }
        } catch (IOException e) {
            error("Error al validar Usuario", "");
        }
    }

    public void rest() {
        persona = new Clientes();
        usuario = new Usuarios();
        fechaS = "";
        genero = "";
        es = 6;
        tipoDocumento = 1;
        rol = 1;
        correo = "";
        clave = "";
        id = 0;
        classMS = "";
        mensaje = "";
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

//    public List<Mensajes> listarTodosMensajesC() {
//        try {
//            return mfl.MensajesClientes(id);
//        } catch (Exception e) {
//            return null;
//        }
//    }

    public void recuperarUsuario() {
        try {
            usuario = ufl.validarUsuario(correo, clave);
            if (usuario != null) {

                SendMail mail = new SendMail();
                mail.setVmessage("Su usuario es: " + usuario.getUsCorreo() + "\nSu contraseña es: " + usuario.getUsClave());
                mail.setSubject("Recuperacion de Usuario");
                mail.SendMail(correo);
                correo = "";
                info("Enviado Exitocamente", "Los datos fueron enviados a su correo");
            } else {
                error("El usuario no existe", "");
            }
        } catch (Exception e) {
            error("Error al enviar los datos", "");
        }

    }

    public void cargarDatos(int idc) throws IOException {
        try {
            persona = new Clientes();
            usuario = new Usuarios();
            usuario = ufl.find(idc);
            id = idc;
            persona = cd.find(usuario.getIDCliente().getIdCliente());
            if (persona == null) {
                id = 30;
            } else {

                if (persona.getCliTipoDocumento() == null) {
                    tipoDocumento = 1;
                } else {
                    TiposDocumentos td = persona.getCliTipoDocumento();
                    tipoDocumento = td.getIdTipoDocumento();
                }
                if (persona.getCliEstadoCivil() == null) {
                    es = 1;
                } else {
                    EstadosCiviles se = persona.getCliEstadoCivil();
                    es = se.getIdEstadoCivil();
                }
                if (usuario.getRolTipo() == null) {
                    rol = 1;
                } else {
                    Roles role = usuario.getRolTipo();
                    rol = role.getIdrol();
                }
                genero = persona.getCliSexo();

                if (persona.getCliFechaNacimiento() == null) {
                    fechaS = "00-00-0000";
                } else {
                    fechaS = fechaString(persona.getCliFechaNacimiento());
                }

                FacesContext facesContext = FacesContext.getCurrentInstance();
                facesContext.getExternalContext().redirect("update.xhtml");

            }
        } catch (IOException e) {
            error("Error el cargar los datos", "");
        }

    }

    public void close() throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("clientes.xhtml");
        persona = new Clientes();
        usuario = new Usuarios();
    }
  

    public void actualizarDatos() throws IOException {
        try {
            
            Usuarios u = ufl.find(usuario.getIdUsuario());
            Clientes c = cd.find(u.getIDCliente().getIdCliente());
            if (u != null) {
                c.setCliNombre(persona.getCliNombre());
                c.setCliApellido(persona.getCliApellido());
                TiposDocumentos td = ctd.find(tipoDocumento);
                c.setCliTipoDocumento(td);
                Roles role = rfl.find(rol);
                u.setRolTipo(role);
                EstadosCiviles se = esfl.find(es);
                c.setCliEstadoCivil(se);
                c.setCliNumeroDocumento(persona.getCliNumeroDocumento());
                c.setCliSexo(genero);
                c.setCliEPS(persona.getCliEPS());
                c.setCliFechaNacimiento(ParseFecha(fechaS));
                c.setCliNumeroHijos(persona.getCliNumeroHijos());
                c.setCliTelefono(persona.getCliTelefono());
                c.setCliPais(persona.getCliPais());
                c.setCliDirección(persona.getCliDirección());
                
                if (this.file != null) {
                    String carpeta = "/home/anderson/NetBeansProjects/AnsyV5/src/main/webapp/resources/imagenes";
                    c.setUrlImg(file.getContent());
                    c.setNameImg(file.getFileName());
                    escriByte(IOUtils.toByteArray(file.getInputStream()), carpeta, file.getFileName());
                }
                

                if (usuario.getUsClave() != null) {
                    u.setUsClave(usuario.getUsClave());
                }
                
                
                Usuarios vd = ufl.validarUsuarioReg(usuario.getUsCorreo());
                if (vd == null) {
                    u.setUsCorreo(usuario.getUsCorreo());
                    cd.edit(c);
                    ufl.edit(u);
                    info("Se actualizo correctamente", "");
                } else if(vd.getUsCorreo().equalsIgnoreCase(u.getUsCorreo())){
                    u.setUsCorreo(usuario.getUsCorreo());
                    cd.edit(c);
                    ufl.edit(u);
                    info("Se actualizo correctamente", "");
                }else{error("El correo ya se encuentra registrado","");}
                if (rol == 2) {
                    
                    usuario = ufl.find(usuario.getIdUsuario());
                    persona = cd.find(usuario.getIDCliente().getIdCliente());
                }
            }
        } catch (IOException e) {
            error("Error al actualizar los datos", "");
        }

    }
    
    

    public void registrar() {
        Usuarios u = new Usuarios();
        try {
            int save = rol;
            if (rol == 1) {
                save = 1;
            }
            TiposDocumentos td = ctd.find(tipoDocumento);
            EstadosCiviles esd = esfl.find(es);
            Roles role = rfl.find(this.rol);
            persona.setCliFechaNacimiento(ParseFecha(fechaS));
            persona.setCliTipoDocumento(td);
            persona.setCliSexo(genero);
            persona.setCliEstadoCivil(esd);
            usuario.setRolTipo(role);
            persona.setNameImg("user-profile-icon.jpg");
            u = ufl.validarUsuarioReg(usuario.getUsCorreo());
            if (u == null) {
                cd.create(persona);
                usuario.setIDCliente(persona);
                ufl.create(usuario);
                persona = new Clientes();
                usuario = new Usuarios();
                fechaS = "";
                rol = save;
                info("Usuario registrado exitosamente", "");
            } else {
                error("El correo ya se encuentra registrado", "");
            }
        } catch (Exception e) {
            persona = new Clientes();
            error("Error al registrar nuevo usuario", "");
        }

    }

    public void escriByte(byte[] bytes, String carpeta, String imgName) throws IOException {
        try {
            Path path = Paths.get(carpeta, imgName);
            Files.write(path, bytes);
        } catch (IOException e) {
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
    
    
    
    public List<ServiciosAdquiridos> listarServiciosAdquiridos(){
       return sfl.planesActivosClientes(usuario.getIdUsuario(),1);
    }
    
    public List<ServiciosAdquiridos> listarServiciosAdquiridosAdmin(){
       return sfl.buscarIDUsuario(usuario.getIdUsuario());
    }
    
//    public void actializarEstadoSerAdd(int id){
//        ServiciosAdquiridos estado = sfl.find(id);
//        Estados estEdit = estado.
//        sfl.edit(estado);
//    }
    
    

    public Clientes getPersona() {
        return persona;
    }

    public void setPersona(Clientes persona) {
        this.persona = persona;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getEs() {
        return es;
    }

    public void setEs(int es) {
        this.es = es;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaS() {
        return fechaS;
    }

    public void setFechaS(String fechaS) {
        this.fechaS = fechaS;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getClassMS() {
        return classMS;
    }

    public void setClassMS(String classMS) {
        this.classMS = classMS;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void dowDoc() throws IOException {
        doc="../../resources/documentos/Plantilla-importar-clientes.xlsx";
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect(doc);
    }

}

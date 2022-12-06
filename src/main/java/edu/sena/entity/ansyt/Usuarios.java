/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.sena.entity.ansyt;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;


/**
 *
 * @author anderson
 */
@Entity
@Table(name = "Usuarios")

@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuarios.findByUsCorreo", query = "SELECT u FROM Usuarios u WHERE u.usCorreo = :usCorreo"),
    @NamedQuery(name = "Usuarios.findByUsClave", query = "SELECT u FROM Usuarios u WHERE u.usClave = :usClave")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Usuario")
    private Integer idUsuario;
    @Size(max = 45)
    @Column(name = "Us_Correo")
    private String usCorreo;
    @Size(max = 45)
    @Column(name = "Us_Clave")
    private String usClave;
    @JoinColumn(name = "Us_Plan", referencedColumnName = "Id_Plan")
    @ManyToOne(fetch = FetchType.LAZY)
    private Planes usPlan;
    @JoinColumn(name = "Us_Ser", referencedColumnName = "Id_Servicio")
    @ManyToOne(fetch = FetchType.LAZY)
    private Servicios usSer;
    @JoinColumn(name = "ID_Cliente", referencedColumnName = "Id_Cliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clientes iDCliente;
    @JoinColumn(name = "rol_tipo", referencedColumnName = "Id_rol")
    @ManyToOne(fetch = FetchType.LAZY)
    private Roles rolTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDUsuario", fetch = FetchType.LAZY)
    private Collection<ServiciosAdquiridos> serviciosAdquiridosCollection;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsCorreo() {
        return usCorreo;
    }

    public void setUsCorreo(String usCorreo) {
        this.usCorreo = usCorreo;
    }

    public String getUsClave() {
        return usClave;
    }

    public void setUsClave(String usClave) {
        this.usClave = usClave;
    }

    public Planes getUsPlan() {
        return usPlan;
    }

    public void setUsPlan(Planes usPlan) {
        this.usPlan = usPlan;
    }

    public Servicios getUsSer() {
        return usSer;
    }

    public void setUsSer(Servicios usSer) {
        this.usSer = usSer;
    }

    public Clientes getIDCliente() {
        return iDCliente;
    }

    public void setIDCliente(Clientes iDCliente) {
        this.iDCliente = iDCliente;
    }

    public Roles getRolTipo() {
        return rolTipo;
    }

    public void setRolTipo(Roles rolTipo) {
        this.rolTipo = rolTipo;
    }



    public void setServiciosAdquiridosCollection(Collection<ServiciosAdquiridos> serviciosAdquiridosCollection) {
        this.serviciosAdquiridosCollection = serviciosAdquiridosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ansyt.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}

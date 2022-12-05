/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.sena.entity.ansyt;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anderson
 */
@Entity
@Table(name = "ServiciosAdquiridos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiciosAdquiridos.findAll", query = "SELECT s FROM ServiciosAdquiridos s"),
    @NamedQuery(name = "ServiciosAdquiridos.findByIDSerAdd", query = "SELECT s FROM ServiciosAdquiridos s WHERE s.iDSerAdd = :iDSerAdd")})
public class ServiciosAdquiridos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SerAdd")
    private Integer iDSerAdd;
    @JoinColumn(name = "ID_Usuario", referencedColumnName = "Id_Usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios iDUsuario;
    @JoinColumn(name = "ID_Servicio", referencedColumnName = "Id_Plan")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Planes iDServicio;
    @JoinColumn(name = "ID_Estado", referencedColumnName = "ID_est")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Estados iDEstado;

    public ServiciosAdquiridos() {
    }

    public ServiciosAdquiridos(Integer iDSerAdd) {
        this.iDSerAdd = iDSerAdd;
    }

    public Integer getIDSerAdd() {
        return iDSerAdd;
    }

    public void setIDSerAdd(Integer iDSerAdd) {
        this.iDSerAdd = iDSerAdd;
    }

    public Usuarios getIDUsuario() {
        return iDUsuario;
    }

    public void setIDUsuario(Usuarios iDUsuario) {
        this.iDUsuario = iDUsuario;
    }

    public Planes getIDServicio() {
        return iDServicio;
    }

    public void setIDServicio(Planes iDServicio) {
        this.iDServicio = iDServicio;
    }

    public Estados getIDEstado() {
        return iDEstado;
    }

    public void setIDEstado(Estados iDEstado) {
        this.iDEstado = iDEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDSerAdd != null ? iDSerAdd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiciosAdquiridos)) {
            return false;
        }
        ServiciosAdquiridos other = (ServiciosAdquiridos) object;
        if ((this.iDSerAdd == null && other.iDSerAdd != null) || (this.iDSerAdd != null && !this.iDSerAdd.equals(other.iDSerAdd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ansyt.ServiciosAdquiridos[ iDSerAdd=" + iDSerAdd + " ]";
    }
    
}

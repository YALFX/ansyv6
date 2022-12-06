/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.sena.entity.ansyt;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author anderson
 */
@Entity
@Table(name = "Servicios")

@NamedQueries({
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s"),
    @NamedQuery(name = "Servicios.findByIdServicio", query = "SELECT s FROM Servicios s WHERE s.idServicio = :idServicio"),
    @NamedQuery(name = "Servicios.findBySerNombre", query = "SELECT s FROM Servicios s WHERE s.serNombre = :serNombre"),
    @NamedQuery(name = "Servicios.findBySerCategoria", query = "SELECT s FROM Servicios s WHERE s.serCategoria = :serCategoria"),
    @NamedQuery(name = "Servicios.findByNameimg", query = "SELECT s FROM Servicios s WHERE s.nameimg = :nameimg")})
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Servicio")
    private Integer idServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Ser_Nombre")
    private String serNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Ser_Categoria")
    private String serCategoria;
    @Lob
    @Column(name = "Ser_img")
    private byte[] serimg;
    @Size(max = 300)
    @Column(name = "Name_img")
    private String nameimg;
    @JoinColumn(name = "Ser_est", referencedColumnName = "ID_est")
    @ManyToOne(fetch = FetchType.LAZY)
    private Estados serest;
    @JoinColumn(name = "Ser_Entidad", referencedColumnName = "Id_Entidades")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Entidades serEntidad;
    @OneToMany(mappedBy = "usSer", fetch = FetchType.LAZY)
    private Collection<Usuarios> usuariosCollection;

    public Servicios() {
    }

    public Servicios(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Servicios(Integer idServicio, String serNombre, String serCategoria) {
        this.idServicio = idServicio;
        this.serNombre = serNombre;
        this.serCategoria = serCategoria;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getSerNombre() {
        return serNombre;
    }

    public void setSerNombre(String serNombre) {
        this.serNombre = serNombre;
    }

    public String getSerCategoria() {
        return serCategoria;
    }

    public void setSerCategoria(String serCategoria) {
        this.serCategoria = serCategoria;
    }

    public byte[] getSerimg() {
        return serimg;
    }

    public void setSerimg(byte[] serimg) {
        this.serimg = serimg;
    }

    public String getNameimg() {
        return nameimg;
    }

    public void setNameimg(String nameimg) {
        this.nameimg = nameimg;
    }

    public Estados getSerest() {
        return serest;
    }

    public void setSerest(Estados serest) {
        this.serest = serest;
    }

    public Entidades getSerEntidad() {
        return serEntidad;
    }

    public void setSerEntidad(Entidades serEntidad) {
        this.serEntidad = serEntidad;
    }


    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicios)) {
            return false;
        }
        Servicios other = (Servicios) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ansyt.Servicios[ idServicio=" + idServicio + " ]";
    }
    
}

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
import javax.persistence.Lob;
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
@Table(name = "Entidades")

@NamedQueries({
    @NamedQuery(name = "Entidades.findAll", query = "SELECT e FROM Entidades e"),
    @NamedQuery(name = "Entidades.findByIdEntidades", query = "SELECT e FROM Entidades e WHERE e.idEntidades = :idEntidades"),
    @NamedQuery(name = "Entidades.findByEntNombre", query = "SELECT e FROM Entidades e WHERE e.entNombre = :entNombre"),
    @NamedQuery(name = "Entidades.findByEntDescripcion", query = "SELECT e FROM Entidades e WHERE e.entDescripcion = :entDescripcion"),
    @NamedQuery(name = "Entidades.findByNameimg", query = "SELECT e FROM Entidades e WHERE e.nameimg = :nameimg")})
public class Entidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Entidades")
    private Integer idEntidades;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Ent_Nombre")
    private String entNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Ent_Descripcion")
    private String entDescripcion;
    @Lob
    @Column(name = "Ent_img")
    private byte[] entimg;
    @Size(max = 300)
    @Column(name = "Name_img")
    private String nameimg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serEntidad", fetch = FetchType.LAZY)
    private Collection<Servicios> serviciosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planEntidad", fetch = FetchType.LAZY)
    private Collection<Planes> planesCollection;

    public Entidades() {
    }

    public Entidades(Integer idEntidades) {
        this.idEntidades = idEntidades;
    }

    public Entidades(Integer idEntidades, String entNombre, String entDescripcion) {
        this.idEntidades = idEntidades;
        this.entNombre = entNombre;
        this.entDescripcion = entDescripcion;
    }

    public Integer getIdEntidades() {
        return idEntidades;
    }

    public void setIdEntidades(Integer idEntidades) {
        this.idEntidades = idEntidades;
    }

    public String getEntNombre() {
        return entNombre;
    }

    public void setEntNombre(String entNombre) {
        this.entNombre = entNombre;
    }

    public String getEntDescripcion() {
        return entDescripcion;
    }

    public void setEntDescripcion(String entDescripcion) {
        this.entDescripcion = entDescripcion;
    }

    public byte[] getEntimg() {
        return entimg;
    }

    public void setEntimg(byte[] entimg) {
        this.entimg = entimg;
    }

    public String getNameimg() {
        return nameimg;
    }

    public void setNameimg(String nameimg) {
        this.nameimg = nameimg;
    }



    public void setServiciosCollection(Collection<Servicios> serviciosCollection) {
        this.serviciosCollection = serviciosCollection;
    }



    public void setPlanesCollection(Collection<Planes> planesCollection) {
        this.planesCollection = planesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidades != null ? idEntidades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidades)) {
            return false;
        }
        Entidades other = (Entidades) object;
        if ((this.idEntidades == null && other.idEntidades != null) || (this.idEntidades != null && !this.idEntidades.equals(other.idEntidades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ansyt.Entidades[ idEntidades=" + idEntidades + " ]";
    }
    
}

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anderson
 */
@Entity
@Table(name = "Estados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estados.findAll", query = "SELECT e FROM Estados e"),
    @NamedQuery(name = "Estados.findByIDest", query = "SELECT e FROM Estados e WHERE e.iDest = :iDest"),
    @NamedQuery(name = "Estados.findByNameest", query = "SELECT e FROM Estados e WHERE e.nameest = :nameest"),
    @NamedQuery(name = "Estados.findByDescripcionest", query = "SELECT e FROM Estados e WHERE e.descripcionest = :descripcionest")})
public class Estados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_est")
    private Integer iDest;
    @Size(max = 50)
    @Column(name = "Name_est")
    private String nameest;
    @Size(max = 300)
    @Column(name = "Descripcion_est")
    private String descripcionest;
    @OneToMany(mappedBy = "serest", fetch = FetchType.LAZY)
    private Collection<Servicios> serviciosCollection;
    @OneToMany(mappedBy = "planest", fetch = FetchType.LAZY)
    private Collection<Planes> planesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDEstado", fetch = FetchType.LAZY)
    private Collection<ServiciosAdquiridos> serviciosAdquiridosCollection;

    public Estados() {
    }

    public Estados(Integer iDest) {
        this.iDest = iDest;
    }

    public Integer getIDest() {
        return iDest;
    }

    public void setIDest(Integer iDest) {
        this.iDest = iDest;
    }

    public String getNameest() {
        return nameest;
    }

    public void setNameest(String nameest) {
        this.nameest = nameest;
    }

    public String getDescripcionest() {
        return descripcionest;
    }

    public void setDescripcionest(String descripcionest) {
        this.descripcionest = descripcionest;
    }

    @XmlTransient
    public Collection<Servicios> getServiciosCollection() {
        return serviciosCollection;
    }

    public void setServiciosCollection(Collection<Servicios> serviciosCollection) {
        this.serviciosCollection = serviciosCollection;
    }

    @XmlTransient
    public Collection<Planes> getPlanesCollection() {
        return planesCollection;
    }

    public void setPlanesCollection(Collection<Planes> planesCollection) {
        this.planesCollection = planesCollection;
    }

    @XmlTransient
    public Collection<ServiciosAdquiridos> getServiciosAdquiridosCollection() {
        return serviciosAdquiridosCollection;
    }

    public void setServiciosAdquiridosCollection(Collection<ServiciosAdquiridos> serviciosAdquiridosCollection) {
        this.serviciosAdquiridosCollection = serviciosAdquiridosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDest != null ? iDest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estados)) {
            return false;
        }
        Estados other = (Estados) object;
        if ((this.iDest == null && other.iDest != null) || (this.iDest != null && !this.iDest.equals(other.iDest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ansyt.Estados[ iDest=" + iDest + " ]";
    }
    
}

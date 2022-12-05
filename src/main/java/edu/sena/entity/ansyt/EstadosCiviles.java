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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anderson
 */
@Entity
@Table(name = "Estados_Civiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosCiviles.findAll", query = "SELECT e FROM EstadosCiviles e"),
    @NamedQuery(name = "EstadosCiviles.findByIdEstadoCivil", query = "SELECT e FROM EstadosCiviles e WHERE e.idEstadoCivil = :idEstadoCivil"),
    @NamedQuery(name = "EstadosCiviles.findByECNombre", query = "SELECT e FROM EstadosCiviles e WHERE e.eCNombre = :eCNombre")})
public class EstadosCiviles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_EstadoCivil")
    private Integer idEstadoCivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EC_Nombre")
    private String eCNombre;
    @OneToMany(mappedBy = "cliEstadoCivil", fetch = FetchType.LAZY)
    private Collection<Clientes> clientesCollection;

    public EstadosCiviles() {
    }

    public EstadosCiviles(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public EstadosCiviles(Integer idEstadoCivil, String eCNombre) {
        this.idEstadoCivil = idEstadoCivil;
        this.eCNombre = eCNombre;
    }

    public Integer getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public String getECNombre() {
        return eCNombre;
    }

    public void setECNombre(String eCNombre) {
        this.eCNombre = eCNombre;
    }

    @XmlTransient
    public Collection<Clientes> getClientesCollection() {
        return clientesCollection;
    }

    public void setClientesCollection(Collection<Clientes> clientesCollection) {
        this.clientesCollection = clientesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoCivil != null ? idEstadoCivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosCiviles)) {
            return false;
        }
        EstadosCiviles other = (EstadosCiviles) object;
        if ((this.idEstadoCivil == null && other.idEstadoCivil != null) || (this.idEstadoCivil != null && !this.idEstadoCivil.equals(other.idEstadoCivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ansyt.EstadosCiviles[ idEstadoCivil=" + idEstadoCivil + " ]";
    }
    
}

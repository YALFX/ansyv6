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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "Planes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planes.findAll", query = "SELECT p FROM Planes p"),
    @NamedQuery(name = "Planes.findByIdPlan", query = "SELECT p FROM Planes p WHERE p.idPlan = :idPlan"),
    @NamedQuery(name = "Planes.findByPlanNombre", query = "SELECT p FROM Planes p WHERE p.planNombre = :planNombre"),
    @NamedQuery(name = "Planes.findByPlanCategoria", query = "SELECT p FROM Planes p WHERE p.planCategoria = :planCategoria"),
    @NamedQuery(name = "Planes.findByPlanTipoPlan", query = "SELECT p FROM Planes p WHERE p.planTipoPlan = :planTipoPlan"),
    @NamedQuery(name = "Planes.findByPlanCopago", query = "SELECT p FROM Planes p WHERE p.planCopago = :planCopago"),
    @NamedQuery(name = "Planes.findByPlanPrecio", query = "SELECT p FROM Planes p WHERE p.planPrecio = :planPrecio"),
    @NamedQuery(name = "Planes.findByPlanDescripcion", query = "SELECT p FROM Planes p WHERE p.planDescripcion = :planDescripcion"),
    @NamedQuery(name = "Planes.findByNameimg", query = "SELECT p FROM Planes p WHERE p.nameimg = :nameimg")})
public class Planes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Plan")
    private Integer idPlan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Plan_Nombre")
    private String planNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Plan_Categoria")
    private String planCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Plan_TipoPlan")
    private String planTipoPlan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Plan_Copago")
    private String planCopago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Plan_Precio")
    private int planPrecio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "Plan_Descripcion")
    private String planDescripcion;
    @Lob
    @Column(name = "Plan_img")
    private byte[] planimg;
    @Size(max = 300)
    @Column(name = "Name_img")
    private String nameimg;
    @OneToMany(mappedBy = "usPlan", fetch = FetchType.LAZY)
    private Collection<Usuarios> usuariosCollection;
    @JoinColumn(name = "Plan_Entidad", referencedColumnName = "Id_Entidades")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Entidades planEntidad;
    @JoinColumn(name = "Plan_est", referencedColumnName = "ID_est")
    @ManyToOne(fetch = FetchType.LAZY)
    private Estados planest;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDServicio", fetch = FetchType.LAZY)
    private Collection<ServiciosAdquiridos> serviciosAdquiridosCollection;

    public Planes() {
    }

    public Planes(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public Planes(Integer idPlan, String planNombre, String planCategoria, String planTipoPlan, String planCopago, int planPrecio, String planDescripcion) {
        this.idPlan = idPlan;
        this.planNombre = planNombre;
        this.planCategoria = planCategoria;
        this.planTipoPlan = planTipoPlan;
        this.planCopago = planCopago;
        this.planPrecio = planPrecio;
        this.planDescripcion = planDescripcion;
    }

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public String getPlanNombre() {
        return planNombre;
    }

    public void setPlanNombre(String planNombre) {
        this.planNombre = planNombre;
    }

    public String getPlanCategoria() {
        return planCategoria;
    }

    public void setPlanCategoria(String planCategoria) {
        this.planCategoria = planCategoria;
    }

    public String getPlanTipoPlan() {
        return planTipoPlan;
    }

    public void setPlanTipoPlan(String planTipoPlan) {
        this.planTipoPlan = planTipoPlan;
    }

    public String getPlanCopago() {
        return planCopago;
    }

    public void setPlanCopago(String planCopago) {
        this.planCopago = planCopago;
    }

    public int getPlanPrecio() {
        return planPrecio;
    }

    public void setPlanPrecio(int planPrecio) {
        this.planPrecio = planPrecio;
    }

    public String getPlanDescripcion() {
        return planDescripcion;
    }

    public void setPlanDescripcion(String planDescripcion) {
        this.planDescripcion = planDescripcion;
    }

    public byte[] getPlanimg() {
        return planimg;
    }

    public void setPlanimg(byte[] planimg) {
        this.planimg = planimg;
    }

    public String getNameimg() {
        return nameimg;
    }

    public void setNameimg(String nameimg) {
        this.nameimg = nameimg;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    public Entidades getPlanEntidad() {
        return planEntidad;
    }

    public void setPlanEntidad(Entidades planEntidad) {
        this.planEntidad = planEntidad;
    }

    public Estados getPlanest() {
        return planest;
    }

    public void setPlanest(Estados planest) {
        this.planest = planest;
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
        hash += (idPlan != null ? idPlan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planes)) {
            return false;
        }
        Planes other = (Planes) object;
        if ((this.idPlan == null && other.idPlan != null) || (this.idPlan != null && !this.idPlan.equals(other.idPlan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ansyt.Planes[ idPlan=" + idPlan + " ]";
    }
    
}

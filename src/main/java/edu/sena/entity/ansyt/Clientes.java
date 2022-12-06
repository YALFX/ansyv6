/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.sena.entity.ansyt;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;


/**
 *
 * @author anderson
 */
@Entity
@Table(name = "Clientes")

@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByIdCliente", query = "SELECT c FROM Clientes c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Clientes.findByCliNombre", query = "SELECT c FROM Clientes c WHERE c.cliNombre = :cliNombre"),
    @NamedQuery(name = "Clientes.findByCliApellido", query = "SELECT c FROM Clientes c WHERE c.cliApellido = :cliApellido"),
    @NamedQuery(name = "Clientes.findByCliNumeroDocumento", query = "SELECT c FROM Clientes c WHERE c.cliNumeroDocumento = :cliNumeroDocumento"),
    @NamedQuery(name = "Clientes.findByCliSexo", query = "SELECT c FROM Clientes c WHERE c.cliSexo = :cliSexo"),
    @NamedQuery(name = "Clientes.findByCliEPS", query = "SELECT c FROM Clientes c WHERE c.cliEPS = :cliEPS"),
    @NamedQuery(name = "Clientes.findByCliFechaNacimiento", query = "SELECT c FROM Clientes c WHERE c.cliFechaNacimiento = :cliFechaNacimiento"),
    @NamedQuery(name = "Clientes.findByCliNumeroHijos", query = "SELECT c FROM Clientes c WHERE c.cliNumeroHijos = :cliNumeroHijos"),
    @NamedQuery(name = "Clientes.findByCliTelefono", query = "SELECT c FROM Clientes c WHERE c.cliTelefono = :cliTelefono"),
    @NamedQuery(name = "Clientes.findByCliPais", query = "SELECT c FROM Clientes c WHERE c.cliPais = :cliPais"),
    @NamedQuery(name = "Clientes.findByCliDepartamento", query = "SELECT c FROM Clientes c WHERE c.cliDepartamento = :cliDepartamento"),
    @NamedQuery(name = "Clientes.findByCliCiudad", query = "SELECT c FROM Clientes c WHERE c.cliCiudad = :cliCiudad"),
    @NamedQuery(name = "Clientes.findByCliDirecci\u00f3n", query = "SELECT c FROM Clientes c WHERE c.cliDirecci\u00f3n = :cliDirecci\u00f3n"),
    @NamedQuery(name = "Clientes.findByNameImg", query = "SELECT c FROM Clientes c WHERE c.nameImg = :nameImg")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Cliente")
    private Integer idCliente;
    @Size(max = 80)
    @Column(name = "Cli_Nombre")
    private String cliNombre;
    @Size(max = 50)
    @Column(name = "Cli_Apellido")
    private String cliApellido;
    @Column(name = "Cli_NumeroDocumento")
    private Integer cliNumeroDocumento;
    @Size(max = 1)
    @Column(name = "Cli_Sexo")
    private String cliSexo;
    @Size(max = 30)
    @Column(name = "Cli_EPS")
    private String cliEPS;
    @Column(name = "Cli_FechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date cliFechaNacimiento;
    @Column(name = "Cli_NumeroHijos")
    private Integer cliNumeroHijos;
    @Column(name = "Cli_Telefono")
    private BigInteger cliTelefono;
    @Size(max = 45)
    @Column(name = "Cli_Pais")
    private String cliPais;
    @Size(max = 45)
    @Column(name = "Cli_Departamento")
    private String cliDepartamento;
    @Size(max = 45)
    @Column(name = "Cli_Ciudad")
    private String cliCiudad;
    @Size(max = 45)
    @Column(name = "Cli_Direcci\u00f3n")
    private String cliDirección;
    @Lob
    @Column(name = "url_img")
    private byte[] urlImg;
    @Size(max = 300)
    @Column(name = "name_img")
    private String nameImg;
    @JoinColumn(name = "Cli_TipoDocumento", referencedColumnName = "Id_TipoDocumento")
    @ManyToOne(fetch = FetchType.LAZY)
    private TiposDocumentos cliTipoDocumento;
    @JoinColumn(name = "Cli_EstadoCivil", referencedColumnName = "Id_EstadoCivil")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadosCiviles cliEstadoCivil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDCliente", fetch = FetchType.LAZY)
    private Collection<Usuarios> usuariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente", fetch = FetchType.LAZY)
    private Collection<Pqrs> pqrsCollection;

    public Clientes() {
    }

    public Clientes(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliApellido() {
        return cliApellido;
    }

    public void setCliApellido(String cliApellido) {
        this.cliApellido = cliApellido;
    }

    public Integer getCliNumeroDocumento() {
        return cliNumeroDocumento;
    }

    public void setCliNumeroDocumento(Integer cliNumeroDocumento) {
        this.cliNumeroDocumento = cliNumeroDocumento;
    }

    public String getCliSexo() {
        return cliSexo;
    }

    public void setCliSexo(String cliSexo) {
        this.cliSexo = cliSexo;
    }

    public String getCliEPS() {
        return cliEPS;
    }

    public void setCliEPS(String cliEPS) {
        this.cliEPS = cliEPS;
    }

    public Date getCliFechaNacimiento() {
        return cliFechaNacimiento;
    }

    public void setCliFechaNacimiento(Date cliFechaNacimiento) {
        this.cliFechaNacimiento = cliFechaNacimiento;
    }

    public Integer getCliNumeroHijos() {
        return cliNumeroHijos;
    }

    public void setCliNumeroHijos(Integer cliNumeroHijos) {
        this.cliNumeroHijos = cliNumeroHijos;
    }

    public BigInteger getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(BigInteger cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public String getCliPais() {
        return cliPais;
    }

    public void setCliPais(String cliPais) {
        this.cliPais = cliPais;
    }

    public String getCliDepartamento() {
        return cliDepartamento;
    }

    public void setCliDepartamento(String cliDepartamento) {
        this.cliDepartamento = cliDepartamento;
    }

    public String getCliCiudad() {
        return cliCiudad;
    }

    public void setCliCiudad(String cliCiudad) {
        this.cliCiudad = cliCiudad;
    }

    public String getCliDirección() {
        return cliDirección;
    }

    public void setCliDirección(String cliDirección) {
        this.cliDirección = cliDirección;
    }

    public byte[] getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(byte[] urlImg) {
        this.urlImg = urlImg;
    }

    public String getNameImg() {
        return nameImg;
    }

    public void setNameImg(String nameImg) {
        this.nameImg = nameImg;
    }

    public TiposDocumentos getCliTipoDocumento() {
        return cliTipoDocumento;
    }

    public void setCliTipoDocumento(TiposDocumentos cliTipoDocumento) {
        this.cliTipoDocumento = cliTipoDocumento;
    }

    public EstadosCiviles getCliEstadoCivil() {
        return cliEstadoCivil;
    }

    public void setCliEstadoCivil(EstadosCiviles cliEstadoCivil) {
        this.cliEstadoCivil = cliEstadoCivil;
    }



    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }



    public void setPqrsCollection(Collection<Pqrs> pqrsCollection) {
        this.pqrsCollection = pqrsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ansyt.Clientes[ idCliente=" + idCliente + " ]";
    }
    
}

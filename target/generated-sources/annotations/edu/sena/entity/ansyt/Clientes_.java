package edu.sena.entity.ansyt;

import edu.sena.entity.ansyt.EstadosCiviles;
import edu.sena.entity.ansyt.Pqrs;
import edu.sena.entity.ansyt.TiposDocumentos;
import edu.sena.entity.ansyt.Usuarios;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-06T00:31:21")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, TiposDocumentos> cliTipoDocumento;
    public static volatile SingularAttribute<Clientes, String> cliNombre;
    public static volatile SingularAttribute<Clientes, Integer> cliNumeroDocumento;
    public static volatile SingularAttribute<Clientes, Integer> cliNumeroHijos;
    public static volatile SingularAttribute<Clientes, String> cliSexo;
    public static volatile SingularAttribute<Clientes, byte[]> urlImg;
    public static volatile SingularAttribute<Clientes, String> cliCiudad;
    public static volatile SingularAttribute<Clientes, Integer> idCliente;
    public static volatile SingularAttribute<Clientes, String> cliDirección;
    public static volatile SingularAttribute<Clientes, EstadosCiviles> cliEstadoCivil;
    public static volatile SingularAttribute<Clientes, BigInteger> cliTelefono;
    public static volatile SingularAttribute<Clientes, String> cliDepartamento;
    public static volatile CollectionAttribute<Clientes, Usuarios> usuariosCollection;
    public static volatile SingularAttribute<Clientes, Date> cliFechaNacimiento;
    public static volatile SingularAttribute<Clientes, String> cliEPS;
    public static volatile SingularAttribute<Clientes, String> cliPais;
    public static volatile SingularAttribute<Clientes, String> nameImg;
    public static volatile SingularAttribute<Clientes, String> cliApellido;
    public static volatile CollectionAttribute<Clientes, Pqrs> pqrsCollection;

}
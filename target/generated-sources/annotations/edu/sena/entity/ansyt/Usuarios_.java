package edu.sena.entity.ansyt;

import edu.sena.entity.ansyt.Clientes;
import edu.sena.entity.ansyt.Planes;
import edu.sena.entity.ansyt.Roles;
import edu.sena.entity.ansyt.Servicios;
import edu.sena.entity.ansyt.ServiciosAdquiridos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-06T02:16:56")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> usClave;
    public static volatile SingularAttribute<Usuarios, Servicios> usSer;
    public static volatile SingularAttribute<Usuarios, Planes> usPlan;
    public static volatile CollectionAttribute<Usuarios, ServiciosAdquiridos> serviciosAdquiridosCollection;
    public static volatile SingularAttribute<Usuarios, Integer> idUsuario;
    public static volatile SingularAttribute<Usuarios, String> usCorreo;
    public static volatile SingularAttribute<Usuarios, Roles> rolTipo;
    public static volatile SingularAttribute<Usuarios, Clientes> iDCliente;

}
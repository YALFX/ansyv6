package edu.sena.entity.ansyt;

import edu.sena.entity.ansyt.Entidades;
import edu.sena.entity.ansyt.Estados;
import edu.sena.entity.ansyt.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-06T00:31:21")
@StaticMetamodel(Servicios.class)
public class Servicios_ { 

    public static volatile SingularAttribute<Servicios, String> serCategoria;
    public static volatile SingularAttribute<Servicios, byte[]> serimg;
    public static volatile SingularAttribute<Servicios, Entidades> serEntidad;
    public static volatile SingularAttribute<Servicios, Estados> serest;
    public static volatile CollectionAttribute<Servicios, Usuarios> usuariosCollection;
    public static volatile SingularAttribute<Servicios, Integer> idServicio;
    public static volatile SingularAttribute<Servicios, String> nameimg;
    public static volatile SingularAttribute<Servicios, String> serNombre;

}
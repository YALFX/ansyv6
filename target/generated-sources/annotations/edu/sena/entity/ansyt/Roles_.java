package edu.sena.entity.ansyt;

import edu.sena.entity.ansyt.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-06T02:16:56")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile SingularAttribute<Roles, Integer> idrol;
    public static volatile CollectionAttribute<Roles, Usuarios> usuariosCollection;
    public static volatile SingularAttribute<Roles, String> nombre;

}
package edu.sena.entity.ansyt;

import edu.sena.entity.ansyt.Planes;
import edu.sena.entity.ansyt.Servicios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-06T00:31:21")
@StaticMetamodel(Entidades.class)
public class Entidades_ { 

    public static volatile SingularAttribute<Entidades, String> entDescripcion;
    public static volatile SingularAttribute<Entidades, Integer> idEntidades;
    public static volatile SingularAttribute<Entidades, byte[]> entimg;
    public static volatile CollectionAttribute<Entidades, Planes> planesCollection;
    public static volatile SingularAttribute<Entidades, String> entNombre;
    public static volatile SingularAttribute<Entidades, String> nameimg;
    public static volatile CollectionAttribute<Entidades, Servicios> serviciosCollection;

}
package edu.sena.entity.ansyt;

import edu.sena.entity.ansyt.Entidades;
import edu.sena.entity.ansyt.Estados;
import edu.sena.entity.ansyt.ServiciosAdquiridos;
import edu.sena.entity.ansyt.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-06T02:16:56")
@StaticMetamodel(Planes.class)
public class Planes_ { 

    public static volatile SingularAttribute<Planes, String> planDescripcion;
    public static volatile SingularAttribute<Planes, String> planTipoPlan;
    public static volatile SingularAttribute<Planes, String> planCategoria;
    public static volatile SingularAttribute<Planes, String> planCopago;
    public static volatile SingularAttribute<Planes, Integer> idPlan;
    public static volatile SingularAttribute<Planes, Entidades> planEntidad;
    public static volatile SingularAttribute<Planes, Estados> planest;
    public static volatile SingularAttribute<Planes, byte[]> planimg;
    public static volatile SingularAttribute<Planes, Integer> planPrecio;
    public static volatile CollectionAttribute<Planes, ServiciosAdquiridos> serviciosAdquiridosCollection;
    public static volatile CollectionAttribute<Planes, Usuarios> usuariosCollection;
    public static volatile SingularAttribute<Planes, String> planNombre;
    public static volatile SingularAttribute<Planes, String> nameimg;

}
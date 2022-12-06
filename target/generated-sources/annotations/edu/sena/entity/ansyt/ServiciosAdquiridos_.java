package edu.sena.entity.ansyt;

import edu.sena.entity.ansyt.Estados;
import edu.sena.entity.ansyt.Planes;
import edu.sena.entity.ansyt.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-06T02:16:56")
@StaticMetamodel(ServiciosAdquiridos.class)
public class ServiciosAdquiridos_ { 

    public static volatile SingularAttribute<ServiciosAdquiridos, Integer> iDSerAdd;
    public static volatile SingularAttribute<ServiciosAdquiridos, Usuarios> iDUsuario;
    public static volatile SingularAttribute<ServiciosAdquiridos, Planes> iDServicio;
    public static volatile SingularAttribute<ServiciosAdquiridos, Estados> iDEstado;

}
package edu.sena.entity.ansyt;

import edu.sena.entity.ansyt.Clientes;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-06T02:16:56")
@StaticMetamodel(EstadosCiviles.class)
public class EstadosCiviles_ { 

    public static volatile SingularAttribute<EstadosCiviles, Integer> idEstadoCivil;
    public static volatile SingularAttribute<EstadosCiviles, String> eCNombre;
    public static volatile CollectionAttribute<EstadosCiviles, Clientes> clientesCollection;

}
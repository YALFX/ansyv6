package edu.sena.entity.ansyt;

import edu.sena.entity.ansyt.Planes;
import edu.sena.entity.ansyt.Servicios;
import edu.sena.entity.ansyt.ServiciosAdquiridos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-06T02:16:56")
@StaticMetamodel(Estados.class)
public class Estados_ { 

    public static volatile SingularAttribute<Estados, Integer> iDest;
    public static volatile CollectionAttribute<Estados, ServiciosAdquiridos> serviciosAdquiridosCollection;
    public static volatile CollectionAttribute<Estados, Planes> planesCollection;
    public static volatile SingularAttribute<Estados, String> descripcionest;
    public static volatile SingularAttribute<Estados, String> nameest;
    public static volatile CollectionAttribute<Estados, Servicios> serviciosCollection;

}
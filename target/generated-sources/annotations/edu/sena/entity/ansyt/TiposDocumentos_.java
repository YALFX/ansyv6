package edu.sena.entity.ansyt;

import edu.sena.entity.ansyt.Clientes;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-06T00:31:21")
@StaticMetamodel(TiposDocumentos.class)
public class TiposDocumentos_ { 

    public static volatile SingularAttribute<TiposDocumentos, Integer> idTipoDocumento;
    public static volatile CollectionAttribute<TiposDocumentos, Clientes> clientesCollection;
    public static volatile SingularAttribute<TiposDocumentos, String> docNombre;

}
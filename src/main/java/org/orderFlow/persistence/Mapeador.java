package org.orderFlow.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaz que define los métodos necesarios para mapear objetos a base de datos.
 */
public interface Mapeador {

    /**
     * Devuelve el identificador único del objeto.
     *
     * @return El identificador único (OID).
     */
    int getOid();

    /**
     * Establece el identificador único del objeto.
     *
     * @param oid El identificador único (OID).
     */
    void setOid(int oid);

    /**
     * Devuelve la sentencia SQL para insertar el objeto en la base de datos.
     *
     * @return La sentencia SQL de inserción.
     */
    String getSqlInsertar();

    /**
     * Devuelve la sentencia SQL para modificar el objeto en la base de datos.
     *
     * @return La sentencia SQL de modificación.
     */
    String getSqlModificar();

    /**
     * Devuelve la sentencia SQL para borrar el objeto de la base de datos.
     *
     * @return La sentencia SQL de borrado.
     */
    String getSqlBorrar();

    /**
     * Devuelve la sentencia SQL para restaurar el objeto desde la base de datos.
     *
     * @return La sentencia SQL de restauración.
     */
    String getSqlRestaurar();

    /**
     * Devuelve la sentencia SQL para seleccionar el objeto desde la base de datos.
     *
     * @return La sentencia SQL de selección.
     */
    String getSqlSeleccionar();

    /**
     * Lee los datos de un ResultSet y los asigna al objeto.
     *
     * @param rs El ResultSet con los datos.
     * @throws SQLException Si ocurre un error al leer los datos.
     */
    void leer(ResultSet rs) throws SQLException;

    /**
     * Crea un nuevo objeto.
     */
    void crearNuevo();

    /**
     * Devuelve el objeto mapeado.
     *
     * @return El objeto mapeado.
     */
    Object getObject();
}

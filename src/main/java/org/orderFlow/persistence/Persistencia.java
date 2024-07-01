package org.orderFlow.persistence;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona la persistencia de objetos en la base de datos.
 */
@Repository
public class Persistencia {

    private BaseDeDatos base;
    private static Persistencia instanciaPersistencia = new Persistencia();

    /**
     * Devuelve la instancia única de la clase.
     *
     * @return La instancia única de Persistencia.
     */
    public static Persistencia Instancia() {
        return instanciaPersistencia;
    }

    private Persistencia() {}

    /**
     * Devuelve la instancia de la base de datos.
     *
     * @return La instancia de BaseDeDatos.
     */
    public BaseDeDatos getBase() {
        return base;
    }

    /**
     * Establece la instancia de la base de datos.
     *
     * @param base La instancia de BaseDeDatos.
     */
    public void setBase(BaseDeDatos base) {
        this.base = base;
    }

    /**
     * Obtiene el próximo identificador único (OID).
     *
     * @return El próximo OID.
     */
    private static int proximoOid() {
        try {
            String sql = "SELECT valor FROM Oid";
            ResultSet rs = instanciaPersistencia.base.consultar(sql);
            rs.next();
            int oid = rs.getInt("valor");
            sql = "UPDATE Oid SET valor=" + (oid + 1);
            instanciaPersistencia.base.actualizar(sql);
            return oid;
        } catch (SQLException e) {
            System.out.println("Error al obtener el oid: " + e.getMessage());
            return -1;
        }
    }

    /**
     * Guarda un objeto en la base de datos.
     *
     * @param obj El objeto a guardar.
     */
    public void guardar(Mapeador obj) {
        if (obj.getOid() == 0) {
            insertar(obj);
        } else {
            modificar(obj);
        }
    }

    /**
     * Inserta un nuevo objeto en la base de datos.
     *
     * @param obj El objeto a insertar.
     */
    private void insertar(Mapeador obj) {
        int oid = proximoOid();
        obj.setOid(oid);
        String sql = obj.getSqlInsertar();
        int filas = base.actualizar(sql);
        if (filas < 1) {
            obj.setOid(0);
        }
    }

    /**
     * Modifica un objeto existente en la base de datos.
     *
     * @param obj El objeto a modificar.
     */
    private void modificar(Mapeador obj) {
        String sql = obj.getSqlModificar();
        base.actualizar(sql);
    }

    /**
     * Borra un objeto de la base de datos.
     *
     * @param obj El objeto a borrar.
     */
    private void borrar(Mapeador obj) {
        String sql = obj.getSqlBorrar();
        int filas = base.actualizar(sql);
        if (filas > 0) {
            obj.setOid(0);
        }
    }

    /**
     * Restaura un objeto desde la base de datos.
     *
     * @param obj El objeto a restaurar.
     */
    public void restaurar(Mapeador obj) {
        if (obj.getOid() > 0) {
            String sql = obj.getSqlRestaurar();
            ResultSet rs = instanciaPersistencia.base.consultar(sql);
            try {
                rs.next();
                obj.leer(rs);
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error al restaurar: " + e.getMessage());
            }
        }
    }

    /**
     * Busca objetos en la base de datos según una condición.
     *
     * @param map El mapeador del objeto.
     * @param condicionWhere La condición WHERE de la consulta SQL.
     * @return Una lista de objetos que cumplen con la condición.
     */
    public static List<Object> buscar(Mapeador map, String condicionWhere) {
        String sql = map.getSqlSeleccionar();
        if (condicionWhere != null) {
            sql += " WHERE " + condicionWhere;
        }

        ResultSet rs = instanciaPersistencia.base.consultar(sql);
        List<Object> lista = new ArrayList<>();

        try {
            while (rs.next()) {
                map.crearNuevo();
                map.leer(rs);
                lista.add(map.getObject());
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
            System.out.println("SQL: " + sql);
        }
        return lista;
    }

    /**
     * Obtiene todos los objetos de un tipo específico desde la base de datos.
     *
     * @param map El mapeador del objeto.
     * @return Una lista de todos los objetos.
     */
    public List<Object> obtenerTodos(Mapeador map) {
        return buscar(map, null);
    }
}

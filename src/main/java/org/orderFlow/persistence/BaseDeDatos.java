package org.orderFlow.persistence;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que gestiona la conexión y operaciones con la base de datos.
 */
@Repository
public class BaseDeDatos {

    private static BaseDeDatos instancia = new BaseDeDatos();
    private Connection conexion;
    private Statement statement;

    /**
     * Devuelve la instancia única de la clase.
     *
     * @return La instancia única de BaseDeDatos.
     */
    public static BaseDeDatos Instancia() {
        return instancia;
    }

    private BaseDeDatos() {}

    /**
     * Conecta a la base de datos utilizando los parámetros proporcionados.
     *
     * @param url La URL de la base de datos.
     * @param user El usuario de la base de datos.
     * @param password La contraseña del usuario.
     */
    public void conectar(String url, String user, String password) {
        try {
            // No es necesario registrar explícitamente el driver para PostgreSQL
            // DriverManager.registerDriver(new org.postgresql.Driver());
            conexion = DriverManager.getConnection(url, user, password);
            statement = conexion.createStatement();
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }

    /**
     * Desconecta de la base de datos.
     */
    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al desconectar: " + e.getMessage());
        }
    }

    /**
     * Ejecuta una actualización SQL.
     *
     * @param sql La consulta SQL de actualización.
     * @return El número de filas afectadas o -1 si hay un error.
     */
    public int actualizar(String sql) {
        try {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            System.out.println("SQL: " + sql);
            return -1;
        }
    }

    /**
     * Ejecuta una consulta SQL.
     *
     * @param sql La consulta SQL.
     * @return Un ResultSet con los resultados de la consulta o null si hay un error.
     */
    public ResultSet consultar(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
            System.out.println("SQL: " + sql);
            return null;
        }
    }
}


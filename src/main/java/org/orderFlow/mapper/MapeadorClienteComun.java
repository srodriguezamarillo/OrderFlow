package org.orderFlow.mapper;

import org.orderFlow.model.ClienteComun;
import org.orderFlow.model.SUsuarios;
import org.orderFlow.persistence.Mapeador;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que mapea un ClienteComun a la base de datos.
 */
public class MapeadorClienteComun implements Mapeador {

    private ClienteComun cliente;

    /**
     * Constructor que inicializa el mapeador con un cliente.
     *
     * @param cliente El cliente a mapear.
     */
    public MapeadorClienteComun(ClienteComun cliente) {
        this.cliente = cliente;
    }

    @Override
    public int getOid() {
        return cliente.getOid();
    }

    @Override
    public void setOid(int oid) {
        cliente.setOid(oid);
    }

    @Override
    public String getSqlInsertar() {
        return "INSERT INTO cliente (oid, id, nombre, email, tipo) VALUES ("
                + getOid() + ", " + cliente.getId() + ", '" + cliente.getNombre() + "', '" + cliente.getEmail() + "', '"
                + SUsuarios.TipoCliente.COMUN.toString() + "')";
    }

    @Override
    public String getSqlModificar() {
        return "UPDATE cliente SET nombre = '" + cliente.getNombre() +
                "', email = '" + cliente.getEmail() + "' WHERE oid = " + getOid();
    }

    @Override
    public String getSqlBorrar() {
        return "DELETE FROM cliente WHERE oid = " + getOid();
    }

    @Override
    public String getSqlRestaurar() {
        return "SELECT * FROM cliente WHERE oid = " + getOid();
    }

    @Override
    public String getSqlSeleccionar() {
        return "SELECT * FROM cliente";
    }

    @Override
    public void leer(ResultSet rs) throws SQLException {
        setOid(rs.getInt("oid"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setEmail(rs.getString("email"));
    }

    @Override
    public void crearNuevo() {
        cliente = new ClienteComun();
    }

    @Override
    public Object getObject() {
        return cliente;
    }
}

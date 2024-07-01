package org.orderFlow.mapper;

import org.orderFlow.model.Servicio;
import org.orderFlow.persistence.Mapeador;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que mapea un Servicio a la base de datos.
 */
public class MapeadorServicio implements Mapeador {

    private Servicio servicio;

    /**
     * Constructor que inicializa el mapeador con un servicio.
     *
     * @param servicio El servicio a mapear.
     */
    public MapeadorServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public int getOid() {
        return servicio.getOid();
    }

    @Override
    public void setOid(int oid) {
        servicio.setOid(oid);
    }

    @Override
    public String getSqlInsertar() {
        if (servicio.getCliente() != null) {
            return "INSERT INTO servicio (oid, total, oidCliente) VALUES "
                    + "(" + getOid() + ", " + servicio.getTotal() + ", " +
                    servicio.getCliente().getOid() + ")";
        } else {
            return "INSERT INTO servicio (oid, total) VALUES "
                    + "(" + getOid() + ", " + servicio.getTotal() + ")";
        }
    }

    @Override
    public String getSqlModificar() {
        return "UPDATE servicio SET total = " + servicio.getTotal() + ", "
                + "oidCliente = " + servicio.getCliente().getOid()
                + " WHERE oid = " + getOid();
    }

    @Override
    public String getSqlBorrar() {
        return "DELETE FROM servicio WHERE oid = " + getOid();
    }

    @Override
    public String getSqlRestaurar() {
        return "SELECT * FROM servicio WHERE oid = " + getOid();
    }

    @Override
    public String getSqlSeleccionar() {
        return "SELECT * FROM servicio";
    }

    @Override
    public void leer(ResultSet rs) throws SQLException {
        setOid(rs.getInt("oid"));
        servicio.setTotal(rs.getDouble("total"));
        servicio.getCliente().setOid(rs.getInt("oidCliente"));
    }

    @Override
    public void crearNuevo() {
        servicio = new Servicio();
    }

    @Override
    public Object getObject() {
        return servicio;
    }
}

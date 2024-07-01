package org.orderFlow.mapper;

import org.orderFlow.model.Producto;
import org.orderFlow.persistence.Mapeador;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que mapea un Producto a la base de datos.
 */
public class MapeadorProducto implements Mapeador {

    private Producto producto;

    /**
     * Constructor que inicializa el mapeador con un producto.
     *
     * @param producto El producto a mapear.
     */
    public MapeadorProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int getOid() {
        return producto.getOid();
    }

    @Override
    public void setOid(int oid) {
        producto.setOid(oid);
    }

    @Override
    public String getSqlInsertar() {
        return "INSERT INTO producto (oid, codigo, nombre, precio, stock, tipoUPP) VALUES ("
                + getOid() + ", '" + producto.getCodigo() + "', '" + producto.getNombre()
                + "', " + producto.getPrecio() + ", " + producto.getStock() + ", '"
                + producto.getTipoUnidadProcesadoraPedidos().toString() + "')";
    }

    @Override
    public String getSqlModificar() {
        return "UPDATE producto SET codigo = '" + producto.getCodigo() +
                "', nombre = '" + producto.getNombre() + "', precio = " + producto.getPrecio()
                + ", stock = " + producto.getStock() + ", tipoUPP = '"
                + producto.getTipoUnidadProcesadoraPedidos().toString() + "'"
                + " WHERE oid = " + getOid();
    }

    @Override
    public String getSqlBorrar() {
        return "DELETE FROM producto WHERE oid = " + getOid();
    }

    @Override
    public String getSqlRestaurar() {
        return "SELECT * FROM producto WHERE oid = " + getOid();
    }

    @Override
    public String getSqlSeleccionar() {
        return "SELECT * FROM producto";
    }

    @Override
    public void leer(ResultSet rs) throws SQLException {
        setOid(rs.getInt("oid"));
        producto.setCodigo(rs.getString("codigo"));
        producto.setNombre(rs.getString("nombre"));
        producto.setPrecio(rs.getDouble("precio"));
        producto.setStock(rs.getInt("stock"));
        producto.setUpp(rs.getString("tipoUPP"));
    }

    @Override
    public void crearNuevo() {
        producto = new Producto();
    }

    @Override
    public Object getObject() {
        return producto;
    }
}

package org.orderFlow.mapper;

import org.orderFlow.model.Facade;
import org.orderFlow.model.ItemPedido;
import org.orderFlow.persistence.Mapeador;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que mapea un ItemPedido a la base de datos.
 */
public class MapeadorItemPedido implements Mapeador {

    private ItemPedido itemPedido;
    private int oidServicio;

    /**
     * Constructor que inicializa el mapeador con un itemPedido y un oidServicio.
     *
     * @param itemPedido El itemPedido a mapear.
     * @param oid El identificador del servicio asociado.
     */
    public MapeadorItemPedido(ItemPedido itemPedido, int oid) {
        this.itemPedido = itemPedido;
        this.oidServicio = oid;
    }

    @Override
    public int getOid() {
        return itemPedido.getOid();
    }

    @Override
    public void setOid(int oid) {
        itemPedido.setOid(oid);
    }

    @Override
    public String getSqlInsertar() {
        return "INSERT INTO itempedido (oid, oidServicio, oidProducto, estado, cantidad, descripcion, gestor, mozo, mesa, total) VALUES "
                + "(" + getOid() + ", " + oidServicio + ", " + itemPedido.getProducto().getOid() + ", '"
                + itemPedido.getEstado().toString() + "', " + itemPedido.getCantidad() + ", '" + itemPedido.getDescripcion() + "', '"
                + itemPedido.getGestor().getUser() + "', '" + itemPedido.getMozo().getUser() + "', " + itemPedido.getMesa().getNumero() + ", "
                + itemPedido.getTotal() + ")";
    }

    @Override
    public String getSqlModificar() {
        return "UPDATE itempedido SET estado ='" + itemPedido.getEstado().toString() + "', "
                + "cantidad =" + itemPedido.getCantidad() + ", " + "descripcion ='" + itemPedido.getDescripcion() + "', "
                + "gestor ='" + itemPedido.getGestor().getUser() + "', " + "mozo ='" + itemPedido.getMozo().getUser() + "', "
                + "total =" + itemPedido.getTotal() + " WHERE oid=" + getOid();
    }

    @Override
    public String getSqlBorrar() {
        return "DELETE FROM itempedido WHERE oid=" + getOid();
    }

    @Override
    public String getSqlRestaurar() {
        return "SELECT * FROM itempedido WHERE oid=" + getOid();
    }

    @Override
    public String getSqlSeleccionar() {
        return "SELECT * FROM itempedido";
    }

    @Override
    public void leer(ResultSet rs) throws SQLException {
        setOid(rs.getInt("oid"));
        itemPedido.setProducto(Facade.Instancia().buscarProducto(rs.getInt("oidProducto")));
        itemPedido.setEstado(rs.getString("estado"));
        itemPedido.setCantidad(rs.getInt("cantidad"));
        itemPedido.setDescripcion(rs.getString("descripcion"));
        itemPedido.setGestor(rs.getString("gestor"));
        itemPedido.setMozo(rs.getString("mozo"));
        itemPedido.setMesa(rs.getInt("mesa"));
        itemPedido.setTotal(rs.getDouble("total"));
    }

    @Override
    public void crearNuevo() {
        itemPedido = new ItemPedido();
    }

    @Override
    public Object getObject() {
        return itemPedido;
    }
}

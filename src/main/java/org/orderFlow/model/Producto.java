package org.orderFlow.model;

import javax.persistence.*;
import org.orderFlow.mapper.MapeadorProducto;
import org.orderFlow.persistence.Persistencia;
import org.orderFlow.model.UPP.TipoUnidadProcesadoraPedidos;

/**
 * Clase que representa un producto en el restaurante.
 */
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private int stock;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUnidadProcesadoraPedidos tipoUnidadProcesadoraPedidos;

    /**
     * Constructor que inicializa un nuevo producto con los detalles proporcionados.
     *
     * @param codigo El código del producto.
     * @param nombre El nombre del producto.
     * @param precio El precio del producto.
     * @param stock La cantidad en stock del producto.
     * @param tipoUP El tipo de unidad procesadora de pedidos del producto.
     */
    public Producto(String codigo, String nombre, double precio, int stock, TipoUnidadProcesadoraPedidos tipoUP) {
        setCodigo(codigo);
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
        setUnidadProcesadoraPedidos(tipoUP);
        Facade.Instancia().getSmesas().getProductos().add(this);
        MapeadorProducto map = new MapeadorProducto(this);
        Persistencia persistencia = Persistencia.Instancia();
        persistencia.guardar(map);
    }

    /**
     * Constructor por defecto.
     */
    public Producto() {}

    /**
     * Devuelve el OID del producto.
     *
     * @return El OID del producto.
     */
    public int getOid() {
        return oid;
    }

    /**
     * Establece el OID del producto.
     *
     * @param oid El OID a establecer.
     */
    public void setOid(int oid) {
        this.oid = oid;
    }

    /**
     * Devuelve el código del producto.
     *
     * @return El código del producto.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del producto.
     *
     * @param codigo El código a establecer.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el precio del producto.
     *
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio El precio a establecer.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve la cantidad en stock del producto.
     *
     * @return La cantidad en stock del producto.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece la cantidad en stock del producto.
     *
     * @param stock La cantidad en stock a establecer.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Devuelve el tipo de unidad procesadora de pedidos del producto.
     *
     * @return El tipo de unidad procesadora de pedidos.
     */
    public TipoUnidadProcesadoraPedidos getTipoUnidadProcesadoraPedidos() {
        return tipoUnidadProcesadoraPedidos;
    }

    /**
     * Establece el tipo de unidad procesadora de pedidos del producto.
     *
     * @param tipoUnidadProcesadoraPedidos El tipo de unidad procesadora de pedidos a establecer.
     */
    public void setUnidadProcesadoraPedidos(TipoUnidadProcesadoraPedidos tipoUnidadProcesadoraPedidos) {
        this.tipoUnidadProcesadoraPedidos = tipoUnidadProcesadoraPedidos;
    }

    /**
     * Devuelve una representación en cadena del producto.
     *
     * @return Una cadena con el nombre y la cantidad en stock del producto.
     */
    @Override
    public String toString() {
        return getNombre() + " - " + getStock();
    }

    /**
     * Establece el tipo de unidad procesadora de pedidos usando una cadena.
     *
     * @param string El tipo de unidad procesadora de pedidos a establecer como cadena.
     */
    public void setUpp(String string) {
        if (string.equals(UPP.TipoUnidadProcesadoraPedidos.BAR.toString())) {
            tipoUnidadProcesadoraPedidos = UPP.TipoUnidadProcesadoraPedidos.BAR;
        } else if (string.equals(UPP.TipoUnidadProcesadoraPedidos.COCINA.toString())) {
            tipoUnidadProcesadoraPedidos = UPP.TipoUnidadProcesadoraPedidos.COCINA;
        } else {
            tipoUnidadProcesadoraPedidos = UPP.TipoUnidadProcesadoraPedidos.POSTRE;
        }
    }
}

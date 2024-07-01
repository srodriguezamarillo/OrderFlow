package org.orderFlow.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase que representa un ítem de pedido.
 */
@Entity
@Table(name = "items_pedido")
public class ItemPedido implements Serializable {

    public enum Estado { PROCESO, FINALIZADO, PENDIENTE }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private int cantidad;

    @Column
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "gestor_id")
    private Usuario gestor;

    @Column(nullable = false)
    private double total;

    @ManyToOne
    @JoinColumn(name = "mozo_id", nullable = false)
    private Usuario mozo;

    @ManyToOne
    @JoinColumn(name = "mesa_id", nullable = false)
    private Mesa mesa;

    /**
     * Constructor que inicializa un nuevo ítem de pedido.
     *
     * @param servicio El servicio al que pertenece el ítem de pedido.
     * @param producto El producto del ítem de pedido.
     * @param cantidad La cantidad del producto.
     * @param descripcion La descripción del ítem de pedido.
     * @param mozo El mozo que realiza el pedido.
     * @param mesa La mesa a la que se asigna el pedido.
     */
    public ItemPedido(Servicio servicio, Producto producto, int cantidad, String descripcion, Usuario mozo, Mesa mesa) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.estado = Estado.PENDIENTE;
        this.gestor = null;
        calcularTotal();
        this.mozo = mozo;
        this.mesa = mesa;
        servicio.agregarItem(this);
        servicio.calcularTotal();
        servicio.notificar();
    }

    /**
     * Constructor por defecto.
     */
    public ItemPedido() {}

    /**
     * Devuelve el OID del ítem de pedido.
     *
     * @return El OID del ítem de pedido.
     */
    public int getOid() {
        return oid;
    }

    /**
     * Establece el OID del ítem de pedido.
     *
     * @param oid El OID a establecer.
     */
    public void setOid(int oid) {
        this.oid = oid;
    }

    /**
     * Devuelve el producto del ítem de pedido.
     *
     * @return El producto del ítem de pedido.
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el producto del ítem de pedido.
     *
     * @param producto El producto a establecer.
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Devuelve la cantidad del ítem de pedido.
     *
     * @return La cantidad del ítem de pedido.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del ítem de pedido.
     *
     * @param cantidad La cantidad a establecer.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Devuelve la descripción del ítem de pedido.
     *
     * @return La descripción del ítem de pedido.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del ítem de pedido.
     *
     * @param descripcion La descripción a establecer.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el estado del ítem de pedido.
     *
     * @return El estado del ítem de pedido.
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Establece el estado del ítem de pedido.
     *
     * @param estado El estado a establecer.
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Establece el estado del ítem de pedido usando una cadena.
     *
     * @param estado El estado a establecer como cadena.
     */
    public void setEstado(String estado) {
        if (estado.equals(Estado.FINALIZADO.toString())) {
            this.estado = Estado.FINALIZADO;
        } else if (estado.equals(Estado.PENDIENTE.toString())) {
            this.estado = Estado.PENDIENTE;
        } else {
            this.estado = Estado.PROCESO;
        }
    }

    /**
     * Devuelve el gestor del ítem de pedido.
     *
     * @return El gestor del ítem de pedido.
     */
    public Usuario getGestor() {
        return gestor;
    }

    /**
     * Establece el gestor del ítem de pedido.
     *
     * @param gestor El gestor a establecer.
     */
    public void setGestor(Usuario gestor) {
        this.gestor = gestor;
    }

    /**
     * Establece el gestor del ítem de pedido usando una cadena.
     *
     * @param gestor El gestor a establecer como cadena.
     */
    public void setGestor(String gestor) {
        this.gestor = Facade.Instancia().buscarUsuario(gestor);
    }

    /**
     * Devuelve el mozo del ítem de pedido.
     *
     * @return El mozo del ítem de pedido.
     */
    public Usuario getMozo() {
        return mozo;
    }

    /**
     * Establece el mozo del ítem de pedido.
     *
     * @param mozo El mozo a establecer.
     */
    public void setMozo(Usuario mozo) {
        this.mozo = mozo;
    }

    /**
     * Establece el mozo del ítem de pedido usando una cadena.
     *
     * @param mozo El mozo a establecer como cadena.
     */
    public void setMozo(String mozo) {
        this.mozo = Facade.Instancia().buscarUsuario(mozo);
    }

    /**
     * Devuelve la mesa del ítem de pedido.
     *
     * @return La mesa del ítem de pedido.
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * Establece la mesa del ítem de pedido.
     *
     * @param mesa La mesa a establecer.
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    /**
     * Establece la mesa del ítem de pedido usando un número.
     *
     * @param numero El número de la mesa.
     */
    public void setMesa(int numero) {
        this.mesa = Facade.Instancia().buscarMesa(numero);
    }

    /**
     * Devuelve el total del ítem de pedido.
     *
     * @return El total del ítem de pedido.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Establece el total del ítem de pedido.
     *
     * @param total El total a establecer.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Calcula el total del ítem de pedido.
     */
    public void calcularTotal() {
        double resultado = this.producto.getPrecio() * this.cantidad;
        setTotal(resultado);
    }

    @Override
    public String toString() {
        return producto.getNombre();
    }
}

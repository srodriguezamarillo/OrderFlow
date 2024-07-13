package org.orderFlow.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Clase que representa un servicio en el restaurante.
 */
@Entity
@Table(name = "servicios")
public class Servicio extends Observable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;

    @Column(nullable = false)
    private double total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "servicio_id")
    private List<ItemPedido> items = new ArrayList<>();

    @Transient
    private List<Observer> observadores = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ICliente cliente;

    /**
     * Constructor que inicializa un nuevo servicio.
     */
    public Servicio() {
        setTotal(0.0);
        cliente = null;
    }

    /**
     * Devuelve el OID del servicio.
     *
     * @return El OID del servicio.
     */
    public int getOid() {
        return oid;
    }

    /**
     * Establece el OID del servicio.
     *
     * @param oid El OID a establecer.
     */
    public void setOid(int oid) {
        this.oid = oid;
    }

    /**
     * Devuelve la lista de ítems del servicio.
     *
     * @return La lista de ítems del servicio.
     */
    public List<ItemPedido> getItems() {
        return this.items;
    }

    /**
     * Devuelve el total del servicio.
     *
     * @return El total del servicio.
     */
    public double getTotal() {
        return this.total;
    }

    /**
     * Establece el total del servicio.
     *
     * @param total El total a establecer.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Devuelve el cliente asociado al servicio.
     *
     * @return El cliente asociado al servicio.
     */
    public ICliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado al servicio.
     *
     * @param cliente El cliente a establecer.
     */
    public void setCliente(ICliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Calcula el total del servicio.
     */
    public void calcularTotal() {
        double resultado = 0.0;

        if (this.cliente == null) {
            for (ItemPedido i : items) {
                i.calcularTotal();
                resultado += i.getTotal();
            }
        } else {
            resultado = cliente.calcularTotal((ArrayList<ItemPedido>) items);
        }
        setTotal(resultado);
    }

    /**
     * Agrega un ítem al servicio.
     *
     * @param item El ítem a agregar.
     */
    public void agregarItem(ItemPedido item) {
        items.add(item);
    }

    /**
     * Agrega un observador al servicio.
     *
     * @param o El observador a agregar.
     */
    public void agregarObserver(Observer o) {
        observadores.add(o);
    }

    /**
     * Notifica a todos los observadores.
     */
    public void notificar() {
        Facade.Instancia().notificar();
    }

    /**
     * Verifica si el servicio tiene ítems pendientes.
     *
     * @return true si hay ítems pendientes, false en caso contrario.
     */
    public boolean itemsPendientes() {
        for (ItemPedido item : items) {
            if (!item.getEstado().equals(ItemPedido.Estado.FINALIZADO)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca un ítem por su código de producto.
     *
     * @param codigo El código del producto.
     * @return El ítem encontrado o null si no se encuentra.
     */
    public ItemPedido buscarItem(String codigo) {
        for (ItemPedido item : items) {
            if (item.getProducto().getCodigo().equals(codigo)) {
                return item;
            }
        }
        return null;
    }
}

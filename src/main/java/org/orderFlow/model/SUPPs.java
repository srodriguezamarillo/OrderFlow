package org.orderFlow.model;

import org.orderFlow.model.UPP.TipoUnidadProcesadoraPedidos;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Clase que gestiona las unidades procesadoras de pedidos (UPPs).
 */
public class SUPPs extends Observable {

    private List<UPP> unidadesProcesadoraPedidos;
    private List<Observer> observadores = new ArrayList<>();

    /**
     * Constructor que inicializa las unidades procesadoras de pedidos.
     */
    public SUPPs() {
        unidadesProcesadoraPedidos = new ArrayList<>();
        for (TipoUnidadProcesadoraPedidos tipo : UPP.getEnumerado()) {
            unidadesProcesadoraPedidos.add(new UPP(tipo));
        }
    }

    /**
     * Devuelve la lista de unidades procesadoras de pedidos.
     *
     * @return La lista de unidades procesadoras de pedidos.
     */
    public List<UPP> getUnidadesProcesadoraPedidos() {
        return unidadesProcesadoraPedidos;
    }

    /**
     * Agrega una nueva unidad procesadora de pedidos.
     *
     * @param upp La unidad procesadora de pedidos a agregar.
     */
    public void agregarUnidadProcesadora(UPP upp) {
        getUnidadesProcesadoraPedidos().add(upp);
    }

    /**
     * Agrega un observador.
     *
     * @param o El observador a agregar.
     */
    public void agregarObserver(Observer o) {
        observadores.add(o);
    }

    /**
     * Agrega un ítem de pedido a una mesa y lo asigna a la unidad procesadora correspondiente.
     *
     * @param mesa La mesa.
     * @param producto El producto del pedido.
     * @param cantidad La cantidad del producto.
     * @param comentario Comentarios adicionales.
     * @param mozo El mozo que realiza el pedido.
     */
    public void agregarItemPedido(Mesa mesa, Producto producto, int cantidad, String comentario, Usuario mozo) {
        ItemPedido item = new ItemPedido(mesa.getServicio(), producto, cantidad, comentario, mozo, mesa);
        for (UPP u : unidadesProcesadoraPedidos) {
            if (u.getTipo().equals(item.getProducto().getTipoUnidadProcesadoraPedidos())) {
                u.agregarPedido(item);
            }
        }
        notificar();
    }

    /**
     * Busca una unidad procesadora de pedidos por su tipo.
     *
     * @param tipo El tipo de la unidad procesadora de pedidos.
     * @return La unidad procesadora de pedidos encontrada o null si no se encuentra.
     */
    public UPP buscarUPP(TipoUnidadProcesadoraPedidos tipo) {
        for (UPP up : unidadesProcesadoraPedidos) {
            if (up.getTipo().equals(tipo)) {
                return up;
            }
        }
        return null;
    }

    /**
     * Devuelve la lista de tipos de unidades procesadoras de pedidos.
     *
     * @return La lista de tipos de unidades procesadoras de pedidos.
     */
    public List<TipoUnidadProcesadoraPedidos> listadoTipoUnidad() {
        return UPP.getEnumerado();
    }

    /**
     * Notifica a todos los observadores.
     */
    public void notificar() {
        Facade.Instancia().notificar();
    }

    /**
     * Toma un pedido y lo asigna a un gestor y una unidad procesadora de pedidos.
     *
     * @param pedido El pedido a tomar.
     * @param gestor El gestor que toma el pedido.
     * @param upp La unidad procesadora de pedidos.
     * @return true si el pedido se tomó con éxito, false en caso contrario.
     */
    public boolean tomarPedido(ItemPedido pedido, Usuario gestor, UPP upp) {
        if (pedido.getEstado().equals(ItemPedido.Estado.PENDIENTE)) {
            pedido.setEstado(ItemPedido.Estado.PROCESO);
            pedido.setGestor(gestor);
            notificar();
            Facade.Instancia().notificar();
            return true;
        }
        return false;
    }

    /**
     * Finaliza un pedido.
     *
     * @param pedido El pedido a finalizar.
     * @return true si el pedido se finalizó con éxito, false en caso contrario.
     */
    public boolean finalizarPedido(ItemPedido pedido) {
        if (pedido.getEstado().equals(ItemPedido.Estado.PROCESO)) {
            pedido.setEstado(ItemPedido.Estado.FINALIZADO);
            notificar();
            Facade.Instancia().notificar();
            Facade.Instancia().notificarPedidoFinalizado(pedido);
            return true;
        }
        return false;
    }

    /**
     * Devuelve la lista de pedidos tomados por un gestor en una unidad procesadora de pedidos.
     *
     * @param gestor El gestor.
     * @param upp La unidad procesadora de pedidos.
     * @return La lista de pedidos tomados por el gestor en la unidad procesadora de pedidos.
     */
    public List<ItemPedido> pedidosTomados(Usuario gestor, UPP upp) {
        List<ItemPedido> lista = new ArrayList<>();
        for (ItemPedido pedido : upp.getPedidos()) {
            if (pedido.getEstado().equals(ItemPedido.Estado.PROCESO) && pedido.getGestor() == gestor) {
                lista.add(pedido);
            }
        }
        return lista;
    }
}

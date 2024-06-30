package org.orderFlow.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una Unidad Procesadora de Pedidos (UPP).
 */
@Component
public class UPP {

    public enum TipoUnidadProcesadoraPedidos {BAR, COCINA, POSTRE}

    private TipoUnidadProcesadoraPedidos tipo;
    private List<ItemPedido> pedidos = new ArrayList<>();
    private List<Usuario> gestores = new ArrayList<>();

    /**
     * Constructor que inicializa una UPP con un tipo específico.
     *
     * @param tipo El tipo de unidad procesadora de pedidos.
     */
    public UPP(TipoUnidadProcesadoraPedidos tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve el tipo de la UPP.
     *
     * @return El tipo de la UPP.
     */
    public TipoUnidadProcesadoraPedidos getTipo() {
        return tipo;
    }

    /**
     * Devuelve la lista de pedidos asignados a la UPP.
     *
     * @return La lista de pedidos.
     */
    public List<ItemPedido> getPedidos() {
        return pedidos;
    }

    /**
     * Devuelve la lista de gestores asignados a la UPP.
     *
     * @return La lista de gestores.
     */
    public List<Usuario> getGestores() {
        return gestores;
    }

    /**
     * Establece la lista de gestores asignados a la UPP.
     *
     * @param gestores La lista de gestores.
     */
    public void setGestores(List<Usuario> gestores) {
        this.gestores = gestores;
    }

    /**
     * Devuelve la lista de pedidos pendientes en la UPP.
     *
     * @return La lista de pedidos pendientes.
     */
    public List<ItemPedido> getPedidosPendientes() {
        List<ItemPedido> listaPedidos = new ArrayList<>();
        for (ItemPedido pedido : pedidos) {
            if (pedido.getEstado().equals(ItemPedido.Estado.PENDIENTE)) {
                listaPedidos.add(pedido);
            }
        }
        return listaPedidos;
    }

    /**
     * Devuelve una lista de todos los tipos de UPP disponibles.
     *
     * @return La lista de tipos de UPP.
     */
    public static List<TipoUnidadProcesadoraPedidos> getEnumerado() {
        List<TipoUnidadProcesadoraPedidos> listaTiposUP = new ArrayList<>();
        for (TipoUnidadProcesadoraPedidos tipoUP : TipoUnidadProcesadoraPedidos.values()) {
            listaTiposUP.add(tipoUP);
        }
        return listaTiposUP;
    }

    /**
     * Agrega un pedido a la UPP.
     *
     * @param iP El pedido a agregar.
     */
    public void agregarPedido(ItemPedido iP) {
        this.pedidos.add(iP);
    }

    /**
     * Devuelve la lista de pedidos en proceso asignados a un gestor específico.
     *
     * @param gestor El gestor.
     * @return La lista de pedidos en proceso asignados al gestor.
     */
    public List<ItemPedido> getPedidosGestor(Usuario gestor) {
        List<ItemPedido> lista = new ArrayList<>();
        for (ItemPedido pedido : getPedidos()) {
            if (pedido.getEstado().equals(ItemPedido.Estado.PROCESO) && pedido.getGestor() == gestor) {
                lista.add(pedido);
            }
        }
        return lista;
    }

    /**
     * Verifica si hay pedidos pendientes o en proceso asignados a un gestor específico.
     *
     * @param gestor El gestor.
     * @return true si hay pedidos pendientes o en proceso, false en caso contrario.
     */
    public boolean pedidosPendientes(Usuario gestor) {
        return pedidos.stream().anyMatch(p ->
                (p.getEstado().equals(ItemPedido.Estado.PROCESO) || p.getEstado().equals(ItemPedido.Estado.PENDIENTE)) && p.getGestor() == gestor);
    }
}

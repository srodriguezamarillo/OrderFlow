package org.orderFlow.interfaces;

import org.orderFlow.model.ItemPedido;

/**
 * Interfaz para la vista de gestión de pedidos.
 * Define los métodos que deben ser implementados por la vista.
 */
public interface IVistaGestorPedidos {

    /**
     * Carga los pedidos en la vista.
     */
    void cargarPedidos();

    /**
     * Muestra los pedidos tomados en la vista.
     */
    void mostrarPedidosTomados();

    /**
     * Muestra un mensaje en la vista.
     *
     * @param mensaje El mensaje a mostrar.
     */
    void mostrarMensaje(String mensaje);

    /**
     * Toma un pedido.
     *
     * @param item El ítem del pedido.
     */
    void tomarPedido(ItemPedido item);

    /**
     * Finaliza un pedido.
     *
     * @param item El ítem del pedido.
     */
    void finalizarPedido(ItemPedido item);
}

package org.orderFlow.interfaces;

import org.orderFlow.model.ItemPedido;
import org.orderFlow.model.Mesa;
import org.orderFlow.model.Usuario;

/**
 * Interfaz para la vista de gestión de mesas.
 * Define los métodos que deben ser implementados por la vista.
 */
public interface IVistaMesas {

    /**
     * Método para seleccionar una mesa.
     */
    void seleccionarMesa();

    /**
     * Método para abrir una mesa.
     */
    void abrirMesa();

    /**
     * Método para cerrar una mesa.
     */
    void cerrarMesa();

    /**
     * Método para iniciar un servicio en una mesa.
     */
    void servicio();

    /**
     * Método para solicitar la transferencia de una mesa.
     */
    void askTransferir();

    /**
     * Método para responder a una solicitud de transferencia de mesa.
     *
     * @param respuesta La respuesta a la solicitud (aceptar o rechazar).
     */
    void transferir(int respuesta);

    /**
     * Muestra un mensaje en la vista.
     *
     * @param mensaje El mensaje a mostrar.
     */
    void mostrarMensaje(String mensaje);

    /**
     * Actualiza los datos en la vista.
     */
    void actualizarDatos();

    /**
     * Método para registrar un cliente.
     */
    void registrarCliente();

    /**
     * Método para salir de la vista.
     */
    void salir();

    /**
     * Devuelve el mozo actualmente logueado.
     *
     * @return El usuario del mozo.
     */
    Usuario getMozo();

    /**
     * Notifica una transferencia de mesa.
     *
     * @param mozoOrigen El mozo que transfiere la mesa.
     * @param mesa La mesa que se transfiere.
     */
    void notificarTransferencia(Usuario mozoOrigen, Mesa mesa);

    /**
     * Notifica un nuevo pedido.
     *
     * @param item El ítem del pedido.
     */
    void notificarPedido(ItemPedido item);
}


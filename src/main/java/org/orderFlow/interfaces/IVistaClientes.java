package org.orderFlow.interfaces;

/**
 * Interfaz para la vista de gestión de clientes.
 * Define los métodos que deben ser implementados por la vista.
 */
public interface IVistaClientes {

    /**
     * Método para registrar un cliente.
     */
    void registrar();

    /**
     * Muestra un mensaje en la vista.
     *
     * @param mensaje El mensaje a mostrar.
     */
    void mostrarMensaje(String mensaje);
}

package org.orderFlow.interfaces;

/**
 * Interfaz para la vista de servicios.
 * Define los métodos que deben ser implementados por la vista.
 */
public interface IVistaServicio {

    /**
     * Agrega un ítem al servicio.
     */
    void agregarItem();

    /**
     * Carga los datos en la vista.
     */
    void cargarDatos();

    /**
     * Muestra un mensaje en la vista.
     *
     * @param mensaje El mensaje a mostrar.
     */
    void mostrarMensaje(String mensaje);
}

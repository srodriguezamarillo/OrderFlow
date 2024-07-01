package org.orderFlow.interfaces;

import org.orderFlow.model.Usuario;

/**
 * Interfaz para la vista de login.
 * Define los métodos que deben ser implementados por la vista.
 */
public interface IVistaLogin {

    /**
     * Método para realizar el login.
     */
    void login();

    /**
     * Permite el ingreso del usuario a la vista principal.
     *
     * @param u El usuario que ha iniciado sesión.
     */
    void ingresar(Usuario u);

    /**
     * Muestra un mensaje en la vista.
     *
     * @param mensaje El mensaje a mostrar.
     */
    void mostrarMensaje(String mensaje);
}

package org.orderFlow.controller;

import org.orderFlow.model.Facade;
import org.orderFlow.model.Usuario;
import org.orderFlow.model.Constantes;
import org.orderFlow.interfaces.IVistaLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Controlador para la gestión de usuarios.
 * Implementa la lógica para el inicio de sesión de usuarios.
 */
@Controller
public class ControladorUsuarios {

    private IVistaLogin vista;

    /**
     * Constructor que inicializa el controlador con la vista correspondiente.
     *
     * @param vista La interfaz de la vista de login.
     */
    @Autowired
    public ControladorUsuarios(IVistaLogin vista) {
        this.vista = vista;
    }

    /**
     * Maneja el proceso de inicio de sesión de un usuario.
     *
     * @param username El nombre de usuario.
     * @param pass La contraseña del usuario.
     */
    public void login(String username, String pass) {
        String msg = Facade.Instancia().login(username, pass);
        if (msg.equals(Constantes.Msg_User_Correcto)) {
            Usuario user = Facade.Instancia().buscarUsuario(username);
            vista.ingresar(user);
        } else {
            vista.mostrarMensaje(msg);
        }
    }
}

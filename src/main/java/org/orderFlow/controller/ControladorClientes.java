package org.orderFlow.controller;

import org.orderFlow.model.Constantes;
import org.orderFlow.model.Facade;
import org.orderFlow.interfaces.IVistaClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Controlador para la gestión de clientes.
 * Se comunica con la vista y la fachada para registrar nuevos clientes.
 */
@Controller
public class ControladorClientes {

    private IVistaClientes vista;

    /**
     * Constructor que inicializa el controlador con la vista correspondiente.
     *
     * @param vista La interfaz de la vista de clientes.
     */
    @Autowired
    public ControladorClientes(IVistaClientes vista) {
        this.vista = vista;
    }

    /**
     * Método para registrar un nuevo cliente.
     *
     * @param nombre Nombre del cliente.
     * @param email Correo electrónico del cliente.
     * @param tipo Tipo de cliente (Común, Preferencial, De la Casa).
     */
    public void registrar(String nombre, String email, String tipo) {
        boolean registrado = Facade.Instancia().registrarCliente(nombre, email, tipo);
        if (registrado) {
            vista.mostrarMensaje(Constantes.Msg_Cliente_Registrado);
        } else {
            vista.mostrarMensaje(Constantes.Msg_Cliente_No_Registrado);
        }
    }
}

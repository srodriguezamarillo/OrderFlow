package org.orderFlow.controller;

import org.orderFlow.interfaces.IVistaClientes;
import org.orderFlow.mapper.MapeadorClienteComun;
import org.orderFlow.mapper.MapeadorClienteDeLaCasa;
import org.orderFlow.mapper.MapeadorClientePreferencial;
import org.orderFlow.model.ClienteComun;
import org.orderFlow.model.ClienteDeLaCasa;
import org.orderFlow.model.ClientePreferencial;
import org.orderFlow.model.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Controlador para la gestión de clientes.
 * Se comunica con la vista y los mapeadores para registrar nuevos clientes.
 */
@Controller
public class ControladorClientes {

    private IVistaClientes vista;

    @Autowired
    private MapeadorClienteComun mapeadorClienteComun;

    @Autowired
    private MapeadorClienteDeLaCasa mapeadorClienteDeLaCasa;

    @Autowired
    private MapeadorClientePreferencial mapeadorClientePreferencial;

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
        boolean registrado = false;
        switch (tipo.toUpperCase()) {
            case "COMUN":
                ClienteComun clienteComun = new ClienteComun(nombre, email);
                mapeadorClienteComun.save(clienteComun);
                registrado = true;
                break;
            case "DELACASA":
                ClienteDeLaCasa clienteDeLaCasa = new ClienteDeLaCasa(nombre, email);
                mapeadorClienteDeLaCasa.save(clienteDeLaCasa);
                registrado = true;
                break;
            case "PREFERENCIAL":
                ClientePreferencial clientePreferencial = new ClientePreferencial(nombre, email);
                mapeadorClientePreferencial.save(clientePreferencial);
                registrado = true;
                break;
            default:
                registrado = false;
                break;
        }
        if (registrado) {
            vista.mostrarMensaje(Constantes.Msg_Cliente_Registrado);
        } else {
            vista.mostrarMensaje(Constantes.Msg_Cliente_No_Registrado);
        }
    }
}

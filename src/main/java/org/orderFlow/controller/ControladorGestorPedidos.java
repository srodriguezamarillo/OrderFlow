package org.orderFlow.controller;

import org.orderFlow.model.Facade;
import org.orderFlow.model.Usuario;
import org.orderFlow.model.ItemPedido;
import org.orderFlow.model.UPP;
import org.orderFlow.interfaces.IVistaGestorPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Observable;
import java.util.Observer;

/**
 * Controlador para la gestión de pedidos.
 * Implementa la lógica para tomar y finalizar pedidos, así como la gestión de observers.
 */
@Controller
public class ControladorGestorPedidos implements Observer {

    private IVistaGestorPedidos vista;

    /**
     * Constructor que inicializa el controlador con la vista correspondiente.
     * Agrega el controlador como observer.
     *
     * @param vista La interfaz de la vista del gestor de pedidos.
     */
    @Autowired
    public ControladorGestorPedidos(IVistaGestorPedidos vista) {
        this.vista = vista;
        agregarObserver(this);
    }

    /**
     * Método para tomar un pedido.
     *
     * @param item El ítem del pedido.
     * @param gestor El usuario que gestiona el pedido.
     * @param upp La unidad procesadora de pedidos.
     */
    public void tomarPedido(ItemPedido item, Usuario gestor, UPP upp) {
        Facade.Instancia().tomarPedido(item, gestor, upp);
    }

    /**
     * Método para finalizar un pedido.
     *
     * @param item El ítem del pedido.
     */
    public void finalizarPedido(ItemPedido item) {
        Facade.Instancia().finalizarPedido(item);
    }

    /**
     * Método para agregar un observer.
     *
     * @param o El observer a agregar.
     */
    public void agregarObserver(Observer o) {
        Facade.Instancia().agregarObserver(o);
    }

    /**
     * Método para cerrar sesión.
     *
     * @param user El nombre de usuario.
     * @return Mensaje de logout.
     */
    public String logout(String user) {
        return Facade.Instancia().logout(user);
    }

    /**
     * Método que se llama cuando el observable notifica a los observers.
     * Actualiza la vista con los pedidos tomados y cargados.
     *
     * @param o El observable.
     * @param arg Argumento pasado por el observable.
     */
    @Override
    public void update(Observable o, Object arg) {
        vista.cargarPedidos();
        vista.mostrarPedidosTomados();
    }
}

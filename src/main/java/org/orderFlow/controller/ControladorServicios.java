package org.orderFlow.controller;

import org.orderFlow.model.Facade;
import org.orderFlow.model.Mesa;
import org.orderFlow.model.Producto;
import org.orderFlow.model.Usuario;
import org.orderFlow.interfaces.IVistaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Controlador para la gestión de servicios.
 * Implementa la lógica para agregar ítems a servicios, buscar productos, y gestionar observers.
 */
@Controller
public class ControladorServicios implements Observer {

    private IVistaServicio vista;

    /**
     * Constructor que inicializa el controlador con la vista correspondiente.
     * Agrega el controlador como observer.
     *
     * @param vista La interfaz de la vista de servicios.
     */
    @Autowired
    public ControladorServicios(IVistaServicio vista) {
        this.vista = vista;
        agregarObservador(this);
    }

    /**
     * Agrega un ítem a un servicio.
     *
     * @param mesa La mesa a la que se agregará el ítem.
     * @param producto El producto a agregar.
     * @param cantidad La cantidad del producto.
     * @param comentario Comentarios adicionales.
     * @param mozo El mozo que agrega el ítem.
     */
    public void agregarItem(Mesa mesa, Producto producto, int cantidad, String comentario, Usuario mozo) {
        Facade.Instancia().agregarItemServicio(mesa, producto, cantidad, comentario, mozo);
    }

    /**
     * Busca y devuelve una lista de productos.
     *
     * @return Lista de productos.
     */
    public ArrayList<Producto> buscarProductos() {
        return Facade.Instancia().listaProductos();
    }

    /**
     * Busca un producto por su código.
     *
     * @param codigo El código del producto.
     * @return El producto encontrado.
     */
    public Producto buscarProducto(String codigo) {
        return Facade.Instancia().buscarProducto(codigo);
    }

    /**
     * Agrega un observador.
     *
     * @param o El observador a agregar.
     */
    public void agregarObservador(Observer o) {
        Facade.Instancia().agregarObserver(o);
    }

    /**
     * Método que se llama cuando el observable notifica a los observers.
     * Actualiza la vista con los datos más recientes.
     *
     * @param o El observable.
     * @param arg Argumento pasado por el observable.
     */
    @Override
    public void update(Observable o, Object arg) {
        vista.cargarDatos();
    }
}

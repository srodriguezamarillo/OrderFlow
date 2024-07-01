package org.orderFlow.controller;

import org.orderFlow.model.Facade;
import org.orderFlow.model.ICliente;
import org.orderFlow.model.Mesa;
import org.orderFlow.model.Usuario;
import org.orderFlow.interfaces.IVistaMesas;
import org.orderFlow.interfaces.IVistaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Controlador para la gestión de mesas.
 * Implementa la lógica para abrir, cerrar, y transferir mesas, así como la gestión de observers.
 */
@Controller
public class ControladorMesas implements Observer {

    private IVistaMesas vista;
    private IVistaServicio vistaServicio;

    /**
     * Constructor que inicializa el controlador con la vista correspondiente.
     * Agrega el controlador como observer.
     *
     * @param vista La interfaz de la vista de mesas.
     */
    @Autowired
    public ControladorMesas(IVistaMesas vista) {
        this.vista = vista;
        agregarObservador(this);
    }

    /**
     * Devuelve la vista de mesas.
     *
     * @return La vista de mesas.
     */
    public IVistaMesas getVista() {
        return this.vista;
    }

    /**
     * Abre una nueva mesa.
     *
     * @param mesa La mesa a abrir.
     * @return true si la mesa se abrió con éxito, false en caso contrario.
     */
    public boolean abrirMesa(Mesa mesa) {
        return Facade.Instancia().abrirMesa(mesa);
    }

    /**
     * Cierra una mesa existente.
     *
     * @param mesa La mesa a cerrar.
     * @return true si la mesa se cerró con éxito, false en caso contrario.
     */
    public boolean cerrarMesa(Mesa mesa) {
        return Facade.Instancia().cerrarMesa(mesa);
    }

    /**
     * Cierra la sesión de un usuario.
     *
     * @param user El nombre de usuario.
     * @return Mensaje de logout.
     */
    public String logout(String user) {
        return Facade.Instancia().logout(user);
    }

    /**
     * Busca una mesa por su número.
     *
     * @param numero El número de la mesa.
     * @return La mesa encontrada.
     */
    public Mesa buscarMesa(int numero) {
        return Facade.Instancia().buscarMesa(numero);
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
     * Notifica cambios en las mesas.
     */
    public void notificarMesas() {
        Facade.Instancia().notificarMesas();
    }

    /**
     * Devuelve una lista de todas las mesas.
     *
     * @return Lista de mesas.
     */
    public ArrayList<Mesa> buscarMesas() {
        return Facade.Instancia().listaMesas();
    }

    /**
     * Devuelve una lista de las mesas gestionadas por un mozo.
     *
     * @param user El nombre del mozo.
     * @return Lista de mesas gestionadas por el mozo.
     */
    public ArrayList<Mesa> buscarMesasMozo(String user) {
        return Facade.Instancia().listaMesasMozo(user);
    }

    /**
     * Solicita la transferencia de una mesa a otro mozo.
     *
     * @param mesa La mesa a transferir.
     * @param mozoOrigen El mozo que transfiere la mesa.
     * @param mozoDestino El mozo que recibe la mesa.
     */
    public void askTransferir(Mesa mesa, Usuario mozoOrigen, Usuario mozoDestino) {
        Facade.Instancia().askTransferirMesa(mesa, mozoOrigen, mozoDestino);
    }

    /**
     * Responde a una solicitud de transferencia de mesa.
     *
     * @param respuesta La respuesta a la solicitud (aceptar o rechazar).
     * @param mozoOrigen El mozo que transfiere la mesa.
     */
    public void responderTransferencia(int respuesta, Usuario mozoOrigen) {
        Facade.Instancia().responderTransferencia(respuesta, mozoOrigen);
    }

    /**
     * Transfiere una mesa a otro mozo.
     *
     * @param mesa La mesa a transferir.
     * @param mozoOrigen El mozo que transfiere la mesa.
     * @param mozoDestino El mozo que recibe la mesa.
     */
    public void transferir(Mesa mesa, Usuario mozoOrigen, Usuario mozoDestino) {
        Facade.Instancia().transferirMesa(mesa, mozoDestino);
    }

    /**
     * Devuelve una lista de los mozos que están actualmente logeados.
     *
     * @param mozo El usuario del mozo.
     * @return Lista de mozos logeados.
     */
    public List<Usuario> getMozosLogeados(Usuario mozo) {
        return Facade.Instancia().listaMozosLogeados(mozo);
    }

    /**
     * Busca un cliente por su ID.
     *
     * @param id El ID del cliente.
     * @return El cliente encontrado.
     */
    public ICliente buscarCliente(int id) {
        return Facade.Instancia().buscarCliente(id);
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
        vista.actualizarDatos();
    }

    /**
     * Verifica si un mozo tiene mesas abiertas.
     *
     * @param mozo El usuario del mozo.
     * @return true si el mozo tiene mesas abiertas, false en caso contrario.
     */
    public boolean mesasAbiertasMozo(Usuario mozo) {
        return Facade.Instancia().mesasAbiertasMozo(mozo);
    }

    /**
     * Busca un mozo por su nombre.
     *
     * @param m El nombre del mozo.
     * @return El mozo encontrado.
     */
    public Usuario buscarMozo(String m) {
        return Facade.Instancia().buscarUsuario(m);
    }
}

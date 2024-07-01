package org.orderFlow.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Clase que representa el tiempo de transferencia y gestiona su ejecución.
 */
@Component
public class TiempoTransferencia extends Observable implements Runnable {

    private Thread hilo;
    private boolean finalizado;
    private boolean correr;
    private int inicio = 15;
    private List<Observer> observadores;

    /**
     * Enum para los diferentes eventos que pueden ocurrir durante el tiempo de transferencia.
     */
    public enum Eventos {ESTADO, VALOR}

    /**
     * Constructor que inicializa el tiempo de transferencia con un observador.
     *
     * @param o El observador a agregar.
     */
    public TiempoTransferencia(Observer o) {
        observadores = new ArrayList<>();
        agregarObserver(o);
    }

    /**
     * Finaliza el tiempo de transferencia.
     */
    public void terminar() {
        finalizado = true;
        detener();
    }

    /**
     * Detiene el tiempo de transferencia.
     */
    public void detener() {
        if (correr) {
            correr = false;
            hilo.interrupt();
            notificar(Eventos.ESTADO);
        }
    }

    /**
     * Muestra el tiempo de transferencia y comienza su ejecución.
     */
    public void mostrar() {
        if (!correr && !finalizado) {
            hilo = new Thread(this);
            hilo.start();
        }
    }

    /**
     * Ejecuta el tiempo de transferencia.
     */
    @Override
    public void run() {
        for (; inicio > 0; inicio--) {
            notificar(Eventos.VALOR);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        correr = false;
        notificar(Eventos.ESTADO);
    }

    /**
     * Devuelve una representación en cadena del tiempo de transferencia.
     *
     * @return El valor actual del tiempo de transferencia como cadena.
     */
    @Override
    public String toString() {
        return Integer.toString(inicio);
    }

    /**
     * Agrega un observador al tiempo de transferencia.
     *
     * @param o El observador a agregar.
     */
    public void agregarObserver(Observer o) {
        observadores.add(o);
    }

    /**
     * Notifica a todos los observadores de un evento específico.
     *
     * @param evento El evento a notificar.
     */
    public void notificar(Object evento) {
        setChanged();
        for (Observer o : observadores) {
            o.update(this, evento);
        }
    }
}

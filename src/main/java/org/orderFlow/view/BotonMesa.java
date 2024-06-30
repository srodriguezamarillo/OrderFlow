package org.orderFlow.view;

import javafx.scene.control.Button;

/**
 * Botón personalizado para la selección de mesas.
 * Proporciona una interfaz gráfica para interactuar con las mesas.
 */
public class BotonMesa extends Button {

    private int numeroMesa;

    public BotonMesa(int numeroMesa) {
        super("Mesa " + numeroMesa);
        this.numeroMesa = numeroMesa;

        // Acción para seleccionar la mesa
        setOnAction(e -> seleccionarMesa());
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
        setText("Mesa " + numeroMesa);
    }

    private void seleccionarMesa() {
        // Lógica para seleccionar mesa
        System.out.println("Mesa " + numeroMesa + " seleccionada.");
    }
}

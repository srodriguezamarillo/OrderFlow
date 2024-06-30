package org.orderFlow.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ventana para la gestión de servicios.
 * Proporciona una interfaz gráfica para agregar y eliminar servicios.
 */
public class VentanaServicio extends Application {

    private TextField textFieldServicio;
    private Button buttonAgregar;
    private Button buttonEliminar;

    @Override
    public void start(Stage primaryStage) {
        // Configuración básica de la ventana
        primaryStage.setTitle("Gestión de Servicios");
        primaryStage.setWidth(400);
        primaryStage.setHeight(300);

        // Inicialización de componentes
        textFieldServicio = new TextField();
        buttonAgregar = new Button("Agregar Servicio");
        buttonEliminar = new Button("Eliminar Servicio");

        // Configuración del layout
        VBox panel = new VBox(10);
        panel.getChildren().addAll(
                new Label("Nombre del Servicio:"),
                textFieldServicio,
                buttonAgregar,
                buttonEliminar
        );

        // Añadir panel a la ventana
        Scene scene = new Scene(panel);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Acción para agregar servicio
        buttonAgregar.setOnAction(e -> agregarServicio());

        // Acción para eliminar servicio
        buttonEliminar.setOnAction(e -> eliminarServicio());
    }

    private void agregarServicio() {
        String servicio = textFieldServicio.getText();
        // Lógica para agregar servicio
        System.out.println("Servicio " + servicio + " agregado.");
    }

    private void eliminarServicio() {
        String servicio = textFieldServicio.getText();
        // Lógica para eliminar servicio
        System.out.println("Servicio " + servicio + " eliminado.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

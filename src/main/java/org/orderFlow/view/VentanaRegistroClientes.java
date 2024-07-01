package org.orderFlow.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ventana para el registro de clientes.
 * Proporciona una interfaz gráfica para registrar nuevos clientes.
 */
public class VentanaRegistroClientes extends Application {

    private TextField textFieldNombre;
    private TextField textFieldEmail;
    private ComboBox<String> comboBoxTipoCliente;
    private Button buttonRegistrar;

    @Override
    public void start(Stage primaryStage) {
        // Configuración básica de la ventana
        primaryStage.setTitle("Registro de Clientes");
        primaryStage.setWidth(400);
        primaryStage.setHeight(300);

        // Inicialización de componentes
        textFieldNombre = new TextField();
        textFieldEmail = new TextField();
        comboBoxTipoCliente = new ComboBox<>();
        comboBoxTipoCliente.getItems().addAll("COMUN", "PREFERENCIAL", "DELACASA");
        buttonRegistrar = new Button("Registrar Cliente");

        // Configuración del layout
        VBox panel = new VBox(10);
        panel.getChildren().addAll(
                new Label("Nombre del Cliente:"),
                textFieldNombre,
                new Label("Email del Cliente:"),
                textFieldEmail,
                new Label("Tipo de Cliente:"),
                comboBoxTipoCliente,
                buttonRegistrar
        );

        // Añadir panel a la ventana
        Scene scene = new Scene(panel);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Acción para registrar cliente
        buttonRegistrar.setOnAction(e -> registrarCliente());
    }

    private void registrarCliente() {
        String nombre = textFieldNombre.getText();
        String email = textFieldEmail.getText();
        String tipo = comboBoxTipoCliente.getValue();
        // Lógica para registrar cliente
        System.out.println("Cliente " + nombre + " (" + tipo + ") con email " + email + " registrado.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

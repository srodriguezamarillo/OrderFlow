package org.orderFlow.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Ventana para el login de usuarios.
 * Proporciona una interfaz gráfica para el inicio de sesión.
 */
public class VentanaLogin extends Application {

    private TextField textFieldUsuario;
    private PasswordField passwordField;

    @Override
    public void start(Stage primaryStage) {
        // Configuración básica de la ventana
        primaryStage.setTitle("Login de Usuarios");

        // Inicialización de componentes
        textFieldUsuario = new TextField();
        passwordField = new PasswordField();
        Button buttonLogin = new Button("Login");

        // Configuración del layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Añadir componentes al layout
        grid.add(new Label("Usuario:"), 0, 0);
        grid.add(textFieldUsuario, 1, 0);
        grid.add(new Label("Contraseña:"), 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(buttonLogin, 1, 2);

        // Acción para el login
        buttonLogin.setOnAction(e -> login());

        // Configuración de la escena
        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void login() {
        String usuario = textFieldUsuario.getText();
        String contraseña = passwordField.getText();
        // Lógica para login
        System.out.println("Usuario " + usuario + " intentó iniciar sesión.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

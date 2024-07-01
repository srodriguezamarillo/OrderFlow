package org.orderFlow.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorPrincipal extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/VentanaPrincipal.fxml"));
        primaryStage.setTitle("Gestión del Restaurante");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void abrirVentanaGestionMozos() throws Exception {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/vista/VentanaGestionMozos.fxml"));
        stage.setTitle("Gestión de Mozos");
        stage.setScene(new Scene(root));
        stage.show();
    }
}

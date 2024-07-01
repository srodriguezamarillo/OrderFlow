package org.orderFlow.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ventana para la procesadora de pedidos.
 * Proporciona una interfaz gráfica para procesar pedidos.
 */
public class VentanaProcesadoraPedidos extends Application {

    private TextArea textAreaPedidos;
    private Button buttonProcesar;

    @Override
    public void start(Stage primaryStage) {
        // Configuración básica de la ventana
        primaryStage.setTitle("Procesadora de Pedidos");
        primaryStage.setWidth(400);
        primaryStage.setHeight(300);

        // Inicialización de componentes
        textAreaPedidos = new TextArea();
        textAreaPedidos.setPrefRowCount(10);
        textAreaPedidos.setPrefColumnCount(30);
        buttonProcesar = new Button("Procesar Pedidos");

        // Configuración del layout
        VBox panel = new VBox(10);
        panel.getChildren().addAll(new ScrollPane(textAreaPedidos), buttonProcesar);

        // Añadir panel a la ventana
        Scene scene = new Scene(panel);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Acción para procesar pedidos
        buttonProcesar.setOnAction(e -> procesarPedidos());
    }

    private void procesarPedidos() {
        // Lógica para procesar pedidos
        String pedidos = textAreaPedidos.getText();
        System.out.println("Pedidos procesados:\n" + pedidos);
        textAreaPedidos.setText("");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

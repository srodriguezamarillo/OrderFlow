package org.orderFlow.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Ventana para la gestión de pedidos.
 * Proporciona una interfaz gráfica para agregar y eliminar pedidos.
 */
public class VentanaGestorPedidos extends Application {

    private TextField textFieldProducto;
    private TextField textFieldCantidad;
    private TextArea textAreaPedidos;

    @Override
    public void start(Stage primaryStage) {
        // Configuración básica de la ventana
        primaryStage.setTitle("Gestión de Pedidos");

        // Inicialización de componentes
        textFieldProducto = new TextField();
        textFieldCantidad = new TextField();
        Button buttonAgregar = new Button("Agregar Pedido");
        Button buttonEliminar = new Button("Eliminar Pedido");
        textAreaPedidos = new TextArea();
        textAreaPedidos.setEditable(false);

        // Configuración del layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Añadir componentes al layout
        grid.add(new Label("Producto:"), 0, 0);
        grid.add(textFieldProducto, 1, 0);
        grid.add(new Label("Cantidad:"), 0, 1);
        grid.add(textFieldCantidad, 1, 1);
        grid.add(buttonAgregar, 0, 2);
        grid.add(buttonEliminar, 1, 2);
        grid.add(new Label("Pedidos:"), 0, 3);
        grid.add(textAreaPedidos, 0, 4, 2, 1);

        // Acción para agregar pedido
        buttonAgregar.setOnAction(e -> agregarPedido());

        // Acción para eliminar pedido
        buttonEliminar.setOnAction(e -> eliminarPedido());

        // Configuración de la escena
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void agregarPedido() {
        String producto = textFieldProducto.getText();
        String cantidad = textFieldCantidad.getText();
        // Lógica para agregar pedido
        textAreaPedidos.appendText("Pedido de " + cantidad + " unidades de " + producto + " agregado.\n");
        textFieldProducto.clear();
        textFieldCantidad.clear();
    }

    private void eliminarPedido() {
        String producto = textFieldProducto.getText();
        // Lógica para eliminar pedido
        textAreaPedidos.appendText("Pedido de " + producto + " eliminado.\n");
        textFieldProducto.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

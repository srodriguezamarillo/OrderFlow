package org.orderFlow.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

@Controller
public class ControladorVentanaGestionMozos {

    @FXML
    private TextField textFieldNombre;

    @FXML
    private Button buttonAgregar;

    @FXML
    private Button buttonEliminar;

    @FXML
    private Button buttonListar;

    @FXML
    private TextArea textAreaMozos;

    @FXML
    private void initialize() {
        // Inicialización adicional si es necesario
    }

    @FXML
    private void agregarMozo(ActionEvent event) {
        String nombre = textFieldNombre.getText();
        // Lógica para agregar mozo
        textAreaMozos.appendText("Mozo " + nombre + " agregado.\n");
        textFieldNombre.clear();
    }

    @FXML
    private void eliminarMozo(ActionEvent event) {
        String nombre = textFieldNombre.getText();
        // Lógica para eliminar mozo
        textAreaMozos.appendText("Mozo " + nombre + " eliminado.\n");
        textFieldNombre.clear();
    }

    @FXML
    private void listarMozos(ActionEvent event) {
        // Lógica para listar mozos
        textAreaMozos.appendText("Listando mozos...\n");
        // Suponiendo que tienes una lista de mozos
        String[] mozos = {"Mozo1", "Mozo2", "Mozo3"};
        for (String mozo : mozos) {
            textAreaMozos.appendText(mozo + "\n");
        }
    }
}

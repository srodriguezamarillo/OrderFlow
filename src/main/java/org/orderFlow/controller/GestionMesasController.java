package org.orderFlow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GestionMesasController {

    @GetMapping("/gestionMesas")
    public String gestionMesas(Model model) {
        // Lógica para gestionar las mesas
        return "GestionMesas"; // Debe corresponder a GestionMesas.html en resources/templates
    }
}

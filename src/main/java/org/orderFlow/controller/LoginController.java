package org.orderFlow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Debe corresponder a login.html en resources/templates
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              Model model) {
        // Lógica de autenticación
        return "redirect:/gestionMesas";
    }
}

package com.barbearia.fiodanavalha.app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping("/dashboard")
    public String dashboardCliente() {
        return "Área exclusiva do Cliente";
    }
}
